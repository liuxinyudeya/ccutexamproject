package org.liuxinyu.project.academy.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.academy.mapper.IAcademy_Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class Academy_Service_Impl implements Academy_Service_Iface {
    @Resource
    IAcademy_Dao iAcademy_dao;


    public Map<String, Object> addAcademy(Academy academy) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        academy.setId(academy.getGrade()+academy.getAcademyCode()); // 设置主键id : 年级+学院编号 确保唯一
        academy.setDepartment("03"); // 设置部门等级 03 学院 : 02 专业 : 01 班级

        try {
            iAcademy_dao.addAcademyByOne(academy);
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已录入该信息");
            return stringObjectHashMap;
        }

        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "添加成功");
        return stringObjectHashMap;
    }

    public List<Academy> queryAllAcademy() throws Exception {
        return iAcademy_dao.queryAllAcademy();

    }
}
