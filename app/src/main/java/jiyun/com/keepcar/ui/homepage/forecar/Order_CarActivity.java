package jiyun.com.keepcar.ui.homepage.forecar;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.keepcar.R;

public class Order_CarActivity extends AppCompatActivity implements View.OnClickListener {
//
    private ViewPager vp;
    private TextView button;
    private int[] res = {R.drawable.car1, R.drawable.car2, R.drawable.car3};
    private List<ImageView> listdata = new ArrayList<ImageView>();
    private ListView order_listView;
    private Button insertorder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__car);
        initView();
        initHeader();
    }

    private void initHeader() {
        View headerLayout = View.inflate(Order_CarActivity.this, R.layout.headerfroelayout, null);
        order_listView.addHeaderView(headerLayout);
    }


    private void initView() {
        order_listView = (ListView) findViewById(R.id.order_listView);
        insertorder = (Button) findViewById(R.id.insertorder);
        insertorder.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insertorder:

//        弹出一个popupwindow

//        加载popupwndow的布局
               View popupview = LayoutInflater.from(Order_CarActivity.this).inflate(R.layout.insertorser, null);
//        创建一个popupWindow对象
                PopupWindow popupWindow=new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//        默认获取不到焦点，设置获取焦点
                popupWindow.setFocusable(true);
//        点击窗口以外的区域，窗口消失
//        popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
//        弹出或者消失的时候带动画效果
                popupWindow.setAnimationStyle(R.style.mypopupwindow);

//        显示popupwindow
                popupWindow.showAtLocation(popupview, Gravity.BOTTOM,0,0);
                break;
        }
    }
}
