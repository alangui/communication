package com.qing.niu.workstation.web.jdk.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/14 22:38
 * @ProjectName communication
 * @Version 1.0.0
 */
public class PersonTest {

    public static void main(String[] args) {
        Person person1 = new Person("zhangsan",20);
        Person person2 = new Person("lisi",30);
        Person person3 = new Person("wangwu",40);

        List<Person> persons = Arrays.asList(person1,person2,person3);

        PersonTest personTest = new PersonTest();
        List<Person> list = personTest.getPersonsByUsername("zhangsan",persons);
        list.forEach(person -> System.out.println(person.getUaername()));

        List<Person> personList = personTest.getPersonByAge(20,persons);
        personList.forEach(person -> System.out.println(person.getAge()));

        List<Person> personList1 = personTest.getPersonByAge2(20,persons,(age,listPerson) ->
                listPerson.stream().filter(person -> person.getAge() <= 20).collect(Collectors.toList()));
        personList1.forEach(person -> System.out.println(person.getAge()));
    }

    public List<Person> getPersonsByUsername(String username, List<Person> persons){
        return persons.stream().filter(person -> person.getUaername().equals(username)).collect(Collectors.toList());
    }

    public List<Person> getPersonByAge(int age, List<Person> persons){
        BiFunction<Integer, List<Person>, List<Person>> biFunction = (age1,personsList) -> personsList.stream().
                filter(person -> person.getAge() > age).collect(Collectors.toList());
        return biFunction.apply(age,persons);
    }

    public List<Person> getPersonByAge2(int age, List<Person> persons, BiFunction<Integer, List<Person>, List<Person>> biFunction){
        return biFunction.apply(age,persons);
    }
}
