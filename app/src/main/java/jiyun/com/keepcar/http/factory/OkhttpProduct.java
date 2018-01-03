package jiyun.com.keepcar.http.factory;

import android.content.Context;
import android.util.Log;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import jiyun.com.keepcar.http.OkhttpUtils;
import jiyun.com.keepcar.ui.App;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 阿三 on 2017/12/27.
 */
public class OkhttpProduct<T> extends RequestFactory<T> {
    HttpCallBack<T> httpCallBack;
    @Override
    public void get(Context context, String page, Type type, HttpCallBack<T> httpCallBack) {

    }

    @Override
    public void post(Context context, String page, String url, final Type type, final HttpCallBack<T> httpCallBack) {
        this.httpCallBack=httpCallBack;
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),url);
        Request request=new Request.Builder().url(page).post(requestBody).build();
        OkhttpUtils.getInstance().newsCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str=response.body().string();
              //  Log.e("TAG",str);
                Gson gson = new Gson();
                final T o = gson.fromJson(str,type);
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        httpCallBack.success(o);
                    }
                });

            }
        });
    }

    @Override
    public void postTwo(Context context, String page, String url, final Type type, final HttpCallBack<T> httpCallBack) {
        this.httpCallBack=httpCallBack;
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"),url);
        Request request=new Request.Builder().url(page).post(requestBody).build();
        OkhttpUtils.getInstance().newsCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String str=response.body().string();
                Log.e("TAG",str);
                Gson gson = new Gson();
                final T o = gson.fromJson(str,type);
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        httpCallBack.successTwo(o);
                    }
                });

            }
        });
    }

}
