package com.turingschool.demo.blockingqueue.array;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<Integer> listA = new ArrayList();
        List<Integer> listB = new ArrayList();
//        listA.add(0,3);
//        listA.add(1,2);
//        listA.add(2,1);
//        listA.add(2,4);
//
//        System.out.println(listA);
//        listA.add(1);
//        listA.add(3);
//        listA.add(5);
//        listA.add(7);
//        listB.add(2);
//        listB.add(4);
//        listB.add(6);
//        listA.addAll(listB);
//        System.out.println(listA);

        int n1 = 0;
        int n2 = 0;
        int[] array = new int[]{1,2,3,4,5,6,7};
        for (int i = 0; i < array.length; i++ ){
            if (array[i] % 2 != 0){
                listA.add(n1,array[i]);
                n1++;
            } else {
                listB.add(n2,array[i]);
                n2++;
            }
        }
        listA.addAll(listB);
        System.out.println(listA);
    }
}
