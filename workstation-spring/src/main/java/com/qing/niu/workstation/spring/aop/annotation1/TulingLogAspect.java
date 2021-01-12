package com.qing.niu.workstation.spring.aop.annotation1;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

/**
 * <p>
 * </p>
 *
 * @Author Alan_gui
 * @Date 2021/1/12
 * @ProjectName IntelliJ IDEA
 * @Package com.qing.niu.workstation.spring.aop.annotation1
 * @Version 1.0.0
 */
@Aspect
public class TulingLogAspect {

    @Pointcut("execution (* com.qing.niu.workstation.spring.aop.annotation1.TulingCalculate.*(..))")
    public void pointCut(){}

    @Before(value = "pointCut()")
    public void methodBefore(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【" + methodName + "】<前置通知>, 入参" + Arrays.asList(joinPoint.getArgs()));
    }

    @After(value = "pointCut()")
    public void methodAfter(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【" + methodName + "】<后置通知, 入参>" + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterReturning(value = "pointCut()")
    public void methodReturning(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【" + methodName + "】<返回通知>, 入参" + Arrays.asList(joinPoint.getArgs()));
    }

    @AfterThrowing(value = "pointCut()")
    public void methodAfterThrowing(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("执行目标方法【" + methodName + "】<异常通知>, 入参" + Arrays.asList(joinPoint.getArgs()));
    }
}
