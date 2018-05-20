/**
 * Date:     2018/5/1922:30
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.web;

import com.zhou.mongo.chapter_05.service.ProductService;
import com.zhou.mongo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2018/5/19  22:30
 * created by zhoumb
 */
@RestController
@RequestMapping(value = "/index")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/product/getProductById")
    public Product getProductById(@RequestParam(value = "productId")String productId){
        return productService.findProductById(productId);
    }
}
