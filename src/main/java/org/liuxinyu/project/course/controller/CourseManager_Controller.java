package org.liuxinyu.project.course.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.cla.service.ICla_Service;
import org.liuxinyu.project.course.entity.Course;
import org.liuxinyu.project.course.service.ICourse_Service;
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
@RequestMapping("CourseManager_Controller")
public class CourseManager_Controller {


    @Resource
    ICourse_Service iCourse_service;


    @ResponseBody
    @RequestMapping("addCourse")
    public Map<String, Object> addClass(Course course) {
        System.out.println("course = " + course);
        Map<String, Object> stringObjectHashMap = null;
        try {
            stringObjectHashMap = iCourse_service.addCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }

    @ResponseBody
    @RequestMapping("queryAllCourse")
    public String queryAllCourse(int page, int limit, String key) {
        List<Course> CourseList = new ArrayList<Course>();
        List<Course> data = new ArrayList<Course>();

        try {
            CourseList = iCourse_service.queryAllCourse(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = CourseList.size() > page * limit ? page * limit : CourseList.size();


        for (int i = (page - 1) * limit; i < count; i++) {
            data.add(CourseList.get(i));
        }
        LayuiTable list = new LayuiTable("0", "", CourseList.size(), data);
        return JSON.toJSONString(list);

    }

    @ResponseBody
    @RequestMapping("queryCourse")
    public List<Course> queryCourse(String grade,String academyCode,String majorCode) {
        List<Course> CourseList = new ArrayList<Course>();
        System.out.println("grade = [" + grade + "], academyCode = [" + academyCode + "], majorCode = [" + majorCode + "]");
        try {
            CourseList = iCourse_service.queryCourse(grade,academyCode,majorCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return CourseList;

    }


    @ResponseBody
    @RequestMapping("updateCourse")
    public Map<String, Object> updateCourse(Course course) {
        System.out.println("course = " + course);
        Map<String, Object> stringObjectHashMap = null;
        try {
            stringObjectHashMap = iCourse_service.updateCourse(course);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }


}
