package org.liuxinyu.project.major.service;

import org.liuxinyu.project.major.mapper.IMajor_Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:14
 */
@Service
@Transactional
public class Major_Service implements IMajor_Service {

    @Resource
    IMajor_Dao iMajor_dao;

    public List<String> gradeInit() throws Exception {
        List<String> gradeList = iMajor_dao.queryGradeKind();
        return gradeList;
    }
}
