package com.dhy.json.demo2.model.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/9/2 08:58
 **/
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class XmlRespBody {
    @XmlElement(name = "cusno")
    private String customerNo;

    @XmlElementWrapper(name = "list")
    @XmlElement(name = "entity")
    private List<XmlRespEntity> entityList;
}
