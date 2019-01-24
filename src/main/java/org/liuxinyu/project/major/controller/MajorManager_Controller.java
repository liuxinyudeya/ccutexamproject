package org.liuxinyu.project.major.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.major.service.IMajor_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    public List<Academy> academyInit(String grade) {
        List<Academy> list = new ArrayList<Academy>();


        return list;
    }


}
