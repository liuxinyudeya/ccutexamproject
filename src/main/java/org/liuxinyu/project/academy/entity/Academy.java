package org.liuxinyu.project.academy.entity;

import java.util.Date;

public class Academy {
    private String id;
    private String academyName;
    private String academyCode;
    private Date updatetime;
    private String grade;
    private String department;
    private String isdelete;
    private String updatetime_str;
    private String majorName;
    private String majorCode;
    private String managerid;
    private String newid;
    private String classno;

    @Override
    public String toString() {
        return "Academy{" +
                "id='" + id + '\'' +
                ", academyName='" + academyName + '\'' +
                ", academyCode='" + academyCode + '\'' +
                ", updatetime=" + updatetime +
                ", grade='" + grade + '\'' +
                ", department='" + department + '\'' +
                ", isdelete='" + isdelete + '\'' +
                ", updatetime_str='" + updatetime_str + '\'' +
                ", majorName='" + majorName + '\'' +
                ", majorCode='" + majorCode + '\'' +
                ", managerid='" + managerid + '\'' +
                ", newid='" + newid + '\'' +
                ", classno='" + classno + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
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

    public String getManagerid() {
        return managerid;
    }

    public void setManagerid(String managerid) {
        this.managerid = managerid;
    }

    public String getNewid() {
        return newid;
    }

    public void setNewid(String newid) {
        this.newid = newid;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }
}
