package jiyun.com.keepcar.ui.homepage;

import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;

import java.util.ArrayList;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.bean.TestBean;

public class XiCheActivity extends AppCompatActivity {


    private CheckBox dianmian;
    private CheckBox paixu;
    private LinearLayout activity_xi_che;
    private LinearLayout layout;
    private PopupWindow popupWindow;
    private ListView xicheListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xi_che);
        initView();
        initData();
    }

    private void initData() {
        for (int i = 0; i < 15; i++) {
        }
    }


    private void initView() {
        dianmian = (CheckBox) findViewById(R.id.dianmian);
        paixu = (CheckBox) findViewById(R.id.paixu);
        activity_xi_che = (LinearLayout) findViewById(R.id.activity_xi_che);
        dianmian.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
                if (dianmian.isChecked()) {
                    View popupview = LayoutInflater.from(XiCheActivity.this).inflate(R.layout.xichepopone, null);
                    popupWindow = new PopupWindow(popupview, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                    popupWindow.setBackgroundDrawable(new BitmapDrawable());
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.showAsDropDown(layout);
                    paixu.setChecked(false);
                    final RadioButton dianmianbuxian = popupview.findViewById(R.id.dianmian_Nolimit);
                    final RadioButton allxiche = popupview.findViewById(R.id.allxiche);
                    final RadioButton allvip = popupview.findViewById(R.id.allvip);
                    final RadioButton order4s = popupview.findViewById(R.id.order4s);
                    final RadioButton historyxidan = popupview.findViewById(R.id.historyxidan);
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
}
