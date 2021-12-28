package com.dhy.httpclient5;

import org.apache.hc.client5.http.cache.CacheResponseStatus;
import org.apache.hc.client5.http.cache.HttpCacheContext;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.cache.CacheConfig;
import org.apache.hc.client5.http.impl.cache.CachingHttpClients;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.core5.io.CloseMode;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**

* @Description HttpClientCache插件的用途

* @Author lvaolin

* @Date 2021/2/9 3:36 下午

*/

public class HttpClientCache {

   public static void main(String[] args) throws IOException {

       CacheConfig cacheConfig = CacheConfig.custom()

               .setMaxCacheEntries(1000)

               .setMaxObjectSize(8192)

               .build();

       RequestConfig requestConfig = RequestConfig.custom()

               .setConnectTimeout(3, TimeUnit.SECONDS)

               .setConnectionRequestTimeout(10, TimeUnit.SECONDS)

               .build();

       CloseableHttpClient cachingClient = CachingHttpClients.custom()

               .setCacheConfig(cacheConfig)

               .setDefaultRequestConfig(requestConfig)

               .build();

       HttpCacheContext context = HttpCacheContext.create();

       HttpGet httpget = new HttpGet("http://www.baidu.com/");

       for (int i = 0; i <3 ; i++) {

           CloseableHttpResponse response = cachingClient.execute(httpget, context);

           try {

               CacheResponseStatus responseStatus = context.getCacheResponseStatus();

               switch (responseStatus) {

                   case CACHE_HIT:

                       System.out.println("A response was generated from the cache with " +

                               "no requests sent upstream");

                       break;

                   case CACHE_MODULE_RESPONSE:

                       System.out.println("The response was generated directly by the " +

                               "caching module");

                       break;

                   case CACHE_MISS:

                       System.out.println("The response came from an upstream server");

                       break;

                   case VALIDATED:

                       System.out.println("The response was generated from the cache " +

                               "after validating the entry with the origin server");

                       break;

               }

           } finally {

               response.close();

           }

       }

       cachingClient.close(CloseMode.GRACEFUL);

   }

}