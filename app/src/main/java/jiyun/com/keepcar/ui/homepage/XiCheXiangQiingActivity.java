package jiyun.com.keepcar.ui.homepage;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;

import jiyun.com.keepcar.R;

public class XiCheXiangQiingActivity extends AppCompatActivity {

    private ImageView Local_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xi_che_xiang_qiing);
        initView();
        initLinnser();
    }

    private void initLinnser() {
Local_account.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {


//      加载popupwndow的布局
        View popupview = LayoutInflater.from(XiCheXiangQiingActivity.this).inflate(R.layout.xichexaingqing, null);
//        创建一个popupWindow对象
        PopupWindow popupWindow=new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//       默认获取不到焦点，设置获取焦点
        popupWindow.setFocusable(true);
//        点击窗口以外的区域，窗口消失
//        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
//        弹出或者消失的时候带动画效果
        popupWindow.setAnimationStyle(R.style.mypopupwindow);
//        显示popupwindow
        popupWindow.showAtLocation(popupview, Gravity.BOTTOM,0,0);
    }
});
    }

    private void initView() {
        Local_account = (ImageView) findViewById(R.id.Local_account);
    }
}
