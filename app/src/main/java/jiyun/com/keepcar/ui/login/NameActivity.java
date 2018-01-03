package jiyun.com.keepcar.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;

/**
 * Created by Administrator on 2018/1/3.
 */

public class NameActivity extends BaseActivity {
    private EditText ed_nicehng;
    private TextView ok_ed;

    @Override
    protected void initView() {
        final Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("7");
        ed_nicehng= (EditText) findViewById(R.id.ed_nicehng);
        ed_nicehng.setText(stringExtra);
        ok_ed= (TextView) findViewById(R.id.ok_ed);
        ok_ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                if( ed_nicehng.getText().toString().length()!=0){
                    Intent intent2 = intent1.putExtra("4", ed_nicehng.getText().toString());
                    setResult(97,intent2);
                    finish();
                }else {
                    Toast.makeText(NameActivity.this, "不能为空", Toast.LENGTH_SHORT).show();
                }
              //("^[\\u4e00-\\u9fa5]+[·•][\\u4e00-\\u9fa5]+$")){

            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_name;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
