/**
 * Date:     2018/5/2921:50
 * AUTHOR:   Administrator
 */
package com.zhou.basejava8.chapter01.filter;


import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 2018/5/29  21:50
 * created by zhoumb
 */
public class FilterTest {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("1","f"));
        personList.add(new Person("2","m"));
        personList.add(new Person("3","m"));
        personList.add(new Person("5","m"));
        personList.add(new Person("6","n"));
        personList.add(new Person("7","m"));
        personList.add(new Person("4","m"));
        personList.add(new Person("8","d"));

        List<Person> personList1 = Person.filterPerson(personList, new PersonFilter() {
            @Override
            public boolean accept(Person person) {
                return !StringUtils.pathEquals(person.getSex(),"m");
            }
        });
        for (Person person :
                personList1) {
            System.out.println(person);
        }
        System.out.println("-------------------");
        List<Person> personList2 = Person.filterPerson(personList, Person::isM);
        personList2.stream().forEach(person -> {
            System.out.println(person);
        });
    }
}
