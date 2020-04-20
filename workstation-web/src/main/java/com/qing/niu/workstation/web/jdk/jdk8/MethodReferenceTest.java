package com.qing.niu.workstation.web.jdk.jdk8;

import java.util.Arrays;
import java.util.List;

/**
 * <p>
 *     方法引用实际上Lambda表达式的一个语法糖
 *     可以将方法引用看作是一个【函数指针】，指向方法
 *
 *     方法引用分为四类：
 *     1、类名::静态方法名
 *     2、对象名::实例方法
 *     3、类名::实例方法
 *     4、类名::new（构造方法引用）
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/18 14:49
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MethodReferenceTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a","b","c");
        list.forEach(System.out::println);

        Student1 student1 = new Student1("zhangsan",10);
        Student1 student2 = new Student1("lisi",20);
        Student1 student3 = new Student1("wangwu",50);
        Student1 student4 = new Student1("zhaoliu",40);
        //类名::静态方法名
        List<Student1> list1 = Arrays.asList(student1,student2,student3,student4);
        list1.sort(Student1::compareStudentByScore);
        list1.forEach(param -> System.out.println(param.getScore()));

        List<Student1> list2 = Arrays.asList(student1,student2,student3,student4);
        list2.sort(Student1::compareStudentByName);
        list2.forEach(param -> System.out.println(param.getName()));
        //对象名::实例方法
        List<Student1> list3 = Arrays.asList(student1,student2,student3,student4);
        StudentComparator studentComparator = new StudentComparator();
        list3.sort(studentComparator::compareStudentByScore);
        list3.forEach(param -> System.out.println(param.getScore()));
        //类名::实例方法(两个参数，第一个参数作为调用compareBySocre方法的对象，第二个对象作为方法参数)
        List<Student1> list4 = Arrays.asList(student1,student2,student3,student4);
        list4.sort(Student1::compareBySocre);
        list4.forEach(param -> System.out.println(param.getScore()));

    }
}

class Student1{

    private String name;

    private int score;

    public Student1(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int compareStudentByScore(Student1 student1, Student1 student2){
        return student1.getScore() - student2.getScore();
    }

    public static int compareStudentByName(Student1 student1, Student1 student2){
        return student1.getName().compareToIgnoreCase(student2.getName());
    }

    public int compareBySocre(Student1 student1){
        return this.getScore() - student1.getScore();
    }

    public int compareByName(Student1 student1){
        return this.getName().compareToIgnoreCase(student1.getName());
    }
}

class StudentComparator{
    public int compareStudentByScore(Student1 student1, Student1 student2){
        return student1.getScore() - student2.getScore();
    }

    public int compareStudentByName(Student1 student1, Student1 student2){
        return student1.getName().compareToIgnoreCase(student2.getName());
    }
}