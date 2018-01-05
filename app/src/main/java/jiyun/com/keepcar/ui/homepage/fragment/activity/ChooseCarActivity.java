package jiyun.com.keepcar.ui.homepage.fragment.activity;

import android.support.annotation.IdRes;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;

/**
 * Created by Administrator on 2018/1/3.
 */
public class ChooseCarActivity extends BaseActivity {
    private ListView lv_lovecar;
    private RadioButton guanlianVIP;
    private RadioButton addLove;
    private RadioGroup radio_love;

    @Override
    protected void initView() {
        lv_lovecar = (ListView) findViewById(R.id.lv_lovecar);
        guanlianVIP= (RadioButton) findViewById(R.id.guanlianVIP);
        addLove= (RadioButton) findViewById(R.id.addLove);
        radio_love= (RadioGroup) findViewById(R.id.radio_love);
        radio_love.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.addLove:
                        break;
                    case R.id.guanlianVIP:

                        break;
                }
            }
        });
    }

    @Override
    protected void initData() {
    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_choosecar;
    }

}
