package com.qing.niu.workstation.spring.aop.classic;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/24 0:06
 * @ProjectName communication
 * @Version 1.0.0
 */
public class TraceLogHandler implements MethodBeforeAdvice,AfterReturningAdvice{

    @Override
    public void before(Method method, Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("调用前:" + System.currentTimeMillis());
    }

    @Override
    public void afterReturning(@Nullable Object returnValue, Method method, Object[] args, @Nullable Object target) throws Throwable {
        System.out.println("调用后:" + System.currentTimeMillis());
    }
}
