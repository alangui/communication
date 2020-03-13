package com.qing.niu.workstation.spring.springboot.autoconfig;

import java.io.Serializable;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/3/9 12:51
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Product implements Serializable{
    private static final long serialVersionUID = -7919980993692645487L;

    private String productName;

    private String productType;

    private String productSubType;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductSubType() {
        return productSubType;
    }

    public void setProductSubType(String productSubType) {
        this.productSubType = productSubType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", productSubType='" + productSubType + '\'' +
                '}';
    }
}
