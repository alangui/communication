package jvm;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2019/3/31 23:22
 * @ProjectName communication
 * @Version 1.0.0
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("专业").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);
        System.out.println(str1.intern() == "计算机专业");
    }
}
