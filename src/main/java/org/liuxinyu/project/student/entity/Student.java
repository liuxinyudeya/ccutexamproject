package org.liuxinyu.project.student.entity;

import java.util.Date;

/**
 * @author liuxinyu
 * @date 2019/1/30 0030 - 13:36
 */
public class Student {
    private String newstudentno;
    private String studentno;
    private String grade;
    private String academyName;
    private String academyCode;
    private String majorName;
    private String majorCode;
    private String classno;
    private String name;
    private String sex;
    private String isdelete;
    private String updatetime_str;
    private Date updatetime;

    @Override
    public String toString() {
        return "Student{" +
                "newstudentno='" + newstudentno + '\'' +
                ", studentno='" + studentno + '\'' +
                ", grade='" + grade + '\'' +
                ", academyName='" + academyName + '\'' +
                ", academyCode='" + academyCode + '\'' +
                ", majorName='" + majorName + '\'' +
                ", majorCode='" + majorCode + '\'' +
                ", classno='" + classno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", isdelete='" + isdelete + '\'' +
                ", updatetime_str='" + updatetime_str + '\'' +
                ", updatetime=" + updatetime +
                '}';
    }

    public String getNewstudentno() {
        return newstudentno;
    }

    public void setNewstudentno(String newstudentno) {
        this.newstudentno = newstudentno;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
    }

    public String getAcademyCode() {
        return academyCode;
    }

    public void setAcademyCode(String academyCode) {
        this.academyCode = academyCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getUpdatetime_str() {
        return updatetime_str;
    }

    public void setUpdatetime_str(String updatetime_str) {
        this.updatetime_str = updatetime_str;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}
