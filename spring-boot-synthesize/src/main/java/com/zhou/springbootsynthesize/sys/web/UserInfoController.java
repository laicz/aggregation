/**
 * Date:     2018/5/1522:55
 * AUTHOR:   Administrator
 */
package com.zhou.springbootsynthesize.sys.web;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于测试系统管理
 * 2018/5/15  22:55
 * created by zhoumb
 */
@Controller
@RequestMapping(value = "/userInfo")
public class UserInfoController {

    /**
     * 用户查询
     * @return
     */
    @RequestMapping("/usrList")
    @RequiresPermissions("userInfo:view")
    public String userInfo(){
        return "userInfo";
    }

    /**
     * 用户添加
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")
    public String userInfoAdd(){
        return "userInfoAdd";
    }

    /**
     * 用户删除
     * @return
     */
    @RequestMapping("/userDel")
    @RequiresPermissions("userInfo:del")
    public String userInfoDel(){
        return "userInfoDel";
    }

}
