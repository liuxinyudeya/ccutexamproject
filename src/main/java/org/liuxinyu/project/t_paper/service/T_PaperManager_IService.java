package org.liuxinyu.project.t_paper.service;

import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.t_paper.entity.Paper;
import org.liuxinyu.project.t_paper.entity.Question;
import org.liuxinyu.project.t_paper.entity.paperInit;

import java.util.List;
import java.util.Map;

public interface T_PaperManager_IService {
    Map<String, Object> addQuestion(Question question) throws Exception;

    Map<String, Object> setPaper(Paper paper) throws Exception;

    void updateQuestion(Question question) throws Exception;

    void delQuestion(String questionId) throws Exception;

    Paper isexistPaper(String courseno) throws Exception;

    List<Question> queryAllQuestion(String courseno) throws Exception;

    Question queryQuestion(String questionid) throws Exception;

    paperInit queryPaper(String paperid) throws Exception;


}
