package com.example.duhongwang20180514.app;

import android.app.Application;
import com.facebook.drawee.backends.pipeline.Fresco;
/**
 * 用于全局配置初始化异步加载类
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 用于全局配置初始化Fresco 图片加载
        Fresco.initialize(this);

    }
}
