package com.dhy.json.demo2.model.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/2 08:59
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlRespExtension {
    @XmlElement(name = "FILLER")
    private String filler;
}
