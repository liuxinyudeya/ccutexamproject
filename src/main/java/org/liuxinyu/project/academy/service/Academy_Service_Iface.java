package org.liuxinyu.project.academy.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.util.entity.LayuiTable;

import java.util.List;
import java.util.Map;

public interface Academy_Service_Iface {

    Map<String,Object> addAcademy(Academy academy) throws Exception ;

    List<Academy> queryAllAcademy() throws Exception ;

    Map<String,Object>  updateAcademy(Academy academy) throws Exception ;
}
