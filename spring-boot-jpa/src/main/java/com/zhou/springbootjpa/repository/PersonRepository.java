/**
 * Date:     2018/5/923:05
 * AUTHOR:   Administrator
 */
package com.zhou.springbootjpa.repository;

import com.zhou.springbootjpa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 2018/5/9  23:05
 * created by zhoumb
 */
public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> findByAddress(String address);

    Person findByNameAndAddress(String name,String address);

    @Query("select  p from  Person  p  where  p.name= :name and p.address = :address")
    Person withNameAndAddressQuery(@Param("name")String name , @Param("address") String address);

//    Person withNameAndAddressNameQuery(String name ,String address);
}
