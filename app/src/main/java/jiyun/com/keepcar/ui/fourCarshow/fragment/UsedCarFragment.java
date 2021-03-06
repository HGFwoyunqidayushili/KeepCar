package jiyun.com.keepcar.ui.fourCarshow.fragment;


import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.gjiazhe.wavesidebar.WaveSideBar;

import java.util.ArrayList;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseFragment;
import jiyun.com.keepcar.ui.fourCarshow.adapter.MyBrandAdapter;
import jiyun.com.keepcar.ui.fourCarshow.bean.MyBrandBean;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsedCarFragment extends BaseFragment implements WaveSideBar.OnSelectIndexItemListener{

    private CheckBox brand;
    private CheckBox storefront;
    private CheckBox sort;
    private CheckBox shaixuan;
    private LinearLayout line_shop;
    private ListView lv_shop;
    private RecyclerView mBrandList;
    private ArrayList<MyBrandBean> myBrandBeen;
    private View view;
    public UsedCarFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_used_car, container, false);
        initView();
        initData();
        return view;
    }
    @Override
    protected void initView() {
        brand = (CheckBox) view.findViewById(R.id.btn_shop_brand);
        storefront = (CheckBox) view.findViewById(R.id.btn_shop_storefront);
        sort = (CheckBox) view.findViewById(R.id.btn_shop_sort);
        shaixuan = (CheckBox) view.findViewById(R.id.btn_shop_shaixuan);
        line_shop = (LinearLayout) view.findViewById(R.id.line_shop);
        initLstener();
    }

    private void initLstener() {
        //品牌
        brand.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (brand.isChecked()) {
                    View mBrandView = LayoutInflater.from(getActivity()).inflate(R.layout.brand_pop, null);
                    initBrandView(mBrandView);
                    showPops(mBrandView);
                }
            }

        });
        //4S店不限
        storefront.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (storefront.isChecked()) {
                    View mShopStoreView = LayoutInflater.from(getActivity()).inflate(R.layout.shop_store_pop, null);
                    initShopStoreView(mShopStoreView);
                    showPop(mShopStoreView);
                }
            }
        });
        //排序
        sort.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sort.isChecked()) {
                    View mSortView = LayoutInflater.from(getActivity()).inflate(R.layout.sort_pop, null);
                    initSortView(mSortView);
                    showPop(mSortView);
                }
            }
        });
        //筛选
        shaixuan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (shaixuan.isChecked()) {
                    View mSortView = LayoutInflater.from(getActivity()).inflate(R.layout.popuwindow_screen, null);
//                    initSortView(mSortView);
                    screenPop(mSortView);
                }

            }


        });
    }

    private void screenPop(View mSortView) {
        PopupWindow popupWindow = new PopupWindow(mSortView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        popupWindow.setBackgroundDrawable(new BitmapDrawable());

        popupWindow.setFocusable(true);

        // 设置点击其他地方 就消失 (只设置这个，没有效果) 必须设置背景
        popupWindow.setOutsideTouchable(true);

        popupWindow.setTouchable(true);

        popupWindow.setAnimationStyle(R.style.AnimationTopFade); // 设置动画

        popupWindow.showAsDropDown(line_shop, 0, 0);

//        if (popupWindow.isShowing()) {
//            WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
//            params.alpha = 0.5f;
//            getActivity().getWindow().setAttributes(params);
//        }

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams params = getActivity().getWindow().getAttributes();
                params.alpha = 1f;
                getActivity().getWindow().setAttributes(params);
                shaixuan.setChecked(false);
            }
        });
    }

    private void initSortView(View mSortView) {
        RadioGroup rg_sort_pop = (RadioGroup) mSortView.findViewById(R.id.rg_sort_pop);
        RadioButton rb_default = (RadioButton) mSortView.findViewById(R.id.rb_default);
        RadioButton rb_recently = (RadioButton) mSortView.findViewById(R.id.rb_recently);
    }

    private void showPop(View mShopStoreView) {
        PopupWindow popupWindow = new PopupWindow(mShopStoreView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,true);
        //动画效果
        popupWindow.setAnimationStyle(R.style.AnimationTopFade);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        //菜单背景色
        ColorDrawable dw = new ColorDrawable(Color.TRANSPARENT);
        popupWindow.setBackgroundDrawable(dw);
        //关闭事件
        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAsDropDown(line_shop,0,0);


        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                brand.setChecked(false);
                storefront.setChecked(false);
                sort.setChecked(false);
                shaixuan.setChecked(false);
            }
        });
    }

    private void initShopStoreView(View mShopStoreView) {
        RadioGroup mRgShopStorePop = (RadioGroup) mShopStoreView.findViewById(R.id.rg_shop_store_pop);
        RadioButton mRbStoreFront = (RadioButton) mShopStoreView.findViewById(R.id.rb_storefront);
        RadioButton mRbMember = (RadioButton) mShopStoreView.findViewById(R.id.rb_member);
        RadioButton mRbHistory = (RadioButton) mShopStoreView.findViewById(R.id.rb_history);
    }

    private void showPops(View mBrandView) {
        PopupWindow popupWindow = new PopupWindow(mBrandView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,true);
        //动画效果
        popupWindow.setAnimationStyle(R.style.AnimationTopFade);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        //菜单背景色
        ColorDrawable dw = new ColorDrawable(Color.TRANSPARENT);
        popupWindow.setBackgroundDrawable(dw);
        //关闭事件
        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.showAsDropDown(line_shop,0,0);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                brand.setChecked(false);
            }
        });
    }

    private void initBrandView(View mBrandView) {
        mBrandList = (RecyclerView) mBrandView.findViewById(R.id.recycler_view);
        WaveSideBar waveSideBar = (WaveSideBar) mBrandView.findViewById(R.id.side_bar);
        waveSideBar.setTextColor(Color.BLACK);
        waveSideBar.setMaxOffset(10);//字母偏移量
        waveSideBar.setPosition(WaveSideBar.POSITION_RIGHT);//侧边栏在左边还是右边
        waveSideBar.setLazyRespond(true);//false:列表随侧边栏的滚动滚动
        waveSideBar.setOnSelectIndexItemListener(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        mBrandList.setLayoutManager(linearLayoutManager);
        myBrandBeen = new ArrayList<>();

        MyBrandAdapter myAdapter = new MyBrandAdapter(myBrandBeen, getActivity());
        mBrandList.setAdapter(myAdapter);

        myBrandBeen.addAll(MyBrandBean.getEnglishContacts());
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onSelectIndexItem(String index) {
        for (int i = 0; i < myBrandBeen.size(); i++) {
            if (myBrandBeen.get(i).getIndex().equals(index)) {
                ((LinearLayoutManager) mBrandList.getLayoutManager()).scrollToPositionWithOffset(i, 0);
                return;
            }
        }
    }
}
