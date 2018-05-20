/**
 * Date:     2018/5/209:44
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service;

import com.zhou.mongo.model.CatgoryAncestor;

import java.util.List;

/**
 * 2018/5/20  9:44
 * created by zhoumb
 */
public interface CatgoryAncestorService {
    List<CatgoryAncestor> saveAll(List<CatgoryAncestor> catgoryAncestors);
}
