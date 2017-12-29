package jiyun.com.keepcar.ui.homepage.forecar;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.keepcar.R;

public class Order_CarActivity extends AppCompatActivity {

    private ViewPager vp;
    private TextView button;
    private int[] res = {R.drawable.car1, R.drawable.car2, R.drawable.car3};
    private List<ImageView> listdata = new ArrayList<ImageView>();
    private ListView order_listView;

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
    }
}
