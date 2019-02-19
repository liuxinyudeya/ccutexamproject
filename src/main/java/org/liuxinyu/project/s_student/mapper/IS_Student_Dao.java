package org.liuxinyu.project.s_student.mapper;

import org.liuxinyu.project.s_student.entity.S_Student;

import java.util.List;

public interface IS_Student_Dao {

    List<S_Student> queryCourseList(String studentno);
}
