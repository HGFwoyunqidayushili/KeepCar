package jiyun.com.keepcar.ui;


import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment {


    public BaseFragment() {
        // Required empty public constructor
    }



    protected abstract void initView();

    protected abstract void initData();



}
