package org.liuxinyu.project.s_student.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.liuxinyu.project.distribution.entity.Tea_Cla_Cou;
import org.liuxinyu.project.paper.mapper.IExam_Dao;
import org.liuxinyu.project.s_student.entity.ClassRank;
import org.liuxinyu.project.s_student.entity.GradeInfo;
import org.liuxinyu.project.s_student.entity.S_Student;
import org.liuxinyu.project.s_student.entity.UpPer;
import org.liuxinyu.project.s_student.mapper.IS_Student_Dao;
import org.liuxinyu.project.student.entity.Student;

import org.liuxinyu.project.t_paper.entity.Paper;

import org.liuxinyu.project.util.controller.UUID_Tools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class S_Student_Service implements IS_Student_Service {
    @Resource
    IS_Student_Dao is_student_dao;
    @Resource
    IExam_Dao iExam_dao;

    @Override
    public List<S_Student> queryCourseList(String studentno) throws Exception {
        List<S_Student> result = new ArrayList<S_Student>();
        List<S_Student> s_students = is_student_dao.queryCourseList(studentno);
        for (S_Student s : s_students) {
            int finshExam = is_student_dao.isFinshExam(studentno, s.getCourseNo());
            s.setFinshExam(finshExam);
            result.add(s);
        }
        return result;
    }

    @Override
    public int calcScore(String data, String studentno) throws Exception {

        Object paperidObject = JSONObject.parseObject(data).get("paperid");
        Object radio = JSONObject.parseObject(data).get("radioList");
        Object checkbox = JSONObject.parseObject(data).get("checkboxList");
        Object judge = JSONObject.parseObject(data).get("judgeList");
        Object fill = JSONObject.parseObject(data).get("fillList");
        String str = JSONObject.toJSONString(paperidObject);
        String paperid = str.substring(1, str.length() - 1);
        List<UpPer> radioList = JSONArray.parseArray(JSONObject.toJSONString(radio), UpPer.class);
        List<UpPer> checkboxList = JSONArray.parseArray(JSONObject.toJSONString(checkbox), UpPer.class);
        List<UpPer> judgeList = JSONArray.parseArray(JSONObject.toJSONString(judge), UpPer.class);
        List<UpPer> fillList = JSONArray.parseArray(JSONObject.toJSONString(fill), UpPer.class);


        int paperScore = 0;
        int radioScore = getScore(radioList);
        int judgeScore = getScore(judgeList);
        int fillScore = getScore(fillList);
        int checkboxScore = getScoreBycheckbox(checkboxList);
        paperScore = radioScore + checkboxScore + judgeScore + fillScore;
        // 向成绩信息表中插入信息
        Student student = is_student_dao.queryStudent(studentno);// 查询学生基本信息
        Paper paper = iExam_dao.queryPaper(paperid);// 查询试卷信息
        GradeInfo gradeInfo = new GradeInfo();
        gradeInfo.setId(UUID_Tools.getUUID());
        gradeInfo.setGrade(student.getGrade());
        gradeInfo.setAcademyName(student.getAcademyName());
        gradeInfo.setAcademyCode(student.getAcademyCode());
        gradeInfo.setMajorName(student.getMajorName());
        gradeInfo.setMajorCode(student.getMajorCode());
        gradeInfo.setClassno(student.getClassno());
        gradeInfo.setStudentno(student.getStudentno());
        gradeInfo.setPaperid(paperid);
        gradeInfo.setCourseno(paper.getCourseno());
        gradeInfo.setScore(paperScore + "");
        is_student_dao.addGradeInfo(gradeInfo);

        return paperScore;

    }

    @Override
    public List<GradeInfo> queryPaper(String studentno) throws Exception {
        List<GradeInfo> result = new ArrayList<GradeInfo>();
        List<GradeInfo> gradeInfos = is_student_dao.queryGradeInfo(studentno);
        for (GradeInfo gradeInfo : gradeInfos) {
            Tea_Cla_Cou tea_cla_cou = is_student_dao.queryTCC(gradeInfo.getCourseno());
            gradeInfo.setCourseName(tea_cla_cou.getCourseName());
            gradeInfo.setTeacherNo(tea_cla_cou.getTeacherno());
            gradeInfo.setTeacherName(tea_cla_cou.getTeacherName());
            HashMap<String, String> map = new HashMap<String, String>();
            String classAvg = is_student_dao.queryClassAvg(gradeInfo.getCourseno());
            List<ClassRank> classRanks = is_student_dao.queryClassRank(gradeInfo.getClassno(), gradeInfo.getCourseno());
            for (ClassRank cr : classRanks) {
                map.put(cr.getStudentno(), cr.getClassrank());
            }
            gradeInfo.setClassAvg(classAvg);
            gradeInfo.setClassrank(map.get(studentno));
            result.add(gradeInfo);
        }

        return result;
    }

    private int getScore(List<UpPer> questionList) {
        int score = 0;
        if (questionList != null && questionList.size() > 0) {
            for (int i = 0; i < questionList.size(); i++) {
                score += is_student_dao.calcScore(questionList.get(i).getAnswer(), questionList.get(i).getQuestionid());
            }
        }
        return score;
    }

    private int getScoreBycheckbox(List<UpPer> questionList) {
        int sum = 0;
        int score = 0;
        List raList = new ArrayList();
        List aList = new ArrayList();
        for (UpPer u : questionList) {
            UpPer upPer = is_student_dao.queryQuestionForCheck(u.getQuestionid());
            String[] realAnswer = upPer.getRealanswers().split(",");
            String[] answer = u.getAnswer().split(",");
            for (String ra : realAnswer) {
                raList.add(ra);
            }
            for (String a : answer) {
                aList.add(a);
            }

            // 如果 正确答案与答案完全相等 则 全分
            // else ; if 只要 answer中一个元素 不属于 realAnswer 则 0分 否则 一半分值
            if (upPer.getRealanswers().equals(u.getAnswer())) {
                score = upPer.getQuestionscore();
            } else {
                for (int i = 0; i < aList.size(); i++) {
                    if (!raList.contains(aList.get(i))) {
                        score = 0;
                    } else {
                        score = upPer.getQuestionscore() / 2;
                    }
                }
            }
            sum += score;

        }
        return sum;
    }

}


