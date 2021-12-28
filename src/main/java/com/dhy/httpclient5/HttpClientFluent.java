package com.dhy.httpclient5;

import com.google.common.base.Charsets;
import org.apache.hc.client5.http.fluent.Content;
import org.apache.hc.client5.http.fluent.Request;

import java.io.IOException;

public class HttpClientFluent {

   public static void main(String[] args) throws IOException {

       //这种风格的编程确实很简洁清晰，给人流畅的感觉------

       Content content = Request.get("http://www.baidu.com/")

               .setHeader("Connection","keep-alive")

               .execute()

               .returnContent();

       System.out.println(content.asString());

       Content content2 = Request.post("http://www.baidu.com/")

               .setHeader("Connection","keep-alive")

               .setHeader("Accept", "application/json")

               .setHeader("Content-Type", "application/json")//设置header信息

               .bodyByteArray("{  }".getBytes(Charsets.UTF_8))//发送json格式的数据

               .execute()

               .returnContent();

       System.out.println(content2.asString());

       for (; ; ) ;

   }

}