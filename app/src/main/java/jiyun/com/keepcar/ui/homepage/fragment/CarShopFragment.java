package jiyun.com.keepcar.ui.homepage.fragment;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.bean.TestBean;
import jiyun.com.keepcar.ui.adapter.ForeCarAdapter;
import jiyun.com.keepcar.ui.homepage.forecar.Car_details;







public class CarShopFragment extends Fragment {


    private View inflate;
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
    private ListView foreListView;
    public CarShopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_car_shop, container, false);
        initView(inflate);
        initPopupwindows();
        initLinnsert();
        initData();
        return inflate;
    }

    private void initData() {
        ArrayList<TestBean> testBeen = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            testBeen.add(new TestBean("https://img01.sogoucdn.com/net/a/04/link?url=http%3A%2F%2Fimg02.sogoucdn.com%2Fapp%2Fa%2F100520093%2Fb02984f46fae9d60-83addf1637031898-c0f2a058a6f60e7ff0c4a56701ab619a.jpg&appid=122","豪车"+i,"400"+i));
        }
        ForeCarAdapter foreCarAdapter = new ForeCarAdapter(testBeen, getActivity());
        foreListView.setAdapter(foreCarAdapter);
    }
//
//

    private void initView(View inflate) {
        brand = (CheckBox) inflate.findViewById(R.id.brand);
        storefront = (CheckBox) inflate.findViewById(R.id.storefront);
        sort = (CheckBox) inflate.findViewById(R.id.sort);
        linlayout = (LinearLayout) inflate.findViewById(R.id.linlayout);
        foreListView = (ListView) inflate.findViewById(R.id.foreListView);
    }
    private void initLinnsert() {

        foreListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(getActivity(),Car_details.class));
            }
        });
    }

    private void initPopupwindows() {
        //----------------------------------------------品牌PopupWindows----------------------------------------------
     /*   View popupview = LayoutInflater.from(ForeCarActivity.this).inflate(R.layout.popupone, null);
        PopupWindow pinpaiPop = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pinpaiPop.setBackgroundDrawable(new BitmapDrawable());
        //pinpaiPop.showAtLocation(linlayout,Gravity.BOTTOM,0,0);
        pinpaiPop.showAsDropDown(linlayout);*/

        //第二个PopupWindows事件
        storefront.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    showPopOne();
                } else {
                    disPopOne();
                }


            }


        });
        sort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    showPopThree();

                } else {
                    disPopThree();
                }


            }
        });
    }




    private void showPopOne() {
        //----------------------------------------------店面PopupWindows----------------------------------------------
        View popupview2 = LayoutInflater.from(getActivity()).inflate(R.layout.poputwo, null);
        pinpaiPop2 = new PopupWindow(popupview2, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pinpaiPop2.setBackgroundDrawable(new BitmapDrawable());
        pinpaiPop2.setBackgroundDrawable(new ColorDrawable());
        pinpaiPop2.showAsDropDown(linlayout, 0, 0, Gravity.BOTTOM);
        if (pinpaiPop2.isShowing()) {
            WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
            attributes.alpha = 0.5f;
            getActivity().getWindow().setAttributes(attributes);
        }
        pinpaiPop2.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
                attributes.alpha = 1.0f;
                getActivity().getWindow().setAttributes(attributes);
            }
        });
        pinpaiPop2.setFocusable(true);

        raone = (RadioButton) popupview2.findViewById(R.id.raOne);
        raTwo = (RadioButton) popupview2.findViewById(R.id.raTwo);
        raThree = (RadioButton) popupview2.findViewById(R.id.raThree);
        raone.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (raone.isChecked()) {
//            storefront.setText("店面不限");
                    raone.setTextColor(Color.RED);
                    storefront.setChecked(false);
                    Toast.makeText(getActivity(), "店面不限", Toast.LENGTH_SHORT).show();
                } else {
//            storefront.setText("店面不限");
                    raone.setTextColor(Color.BLACK);
                }
            }
        });


        raTwo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (raTwo.isChecked()) {
//            storefront.setText("店面不限");
                    raTwo.setTextColor(Color.RED);
                    pinpaiPop2.dismiss();
                    storefront.setChecked(false);
                    Toast.makeText(getActivity(), "我的会员单", Toast.LENGTH_SHORT).show();
                } else {
//            storefront.setText("店面不限");
                    raTwo.setTextColor(Color.BLACK);
                }
            }
        });
        raThree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (raThree.isChecked()) {
//            storefront.setText("店面不限");
                    raThree.setTextColor(Color.RED);
                    pinpaiPop2.dismiss();
                    storefront.setChecked(false);
                    Toast.makeText(getActivity(), "历史下单店", Toast.LENGTH_SHORT).show();
                } else {
//            storefront.setText("店面不限");
                    raThree.setTextColor(Color.BLACK);
                }
            }
        });


    }

    private void disPopOne() {
        pinpaiPop2.dismiss();
    }

    private void showPopThree() {
        //----------------------------------------------排序PopupWindows----------------------------------------------
        final View popupview3 = LayoutInflater.from(getActivity()).inflate(R.layout.poputhree, null);
        pinpaiPop3 = new PopupWindow(popupview3, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        pinpaiPop3.setBackgroundDrawable(new BitmapDrawable());

        pinpaiPop3.showAsDropDown(linlayout, 0, 0, Gravity.BOTTOM);
        if (pinpaiPop3.isShowing()){
            pinpaiPop2.dismiss();
            WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
            attributes.alpha = 0.5f;
            getActivity().getWindow().setAttributes(attributes);
        }
        pinpaiPop3.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams attributes = getActivity().getWindow().getAttributes();
                attributes.alpha = 1.0f;
                getActivity().getWindow().setAttributes(attributes);
            }
        });
        pinpaiPop2.setFocusable(true);
        aDefault = (RadioButton) popupview3.findViewById(R.id.Default);
        Distance = (RadioButton) popupview3.findViewById(R.id.Distance);
        Evaluate = (RadioButton) popupview3.findViewById(R.id.Evaluate);

        Distance.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    pinpaiPop3.dismiss();
                    sort.setChecked(false);
                    Distance.setTextColor(Color.RED);
                    Toast.makeText(getActivity(), "距离最近", Toast.LENGTH_SHORT).show();
                } else {
                    Distance.setTextColor(Color.BLACK);
                }
            }
        });
        //
        aDefault.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    pinpaiPop3.dismiss();
                    sort.setChecked(false);
                    aDefault.setTextColor(Color.RED);
                    Toast.makeText(getActivity(), "默认排序", Toast.LENGTH_SHORT).show();
                } else {
                    aDefault.setTextColor(Color.BLACK);
                }
            }
        });
        Evaluate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    pinpaiPop3.dismiss();
                    sort.setChecked(false);
                    Evaluate.setTextColor(Color.RED);
                    Toast.makeText(getActivity(), "评价最高", Toast.LENGTH_SHORT).show();
                } else {
                    Evaluate.setTextColor(Color.BLACK);
                }
            }
        });
    }

    private void disPopThree() {
        pinpaiPop3.dismiss();
    }

}
