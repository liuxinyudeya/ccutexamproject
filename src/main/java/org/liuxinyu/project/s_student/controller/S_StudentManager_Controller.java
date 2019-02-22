package org.liuxinyu.project.s_student.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.s_student.entity.GradeInfo;
import org.liuxinyu.project.s_student.entity.S_Student;
import org.liuxinyu.project.s_student.service.IS_Student_Service;
import org.liuxinyu.project.util.entity.LayuiTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("S_StudentManager_Controller")
public class S_StudentManager_Controller {

    @Resource
    IS_Student_Service is_student_service;

    @ResponseBody
    @RequestMapping("queryCourseList")
    public String queryCourseList(int page, int limit, String key, HttpServletRequest request) {
        String studentno = (String) request.getSession().getAttribute("username");

        List<S_Student> s_studentList = new ArrayList<S_Student>();
        List<S_Student> data = new ArrayList<S_Student>();

        try {
            s_studentList = is_student_service.queryCourseList(studentno);

        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = s_studentList.size() > page * limit ? page * limit : s_studentList.size();

        for (int i = (page - 1) * limit; i < count; i++) {
            data.add(s_studentList.get(i));
        }

        LayuiTable list = new LayuiTable("0", "", s_studentList.size(), data);
        return JSON.toJSONString(list);

    }

    @ResponseBody
    @RequestMapping("upPaper")
    public int upPaper(String data, HttpServletRequest request) {
        System.out.println("data = " + data);
        String studentno = (String) request.getSession().getAttribute("username");
        int Score = 0;
        try {
            Score = is_student_service.calcScore(data, studentno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Score;

    }

    @RequestMapping("queryPaper")
    @ResponseBody
    public String queryPaper(int page, int limit, HttpServletRequest request) {
        String studentno = (String) request.getSession().getAttribute("username");
        List<GradeInfo> gradeInfos = new ArrayList<GradeInfo>();
        List<GradeInfo> data = new ArrayList<GradeInfo>();
        try {
            gradeInfos = is_student_service.queryPaper(studentno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = gradeInfos.size() > page * limit ? page * limit : gradeInfos.size();

        for (int i = (page - 1) * limit; i < count; i++) {
            data.add(gradeInfos.get(i));
        }

        LayuiTable list = new LayuiTable("0", "", gradeInfos.size(), data);
        return JSON.toJSONString(list);
    }
}






