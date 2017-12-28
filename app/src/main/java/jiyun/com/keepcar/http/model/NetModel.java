package jiyun.com.keepcar.http.model;

import android.content.Context;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import jiyun.com.keepcar.http.contract.InfoContract;
import jiyun.com.keepcar.http.factory.HttpCallBack;
import jiyun.com.keepcar.http.factory.OkhttpProduct;
import jiyun.com.keepcar.http.factory.RequestFactory;
import jiyun.com.keepcar.http.factory.requestfactory.RequestProduct;
import jiyun.com.keepcar.http.factory.requestfactory.RequestProductImpl;

/**
 * Created by 阿三 on 2017/12/27.
 */
public class NetModel implements InfoContract.Model {

    @Override
    public void requestNewsData(Context context, String page,String url, HttpCallBack httpCallBack) {
            RequestProduct requestProduct=new RequestProductImpl();
            RequestFactory factory=requestProduct.create(OkhttpProduct.class);
            Type[] types=httpCallBack.getClass().getGenericInterfaces();
            Type[] actualTypeArguments = null;
        for (int i = 0; i < types.length; i++) {
            if (types[i] instanceof ParameterizedType) {
                actualTypeArguments = ((ParameterizedType) types[i]).getActualTypeArguments();
            }
        }
        Type type = actualTypeArguments[0];
        factory.post(context,page,url, type, httpCallBack);
    }

}
