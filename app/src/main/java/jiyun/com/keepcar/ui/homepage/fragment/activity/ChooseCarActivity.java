package jiyun.com.keepcar.ui.homepage.fragment.activity;

import android.os.Handler;
import android.os.Message;
import android.support.annotation.IdRes;
import android.util.Log;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.io.IOException;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by Administrator on 2018/1/3.
 */
public class ChooseCarActivity extends BaseActivity {
    private ListView lv_lovecar;
    private RadioButton guanlianVIP;
    private RadioButton addLove;
    private RadioGroup radio_love;
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            String  obj = (String) msg.obj;
            switch (msg.what){
                case 1:
                    Log.e("111111111111111",obj);
                    break;
            }
        }
    };

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
        OkHttpClient okHttpClient = new OkHttpClient();
        String str="{\"tk\":\"0D00467259E978645A20D90842AE9C04\",\"ak\":\"f4474404846d470a8e1f6c081a28acc5\",\"channel\":\"android\"}";
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), str);
        Request build = new Request.Builder().url("http://39.106.173.47:8080/app/myAccount/queryMyPlatfromCarList.do")
                .post(requestBody)
                .build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Message message = handler.obtainMessage();
                message.what=1;
                message.obj=response.body().string();
                handler.sendMessage(message);
            }
        });

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_choosecar;
    }

}
