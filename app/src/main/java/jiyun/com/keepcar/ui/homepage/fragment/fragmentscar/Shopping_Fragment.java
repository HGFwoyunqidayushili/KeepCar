package jiyun.com.keepcar.ui.homepage.fragment.fragmentscar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.bean.ForeCarXaingQingBean;
import jiyun.com.keepcar.http.contract.InfoContract;
import jiyun.com.keepcar.http.presenter.PresenterInfo;
import jiyun.com.keepcar.ui.adapter.ShopForeCar;
import jiyun.com.keepcar.utils.ZJson;

/**
 * A simple {@link Fragment} subclass.
 */
public class Shopping_Fragment extends Fragment implements InfoContract.Views<ForeCarXaingQingBean> {
    private final String URL = "http://39.106.173.47:8080/app/boutique/showProduct.do?ak=f4474404846d470a8e1f6c081a28acc5&channel=android";
    private XRecyclerView rexyxView;

    public Shopping_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shopping_, container, false);
        initView(inflate);

        initData();
        return inflate;
    }

    private void initData() {
        Map<String, Object> map = new HashMap<>();

        map.put("shopCode","店面不限");
        map.put("searchType","默认排序");
        map.put("pageSize",6);
        map.put("pageNum",0);
        String s = ZJson.toJSONMap(map);
        PresenterInfo presenterInfo = new PresenterInfo(this, getActivity());
        presenterInfo.getNewsData(URL,s);
    }

    private void initView(View inflate) {
        //
        rexyxView = (XRecyclerView) inflate.findViewById(R.id.rexyxView);
    }

    @Override
    public void success(ForeCarXaingQingBean foreCarXaingQingBean) {
        List<ForeCarXaingQingBean.DataBean.ListBean> list = foreCarXaingQingBean.getData().getList();
        ShopForeCar shopForeCar = new ShopForeCar(list,getActivity());
        GridLayoutManager gid = new GridLayoutManager(getActivity(),2);
        rexyxView.setLayoutManager(gid);
        rexyxView.setAdapter(shopForeCar);

    }

    @Override
    public void failure(Throwable e) {

    }
}
