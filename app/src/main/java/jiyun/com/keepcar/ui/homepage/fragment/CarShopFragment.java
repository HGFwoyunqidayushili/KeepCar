package jiyun.com.keepcar.ui.homepage.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.bean.TestBean;
import jiyun.com.keepcar.ui.adapter.ForeCarAdapter;
import jiyun.com.keepcar.ui.homepage.Utilscar.DropBean;
import jiyun.com.keepcar.ui.homepage.Utilscar.DropdownButton;
import jiyun.com.keepcar.ui.homepage.forecar.Car_details;


public class CarShopFragment extends Fragment {


    private CheckBox brand;
    private CheckBox storefront;
    private CheckBox sort;
    private LinearLayout linlayout;
    private RadioButton raone;
    private RadioButton raTwo;
    private RadioButton raThree;
    private PopupWindow pinpaiPop2;
    private PopupWindow pinpaiPop3;
    private RadioButton aDefault;
    private RadioButton Distance;
    private RadioButton Evaluate;
    DropdownButton dropdownButton1;
    DropdownButton dropdownButton2;
    DropdownButton dropdownButton3;
    List<DropBean> times;
    List<DropBean> types;
    List<DropBean> names;
    private ListView foreCarListView;
//

    public CarShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_car_shop, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        ArrayList<TestBean> testBeen = new ArrayList<>();
        for (int i = 1; i < 20; i++) {
            testBeen.add(new TestBean("昌平区第"+i+"大街"));
        }
        ForeCarAdapter foreCarAdapter = new ForeCarAdapter(testBeen, getActivity());
        foreCarListView.setAdapter(foreCarAdapter);
        foreCarListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), Car_details.class));
            }
        });
    }
//

    private void initSomeData() {
        times = new ArrayList<>();
        types = new ArrayList<>();
        names = new ArrayList<>();

        times.add(new DropBean("汽车品牌"));
        times.add(new DropBean("奥迪汽车"));
        times.add(new DropBean("奔驰汽车"));
        times.add(new DropBean("大众汽车"));
        times.add(new DropBean("宝马汽车"));


        types.add(new DropBean("店面不限"));
        types.add(new DropBean("全部会员店"));
        types.add(new DropBean("历史下单店 "));

        names.add(new DropBean("默认排序"));
        names.add(new DropBean("销量最高"));
        names.add(new DropBean("积分值最低"));
    }

    private void initView(View inflate) {
        dropdownButton1 = (DropdownButton) inflate.findViewById(R.id.time1);
        dropdownButton2 = (DropdownButton) inflate.findViewById(R.id.time2);
        dropdownButton3 = (DropdownButton) inflate.findViewById(R.id.time3);
        initSomeData();
        dropdownButton1.setData(times);
        dropdownButton2.setData(types);
        dropdownButton3.setData(names);
        foreCarListView = (ListView) inflate.findViewById(R.id.foreCarListView);
    }
}
