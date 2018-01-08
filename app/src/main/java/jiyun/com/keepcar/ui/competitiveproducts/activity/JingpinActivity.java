package jiyun.com.keepcar.ui.competitiveproducts.activity;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.entity.DropBean;
import jiyun.com.keepcar.http.contract.InfoContract;
import jiyun.com.keepcar.http.presenter.PresenterInfo;
import jiyun.com.keepcar.ui.BaseActivity;
import jiyun.com.keepcar.ui.Constant;
import jiyun.com.keepcar.ui.competitiveproducts.adapter.JPrecyclerview;
import jiyun.com.keepcar.ui.competitiveproducts.bean.Competpd;
import jiyun.com.keepcar.utils.Cjson;
import jiyun.com.keepcar.utils.PopupwindowView;
import jiyun.com.keepcar.view.DropdownButton;
import jiyun.com.keepcar.view.MyApptitle;

public class JingpinActivity extends BaseActivity implements View.OnClickListener,CompoundButton.OnCheckedChangeListener,InfoContract.Views<Competpd>{
    private MyApptitle App_title;
    private LinearLayout kind;
    private LinearLayout no_xianzhi;
    private LinearLayout sort;
    private CheckBox cb_kind;
    private CheckBox cb_buxian;
    private DropdownButton cb_sort;
     private PopupwindowView popupwindowView;
    private LinearLayout linearLayout;
    private List<DropBean> time;

    private String str_kind;
    private String str_buxian;
    private String str_sort;

    private String BASE_URLSTRING="/boutique/showProduct.do";
    private List<Competpd.DataBean.ListBean> listBeen;
    private RecyclerView jp_recyclerview;
    @Override
    protected void initView() {
        App_title= (MyApptitle) findViewById(R.id.App_title);
        App_title.setCenterTv("4S店精品","#FFFFFF");
        App_title.setLeftImg(getResources().getDrawable(R.mipmap.back));
        TextViewClickListener(App_title);
        time=new ArrayList<>();
        listBeen=new ArrayList<>();
        jp_recyclerview= (RecyclerView) findViewById(R.id.jp_recyclerview);
        kind= (LinearLayout) findViewById(R.id.kind);
        no_xianzhi= (LinearLayout) findViewById(R.id.no_xianzhi);
        sort= (LinearLayout) findViewById(R.id.sort_jingpin);

        cb_kind= (CheckBox) findViewById(R.id.cb_kind);
        cb_kind.setOnCheckedChangeListener(this);
        cb_buxian= (CheckBox) findViewById(R.id.cb_buxian);
        cb_buxian.setOnCheckedChangeListener(this);
        cb_sort= (DropdownButton) findViewById(R.id.cb_sort);

        linearLayout= (LinearLayout) findViewById(R.id.line1);
        initAdapter();

    }

    @Override
    protected void initData() {
        time.add(new DropBean("排序"));
        time.add(new DropBean("默认排序"));
        time.add(new DropBean("销量最高"));
        time.add(new DropBean("价格最低"));
        cb_sort.setData(time);
        str_kind=cb_kind.getText().toString();
        str_buxian=cb_buxian.getText().toString();
        str_sort=cb_sort.text.getText().toString();

        Map<String,Object> map=new HashMap<>();
        map.put("shopCode",str_buxian);
        map.put("searchType",str_sort);
        map.put("pageSize","10");
        map.put("pageNum",0);

        String json= Cjson.toJSONMap(map);
        Log.e("TAG",json);
        PresenterInfo presenterInfo=new PresenterInfo(this,this);
        presenterInfo.getNewsData(Constant.URL_STRING+BASE_URLSTRING,json);



    }

    private void initAdapter() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_jingpin;
    }

    @Override
    public void onClick(View view) {

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        boolean checked = compoundButton.isChecked();
        switch (compoundButton.getId()){
            case R.id.cb_kind:

                break;
            case R.id.cb_buxian:
                break;
        }
    }


    @Override
    public void success(Competpd competpd) {

        List<Competpd.DataBean.ListBean> list = competpd.getData().getList();

        Log.e("TAG","数组的长度为------------------------"+list.size()+"");
        listBeen.addAll(list);
        GridLayoutManager manager=new GridLayoutManager(this,2);

        jp_recyclerview.setLayoutManager(manager);
        JPrecyclerview jPrecyclerview=new JPrecyclerview(this,listBeen);
        jp_recyclerview.setAdapter(jPrecyclerview);
        jPrecyclerview.ItemOnclick(new JPrecyclerview.ItemOnclick() {
            @Override
            public void setItemOnclick(int position) {
                 startActivity(new Intent(JingpinActivity.this,CpvProductItemActivity.class));
            }
        });
    }

    @Override
    public void failure(Throwable e) {

    }
}
