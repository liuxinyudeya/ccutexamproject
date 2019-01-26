package org.liuxinyu.project.cla.mapper;


import org.liuxinyu.project.academy.entity.Academy;

import java.util.List;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:10
 */
public interface ICla_Dao {


    void addCla(Academy academy);

    List<Academy> queryAllCla(String key);

    void updateCla(Academy academy);
}
