package jiyun.com.keepcar.http.factory.requestfactory;

import jiyun.com.keepcar.http.factory.RequestFactory;

/**
 * Created by 阿三 on 2017/12/27.
 */
public class RequestProductImpl extends RequestProduct {


    @Override
    public <T extends RequestFactory> RequestFactory create(Class<T> clz) {
        try {
            RequestFactory o = (RequestFactory) Class.forName(clz.getName()).newInstance();
            return o;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
