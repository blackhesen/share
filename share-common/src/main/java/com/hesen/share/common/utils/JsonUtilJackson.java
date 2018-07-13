package com.hesen.share.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pc-hh on 2017/3/24.
 */
public class JsonUtilJackson {

    private static Logger log = LoggerFactory.getLogger(JsonUtilJackson.class);

    /**
     * OBJ转JSON
     *
     * @param obj
     * @return
     */
    public static String objectToJson(Object obj) {
        String json = "";
        try {
            //转换器
            ObjectMapper mapper = new ObjectMapper();
            mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            //将对象转换成json
            json = mapper.writeValueAsString(obj);
            log.debug(json);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return json;
    }


    /**
     * JSON转OBJ
     *
     * @param jsonStr
     * @param cl
     * @return
     */
    public static Object jsonToBean(String jsonStr, Class<?> cl) {
        Object obj = null;
        try {
            //转换器
            ObjectMapper mapper = new ObjectMapper();
            //json转object
            obj = mapper.readValue(jsonStr, cl);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return obj;
    }


    /**
     * 将json格式转换成map对象
     *
     * @param jsonStr
     * @return
     */
    public static Map<?, ?> jsonToMap(String jsonStr) {
        Map<?, ?> objMap = null;
        try {
            if (jsonStr != null) {
                //转换器
                ObjectMapper mapper = new ObjectMapper();
                //json转换成map
                objMap = mapper.readValue(jsonStr, Map.class);
            }
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }
        return objMap;
    }


    /**
     * 将json格式转换成map型的list对象
     *
     * @param jsonStr
     * @return
     * @Au
     */
    public static List<LinkedHashMap> jsonToMapList(String jsonStr) {
        List<LinkedHashMap> list = null;
        try {
            //转换器
            ObjectMapper objectMapper = new ObjectMapper();
            list = objectMapper.readValue(jsonStr, List.class);

        } catch (JsonParseException e) {
            log.error(e.getMessage(), e);
        } catch (JsonMappingException e) {
            log.error(e.getMessage(), e);
        } catch (IOException e) {
            log.error(e.getMessage(), e);
        }

        return list;
    }


    /**
     * 将json格式转换成list对象
     *
     * @param jsonStr
     * @param classOfT
     * @return
     * @Au
     */
    public static <T> ArrayList<T> jsonToBeanList(String jsonStr, Class<T> classOfT) throws Exception {

        ArrayList<T> listOfT = new ArrayList<>();
        if (jsonStr != null) {
            //转换器
            ObjectMapper objectMapper = new ObjectMapper();
            List<LinkedHashMap> mapList = jsonToMapList(jsonStr);
            for (int i = 0; i < mapList.size(); i++) {
                Map<String, Object> map = mapList.get(i);
                T obj = (T) BeanToMapUtil.convertMap(classOfT, map);
                listOfT.add(obj);
            }
        }
        return listOfT;
    }


    /**
     * 解决字符型空串转数字问题
     *
     * @param jsonString
     * @param classOfT
     * @param <T>
     * @return
     * @throws Exception
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> classOfT) throws Exception {
        //转换器
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, classOfT);
        List<T> lst = (List<T>) objectMapper.readValue(jsonString, javaType);
        return lst;
    }

}
