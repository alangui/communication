package com.qing.niu.workstation.spring.basic.importuse;

import com.qing.niu.workstation.spring.Lifecircle.Person;
import com.qing.niu.workstation.spring.model.Car;
import org.springframework.context.annotation.Import;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
@Import(value = {Car.class, Person.class, TlImportSelector.class, TlBeanDefinitionRegister.class})
public class ImportConfig {
}
