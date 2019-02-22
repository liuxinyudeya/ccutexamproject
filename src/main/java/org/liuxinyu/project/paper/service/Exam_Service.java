package org.liuxinyu.project.paper.service;

import org.liuxinyu.project.paper.entity.Exam;
import org.liuxinyu.project.paper.mapper.IExam_Dao;
import org.liuxinyu.project.t_paper.entity.Paper;
import org.liuxinyu.project.t_paper.entity.Question;
import org.liuxinyu.project.t_paper.mapper.T_Paper_Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class Exam_Service implements IExam_Service {

    @Resource
    IExam_Dao iExam_dao;
    @Resource
    T_Paper_Dao t_paper_dao;

    @Override
    public Exam queryExam(String paperid) throws Exception {
        Exam exam = new Exam();
        String questionTypeCode="";
        // 根据试卷id查询 所有类型试题ID集合
        List<String> redioids = iExam_dao.queryQuestionID(paperid, "01");
        List<String> checkboxids = iExam_dao.queryQuestionID(paperid, "02");
        List<String> judgeids = iExam_dao.queryQuestionID(paperid, "03");
        List<String> fillids = iExam_dao.queryQuestionID(paperid, "04");
        // 各个类型试题集合
        exam.setRedioList(getQUestionList(redioids));
        exam.setCheckboxList(getQUestionList(checkboxids));
        exam.setJudgeList(getQUestionList(judgeids));
        exam.setFillList(getQUestionList(fillids));
        Paper paper = iExam_dao.queryPaper(paperid);
        exam.setTestTime(paper.getTestTime()); // 开考时间
        exam.setMinuteCount(paper.getMinuteCount()); // 时长
        return exam;
    }

    private List<Question> getQUestionList(List<String> IdList) {
        List<Question> questionList = new ArrayList<Question>();
        if (IdList != null && IdList.size() > 0) {
            for (String r : IdList) {
                Question question = new Question();
                question = t_paper_dao.queryQuestion(r);
                questionList.add(question);
            }
        }
        return questionList;
    }
}
