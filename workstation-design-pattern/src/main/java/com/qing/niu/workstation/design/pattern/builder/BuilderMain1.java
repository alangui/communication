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
public class BuilderMain1 {

    public static void main(String[] args) {
        Director director = new Director(new DefaultProductBuilder());
        Product product = director.makeProduct("1","2","1","2","3","4");
        System.out.println(product);
    }
}
