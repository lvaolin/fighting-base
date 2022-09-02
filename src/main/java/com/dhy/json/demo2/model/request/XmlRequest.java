package com.dhy.json.demo2.model.request;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/1 14:11
 **/
@Data
@XmlRootElement(name = "ROOT")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"reqHeader", "reqBody", "reqExtension"})
public class XmlRequest<H extends XmlReqHeader, B extends XmlReqBody> {
    @XmlAttribute
    private boolean isRequest = true;

    @XmlAttribute
    private boolean isResponse = false;

    @XmlAnyElement(lax = true)
    private H reqHeader;

    @XmlAnyElement(lax = true)
    private B reqBody;

    @XmlElementWrapper(name = "EXTENSIONS")
    @XmlElement(name = "EXTENSION")
    private List<XmlReqExtension> reqExtension;
}
