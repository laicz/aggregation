/**
 * Date:     2018/5/1923:40
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.sun.org.apache.regexp.internal.RE;
import com.zhou.mongo.chapter_05.dao.ReviewMBDao;
import com.zhou.mongo.chapter_05.repository.ReviewMBRepository;
import com.zhou.mongo.chapter_05.service.ReviewService;
import com.zhou.mongo.model.Review;
import org.bson.Document;
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

    @Autowired
    private ReviewMBDao reviewMBDao;

    @Override
    public List<Review> saveAll(List<Review> reviews) {
        return reviewMBRepository.saveAll(reviews);
    }

    @Override
    public List<Review> findReviewByProductId(String productId){
        return  reviewMBRepository.findReviewByProductId(productId);
    }

    @Override
    public JSONArray findAllProductReviewCount(){
        return reviewMBDao.findAllProductReviewCount();
    }

    @Override
    public Document getReviewCountByProductId(String productId) {
        return reviewMBDao.getReviewCountByProductId(productId);
    }

    @Override
    public Document getAverageReviewRate(String productId) {
        return reviewMBDao.getAverageReviewRate(productId);
    }

    @Override
    public JSONArray getDetailReviewByProductId(String productId) {
        return reviewMBDao.getDetailReviewByProductId(productId);
    }

    @Override
    public JSONArray getDetailReviewByUserId() {
        return reviewMBDao.getDetailReviewByUserId();
    }
}
