package com.dhy.httpclient5;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequests;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.async.methods.SimpleRequestBuilder;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManager;
import org.apache.hc.client5.http.impl.nio.PoolingAsyncClientConnectionManagerBuilder;
import org.apache.hc.client5.http.io.HttpClientConnectionManager;
import org.apache.hc.client5.http.nio.AsyncClientConnectionManager;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.config.Http1Config;
import org.apache.hc.core5.util.TimeValue;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @Description 实现异步SDK
 * 需求：目前第三方接口全是堵塞式接口，并且性能特别差，一个接口100秒以上
 * 目标：消除客户端大量的堵塞等待线程
 * @Author lvaolin
 * @Date 2021/12/30 20:40 下午
*/
public class HttpClientAsyncSDK {
   public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
       int i=300;
       MyClient myClient = new MyClient();
       while (i-->0){
           new Thread(new Runnable() {
               @Override
               public void run() {

                   myClient.login("http://localhost:8080/spring/index","admin",new FutureCallback<SimpleHttpResponse>() {
                       @Override
                       public void completed(SimpleHttpResponse response) {
                           System.out.println("->" + response.getBodyText());
                           //save db、rpc、mq。。。
                       }
                       @Override
                       public void failed(Exception ex) {
                           System.out.println(ex);
                       }
                       @Override
                       public void cancelled() {
                           System.out.println("cancelled");
                       }
                   });
                   System.out.println("http请求已发送");
               }
           }).start();
       }
       while (true);
   }


    static public class MyClient {
        private CloseableHttpAsyncClient httpclient = null;
        {
            //相当于一个浏览器，默认向同一个服务器同时最多建立5个连接
            //httpclient = HttpAsyncClients.createDefault();
            //httpclient = HttpAsyncClients.createHttp2Default();

            PoolingAsyncClientConnectionManager cmb = PoolingAsyncClientConnectionManagerBuilder
                    .create()
                    .setMaxConnPerRoute(1000)
                    .setMaxConnTotal(1000)
                    .setConnectionTimeToLive(TimeValue.ofSeconds(10L))
                    .build();
            httpclient = HttpAsyncClients.custom().setConnectionManager(cmb).build();
            //启动IO线程（回调线程）
            httpclient.start();
        }

        public Future<SimpleHttpResponse> login(String url,String name,final FutureCallback<SimpleHttpResponse> callback){
            SimpleHttpRequest request = SimpleRequestBuilder.get(url + "?name=" + name).build();
            Future<SimpleHttpResponse> future = httpclient.execute(request, callback);
            return future;
        }

    }
}