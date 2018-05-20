/**
 * Date:     2018/5/209:53
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service.impl;

import com.zhou.mongo.chapter_05.repository.CatgoriesMBRepository;
import com.zhou.mongo.chapter_05.service.CatgoriesService;
import com.zhou.mongo.model.Categories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2018/5/20  9:53
 * created by zhoumb
 */
@Service
public class CatgoriesServiceImpl implements CatgoriesService {

    @Autowired
    private CatgoriesMBRepository catgoriesMBRepository;

    @Override
    public List<Categories> saveAll(List<Categories> categories) {
        return catgoriesMBRepository.saveAll(categories);
    }
}
