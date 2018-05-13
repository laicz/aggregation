/**
 * Date:     2018/5/1322:48
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.mongodb;

import com.mongodb.*;

import java.util.List;
import java.util.Set;

/**
 * 直接使用mongo
 * 2018/5/13  22:48
 * created by zhoumb
 */
public class MongoTest {
    public static void main(String[] args) {
        Mongo mongo = new Mongo("127.0.0.1:27017");
        //查询出所有的名称
        List<String> databaseNames = mongo.getDatabaseNames();
        for (String databaseName:
             databaseNames) {
            System.out.println(databaseName);
        }
        //选择自己需要使用的mongodb
        DB db = mongo.getDB("synthesize");
        //查询出所有的结合名称
        Set<String> collectionNames = db.getCollectionNames();
        for (String collectionName:
             collectionNames) {
            System.out.println(collectionName);
        }
        //获取自己使用的collection
        DBCollection person = db.getCollection("person");
        DBCursor cursor = person.find();
        while(cursor.hasNext()){
            DBObject object = cursor.next();
            System.out.println(object.get("name"));
        }
        System.out.println(cursor.count());
    }
}
