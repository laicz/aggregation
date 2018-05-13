/**
 * Date:     2018/5/1322:57
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.mongodb;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

/**
 * 2018/5/13  22:57
 * created by zhoumb
 */
public class MongoTest1 {
    static  Mongo mongo ;
    static DB db;
    static {
        mongo = new Mongo("127.0.0.1:27017");
        db = mongo.getDB("synthesize");
    }
    public static void main(String[] args) {
        DBCollection person = db.getCollection("person");

    }
}
