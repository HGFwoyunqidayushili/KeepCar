package jiyun.com.keepcar.ui.adapter.carRenewal.activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.http.contract.InfoContract;
import jiyun.com.keepcar.http.presenter.PresenterInfo;
import jiyun.com.keepcar.ui.BaseActivity;
import jiyun.com.keepcar.ui.Constant;
import jiyun.com.keepcar.ui.adapter.carRenewal.adapter.InsuranceName;
import jiyun.com.keepcar.ui.adapter.carRenewal.bean.Insurancecompany;
import jiyun.com.keepcar.utils.Popupwindow;
import jiyun.com.keepcar.view.MyApptitle;

public class RenewalAcrivity extends BaseActivity implements View.OnClickListener,InfoContract.Views<Insurancecompany> {
//
   private MyApptitle App_title;
   private RelativeLayout last_Insurance;
   private RelativeLayout this_Insurance;
    private PresenterInfo presenterInfo;
    private String BASE_URLSTRING="/instruction/company.do";
    private TextView textView1;
    private TextView textView2;
    private List<Insurancecompany.DataBean> insurancecompanyList;
    private Popupwindow popupwindow;
    private ListView listView;
    private Button bt_Quotation;

    @Override
    protected void initView() {
        presenterInfo=new PresenterInfo(this,this);
        presenterInfo.getNewsData(Constant.URL_STRING+BASE_URLSTRING,"");
       App_title= (MyApptitle) findViewById(R.id.App_title);
        App_title.setCenterTv("4S店续保","#FFFFFF");
        App_title.setLeftImg(getResources().getDrawable(R.mipmap.back));
        TextViewClickListener(App_title);
        last_Insurance= (RelativeLayout) findViewById(R.id.last_Insurance);
        last_Insurance.setOnClickListener(this);
        this_Insurance= (RelativeLayout) findViewById(R.id.this_Insurance);
        this_Insurance.setOnClickListener(this);
        textView1= (TextView) findViewById(R.id.text1);
        textView2= (TextView) findViewById(R.id.text2);
        insurancecompanyList=new ArrayList<>();
        bt_Quotation= (Button) findViewById(R.id.bt_quotation);
        bt_Quotation.setOnClickListener(this);
    }
///
    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_renewal_acrivity;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.last_Insurance:

                break;
            case R.id.this_Insurance:
                View contentview= LayoutInflater.from(this).inflate(R.layout.insurance,null);
                listView= (ListView) contentview.findViewById(R.id.lv_lv);
                popupwindow=new Popupwindow(this,contentview,textView2);
                popupwindow.show();
                InsuranceName insuranceName=new InsuranceName(this,insurancecompanyList);
                listView.setAdapter(insuranceName);
                break;
            case R.id.bt_quotation:
             View contenteview=LayoutInflater.from(this).inflate(R.layout.quotation,null);
                popupwindow=new Popupwindow(this,contenteview,bt_Quotation);
                popupwindow.show();
                break;
        }
    }


    @Override
    public void success(Insurancecompany insurancecompany) {
        List<Insurancecompany.DataBean> data = insurancecompany.getData();
        insurancecompanyList.addAll(data);
        Log.e("TAG",insurancecompanyList.get(0).getName());
    }

    @Override
    public void failure(Throwable e) {

    }

    @Override
    public void successTwo(Insurancecompany insurancecompany) {

    }


}
