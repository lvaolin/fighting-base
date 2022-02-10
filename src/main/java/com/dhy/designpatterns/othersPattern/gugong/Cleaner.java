package com.dhy.designpatterns.othersPattern.gugong;

/**
 * @Project fighting-core
 * @Description 清洁工
 * @Author lvaolin
 * @Date 2022/2/10 上午11:25
 */
public class Cleaner {
    void clean(Cleanable cleanable){
        cleanable.cleaned();
    }
}
