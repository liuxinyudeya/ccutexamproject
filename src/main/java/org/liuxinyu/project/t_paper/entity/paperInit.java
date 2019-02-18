package org.liuxinyu.project.t_paper.entity;

public class paperInit {

    private double count;
    private double level;
    private double score;
    private String questionTypeCode;

    private double paperLevel;
    private double paperCount;
    private double paperScore;

    private double radioCount;
    private double checkboxCount;
    private double judgeCount;
    private double fillCount;

    @Override
    public String toString() {
        return "paperInit{" +
                "count=" + count +
                ", level=" + level +
                ", score=" + score +
                ", questionTypeCode='" + questionTypeCode + '\'' +
                ", paperLevel=" + paperLevel +
                ", paperCount=" + paperCount +
                ", paperScore=" + paperScore +
                ", radioCount=" + radioCount +
                ", checkboxCount=" + checkboxCount +
                ", judgeCount=" + judgeCount +
                ", fillCount=" + fillCount +
                '}';
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public double getLevel() {
        return level;
    }

    public void setLevel(double level) {
        this.level = level;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getQuestionTypeCode() {
        return questionTypeCode;
    }

    public void setQuestionTypeCode(String questionTypeCode) {
        this.questionTypeCode = questionTypeCode;
    }

    public double getPaperLevel() {
        return paperLevel;
    }

    public void setPaperLevel(double paperLevel) {
        this.paperLevel = paperLevel;
    }

    public double getPaperCount() {
        return paperCount;
    }

    public void setPaperCount(double paperCount) {
        this.paperCount = paperCount;
    }

    public double getPaperScore() {
        return paperScore;
    }

    public void setPaperScore(double paperScore) {
        this.paperScore = paperScore;
    }

    public double getRadioCount() {
        return radioCount;
    }

    public void setRadioCount(double radioCount) {
        this.radioCount = radioCount;
    }

    public double getCheckboxCount() {
        return checkboxCount;
    }

    public void setCheckboxCount(double checkboxCount) {
        this.checkboxCount = checkboxCount;
    }

    public double getJudgeCount() {
        return judgeCount;
    }

    public void setJudgeCount(double judgeCount) {
        this.judgeCount = judgeCount;
    }

    public double getFillCount() {
        return fillCount;
    }

    public void setFillCount(double fillCount) {
        this.fillCount = fillCount;
    }
}
