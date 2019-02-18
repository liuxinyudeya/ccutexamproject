package org.liuxinyu.project.t_paper.service;

import org.liuxinyu.project.distribution.entity.Tea_Cla_Cou;
import org.liuxinyu.project.distribution.mapper.ITea_Cla_Cou_Dao;
import org.liuxinyu.project.t_paper.entity.Answer;
import org.liuxinyu.project.t_paper.entity.Paper;
import org.liuxinyu.project.t_paper.entity.Question;
import org.liuxinyu.project.t_paper.entity.paperInit;
import org.liuxinyu.project.t_paper.mapper.T_Paper_Dao;
import org.liuxinyu.project.util.controller.UUID_Tools;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class T_PaperManager_Service implements T_PaperManager_IService {
    @Resource
    T_Paper_Dao t_paper_dao;
    @Resource
    ITea_Cla_Cou_Dao tea_cla_cou_dao;

    public Map<String, Object> addQuestion(Question question) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String questionID = UUID_Tools.getUUID();
        question.setId(questionID);
        // 插入题目
        t_paper_dao.addQuestion(question);
        // 插入答案
        switch (question.getQuestionTypeCode()) {
            case "01":
            case "02":
                q("A", question.getA(), questionID);
                q("B", question.getB(), questionID);
                q("C", question.getC(), questionID);
                q("D", question.getD(), questionID);
                break;
            case "03":
                q("", "true", questionID);
                q("", "false", questionID);
                break;
            case "04":
                q("", question.getRealAnswers(), questionID);
                break;
        }

        resultMap.put("state", "0");
        resultMap.put("message", "执行成功");
        return resultMap;
    }

    @Override
    public Map<String, Object> setPaper(Paper paper) throws Exception {
        Map<String, Object> resultMap = new HashMap<String, Object>();
        String s = t_paper_dao.verifyPaper(paper.getId());
        if (s == null) {

            List<paperInit> paperInits = t_paper_dao.queryPaper(paper.getId());
            paperInit paperInit = new paperInit();
            double paperLevel = 0.0;
            double paperScore = 0.0;
            for (int i = 0; i < paperInits.size(); i++) {
                paperInit paperInit01 = paperInits.get(i);
                paperScore += paperInit01.getScore();
                paperLevel += paperInit01.getLevel();
            }
            paper.setLevel(paperScore + "");
            paper.setScore(paperScore + "");

            String id = paper.getTea_cla_couid(); // 查询Tea_Cla_Cou基本信息
            Tea_Cla_Cou tea_cla_cou = tea_cla_cou_dao.queryTea_Cla_Cou(id);
            paper.setPaperNo(UUID_Tools.getpaperno(6)); // 生成考试码
            paper.setClassno(tea_cla_cou.getClassno());
            paper.setTeacherno(tea_cla_cou.getTeacherno());
            paper.setCourseno(tea_cla_cou.getCourseno());

            paper.setExamstate("未考试");
            paper.setPaperstate("已出卷");
            t_paper_dao.setPaper(paper);
        } else {
            resultMap.put("state", "1");
            resultMap.put("message", "已经生成该试卷");
            return resultMap;
        }
        resultMap.put("state", "0");
        resultMap.put("message", "执行成功");
        return resultMap;
    }

    @Override
    public void updateQuestion(Question question) throws Exception {

        t_paper_dao.updateQuestion(question);
        System.out.println(question.getQuestionTypeCode());
        System.out.println(question.getQuestionTypeCode().equals("01") || question.getQuestionTypeCode().equals("02"));
        if (question.getQuestionTypeCode().equals("01") || question.getQuestionTypeCode().equals("02")) {
            t_paper_dao.updateAnswer(question.getA(), question.getAId());
            t_paper_dao.updateAnswer(question.getB(), question.getBId());
            t_paper_dao.updateAnswer(question.getC(), question.getCId());
            t_paper_dao.updateAnswer(question.getD(), question.getDId());
        }
    }

    @Override
    public void delQuestion(String questionId) throws Exception {
        t_paper_dao.delQuestion(questionId);
    }

    private void q(String answerCode, String answerName, String questionID) {
        Answer answer = new Answer();
        answer.setId(UUID_Tools.getUUID());
        answer.setAnswerCode(answerCode);
        answer.setAnswerName(answerName);
        answer.setQuestionId(questionID);
        t_paper_dao.addAnswer(answer);
    }

    public Paper isexistPaper(String courseid) {
        String paperid = ""; // 试卷id 根据courseno 查询paper表 如果没有唯一结果 则向paper表中添加一条数据
        List<Paper> paperList = t_paper_dao.queryPaperByCourseId(courseid);
        if (paperList.size() < 1) {
            // 向paper中添加一条记录
            String id = UUID_Tools.getUUID();
            t_paper_dao.addOnePaper(id, courseid);
            paperid = id;
        }
        return paperList.get(0);
    }

    @Override
    public List<Question> queryAllQuestion(String paperid) throws Exception {
        List<Question> questionList = t_paper_dao.queryAllQuestion(paperid);
        return questionList;
    }

    @Override
    public Question queryQuestion(String questionid) throws Exception {
        Question questions = t_paper_dao.queryQuestion(questionid);
        return questions;
    }

    @Override
    public paperInit queryPaper(String paperid) throws Exception {
        List<paperInit> paperInits = t_paper_dao.queryPaper(paperid);
        paperInit paperInit = new paperInit();
        double paperLevel = 0.0;
        double paperCount = 0.0;
        double paperScore = 0.0;
        for (int i = 0; i < paperInits.size(); i++) {

            if (paperInits.get(i).getQuestionTypeCode().equals("01")) {
                paperInit.setRadioCount(paperInits.get(i).getCount());
            } else if (paperInits.get(i).getQuestionTypeCode().equals("02")) {
                paperInit.setCheckboxCount(paperInits.get(i).getCount());
            } else if (paperInits.get(i).getQuestionTypeCode().equals("03")) {
                paperInit.setJudgeCount(paperInits.get(i).getCount());
            }
            if (paperInits.get(i).getQuestionTypeCode().equals("04")) {
                paperInit.setFillCount(paperInits.get(i).getCount());
            }
            paperInit paperInit01 = paperInits.get(i);
            paperCount += paperInit01.getCount();
            paperScore += paperInit01.getScore();
            paperLevel += paperInit01.getLevel();
        }
        paperInit.setPaperCount(paperCount);
        paperInit.setPaperScore(paperScore);
        paperInit.setPaperLevel(paperLevel / 4);
        return paperInit;
    }
}
