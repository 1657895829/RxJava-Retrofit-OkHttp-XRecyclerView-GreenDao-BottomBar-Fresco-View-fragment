package com.example.duhongwang20180514.app;

import android.app.Application;
import com.example.duhongwang20180514.dao.DaoMaster;
import com.example.duhongwang20180514.dao.DaoSession;
import com.facebook.drawee.backends.pipeline.Fresco;
import org.greenrobot.greendao.database.Database;

/**
 * 用于全局配置初始化异步加载类
 */
public class MyApplication extends Application {
    //设置session为静态变量
    public static DaoSession session;

    @Override
    public void onCreate() {
        super.onCreate();
        // 用于全局配置初始化Fresco 图片加载
        Fresco.initialize(this);

        //初始化数据库
        DaoMaster.DevOpenHelper database = new DaoMaster.DevOpenHelper(this, "MyDao");

        //获取数据库
        Database db = database.getWritableDb();

        //操作数据库，等于打开数据库
        session = new DaoMaster(db).newSession();
    }
}
