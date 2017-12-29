package jiyun.com.keepcar.ui.login;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;

/**
 * Created by Administrator on 2017/12/29.
 */

public class LoginActvitity extends BaseActivity implements View.OnClickListener {
    private EditText reginst_ipone;
    private EditText login_et_pwd;
    private Button getCode;
    private Button btn_login;

    @Override
    protected void initView() {
        reginst_ipone = (EditText) findViewById(R.id.reginst_ipone);
        login_et_pwd = (EditText) findViewById(R.id.login_et_pwd);
        btn_login = (Button) findViewById(R.id.btn_login);
        getCode = (Button) findViewById(R.id.getCode);
        final MyCountDownTimer myCountDownTimer = new MyCountDownTimer(60000,1000);
        getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCountDownTimer.start();
            }
        });
        btn_login.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_loain;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }

    @Override
    public void onClick(View v) {

    }

    //复写倒计时
    private class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        //计时过程
        @Override
        public void onTick(long l) {
            //防止计时过程中重复点击
            getCode.setClickable(false);
            getCode.setText(l/1000+"s");

        }

        //计时完毕的方法
        @Override
        public void onFinish() {
            //重新给Button设置文字
            getCode.setText("获取验证码");
            //设置可点击
            getCode.setClickable(true);
        }
    }
}
