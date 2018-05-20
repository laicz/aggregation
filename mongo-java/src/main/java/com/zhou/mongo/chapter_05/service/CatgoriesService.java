/**
 * Date:     2018/5/209:53
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_05.service;

import com.zhou.mongo.model.Categories;

import java.util.List; /**
 * 2018/5/20  9:53
 * created by zhoumb
 */
public interface CatgoriesService {
    List<Categories> saveAll(List<Categories> categories);
}
