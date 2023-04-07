package com.dhy.thread.callchain;

import lombok.SneakyThrows;

class SDK implements ISDK{
        @SneakyThrows
        @Override
        public void m1(){
            System.out.println("sdk.m1");
        }
    }