package org.liuxinyu.project.s_student.service;

import org.liuxinyu.project.s_student.entity.GradeInfo;
import org.liuxinyu.project.s_student.entity.S_Student;

import java.util.List;

public interface IS_Student_Service {

    List<S_Student> queryCourseList(String studentno) throws Exception;

    int calcScore(String data, String studentno) throws Exception;

    List<GradeInfo> queryPaper(String studentno) throws Exception;
}
