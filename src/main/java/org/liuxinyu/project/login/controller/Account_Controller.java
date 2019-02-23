package org.liuxinyu.project.login.controller;

import org.liuxinyu.project.login.entity.Account;
import org.liuxinyu.project.login.service.IAccount_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
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
    public Map<String, Object> verifyLogin(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Account account) {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        List<Account> resoultList = null;
        try {
            resoultList = iAccount_service.queryAccount(account);
            if (1 == resoultList.size()) {
                httpServletRequest.getSession().setAttribute("username", resoultList.get(0).getUsername());
                httpServletRequest.getSession().setAttribute("name", resoultList.get(0).getName());
                resultMap.put("state", "0");
                resultMap.put("count", 1);
            } else {
                resultMap.put("state", "1");
                resultMap.put("count", 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultMap.put("state", "0");
            resultMap.put("error", "糟糕，出错了！");
        }
        return resultMap;
    }

    @ResponseBody
    @RequestMapping("updatePwd")
    public void updatePwd(Account account) {
        System.out.println("account = " + account);
        try {
            iAccount_service.updatePwd(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ResponseBody
    @RequestMapping("queryPwd")
    public Account queryPwd(HttpServletRequest request) {
        String username = (String) request.getSession().getAttribute("username");
        System.out.println("username = " + username);
        Account account = new Account();
        try {
            account = iAccount_service.queryPwd(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return account;
    }
}
