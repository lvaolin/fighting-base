package com.dhy.json.demo1;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/8/31 11:25
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class JsonReqHeader extends JsonHeader {
    private String requestId;
    private String sessionId;
}
