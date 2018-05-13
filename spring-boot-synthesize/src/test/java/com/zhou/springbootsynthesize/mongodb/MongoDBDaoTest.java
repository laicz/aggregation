/**
 * Date:     2018/5/1123:04
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.mongodb;

import com.mongodb.WriteResult;
import com.zhou.springbootsynthesize.sys.model.LoginInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

/**
 * 2018/5/11  23:04
 * created by zhoumb
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoDBDaoTest {

    @Autowired
    private BaseMongoDBDao baseMongoDBDao;

    @Test
    public  void save(){
        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setId(UUID.randomUUID().toString().substring(0,17).replaceAll("-",""));
        loginInfo.setUsername("zhouzhuang2017");
        loginInfo.setPassword(UUID.randomUUID().toString().substring(0,17).replaceAll("-",""));
        loginInfo.setStatus(1);
        baseMongoDBDao.save(loginInfo);
    }

    @Test
    public  void remove(){
        WriteResult writeResult = baseMongoDBDao.removeWith(new LoginInfo());
        System.out.println(writeResult);
    }

}
