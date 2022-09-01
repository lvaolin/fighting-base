package com.dhy.json;

import lombok.Data;

/**
 * @Project fighting-core
 * @Description 泛型原理
 * @Author lvaolin
 * @Date 2022/9/1 上午11:23
 */
public class Test6 {

    public static void main(String[] args) {
        User user = method();
        System.out.println(user.getId());
    }

    public static  <T> T  method(){
        User user = new User();
        user.setId("1");
        user.setName("zhangsan");
        return (T)user;
    }

    @Data
    static class User{
        private String id;
        private String name;

    }

}
