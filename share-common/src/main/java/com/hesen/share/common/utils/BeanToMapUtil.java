package com.hesen.share.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * @Author Hesen
 * @Date   2018/4/19 16:01
 *
 * 该方法不支持对象内嵌套对象转换MAP
 */
public class BeanToMapUtil {

    private static Logger logger = LoggerFactory.getLogger(BeanToMapUtil.class);

    /**
     * 将一个 Map 对象转化为一个 JavaBean
     *
     * @param type 要转化的类型
     * @param map  包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     * @throws IntrospectionException           如果分析类属性失败
     * @throws IllegalAccessException                      如果实例化 JavaBean 失败
     * @throws InstantiationException                      如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Object convertMap(Class type, Map map)
            throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        // 获取类属性
        BeanInfo beanInfo = Introspector.getBeanInfo(type);
        // 创建 JavaBean 对象
        Object obj = type.newInstance();

        // 给 JavaBean 对象的属性赋值
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            String propertyType = descriptor.getPropertyType()
                    .getName();
            if (!map.containsKey(propertyName)) {
                propertyName = captureName(propertyName);
            }

            if (map.containsKey(propertyName)) {
                // 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
                Object value = map.get(propertyName);

                Object[] args = new Object[1];
                try {
                    if ("java.lang.String".equals(propertyType)
                            && value == null) {
                        value = "";
                    } else if ("java.lang.String".equals(propertyType)) {
                        value = value.toString();
                    } else if ("java.util.Date".equals(propertyType)) {
                        value = (Date) value;
                    } else if ("java.lang.Integer".equals(propertyType)) {
                        value = new Integer((String) value);
                    } else if ("float".equals(propertyType)) {
                        value = Float.parseFloat((String) value);
                    } else if ("java.math.BigDecimal".equals(propertyType)) {
                        value = (BigDecimal) value;
                    } else if ("java.lang.Long".equals(propertyType)) {
                        value = Long.valueOf(value.toString());
                    }
                } catch (Exception e) {
                    logger.error(e.getMessage(),e);
                } finally {
                    args[0] = value;
                    descriptor.getWriteMethod().invoke(obj, args);
                }

            }
        }
        return obj;
    }


    /**
     * 将List<Map>转为List<Object>
     *
     * @param type
     * @param mapList
     * @return
     * @throws IntrospectionException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws InvocationTargetException
     */
    public static List convertMapList(Class type, List<LinkedHashMap> mapList)
            throws IntrospectionException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        List<Object> list = new ArrayList<Object>();

        for (LinkedHashMap bean : mapList) {
            list.add(convertMap(type, bean));
        }

        return list;
    }

    /**
     * 将一个 JavaBean 对象转化为一个  Map
     *
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的  Map 对象
     * @throws IntrospectionException           如果分析类属性失败
     * @throws IllegalAccessException                      如果实例化 JavaBean 失败
     * @throws InvocationTargetException 如果调用属性的 setter 方法失败
     */
    public static Map convertBean(Object bean)
            throws IntrospectionException, IllegalAccessException, InvocationTargetException {
        Class type = bean.getClass();
        Map returnMap = new HashMap();
        BeanInfo beanInfo = Introspector.getBeanInfo(type);

        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor descriptor = propertyDescriptors[i];
            String propertyName = descriptor.getName();
            if (!"class".equals(propertyName)) {
                Method readMethod = descriptor.getReadMethod();
                Object result = readMethod.invoke(bean, new Object[0]);
                if (result != null) {
                    returnMap.put(propertyName, result);
                } else {
                    returnMap.put(propertyName, null);
                }
            }
        }
        return returnMap;
    }


    /**
     * 首字母转换为小写
     * @param str
     * @return
     */
    public static String captureName(String str) {
        if (isNotEmpty(str)) {
            str = str.substring(0, 1).toLowerCase() + str.substring(1);
        }
        return str;

    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }



    /**
     * 类转换类方法
     *
     * @param obj
     * @param cla
     * @param <T>
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static <T> T convertClass(Object obj, Class<T> cla) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Map<String, Object> maps = new HashMap<String, Object>();
        T dataBean = null;
        if (null == obj) {
            return null;
        }
        Class<?> cls = obj.getClass();
        dataBean = cla.newInstance();
        Field[] fields = cls.getDeclaredFields();
        Field[] beanFields = cla.getDeclaredFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            String strGet = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1, fieldName.length());
            Method methodGet = cls.getDeclaredMethod(strGet);
            Object object = methodGet.invoke(obj);
            maps.put(fieldName, object == null ? "" : object);
        }

        for (Field field : beanFields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            Class<?> fieldType = field.getType();
            String fieldValue = maps.get(fieldName) == null ? null : maps.get(fieldName).toString();
            if (fieldValue != null) {
                try {
                    if (String.class.equals(fieldType)) {
                        field.set(dataBean, fieldValue);
                    } else if (StringUtils.isNotEmpty(fieldValue)) {
                        if (byte.class.equals(fieldType)) {
                            field.setByte(dataBean, Byte.parseByte(fieldValue));

                        } else if (Byte.class.equals(fieldType)) {
                            field.set(dataBean, Byte.valueOf(fieldValue));

                        } else if (boolean.class.equals(fieldType)) {
                            field.setBoolean(dataBean, Boolean.parseBoolean(fieldValue));

                        } else if (Boolean.class.equals(fieldType)) {
                            field.set(dataBean, Boolean.valueOf(fieldValue));

                        } else if (short.class.equals(fieldType)) {
                            field.setShort(dataBean, Short.parseShort(fieldValue));

                        } else if (Short.class.equals(fieldType)) {
                            field.set(dataBean, Short.valueOf(fieldValue));

                        } else if (int.class.equals(fieldType)) {
                            field.setInt(dataBean, Integer.parseInt(fieldValue));

                        } else if (Integer.class.equals(fieldType)) {
                            field.set(dataBean, Integer.valueOf(fieldValue));

                        } else if (long.class.equals(fieldType)) {
                            field.setLong(dataBean, Long.parseLong(fieldValue));

                        } else if (Long.class.equals(fieldType)) {
                            field.set(dataBean, Long.valueOf(fieldValue));

                        } else if (float.class.equals(fieldType)) {
                            field.setFloat(dataBean, Float.parseFloat(fieldValue));

                        } else if (Float.class.equals(fieldType)) {
                            field.set(dataBean, Float.valueOf(fieldValue));

                        } else if (double.class.equals(fieldType)) {
                            field.setDouble(dataBean, Double.parseDouble(fieldValue));

                        } else if (Double.class.equals(fieldType)) {
                            field.set(dataBean, Double.valueOf(fieldValue));

                        } else if (Date.class.equals(fieldType)) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
                            field.set(dataBean, sdf.parse(fieldValue));
                        }
                    }

                } catch (IllegalArgumentException e) {
                    logger.error(e.getMessage(),e);
                } catch (ParseException e) {
                    logger.error(e.getMessage(),e);
                }

            }
        }
        return dataBean;

    }


}
