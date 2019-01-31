package org.liuxinyu.project.distribution.mapper;


import org.liuxinyu.project.distribution.entity.Tea_Cla_Cou;
import org.liuxinyu.project.student.entity.Student;

import java.util.List;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:10
 */
public interface ITea_Cla_Cou_Dao {


    void addTea_Cla_Cou(Tea_Cla_Cou tea_cla_cou);

    List<Tea_Cla_Cou> queryAllTea_Cla_Cou(String key);

    void updateTea_Cla_Cou(Tea_Cla_Cou tea_cla_cou);
}
