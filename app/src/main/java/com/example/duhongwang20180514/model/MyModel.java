package com.example.duhongwang20180514.model;

import com.example.duhongwang20180514.bean.NewsBean;
import com.example.duhongwang20180514.util.APIGet_Post_Factory;
import com.example.duhongwang20180514.util.AbstractObserver;
import com.example.duhongwang20180514.view.MyView;

/**
 * Created   by    Dewey
 */

public class MyModel {
    //请求数据的方法   https://www.zhaoapi.cn/quarter/getJokes?source=android&appVersion=100&page=1
    public void getData(final MyView myView){
        APIGet_Post_Factory.getInstance().get("/quarter/getJokes?source=android&appVersion=100&page=1", new AbstractObserver<NewsBean>() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                myView.onSuccess(newsBean);
            }

            @Override
            public void onFailure(Exception e) {
                myView.onFailure();
            }
        });
    }
}
