package com.qing.niu.workstation.spring.aop.annotation;

import java.lang.annotation.*;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/7/23 9:51
 * @ProjectName communication
 * @Version 1.0.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Action {

    String name();
}
