package org.liuxinyu.project.login.service;

import org.liuxinyu.project.login.entity.Account;


import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/31 0031 - 12:25
 */

public interface IAccount_Service {
    List<Account> queryAccount(Account account) throws Exception;
}
