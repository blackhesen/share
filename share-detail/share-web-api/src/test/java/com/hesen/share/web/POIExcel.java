package com.hesen.share.web;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Hesen
 * @CreateDate: 2018/5/10 13:39
 */
public class POIExcel {

    // 总行数
    private int totalRows = 0;
    // 总列数
    private int totalCells = 0;

    public Map<String, List<List<String>>> read(String fileName) {
        Map<String, List<List<String>>> maps = new HashMap<String, List<List<String>>>();
        if (fileName == null || !fileName.matches("^.+\\.(?i)((xls)|(xlsx))$")) {
            return maps;
        }
        File file = new File(fileName);
        if (file == null || !file.exists()) {
            return maps;
        }
        try {
            Workbook wb = WorkbookFactory.create(new FileInputStream(file));
            maps = read(wb);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return maps;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public int getTotalCells() {
        return totalCells;
    }

    private Map<String, List<List<String>>> read(Workbook wb) {
        Map<String, List<List<String>>> maps = new HashMap<String, List<List<String>>>();
        int number = wb.getNumberOfSheets();
        if (number > 0) {
            // 循环每个工作表
            for (int i = 0; i < number; i++) {
                List<List<String>> list = new ArrayList<List<String>>();
                Sheet sheet = wb.getSheetAt(i);
                // 获取工作表中所有行数(包括空行)
                this.totalRows = sheet.getPhysicalNumberOfRows();
                if (this.totalRows >= 1 && sheet.getRow(0) != null) {
                    // 遍历所有行(去除标题行)
                    for (int j = 1; j < this.totalRows; j++) {
                        // 得到当前行的所有单元格
                        this.totalCells = sheet.getRow(j).getPhysicalNumberOfCells();
                        List<String> rowLst = new ArrayList<String>();
                        // 遍历所有单元格
                        if (totalCells > 0) {
                            for (int f = 1; f < totalCells; f++) {
                                String value = getCell(sheet.getRow(j).getCell(f));
                                rowLst.add(value);
                            }
                        }
                        // 判断当前行数据是否为空，空数据过滤掉
                        List<String> emptyList = rowLst.stream().filter(e -> StringUtils.isNotEmpty(e))
                                .collect(Collectors.toList());
                        if (null != emptyList && emptyList.size() > 0) {
                            list.add(rowLst);
                        }
                    }
                }
                maps.put(sheet.getSheetName(), list);
            }
        }
        return maps;
    }

    public String getCell(Cell cell) {
        String cellValue = null;
        HSSFDataFormatter hSSFDataFormatter = new HSSFDataFormatter();
        // 使用EXCEL原来格式的方式取得值
        cellValue = hSSFDataFormatter.formatCellValue(cell);
        return cellValue;
    }

    public static void main(String[] args) {
        try {
            Map<String, List<List<String>>> map = new POIExcel()
                    .read("C:\\Users\\issuser\\Desktop\\货物导入模板.xlsx");
            System.out.println(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
