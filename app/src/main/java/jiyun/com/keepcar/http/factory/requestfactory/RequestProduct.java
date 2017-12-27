package jiyun.com.keepcar.http.factory.requestfactory;

import jiyun.com.keepcar.http.factory.RequestFactory;

/**
 * Created by 阿三 on 2017/12/27.
 */
public abstract class RequestProduct {
    public abstract <T extends RequestFactory> RequestFactory create(Class<T> clz);
}
