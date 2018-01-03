package jiyun.com.keepcar.http.presenter;

import android.content.Context;

import jiyun.com.keepcar.http.contract.InfoContract;
import jiyun.com.keepcar.http.model.NetModel;

/**
 * Created by 阿三 on 2017/12/27.
 */
public class PresenterInfo implements InfoContract.Presenter {
    private Context context;
    private InfoContract.Views views;
    private InfoContract.Model model;
    private InfoContract.ViewTwo viewsTwo;
    public PresenterInfo(InfoContract.Views views, Context context){
        this.views=views;
        this.context=context;
        this.viewsTwo=viewsTwo;
        model=new NetModel();

    }
    @Override
    public void getNewsData(String page,String url) {
         model.requestNewsData(context,page,url,views);
    }

    @Override
    public void getNewsDataTwo(String page, String url) {
        model.requestNewsDataTwo(context,page,url,viewsTwo);
    }

}
