/**
 * Date:     2018/5/1923:41
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.repository;

import com.zhou.mongo.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2018/5/19  23:41
 * created by zhoumb
 */
public interface ReviewMBRepository extends MongoRepository<Review,String>{

}
