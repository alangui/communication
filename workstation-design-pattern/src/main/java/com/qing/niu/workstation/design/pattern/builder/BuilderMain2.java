package com.qing.niu.workstation.design.pattern.builder;

/**
 * <p>
 *     通过内部构造类生成对象
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/24
 * @ProjectName communication
 * @Version 1.0.0
 */
public class BuilderMain2 {

    public static void main(String[] args) {
        Product product = new Product.Builder()
                .productName("product name")
                .companyName("company name")
                .part1("part1")
                .part2("part2")
                .part3("part3")
                .part4("part4")
                .build();
        System.out.println(product);
    }
}
