package com.lrm.util;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.beans.PropertyDescriptor;
import java.util.ArrayList;
import java.util.List;

public class CustomerBeanUtils {
    public static String[] getNullPropertyNames(Object source) {
        //提供用於分析和操作標準JavaBean 的操作
        BeanWrapper beanWrapper = new BeanWrapperImpl(source);
        //先取出bean裡面所有的資料
        PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();
        //建一個儲存空屬性的List
        List<String> nullPropertyNames = new ArrayList<>();
        //將bean裡面屬性的資料名稱一一取出並且作是不是null的判斷，若是則加到list裡面
        for (PropertyDescriptor pd : pds) {
            String propertyName = pd.getName();
            if (beanWrapper.getPropertyValue(propertyName) == null) {
                nullPropertyNames.add(propertyName);
            }
        }
        return nullPropertyNames.toArray(new String[nullPropertyNames.size()]);
    }
}
