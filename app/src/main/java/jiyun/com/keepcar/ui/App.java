package jiyun.com.keepcar.ui;

import android.app.Application;

import com.zhy.autolayout.config.AutoLayoutConifg;

import jiyun.com.keepcar.utils.Sp;

/**
 * Created by 阿三 on 2017/12/27.
 */
public class App extends Application {

    public static BaseActivity activity;
    private static App mApplication;
    public static final String SP_FILE_NAME = "SP_FILE";

    private Sp mSpUtil;
    public synchronized static App getInstance() {
        return mApplication;
    }


    public synchronized Sp getSpUtil() {
        if (mSpUtil == null)
            mSpUtil = new Sp(this, SP_FILE_NAME);
        return mSpUtil;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        AutoLayoutConifg.getInstance().useDeviceSize();
        mApplication=this;
    }
    private void initData() {
        mSpUtil = new Sp(this, SP_FILE_NAME);
    }
}
