package com.dhy.json.demo2.model.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/1 14:09
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "EXTENSION")
public class XmlReqExtension {
    @XmlElement(name = "Filler")
    private String filler;
}
