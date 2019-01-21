package org.liuxinyu.project.academy.service;

import org.liuxinyu.project.academy.entity.User_test;

import java.util.List;

public interface Academy_Service_Iface {

    void addAcademy() throws Exception ;

    List<User_test> queryAcademy() throws Exception ;
}
