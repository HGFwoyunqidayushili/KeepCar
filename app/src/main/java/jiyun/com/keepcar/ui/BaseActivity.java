package jiyun.com.keepcar.ui;

import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.widget.Toast;

import com.zhy.autolayout.AutoLayoutActivity;

import jiyun.com.keepcar.view.MyApptitle;

public abstract class BaseActivity extends AutoLayoutActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutID());
        initView();
        initData();
    }
    /**
     * 判断手机是否有网络
     *
     * @return true 有网络
     */
    public boolean isConnected() {
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        try {
            ConnectivityManager connectivity = (ConnectivityManager) this
                    .getSystemService(this.CONNECTIVITY_SERVICE);
            if (connectivity != null) {
                // 获取网络连接管理的对象
                NetworkInfo info = connectivity.getActiveNetworkInfo();

                if (info != null && info.isConnected()) {
                    // 判断当前网络是否已经连接
                    if (info.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
   public void showToast(String message){
       Toast.makeText(BaseActivity.this, message, Toast.LENGTH_SHORT).show();
   }
    protected abstract void initView();

    protected abstract void initData();

    protected abstract int getLayoutID();




   //标题监听事件
    public void TextViewClickListener(MyApptitle App_title){
        App_title.setOnTextViewClickListener(new MyApptitle.OnTextViewClickListener(){
            @Override
            public void OnLeftImgClick() {
                super.OnLeftImgClick();
                finish();
            }
        });
    }
    //标题栏设置中间文字
    public void setCenterTv(MyApptitle App_title,String centerTv){
        App_title.setCenterTv(centerTv,"#ffffff");
    }

    //设置标题栏右边边文字

    public void setRightTv(MyApptitle App_title,String rightTv){
        App_title.setCenterTv(rightTv,"#ffffff");
    }
    //设置标题栏右边图片
    public void setRigthImage(MyApptitle App_title,Drawable draw){
        App_title.setRightImg(draw);
    }
}
