/**
 * Date:     2018/5/1921:51
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.repository;

import com.zhou.mongo.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * product的jpa接口
 * 2018/5/19  21:51
 * created by zhoumb
 */
public interface ProductMBRepository extends MongoRepository<Product, String> {

}
