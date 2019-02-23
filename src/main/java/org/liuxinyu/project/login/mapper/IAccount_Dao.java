package org.liuxinyu.project.login.mapper;

import org.liuxinyu.project.login.entity.Account;

import java.util.List;

/**
 * @author liuxinyu
 * @date 2019/1/31 0031 - 12:22
 */
public interface IAccount_Dao {
    List<Account> queryAccount(Account account);

    void addAccount(Account account);

    void updatePwd(Account account);

    void updateAccount(Account account);

    Account queryPwd(String username);

}
