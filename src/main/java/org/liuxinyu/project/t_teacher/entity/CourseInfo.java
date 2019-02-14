package org.liuxinyu.project.t_teacher.entity;

public class CourseInfo {
    private String id;
    private String teacherno;
    private String grade;
    private String courseName;
    private String courseno;
    private String classno;
    private String academyName;
    private String majorName;
    private int stuCount; // 班级学生个数
    private String paperno; // 试卷编号
    private boolean examstate; // 考试状态
    private String updatetime_str; // 最后修改时间
    private String examCode; // 考试码

    @Override
    public String toString() {
        return "CourseInfo{" +
                "id='" + id + '\'' +
                ", teacherno='" + teacherno + '\'' +
                ", grade='" + grade + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseno='" + courseno + '\'' +
                ", classno='" + classno + '\'' +
                ", academyName='" + academyName + '\'' +
                ", majorName='" + majorName + '\'' +
                ", stuCount=" + stuCount +
                ", paperno='" + paperno + '\'' +
                ", examstate=" + examstate +
                ", updatetime_str='" + updatetime_str + '\'' +
                ", examCode='" + examCode + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
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

    public String getClassno() {
        return classno;
    }

    public void setClassno(String classno) {
        this.classno = classno;
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

    public int getStuCount() {
        return stuCount;
    }

    public void setStuCount(int stuCount) {
        this.stuCount = stuCount;
    }

    public String getPaperno() {
        return paperno;
    }

    public void setPaperno(String paperno) {
        this.paperno = paperno;
    }


    public boolean isExamstate() {
        return examstate;
    }

    public void setExamstate(boolean examstate) {
        this.examstate = examstate;
    }

    public String getUpdatetime_str() {
        return updatetime_str;
    }

    public void setUpdatetime_str(String updatetime_str) {
        this.updatetime_str = updatetime_str;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }
}
