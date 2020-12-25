package com.qing.niu.workstation.design.pattern.prototype;

import java.util.Date;

/**
 * <p>
 *     浅拷贝：被复制对象的所有值属性都含有与原来对象的相同，而所有的对象引用属性仍然指向原来的对象。
 *
 *     深拷贝：在浅拷贝的基础上，所有引用其他对象的变量也进行了clone，并指向被复制过的新对象。
 *
 *     也就是说，一个默认的clone()方法实现机制，仍然是赋值。
 *
 *     如果一个被复制的属性都是基本类型，那么只需要实现当前类的cloneable机制就可以了，此为浅拷贝。
 *
 *     如果被复制对象的属性包含其他实体类对象引用，那么这些实体类对象都需要实现cloneable接口并覆盖clone()方法。
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/25
 * @ProjectName communication
 * @Version 1.0.0
 */
public class ProtoTypeDemo {

    public static void main(String[] args) throws CloneNotSupportedException {
        /** 浅拷贝 **/
        BaseInfo baseInfo = new BaseInfo("111", "222", new Date());

        Product product = new Product("part1", "part2", baseInfo);
        Product productClone = product.clone();
        System.out.println(product);
        System.out.println(productClone);
        System.out.println(product == productClone);

        //修改基本类型属性或其包装类属性
        product.setPart1("part11111");
        System.out.println(product);
        System.out.println(productClone); //clone对象值未变
        System.out.println(product == productClone); //不同对象

        //修改引用类型属性
        product.getBaseInfo().setCompanyName("11111111");
        System.out.println(product);
        System.out.println(productClone); //clone对象baseInfo.companyName值变了, 和原型对象指向同一个引用
        System.out.println(product == productClone); //不同对象
        System.out.println(product.getBaseInfo() == productClone.getBaseInfo()); //同一个对象

        /** 深拷贝 **/
        System.out.println("----------------------------------------------------------------");
        BaseInfo1 baseInfo1 = new BaseInfo1("111", "222", new Date());
        Product1 product1 = new Product1("part1", "part2", baseInfo1);
        Product1 product11 = product1.clone();
        product1.getBaseInfo().setCompanyName("1111111"); //修改引用属性
        System.out.println(product1);
        System.out.println(product11);
        System.out.println(product1 == product11);
        System.out.println(product1.getBaseInfo() == product11.getBaseInfo());
    }
}
