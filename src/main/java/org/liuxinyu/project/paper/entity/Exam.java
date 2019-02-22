package org.liuxinyu.project.paper.entity;

import org.liuxinyu.project.t_paper.entity.Question;

import java.util.Date;
import java.util.List;

public class Exam {
    private String paperid;
    private Date testTime;
    private String testTime_str;
    private String minuteCount;
    private List<Question> redioList;
    private List<Question> checkboxList;
    private List<Question> judgeList;
    private List<Question> fillList;

    @Override
    public String toString() {
        return "Exam{" +
                "paperid='" + paperid + '\'' +
                ", testTime=" + testTime +
                ", testTime_str='" + testTime_str + '\'' +
                ", minuteCount='" + minuteCount + '\'' +
                ", redioList=" + redioList +
                ", checkboxList=" + checkboxList +
                ", judgeList=" + judgeList +
                ", fillList=" + fillList +
                '}';
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
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

    public String getMinuteCount() {
        return minuteCount;
    }

    public void setMinuteCount(String minuteCount) {
        this.minuteCount = minuteCount;
    }

    public List<Question> getRedioList() {
        return redioList;
    }

    public void setRedioList(List<Question> redioList) {
        this.redioList = redioList;
    }

    public List<Question> getCheckboxList() {
        return checkboxList;
    }

    public void setCheckboxList(List<Question> checkboxList) {
        this.checkboxList = checkboxList;
    }

    public List<Question> getJudgeList() {
        return judgeList;
    }

    public void setJudgeList(List<Question> judgeList) {
        this.judgeList = judgeList;
    }

    public List<Question> getFillList() {
        return fillList;
    }

    public void setFillList(List<Question> fillList) {
        this.fillList = fillList;
    }
}
