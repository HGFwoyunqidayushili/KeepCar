package jiyun.com.keepcar.http.factory;

import android.content.Context;

import java.lang.reflect.Type;

/**
 * Created by 阿三 on 2017/12/27.
 */
public class OkhttpProduct<T> extends RequestFactory<T> {
    HttpCallBack<T> httpCallBack;
    @Override
    public void get(Context context, String page, Type type, HttpCallBack<T> httpCallBack) {

    }

    @Override
    public void post(Context context, String page, Type type, HttpCallBack<T> httpCallBack) {
        this.httpCallBack=httpCallBack;

    }

}
