package com.nightstory.mineboot;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author: putao
 * @Date: 2019/1/29
 */
@RestController
@RequestMapping("/demo/test/v1")
public class MyApplication implements ApplicationContextAware {

    private static ApplicationContext context = null;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
    @RequestMapping("mvc")
    public Object testBeanType(){
        String[] beanNames = BeanFactoryUtils.beanNamesForTypeIncludingAncestors(MyApplication.context,Object.class);
        Map<Class<?>,RequestMapping> cachedMappings = new HashMap<>();
        for(String beanName : beanNames){
            RequestMapping mapping = context.findAnnotationOnBean(beanName, RequestMapping.class);
            if(mapping == null){
                continue;
            }
            Class<?> handlerType = context.getType(beanName);
            cachedMappings.put(handlerType, mapping);
            Set<String> urls = new LinkedHashSet<String>();
            String[] typeLevelPatterns = mapping.value();
            for(String str : typeLevelPatterns){
                System.out.println(str);
            }
            ReflectionUtils.doWithMethods(MyApplication.class, new ReflectionUtils.MethodCallback() {
                @Override
                public void doWith(Method method) throws IllegalArgumentException, IllegalAccessException {
                    System.out.println(method.getName());
                }
            });
        }
        return cachedMappings;
    }

    private Object getBean(String beanName){
        Class<?> handlerType = context.getType(beanName);
        return handlerType;
    }
}