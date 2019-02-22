package org.liuxinyu.project.paper.controller;

import org.liuxinyu.project.paper.entity.Exam;
import org.liuxinyu.project.paper.service.IExam_Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("Exam_Controller")
public class Exam_Controller {

    @Resource
    IExam_Service iExam_service;

    @RequestMapping("queryExam")
    @ResponseBody
    public Exam queryExam(String paperid) {
        System.out.println("paperid = " + paperid);
        Exam exam = new Exam();
        try {
            exam = iExam_service.queryExam(paperid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exam;
    }
}
