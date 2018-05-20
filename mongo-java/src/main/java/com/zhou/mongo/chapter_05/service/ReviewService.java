/**
 * Date:     2018/5/1923:39
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service;

import com.zhou.mongo.model.Review;

import java.util.List;

/**
 * 2018/5/19  23:39
 * created by zhoumb
 */
public interface ReviewService {
    List<Review> saveAll(List<Review> reviews);

    List<Review> findReviewByProductId(String productId);
}
