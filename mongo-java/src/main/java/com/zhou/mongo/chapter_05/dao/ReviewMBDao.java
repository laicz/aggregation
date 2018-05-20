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
        System.out.println(String.format("共获取到%d组评论",jsonArray.size()));
        return jsonArray;
    }

    /**
     * 获取某一个商品的评价数量
     * @param productId
     * @return
     */
    public Document getReviewCountByProductId(String productId) {
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.match(Criteria.where("product_id").is(productId)),Aggregation.group("product_id").count().as("评价数量"));
        AggregationResults<Document> review = mongoTemplate.aggregate(aggregation, "review", Document.class);
        if (review == null){
            return  null;
        }
        return  review.iterator().next();
    }
}
