package org.liuxinyu.project.distribution.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.distribution.entity.Tea_Cla_Cou;
import org.liuxinyu.project.distribution.service.ITea_Cla_Cou_Service;
import org.liuxinyu.project.student.entity.Student;
import org.liuxinyu.project.student.service.IStudent_Service;
import org.liuxinyu.project.util.controller.UUID_Tools;
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
@RequestMapping("Tea_Cla_CouManager_Controller")
public class Tea_Cla_CouManager_Controller {


    @Resource
    ITea_Cla_Cou_Service iTea_cla_cou_service ;


    @ResponseBody
    @RequestMapping("addTea_Cla_Cou")
    public Map<String, Object> addTea_Cla_Cou(Tea_Cla_Cou tea_cla_cou) {
        System.out.println("tea_cla_cou = " + tea_cla_cou);
        Map<String, Object> stringObjectHashMap = null;
        try {
            tea_cla_cou.setId(UUID_Tools.getUUID());
            stringObjectHashMap = iTea_cla_cou_service.addTea_Cla_Cou(tea_cla_cou);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }

    @ResponseBody
    @RequestMapping("queryAllTea_Cla_Cou")
    public String queryAllTea_Cla_Cou(int page, int limit, String key) {
        List<Tea_Cla_Cou> studentList = new ArrayList<Tea_Cla_Cou>();
        List<Tea_Cla_Cou> data = new ArrayList<Tea_Cla_Cou>();

        try {
            studentList = iTea_cla_cou_service.queryAllTea_Cla_Cou(key);

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
    @RequestMapping("updateTea_Cla_Cou")
    public Map<String, Object> updateTea_Cla_Cou(Tea_Cla_Cou tea_cla_cou) {
        System.out.println("tea_cla_cou = " + tea_cla_cou);
        Map<String, Object> stringObjectHashMap = null;
        try {
            stringObjectHashMap = iTea_cla_cou_service.updateTea_Cla_Cou(tea_cla_cou);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }


}
