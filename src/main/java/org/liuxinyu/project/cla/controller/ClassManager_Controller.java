package org.liuxinyu.project.cla.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.cla.service.ICla_Service;
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
@RequestMapping("ClassManager_Controller")
public class ClassManager_Controller {


    @Resource
    ICla_Service iCla_service;


    @ResponseBody
    @RequestMapping("addClass")
    public Map<String, Object> addClass(Academy academy) {
        System.out.println("academy = " + academy);
        Map<String, Object> stringObjectHashMap = null;
        try {
            stringObjectHashMap = iCla_service.addCla(academy);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }

    @ResponseBody
    @RequestMapping("queryAllClass")
    public String queryAllMajor(int page, int limit, String key) {
        List<Academy> claList = new ArrayList<Academy>();
        List<Academy> data = new ArrayList<Academy>();

        try {
            claList = iCla_service.queryAllCla(key);

        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = claList.size() > page * limit ? page * limit : claList.size();


        for (int i = (page - 1) * limit; i < count; i++) {
            data.add(claList.get(i));
        }
        LayuiTable list = new LayuiTable("0", "", claList.size(), data);
        return JSON.toJSONString(list);

    }

    @ResponseBody
    @RequestMapping("updateClass")
    public Map<String, Object> updateClass(Academy academy) {
        System.out.println("academy = " + academy);
        Map<String, Object> stringObjectHashMap = null;
        try {
            stringObjectHashMap = iCla_service.updateCla(academy);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", 1);
            stringObjectHashMap.put("error", "糟糕,服务器出错了!");
        }
        return stringObjectHashMap;
    }


}
