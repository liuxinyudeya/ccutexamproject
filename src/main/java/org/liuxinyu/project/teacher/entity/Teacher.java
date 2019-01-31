package org.liuxinyu.project.teacher.entity;

import java.util.Date;

/**
 * @author liuxinyu
 * @date 2019/1/30 0030 - 10:50
 */
public class Teacher {
    private String newteacherno;
    private String teacherno;
    private String name;
    private String sex;
    private Date updatetime;
    private String updatetime_str;
    private String isdelete;

    @Override
    public String toString() {
        return "Teacher{" +
                "newteacherno='" + newteacherno + '\'' +
                ", teacherno='" + teacherno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", updatetime=" + updatetime +
                ", updatetime_str='" + updatetime_str + '\'' +
                ", isdelete='" + isdelete + '\'' +
                '}';
    }

    public String getNewteacherno() {
        return newteacherno;
    }

    public void setNewteacherno(String newteacherno) {
        this.newteacherno = newteacherno;
    }

    public String getTeacherno() {
        return teacherno;
    }

    public void setTeacherno(String teacherno) {
        this.teacherno = teacherno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getUpdatetime_str() {
        return updatetime_str;
    }

    public void setUpdatetime_str(String updatetime_str) {
        this.updatetime_str = updatetime_str;
    }

    public String getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(String isdelete) {
        this.isdelete = isdelete;
    }
}
