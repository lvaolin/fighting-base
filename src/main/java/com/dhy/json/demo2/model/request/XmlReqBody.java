package com.dhy.json.demo2.model.request;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/1 14:08
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlReqBody {
    @XmlElement(name = "CommonBodyField1")
    private String commonBodyField1;
}
