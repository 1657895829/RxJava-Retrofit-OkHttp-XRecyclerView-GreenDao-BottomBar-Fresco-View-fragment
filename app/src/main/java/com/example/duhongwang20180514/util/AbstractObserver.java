package com.example.duhongwang20180514.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Observer被观察者泛型类
 */

public abstract class AbstractObserver<T> implements Observer<String> {

    public abstract void onSuccess(T t);

    /**
     * 1  当前 网络异常
     * 2  json 解析异常
     * 2  未知异常
     */
    public abstract void onFailure(Exception e);

    @Override
    public void onSubscribe(Disposable d) {

    }

    //数据接收的成功执行
    @Override
    public void onNext(String result) {


        try {
            Type type =  getClass().getGenericSuperclass() ;
            Type [] types =  ((ParameterizedType)type).getActualTypeArguments() ;
            Class clazz = (Class) types[0] ;
            Gson gson = new Gson();
            T t = (T)  gson.fromJson(result,clazz);
            onSuccess(t);
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
            onFailure(e);
        }catch (Exception e){
            e.printStackTrace();
            onFailure(e);
        }

    }

    //数据接收失败时异常错误的执行方法
    @Override
    public void onError(Throwable e) {
        onFailure(new Exception(""));
        System.out.println(e);
    }

    //事件完成时
    @Override
    public void onComplete() {

    }
}
