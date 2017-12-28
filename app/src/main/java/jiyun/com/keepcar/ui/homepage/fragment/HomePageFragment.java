package jiyun.com.keepcar.ui.homepage.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.recker.flybanner.FlyBanner;

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
    private FlyBanner flyBanner;
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
        flyBanner= (FlyBanner) herder.findViewById(R.id.fly_banner);
         lv.addHeaderView(herder);
        lv.setAdapter(null);


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
        flyBanner.setImagesUrl(listimage);
        flyBanner.startAutoPlay();

    }

    @Override
    public void failure(Throwable e) {

    }

}
