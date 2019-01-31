package org.liuxinyu.project.course.service;

import org.apache.ibatis.annotations.Param;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.course.entity.Course;

import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:13
 */
public interface ICourse_Service {


    Map<String, Object> addCourse(Course course) throws Exception;

    List<Course> queryAllCourse(String key) throws Exception;

    List<Course>  queryCourse(String graed,String academyCode,String majorCode) throws Exception;

    Map<String, Object> updateCourse(Course course) throws Exception;
}
