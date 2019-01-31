package org.liuxinyu.project.student.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.cla.mapper.ICla_Dao;
import org.liuxinyu.project.cla.service.ICla_Service;
import org.liuxinyu.project.student.entity.Student;
import org.liuxinyu.project.student.mapper.IStudent_Dao;
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
public class Student_Service implements IStudent_Service {


    @Resource
    IStudent_Dao iStudent_dao;


    public Map<String, Object> addStudent(Student student) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        iStudent_dao.addStudent(student);
        try {

        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已录入该信息");
            return stringObjectHashMap;
        }


        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "添加成功");
        return stringObjectHashMap;
    }

    public List<Student> queryAllStudent(String key) throws Exception {

        return iStudent_dao.queryAllStudent(key);
    }

    public Map<String, Object> updateStudent(Student student) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();

        try {
            iStudent_dao.updateStudent(student);
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已有[" + student.getStudentno() + "]编号的学生");
            return stringObjectHashMap;
        }

        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "更新成功");
        return stringObjectHashMap;
    }
}
