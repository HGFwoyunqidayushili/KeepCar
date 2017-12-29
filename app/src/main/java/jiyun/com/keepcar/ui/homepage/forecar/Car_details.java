package jiyun.com.keepcar.ui.homepage.forecar;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import jiyun.com.keepcar.R;

public class Car_details extends AppCompatActivity {
    private ImageView yue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);
        initView();
    }

    private void initView() {
        yue = (ImageView) findViewById(R.id.yue);
         yue.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 startActivity(new Intent(Car_details.this,Order_CarActivity.class));
             }
         });
    }
}
