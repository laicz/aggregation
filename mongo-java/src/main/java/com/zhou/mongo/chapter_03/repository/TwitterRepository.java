/**
 * Date:     2018/5/178:01
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_03.repository;

import com.zhou.mongo.chapter_03.model.Twitter;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2018/5/17  8:01
 * created by zhoumb
 */
public interface TwitterRepository extends MongoRepository<Twitter,String> {

}
