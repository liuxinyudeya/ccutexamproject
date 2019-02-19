package org.liuxinyu.project.s_student.service;

import org.liuxinyu.project.s_student.entity.S_Student;

import java.util.List;

public interface IS_Student_Service {

    List<S_Student> queryCourseList(String studentno) throws Exception;
}
