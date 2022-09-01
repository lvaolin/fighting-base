package com.dhy.json.demo1;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


class JsonParserTest {
    private static final Parser parser = new JsonParser();

    private static ObjectMapper objectMapper = new ObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false).configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;

    private static ObjectWriter objectWriter= objectMapper.writerWithDefaultPrettyPrinter();


    @Test
    void format1() {
        JsonMessage<JsonReqHeader, JsonReqBody> msg = new JsonMessage<>();
        JsonReqHeader header = new JsonReqHeader();
        header.setRequestId("fake-request-id");
        header.setSessionId("fake-session-id");
        JsonReqBody body = new JsonReqBody();
        body.setResourceId("fake-resource-id");
        body.setResourceName("fake-resource-name");
        msg.setHeader(header);
        msg.setBody(body);
        byte[] bytes = parser.format(msg, StandardCharsets.UTF_8.name());
        System.out.println(new String(bytes, StandardCharsets.UTF_8));
    }

    @Test
    void parse1() throws IOException {
        String str = "{\"header\":{\"requestId\":\"fake-request-id\",\"sessionId\":\"fake-session-id\"},\"body\":{\"resourceId\":\"fake-resource-id\",\"resourceName\":\"fake-resource-name\"}}";

        TypeReference<JsonMessage<JsonReqHeader, JsonReqBody>> reference = new TypeReference<JsonMessage<JsonReqHeader, JsonReqBody>>() {};
        JsonMessage<JsonReqHeader, JsonReqBody> jsonMsg = objectMapper.readValue(str, reference);
        System.out.println(jsonMsg);

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
//        JsonMessage<JsonReqHeader, JsonReqBody> msg = parser.parse(bytes, StandardCharsets.UTF_8.name(), JsonMessage.class);
//        System.out.println(msg);
//        System.out.println(objectWriter.writeValueAsString(msg));
    }

    public static void main(String[] args) throws JsonProcessingException {
        String str = "{\"header\":{\"requestId\":\"fake-request-id\",\"sessionId\":\"fake-session-id\"},\"body\":{\"resourceId\":\"fake-resource-id\",\"resourceName\":\"fake-resource-name\"}}";

        TypeReference<JsonMessage<JsonReqHeader, JsonReqBody>> reference = new TypeReference<JsonMessage<JsonReqHeader, JsonReqBody>>() {};
        JsonMessage<JsonReqHeader, JsonReqBody> jsonMsg = objectMapper.readValue(str, reference);
        System.out.println(jsonMsg);

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        JsonMessage<JsonReqHeader, JsonReqBody> msg = parser.parse(bytes, StandardCharsets.UTF_8.name(), new TypeReference<JsonMessage<JsonReqHeader, JsonReqBody>>() {});
        System.out.println(msg);
        System.out.println(objectWriter.writeValueAsString(msg));
    }
}