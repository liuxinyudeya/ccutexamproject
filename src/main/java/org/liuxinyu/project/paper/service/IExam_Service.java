package org.liuxinyu.project.paper.service;

import org.liuxinyu.project.paper.entity.Exam;

public interface IExam_Service {

    Exam queryExam(String paperid) throws Exception;
}
