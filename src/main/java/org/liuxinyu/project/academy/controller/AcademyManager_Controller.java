package org.liuxinyu.project.academy.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.academy.service.Academy_Service_Iface;
import org.liuxinyu.project.util.entity.LayuiTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("AcademyManager")
public class AcademyManager_Controller {

    @Resource
    Academy_Service_Iface academy_service_iface;

    @ResponseBody
    @RequestMapping(value = "addAcademy",method = RequestMethod.POST)
    public Map<String,Object> addAcademy(Academy academy){
        System.out.println("academy = " + academy);
        Map<String, Object> stringObjectHashMap=null;
        try {
            stringObjectHashMap = academy_service_iface.addAcademy(academy);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state",1);
            stringObjectHashMap.put("error","糟糕,服务器出错了!");
        }
        return stringObjectHashMap ;

    }

    @ResponseBody
    @RequestMapping("queryAllAcademy")
    public String queryAllAcademy(int page, int limit){// page 当前页数 ： limit 每页条数

        List<Academy> academyList = new ArrayList<Academy>();
        List<Academy> data = new ArrayList<Academy>();

        try {
            academyList = academy_service_iface.queryAllAcademy();

        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = academyList.size()>page*limit? 2*limit:academyList.size();

        for(int i=(page-1)*limit;i<count;i++){
            data.add(academyList.get(i));
        }

        LayuiTable list = new LayuiTable("0","",count,data);
        return JSON.toJSONString(list) ;

    }

    @ResponseBody
    @RequestMapping("updateAcademy")
    public Map<String,Object> updateAcademy(Academy academy){
        System.out.println("academy = " + academy);
        Map<String, Object> stringObjectHashMap=null;
        try {
            stringObjectHashMap = academy_service_iface.updateAcademy(academy);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state",1);
            stringObjectHashMap.put("error","糟糕,服务器出错了!");
        }
        return stringObjectHashMap ;
    }


}

