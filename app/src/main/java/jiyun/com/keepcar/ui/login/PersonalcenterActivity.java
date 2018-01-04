package jiyun.com.keepcar.ui.login;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;

/**
 * Created by Administrator on 2018/1/2.
 */

public class PersonalcenterActivity extends BaseActivity implements View.OnClickListener{
    private ImageView touxiang_updata;
    private RelativeLayout touxiang_liner;
    private TextView nicheng_updata;
    private LinearLayout nicheng_liner;
    private TextView name_updata;
    private LinearLayout name_liner;
    private TextView youxiang_updata;
    private LinearLayout youxiang_liner;
    private LinearLayout liner;
    private Button ok;
    @Override
    protected void initView() {
        ok= (Button) findViewById(R.id.ok);
        touxiang_updata= (ImageView) findViewById(R.id.touxiang_updata);
        touxiang_liner= (RelativeLayout) findViewById(R.id.touxiang_liner);
        nicheng_updata= (TextView) findViewById(R.id.nicheng_updata);
        nicheng_liner= (LinearLayout) findViewById(R.id.nicheng_liner);
        youxiang_liner= (LinearLayout) findViewById(R.id.youxiang_liner);
        name_liner= (LinearLayout) findViewById(R.id.name_liner);
        name_updata= (TextView) findViewById(R.id.name_updata);
        youxiang_updata= (TextView) findViewById(R.id.youxiang_updata);
        liner = (LinearLayout) findViewById(R.id.liner);
        touxiang_liner.setOnClickListener(this);
        youxiang_liner.setOnClickListener(this);
        nicheng_liner.setOnClickListener(this);
        name_liner.setOnClickListener(this);
    }
    @Override
    protected void initData() {
    }
    @Override
    protected int getLayoutID() {
        return R.layout.activity_personalcenter;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==99&&resultCode==99){
            String stringExtra = data.getStringExtra("2");
            youxiang_updata.setText(stringExtra);
        }
        if (requestCode==98&&resultCode==98){
            String stringExtra = data.getStringExtra("3");
            nicheng_updata.setText(stringExtra);
        }
        if (requestCode==97&&resultCode==97){
            String stringExtra = data.getStringExtra("4");
            name_updata.setText(stringExtra);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.touxiang_liner:
                ok.setVisibility(View.GONE);
                View inflate = LayoutInflater.from(this).inflate(R.layout.pop_touxiang, null);
                TextView tv_photo = (TextView) inflate.findViewById(R.id.tv_photo);

                TextView tv_photograph = (TextView) inflate.findViewById(R.id.tv_photograph);
                TextView tv_cancle = (TextView) inflate.findViewById(R.id.tv_cancle);

                final PopupWindow p=new PopupWindow(inflate, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                p.setFocusable(true);
                p.setTouchable(true);

                p.setBackgroundDrawable(new BitmapDrawable());
                p.showAtLocation(liner, Gravity.BOTTOM,0,0);
                tv_photo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {


                    }
                });
                tv_photograph.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                tv_cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ok.setVisibility(View.VISIBLE);
                        p.dismiss();
                    }
                });

                break;
            case R.id.youxiang_liner:
                Intent intent = new Intent(PersonalcenterActivity.this, YouxiangActivity.class);
                intent.putExtra("1",youxiang_updata.getText().toString());
                startActivityForResult(intent,99);

                break;
            case R.id.nicheng_liner:
                Intent intent1 = new Intent(PersonalcenterActivity.this, NiChengActivity.class);
              intent1.putExtra("8", nicheng_updata.getText().toString());
                startActivityForResult(intent1,98);
                break;
            case R.id.name_liner:

                Intent intent3 = new Intent(PersonalcenterActivity.this, NameActivity.class);
                intent3.putExtra("7",name_updata.getText().toString());
                startActivityForResult(intent3,97);
                break;
        }
    }
}
