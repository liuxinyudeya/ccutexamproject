package org.liuxinyu.project.distribution.entity;

import java.util.Date;

/**
 * @author liuxinyu
 * @date 2019/1/30 0030 - 16:27
 */
public class Tea_Cla_Cou {
    private String id;
    private String grade;
    private String academyCode;
    private String academyName;
    private String majorName;
    private String majorCode;
    private String classno;
    private String courseName;
    private String courseno;
    private String teacherno;
    private String teacherName;
    private String examstate;
    private String paperno;
    private String newid;
    private Date updatetime;
    private String updatetime_str;

    @Override
    public String toString() {
        return "Tea_Cla_Cou{" +
                "id='" + id + '\'' +
                ", grade='" + grade + '\'' +
                ", academyCode='" + academyCode + '\'' +
                ", academyName='" + academyName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", majorCode='" + majorCode + '\'' +
                ", classno='" + classno + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseno='" + courseno + '\'' +
                ", teacherno='" + teacherno + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", examstate='" + examstate + '\'' +
                ", paperno='" + paperno + '\'' +
                ", newid='" + newid + '\'' +
                ", updatetime=" + updatetime +
                ", updatetime_str='" + updatetime_str + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getAcademyCode() {
        return academyCode;
    }

    public void setAcademyCode(String academyCode) {
        this.academyCode = academyCode;
    }

    public String getAcademyName() {
        return academyName;
    }

    public void setAcademyName(String academyName) {
        this.academyName = academyName;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getExamstate() {
        return examstate;
    }

    public void setExamstate(String examstate) {
        this.examstate = examstate;
    }

    public String getPaperno() {
        return paperno;
    }

    public void setPaperno(String paperno) {
        this.paperno = paperno;
    }

    public String getNewid() {
        return newid;
    }

    public void setNewid(String newid) {
        this.newid = newid;
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
}
