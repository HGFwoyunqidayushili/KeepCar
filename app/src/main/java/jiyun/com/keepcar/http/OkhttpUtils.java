package jiyun.com.keepcar.http;

import android.os.Environment;

import java.io.File;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * Created by 阿三 on 2017/12/26.
 */
public class OkhttpUtils {
    private OkHttpClient.Builder okHttpClient;
    private static OkhttpUtils okHttpUtils;
    private OkHttpClient okHttpClien;
    public OkhttpUtils(){
        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Yangche");
        if (file != null) {
            file.mkdir();
        }
        Cache cache = new Cache(file, 1024 * 1024* 8);
        okHttpClient= new OkHttpClient.Builder().cache(cache);
        okHttpClien=new OkHttpClient();
    }
    public static OkhttpUtils getInstance(){
        if(okHttpUtils==null){
            synchronized (OkhttpUtils.class){
                if(okHttpUtils==null){
                    okHttpUtils=new OkhttpUtils();
                }
            }
        }
        return okHttpUtils;
    }
      public void getPost(String url, String Baseurl,Callback callback){

          RequestBody requestBody=RequestBody.create(MediaType.parse("application/json;charset=utf-8"),Baseurl);
          Request request=new Request.Builder().url(url).post(requestBody).build();
           okHttpClien.newCall(request).enqueue(callback);
      }
    public Call newsCall(Request request){
        return okHttpClien.newCall(request);

    }

}
