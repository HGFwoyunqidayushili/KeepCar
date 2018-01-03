package jiyun.com.keepcar.http.contract;

import android.content.Context;

import jiyun.com.keepcar.http.factory.HttpCallBack;

/**
 * Created by 阿三 on 2017/12/27.
 */
public interface InfoContract {

    interface Model {
        void requestNewsData(Context context, String page,String url , HttpCallBack httpCallBack);
        void requestNewsDataTwo(Context context, String page,String url , HttpCallBack httpCallBack);
    }

    interface Views<T>  extends HttpCallBack<T> {

    }
    interface ViewTwo<T> extends HttpCallBack<T>{

    }

    interface Presenter {
        void getNewsData(String page,String url);
        void getNewsDataTwo(String page,String url);
    }
}
