package org.liuxinyu.project.course.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.cla.mapper.ICla_Dao;
import org.liuxinyu.project.cla.service.ICla_Service;
import org.liuxinyu.project.course.entity.Course;
import org.liuxinyu.project.course.mapper.ICourse_Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:14
 */
@Service
@Transactional
public class Course_Service implements ICourse_Service {


    @Resource
    ICourse_Dao icourse_dao;


    public Map<String, Object> addCourse(Course course) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        course.setCourseno(course.getCourseCode() + course.getGrade() + course.getAcademyCode() + course.getMajorCode()); // 设置主键id : 课程编号+年级+学院编号+专业编号 确保唯一

        try {
            icourse_dao.addCourse(course);
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已录入该信息");
            return stringObjectHashMap;
        }


        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "添加成功");
        return stringObjectHashMap;
    }

    public List<Course> queryAllCourse(String key) throws Exception {

        return icourse_dao.queryAllCourse(key);
    }

    public List<Course> queryCourse(String graed, String academyCode, String majorCode) throws Exception {
        return icourse_dao.queryCourse(graed,academyCode,majorCode);
    }

    public Map<String, Object> updateCourse(Course course) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        course.setNewcourseno(course.getCourseCode() + course.getGrade() + course.getAcademyCode() + course.getMajorCode()); // 设置主键id : 课程编号+年级+学院编号+专业编号 确保唯一
        icourse_dao.updateCourse(course);
        try {

        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已有[" + course.getNewcourseno() + "]编号的课程");
            return stringObjectHashMap;
        }

        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "更新成功");
        return stringObjectHashMap;
    }
}
