package com.qing.niu.workstation.design.pattern.builder;

import lombok.Builder;
import lombok.ToString;
import lombok.experimental.Tolerate;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/25
 * @ProjectName communication
 * @Version 1.0.0
 */
@ToString
@Builder
public class Product1 {

    private String productName;

    private String companyName;

    private String part1;

    private String part2;

    private String part3;

    private String part4;

    @Tolerate
    public Product1(){}
}

