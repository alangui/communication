package com.qing.niu.workstation.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;
import java.util.UUID;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/23 19:20
 * @ProjectName communication
 * @Version 1.0.0
 */
public class LogAspect {

    public void logPointCut(){}

    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("before获取到方法：" + method.getName());
        System.out.println("向线程注入tracecLogId" + UUID.randomUUID().toString());
    }

    public void after(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("after获取到方法：" + method.getName());
        System.out.println("清除线程traceLogId");
    }

    @SuppressWarnings("Duplicates")
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
