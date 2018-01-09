package jiyun.com.keepcar.ui.homepage.forecar;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.ArrayList;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.adapter.InsertFragment;
import jiyun.com.keepcar.ui.homepage.fragment.fragmentscar.Shopping_Fragment;

public class Car_details extends AppCompatActivity implements View.OnClickListener {
    private ImageView yue;
    private ImageView faxian;
    private LinearLayout topLinlayout;
    private ViewPagers foreViewpagers;
    private TabLayout tabLayout;
    private TextView fore_address;
    private TextView fore_name;
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        initView();
        initInsertFragment();
        getIntents();
    }

    private void initInsertFragment() {
        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Fragment> fragments = new ArrayList<>();
        strings.add("精品");
        strings.add("活动");
        strings.add("新车");
        strings.add("二手车");
        strings.add("积分商城");
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                tabLayout.addTab(tabLayout.newTab().setText(strings.get(i)));
                fragments.add(new Shopping_Fragment());
                tabLayout.setupWithViewPager(foreViewpagers);
            } else if (i > 0) {
                tabLayout.addTab(tabLayout.newTab().setText(strings.get(i)));
                fragments.add(new Shopping_Fragment());
                tabLayout.setupWithViewPager(foreViewpagers);
            }

            InsertFragment insertFragment = new InsertFragment(getSupportFragmentManager(), fragments, strings);
            foreViewpagers.setAdapter(insertFragment);
        }
    }

    private void initView() {
        yue = (ImageView) findViewById(R.id.yue);
        yue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Car_details.this, Order_CarActivity.class));
            }
        });
        faxian = (ImageView) findViewById(R.id.faxian);
        faxian.setOnClickListener(this);
        topLinlayout = (LinearLayout) findViewById(R.id.topLinlayout);
        topLinlayout.setOnClickListener(this);
        foreViewpagers = (ViewPagers) findViewById(R.id.foreViewpagers);
        foreViewpagers.setOnClickListener(this);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.setOnClickListener(this);
        fore_address = (TextView) findViewById(R.id.fore_address);
        fore_address.setOnClickListener(this);
        fore_name = (TextView) findViewById(R.id.fore_name);
        fore_name.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.faxian:
                View popupview2 = LayoutInflater.from(Car_details.this).inflate(R.layout.popupfaxian, null);

                PopupWindow pinpaiPop2 = new PopupWindow(popupview2, 80, ViewGroup.LayoutParams.WRAP_CONTENT);
                pinpaiPop2.setBackgroundDrawable(new BitmapDrawable());
                pinpaiPop2.setBackgroundDrawable(new ColorDrawable());

                pinpaiPop2.setFocusable(true);
//        点击窗口以外的区域，窗口消失
//        popupWindow.setOutsideTouchable(true);
                pinpaiPop2.showAsDropDown(topLinlayout, 258, -480, Gravity.TOP);
//                pinpaiPop2.showAtLocation(topLinlayout, 0, 0, Gravity.CENTER);
                if (pinpaiPop2.isShowing()) {
                    WindowManager.LayoutParams attributes = getWindow().getAttributes();
                    attributes.alpha = 0.5f;
                    getWindow().setAttributes(attributes);
                }
                pinpaiPop2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        WindowManager.LayoutParams attributes = getWindow().getAttributes();
                        attributes.alpha = 1.0f;
                        getWindow().setAttributes(attributes);
                    }
                });
                break;
        }
    }

    public void getIntents() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String carname = intent.getStringExtra("carname");
        fore_name.setText(carname);
        fore_address.setText(name);
    }
}
