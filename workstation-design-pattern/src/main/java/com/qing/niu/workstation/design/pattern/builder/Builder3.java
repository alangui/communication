package com.qing.niu.workstation.design.pattern.builder;

/**
 * <p>
 *     使用lombok注解
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/25
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Builder3 {

    public static void main(String[] args) {
        Product1 product1 = Product1.builder()
                .productName("1")
                .companyName("2")
                .part1("1")
                .part2("2")
                .part3("3")
                .part4("4")
                .build();
        System.out.println(product1);

        Product1 product = new Product1();
        System.out.println(product);
    }
}
