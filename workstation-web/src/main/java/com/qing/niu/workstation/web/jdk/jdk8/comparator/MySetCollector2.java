package com.qing.niu.workstation.web.jdk.jdk8.comparator;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/5/25 20:17
 * @ProjectName communication
 * @Version 1.0.0
 */
public class MySetCollector2<T> implements Collector<T,Set<T>,Map<T,T>>{

    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return HashSet<T>::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked!");
        return(set,item) -> {
            System.out.println("accumulator: " + set + Thread.currentThread().getName());
            set.add(item);
        };
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked!");
        return (set1,set2) -> {
            set1.addAll(set2);
            return set1;};
    }

    @Override
    public Function<Set<T>, Map<T, T>> finisher() {
        System.out.println("finisher invoked!");
        return set -> {
            Map<T,T> map = new HashMap<>();
            set.stream().forEach(item -> map.put(item,item));
            return map;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked");
        return Collections.unmodifiableSet(EnumSet.of(Characteristics.UNORDERED,Characteristics.CONCURRENT));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","world","welcome","hello","a","b","c","d","e","f","g");
        Set<String> set = new HashSet<>();
        set.addAll(list);
        Map<String,String> map = set.parallelStream().collect(new MySetCollector2<>());
        System.out.println(map);
    }
}
