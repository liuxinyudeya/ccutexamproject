package org.liuxinyu.project.t_teacher.service;

import org.liuxinyu.project.t_teacher.entity.CourseInfo;

import java.util.List;

public interface T_CourseManager_IService {

    List<CourseInfo> queryCourseLIst(String teacherno) throws Exception ;
}
