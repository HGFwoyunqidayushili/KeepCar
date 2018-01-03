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

public class YouxiangActivity extends BaseActivity {
    private EditText ed_nicehng;
    private TextView ok_ed;

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("1");
        ed_nicehng= (EditText) findViewById(R.id.ed_nicehng);
        ed_nicehng.setText(stringExtra);
        ok_ed= (TextView) findViewById(R.id.ok_ed);
        ok_ed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = getIntent();
                if(ed_nicehng.getText().toString().matches("^[\\w._]+@([qQ][qQ]|[gG][mM][aA][iI][lL]|163)\\.[cC][oO][mM](\\r\\n|\\r|\\n)?$")){
                    Intent intent2 = intent1.putExtra("2", ed_nicehng.getText().toString());
                    setResult(99,intent2);
                    finish();
                }else {
                    Toast.makeText(YouxiangActivity.this, "请输入正确的邮箱格式", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_youxiang;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
}
