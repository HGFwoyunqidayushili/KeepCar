package jiyun.com.keepcar.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.zaaach.citypicker.CityPickerActivity;
import com.zaaach.citypicker.utils.StringUtils;

import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.homepage.fragment.CarShopFragment;
import jiyun.com.keepcar.ui.homepage.fragment.HomePageFragment;
import jiyun.com.keepcar.ui.homepage.fragment.PersonalFragment;
import jiyun.com.keepcar.ui.homepage.fragment.ShoppingcartFragment;

public class MainActivity extends BaseActivity {

    private HomePageFragment homePageFragment;
    private CarShopFragment carShopFragment;
    private PersonalFragment personalFragment;
    private ShoppingcartFragment shoppingcartFragment;
    private List<Fragment> FragmentList;
    private RadioGroup radioGroup;
    private FragmentManager manager;
    private TextView address;
    private AMapLocationClient mLocationClient;

    @Override
    protected void initView() {
        initLocation();
        manager=getSupportFragmentManager();
        address= (TextView) findViewById(R.id.address);
        radioGroup= (RadioGroup) findViewById(R.id.tabGroup);

        homePageFragment=new HomePageFragment();
        manager.beginTransaction().replace(R.id.Frame_layout,homePageFragment).commit();
    }

    @Override
    protected void initData() {
         initListener();
    }

    private void initListener() {
           radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
               @Override
               public void onCheckedChanged(RadioGroup radioGroup, int i) {
                   switch (i){
                       case R.id.rbTabHome:
                          setChooseItem(0);
                           break;
                       case R.id.rb4Sshop:
                           setChooseItem(1);
                           break;
                       case R.id.rbShoppingCar:
                           setChooseItem(2);
                           break;
                       case R.id.rbPersonal:
                           setChooseItem(3);
                           break;
                   }
               }
           });
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, CityPickerActivity.class),
                        233);
            }
        });
    }

    private void setChooseItem(int index) {
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);
        switch (index){
           case 0:
               if(homePageFragment==null){
                   homePageFragment=new HomePageFragment();
                   transaction.add(R.id.Frame_layout,homePageFragment);
               }
               else{
                   transaction.show(homePageFragment);
               }
               break;
           case 1:
               if(carShopFragment==null){
                   carShopFragment=new CarShopFragment();
                   transaction.add(R.id.Frame_layout,carShopFragment);
               }
               else {
                   transaction.show(carShopFragment);
               }
               break;
           case 2:
               if(shoppingcartFragment==null){
                   shoppingcartFragment=new ShoppingcartFragment();
                   transaction.add(R.id.Frame_layout,shoppingcartFragment);
               }
               else{
                   transaction.show(shoppingcartFragment);
               }
               break;
           case 3:
               if(personalFragment==null){
                   personalFragment=new PersonalFragment();
                   transaction.add(R.id.Frame_layout,personalFragment);
               }
               else {
                   transaction.show(personalFragment);
               }
               break;
       }
    }

    private void hideFragment(FragmentTransaction transaction) {
        if(homePageFragment!=null){
            transaction.hide(homePageFragment);
        }
        if(carShopFragment!=null){
            transaction.hide(carShopFragment);
        }
        if(shoppingcartFragment!=null){
            transaction.hide(shoppingcartFragment);
        }
        if(personalFragment!=null){
            transaction.hide(personalFragment);
        }
        transaction.commit();
    }

    @Override
    protected int getLayoutID() {
      return R.layout.activity_main;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==233&&resultCode==RESULT_OK){
            if(data!=null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                address.setText(city);
            }
        }
    }

        private void initLocation() {
            mLocationClient = new AMapLocationClient(this);
            AMapLocationClientOption option = new AMapLocationClientOption();
            option.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
            option.setOnceLocation(true);
            mLocationClient.setLocationOption(option);
            mLocationClient.setLocationListener(new AMapLocationListener() {
                @Override
                public void onLocationChanged(AMapLocation aMapLocation) {
                    if (aMapLocation != null) {
                        if (aMapLocation.getErrorCode() == 0) {
                            String city = aMapLocation.getCity();
                            String substring = city.substring(0, 2);
                             address.setText(substring);
                            String district = aMapLocation.getDistrict();
                            String location = StringUtils.extractLocation(city, district);

                        } else {
                            //定位失败

                        }
                    }
                }
            });
            mLocationClient.startLocation();
        }

}
