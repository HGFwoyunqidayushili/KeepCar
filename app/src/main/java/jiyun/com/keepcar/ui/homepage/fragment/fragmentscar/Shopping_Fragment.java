package jiyun.com.keepcar.ui.homepage.fragment.fragmentscar;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import jiyun.com.keepcar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Shopping_Fragment extends Fragment {
    private final String URL = "http://39.106.173.47:8080/app/boutique/showProduct.do?ak=f4474404846d470a8e1f6c081a28acc5&channel=android";
    private XRecyclerView rexyxView;

    public Shopping_Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_shopping_, container, false);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {

    }

    private void initView(View inflate) {
        rexyxView = (XRecyclerView) inflate.findViewById(R.id.rexyxView);
    }
}
