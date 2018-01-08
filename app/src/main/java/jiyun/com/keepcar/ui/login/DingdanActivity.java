package jiyun.com.keepcar.ui.login;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;
import jiyun.com.keepcar.ui.homepage.fragment.activity.DingdanFragemnt;

/**
 * Created by Administrator on 2018/1/3.
 */
public class DingdanActivity extends BaseActivity {
    private RadioButton suoha;
    private RadioButton daifu;
    private RadioButton daishi;
    private RadioButton daifa;
    private RadioButton daishou;
    private RadioButton daiping;
    private RadioGroup group;
    private FrameLayout fram_radio;
    @Override
    protected void initView() {
        suoha= (RadioButton) findViewById(R.id.suoha);
        daifu= (RadioButton) findViewById(R.id.daifu);
        daishi= (RadioButton) findViewById(R.id.daishi);
        daifa= (RadioButton) findViewById(R.id.daifa);
        daishou= (RadioButton) findViewById(R.id.daishou);
        daiping= (RadioButton) findViewById(R.id.daiping);
        group= (RadioGroup) findViewById(R.id.group);
        fram_radio= (FrameLayout) findViewById(R.id.fram_radio);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        FragmentTransaction replace = fragmentTransaction.add(R.id.fram_radio, DingdanFragemnt.newInstances("0"));
        replace.commit();
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.suoha:
//                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        FragmentTransaction replace = fragmentTransaction.replace(R.id.fram_radio, DingdanFragemnt.newInstances("0"));
                        replace.commit();
                        break;
                    case R.id.daifu:
                        FragmentTransaction fragmentTransaction1 = getSupportFragmentManager().beginTransaction();
                        FragmentTransaction replace1 = fragmentTransaction1.replace(R.id.fram_radio, DingdanFragemnt.newInstances("1"));
                        replace1.commit();
                        break;
                    case R.id.daishi:
                        FragmentTransaction fragmentTransaction2 = getSupportFragmentManager().beginTransaction();
                        FragmentTransaction replace2 = fragmentTransaction2.replace(R.id.fram_radio, DingdanFragemnt.newInstances("2"));
                        replace2.commit();
                        break;
                    case R.id.daishou:
                        FragmentTransaction fragmentTransaction3 = getSupportFragmentManager().beginTransaction();
                        FragmentTransaction replace3 = fragmentTransaction3.replace(R.id.fram_radio, DingdanFragemnt.newInstances("3"));
                        replace3.commit();
                        break;

                    case R.id.daiping:
                        FragmentTransaction fragmentTransaction4 = getSupportFragmentManager().beginTransaction();
                        FragmentTransaction replace4 = fragmentTransaction4.replace(R.id.fram_radio, DingdanFragemnt.newInstances("4"));
                        replace4.commit();
                        break;
                    case R.id.daifa:
                        FragmentTransaction fragmentTransaction5= getSupportFragmentManager().beginTransaction();
                        FragmentTransaction replace5= fragmentTransaction5.replace(R.id.fram_radio, DingdanFragemnt.newInstances("5"));
                        replace5.commit();
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
        return R.layout.activity_dingdan;
    }

}
