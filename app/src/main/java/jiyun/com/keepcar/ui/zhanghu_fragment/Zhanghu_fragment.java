package jiyun.com.keepcar.ui.zhanghu_fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import jiyun.com.keepcar.R;

/**
 * Created by Administrator on 2018/1/2.
 */

public class Zhanghu_fragment extends Fragment {
    private String name;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        name = bundle.get("name").toString();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_jifen, null);
        if(name=="第二个fragment"){
            View a = inflater.inflate(R.layout.fragment_chuzhi, null);
            return a;
        }
        if(name=="第3个fragment"){
            View b = inflater.inflate(R.layout.fragment_yuequan, null);
            return b;
        }
        if(name=="第4个fragment"){
            View c = inflater.inflate(R.layout.fragment_dingequan, null);
            return c;
        }
        return inflate;
    }
    public static Zhanghu_fragment newInstance(String name) {
        Bundle args = new Bundle();
        args.putString("name", name);
        Zhanghu_fragment fragment = new Zhanghu_fragment();
        fragment.setArguments(args);
        return fragment;
    }
}
