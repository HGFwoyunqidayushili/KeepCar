package jiyun.com.keepcar.ui.homepage;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.homepage.forecar.Order_CarActivity;

public class JieZhangXiCheActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager xicheViewPager;
    private ViewPager vp;
    private int[] res = {R.drawable.hanmacar, R.drawable.pao1, R.drawable.pao2};
    private List<ImageView> listdata = new ArrayList<ImageView>();
    private Button lijigoumai;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jie_zhang_xi_che);
        initView();
        initData();
        initAdapter();
    }

    private void initAdapter() {
        vp.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return listdata.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = listdata.get(position);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((ImageView) object);
            }
        });
    }

    private void initData() {
        for (int i = 0; i < res.length; i++) {
            ImageView imageview = new ImageView(getApplication());
            imageview.setScaleType(ImageView.ScaleType.FIT_XY);
            imageview.setImageResource(res[i]);
            listdata.add(imageview);
        }
    }

    private void initView() {
        vp = (ViewPager) findViewById(R.id.xicheViewPager);
        lijigoumai = (Button) findViewById(R.id.lijigoumai);
        lijigoumai.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lijigoumai:

//        弹出一个popupwindow

//        加载popupwndow的布局
                View popupview1 = LayoutInflater.from(JieZhangXiCheActivity.this).inflate(R.layout.oderiteam, null);
//        创建一个popupWindow对象
                final PopupWindow popupWindow1 = new PopupWindow(popupview1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        默认获取不到焦点，设置获取焦点
                popupWindow1.setFocusable(true);
//        点击窗口以外的区域，窗口消失
//        popupWindow.setOutsideTouchable(true);
                popupWindow1.setBackgroundDrawable(new BitmapDrawable());
//        弹出或者消失的时候带动画效果
                popupWindow1.setAnimationStyle(R.style.mypopupwindow);
//        显示popupwindow
                popupWindow1.showAtLocation(popupview1, Gravity.BOTTOM, 0, 0);
                Button Determine = (Button) popupview1.findViewById(R.id.Determine);
                Determine.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         popupWindow1.dismiss();
                        View popupview3 = LayoutInflater.from(JieZhangXiCheActivity.this).inflate(R.layout.fukuaniteam, null);
                        final PopupWindow popupWindow33 = new PopupWindow(popupview3, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                        popupWindow33.setFocusable(true);
                        popupWindow33.setAnimationStyle(R.style.mypopupwindow);
                        popupWindow33.setBackgroundDrawable(new BitmapDrawable());
                        popupWindow33.showAtLocation(popupview3, Gravity.BOTTOM, 0, 0);
                        Button enter = (Button) popupview3.findViewById(R.id.enter);
                        enter.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                popupWindow33.dismiss();
                               startActivity(new Intent(JieZhangXiCheActivity.this,Success_Activity.class));
                            }
                        });

                    }
                });
                break;
        }
    }
}
