package com.dhy.designpatterns.chainOfResponsibility.linkedChain;

/**
 * @Title BaseNode
 * @Description
 * @Author lvaolin
 * @Date 2022/1/1 16:26
 **/
public abstract class BaseNode implements Node {
    private Node node;
    @Override
    public Node getNext() {
        return node;
    }
    @Override
    public void setNext(Node node) {
        this.node = node;
    }

    @Override
    public abstract void check(GlCertificate glCertificate);
}
