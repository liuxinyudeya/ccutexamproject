package org.liuxinyu.project.distribution.service;

import org.liuxinyu.project.distribution.entity.Tea_Cla_Cou;
import org.liuxinyu.project.student.entity.Student;

import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:13
 */
public interface ITea_Cla_Cou_Service {


    Map<String, Object> addTea_Cla_Cou(Tea_Cla_Cou tea_cla_cou) throws Exception;

    List<Tea_Cla_Cou> queryAllTea_Cla_Cou(String key) throws Exception;

    Map<String, Object> updateTea_Cla_Cou(Tea_Cla_Cou tea_cla_cou) throws Exception;
}
