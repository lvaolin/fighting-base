package com.dhy.json.demo1;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.mortbay.util.ajax.JSON;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;

/**
 * JSON报文转换器
 *
 * @author: hujiao
 * @since : 2022/8/23 17:28
 **/
@Component(value = "json")
@Slf4j
public class JsonParser implements Parser {
    private final ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public byte[] format(Object request, String encoding) {
        byte[] requestBytes;
        try {
            String requestStr = objectMapper.writeValueAsString(request);
            if (request == null) {
                requestBytes = new byte[0];
            } else {
                requestBytes = requestStr.getBytes(encoding);
            }
        } catch (JsonProcessingException | UnsupportedEncodingException e) {
            log.error("[MCIS-SDK] Failed to generate JSON message.", e);
            throw new RuntimeException("Transaction failed.");
        }
        return requestBytes;
    }

    @Override
    public <T> T parse(byte[] responseBytes, String encoding, TypeReference<T> typeReference ) {
        if (responseBytes == null || responseBytes.length == 0) {
            return null;
        }
        T responseObj;

        try {
            responseObj = objectMapper.readValue(new String(responseBytes, encoding), typeReference);
        } catch (IOException e) {
            log.error("[MCIS-SDK] Failed to parse JSON message.", e);
            throw new RuntimeException("Transaction failed.");
        }


        return responseObj;
    }
}
