package com.dhy.json.demo2.model.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/2 08:58
 **/
@Data
@XmlRootElement(name = "GCS")
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlResponse {
    @XmlAttribute
    private boolean isRequest = false;

    @XmlAttribute
    private boolean isResponse = true;

    @XmlElement(name = "system")
    private XmlRespHeader header;

    @XmlElement(name = "page")
    private XmlRespBody body;

    @XmlElementWrapper(name = "extensions")
    @XmlElement(name = "extension")
    private List<XmlRespExtension> extensions;
}
