package com.lititi.exams.web.util;

import java.lang.reflect.Field;
import java.sql.Timestamp;

/**
 * @author weiqineng * @version 1.0
 * @date 2024/2/26 9:43
 */
public class ObjectConverterUtil {
    public static <T, U> U convert(T source, Class<U> targetClass) throws Exception {
        U target = targetClass.getDeclaredConstructor().newInstance();
        Field[] sourceFields = source.getClass().getDeclaredFields();
        for (Field field : sourceFields) {
            try {
                Field targetField = targetClass.getDeclaredField(field.getName());
                if (targetField != null) {
                    field.setAccessible(true);
                    targetField.setAccessible(true);

                    //进行类型检查和转换
                    Object value = field.get(source);
                    if (value != null && !targetField.getType().isAssignableFrom(value.getClass())){
                        //类型不匹配，进行转换
                        value = convertValue(value, targetField.getType());
                    }
                        targetField.set(target, field.get(source));
                }
            }catch (NoSuchFieldException e){
                continue;
            }
        }
        return target;
    }

    public static Object convertValue(Object value,Class<?> targetType){
        //进行类型转换
        if (targetType == Timestamp.class && value instanceof String){
            String dateString = (String) value;
            try {
                return Timestamp.valueOf(dateString);
            }catch (IllegalArgumentException e){
                //解析日期失败，返回原始值
             return value;
            }
        } else if (targetType == Integer.class || targetType == int.class) {
            if (value instanceof String){
                try {
                    return Integer.parseInt((String) value);
                }catch (NumberFormatException e){
                    //转换失败
                    return value;
                }
            }
        } else if (targetType == Boolean.class || targetType == boolean.class) {
            if (value instanceof String){
                String strValue = ((String) value).toLowerCase();
                if ("true".equals(strValue)){
                    return true;
                }else if ("false".equals(strValue)){
                    return false;
                }{
                    return value;
                }
            }
        }
        return value;
    }
}
