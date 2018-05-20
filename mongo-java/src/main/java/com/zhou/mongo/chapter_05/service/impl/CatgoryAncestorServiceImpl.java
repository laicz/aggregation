/**
 * Date:     2018/5/209:45
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service.impl;

import com.zhou.mongo.chapter_05.repository.CatgoryAncestorMBRepository;
import com.zhou.mongo.chapter_05.service.CatgoryAncestorService;
import com.zhou.mongo.model.CatgoryAncestor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2018/5/20  9:45
 * created by zhoumb
 */
@Service
public class CatgoryAncestorServiceImpl implements CatgoryAncestorService {

    @Autowired
    private CatgoryAncestorMBRepository catgoryAncestorMBRepository;

    @Override
    public List<CatgoryAncestor> saveAll(List<CatgoryAncestor> catgoryAncestors){
        return  catgoryAncestorMBRepository.saveAll(catgoryAncestors);
    }
}
