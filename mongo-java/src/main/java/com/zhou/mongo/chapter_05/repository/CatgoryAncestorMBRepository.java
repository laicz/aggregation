/**
 * Date:     2018/5/209:46
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.repository;

import com.zhou.mongo.model.CatgoryAncestor;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 2018/5/20  9:46
 * created by zhoumb
 */
public interface CatgoryAncestorMBRepository extends MongoRepository<CatgoryAncestor,String>{
}
