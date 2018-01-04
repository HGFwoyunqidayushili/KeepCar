package jiyun.com.keepcar.ui.homepage.fragment;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.Gson;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.entity.homepage.CarActivity;
import jiyun.com.keepcar.entity.homepage.ImageBean;
import jiyun.com.keepcar.http.OkhttpUtils;
import jiyun.com.keepcar.http.contract.InfoContract;
import jiyun.com.keepcar.http.presenter.PresenterInfo;
import jiyun.com.keepcar.ui.App;
import jiyun.com.keepcar.ui.BaseFragment;
import jiyun.com.keepcar.ui.Constant;

import jiyun.com.keepcar.ui.homepage.XiCheActivity;

import jiyun.com.keepcar.ui.MainActivity;
import jiyun.com.keepcar.ui.adapter.carRenewal.activity.RenewalAcrivity;
import jiyun.com.keepcar.ui.fourCarshow.activity.FourcarShowActivity;
import jiyun.com.keepcar.utils.Cjson;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */



public class HomePageFragment extends BaseFragment implements View.OnClickListener,InfoContract.Views<ImageBean> {



    private View view;
    private View herder;
    private ListView lv;
    private Banner banner;
    private ViewFlipper viewFlipper;
    private ArrayList<String> testList=new ArrayList<>();
    private int count;

  
    private CheckBox xiiche;


    private String BASE_URLSTRING="/main/queryHotProduct.do";

 //   private String cityId=MainActivity.address.getText().toString();
    private MainActivity activity;

    private CheckBox radio_baoyang;
    private CheckBox radio_weixiu;
    private CheckBox radio_show;
    private CheckBox radio_xubao;
    private CheckBox radio_jingpin;
    private RecyclerView recyclerView;
    private List<CarActivity.DataBean> carActivityList;

    public HomePageFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home_page, container, false);
        herder=LayoutInflater.from(getActivity()).inflate(R.layout.header,null);
        initView();
        initListener();
        initData();
        return view;
    }
    @Override
    protected void initView() {
        carActivityList=new ArrayList<>();
        lv= (ListView) view.findViewById(R.id.lv);
        banner= (Banner) herder.findViewById(R.id.fly_banner);
        viewFlipper= (ViewFlipper) herder.findViewById(R.id.viewflipager);

        xiiche = herder.findViewById(R.id.xiche);
        xiiche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "洗车", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), XiCheActivity.class));
            }
        });
        lv.addHeaderView(herder);

        recyclerView= (RecyclerView) view.findViewById(R.id.recyclerview);
         lv.addHeaderView(herder);

        lv.setAdapter(null);

        radio_baoyang= (CheckBox) view.findViewById(R.id.radio_baoyang);
        radio_baoyang.setOnClickListener(this);
        radio_jingpin= (CheckBox) view.findViewById(R.id.radio_jingpin);
        radio_jingpin.setOnClickListener(this);
        radio_show= (CheckBox) view.findViewById(R.id.radio_show);
        radio_show.setOnClickListener(this);
        radio_jingpin= (CheckBox) view.findViewById(R.id.radio_jingpin);
        radio_jingpin.setOnClickListener(this);
        radio_weixiu= (CheckBox) view.findViewById(R.id.radio_weixiu);
        radio_weixiu.setOnClickListener(this);
        radio_xubao= (CheckBox) view.findViewById(R.id.radio_xubao);
        radio_xubao.setOnClickListener(this);
        testList.add( "爸妈爱的“白”娃娃，真是孕期吃出来的吗？");
        testList.add("如果徒步真的需要理由，十四个够不够？");
        testList.add( "享受清爽啤酒的同时，这些常识你真的了解吗？");
        testList.add( "三星Galaxy S8定型图无悬念");
        testList.add( "家猫为何如此高冷？");
        count=testList.size();
        for(int i=0;i<count;i++){
           View view=LayoutInflater.from(getActivity()).inflate(R.layout.item_flipper,null);
            TextView textView= (TextView) view.findViewById(R.id.title);
            textView.setText(testList.get(i));
            viewFlipper.addView(view);
        }
        initListener();

    }

    private void initListener() {


    }

    @Override
    protected void initData() {
        PresenterInfo presenterInfo=new PresenterInfo(this,getActivity());
        presenterInfo.getNewsData(Constant.URLIMAGE_STRING,"");
        Map<String,Object> map=new HashMap<>();
         map.put("cityId","");
          String json=Cjson.toJSONMap(map);
         OkhttpUtils.getInstance().getPost(Constant.URL_STRING + BASE_URLSTRING, json, new Callback() {
             public String string;

             @Override
             public void onFailure(Call call, IOException e) {

             }

             @Override
             public void onResponse(Call call, Response response) throws IOException {
                 string=response.body().string();
                 Gson gson=new Gson();
                 CarActivity carActivity=gson.fromJson(string,CarActivity.class);
                 List<CarActivity.DataBean> data = carActivity.getData();
                 carActivityList.addAll(data);
                 App.activity.runOnUiThread(new Runnable() {
                     @Override
                     public void run() {

                     }
                 });

             }
         });


    }


    @Override
    public void success(ImageBean imageBean) {
        List<String> listimage=imageBean.getData();
        List<String> list=new ArrayList<>();
        Log.e("TAG",listimage.size()+"");
         for(int i=0;i<listimage.size();i++){
                list.add(Constant.HOMEPAGE_IMAURL+listimage.get(i));
         }
//        MyA myA=new MyA(list,getActivity());
//        lv.setAdapter(myA);myA
        Log.e("TAG",list.get(0));
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(list);
        banner.start();

/////
    }
/*
  热门推荐
 */


    @Override
    public void failure(Throwable e) {

    }

    @Override

    

    public void successTwo(ImageBean imageBean) {

    }




    @Override
    public void onClick(View view) {
        Intent intent;
         switch (view.getId()){
             case R.id.radio_baoyang:
                 break;
             case R.id.radio_weixiu:
                 break;
             case R.id.radio_show:
                 intent=new Intent(getActivity(), FourcarShowActivity.class);
                 startActivity(intent);
                 break;
             case R.id.radio_xubao:
                 intent=new Intent(getActivity(), RenewalAcrivity.class);
                 startActivity(intent);
                 break;
             case R.id.radio_jingpin:
                 break;
         }

    }

    class GlideImageLoader extends ImageLoader{

       @Override
       public void displayImage(Context context, Object path, ImageView imageView) {
           Glide.with(context).load(path).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
       }
   }


}
