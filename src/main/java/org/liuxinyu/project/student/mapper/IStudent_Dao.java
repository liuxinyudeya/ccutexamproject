package org.liuxinyu.project.student.mapper;


import org.liuxinyu.project.student.entity.Student;

import java.util.List;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:10
 */
public interface IStudent_Dao {


    void addStudent(Student student);

    List<Student> queryAllStudent(String key);

    List<Student> queryStudentByStuno(String studentno);

    void updateStudent(Student student);
}
