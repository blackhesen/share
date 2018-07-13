package com.hesen.share.web;

import com.hesen.share.common.res.JsonObjectResponse;
import com.hesen.share.common.utils.StringUtil;
import org.junit.Test;
import org.springframework.http.HttpMethod;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author: Hesen
 * @CreateDate: 2018/5/10 16:03
 */
public class TestHello {
    public static void main(String[] args) {
        String orderStatus = "";
        String projectCategory = null;
        String projectName = null;
        List<String> paramList = Arrays.asList(orderStatus, projectCategory, projectName);
        List<String> filterList = paramList.stream().filter(e -> StringUtil.isNotEmpty(e)).collect(Collectors.toList());
        System.out.println(filterList.toString());
    }

    @Test
    public void getDateBefore() {
        Date dNow = new Date();
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dNow);//把当前时间赋给日历
        calendar.add(Calendar.MONTH, -3);  //设置为前3月
        Date dBefore = calendar.getTime();   //得到前3月的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
        String defaultStartDate = sdf.format(dBefore);    //格式化前3月的时间
        String defaultEndDate = sdf.format(dNow); //格式化当前时间
        System.out.println("三个月之前时间=======" + defaultStartDate);
        System.out.println("当前时间===========" + defaultEndDate);
    }

    @Test
    public void strToList() {
        String[] strs = {"1,2"};
        String str = strs[0];
        String[] split = str.split(",");
        System.out.println(split.toString());
        List<String> strings = Arrays.asList(split);
        System.out.println(strings.toString());
    }

    @Test
    public void rest() {
        String url = "http://dev-wapi-operate.dx-groups.com/api/web/banner/position/list";
        InformationPosTo informationPosTo = new InformationPosTo();
        informationPosTo.setBelongIndustry("");
        String currentPage = "1";
        Map<String, Object> map = new HashMap<>();
        map.put("informationPos", informationPosTo);
        map.put("currentPage", currentPage);
        JsonObjectResponse request = RestService.request(map, url, HttpMethod.POST, JsonObjectResponse.class);

        return;
    }
}
