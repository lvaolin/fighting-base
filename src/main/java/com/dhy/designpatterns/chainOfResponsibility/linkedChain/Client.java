package com.dhy.designpatterns.chainOfResponsibility.linkedChain;

/**
 * @Title Client
 * @Description
 * @Author lvaolin
 * @Date 2022/1/1 16:47
 **/
public class Client {
    public static void main(String[] args) {
        //凭证信息
        GlCertificate glCertificate = new GlCertificate();

        //检查规则
        Node f1Node = new Node1();
        Node f2Node = new Node2();
        Node f3Node = new Node3();
        f1Node.setNext(f2Node);
        f2Node.setNext(f3Node);

        //组装检查链
        MyNodeChain myNodeChain = new MyNodeChain();
        //目标服务
        myNodeChain.setGlCertificateService(new GlCertificateService());
        //头节点
        myNodeChain.setNode(f1Node);
        //保存凭证
        myNodeChain.doSave(glCertificate);
    }

}
