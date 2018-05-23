package com.example.duhongwang20180514.util;

import java.util.Map;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 *  get与post请求方式的单例模式执行类
 */

public class APIGet_Post_Factory {

    private APIGet_Post_Factory(){}
    private  static APIGet_Post_Factory factory = null ;

    //单例模式声明，使用双重锁加载
    public static APIGet_Post_Factory getInstance(){
        if(factory == null){
            synchronized (APIGet_Post_Factory.class){
                if(factory == null){
                    factory = new APIGet_Post_Factory();
                }
            }
        }
        return factory;
    }


    //get请求方式，传入网址url，Map集合传参，使用Observer被观察者订阅执行
    public void get(String url, Map<String,String> map, Observer<String> observer){
        RetrofitUtils.getInstance().get(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //get请求方式，传入网址url，不传参，直接使用Observer被观察者订阅执行
    public void get(String url,Observer<String> observer){
        RetrofitUtils.getInstance().get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    //post请求方式，传入网址url，Map集合传参，使用Observer被观察者订阅执行
    public void post(String url,Map<String,String> map,Observer<String> observer){

        RetrofitUtils.getInstance().post(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
}
