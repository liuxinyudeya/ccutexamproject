package org.liuxinyu.project.student.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.cla.mapper.ICla_Dao;
import org.liuxinyu.project.cla.service.ICla_Service;
import org.liuxinyu.project.login.entity.Account;
import org.liuxinyu.project.login.mapper.IAccount_Dao;
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
    @Resource
    IAccount_Dao iAccount_dao;


    public Map<String, Object> addStudent(Student student) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        Account account = new Account();

        account.setUsername(student.getStudentno()); // 学号就是账号
        account.setPassword("123456"); // 默认密码123456
        account.setName(student.getName());
        account.setRoleCode("01"); // 学生

        try {
            iStudent_dao.addStudent(student); // 向学生表中添加记录
            iAccount_dao.addAccount(account);
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
        Account account = new Account();
        account.setNewusername(student.getNewstudentno());
        account.setName(student.getName());
        account.setUsername(student.getStudentno());
        try {
            iStudent_dao.updateStudent(student); // 修改学生学号
            iAccount_dao.updateAccount(account); // 修改学生登陆用户名
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
