package com.qing.niu.workstation.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/23 9:58
 * @ProjectName communication
 * @Version 1.0.0
 */
@Aspect
@Component
public class LogAspect {

    @Pointcut(value = "@annotation(com.qing.niu.workstation.spring.aop.annotation.Action)")
    public void logPointCut(){}

    @Before("logPointCut())")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("before获取到注解action注解方法：" + method.getName());
        if ("traceLogId".equals(action.name())) {
            System.out.println("向线程注入tracecLogId" + UUID.randomUUID().toString());
        }
    }

    @After("logPointCut())")
    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("after获取到注解action注解方法：" + method.getName());
        if ("traceLogId".equals(action.name())) {
            System.out.println("清除线程traceLogId");
        }
    }

    @SuppressWarnings("Duplicates")
    @Around("execution(* com.qing.niu.workstation.spring.aop.annotation.AnnotationActionDemo.realTimePay(..))")
    public Object around(ProceedingJoinPoint joinPoint){
        System.out.println("进入支付流程。。。");
        Boolean result = false;
        try {
            result = (Boolean) joinPoint.proceed();
            System.out.println("结果result:" + result);
            System.out.println("通知上游系统");
        } catch (Throwable throwable) {
            System.out.println(joinPoint.getSignature().getName() + "调用失败");
        } finally {
            System.out.println("流程结束");
        }
        return result;
    }
}
