package com.example.duhongwang20180514.util;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * OkHttp的单例模式封装类
 */

public class OkHttpUtils {


    private static OkHttpClient client = null ;

    //单例模式
    public static OkHttpClient getInstance(){

        //添加双重锁
        if(client == null){
            synchronized (OkHttpUtils.class){
                if(client == null){
                    client = new OkHttpClient.Builder()
                            .connectTimeout(20000, TimeUnit.SECONDS)
                            .writeTimeout(20000,TimeUnit.SECONDS)
                            .readTimeout(20000,TimeUnit.SECONDS)
                            .addInterceptor(new CommonHeaderInterceptor())
                            .addInterceptor(new LoggingInterceptor())
                            .build();
                }
            }
        }
        return client;
    }


}
