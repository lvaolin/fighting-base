package com.dhy.json.demo2.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/1 17:39
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@XmlRootElement(name = "HEADER")
@XmlAccessorType(XmlAccessType.FIELD)
public class SomeReqHeader extends XmlReqHeader {
    private String someHeaderField1;

    private String someHeaderField2;
}
