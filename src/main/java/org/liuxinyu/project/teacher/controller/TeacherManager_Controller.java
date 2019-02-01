package org.liuxinyu.project.teacher.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.login.entity.Account;
import org.liuxinyu.project.login.mapper.IAccount_Dao;
import org.liuxinyu.project.major.service.IMajor_Service;
import org.liuxinyu.project.teacher.entity.Teacher;
import org.liuxinyu.project.teacher.mapper.ITeacher_Dao;
import org.liuxinyu.project.teacher.service.ITeacher_Service;
import org.liuxinyu.project.util.entity.LayuiTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:00
 */
@Controller
@RequestMapping("TeacherManager_Controller")
public class TeacherManager_Controller {

    @Resource
    ITeacher_Service iTeacher_service;
    @Resource
    IAccount_Dao iAccount_dao;

    @ResponseBody
    @RequestMapping("addTeacher")
    public Map<String, Object> addTeacher(Teacher teacher) {
        System.out.println("teacher = " + teacher);
        Map<String, Object> stringObjectHashMap = null;


        try {
            stringObjectHashMap = iTeacher_service.addTeacher(teacher); // 教师信息表添加教师

        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }

    @ResponseBody
    @RequestMapping("queryAllTeacher")
    public String queryAllTeacher(int page, int limit, String key) {
        List<Teacher> teacherList = new ArrayList<Teacher>();
        List<Teacher> data = new ArrayList<Teacher>();

        try {
            teacherList = iTeacher_service.queryAllTeacher(key);

        } catch (Exception e) {
            e.printStackTrace();
        }

        int count = teacherList.size() > page * limit ? page * limit : teacherList.size();


        for (int i = (page - 1) * limit; i < count; i++) {
            data.add(teacherList.get(i));
        }
        LayuiTable list = new LayuiTable("0", "", teacherList.size(), data);
        return JSON.toJSONString(list);

    }

    @ResponseBody
    @RequestMapping("queryTeacher")
    public List<Teacher> queryTeacher(String key) {
        List<Teacher> teacherList = new ArrayList<Teacher>();

        try {
            teacherList = iTeacher_service.queryAllTeacher(key);

        } catch (Exception e) {
            e.printStackTrace();
        }


        return teacherList;

    }


    @ResponseBody
    @RequestMapping("updateTeacher")
    public Map<String, Object> updateTeacher(Teacher teacher) {
        System.out.println("academy = " + teacher);
        Map<String, Object> stringObjectHashMap = null;
        try {
            stringObjectHashMap = iTeacher_service.updateTeacher(teacher);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }


}
