package com.dhy.dubbo.dubboproxytest;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * @Title Client
 * @Description
 * @Author lvaolin
 * @Date 2022/3/16 23:29
 **/
public class Client {
    public static void main(String[] args) {

        //假设这是前端传过来的报文,一定要用数组传 参数组，和 方法签名 一一对应。
        String json = "{\"paramValues\":[{\"id\":\"001\"},{\"date\":\"2022-03-04\"},{\"myDto\":{\"name\":\"zhangsan\",\"school\":\"hbu\"}}]}";
         //转换成 3个参数，再泛化调用
        //方法定义   hello(String id,Date date, MyDto myDto)

        //这样直接就转过来了
        DubboRequestDto dubboRequestDto = JSON.parseObject(json, DubboRequestDto.class);

        //可以直接作为 dubbo泛化调用的 Object[]  values 传递过去
       // dubboRequestDto.getParamValues()

        System.out.println("-----------------");

    }
}
