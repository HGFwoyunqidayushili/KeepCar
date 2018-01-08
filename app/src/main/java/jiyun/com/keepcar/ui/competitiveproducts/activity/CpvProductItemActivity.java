package jiyun.com.keepcar.ui.competitiveproducts.activity;

import android.view.View;
import android.widget.Button;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;

public class CpvProductItemActivity extends BaseActivity implements View.OnClickListener{

    private Button purchase;


    @Override
    protected void initView() {
        purchase= (Button) findViewById(R.id.purchase);
        purchase.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected int getLayoutID() {
        return R.layout.activity_cpv_product_item;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.purchase:

                break;

        }
    }
}
