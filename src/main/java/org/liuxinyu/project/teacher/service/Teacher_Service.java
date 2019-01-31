package org.liuxinyu.project.teacher.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.major.mapper.IMajor_Dao;
import org.liuxinyu.project.major.service.IMajor_Service;
import org.liuxinyu.project.teacher.entity.Teacher;
import org.liuxinyu.project.teacher.mapper.ITeacher_Dao;
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
public class Teacher_Service implements ITeacher_Service {

    @Resource
    ITeacher_Dao iTeacher_dao;

    public Map<String, Object> addTeacher(Teacher teacher) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();

        try {
            iTeacher_dao.addTeacher(teacher);
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已录入该信息");
            return stringObjectHashMap;
        }

        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "添加成功");
        return stringObjectHashMap;
    }

    public List<Teacher> queryAllTeacher(String key) throws Exception {

        return iTeacher_dao.queryAllTeacher(key);
    }

    public Map<String, Object> updateTeacher(Teacher teacher) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();

        try {
            iTeacher_dao.updateTeacher(teacher);
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已有[" + teacher.getTeacherno() + "]工号的教师");
            return stringObjectHashMap;
        }

        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "更新成功");
        return stringObjectHashMap;
    }
}
