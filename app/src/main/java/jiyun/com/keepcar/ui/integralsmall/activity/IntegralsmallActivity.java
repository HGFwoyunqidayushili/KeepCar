package jiyun.com.keepcar.ui.integralsmall.activity;

import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.entity.DropBean;
import jiyun.com.keepcar.ui.BaseActivity;
import jiyun.com.keepcar.view.DropdownButton;
import jiyun.com.keepcar.view.MyApptitle;

public class IntegralsmallActivity extends BaseActivity {


    private MyApptitle App_title;
    private DropdownButton intrgral_kind;
    private CheckBox intrgral_buxianzhi;
    private DropdownButton  intrgral_sort;

    List<DropBean> times;
    List<DropBean> types;
    private String[] str={"分类","全部分类","精品","定值券","余额券","项目","洗车"};
    @Override
    protected void initView() {
        App_title= (MyApptitle) findViewById(R.id.App_title);
        App_title.setCenterTv("积分商场","#FFFFFF");
        App_title.setLeftImg(getResources().getDrawable(R.mipmap.back));
        TextViewClickListener(App_title);
        intrgral_kind= (DropdownButton) findViewById(R.id.integral_kind);
        intrgral_buxianzhi= (CheckBox) findViewById(R.id.integral_buxian);
        intrgral_sort= (DropdownButton) findViewById(R.id.integral_sort);

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
        types.add(new DropBean("积分值最低"));
        intrgral_kind.setData(times);
        intrgral_sort.setData(types);
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_integralsmall;
    }
}
