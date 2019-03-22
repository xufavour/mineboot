package com.nightstory.mineboot.java.genericity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.TypeVariable;

/**
 * @Author: putao
 * @Date: 2019/3/6
 */
public class FruitDemo {


    public static void main(String[] args) throws Exception{
        Class<?> sellersTemp = Sellers.class;
        ParameterizedType actualType = null;
        TypeVariable<? extends Class<?>>[] typeParameters = sellersTemp.getTypeParameters();
        System.out.println(typeParameters[0].getBounds()[0]);
//        Field fieldBerry = sellersTemp.getField("BerryDateList");
//        Field fieldList = sellersTemp.getField("list");
//        System.out.println(fieldList.getGenericType());
//        Method methodAppleList = sellersTemp.getMethod("getAppleList", new Class[] { List.class });
//        actualType = (ParameterizedType) methodAppleList.getGenericParameterTypes()[0];
//        System.out.println( actualType.getActualTypeArguments()[0].toString());

    }
}
