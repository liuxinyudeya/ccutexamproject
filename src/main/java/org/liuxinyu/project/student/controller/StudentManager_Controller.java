package org.liuxinyu.project.student.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.cla.service.ICla_Service;
import org.liuxinyu.project.student.entity.Student;
import org.liuxinyu.project.student.service.IStudent_Service;
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
@RequestMapping("StudentManager_Controller")
public class StudentManager_Controller {


    @Resource
    IStudent_Service iStudent_service;


    @ResponseBody
    @RequestMapping("addStudent")
    public Map<String, Object> addStudent(Student student) {
        System.out.println("student = " + student);
        Map<String, Object> stringObjectHashMap = null;
        try {
            stringObjectHashMap = iStudent_service.addStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }

    @ResponseBody
    @RequestMapping("queryAllStudent")
    public String queryAllStudent(int page, int limit, String key) {
        List<Student> studentList = new ArrayList<Student>();
        List<Student> data = new ArrayList<Student>();

        try {
            studentList = iStudent_service.queryAllStudent(key);

        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = studentList.size() > page * limit ? page * limit : studentList.size();


        for (int i = (page - 1) * limit; i < count; i++) {
            data.add(studentList.get(i));
        }
        LayuiTable list = new LayuiTable("0", "", studentList.size(), data);
        return JSON.toJSONString(list);

    }

    @ResponseBody
    @RequestMapping("updateStudent")
    public Map<String, Object> updateStudent(Student student) {
        System.out.println("student = " + student);
        Map<String, Object> stringObjectHashMap = null;
        try {
            stringObjectHashMap = iStudent_service.updateStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }


}
