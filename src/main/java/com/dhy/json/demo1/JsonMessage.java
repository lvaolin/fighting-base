package com.dhy.json.demo1;

import lombok.Data;

/**
 * TODO
 *
 * @author: hujiao
 * @since : 2022/8/31 11:24
 **/
@Data
public class JsonMessage<H extends JsonHeader, B extends JsonBody> {
    private H header;

    private B body;
}
