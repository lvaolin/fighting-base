package com.dhy.json.demo2.model.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/2 08:58
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlRespHeader {
    private String transactionCode;

    private String tellerNo;
}
