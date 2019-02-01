package org.liuxinyu.project.login.controller;

import org.liuxinyu.project.login.entity.Account;
import org.liuxinyu.project.login.service.IAccount_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/31 0031 - 12:29
 */
@RequestMapping("Account_Controller")
@Controller
public class Account_Controller {
    @Resource
    IAccount_Service iAccount_service;

    @ResponseBody
    @RequestMapping("verifyLogin")
    public Map<String,Object> verifyLogin(Account account){
        Map<String,Object> resultMap = new HashMap<String, Object>();

        try {
            resultMap =  resultMap =  iAccount_service.queryAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("state","0");
            resultMap.put("error","糟糕，出错了！");
        }
        return resultMap;
    }
}
