package org.liuxinyu.project.paper.mapper;

import org.apache.ibatis.annotations.Param;
import org.liuxinyu.project.t_paper.entity.Paper;

import java.util.List;

public interface IExam_Dao {

    List<String> queryQuestionID(@Param("paperid") String paperid, @Param("questionTypeCode") String questionTypeCode);

    Paper queryPaper (String paperid);

}
