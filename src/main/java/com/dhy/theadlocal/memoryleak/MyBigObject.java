package com.dhy.theadlocal.memoryleak;

/**
 * @Project fighting-core
 * @Description 主要用途描述
 * @Author lvaolin
 * @Date 2023/4/1 上午11:43
 */
public class MyBigObject {
    private String bigString;
    public MyBigObject(String bigString){
        this.bigString = bigString;
    }
}
