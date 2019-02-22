package org.liuxinyu.project.s_student.entity;

import java.util.Date;

public class GradeInfo {
    private String id;
    private String studentno;
    private String classno;
    private String paperid;
    private String courseno;
    private String grade;
    private String academyCode;
    private String academyName;
    private String majorCode;
    private String majorName;
    private String score;
    private Date uptime;
    private String rank;
    private Date testTime;

    private String courseName;
    private String teacherName;
    private String teacherNo;
    private String classAvg;
    private String classrank;

    @Override
    public String toString() {
        return "GradeInfo{" +
                "id='" + id + '\'' +
                ", studentno='" + studentno + '\'' +
                ", classno='" + classno + '\'' +
                ", paperid='" + paperid + '\'' +
                ", courseno='" + courseno + '\'' +
                ", grade='" + grade + '\'' +
                ", academyCode='" + academyCode + '\'' +
                ", academyName='" + academyName + '\'' +
                ", majorCode='" + majorCode + '\'' +
                ", majorName='" + majorName + '\'' +
                ", score='" + score + '\'' +
                ", uptime=" + uptime +
                ", rank='" + rank + '\'' +
                ", testTime=" + testTime +
                ", courseName='" + courseName + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", classAvg='" + classAvg + '\'' +
                ", classrank='" + classrank + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
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

    public String getMajorCode() {
        return majorCode;
    }

    public void setMajorCode(String majorCode) {
        this.majorCode = majorCode;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getUptime() {
        return uptime;
    }

    public void setUptime(Date uptime) {
        this.uptime = uptime;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getClassAvg() {
        return classAvg;
    }

    public void setClassAvg(String classAvg) {
        this.classAvg = classAvg;
    }

    public String getClassrank() {
        return classrank;
    }

    public void setClassrank(String classrank) {
        this.classrank = classrank;
    }
}
