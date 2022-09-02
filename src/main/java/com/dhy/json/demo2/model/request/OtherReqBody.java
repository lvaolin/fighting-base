package com.dhy.json.demo2.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/1 16:48
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@XmlRootElement(name = "BODY")
@XmlAccessorType(XmlAccessType.FIELD)
public class OtherReqBody extends XmlReqBody {
    @XmlElement(name = "OtherBodyField1")
    private String otherBodyField1;

    @XmlElement(name = "OtherBodyField2")
    private String otherBodyField2;
}
