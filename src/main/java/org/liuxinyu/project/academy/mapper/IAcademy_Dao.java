package org.liuxinyu.project.academy.mapper;

import org.liuxinyu.project.academy.entity.Academy;

import java.util.List;

public interface IAcademy_Dao {

    void addAcademyByOne(Academy academy) throws Exception ;

    List<Academy> queryAllAcademy () throws Exception ;
}
