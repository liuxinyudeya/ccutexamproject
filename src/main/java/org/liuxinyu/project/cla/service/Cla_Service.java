package org.liuxinyu.project.cla.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.cla.mapper.ICla_Dao;
import org.liuxinyu.project.major.mapper.IMajor_Dao;
import org.liuxinyu.project.major.service.IMajor_Service;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:14
 */
@Service
@Transactional
public class Cla_Service implements ICla_Service {


    @Resource
    ICla_Dao iCla_dao;


    public Map<String, Object> addCla(Academy academy) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        academy.setId(academy.getGrade() + academy.getAcademyCode() + academy.getMajorCode() + academy.getClassno()); // 设置主键id : 年级+学院编号+专业编号 确保唯一
        academy.setDepartment("01"); // 设置部门等级 03 学院 : 02 专业 : 01 班级
        academy.setManagerid(academy.getGrade() + academy.getAcademyCode() + academy.getMajorCode());

        try {
            iCla_dao.addCla(academy);
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已录入该信息");
            return stringObjectHashMap;
        }


        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "添加成功");
        return stringObjectHashMap;
    }

    public List<Academy> queryAllCla(String key) throws Exception {

        return iCla_dao.queryAllCla(key);
    }

    public Map<String, Object> updateCla(Academy academy) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        academy.setNewid(academy.getGrade() + academy.getAcademyCode() + academy.getMajorCode()+academy.getClassno());
        academy.setManagerid(academy.getGrade() + academy.getAcademyCode()+academy.getMajorCode());
        try {
            iCla_dao.updateCla(academy);
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已有[" + academy.getId() + "]编号的学院");
            return stringObjectHashMap;
        }

        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "更新成功");
        return stringObjectHashMap;
    }
}
