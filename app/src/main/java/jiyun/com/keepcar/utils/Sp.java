package jiyun.com.keepcar.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/1/5.
 */

public class Sp {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public Sp(Context context, String file) {
        sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        editor = sp.edit();
    }
    public void setLanguage(String language){
        editor.putString("language",language);
        editor.commit();
    }

    public String getLanguage(){
        return  sp.getString("language","");
    }
}
