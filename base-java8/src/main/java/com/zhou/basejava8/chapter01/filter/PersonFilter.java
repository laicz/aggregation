/**
 * Date:     2018/5/2921:46
 * AUTHOR:   Administrator
 */
package com.zhou.basejava8.chapter01.filter;

/**
 * 人员过滤器
 * 2018/5/29  21:46
 * created by zhoumb
 */
public interface PersonFilter {

    boolean accept(Person person);
}
