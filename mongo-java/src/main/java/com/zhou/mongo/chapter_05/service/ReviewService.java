/**
 * Date:     2018/5/1923:39
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service;

import com.alibaba.fastjson.JSONArray;
import com.zhou.mongo.model.Review;
import org.bson.Document;

import java.util.List;

/**
 * 2018/5/19  23:39
 * created by zhoumb
 */
public interface ReviewService {
    List<Review> saveAll(List<Review> reviews);

    List<Review> findReviewByProductId(String productId);

    JSONArray findAllProductReviewCount();

    Document getReviewCountByProductId(String productId);

    Document getAverageReviewRate(String productId);

    JSONArray getDetailReviewByProductId(String productId);
}
