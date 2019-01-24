package org.liuxinyu.project.academy.mapper;

import com.mysql.jdbc.UpdatableResultSet;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.util.entity.LayuiTable;

import java.util.List;

public interface IAcademy_Dao {

    void addAcademyByOne(Academy academy) throws Exception ;

    List<Academy> queryAllAcademy (String key) throws Exception ;

    void updateAcademy(Academy academy) throws Exception ;
}
