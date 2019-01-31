package org.liuxinyu.project.student.service;

import org.liuxinyu.project.student.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:13
 */
public interface IStudent_Service {


    Map<String, Object> addStudent(Student student) throws Exception;

    List<Student> queryAllStudent(String key) throws Exception;

    Map<String, Object> updateStudent(Student student) throws Exception;
}
