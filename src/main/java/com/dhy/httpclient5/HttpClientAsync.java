package com.dhy.httpclient5;

import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequests;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.core5.concurrent.FutureCallback;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**

* @Description http client 异步编程

* @Author lvaolin

* @Date 2021/2/9 4:40 下午

*/

public class HttpClientAsync {

   public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

       //CloseableHttpAsyncClient的实例创建同样也有多种方式，高级用法就是用HttpAsyncClients.custom() 定制自己的参数

       try (CloseableHttpAsyncClient httpclient = HttpAsyncClients.createDefault()) {

           //这句话是异步编程api 独有的

           httpclient.start();

           //-----1、 下面是第一种用法--通过获取Future句柄来灵活控制逻辑---

           //执行一个get请求

           SimpleHttpRequest request10 = SimpleHttpRequests.get("http://www.baidu.com/");

           SimpleHttpRequest request11 = SimpleHttpRequests.get("https://yonyou.com/");

           //下面这2步是关键，非堵塞的，返回 future句柄

           Future<SimpleHttpResponse> future10 = httpclient.execute(request10, null);

           Future<SimpleHttpResponse> future11 = httpclient.execute(request11, null);

           //等待响应返回

           SimpleHttpResponse response10 = future10.get();

           System.out.println(response10.getBodyText());

           SimpleHttpResponse response11 = future11.get();

           //-----2、 下面是第二种用法--通过FutureCallback 来实现理想中的异步回调 ---

           //CountDownLatch 是否使用 取决于你的业务需要，

           //你如果想在它回调完成时 再去做一些事情，就可以用 CountDownLatch来控制，否则就可以去掉CountDownLatch的代码

           final CountDownLatch latch1 = new CountDownLatch(2);

           final SimpleHttpRequest request2 = SimpleHttpRequests.get("http://www.baidu.com/");

           httpclient.execute(request2, new FutureCallback<SimpleHttpResponse>() {

               @Override

               public void completed(SimpleHttpResponse response2) {

                   latch1.countDown();

                   System.out.println(request2.getRequestUri() + "->" + response2.getCode());

               }

               @Override

               public void failed(Exception ex) {

                   latch1.countDown();

                   System.out.println(request2.getRequestUri() + "->" + ex);

               }

               @Override

               public void cancelled() {

                   latch1.countDown();

                   System.out.println(request2.getRequestUri() + " cancelled");

               }

           });

           latch1.await();

       }

   }

}