/**
 * Date:     2018/5/2722:55
 * AUTHOR:   Administrator
 */
package com.zhou.basejava8.chapter01.sort;

/**
 * 2018/5/27  22:55
 * created by zhoumb
 */
public class Apple {
    private Integer weight;

    public Integer getWeight() {
        return weight;
    }

    public Apple(Integer weight) {
        this.weight = weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                '}';
    }
}
