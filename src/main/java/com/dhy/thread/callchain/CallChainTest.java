package com.dhy.thread.callchain;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Project fighting-core
 * @Description 运行时调用链统计：需求 统计某个class某个method的所有业务代码调用路径
 * @Author lvaolin
 * @Date 2023/4/7 上午8:50
 */
public class CallChainTest {
    public static void main(String[] args) {
        AController a = new AController();
        a.m1();
    }

    @RequestMapping("/A")
    static class AController {
        @RequestMapping(value = "/m1",params = "txnId=PAY100001")
        void m1(){
            System.out.println("a.m1");
            m2();
        }
        void m2(){
            System.out.println("a.m2");
            B b = new B();
            b.m1();
        }
    }
    static class B{
        void m1(){
            System.out.println("b.m1");
            m2();
        }
        void m2(){
            System.out.println("b.m2");
            SDKProxy sdkProxy = new SDKProxy(new SDK());
            ISDK sdk = sdkProxy.getProxy();
            sdk.m1();

        }
    }





}
