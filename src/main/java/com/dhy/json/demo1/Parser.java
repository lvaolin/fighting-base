package com.dhy.json.demo1;

import com.fasterxml.jackson.core.type.TypeReference;

/**
 * 报文转换器
 *
 * @author: hujiao
 * @since : 2022/8/22 14:28
 **/
public interface Parser {
    /**
     * 将请求信息转换为byte数组
     *
     * @param request  请求信息
     * @param encoding 编码
     * @return 转换后的数据
     */
    byte[] format(Object request, String encoding);

    /**
     * 将响应数据解析成指定类的实例
     *
     * @param responseBytes 响应数据
     * @param encoding      编码
     * @param clazz         类信息
     * @param <T>           泛型
     * @return 解析后得到的响应信息
     */
    <T> T parse(byte[] responseBytes, String encoding, TypeReference<T> typeReference);
}
