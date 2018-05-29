/**
 * Date:     2018/5/2921:45
 * AUTHOR:   Administrator
 */
package com.zhou.basejava8.chapter01.filter;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 2018/5/29  21:45
 * created by zhoumb
 */
public class Person {
    private String name;
    private String sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public static List<Person> filterPerson(List<Person> personList,PersonFilter personFilter) {
        List<Person> personList1 = new ArrayList<>();
        if (CollectionUtils.isEmpty(personList)) {
            return null;
        }
        for (Person person :
                personList) {
            if(personFilter == null || personFilter.accept(person)){
                personList1.add(person);
            }
        }
        return  personList1;
    }

    public boolean isM(){
        return StringUtils.pathEquals("m",this.sex);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
