package com.qing.niu.workstation.spring.springboot.autoconfig;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 12:50
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Company implements Serializable{
    private static final long serialVersionUID = 7526930280900025852L;

    private Employee employee;

    private Product product;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Company{" +
                "employee=" + employee +
                ", product=" + product +
                '}';
    }
}
