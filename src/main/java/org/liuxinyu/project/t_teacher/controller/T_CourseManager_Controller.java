package org.liuxinyu.project.t_teacher.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.t_teacher.entity.CourseInfo;
import org.liuxinyu.project.t_teacher.service.T_CourseManager_IService;
import org.liuxinyu.project.util.entity.LayuiTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("T_CourseManager_Controller")
public class T_CourseManager_Controller {

    @Resource
    T_CourseManager_IService t_courseManager_iService;

    @ResponseBody
    @RequestMapping("courseList")
    public String courseList(int page, int limit, HttpServletRequest request, HttpServletResponse responseh) {
        List<CourseInfo> resultList = new ArrayList<CourseInfo>();
        List<CourseInfo> data = new ArrayList<CourseInfo>();
        String teacherno = (String) request.getSession().getAttribute("username");
        try {
            resultList = t_courseManager_iService.queryCourseLIst(teacherno);
        } catch (Exception e) {
            e.printStackTrace();
        }

        int count = resultList.size() > page * limit ? page * limit : resultList.size();

        for (int i = (page - 1) * limit; i < count; i++) {
            data.add(resultList.get(i));
        }

        LayuiTable list = new LayuiTable("0", "", resultList.size(), data);
        return JSON.toJSONString(list);

    }
}
