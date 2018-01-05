package jiyun.com.keepcar.ui.fourCarshow.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;
import jiyun.com.keepcar.ui.fourCarshow.fragment.NewCarshowFragment;
import jiyun.com.keepcar.ui.fourCarshow.fragment.UsedCarFragment;
import jiyun.com.keepcar.view.MyApptitle;

public class FourcarShowActivity extends BaseActivity implements View.OnClickListener{

    private NewCarshowFragment newCarshowFragment;
    private UsedCarFragment usedCarFragment;
    private TextView newCar_show;
    private TextView usedCar_show;
    private FragmentManager manager;
    private MyApptitle App_title;
    @Override
    protected void initView() {

        manager=getSupportFragmentManager();
        App_title= (MyApptitle) findViewById(R.id.App_title);
        App_title.setCenterTv("4S店展示厅","#FFFFFF");
        App_title.setLeftImg(getResources().getDrawable(R.mipmap.back));
        TextViewClickListener(App_title);
        newCarshowFragment=new NewCarshowFragment();
        newCar_show= (TextView) findViewById(R.id.newCar_show);
        newCar_show.setOnClickListener(this);
        usedCar_show= (TextView) findViewById(R.id.usedCar_show);
        usedCar_show.setOnClickListener(this);
        manager.beginTransaction().replace(R.id.Frame_layout,newCarshowFragment).commit();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_fourcar_show;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.newCar_show:
                usedCar_show.setTextColor(Color.parseColor("#343434"));
                newCar_show.setTextColor(Color.parseColor("#ff0000"));
                setChooseItem(0);
                break;
            case R.id.usedCar_show:
                usedCar_show.setTextColor(Color.parseColor("#ff0000"));
                newCar_show.setTextColor(Color.parseColor("#343434"));
                setChooseItem(1);
                break;
        }
    }

    private void setChooseItem(int index) {
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragmnet(transaction);
        switch (index){
            case 0:
             if(newCarshowFragment==null){
                 newCarshowFragment=new NewCarshowFragment();
                 transaction.add(R.id.Frame_layout,newCarshowFragment);
             }
                else {
                 transaction.show(newCarshowFragment);
             }
                break;
            case 1:
              if(usedCarFragment==null){
                  usedCarFragment=new UsedCarFragment();
                  transaction.add(R.id.Frame_layout,usedCarFragment);
              }
                else {
                  transaction.show(usedCarFragment);
              }
                break;
        }
    }

    private void hideFragmnet(FragmentTransaction transaction) {
        if(newCarshowFragment!=null){
            transaction.hide(newCarshowFragment);
        }
        if(usedCarFragment!=null){
            transaction.hide(usedCarFragment);
        }
        transaction.commit();
    }
}
