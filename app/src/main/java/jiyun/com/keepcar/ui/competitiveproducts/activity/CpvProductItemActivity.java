package jiyun.com.keepcar.ui.competitiveproducts.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.zhy.autolayout.AutoLinearLayout;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.BaseActivity;
import jiyun.com.keepcar.utils.PopupwindowView;

public class CpvProductItemActivity extends BaseActivity implements View.OnClickListener{

    private Button purchase;
    private Button determine;
    private PopupwindowView popupwindowView;
    private AutoLinearLayout linearLayout;

    @Override
    protected void initView() {
        purchase= (Button) findViewById(R.id.purchase);
        purchase.setOnClickListener(this);
        linearLayout= (AutoLinearLayout) findViewById(R.id.line1);
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
                View view1= LayoutInflater.from(this).inflate(R.layout.purchase,null);
                determine= (Button) view1.findViewById(R.id.determine);
                popupwindowView=new PopupwindowView(this,view1,linearLayout);
                popupwindowView.showAtLocation();
                break;

        }
    }
}
