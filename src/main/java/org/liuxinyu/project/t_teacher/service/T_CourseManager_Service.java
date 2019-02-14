package org.liuxinyu.project.t_teacher.service;

import org.liuxinyu.project.t_teacher.entity.CourseInfo;
import org.liuxinyu.project.t_teacher.mapper.CourseInfo_Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class T_CourseManager_Service implements T_CourseManager_IService {

    @Resource
    CourseInfo_Dao courseInfo_dao;

    public List<CourseInfo> queryCourseLIst(String teacherno) throws Exception {
        return courseInfo_dao.queryCourseList(teacherno);

    }
}
