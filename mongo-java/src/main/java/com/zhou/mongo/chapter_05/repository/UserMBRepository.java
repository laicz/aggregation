/**
 * Date:     2018/5/1923:27
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.repository;

import com.zhou.mongo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2018/5/19  23:27
 * created by zhoumb
 */
public interface UserMBRepository extends MongoRepository<User,String>{
}
