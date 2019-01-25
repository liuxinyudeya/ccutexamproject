package org.liuxinyu.project.major.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.major.service.IMajor_Service;
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
@RequestMapping("MajorManager_Controller")
public class MajorManager_Controller {

    @Resource
    IMajor_Service iMajor_service;

    @ResponseBody
    @RequestMapping("gradeInit")
    public List<String> gradeInit() {
        System.out.println("emmm...");
        List<String> gradeList = null;
        try {
            gradeList = iMajor_service.gradeInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gradeList;

    }

    @ResponseBody
    @RequestMapping("academyInit")
    public List<Academy> academyInit(String grade) {
        List<Academy> list = new ArrayList<Academy>();
        try {
            list = iMajor_service.academyInit(grade);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @ResponseBody
    @RequestMapping("addMajor")
    public Map<String, Object> addMajor(Academy academy) {
        System.out.println("academy = " + academy);
        Map<String, Object> stringObjectHashMap = null;
        try {
            stringObjectHashMap = iMajor_service.addMajor(academy);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }

    @ResponseBody
    @RequestMapping("queryAllMajor")
    public String queryAllMajor(int page, int limit, String key) {
        List<Academy> majorList = new ArrayList<Academy>();
        List<Academy> data = new ArrayList<Academy>();

        try {
            majorList = iMajor_service.queryAllMajor(key);

        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = majorList.size() > page * limit ? page * limit : majorList.size();


        for (int i = (page - 1) * limit; i < count; i++) {
            data.add(majorList.get(i));
        }
        LayuiTable list = new LayuiTable("0", "", majorList.size(), data);
        return JSON.toJSONString(list);

    }

}
