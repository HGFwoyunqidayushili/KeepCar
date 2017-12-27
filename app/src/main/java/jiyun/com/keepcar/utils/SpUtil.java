package jiyun.com.keepcar.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.Serializable;

/**
 * Created by 阿三 on 2017/12/26.
 */
public class SpUtil {
    /**
     * 获取sp句柄
     * @param context       页面句柄
     * @param storeName     存储名称
     * @return
     */
    private static SharedPreferences getSettingPreferences(Context context, String storeName) {
        SharedPreferences setting = null;
        setting = context.getSharedPreferences(storeName, Context.MODE_PRIVATE);
        return setting;
    }
    //获取value值
    public static String getString(Context ctx, String storeName, String key) {
        String value = null;
        getSettingPreferences(ctx, storeName).edit();
        if (getSettingPreferences(ctx, storeName).contains(key)) {
            value = getSettingPreferences(ctx, storeName).getString(key, null);
        }
        return value;
    }

    /**
     * 存放数据到指定sp中
     * @param ctx
     * @param storeName
     * @param key
     * @param value
     */
    public static void putString(Context ctx, String storeName, String key, Serializable value) {
        SharedPreferences.Editor edit = getSettingPreferences(ctx, storeName).edit();
        edit.putString(key, "" + value);
        edit.commit();
    }
    //清除指定的sp文件
    public static void clearStoreName(Context context, String storeName) {
        SharedPreferences.Editor edit = getSettingPreferences(context, storeName).edit();
        edit.clear();
        edit.apply();
    }

}
