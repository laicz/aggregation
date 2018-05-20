/**
 * Date:     2018/5/1923:41
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.repository;

import com.zhou.mongo.model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * 2018/5/19  23:41
 * created by zhoumb
 */
public interface ReviewMBRepository extends MongoRepository<Review,String>{

    @Query("{'product_id':?0}")
    List<Review> findReviewByProductId(String productId);
}
