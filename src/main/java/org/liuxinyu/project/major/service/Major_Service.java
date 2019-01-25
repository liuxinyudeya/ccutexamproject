package org.liuxinyu.project.major.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.major.mapper.IMajor_Dao;
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
public class Major_Service implements IMajor_Service {

    @Resource
    IMajor_Dao iMajor_dao;

    public List<String> gradeInit() throws Exception {
        List<String> gradeList = iMajor_dao.queryGradeKind();
        return gradeList;
    }

    public List<Academy> academyInit(String grade) throws Exception {
        List<Academy> academyList = iMajor_dao.queryAcademyKind(grade);
        return academyList;
    }

    public Map<String, Object> addMajor(Academy academy) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        academy.setId(academy.getGrade() + academy.getAcademyCode() + academy.getMajorCode()); // 设置主键id : 年级+学院编号+专业编号 确保唯一
        academy.setDepartment("02"); // 设置部门等级 03 学院 : 02 专业 : 01 班级
        academy.setManagerid(academy.getGrade()+academy.getAcademyCode());

        try {
            iMajor_dao.addMajor(academy);
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已录入该信息");
            return stringObjectHashMap;
        }


        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "添加成功");
        return stringObjectHashMap;
    }

    public List<Academy> queryAllMajor(String key) throws Exception {

        return iMajor_dao.queryAllMajor(key) ;
    }
}
