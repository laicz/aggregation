/**
 * Date:     2018/5/1921:48
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service;

import com.zhou.mongo.model.Product;

import java.util.List;

/**
 * 2018/5/19  21:48
 * created by zhoumb
 */
public interface ProductService {

    Product findProductById(String id);

    boolean addProduct(List<Product> products);
}
