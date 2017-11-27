package cn.eovie.ncufcbackend.util;

import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by earayu on 2017/11/27.
 */
public class BaseConveter {

    /**
     * list转换
     *
     * @param sourceList 源数据
     * @param clazz      目标对象类型
     * @param <T>
     * @return
     */
    public static <T> List<T> convertList(List sourceList, Class<T> clazz) {
        List<T> targetList = Lists.newArrayList();
        if (null != sourceList && null != clazz) {
            for (Object sourceObject : sourceList) {
                targetList.add((T) convertObject(sourceObject, clazz));
            }
            return targetList;
        }
        return targetList;
    }

    /**
     * object转换
     *
     * @param sourceObject 源数据
     * @param clazz        目标对象类型
     * @param <T>
     * @return
     */
    public static <T> T convertObject(Object sourceObject, Class<T> clazz) {
        if (null == sourceObject) {
            return null;
        }
        try {
            Object targetObject = clazz.newInstance();
            // ignoreProperties是为了适应 "3.1.2.RELEASE
            // 版本的spring包中的BeanUtils属性拷贝是字段类型不匹配会报错"
            String[] ignoreProperties = BaseConveter.getIgnoreProperties(sourceObject, targetObject);
            BeanUtils.copyProperties(sourceObject, targetObject, ignoreProperties);
            return (T) targetObject;
        } catch (Exception e) {
            throw new RuntimeException("通用DTO转换失败!" + e.getMessage());
        }
    }

    /**
     * 获取源对象和目标对象中 "字段名称一致但字段类型不一致" 的所有字段
     *
     * @param source 源数据
     * @param target 目标对象
     * @return
     */
    private static String[] getIgnoreProperties(Object source, Object target) {
        if (source == null || target == null) {
            return null;
        }

        Field[] sourceFields = source.getClass().getDeclaredFields();
        Field[] targetFields = target.getClass().getDeclaredFields();

        List<String> ignoreFieldList = Lists.newArrayList();
        for (Field sourceField : sourceFields) {
            for (Field targetFiled : targetFields) {
                if (sourceField.getName().equals(targetFiled.getName()) && !sourceField.getType().getName().equals(targetFiled.getType().getName())) {
                    ignoreFieldList.add(sourceField.getName());
                    break;
                }
            }
        }
        String[] ignoreProperties = new String[ignoreFieldList.size()];
        for (int i = 0; i < ignoreFieldList.size(); i++) {
            ignoreProperties[i] = ignoreFieldList.get(i);
        }
        return ignoreProperties;
    }
}