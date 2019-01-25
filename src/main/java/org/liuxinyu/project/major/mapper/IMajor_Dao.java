package org.liuxinyu.project.major.mapper;

import org.liuxinyu.project.academy.entity.Academy;

import java.util.List;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:10
 */
public interface IMajor_Dao {

    List<String> queryGradeKind() ;

    List<Academy> queryAcademyKind(String grade) ;

    void addMajor(Academy academy) ;

    List<Academy> queryAllMajor(String key) ;
}
