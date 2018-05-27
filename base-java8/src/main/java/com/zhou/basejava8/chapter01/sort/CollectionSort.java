/**
 * Date:     2018/5/2722:52
 * AUTHOR:   Administrator
 */
package com.zhou.basejava8.chapter01.sort;

import java.util.*;

import static java.util.Comparator.comparing;

/**
 * 使用java8来进行排序
 * 2018/5/27  22:52
 * created by zhoumb
 */
public class CollectionSort {

    public static void main(String[] args) {
        sortInbefore();
        System.out.println("-------------------------------");
        sortInJava8();
    }

    /**
     * java8之前的排序
     */
    public static void sortInbefore() {
        List<Apple> apples = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            apples.add(new Apple(random.nextInt(50)));
        }
        Collections.sort(apples, new Comparator<Apple>() {
            @Override
            public int compare(Apple a1, Apple a2) {
                return a1.getWeight().compareTo(a2.getWeight());
            }
        });

        apples.stream().forEach(apple -> {
            System.out.println(apple);
        });
    }

    /**
     * java8中的排序方法
     */
    public static void sortInJava8(){
        List<Apple> apples = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            apples.add(new Apple(random.nextInt(50)));
        }
        apples.sort(comparing(Apple::getWeight));
        apples.stream().forEach(apple -> {
            System.out.println(apple);
        });
    }
}
