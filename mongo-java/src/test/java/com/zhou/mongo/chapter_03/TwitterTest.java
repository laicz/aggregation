/**
 * Date:     2018/5/178:08
 * AUTHOR:   Administrator
 */
package com.zhou.mongo.chapter_03;

import com.zhou.mongo.chapter_03.model.Twitter;
import com.zhou.mongo.chapter_03.service.TwitterService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;

/**
 * 2018/5/17  8:08
 * created by zhoumb
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TwitterTest {

    @Autowired
    TwitterService twitterService;

    @Test
    public  void saveTwitter(){
        Twitter twitter = new Twitter();
        twitter.setContent("this is twitter content");
        twitter.setTags(new String[]{"a","b","c"});
        twitterService.saveTwitter(twitter);
    }
}
