package com.dhy.serialization.boolean1;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

import java.io.IOException;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2022/6/26 上午10:19
 */
public class TestMyBean {

    public static void main(String[] args) throws IOException {

        MyBean myBean = new MyBean();
        myBean.setSuccess(true);
        myBean.setCode("00");
        myBean.setMsg("成功");
        myBean.setFirst(true);
        myBean.setIzSuccess(true);
        String fastjsonS = JSON.toJSONString(myBean);
        System.out.println("fastjson 序列化："+fastjsonS);

        Gson gson = new Gson();
        String gsonS = gson.toJson(myBean);
        System.out.println("gson 序列化："+gsonS);

        ObjectMapper objectMapper = new ObjectMapper();
        String jacksonS = objectMapper.writer().writeValueAsString(myBean);
        System.out.println("jackson 序列化："+jacksonS);

        MyBean myBeanFromGson = gson.fromJson(fastjsonS, MyBean.class);
        MyBean myBeanFromJackson = objectMapper.reader().readValue(fastjsonS,MyBean.class);

        System.out.println("okl");
    }
}
