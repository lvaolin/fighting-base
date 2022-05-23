package com.dhy.theadlocal.DhyTaskProxy.client;

import lombok.Data;


@Data
public class RequestContext {
    private String sessionId;
    private String dbKey;
}