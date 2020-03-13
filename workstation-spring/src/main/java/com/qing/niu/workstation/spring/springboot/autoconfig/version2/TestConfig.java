package com.qing.niu.workstation.spring.springboot.autoconfig.version2;

import com.qing.niu.workstation.spring.springboot.autoconfig.Company;
import com.qing.niu.workstation.spring.springboot.autoconfig.Employee;
import com.qing.niu.workstation.spring.springboot.autoconfig.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 13:07
 * @ProjectName communication
 * @Version 1.0.0
 */
@Configuration
public class TestConfig {

    @Bean
    public Company company(){
        Company company = new Company();
        company.setEmployee(employee());
        company.setProduct(product());
        return company;
    }

    @Bean
    public Product product(){
        Product product = new Product();
        product.setProductName("子弹");
        product.setProductType("国防工业");
        product.setProductSubType("轻武器");
        return product;
    }

    @Bean
    public Employee employee(){
        Employee employee = new Employee();
        employee.setName("李四");
        employee.setAge("19");
        employee.setSex("男");
        return employee;
    }
}
