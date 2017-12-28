package jiyun.com.keepcar.http.factory;

/**
 * Created by 阿三 on 2017/12/27.
 */
public interface HttpCallBack<T> {
    void success(T t);

    void failure(Throwable e);

}
