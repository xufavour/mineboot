package com.nightstory.mineboot.java.annotation;

import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Annotation;

/**
 * @Author: putao
 * @Date: 2018/12/27
 */
@RestController
public class AnnotationMain {
    public static void main(String[] args) throws Exception {
        Class<?> cl = Class.forName("com.nightstory.mineboot.java.annotation.Student");
        System.out.println(cl.isAnnotationPresent(CacheHandle.class));
        System.out.println(cl.isAnnotationPresent(RestController.class));
        for(Annotation an : cl.getAnnotations()){
            System.out.println(an.annotationType() + an.toString());
        }

        System.out.println(cl.getAnnotations().length);

    }

    /**
     * 注解(Annotation):可以创建一个注解,独立的java文件和被编译成字节码问题.不是类。
     *
     * 元注解:用于自己创建的注解中。
     * Target:指定创建的注解使用的地方。
     *@Retention(RetentionPolicy.RUNTIME)运行时作用
     *
     */
}
