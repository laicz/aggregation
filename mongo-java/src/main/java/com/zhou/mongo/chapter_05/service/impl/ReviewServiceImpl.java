/**
 * Date:     2018/5/1923:40
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service.impl;

import com.sun.org.apache.regexp.internal.RE;
import com.zhou.mongo.chapter_05.repository.ReviewMBRepository;
import com.zhou.mongo.chapter_05.service.ReviewService;
import com.zhou.mongo.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2018/5/19  23:40
 * created by zhoumb
 */
@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    private ReviewMBRepository reviewMBRepository;

    @Override
    public List<Review> saveAll(List<Review> reviews) {
        return reviewMBRepository.saveAll(reviews);
    }

    @Override
    public List<Review> findReviewByProductId(String productId){
        return  reviewMBRepository.findReviewByProductId(productId);
    }
}
