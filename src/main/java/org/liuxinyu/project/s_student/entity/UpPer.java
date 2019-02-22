package org.liuxinyu.project.s_student.entity;

public class UpPer {
    private String answer;
    private String questionid;
    private int questionscore;
    private String realanswers;

    @Override
    public String toString() {
        return "UpPer{" +
                "answer='" + answer + '\'' +
                ", questionid='" + questionid + '\'' +
                ", questionscore=" + questionscore +
                ", realanswers='" + realanswers + '\'' +
                '}';
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getQuestionid() {
        return questionid;
    }

    public void setQuestionid(String questionid) {
        this.questionid = questionid;
    }

    public int getQuestionscore() {
        return questionscore;
    }

    public void setQuestionscore(int questionscore) {
        this.questionscore = questionscore;
    }

    public String getRealanswers() {
        return realanswers;
    }

    public void setRealanswers(String realanswers) {
        this.realanswers = realanswers;
    }
}
