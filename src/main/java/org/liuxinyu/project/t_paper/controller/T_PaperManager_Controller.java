package org.liuxinyu.project.t_paper.controller;

import com.alibaba.fastjson.JSON;
import org.liuxinyu.project.t_paper.entity.Paper;
import org.liuxinyu.project.t_paper.entity.Question;
import org.liuxinyu.project.t_paper.entity.paperInit;
import org.liuxinyu.project.t_paper.service.T_PaperManager_IService;
import org.liuxinyu.project.util.entity.LayuiTable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("T_PaperManager_Controller")
public class T_PaperManager_Controller {

    @Resource
    T_PaperManager_IService t_paperManager_iService;

    @ResponseBody
    @RequestMapping("queryAllQuestion")
    public String queryAllQuestion(int page, int limit, String courseno) {// page 当前页数 ： limit 每页条数
        List<Question> questionList = new ArrayList<Question>();
        List<Question> data = new ArrayList<Question>();
        try {
            questionList = t_paperManager_iService.queryAllQuestion(courseno);
        } catch (Exception e) {
            e.printStackTrace();
        }
        int count = questionList.size() > page * limit ? page * limit : questionList.size();

        for (int i = (page - 1) * limit; i < count; i++) {
            data.add(questionList.get(i));
        }

        LayuiTable list = new LayuiTable("0", "", questionList.size(), data);
        return JSON.toJSONString(list);

    }

    @ResponseBody
    @RequestMapping("queryQuestion")
    public Question queryQuestion(String questionid) {
        Question question = new Question();

        try {
            question = t_paperManager_iService.queryQuestion(questionid);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return question;

    }


    @ResponseBody
    @RequestMapping("addQuestion")
    public Map<String, Object> addQuestion(Question question) {
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        System.out.println("question = " + question);
        try {
            stringObjectHashMap = t_paperManager_iService.addQuestion(question);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", "1");
            stringObjectHashMap.put("message", "糟糕出错了");
            return stringObjectHashMap;
        }
        return stringObjectHashMap;
    }

    @ResponseBody
    @RequestMapping("setPaper")
    public Map<String, Object> setPaper(Paper paper) {
        Map<String, Object> stringObjectHashMap = new HashMap<>();
        System.out.println("paper = " + paper);
        try {
            stringObjectHashMap = t_paperManager_iService.setPaper(paper);
        } catch (Exception e) {
            e.printStackTrace();
            stringObjectHashMap.put("state", "1");
            stringObjectHashMap.put("message", "糟糕出错了");
            return stringObjectHashMap;
        }
        return stringObjectHashMap;
    }

    @ResponseBody
    @RequestMapping("updateQuestion")
    public void updateQuestion(Question question) {

        System.out.println("question = " + question);
        try {
            t_paperManager_iService.updateQuestion(question);
        } catch (Exception e) {
            e.printStackTrace();

        }

    }


    @ResponseBody
    @RequestMapping("isexistPaper")
    public Paper isexistPaper(String courseid) {
        System.out.println("course = " + courseid);
        Paper paper = new Paper();
        try {
            paper = t_paperManager_iService.isexistPaper(courseid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paper;
    }

    @ResponseBody
    @RequestMapping("delQuestion")
    public void delQuestion(String questionid) {
        System.out.println("questionid = " + questionid);
        try {
            t_paperManager_iService.delQuestion(questionid);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @ResponseBody
    @RequestMapping("queryPaper")
    public paperInit queryPaperInit(String paperid) {
        System.out.println("questionid = " + paperid);
        paperInit paperInit = new paperInit();
        try {
            paperInit = t_paperManager_iService.queryPaper(paperid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return paperInit;
    }
}
