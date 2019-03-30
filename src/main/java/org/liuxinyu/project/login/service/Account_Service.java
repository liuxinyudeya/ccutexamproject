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
    public static final String NAME = "liuxinyu";
    @Resource
    IAccount_Dao iAccount_dao;

    public List<Account> queryAccount(Account account) throws Exception {


        List<Account> resultList = iAccount_dao.queryAccount(account);


        return resultList;
    }

    @Override
    public void updatePwd(Account account) throws Exception {
        iAccount_dao.updatePwd(account);
    }

    @Override
    public Account queryPwd(String username) throws Exception {
        return iAccount_dao.queryPwd(username);

    }
}
