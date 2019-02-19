package org.liuxinyu.project.s_student.service;

import org.liuxinyu.project.s_student.entity.S_Student;
import org.liuxinyu.project.s_student.mapper.IS_Student_Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class S_Student_Service implements IS_Student_Service {
    @Resource
    IS_Student_Dao is_student_dao;
    @Override
    public List<S_Student> queryCourseList(String studentno) throws Exception {
        List<S_Student> s_students = is_student_dao.queryCourseList(studentno);
        return s_students;
    }
}
