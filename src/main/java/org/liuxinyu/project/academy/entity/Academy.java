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
                ", update_str='" + updatetime_str + '\'' +
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

}
