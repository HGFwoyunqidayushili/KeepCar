package jiyun.com.keepcar.ui.homepage.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.entity.homepage.ImageBean;
import jiyun.com.keepcar.http.contract.InfoContract;
import jiyun.com.keepcar.http.presenter.PresenterInfo;
import jiyun.com.keepcar.ui.BaseFragment;
import jiyun.com.keepcar.ui.Constant;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends BaseFragment implements InfoContract.Views<ImageBean>{


    private View view;
    private View herder;
    private ListView lv;
    private Banner banner;
    private ViewFlipper viewFlipper;
    private RadioGroup radio_CarService;
    private ArrayList<String> testList=new ArrayList<>();
    private int count;
    private String URL_STRING="http://39.106.173.47:8080/app/main/queryBrandImg.do";
    public HomePageFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_home_page, container, false);
        herder=LayoutInflater.from(getActivity()).inflate(R.layout.header,null);
        initView();
        initData();
        return view;
    }
    @Override
    protected void initView() {
        lv= (ListView) view.findViewById(R.id.lv);
        banner= (Banner) herder.findViewById(R.id.fly_banner);
        viewFlipper= (ViewFlipper) herder.findViewById(R.id.viewflipager);
        radio_CarService= (RadioGroup) herder.findViewById(R.id.radio_CarService);
         lv.addHeaderView(herder);
        lv.setAdapter(null);
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
         radio_CarService.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
             @Override
             public void onCheckedChanged(RadioGroup radioGroup, int i) {
                 switch (i){
                     case R.id.radio_baoyang:
                         break;
                     case R.id.radio_weixiu:
                         break;
                     case R.id.radio_show:
                         break;
                     case R.id.radio_xubao:
                         break;
                     case R.id.radio_jingpin:

                         break;

                 }
             }
         });
    }

    @Override
    protected void initData() {
        PresenterInfo presenterInfo=new PresenterInfo(this,getActivity());
          presenterInfo.getNewsData(URL_STRING,"");
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

    @Override
    public void failure(Throwable e) {

    }

   class GlideImageLoader extends ImageLoader{

       @Override
       public void displayImage(Context context, Object path, ImageView imageView) {
           Glide.with(context).load(path).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.ALL).into(imageView);
       }


   }
}
