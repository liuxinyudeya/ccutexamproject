package org.liuxinyu.project.t_paper.entity;


import java.util.List;

public class Question {

    private String paperid;
    private String id; // 题目ID
    private String questionTypeName; // 题目类型名称
    private String questionTypeCode; // 题目类型编码
    private String questionLevel; // 题目难度等级
    private double questionScore; // 题目分数
    private String questionDesc; // 题目描述
    private String A; // A选项
    private String B; // B选项
    private String C; // C选项
    private String D; // D选项
    private String realAnswers; // 正确答案
    private String AId; // A选项
    private String BId; // B选项
    private String CId; // C选项
    private String DId; // D选项


    private List<Answer> Answers;
    private String courseno;

    @Override
    public String toString() {
        return "Question{" +
                "paperid='" + paperid + '\'' +
                ", id='" + id + '\'' +
                ", questionTypeName='" + questionTypeName + '\'' +
                ", questionTypeCode='" + questionTypeCode + '\'' +
                ", questionLevel='" + questionLevel + '\'' +
                ", questionScore=" + questionScore +
                ", questionDesc='" + questionDesc + '\'' +
                ", A='" + A + '\'' +
                ", B='" + B + '\'' +
                ", C='" + C + '\'' +
                ", D='" + D + '\'' +
                ", realAnswers='" + realAnswers + '\'' +
                ", AId='" + AId + '\'' +
                ", BId='" + BId + '\'' +
                ", CId='" + CId + '\'' +
                ", DId='" + DId + '\'' +
                ", Answers=" + Answers +
                ", courseno='" + courseno + '\'' +
                '}';
    }

    public String getCourseno() {
        return courseno;
    }

    public void setCourseno(String courseno) {
        this.courseno = courseno;
    }

    public String getPaperid() {
        return paperid;
    }

    public void setPaperid(String paperid) {
        this.paperid = paperid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestionTypeName() {
        return questionTypeName;
    }

    public void setQuestionTypeName(String questionTypeName) {
        this.questionTypeName = questionTypeName;
    }

    public String getQuestionTypeCode() {
        return questionTypeCode;
    }

    public void setQuestionTypeCode(String questionTypeCode) {
        this.questionTypeCode = questionTypeCode;
    }

    public String getQuestionLevel() {
        return questionLevel;
    }

    public void setQuestionLevel(String questionLevel) {
        this.questionLevel = questionLevel;
    }

    public double getQuestionScore() {
        return questionScore;
    }

    public void setQuestionScore(double questionScore) {
        this.questionScore = questionScore;
    }

    public String getQuestionDesc() {
        return questionDesc;
    }

    public void setQuestionDesc(String questionDesc) {
        this.questionDesc = questionDesc;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getRealAnswers() {
        return realAnswers;
    }

    public void setRealAnswers(String realAnswers) {
        this.realAnswers = realAnswers;
    }

    public List<Answer> getAnswers() {
        return Answers;
    }

    public void setAnswers(List<Answer> answers) {
        Answers = answers;
    }

    public String getAId() {
        return AId;
    }

    public void setAId(String AId) {
        this.AId = AId;
    }

    public String getBId() {
        return BId;
    }

    public void setBId(String BId) {
        this.BId = BId;
    }

    public String getCId() {
        return CId;
    }

    public void setCId(String CId) {
        this.CId = CId;
    }

    public String getDId() {
        return DId;
    }

    public void setDId(String DId) {
        this.DId = DId;
    }
}
