package com.nightstory.mineboot.java.annotation;

import java.lang.annotation.*;

/**
 * @Author: putao
 * @Date: 2018/12/27
 */
@Target({ElementType.TYPE,ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CacheHandle {
    String value() default "";
}
