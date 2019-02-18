package org.liuxinyu.project.t_paper.entity;

import java.awt.print.PrinterAbortException;

public class Answer {
    private String id;
    private String questionId;
    private String answerCode;
    private String answerName;
    private String answerid;

    @Override
    public String toString() {
        return "Answer{" +
                "id='" + id + '\'' +
                ", questionId='" + questionId + '\'' +
                ", answerCode='" + answerCode + '\'' +
                ", answerName='" + answerName + '\'' +
                ", answerid='" + answerid + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getAnswerCode() {
        return answerCode;
    }

    public void setAnswerCode(String answerCode) {
        this.answerCode = answerCode;
    }

    public String getAnswerName() {
        return answerName;
    }

    public void setAnswerName(String answerName) {
        this.answerName = answerName;
    }

    public String getAnswerid() {
        return answerid;
    }

    public void setAnswerid(String answerid) {
        this.answerid = answerid;
    }
}
