package jiyun.com.keepcar.ui.homepage.fragment.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.login.DetailsActivity;

/**
 * Created by Administrator on 2018/1/4.
 */

public class DingdanFragemnt extends Fragment {
    private String name;
    private TextView jingpin;
    private TextView xiangqiang;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        name = bundle.get("name").toString();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragmnet_dingdan, null);

//        if(name=="0"){
//            View a = inflater.inflate(R.layout.fragment_chuzhi, null);
//            return a;
//        }
//        if(name=="第3个fragment"){
//            View b = inflater.inflate(R.layout.fragment_yuequan, null);
//            return b;
//        }
//        if(name=="第4个fragment"){
//            View c = inflater.inflate(R.layout.fragment_dingequan, null);
//            return c;
//        }
        initView(inflate);
        return inflate;
    }

    public static DingdanFragemnt newInstances(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        DingdanFragemnt fragment = new DingdanFragemnt();
        fragment.setArguments(args);
        return fragment;
    }

    private void initView(View inflate) {
        jingpin = (TextView) inflate.findViewById(R.id.jingpin);
        xiangqiang = (TextView) inflate.findViewById(R.id.xiangqiang);
        xiangqiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailsActivity.class);
                startActivity(intent);
            }
        });
    }
}
