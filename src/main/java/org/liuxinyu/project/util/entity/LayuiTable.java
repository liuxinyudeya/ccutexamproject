package org.liuxinyu.project.util.entity;

import com.alibaba.fastjson.JSON;

import java.util.List;

/**
 * @author liuxinyu
 * @date 2019/1/23 0023 - 9:45
 */
public class LayuiTable {

    private String code;
    private String msg;
    private int count;
    private List data;


    public LayuiTable() {

    }


    public LayuiTable(String code, String msg, int count, List data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    @Override
    public String toString() {
        return "LayuiTable{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Object> getData() {
        return data;
    }


    public void setData(List data) {
        this.data = data;
    }


}
