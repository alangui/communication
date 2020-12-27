package com.qing.niu.workstation.design.pattern.builder;

/**
 * <p>
 *     通过外部构造类构造对象
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/24
 * @ProjectName communication
 * @Version 1.0.0
 */
public interface ProductBuilder {

    void builderProductName(String productName);

    void builderCompanyName(String companyName);

    void builderPart1(String part1);

    void builderPart2(String part2);

    void builderPart3(String part3);

    void builderPart4(String part4);

    Product build();
}
