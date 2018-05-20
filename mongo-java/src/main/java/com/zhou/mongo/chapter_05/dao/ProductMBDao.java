/**
 * Date:     2018/5/1921:50
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

/**
 * 2018/5/19  21:50
 * created by zhoumb
 */
@Repository
public class ProductMBDao {
    @Autowired
    private MongoTemplate mongoTemplate;

}
