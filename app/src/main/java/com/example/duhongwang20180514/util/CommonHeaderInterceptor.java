package com.example.duhongwang20180514.util;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 添加请求头的自定义拦截器
 */

public class CommonHeaderInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取链表结构的请求
        Request request =  chain.request();

        Request.Builder builder =  request.newBuilder() ;

        //添加请求头的参数
        builder.addHeader("key","1509D");
        builder.addHeader("User-Agent","android");

        //返回链表请求的数据
        return chain.proceed(builder.build());
    }
}
