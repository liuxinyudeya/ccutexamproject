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
        List<CourseInfo> courseInfos = courseInfo_dao.queryCourseList(teacherno);
        for(CourseInfo c:courseInfos){
            String courseno = c.getCourseno();
            CourseInfo querypaperbycon = courseInfo_dao.querypaperbycon(courseno);
            c.setPaperno(querypaperbycon.getPaperno());
            c.setExamstate(querypaperbycon.getExamstate());
            c.setScore(querypaperbycon.getScore());
            c.setLevel(querypaperbycon.getLevel());
        }
        return courseInfos;
    }
}
