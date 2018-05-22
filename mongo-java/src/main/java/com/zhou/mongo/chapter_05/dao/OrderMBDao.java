/**
 * Date:     2018/5/2123:17
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.dao;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.zhou.mongo.model.Order;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Iterator;

/**
 * 2018/5/21  23:17
 * created by zhoumb
 */
@Repository
public class OrderMBDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 根据订单的年月日来分组统计订单
     * @param starTime
     * @param endTime
     * @return
     */
    public JSONArray getOrderGroupByMonth(Date starTime, Date endTime){
        Aggregation aggregation = Aggregation.newAggregation(Aggregation.project().andExpression("year(create_time)").as("year")
        .andExpression("month(create_time)").as("month")/*.andExpression("dayOfMonth(create_time)").as("day")*/,
                Aggregation.group("year","month"/*,"day"*/).count().as("count"),
                Aggregation.sort(Sort.by(Sort.Direction.DESC,"year","month"/*,"day"*/)));
        AggregationResults<Document> aggregate = mongoTemplate.aggregate(aggregation, Order.class, Document.class);
        if (aggregate == null){
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        Iterator<Document> iterator = aggregate.iterator();
        while(iterator.hasNext()){
            jsonArray.add(JSON.parseObject(JSON.toJSONString(iterator.next())));
        }
        return  jsonArray;
    }
}
