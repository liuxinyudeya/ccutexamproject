package org.liuxinyu.project.major.service;

import org.liuxinyu.project.academy.entity.Academy;

import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:13
 */
public interface IMajor_Service {
    List<String> gradeInit() throws Exception;

    List<Academy> academyInit(String managerid, String department) throws Exception;

    Map<String, Object> addMajor(Academy academy) throws Exception;

    List<Academy> queryAllMajor(String key) throws Exception;

    Map<String, Object> updateMajor(Academy academy) throws Exception;
}
