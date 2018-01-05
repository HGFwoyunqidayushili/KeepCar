package jiyun.com.keepcar.ui.wonderful.activity;

import android.util.Log;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.entity.DropBean;
import jiyun.com.keepcar.ui.BaseActivity;
import jiyun.com.keepcar.view.DropdownButton;
import jiyun.com.keepcar.view.MyApptitle;

public class WonderfulActivity extends BaseActivity  {

   private DropdownButton wonderful_activity;
   private CheckBox wonderful_buxian;
   private DropdownButton  woderful_sort;
   private MyApptitle App_title;
    List<DropBean> times;
    List<DropBean> types;

    private String kind;
    private String buxian;
    private String sort;
    private String []str={"活动","活动不限","市场活动","保险活动","团购","现实抢购","定时秒杀","买赠","套餐"};
    @Override
    protected void initView() {
        App_title= (MyApptitle) findViewById(R.id.App_title);
        App_title.setCenterTv("活动","#FFFFFF");
        App_title.setLeftImg(getResources().getDrawable(R.mipmap.back));
        TextViewClickListener(App_title);
        wonderful_activity= (DropdownButton) findViewById(R.id.wonderful);
        woderful_sort= (DropdownButton) findViewById(R.id.wonderful_sort);

        times=new ArrayList<>();
        types=new ArrayList<>();


    }

    @Override
    protected void initData() {
      for(int i=0;i<str.length;i++){
          times.add(new DropBean(str[i]));
      }
        types.add(new DropBean("排序"));
        types.add(new DropBean("默认排序"));
        types.add(new DropBean("销量最高"));
        types.add(new DropBean("价格最低"));
        wonderful_activity.setData(times);
        woderful_sort.setData(types);
        sort=woderful_sort.text.getText().toString();
        Log.e("TAG",sort);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_wonderful;
    }
}
