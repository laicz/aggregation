/**
 * Date:     2018/5/2010:29
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.web;

import com.alibaba.fastjson.JSONArray;
import com.zhou.mongo.chapter_05.service.ReviewService;
import com.zhou.mongo.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2018/5/20  10:29
 * created by zhoumb
 */
@RestController
@RequestMapping(value = "/index/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @RequestMapping(value = "/getPreviewByProductId")
    public List<Review> getReviewByProductId(@RequestParam("productId")String productId){
        return reviewService.findReviewByProductId(productId);
    }

    /**
     * 获取所有的商品机评论数
     * @return
     */
    @RequestMapping(value = "/findAllProductReviewCount")
    public JSONArray findAllProductReviewCount(){
        return reviewService.findAllProductReviewCount();
    }
}
