package com.nightstory.mineboot.main;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @Author: putao
 * @Date: 2019/2/18
 */
public class TempTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException {
        String str = "hello world !!!";
        str.intern();
        Class<String> stringClass = String.class;
        Annotation[] annotations = stringClass.getAnnotations();

        Field field = stringClass.getDeclaredField("value");
        field.setAccessible(true);
        System.out.println(field.getName());
        char[] chars = (char[]) field.get(str);
        chars[1] = 1;
        System.out.println(str);
    }
}

