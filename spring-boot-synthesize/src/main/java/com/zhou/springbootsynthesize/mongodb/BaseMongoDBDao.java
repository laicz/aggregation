/**
 * Date:     2018/5/1122:58
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.mongodb;

import com.mongodb.WriteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 * 2018/5/11  22:58
 * created by zhoumb
 */
@Repository
public class BaseMongoDBDao<T> {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(T t){
        mongoTemplate.save(t);
    }

    public void remove(T t){
        mongoTemplate.remove(t);
    }

    public WriteResult removeWith(T t){
        Criteria criteria = new Criteria();
        criteria.where("_id").is("72deb9a824bd4e0");
        Query query = new Query(criteria);
        WriteResult remove = mongoTemplate.remove(query, t.getClass());
        return remove;
    }


}
