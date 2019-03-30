package org.liuxinyu.project.cla.service;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.liuxinyu.project.academy.entity.Academy;
import org.liuxinyu.project.cla.mapper.ICla_Dao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuxinyu
 * @date 2019/1/24 0024 - 15:14
 */
@Service
@Transactional
public class Cla_Service implements ICla_Service {


    @Resource
    ICla_Dao iCla_dao;


    public Map<String, Object> addCla(Academy academy) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        academy.setId(academy.getGrade() + academy.getAcademyCode() + academy.getMajorCode() + academy.getClassno()); // 设置主键id : 年级+学院编号+专业编号 确保唯一
        academy.setDepartment("01"); // 设置部门等级 03 学院 : 02 专业 : 01 班级
        academy.setManagerid(academy.getGrade() + academy.getAcademyCode() + academy.getMajorCode());

        try {
            iCla_dao.addCla(academy);
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已录入该信息");
            return stringObjectHashMap;
        }


        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "添加成功");
        return stringObjectHashMap;
    }

    public List<Academy> queryAllCla(String key) throws Exception {

        return iCla_dao.queryAllCla(key);
    }

    public Map<String, Object> updateCla(Academy academy) throws Exception {
        HashMap<String, Object> stringObjectHashMap = new HashMap<String, Object>();
        academy.setNewid(academy.getGrade() + academy.getAcademyCode() + academy.getMajorCode() + academy.getClassno());
        academy.setManagerid(academy.getGrade() + academy.getAcademyCode() + academy.getMajorCode());
        try {
            iCla_dao.updateCla(academy);
        } catch (Exception e) {
            stringObjectHashMap.put("state", 1);// 0 成功 : 1 失败
            stringObjectHashMap.put("error", "已有[" + academy.getId() + "]编号的学院");
            return stringObjectHashMap;
        }

        stringObjectHashMap.put("state", 0);// 0 成功 : 1 失败
        stringObjectHashMap.put("success", "更新成功");
        return stringObjectHashMap;
    }

    @Override
    public HashMap<String, Object> uploadExcle(MultipartFile file) throws IOException {
        HashMap<String, Object> result = new HashMap<String, Object>();
        ArrayList<Academy> academies = new ArrayList<>();

        if (!file.isEmpty() && file.getOriginalFilename().endsWith("xls")) {
            InputStream is = file.getInputStream();
            HSSFWorkbook hssf = new HSSFWorkbook(is);
            HSSFSheet sheet = hssf.getSheet("Sheet1");

            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                Academy academy = new Academy();
                HSSFCell grade = sheet.getRow(i).getCell(0);
                HSSFCell academyName = sheet.getRow(i).getCell(1);
                HSSFCell academyCode = sheet.getRow(i).getCell(2);
                HSSFCell majorName = sheet.getRow(i).getCell(3);
                HSSFCell majorCode = sheet.getRow(i).getCell(4);
                HSSFCell classno = sheet.getRow(i).getCell(5);
                academy.setId(grade.toString() + academyCode.toString() + majorCode.toString() + classno.toString()); // 设置主键id : 年级+学院编号+专业编号 确保唯一
                academy.setGrade(grade.toString());
                academy.setDepartment("01"); // 设置部门等级 03 学院 : 02 专业 : 01 班级
                academy.setManagerid(grade.toString() + academyCode.toString() + majorCode.toString());
                academy.setAcademyCode(academyCode.toString());
                academy.setAcademyName(academyName.toString());
                academy.setMajorName(majorName.toString());
                academy.setMajorCode(majorCode.toString());
                academy.setClassno(classno.toString());

                academies.add(academy);
            }
            try {
                iCla_dao.batchInsert(academies);
            } catch (Exception e) {
                result.put("state", "1");
                result.put("message", "上传失败,不能有相同的编号");
                return result;
            }

        }
        result.put("state", "0");
        result.put("message", "添加成功");
        return result;
    }
}
