/**
 * Date:     2018/5/1921:47
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service.impl;

import com.zhou.mongo.chapter_05.dao.ProductMBDao;
import com.zhou.mongo.chapter_05.repository.ProductMBRepository;
import com.zhou.mongo.chapter_05.service.ProductService;
import com.zhou.mongo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * 商品service
 * 2018/5/19  21:47
 * created by zhoumb
 */
@Service
public class ProdcuctServiceImpl implements ProductService {

    @Autowired
    private ProductMBDao productMBDao;

    @Autowired
    private ProductMBRepository productMBRepository;

    @Override
    public Product findProductById(String id) {
        Optional<Product> optional = productMBRepository.findById(id);
        System.out.println(optional);
        if (optional == null || Optional.empty().equals(optional)) {
            return null;
        }
        return optional.get();
    }

    /**
     * 添加商品
     *
     * @param products
     * @return
     */
    @Override
    public boolean addProduct(List<Product> products) {
        List<Product> productList = productMBRepository.saveAll(products);
        return productList.size() == products.size();
    }

    @Override
    public List<Product> getAllProduct() {
        return productMBRepository.findAll();
    }
}
