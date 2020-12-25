package com.qing.niu.workstation.design.pattern.prototype;

import java.io.*;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/25
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Product1 implements Cloneable, Serializable {
    private static final long serialVersionUID = -2355938217648684847L;

    private String part1;

    private String part2;

    private BaseInfo1 baseInfo;

    public Product1(String part1, String part2, BaseInfo1 baseInfo) {
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

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public BaseInfo1 getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(BaseInfo1 baseInfo) {
        this.baseInfo = baseInfo;
    }

    @Override
    protected Product1 clone() throws CloneNotSupportedException {
        // 序列化方式实现的深拷贝
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();

        try (ObjectOutputStream oos=new ObjectOutputStream( byteArrayOutputStream )) {
            oos.writeObject( this );
        } catch (IOException e) {
            e.printStackTrace();
        }
        ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream( byteArrayOutputStream.toByteArray() );

        try (ObjectInputStream ois=new ObjectInputStream( byteArrayInputStream )) {
            return ((Product1) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String toString() {
        return "Product1{" +
                "part1='" + part1 + '\'' +
                ", part2='" + part2 + '\'' +
                ", baseInfo=" + baseInfo +
                '}';
    }
}
