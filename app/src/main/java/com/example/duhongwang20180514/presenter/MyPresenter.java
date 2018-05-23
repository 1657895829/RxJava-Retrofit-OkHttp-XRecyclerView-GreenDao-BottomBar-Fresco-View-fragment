package com.example.duhongwang20180514.presenter;

import com.example.duhongwang20180514.bean.NewsBean;
import com.example.duhongwang20180514.model.MyModel;
import com.example.duhongwang20180514.view.MyView;

/**
 * Created   by    Dewey
 */
public class MyPresenter {
    private MyView myView;
    private MyModel myModel;

    public MyPresenter(MyView myView) {
        this.myView = myView;
        myModel = new MyModel();
    }

    //请求数据
    public void get(){
        myModel.getData(new MyView() {
            @Override
            public void onSuccess(NewsBean newsBean) {
                if (myView != null){
                    myView.onSuccess(newsBean);
                }
            }

            @Override
            public void onFailure() {
                if (myView != null){
                    myView.onFailure();
                }
            }
        });
    }

    //解绑p层
    public void detach(){
        this.myView = null;
    }
}
