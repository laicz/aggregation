/**
 * Date:     2018/5/923:11
 * AUTHOR:   Administrator
 */
package com.zhou.springbootjpa.controller;

import com.zhou.springbootjpa.model.Person;
import com.zhou.springbootjpa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2018/5/9  23:11
 * created by zhoumb
 */
@RestController
public class DataController {

    @Autowired
    private PersonRepository personRepository ;

    @RequestMapping(value="/sava")
    public Person save(String name, String address , Integer age){
        return personRepository.save(new Person(name,age,address));
    }

    @RequestMapping(value = "/getAll")
    public List<Person> getAll(){
        return personRepository.findAll();
    }

    @RequestMapping("/findWithPage")
    public Page<Person> findPersonWithPage(Integer page, Integer size){
        return personRepository.findAll(new PageRequest(page,size));
    }

}
