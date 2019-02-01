package org.liuxinyu.project.login.service;

import org.liuxinyu.project.login.entity.Account;
import org.liuxinyu.project.login.mapper.IAccount_Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/31 0031 - 12:26
 */
@Service
@Transactional
public class Account_Service implements IAccount_Service {

    @Resource
    IAccount_Dao iAccount_dao;

    public Map<String, Object> queryAccount(Account account) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();

        List<Account> resultList = iAccount_dao.queryAccount(account);
        resultMap.put("state", '0');
        resultMap.put("success", "登陆成功");
        resultMap.put("count",resultList.size());

        return resultMap;
    }
}