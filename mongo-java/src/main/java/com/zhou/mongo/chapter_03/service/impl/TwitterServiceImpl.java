/**
 * Date:     2018/5/178:05
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_03.service.impl;

import com.zhou.mongo.chapter_03.model.Twitter;
import com.zhou.mongo.chapter_03.repository.TwitterRepository;
import com.zhou.mongo.chapter_03.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 2018/5/17  8:05
 * created by zhoumb
 */
@Service
public class TwitterServiceImpl implements TwitterService {

    @Autowired
    private TwitterRepository twitterRepository;

    public void saveTwitter(Twitter twitter){
        twitterRepository.save(twitter);
    }
}
