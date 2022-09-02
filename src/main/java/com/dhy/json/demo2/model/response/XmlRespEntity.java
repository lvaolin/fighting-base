package com.dhy.json.demo2.model.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/2 09:06
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlRespEntity {
    @XmlElement(name = "cardNo")
    private String creditCardNo;

    @XmlElement(name = "ccyCode")
    private String currencyCode;
}
