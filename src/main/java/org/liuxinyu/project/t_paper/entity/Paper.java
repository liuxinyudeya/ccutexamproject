package org.liuxinyu.project.t_paper.entity;

import javax.print.DocFlavor;
import java.util.Date;

public class Paper {
    private String id;
    private String classno;
    private String teacherno;
    private String courseno;
    private String testTime_str;
    private Date testTime;
    private String minuteCount;
    private String paperNo;
    private String examstate;
    private String paperstate;
    private String paperid;
    private String tea_cla_couid;
    private String level;
    private String score;
    private Date endTime;
    private String endTime_str;


    @Override
    public String toString() {
        return "Paper{" +
                "id='" + id + '\'' +
                ", classno='" + classno + '\'' +
                ", teacherno='" + teacherno + '\'' +
                ", courseno='" + courseno + '\'' +
                ", testTime_str='" + testTime_str + '\'' +
                ", testTime=" + testTime +
                ", minuteCount='" + minuteCount + '\'' +
                ", paperNo='" + paperNo + '\'' +
                ", examstate='" + examstate + '\'' +
                ", paperstate='" + paperstate + '\'' +
                ", paperid='" + paperid + '\'' +
                ", tea_cla_couid='" + tea_cla_couid + '\'' +
                ", level='" + level + '\'' +
                ", score='" + score + '\'' +
                ", endTime=" + endTime +
                ", endTime_str='" + endTime_str + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
    }

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno;
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getTestTime_str() {
        return testTime_str;
    }

    public void setTestTime_str(String testTime_str) {
        this.testTime_str = testTime_str;
    }

    public String getMinuteCount() {
        return minuteCount;
    }

    public void setMinuteCount(String minuteCount) {
        this.minuteCount = minuteCount;
    }

    public String getPaperNo() {
        return paperNo;
    }

    public void setPaperNo(String paperNo) {
        this.paperNo = paperNo;
    }

    public String getExamstate() {
        return examstate;
    }

    public void setExamstate(String examstate) {
        this.examstate = examstate;
    }

    public String getPaperstate() {
        return paperstate;
    }

    public void setPaperstate(String paperstate) {
        this.paperstate = paperstate;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public String getTea_cla_couid() {
        return tea_cla_couid;
    }

    public void setTea_cla_couid(String tea_cla_couid) {
        this.tea_cla_couid = tea_cla_couid;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getEndTime_str() {
        return endTime_str;
    }

    public void setEndTime_str(String endTime_str) {
        this.endTime_str = endTime_str;
    }
}
