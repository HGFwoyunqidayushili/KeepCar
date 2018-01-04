package jiyun.com.keepcar.http.factory;

import android.content.Context;

import java.lang.reflect.Type;

/**
 * Created by 阿三 on 2017/12/27.
 */
public abstract class RequestFactory<T> {
    public abstract void get(Context context, String page, Type type, HttpCallBack<T> httpCallBack);
    public abstract void post(Context context, String page,String url, Type type , HttpCallBack<T> httpCallBack);
    public abstract  void postTwo(Context context, String page,String url, Type type , HttpCallBack<T> httpCallBack);
}
