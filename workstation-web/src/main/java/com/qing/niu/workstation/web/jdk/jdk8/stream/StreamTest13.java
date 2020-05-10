package com.qing.niu.workstation.web.jdk.jdk8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/29 23:29
 * @ProjectName communication
 * @Version 1.0.0
 */
public class StreamTest13 {

    public static void main(String[] args) {
        Student student1 = new Student("zhangsan",100,20);
        Student student2 = new Student("lisi",90,20);
        Student student3 = new Student("wangwu",90,30);
        Student student4 = new Student("zhangsan",80,40);

        List<Student> students = Arrays.asList(student1,student2,student3,student4);
        Map<String,List<Student>> map = students.stream().collect(Collectors.groupingBy(Student::getName));
        System.out.println(map);

        Map<Integer,List<Student>> map1 = students.stream().collect(Collectors.groupingBy(Student::getScore));
        System.out.println(map1);

        Map<String,Long> map2 = students.stream().collect(Collectors.groupingBy(Student::getName,Collectors.counting()));
        System.out.println(map2);

        Map<String,Double> map3 = students.stream().collect(Collectors.groupingBy(Student::getName,Collectors.averagingDouble(Student::getScore)));
        System.out.println(map3);

        Map<Boolean,List<Student>> map4 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 90));
        System.out.println(map4);

        Map<Boolean,Long> map5 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 90,Collectors.counting()));
        System.out.println(map5);

        Map<Boolean,Double> map6 = students.stream().collect(Collectors.partitioningBy(student -> student.getScore() > 90,Collectors.averagingInt(Student::getScore)));
        System.out.println(map6);
    }
}
