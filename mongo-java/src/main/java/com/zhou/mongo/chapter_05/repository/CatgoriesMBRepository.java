/**
 * Date:     2018/5/209:56
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.repository;

import com.zhou.mongo.model.Categories;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2018/5/20  9:56
 * created by zhoumb
 */
public interface CatgoriesMBRepository extends MongoRepository<Categories,String>{
}
