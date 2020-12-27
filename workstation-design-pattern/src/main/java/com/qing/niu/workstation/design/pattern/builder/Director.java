package com.qing.niu.workstation.design.pattern.builder;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/24
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Director {

    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product makeProduct(String productName, String companyName, String part1, String part2, String part3, String part4) {
        this.builder.builderProductName(productName);
        this.builder.builderCompanyName(companyName);
        this.builder.builderPart1(part1);
        this.builder.builderPart2(part2);
        this.builder.builderPart3(part3);
        this.builder.builderPart4(part4);
        return this.builder.build();
    }
}
