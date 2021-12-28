package com.dhy.httpclient5;

import com.google.common.base.Charsets;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.entity.UrlEncodedFormEntity;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**

* @Description HttpClient用法演示

* @Author lvaolin

* @Date 2021/2/9 4:07 下午

*/

public class HttpClientClassic {

   public static void main(String[] args) throws IOException, ParseException {

       //关于CloseableHttpClient实例的创建HttpClients提供了多种方式，高级用法可以使用定制方法 HttpClients.custom()

       try (CloseableHttpClient httpclient = HttpClients.createDefault()) {

           //创建一个get类型的http请求

           HttpGet httpGet = new HttpGet("http://www.baidu.com/");

           try (CloseableHttpResponse response1 = httpclient.execute(httpGet)) {

               System.out.println(response1.getCode() + " " + response1.getReasonPhrase());

               HttpEntity entity1 = response1.getEntity();

               EntityUtils.consume(entity1);

           }

           //创建一个post类型的http请求

           HttpPost httpPost = new HttpPost("http://www.baidu.com/");

           List<NameValuePair> nvps = new ArrayList<>();

           nvps.add(new BasicNameValuePair("username", "aaa"));

           nvps.add(new BasicNameValuePair("password", "12345"));

           //这是一个form表单类型的数据格式，放入request body中

           httpPost.setEntity(new UrlEncodedFormEntity(nvps, Charsets.UTF_8));

           //如果是json格式，如下处理,统一使用 UTF-8 可以避免 客户端与服务器端编码不一致问题

           //httpPost.setEntity(new StringEntity("{}",Charsets.UTF_8));

           try (CloseableHttpResponse response2 = httpclient.execute(httpPost)) {

               //响应编码 以及 原因， 比如： 502 Bad Gateway

               System.out.println(response2.getCode() + " " + response2.getReasonPhrase());

               HttpEntity entity2 = response2.getEntity();

               //将响应流转为字符串形式，你可以自己根据需要使用EntityUtils工具进行处理，当然也可以自己解析 InputStream 流

               String stringBody = EntityUtils.toString(entity2, Charsets.UTF_8);

               //简单打印下

               System.out.println(stringBody);

               //确保关闭流资源

               EntityUtils.consume(entity2);

           }

       }

   }

}