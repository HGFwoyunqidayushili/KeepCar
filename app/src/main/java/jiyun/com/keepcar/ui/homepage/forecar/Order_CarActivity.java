package jiyun.com.keepcar.ui.homepage.forecar;

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
import android.widget.EditText;
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
    private int[] res = {R.drawable.hanmacar, R.drawable.pao1, R.drawable.pao2};
    private List<ImageView> listdata = new ArrayList<ImageView>();
    private ListView order_listView;
    private Button insertorder;
    private TextView button;
    private Button Immediately_goumai;
    private int a;
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__car);
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
        vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                button.setText((position + 1) + "/" + listdata.size());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    private void initView() {
        insertorder = (Button) findViewById(R.id.insertorder);
        insertorder.setOnClickListener(this);
        vp = (ViewPager) findViewById(R.id.xicheViewPager);
        vp.setOnClickListener(this);
        button = (TextView) findViewById(R.id.button);
        button.setOnClickListener(this);
        Immediately_goumai = (Button) findViewById(R.id.Immediately_goumai);
        Immediately_goumai.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insertorder:

//        弹出一个popupwindow

//        加载popupwndow的布局
                View popupview = LayoutInflater.from(Order_CarActivity.this).inflate(R.layout.insertorser, null);
//        创建一个popupWindow对象
                PopupWindow popupWindow = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        默认获取不到焦点，设置获取焦点
                popupWindow.setFocusable(true);
//        点击窗口以外的区域，窗口消失
//        popupWindow.setOutsideTouchable(true);
                popupWindow.setBackgroundDrawable(new BitmapDrawable());
//        弹出或者消失的时候带动画效果
                popupWindow.setAnimationStyle(R.style.mypopupwindow);

//        显示popupwindow
                popupWindow.showAtLocation(popupview, Gravity.BOTTOM, 0, 0);
                Button jia = (Button) popupview.findViewById(R.id.jia);
                Button jian = (Button) popupview.findViewById(R.id.jian);
                final EditText jiage = (EditText) popupview.findViewById(R.id.jiage);
                a = 1;
                jia.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                      a++;
                        jiage.setText(a+"");
                    }
                });
                jian.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>1){
                            a--;
                            jiage.setText(a+"");
                        }
                    }
                });
                break;
            case R.id.Immediately_goumai:

//        弹出一个popupwindow

//        加载popupwndow的布局
                View popupview1 = LayoutInflater.from(Order_CarActivity.this).inflate(R.layout.insertorser, null);
//        创建一个popupWindow对象
                PopupWindow popupWindow1 = new PopupWindow(popupview1, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        默认获取不到焦点，设置获取焦点
                popupWindow1.setFocusable(true);
//        点击窗口以外的区域，窗口消失
//        popupWindow.setOutsideTouchable(true);
                popupWindow1.setBackgroundDrawable(new BitmapDrawable());
//        弹出或者消失的时候带动画效果
                popupWindow1.setAnimationStyle(R.style.mypopupwindow);

//        显示popupwindow
                popupWindow1.showAtLocation(popupview1, Gravity.BOTTOM, 0, 0);
                Button jia1 = (Button) popupview1.findViewById(R.id.jia);
                Button jian1 = (Button) popupview1.findViewById(R.id.jian);
                final EditText jiage1 = (EditText) popupview1.findViewById(R.id.jiage);
                a = 1;
                jia1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        a++;
                        jiage1.setText(a+"");
                    }
                });
                jian1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (a>1){
                            a--;
                            jiage1.setText(a+"");
                        }
                    }
                });
                break;
        }
    }
}
