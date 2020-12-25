package com.qing.niu.workstation.design.pattern.flyweight;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/25
 * @ProjectName communication
 * @Version 1.0.0
 */
public class Tree {

    private String name;

    private String data;

    public Tree(String name, String data) {
        System.out.println("name " + name + ", data " + data + " was created");
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}
