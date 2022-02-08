package com.cy.store.entity;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.Serializable;
import java.util.Date;

/**
 * 返回给前端的固定格式
 *
 * @author jimmy
 */
public class JsonResult<D> implements Serializable {

    /*状态*/
    private Integer state;
    /*描述信息*/
    private String message;
    /*具体内容*/
    private D data;

    public JsonResult() {
    }

    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Integer state, String message) {
        this.state = state;
        this.message = message;
    }


    public JsonResult(Throwable e) {
        this.message = e.getMessage();
    }

    public JsonResult(Integer state, Throwable e) {
        this.state = state;
        this.message = e.getMessage();
    }


    public JsonResult(Integer state, String message, D data) {
        this.state = state;
        this.message = message;
        this.data = data;
    }


    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void fail() {
        this.state = 300;
        this.message = "失败";

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public JsonResult success() {
        this.state = 200;
        this.message = "成功";
        return this;
    }

    public JsonResult success(D t) {
        this.state = 200;
        this.message = "成功";
        this.data = t;
        return this;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "state=" + state +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
