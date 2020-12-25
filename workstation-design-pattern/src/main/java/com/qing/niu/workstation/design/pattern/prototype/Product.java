package com.qing.niu.workstation.design.pattern.prototype;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/25
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Product implements Cloneable{

    private String part1;

    private String part2;

    private BaseInfo baseInfo;

    public Product(String part1, String part2, BaseInfo baseInfo) {
        this.part1 = part1;
        this.part2 = part2;
        this.baseInfo = baseInfo;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    @Override
    protected Product clone() throws CloneNotSupportedException {
        return (Product) super.clone();
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public BaseInfo getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    public String toString() {
        return "Product{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }
}
