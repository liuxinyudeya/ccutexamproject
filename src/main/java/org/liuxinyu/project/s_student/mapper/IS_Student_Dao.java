package org.liuxinyu.project.s_student.mapper;

import org.apache.ibatis.annotations.Param;
import org.liuxinyu.project.distribution.entity.Tea_Cla_Cou;
import org.liuxinyu.project.s_student.entity.ClassRank;
import org.liuxinyu.project.s_student.entity.GradeInfo;
import org.liuxinyu.project.s_student.entity.S_Student;
import org.liuxinyu.project.s_student.entity.UpPer;
import org.liuxinyu.project.student.entity.Student;

import java.util.HashMap;
import java.util.List;

public interface IS_Student_Dao {

    List<S_Student> queryCourseList(String studentno);

    int calcScore(@Param("answer") String answer, @Param("questionid") String questionid);

    UpPer queryQuestionForCheck(String questionid);

    void addGradeInfo(GradeInfo gradeInfo);

    Student queryStudent(String studentno);

    void paperFinsh(String paperid);

    List<GradeInfo> queryGradeInfo(String studentno);

    Tea_Cla_Cou queryTCC(String courseno);

    String queryClassAvg(String courseno);

    List<ClassRank> queryClassRank(@Param("classno") String classno, @Param("courseno") String courseno);

    int isFinshExam(@Param("studentno") String studentno, @Param("courseno") String courseno);

    String querypaperno(String courseno);

}
