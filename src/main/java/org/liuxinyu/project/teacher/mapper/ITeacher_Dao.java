package org.liuxinyu.project.teacher.mapper;

import org.apache.ibatis.annotations.Param;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.teacher.entity.Teacher;

import java.util.List;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:10
 */
public interface ITeacher_Dao {



    void addTeacher(Teacher teacher);

    List<Teacher> queryAllTeacher(String key);

    void updateTeacher(Teacher teacher);
}
