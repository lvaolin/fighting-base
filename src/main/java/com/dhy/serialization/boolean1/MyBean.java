package com.dhy.serialization.boolean1;

import java.io.Serializable;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/6/26 上午10:13
 */
public class MyBean implements Serializable {
    private boolean success;//可以
    private boolean izSuccess;//也可以
    private String code;
    private String msg;
    private boolean isFirst;//不正确


    //像这个通过 fastjson序列化后属性就会变为 first
    //如果通过 gson 反序列化 这个属性的值就会丢失
    //所以说 序列化和反序列化 要用同一个库才行
    public boolean isFirst() {
        return isFirst;
    }

    public void setFirst(boolean first) {
        isFirst = first;
    }

    //boolean 类型的属性会生成isXxx的方法
    //这个是正确的，即使用fastjson序列化用gson反序列化也没问题
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    //非boolean类型的会用getXxx()
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

    public boolean isIzSuccess() {
        return izSuccess;
    }

    public void setIzSuccess(boolean izSuccess) {
        this.izSuccess = izSuccess;
    }
}
