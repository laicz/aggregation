/**
 * Date:     2018/5/1122:50
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.mongodb;

import com.mongodb.DBCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * 2018/5/11  22:50
 * created by zhoumb
 */
@Component
public class MongoDBHolder {

    @Autowired
    private MongoTemplate mongoTemplate ;

    public DBCollection getCollection(String collectionName){
        return mongoTemplate.getCollection(collectionName);
    }

    
}
