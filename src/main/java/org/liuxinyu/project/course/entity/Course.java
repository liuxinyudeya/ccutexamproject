package org.liuxinyu.project.course.entity;

import java.util.Date;

/**
 * @author liuxinyu
 * @date 2019/1/28 0028 - 11:07
 */
public class Course {
    private String courseno;
    private String grade;
    private String academyName;
    private String academyCode;
    private String majorName;
    private String majorCode;
    private String courseName;
    private String courseCode;
    private Date updatetime;
    private String updatetime_str;
    private String isdelete;
    private String newcourseno;

    @Override
    public String toString() {
        return "Course{" +
                "courseno='" + courseno + '\'' +
                ", grade='" + grade + '\'' +
                ", academyName='" + academyName + '\'' +
                ", academyCode='" + academyCode + '\'' +
                ", majorName='" + majorName + '\'' +
                ", majorCode='" + majorCode + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", updatetime=" + updatetime +
                ", updatetime_str='" + updatetime_str + '\'' +
                ", isdelete='" + isdelete + '\'' +
                ", newcourseno='" + newcourseno + '\'' +
                '}';
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdatetime_str() {
        return updatetime_str;
    }

    public void setUpdatetime_str(String updatetime_str) {
        this.updatetime_str = updatetime_str;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }

    public String getNewcourseno() {
        return newcourseno;
    }

    public void setNewcourseno(String newcourseno) {
        this.newcourseno = newcourseno;
    }
}
