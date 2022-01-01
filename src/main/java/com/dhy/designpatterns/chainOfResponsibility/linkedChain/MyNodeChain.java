package com.dhy.designpatterns.chainOfResponsibility.linkedChain;

/**
 * @Title MyNodeChain
 * @Description
 * @Author lvaolin
 * @Date 2022/1/1 16:37
 **/
public class MyNodeChain implements NodeChain {
    private GlCertificateService glCertificateService;
    private Node node;
    @Override
    public void doSave(GlCertificate glCertificate) {

        if (node!=null) {
            node.check(glCertificate);
        }
        glCertificateService.save(glCertificate);
    }


    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public GlCertificateService getGlCertificateService() {
        return glCertificateService;
    }

    public void setGlCertificateService(GlCertificateService glCertificateService) {
        this.glCertificateService = glCertificateService;
    }


}
