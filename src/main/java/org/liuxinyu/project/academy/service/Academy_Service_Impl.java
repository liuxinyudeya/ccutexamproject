package org.liuxinyu.project.academy.service;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;
import org.liuxinyu.project.academy.entity.User_test;
import org.liuxinyu.project.academy.mapper.User_test_Dao_Iface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class Academy_Service_Impl implements Academy_Service_Iface {
    @Resource
    User_test_Dao_Iface user_test_dao_iface;

    public void addAcademy() throws Exception {
        user_test_dao_iface.addUser_test();
    }

    public List<User_test> queryAcademy() throws Exception {
        return user_test_dao_iface.queryUser_test();

    }
}
