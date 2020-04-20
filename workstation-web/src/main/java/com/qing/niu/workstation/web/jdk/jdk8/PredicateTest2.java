package com.qing.niu.workstation.web.jdk.jdk8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/4/15 21:53
 * @ProjectName communication
 * @Version 1.0.0
 */
public class PredicateTest2 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        PredicateTest2 predicateTest2 = new PredicateTest2();
        predicateTest2.conditionFilter(list,item -> item % 2 == 0);
        System.out.println("---------------");
        predicateTest2.conditionFilter(list,item -> item % 2 !=0);
        System.out.println("---------------");
        predicateTest2.conditionFilter(list,item -> false);

        predicateTest2.conditionFiltere2(list,item -> item > 5,item -> item % 2 == 0);
    }

    public void conditionFilter(List<Integer> list, Predicate<Integer> predicate){
        for (Integer integer : list){
            if (predicate.test(integer)){
                System.out.println(integer);
            }
        }
    }

    public void conditionFiltere2(List<Integer> list, Predicate<Integer> predicate1, Predicate<Integer> predicate2){
        for (Integer integer : list){
            if (predicate1.and(predicate2).test(integer)){
                System.out.println(integer);
            }
        }
    }
}
