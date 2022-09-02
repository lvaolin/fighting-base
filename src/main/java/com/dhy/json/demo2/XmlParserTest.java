package com.dhy.json.demo2;

import com.dhy.json.demo2.model.request.SomeReqBody;
import com.dhy.json.demo2.model.request.SomeReqHeader;
import com.dhy.json.demo2.model.request.XmlReqExtension;
import com.dhy.json.demo2.model.request.XmlRequest;
import com.dhy.json.demo2.model.response.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ArrayUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class XmlParserTest {
    private XmlParser parser;

    @BeforeEach
    void setup() {
        parser = new XmlParser();
    }

    @Test
    void format() {
        SomeReqHeader header = new SomeReqHeader();
        header.setCommonHeaderField1("111");
        header.setCommonHeaderField2("222");
        header.setSomeHeaderField1("333");
        header.setSomeHeaderField2("444");
        SomeReqBody body = new SomeReqBody();
        body.setCommonBodyField1("555");
        body.setSomeBodyField1("666");
        XmlReqExtension ex = new XmlReqExtension();
        ex.setFiller("777");

        XmlRequest<SomeReqHeader, SomeReqBody> some = new XmlRequest<>();
        some.setReqHeader(header);
        some.setReqBody(body);
        some.setReqExtension(Arrays.asList(ex, ex));
        String xml = new String(parser.format(some, StandardCharsets.UTF_8.name(), SomeReqHeader.class, SomeReqBody.class), StandardCharsets.UTF_8);
        System.out.println(xml);
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ROOT isRequest=\"true\" isResponse=\"false\"><HEADER><CommonHeaderField1>111</CommonHeaderField1><CommonHeaderField2>222</CommonHeaderField2><someHeaderField1>333</someHeaderField1><someHeaderField2>444</someHeaderField2></HEADER><BODY><CommonBodyField1>555</CommonBodyField1><SomeBodyField1>666</SomeBodyField1></BODY><EXTENSIONS><EXTENSION><Filler>777</Filler></EXTENSION><EXTENSION><Filler>777</Filler></EXTENSION></EXTENSIONS></ROOT>", xml);

        XmlRespHeader h = new XmlRespHeader();
        h.setTransactionCode("TS000001");
        h.setTellerNo("9881002");
        XmlRespEntity entity = new XmlRespEntity();
        entity.setCreditCardNo("6225123456789012");
        entity.setCurrencyCode("CNY");
        XmlRespEntity entity1 = new XmlRespEntity();
        entity1.setCreditCardNo("6225888888888888");
        entity1.setCurrencyCode("USD");
        XmlRespBody b = new XmlRespBody();
        b.setCustomerNo("0123456789");
        b.setEntityList(Arrays.asList(entity, entity1));
        XmlRespExtension e = new XmlRespExtension();
        e.setFiller("fake-filler1");
        XmlRespExtension e1 = new XmlRespExtension();
        e1.setFiller("fake-filler2");

        XmlResponse resp = new XmlResponse();
        resp.setHeader(h);
        resp.setBody(b);
        resp.setExtensions(Arrays.asList(e, e1));
        String respXml = new String(parser.format(resp, StandardCharsets.UTF_8.name()), StandardCharsets.UTF_8);
        System.out.println(respXml);
        assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><GCS isRequest=\"false\" isResponse=\"true\"><system><transactionCode>TS000001</transactionCode><tellerNo>9881002</tellerNo></system><page><cusno>0123456789</cusno><list><entity><cardNo>6225123456789012</cardNo><ccyCode>CNY</ccyCode></entity><entity><cardNo>6225888888888888</cardNo><ccyCode>USD</ccyCode></entity></list></page><extensions><extension><FILLER>fake-filler1</FILLER></extension><extension><FILLER>fake-filler2</FILLER></extension></extensions></GCS>", respXml);
    }

    @Test
    void parse() {
        String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><GCS isRequest=\"false\" isResponse=\"true\"><system><transactionCode>TS000001</transactionCode><tellerNo>9881002</tellerNo></system><page><cusno>0123456789</cusno><list><entity><cardNo>6225123456789012</cardNo><ccyCode>CNY</ccyCode></entity><entity><cardNo>6225888888888888</cardNo><ccyCode>USD</ccyCode></entity></list></page><extensions><extension><FILLER>fake-filler1</FILLER></extension><extension><FILLER>fake-filler2</FILLER></extension></extensions></GCS>";
        XmlResponse bean = parse(str, XmlResponse.class);
        System.out.println(bean);

        String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><ROOT isRequest=\"true\" isResponse=\"false\"><HEADER><CommonHeaderField1>111</CommonHeaderField1><CommonHeaderField2>222</CommonHeaderField2><someHeaderField1>333</someHeaderField1><someHeaderField2>444</someHeaderField2></HEADER><BODY><CommonBodyField1>555</CommonBodyField1><SomeBodyField1>666</SomeBodyField1></BODY><EXTENSIONS><EXTENSION><Filler>777</Filler></EXTENSION><EXTENSION><Filler>777</Filler></EXTENSION></EXTENSIONS></ROOT>";
        XmlRequest<SomeReqHeader, SomeReqBody> req = parse(xml, XmlRequest.class, SomeReqHeader.class, SomeReqBody.class);
        System.out.println(req);
    }

    public <T> T parse(String data, Class<T> parametrized, Class<?>... parameterClasses) {
        try {
            Class<?>[] tClasses = new Class[parameterClasses.length + 1];
            tClasses[0] = parametrized;
            if (ArrayUtils.isNotEmpty(parameterClasses)) {
                System.arraycopy(parameterClasses, 0, tClasses, 1, parameterClasses.length);
            }
            System.out.println(Arrays.toString(tClasses));
            JAXBContext context = JAXBContext.newInstance(tClasses);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(data));
        } catch (JAXBException e) {
            log.error("[MCIS-SDK] Failed to parse XML message.", e);
            throw new RuntimeException("Transaction failed.");
        }
    }
}