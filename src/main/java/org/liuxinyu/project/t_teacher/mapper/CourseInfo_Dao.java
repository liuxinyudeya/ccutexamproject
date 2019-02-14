package org.liuxinyu.project.t_teacher.mapper;

import org.liuxinyu.project.t_teacher.entity.CourseInfo;

import java.util.List;

public interface CourseInfo_Dao {

    List<CourseInfo> queryCourseList(String teacherno);
}
