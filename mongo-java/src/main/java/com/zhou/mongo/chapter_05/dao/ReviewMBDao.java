/**
 * Date:     2018/5/2015:19
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.Iterator;

/**
 * 2018/5/20  15:19
 * created by zhoumb
 */
@Repository
public class ReviewMBDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public JSONArray findAllProductReviewCount() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.group("product_id").count().as("count"));
        AggregationResults<Document> results = mongoTemplate.aggregate(aggregation, "review", Document.class);
        JSONArray jsonArray = new JSONArray();
        if (results != null) {
            Iterator<Document> iterator = results.iterator();
            while (iterator.hasNext()) {
                Document document = iterator.next();
                JSONObject jsonObject = JSON.parseObject(JSON.toJSONString(document));
                jsonArray.add(jsonObject);
            }
        }
        System.out.println(String.format("共获取到%d组评论", jsonArray.size()));
        return jsonArray;
    }

    /**
     * 获取某一个商品的评价数量
     *
     * @param productId
     * @return
     */
    public Document getReviewCountByProductId(String productId) {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("product_id").is(productId)), Aggregation.group("product_id").count().as("评价数量"));
        AggregationResults<Document> review = mongoTemplate.aggregate(aggregation, "review", Document.class);
        if (review == null) {
            return null;
        }
        return review.iterator().next();
    }

    /**
     * 获取商品的评价平均分
     *
     * @param productId
     * @return
     */
    public Document getAverageReviewRate(String productId) {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("product_id").is(productId)),
                Aggregation.group("product_id").count().as("评价总数:").avg("rating").as("评价平均分："));
        AggregationResults<Document> review = mongoTemplate.aggregate(aggregation, "review", Document.class);
        if (review == null) {
            return null;
        }
        return review.iterator().next();
    }

    /**
     * 获取详细的产品评分细则
     *
     * @param productId
     * @return
     */
    public JSONArray getDetailReviewByProductId(String productId) {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("product_id").is(productId)), Aggregation.group("rating").count().as("heji"));
        AggregationResults<Document> review = mongoTemplate.aggregate(aggregation, "review", Document.class);
        if (review == null) {
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        Iterator<Document> iterator = review.iterator();
        while (iterator.hasNext()) {
            jsonArray.add(iterator.next());
        }
        return jsonArray;
    }

    /**
     * 获取用户的详细评价信息
     *
     * @return
     */
    public JSONArray getDetailReviewByUserId() {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.project("user_id","helpful_votes"),Aggregation.group("user_id").count().as("用户评价数量").avg("helpful_votes").as("平均帮助人数"));
        AggregationResults<Document> documents = mongoTemplate.aggregate(aggregation, "review", Document.class);
        if (documents == null) {
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        Iterator<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            jsonArray.add(JSON.parseObject(JSON.toJSONString(iterator.next())));
        }
        return jsonArray;
    }
}
