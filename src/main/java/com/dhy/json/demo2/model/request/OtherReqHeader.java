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
 * @since : 2022/9/1 17:41
 **/
@EqualsAndHashCode(callSuper = true)
@Data
@XmlRootElement(name = "HEADER")
@XmlAccessorType(XmlAccessType.FIELD)
public class OtherReqHeader extends XmlReqHeader {
    private String otherHeaderField1;

    private String otherHeaderField2;
}
