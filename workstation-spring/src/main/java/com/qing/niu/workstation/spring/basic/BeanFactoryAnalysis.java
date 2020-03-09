package com.qing.niu.workstation.spring.basic;

import com.qing.niu.workstation.spring.model.WithholdReqDTO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/1/18 14:43
 * @ProjectName communication
 * @Version 1.0.0
 */
public class BeanFactoryAnalysis {

    public static void main(String[] args) {
        BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("beans.xml"));
        WithholdReqDTO withholdReqDTO = (WithholdReqDTO) beanFactory.getBean("withholdReqDTO");
        System.out.println(withholdReqDTO.getTradeNo());
    }
}
