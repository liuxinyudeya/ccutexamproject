package org.liuxinyu.project.academy.controller;


import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.academy.entity.User_test;
import org.liuxinyu.project.academy.service.Academy_Service_Iface;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("HelloWord_Controller")
public class HelloWord_Controller {

    @Resource
    Academy_Service_Iface academy_service_iface;


    @ResponseBody
    @RequestMapping("test01")
    public void test01() throws Exception {
        System.out.println("emmm");
        academy_service_iface.addAcademy();
        System.out.println("hahaha");
    }

    @ResponseBody
    @RequestMapping("test02")
    public String test02() throws Exception {
        List<User_test> arrayList = new ArrayList<User_test>();
        System.out.println("emmm");
        arrayList = academy_service_iface.queryAcademy();
        System.out.println("arrayList = " + arrayList);

        return  JSON.toJSONString(arrayList);
    }
}
