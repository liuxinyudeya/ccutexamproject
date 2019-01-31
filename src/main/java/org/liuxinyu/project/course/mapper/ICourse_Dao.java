package org.liuxinyu.project.course.mapper;


import org.apache.ibatis.annotations.Param;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.course.entity.Course;
import org.liuxinyu.project.distribution.entity.Tea_Cla_Cou;

import java.util.List;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:10
 */
public interface ICourse_Dao {


    void addCourse(Course course);

    List<Course> queryAllCourse(String key);

    List<Course> queryCourse(@Param("grade") String graed, @Param("academyCode") String academyCode, @Param("majorCode") String majorCode) throws Exception;

    void updateCourse(Course course);

    void updateCourse_dist(String courseno);
}
