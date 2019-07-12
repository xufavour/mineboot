package com.nightstory.mineboot.springserise.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {
//
//    @Pointcut("execution(* com.nightstory.mineboot.springserise.controller..*(..))")
//    public void pointcut(){
//    }
//    //前置
//    @Before("pointcut()")//execution(public * *(..))所有方法增强
//    public void beforeAspect(){
//
//        System.out.println("前置增强");
//    }
//
//    //后置
//    @AfterReturning("pointcut()")
//    public void AfterReturningAspect(Object retVal){
//
//        System.out.println("后置增强");
//    }
//
//    //环绕
//    @Around("pointcut()")
//    public void AroundAspect(ProceedingJoinPoint po){
//
//        System.out.println("环绕前增强");
//        try {
//            po.proceed();
//        } catch (Throwable e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        System.out.println("环绕后增强");
//    }
//
//    //异常
//    @AfterThrowing("pointcut()")
//    public void AfterThrowingAspect(){
//
//        System.out.println("异常增强");
//    }
//
//    //最终
//    @After("pointcut()")
//    public void AfterAspect(){
//
//        System.out.println("最终增强");
//    }
}