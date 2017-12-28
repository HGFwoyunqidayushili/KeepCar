package jiyun.com.keepcar.ui;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

/**
 * Created by 阿三 on 2017/12/27.
 */
public class App extends Application {

    public static BaseActivity activity;

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }

}
