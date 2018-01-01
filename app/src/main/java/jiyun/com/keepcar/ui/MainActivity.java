package jiyun.com.keepcar.ui;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.zaaach.citypicker.CityPickerActivity;
import com.zaaach.citypicker.utils.StringUtils;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.homepage.fragment.CarShopFragment;
import jiyun.com.keepcar.ui.homepage.fragment.HomePageFragment;
import jiyun.com.keepcar.ui.homepage.fragment.PersonalFragment;
import jiyun.com.keepcar.ui.homepage.fragment.ShoppingcartFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private HomePageFragment homePageFragment;
    private CarShopFragment carShopFragment;
    private PersonalFragment personalFragment;
    private ShoppingcartFragment shoppingcartFragment;
    private RadioGroup radioGroup;
    private FragmentManager manager;
    private TextView address;
    private AMapLocationClient mLocationClient;
    private  TextView keepcar;
    public static ImageView add;
    private TextView theeditor;
    private String flag="a";
    private ImageView menu;
    private TextView centerTv;


    @Override
    protected void initView() {
        initLocation();
        centerTv= (TextView) findViewById(R.id.centerTv);
        keepcar= (TextView) findViewById(R.id.yangche);
        add= (ImageView) findViewById(R.id.add);
        add.setOnClickListener(this);
        add.setTag(flag);

        //menu= (ImageView) findViewById(R.id.menu);
//        menu.setOnClickListener(this);
        manager=getSupportFragmentManager();
        address= (TextView) findViewById(R.id.address);
        radioGroup= (RadioGroup) findViewById(R.id.tabGroup);
        theeditor= (TextView) findViewById(R.id.Theeditor);
//        homePageFragment=new HomePageFragment();
        if(homePageFragment==null){
            homePageFragment=new HomePageFragment();
            manager.beginTransaction().add(R.id.Frame_layout,homePageFragment).commit();
        }
        else {
            manager.beginTransaction().replace(R.id.Frame_layout,homePageFragment).commit();
        }

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
                           add.setBackgroundResource(R.mipmap.add);
                           add.setVisibility(View.VISIBLE);
                           centerTv.setVisibility(View.GONE);
                           keepcar.setVisibility(View.VISIBLE);
                           flag="a";
                           add.setTag(flag);


                          setChooseItem(0);

                           break;
                       case R.id.rb4Sshop:
                         add.setVisibility(View.GONE);
                          keepcar.setVisibility(View.GONE);
                           centerTv.setVisibility(View.VISIBLE);
                           centerTv.setText("4S店");
                           setChooseItem(1);

                           break;
                       case R.id.rbShoppingCar:
                           keepcar.setVisibility(View.GONE);
                           add.setVisibility(View.GONE);
                           centerTv.setVisibility(View.VISIBLE);
                           centerTv.setText("购物车");
                           setChooseItem(2);

                           break;
                       case R.id.rbPersonal:
                           keepcar.setVisibility(View.GONE);
                           add.setBackgroundResource(R.drawable.you);
                           centerTv.setVisibility(View.VISIBLE);
                           centerTv.setText("个人中心");


                           setChooseItem(3);
                           flag="b";
                           add.setTag(flag);
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
                           //
                        }
                    }
                }
            });
            mLocationClient.startLocation();
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.add:
          if(add.getTag().equals("a")){
              showToast("1111111111111111");
          }
                if(add.getTag().equals("b")){
                    showToast("22222222222");
                }
                break;
//            case R.id.menu:
////                showToast("2222222222");|
//                View inflate = LayoutInflater.from(this).inflate(R.layout.pop_login, null);
//                final PopupWindow popupWindow = new PopupWindow(inflate, 250, 250);
//                TextView finsh_login = (TextView) inflate.findViewById(R.id.finsh_login);
//                TextView qiehuan_name = (TextView) inflate.findViewById(R.id.qiehuan_name);
//                finsh_login.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent = new Intent(MainActivity.this, LoginActvitity.class);
//                        startActivity(intent);
//                    }
//                });
//                qiehuan_name.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        Intent intent1 = new Intent(MainActivity.this, LoginActvitity.class);
//                        startActivity(intent1);
//                    }
//                });
//
////                WindowManager.LayoutParams attributes = getWindow().getAttributes();
////                attributes.alpha=0.5f;
////                getWindow().setAttributes(attributes);
//
////                popupWindow.setFocusable(true);
////                popupWindow.setFocusable(true);
////                popupWindow.showAtLocation(inflate, Gravity.CENTER,0,0);
////                final PopupWindow pop = new PopupWindow(inflate, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT, false);
////////
//// 需要设置一下此参数，点击外边可消失
//                popupWindow.setBackgroundDrawable(new BitmapDrawable());
////设置点击窗口外边窗口消失
//                popupWindow.setOutsideTouchable(true);
//// 设置此参数获得焦点，否则无法点击
//                popupWindow.setFocusable(true);
////                menu.setOnClickListener(new View.OnClickListener() {
//
//                   // @Override
////                    public void onClick(View v) {
//                        if(popupWindow.isShowing()) {
//                            // 隐藏窗口，如果设置了点击窗口外小时即不需要此方式隐藏
//                            popupWindow.dismiss();
//                        } else {
//                            // 显示窗口
//                            popupWindow.showAsDropDown(v);
//                        }
//
////                    }
////                });
//
//
//                break;
//            case R.id.Theeditor:
//
//                break;
       }
    }


}
