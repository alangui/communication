package com.qing.niu.workstation.design.pattern.flyweight;

/**
 * <p>
 *     运用共享技术有效地支持大量细粒度的对象
 *     String, Integer, Long
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/25
 * @ProjectName communication
 * @Version 1.0.0
 */
public class FlyWeightMain {

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1, 2, TreeFactory.getTree("A", "a"));
        TreeNode treeNode2 = new TreeNode(3, 4, TreeFactory.getTree("B", "b"));
        TreeNode treeNode3 = new TreeNode(5, 6, TreeFactory.getTree("A", "a"));
        TreeNode treeNode4 = new TreeNode(7, 8, TreeFactory.getTree("B", "b"));
        System.out.println(treeNode1);
        System.out.println(treeNode2);
        System.out.println(treeNode3);
        System.out.println(treeNode4);
    }
}
