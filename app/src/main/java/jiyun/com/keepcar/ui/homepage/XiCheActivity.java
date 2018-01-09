package jiyun.com.keepcar.ui.homepage;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.bean.TestBean;
import jiyun.com.keepcar.bean.XiCheBean;
import jiyun.com.keepcar.http.contract.InfoContract;
import jiyun.com.keepcar.http.presenter.PresenterInfo;
import jiyun.com.keepcar.ui.adapter.TestAdapter;
import jiyun.com.keepcar.utils.ZJson;

public class XiCheActivity extends AppCompatActivity implements InfoContract.Views<XiCheBean> {

    private final String URL = "http://39.106.173.47:8080/app/washcar/queryWashShops.do?ak=f4474404846d470a8e1f6c081a28acc5&channel=android";
    private CheckBox dianmian;
    private CheckBox paixu;
    private LinearLayout activity_xi_che;
    private LinearLayout layout;
    private PopupWindow popupWindow;
    private ListView xicheListView;
    private ArrayList<TestBean> testBeen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xi_che);
        initView();
        initData();

    }



    private void initData() {
        Map<String, Object> map = new HashMap<>();

        map.put("shopCode","店面不限");
        map.put("searchType","默认排序");

        map.put("pageNum",0);
        map.put("pageSize",5);
        String s = ZJson.toJSONMap(map);
        PresenterInfo presenterInfo = new PresenterInfo(this, this);
        presenterInfo.getNewsData(URL,s);

    }


    private void initView() {
        dianmian = (CheckBox) findViewById(R.id.dianmian);
        paixu = (CheckBox) findViewById(R.id.paixu);
        activity_xi_che = (LinearLayout) findViewById(R.id.activity_xi_che);
        dianmian.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (dianmian.isChecked()) {
                    dianmian.setTextColor(Color.RED);
                    View popupview = LayoutInflater.from(XiCheActivity.this).inflate(R.layout.xichepopone, null);
                    popupWindow = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.showAsDropDown(layout);

                    if (popupWindow.isShowing()){
                        WindowManager.LayoutParams lp = getWindow().getAttributes();
                        lp.alpha=0.5f;
                        getWindow().setAttributes(lp);
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                    }
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            WindowManager.LayoutParams lp = getWindow().getAttributes();
                            lp.alpha=1f;
                            getWindow().setAttributes(lp);
                            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

                        }
                    });
                    paixu.setChecked(false);
                    final RadioButton dianmianbuxian = (RadioButton) popupview.findViewById(R.id.dianmian_Nolimit);
                    final RadioButton allxiche = (RadioButton) popupview.findViewById(R.id.allxiche);
                    final RadioButton allvip = (RadioButton) popupview.findViewById(R.id.allvip);
                    final RadioButton order4s = (RadioButton) popupview.findViewById(R.id.order4s);
                    final RadioButton historyxidan = (RadioButton) popupview.findViewById(R.id.historyxidan);
                    dianmianbuxian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if (b == true) {
                                dianmianbuxian.setTextColor(Color.RED);
                            } else {
                                dianmianbuxian.setTextColor(Color.BLACK);
                            }
                        }
                    });
                    allxiche.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if (b == true) {
                                allxiche.setTextColor(Color.RED);
                            } else {
                                allxiche.setTextColor(Color.BLACK);
                            }
                        }
                    });
                    allvip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if (b == true) {
                                allvip.setTextColor(Color.RED);
                            } else {
                                allvip.setTextColor(Color.BLACK);
                            }
                        }
                    });
                    order4s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if (b == true) {
                                order4s.setTextColor(Color.RED);
                            } else {
                                order4s.setTextColor(Color.BLACK);
                            }
                        }
                    });
                    historyxidan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            if (b == true) {
                                historyxidan.setTextColor(Color.RED);
                            } else {
                                historyxidan.setTextColor(Color.BLACK);
                            }
                        }
                    });
                } else if (!dianmian.isChecked()) {
                    dianmian.setTextColor(Color.BLACK);
                    popupWindow.dismiss();
                }

            }
        });
        paixu.setOnClickListener(new View.OnClickListener() {

            private PopupWindow popupWindow1;

            @Override
            public void onClick(View view) {
                if (paixu.isChecked()) {
                    View popupview = LayoutInflater.from(XiCheActivity.this).inflate(R.layout.xichepopone, null);

                    popupWindow1 = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow1.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow1.setOutsideTouchable(true);
                    popupWindow1.showAsDropDown(layout);
                    dianmian.setChecked(false);
                } else if (!paixu.isChecked()) {
                    popupWindow1.dismiss();
                }
            }
        });
        layout = (LinearLayout) findViewById(R.id.layout);
        xicheListView = (ListView) findViewById(R.id.xicheListView);
    }

    @Override
    public void success(XiCheBean xiCheBean) {
        List<XiCheBean.DataBean.ListBean> list = xiCheBean.getData().getList();
        TestAdapter testAdapter = new TestAdapter(list,XiCheActivity.this);
        xicheListView.setAdapter(testAdapter);
        xicheListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(XiCheActivity.this,XiCheXiangQiingActivity.class));
            }
        });

    }

    @Override
    public void failure(Throwable e) {

    }
}
