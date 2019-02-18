package org.liuxinyu.project.t_paper.mapper;

import org.apache.ibatis.annotations.Param;
import org.liuxinyu.project.t_paper.entity.Answer;
import org.liuxinyu.project.t_paper.entity.Paper;
import org.liuxinyu.project.t_paper.entity.Question;
import org.liuxinyu.project.t_paper.entity.paperInit;

import java.util.List;

public interface T_Paper_Dao {
    List<Paper> queryPaperByCourseId(String courseid);

    void addQuestion(Question question);

    void updateQuestion(Question question);

    void updateAnswer(@Param("answerName") String answerName, @Param("id") String id);

    void delQuestion(String id);

    void delAnswer(String id);

    void addAnswer(Answer answer);

    void addOnePaper(@Param("id") String id, @Param("courseno") String courseno);

    List<Question> queryAllQuestion(String paperid);

    Question queryQuestion(String questionid);

    List<paperInit> queryPaper(String paperid);

    void setPaper(Paper paper);

    String verifyPaper(String paperid);
}
