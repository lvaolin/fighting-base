package com.dhy.json.demo2;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

/**
 * XML报文转换器
 *
 * @author: hujiao
 * @since : 2022/8/23 17:40
 **/
@Component(value = "xml")
@Slf4j
// FIXME 存在继承关系的类，序列化报文时丢失子类属性
public class XmlParser extends AbstractParser {
    @Override
    public byte[] format(Object request, String encoding, Class<?>... classes) {
        if (request == null) {
            return new byte[0];
        }
        try {
            Class<?>[] tClasses = new Class[classes.length + 1];
            tClasses[0] = request.getClass();
            if (ArrayUtils.isNotEmpty(classes)) {
                System.arraycopy(classes, 0, tClasses, 1, classes.length);
            }
            JAXBContext context = JAXBContext.newInstance(tClasses);
            Marshaller marshaller = context.createMarshaller();
            // marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            // marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // FIXME 生产环境应注释此行代码
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);
            StringWriter writer = new StringWriter();
            marshaller.marshal(request, writer);
            String reqStr = writer.toString();
            return reqStr.getBytes(encoding);
        } catch (JAXBException | UnsupportedEncodingException e) {
            log.error("[MCIS-SDK] Failed to generate XML message.", e);
            throw new RuntimeException("Transaction failed.");
        }
    }

    @Override
    public <T> T parse(byte[] responseBytes, String encoding, Class<T> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T t = (T) unmarshaller.unmarshal(new StringReader(new String(responseBytes, encoding)));
            return t;
        } catch (JAXBException | UnsupportedEncodingException e) {
            log.error("[MCIS-SDK] Failed to parse XML message.", e);
            throw new RuntimeException("Transaction failed.");
        }
    }

    @Override
    public <T> T parse(byte[] responseBytes, String encoding, Class<T> parametrized, Class<?>... parameterClasses) {
        try {
            Class<?>[] tClasses = new Class[parameterClasses.length + 1];
            tClasses[0] = parametrized;
            if (ArrayUtils.isNotEmpty(parameterClasses)) {
                System.arraycopy(parameterClasses, 0, tClasses, 1, parameterClasses.length);
            }
            // System.out.println(Arrays.toString(tClasses));
            JAXBContext context = JAXBContext.newInstance(tClasses);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            T t = (T) unmarshaller.unmarshal(new StringReader(new String(responseBytes, encoding)));
            return t;
        } catch (JAXBException | UnsupportedEncodingException e) {
            log.error("[MCIS-SDK] Failed to parse XML message.", e);
            throw new RuntimeException("Transaction failed.");
        }
    }
}
