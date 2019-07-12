package com.nightstory.mineboot.springserise.aop;

import com.nightstory.mineboot.common.HttpContextUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @Author: putao
 * @Date: 2019/4/1
 */
@Aspect
@Component
public class AspectTest {

    /**
     * 声明切点
     */
    @Pointcut("execution(* com.nightstory.mineboot.springserise.controller..*(..))")
    public void pointcut(){
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws NoSuchMethodException {
        HttpServletRequest httpServletRequest = HttpContextUtils.getHttpServletRequest();
        System.out.println(httpServletRequest.getRequestURL());
        Object result = null;
        testaop(point);
        try {
             result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }



    public void testaop(ProceedingJoinPoint pjp){
        System.out.println("start");
        Object obj = null;
        long start = System.currentTimeMillis();
        try {
            Object target = pjp.getTarget();
            MethodSignature msig = (MethodSignature) pjp.getSignature();
            Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
            RequestMapping annotation = currentMethod.getAnnotation(RequestMapping.class);
            System.out.println(currentMethod.getName());
            System.out.println(currentMethod.getDeclaredAnnotations()[0].toString());
            System.out.println(annotation.value()[0]);
            System.out.println(annotation.name());
        }catch (Exception e){
            e.printStackTrace();
        }
        long montiorTime = System.currentTimeMillis();
        System.out.println("time :" + (montiorTime - start));
    }
}
