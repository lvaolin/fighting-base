package com.dhy.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 注解方式使用sentinel   必须在spring中使用，否则没有解析注解的aop
 * @author lvaolin
 * @create 2020/3/19 2:48 下午
 */
public class Demo02 {

    public static void main(String[] args) throws InterruptedException {
        // 配置规则.
        initFlowRules();
        Demo02 demo02 = new Demo02();
        while (true) {
            demo02.helloWorld("lval");
            //TimeUnit.MILLISECONDS.sleep(100);
        }
    }

    private static void initFlowRules(){
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("HelloWorld");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        // Set limit QPS to 20.
        rule.setCount(20);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }


    @SentinelResource(value = "HelloWorld",fallback = "helloWorldFallback",blockHandler = "exceptionHandler")
    public  void  helloWorld(String name) {
        // 资源中的逻辑
        System.out.println(name + " hello world");
    }

    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public  void helloWorldFallback(String name,Throwable throwable) {
        System.out.println("备用逻辑---");
    }

    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
    public  void exceptionHandler(String name, BlockException ex) {
        // Do some log here.
        System.out.println("Block 异常处理");

    }
}
