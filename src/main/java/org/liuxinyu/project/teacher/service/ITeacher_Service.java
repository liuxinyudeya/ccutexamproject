package org.liuxinyu.project.teacher.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.teacher.entity.Teacher;

import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:13
 */
public interface ITeacher_Service {


    Map<String, Object> addTeacher(Teacher teacher) throws Exception;

    List<Teacher> queryAllTeacher(String key) throws Exception;

    Map<String, Object> updateTeacher(Teacher teacher) throws Exception;
}
