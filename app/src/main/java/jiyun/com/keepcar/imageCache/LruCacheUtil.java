package jiyun.com.keepcar.imageCache;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

/**
 * Created by 阿三 on 2018/1/6.
 */
public class LruCacheUtil {
    private LruCache<String,Bitmap> lruCache;
    public LruCacheUtil() {
        long max = Runtime.getRuntime().maxMemory() / 8;
        lruCache = new LruCache<String, Bitmap>((int) max) {
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getByteCount();

            }
    };
    }
    public void putLruCache(String url,Bitmap bitmap){

    }
    public Bitmap getLruCache(String url){
        Bitmap bitmap = lruCache.get(url);
        return bitmap;
    }
}
