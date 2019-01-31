package org.liuxinyu.project.distribution.service;

import org.liuxinyu.project.course.entity.Course;
import org.liuxinyu.project.course.mapper.ICourse_Dao;
import org.liuxinyu.project.distribution.entity.Tea_Cla_Cou;
import org.liuxinyu.project.distribution.mapper.ITea_Cla_Cou_Dao;
import org.liuxinyu.project.student.entity.Student;
import org.liuxinyu.project.student.mapper.IStudent_Dao;
import org.liuxinyu.project.student.service.IStudent_Service;
import org.liuxinyu.project.teacher.service.ITeacher_Service;
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
public class Tea_Cla_Cou_Service implements ITea_Cla_Cou_Service {


    @Resource
    ITea_Cla_Cou_Dao iTea_cla_cou_dao;
    @Resource
    ICourse_Dao iCourse_dao;


    public Map<String, Object> addTea_Cla_Cou(Tea_Cla_Cou tea_cla_cou) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        String courseno = tea_cla_cou.getCourseno();
        try {
            iTea_cla_cou_dao.addTea_Cla_Cou(tea_cla_cou); // 向分配记录表中增加记录
            iCourse_dao.updateCourse_dist(courseno); // 更新课程表 未分配->已分配
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已录入该信息");
            return stringObjectHashMap;
        }


        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "添加成功");
        return stringObjectHashMap;
    }

    public List<Tea_Cla_Cou> queryAllTea_Cla_Cou(String key) throws Exception {

        return iTea_cla_cou_dao.queryAllTea_Cla_Cou(key);
    }

    public Map<String, Object> updateTea_Cla_Cou(Tea_Cla_Cou tea_cla_cou) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();


        iTea_cla_cou_dao.updateTea_Cla_Cou(tea_cla_cou);


        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "更新成功");
        return stringObjectHashMap;
    }
}
