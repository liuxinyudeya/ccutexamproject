package org.liuxinyu.project.academy.controller;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.academy.service.Academy_Service_Iface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
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
            System.out.println(e.getMessage());

            stringObjectHashMap.put("state",1);
            stringObjectHashMap.put("error","糟糕,服务器出错了!");
        }
        return stringObjectHashMap ;

    }

    @ResponseBody
    @RequestMapping("queryAllAcademy")
    public Map<String,Object> queryAllAcademy(){
        Map<String, Object> stringObjectHashMap = new HashMap<String, Object>();

        return stringObjectHashMap ;

    }

}
