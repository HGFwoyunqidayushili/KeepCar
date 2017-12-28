package jiyun.com.keepcar.http;

import android.os.Environment;

import java.io.File;
import java.util.Map;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

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
      public void getPost(String url, Map<String,Object> map){
          StringBuffer sb=new StringBuffer();

          for(String str:map.keySet()){
            //  sb.append()
          }
          //RequestBody body=RequestBody.create(MediaType.parse("application/json;charset=utf-8"))
      }
    public Call newsCall(Request request){
        return okHttpClien.newCall(request);
    }

}
