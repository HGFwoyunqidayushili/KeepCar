package jiyun.com.keepcar.ui.login;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;
import jiyun.com.keepcar.ui.MainActivity;
import jiyun.com.keepcar.utils.Loginutil;
import jiyun.com.keepcar.utils.UserManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/29.
 */
public class LoginActvitity extends BaseActivity implements View.OnClickListener {
    private EditText reginst_ipone;
    private EditText login_et_pwd;
    private Button getCode;
    private Button btn_login;
    Handler handler =  new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String str = (String) msg.obj;
            switch (msg.what) {
                case 0:
                    Toast.makeText(LoginActvitity.this, "失败-->" + str, Toast.LENGTH_LONG).show();
                    Log.e("----------", "失败-->" + str);
                    break;
                case 1:
                    Toast.makeText(LoginActvitity.this, "成功-->" + str, Toast.LENGTH_LONG).show();

                    Log.e("111111",str);
                    break;
                case 3:
                    Toast.makeText(LoginActvitity.this, "失败-->" + str, Toast.LENGTH_LONG).show();
                    break;
                case 4:

                    Toast.makeText(LoginActvitity.this, "成功-->" + str, Toast.LENGTH_LONG).show();
                    denglus();
                    break;
                case 5:
                    Toast.makeText(LoginActvitity.this, "444444-->" + str, Toast.LENGTH_LONG).show();
                    break;
                case 7:
                    try {
                        JSONObject jsonObject=new JSONObject(str);
                         String userId=jsonObject.getString("data");

                         Log.e("TAG",userId);
                        Loginutil loginutil=new Loginutil();
                         loginutil.setData(userId);
                        String trim = reginst_ipone.getText().toString().trim();

                        loginutil.setAccountUname(trim);
                        UserManager.getIntance().saveUser(loginutil);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
//                    Toast.makeText(LoginActvitity.this, "444444-->" + str, Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(LoginActvitity.this, MainActivity.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("123",reginst_ipone.getText().toString());
//                    intent.putExtras(bundle);
                    intent.putExtra("denglu",reginst_ipone.getText().toString());

                    startActivity(intent);
                    Log.e("123333333",str);
                    break;
            }
        }
    };
    private String ss;
    @Override
    protected void initView() {
        //填写手机号控件
        reginst_ipone = (EditText) findViewById(R.id.reginst_ipone);
        //填写密码控件
        login_et_pwd = (EditText) findViewById(R.id.login_et_pwd);
        //登录按钮
        btn_login = (Button) findViewById(R.id.btn_login);
        //获取验证码控件
        getCode = (Button) findViewById(R.id.getCode);
        final MyCountDownTimer myCountDownTimer = new MyCountDownTimer(60000,1000);
        //获取验证码
        getCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(reginst_ipone.getText().length()==0){
                    Toast.makeText(LoginActvitity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(reginst_ipone.getText().toString().matches("^1[3|4|5|7|8][0-9]{9}$")){
                    //Toast.makeText(LoginActvitity.this,reginst_ipone.getText().toString(), Toast.LENGTH_SHORT).show();
                    //倒计时开始
                    myCountDownTimer.start();
                    //网络请求
                    OkHttpClient okHttpClient = new OkHttpClient();
                    String stringss = "{\"accountUname\":\""+reginst_ipone.getText().toString()+"\",\"ak\":\"f4474404846d470a8e1f6c081a28acc5\",\"channel\":\"android\"}";
//                    String stringss = "{\"accountUname\":\"15600385321\",\"ak\":\"f4474404846d470a8e1f6c081a28acc5\",\"channel\":\"android\"}";
                    Toast.makeText(LoginActvitity.this, stringss,Toast.LENGTH_LONG).show();
                     RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), stringss);
                    Request request = new Request.Builder()
                            .url("http://39.106.173.47:8080/app/vcode/m_sendSms_v1_0.do")
//                .url("http://39.106.173.47:8080/app/vcode/m_sendSms_v1_0.do")
                            .post(requestBody)
                            .build();
                    Call call = okHttpClient.newCall(request);
                    call.enqueue(new Callback() {
                        @Override
                        //失败
                        public void onFailure(Call call, IOException e) {
                            Message message = handler.obtainMessage();
                            message.what = 0;
                            message.obj=e.getMessage();
                            handler.sendMessage(message);
                        }
                        //成功
                        @Override
                        public void onResponse(Call call, Response response) throws IOException {
                                Message message = new Message();
                                message.what = 1;
                                message.obj = response.code()+"请求吗";
                                handler.sendMessage(message);
                        }
                    });
                }else {
                    Toast.makeText(LoginActvitity.this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();
                }
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
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                if(reginst_ipone.getText().length()==0){
                    Toast.makeText(LoginActvitity.this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(login_et_pwd.getText().toString().length()==0){
                    Toast.makeText(this, "请输入验证码", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(login_et_pwd.getText().toString().matches("[0-9]{6}")){

                }else {
                    Toast.makeText(this, "验证码错误", Toast.LENGTH_SHORT).show();
                    return;
                }
                yanzheng();
                break;
        }
    }
    private void yanzheng() {
        ss = login_et_pwd.getText().toString();
        OkHttpClient okHttpClient = new OkHttpClient();
        //{"accountUname":""+reginst_ipone.getText().toString()+"\",\"vCode\":\""+ ss +"","ak":"f4474404846d470a8e1f6c081a28acc5","channel":"android"}
        String str= "{\"telephone \":\""+reginst_ipone.getText().toString()+"\",\"vCode\":\""+ ss +"\",\"ak\":\"f4474404846d470a8e1f6c081a28acc5\",\"channel\":\"android\"}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), str);
        Request build = new Request.Builder().url("http://39.106.173.47:8080/app/vcode/validgetPriceCode.do").post(requestBody).build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = handler.obtainMessage();
                message.what=3;
                message.obj=e.getMessage();
                handler.sendMessage(message);
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.code()==200){
                    Message message = handler.obtainMessage();
                    message.what=4;
                    message.obj=response.code()+"qq";
                    handler.sendMessage(message);
                }else if(response.code()==400){
                    Message message = handler.obtainMessage();
                    message.what=5;
                    message.obj=response.code()+"验证码错误";
                    handler.sendMessage(message);
                }

            }
        });
    }
    private void denglus() {
        OkHttpClient okHttpClient = new OkHttpClient();
        String stringsss = "{\"accountUname\":\""+reginst_ipone.getText().toString()+"\",\"vCode\":\""+ ss +"\",\"ak\":\"f4474404846d470a8e1f6c081a28acc5\",\"channel\":\"android\"}";
        Log.e("22222222222222",stringsss);
        Toast.makeText(LoginActvitity.this, stringsss, Toast.LENGTH_LONG).show();
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), stringsss);
        final Request request = new Request.Builder()
                .url("http://39.106.173.47:8080/app/account/m_login/v1_0.do")
//                .url("http://39.106.173.47:8080/app/vcode/m_sendSms_v1_0.do")
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Message message = new Message();
                message.what = 6;
                message.obj = e.getMessage();
                handler.sendMessage(message);
                Toast.makeText(LoginActvitity.this, "11111", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = handler.obtainMessage();
              String   string = response.body().string();
                message.obj = string;
                message.what = 7;
                handler.sendMessage(message);
            }
        });
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