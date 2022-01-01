package com.dhy.designpatterns.chainOfResponsibility.linkedChain;

/**
 * @Title Node
 * @Description
 * @Author lvaolin
 * @Date 2022/1/1 16:23
 **/
public interface Node {
    Node getNext();
    void setNext(Node node) ;

    void check(GlCertificate glCertificate);
}
