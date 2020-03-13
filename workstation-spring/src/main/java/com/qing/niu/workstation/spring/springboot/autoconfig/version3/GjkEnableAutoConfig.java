package com.qing.niu.workstation.spring.springboot.autoconfig.version3;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 14:09
 * @ProjectName communication
 * @Version 1.0.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(GjkImportSelector.class)
public @interface GjkEnableAutoConfig {
}
