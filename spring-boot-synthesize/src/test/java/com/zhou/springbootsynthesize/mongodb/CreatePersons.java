/**
 * Date:     2018/5/1311:25
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.mongodb;

import com.zhou.springbootsynthesize.mongodb.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 2018/5/13  11:25
 * created by zhoumb
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CreatePersons {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void createPersons() {
        List<Person> personList = new ArrayList<>(10);
        personList.add(new Person("tom1", 12, "tom.@gmail.com", "usa", new String[]{"java", "javaScript", "math", "english"},new Date()));
        personList.get(0).setId(UUID.randomUUID().toString().substring(0,11).replace("-",""));
        personList.add(new Person("jack1", 23, "jack.@gmail.com", "usa", new String[]{"java", "javaScript", "math", "english"},new Date()));
        personList.add(new Person("alice1", 32, "alice.@gmail.com", "usa", new String[]{"java", "javaScript", "math", "english"},new Date()));
        personList.add(new Person("rose1", 45, "rose.@gmail.com", "usa", new String[]{"java", "javaScript", "math", "english"},new Date()));
        personList.add(new Person("james1", 12, "james.@gmail.com", "usa", new String[]{"java", "javaScript", "math", "english"},new Date()));
        personList.add(new Person("zhangsan1", 21, "zhangsan.@qq.com", "china", new String[]{"china", "javaScript", "jquery", "java"},new Date()));
        personList.add(new Person("lisi1", 134, "lisi.@163.com", "china", new String[]{"java", "spring boot", "dubbo", "hadoop"},new Date()));
        personList.add(new Person("wangwu1", 121, "twangwu.@qq.com", "china", new String[]{"spring", "mybatis", "redis", "mongodb"},new Date()));
        personList.add(new Person("mazi1", 17, "mazi.@qq.com", "china", new String[]{"java", "css", "html", "netty"},new Date()));
        personList.add(new Person("bazi1", 32, "bazi.@163.com", "china", new String[]{"java", "javaScript", "thread", "mysql"},new Date()));


        mongoTemplate.insert(personList,Person.class);
    }
}
