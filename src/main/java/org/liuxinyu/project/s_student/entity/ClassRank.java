package org.liuxinyu.project.s_student.entity;

public class ClassRank {
    private String studentno;
    private String classrank;

    @Override
    public String toString() {
        return "ClassRank{" +
                "studentno='" + studentno + '\'' +
                ", classrank='" + classrank + '\'' +
                '}';
    }

    public String getStudentno() {
        return studentno;
    }

    public void setStudentno(String studentno) {
        this.studentno = studentno;
    }

    public String getClassrank() {
        return classrank;
    }

    public void setClassrank(String classrank) {
        this.classrank = classrank;
    }
}
