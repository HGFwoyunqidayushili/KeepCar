package jiyun.com.keepcar.ui.homepage.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.entity.homepage.ImageBean;
import jiyun.com.keepcar.http.contract.InfoContract;
import jiyun.com.keepcar.http.presenter.PresenterInfo;
import jiyun.com.keepcar.ui.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends BaseFragment implements InfoContract.Views<ImageBean>{


    private View view;
    private ListView lv;
    private String URL_STRING="http://39.106.173.47:8080/app/main/queryBrandImg.do";
    public HomePageFragment() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      view=inflater.inflate(R.layout.fragment_home_page, container, false);
        initView();
        initData();
        return view;
    }

    protected void initView() {
        lv= (ListView) view.findViewById(R.id.lv);

    }
    @Override
    protected void initData() {
        PresenterInfo presenterInfo=new PresenterInfo(this,getActivity());
          presenterInfo.getNewsData(URL_STRING,"");
    }


    @Override
    public void success(ImageBean imageBean) {
        Log.e("TAG",imageBean.getData().get(0));
    }

    @Override
    public void failure(Throwable e) {

    }

}
