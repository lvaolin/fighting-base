package com.dhy.json.demo2.model.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/1 14:08
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "HEADER")
public class XmlReqHeader {
    @XmlElement(name = "CommonHeaderField1")
    // @XmlTransient
    private String commonHeaderField1;

    @XmlElement(name = "CommonHeaderField2")
    private String commonHeaderField2;
}
