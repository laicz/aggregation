/**
 * Date:     2018/6/48:02
 * AUTHOR:   Administrator
 */
package com.zhou.basejava8.chapter01.filter;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 苹果过滤
 * 2018/6/4  8:02
 * created by zhoumb
 */
public class FilteringApples {
    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        List<Apple> greenApples = filterApples(inventory,FilteringApples::isGreenApples);
        greenApples.stream().forEach(apple -> {
            System.out.println(apple);
        });

        //获取重量超过限设定值的
        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApples);
        heavyApples.stream().forEach(apple -> {
            System.out.println(apple);
        });

        //在代码中灵活设置条件
        List<Apple> green = filterApples(inventory, (Apple a) -> StringUtils.equals("green", a.getColor()));
        green.stream().forEach(apple -> {
            System.out.println(apple);
        });

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples2 = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples2);

        // [Apple{color='green', weight=155}]
        List<Apple> heavyApples2 = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        System.out.println(heavyApples2);

        // []
        List<Apple> weirdApples = filterApples(inventory, (Apple a) -> a.getWeight() < 80 ||
                "brown".equals(a.getColor()));
        System.out.println(weirdApples);

    }

    public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> predicate){
        List<Apple> result = new ArrayList<>();
        inventory.stream().forEach(apple -> {
            if (predicate.test(apple)){
                result.add(apple);
            }
        });
        return result;
    }

    public static boolean isGreenApples(Apple apple){
        return StringUtils.equals("green",apple.getColor());
    }

    public static boolean isHeavyApples(Apple apple){
        return apple.getWeight() > 150;
    }

    public static  class  Apple{
        private int weight = 0;
        private String color;

        public Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "weight=" + weight +
                    ", color='" + color + '\'' +
                    '}';
        }
    }
}
