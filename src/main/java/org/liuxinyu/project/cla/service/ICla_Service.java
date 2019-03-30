package org.liuxinyu.project.cla.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:13
 */
public interface ICla_Service {


    Map<String, Object> addCla(Academy academy) throws Exception;

    List<Academy> queryAllCla(String key) throws Exception;

    Map<String, Object> updateCla(Academy academy) throws Exception;

    HashMap<String, Object> uploadExcle(MultipartFile file) throws Exception ;
}
