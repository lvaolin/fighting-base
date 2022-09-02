package com.dhy.json.demo2;

/**
 * 抽象报文转换器
 *
 * @author: hujiao
 * @since : 2022/8/31 16:33
 **/
public abstract class AbstractParser implements Parser {
    @Override
    public <T> T parse(byte[] responseBytes, String encoding, Class<T> parametrized, Class<?>... parameterClasses) {
        return this.parse(responseBytes, encoding, parametrized);
    }
}
