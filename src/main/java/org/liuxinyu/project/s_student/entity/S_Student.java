package org.liuxinyu.project.s_student.entity;

import java.util.Date;

public class S_Student {
    private String id;
    private String courseNo;
    private String courseName;
    private String teacherNo;
    private String teacherName;
    private String score;
    private String level;
    private String minuteCount;
    private Date testTime;
    private String testTime_str;
    private String paperno;
    private String examstate;

    @Override
    public String toString() {
        return "S_Student{" +
                "id='" + id + '\'' +
                ", courseNo='" + courseNo + '\'' +
                ", courseName='" + courseName + '\'' +
                ", teacherNo='" + teacherNo + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", score='" + score + '\'' +
                ", level='" + level + '\'' +
                ", minuteCount='" + minuteCount + '\'' +
                ", testTime=" + testTime +
                ", testTime_str='" + testTime_str + '\'' +
                ", paperno='" + paperno + '\'' +
                ", examstate='" + examstate + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseNo() {
        return courseNo;
    }

    public void setCourseNo(String courseNo) {
        this.courseNo = courseNo;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherNo() {
        return teacherNo;
    }

    public void setTeacherNo(String teacherNo) {
        this.teacherNo = teacherNo;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMinuteCount() {
        return minuteCount;
    }

    public void setMinuteCount(String minuteCount) {
        this.minuteCount = minuteCount;
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public String getTestTime_str() {
        return testTime_str;
    }

    public void setTestTime_str(String testTime_str) {
        this.testTime_str = testTime_str;
    }

    public String getPaperno() {
        return paperno;
    }

    public void setPaperno(String paperno) {
        this.paperno = paperno;
    }

    public String getExamstate() {
        return examstate;
    }

    public void setExamstate(String examstate) {
        this.examstate = examstate;
    }
}
