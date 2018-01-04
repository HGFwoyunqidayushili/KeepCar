package jiyun.com.keepcar.ui.homepage.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.homepage.fragment.activity.ChooseCarActivity;
import jiyun.com.keepcar.ui.login.PersonalcenterActivity;
import jiyun.com.keepcar.ui.zhanghu_fragment.Zhanghu_fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class PersonalFragment extends Fragment implements View.OnClickListener {
    private ImageView icon_login;
    private TextView name_login;
    private RadioButton daifukuan_rabtn;
    private RadioButton daishigong_rabtn;
    private RadioButton daifahuo_rabtn;
    private RadioButton daishouhuo_rabtn;
    private RadioButton daipingjia_rabtn;
    private RadioButton yiquxiao_rabtn;
    private RadioGroup group_dingdan;
    private ImageView mycars_img;
    private TextView current_car;
    private ImageView img_go;
    private TextView current_cars;
    private TextView current_dianmian;
    private ImageView img_gos;
    private TextView dianmian_current;
    private RadioButton jifen_btn;
    private RadioButton xiangmu_btn;
    private RadioButton chuzhi_btn;
    private RadioButton xiche_btn;
    private RadioButton yuequan_btn;
    private RadioButton jibiezhekou_btn;
    private RadioButton dingequan_btn;
    private RadioGroup rid_group;
    private FrameLayout frag_zhanghu;
    private RelativeLayout my_car;
    private RelativeLayout dangqian_car;
    private  TextView my_dingdan;

    public PersonalFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_personal, container, false);
        initView(inflate);
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        FragmentTransaction add = fragmentTransaction.add(R.id.frag_zhanghu, Zhanghu_fragment.newInstance("第一个fragment"));
//        add.commit();
        initListener();
        return inflate;
    }

    private void initListener() {
        rid_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.jifen_btn:
                        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                        FragmentTransaction add = fragmentTransaction.replace(R.id.frag_zhanghu, Zhanghu_fragment.newInstance("第一个fragment"));
                        add.commit();
                        break;
                    case R.id.chuzhi_btn:
                        FragmentTransaction f1 = getFragmentManager().beginTransaction();
                        FragmentTransaction replace1 = f1.replace(R.id.frag_zhanghu, Zhanghu_fragment.newInstance("第二个fragment"));
                        replace1.commit();
                        break;
                    case R.id.xiangmu_btn:
                        break;
                    case R.id.yuequan_btn:
                        FragmentTransaction f2 = getFragmentManager().beginTransaction();
                        FragmentTransaction replace2 = f2.replace(R.id.frag_zhanghu, Zhanghu_fragment.newInstance("第3个fragment"));
                        replace2.commit();
                        break;
                    case R.id.dingequan_btn:
                        FragmentTransaction f4 = getFragmentManager().beginTransaction();
                        FragmentTransaction replace4 = f4.replace(R.id.frag_zhanghu, Zhanghu_fragment.newInstance("第4个fragment"));
                        replace4.commit();
                        break;
                    case R.id.xiche_btn:
                        break;
                }
            }
        });
    }

    private void initView(View inflate) {
        my_dingdan= (TextView) inflate.findViewById(R.id.my_dingdan);
        my_dingdan.setOnClickListener(this);
        icon_login = (ImageView) inflate.findViewById(R.id.icon_login);
        name_login = (TextView) inflate.findViewById(R.id.name_login);
        daifukuan_rabtn = (RadioButton) inflate.findViewById(R.id.daifukuan_rabtn);
        daishigong_rabtn = (RadioButton) inflate.findViewById(R.id.daishigong_rabtn);
        daifahuo_rabtn = (RadioButton) inflate.findViewById(R.id.daifahuo_rabtn);
        daishouhuo_rabtn = (RadioButton) inflate.findViewById(R.id.daishouhuo_rabtn);
        daipingjia_rabtn = (RadioButton) inflate.findViewById(R.id.daipingjia_rabtn);
        yiquxiao_rabtn = (RadioButton) inflate.findViewById(R.id.yiquxiao_rabtn);
        group_dingdan = (RadioGroup) inflate.findViewById(R.id.group_dingdan);
        mycars_img = (ImageView) inflate.findViewById(R.id.mycars_img);
        current_car = (TextView) inflate.findViewById(R.id.current_car);
        img_go = (ImageView) inflate.findViewById(R.id.img_go);
        current_cars = (TextView) inflate.findViewById(R.id.current_cars);
        current_dianmian = (TextView) inflate.findViewById(R.id.current_dianmian);
        img_gos = (ImageView) inflate.findViewById(R.id.img_gos);
        dianmian_current = (TextView) inflate.findViewById(R.id.dianmian_current);
        jifen_btn = (RadioButton) inflate.findViewById(R.id.jifen_btn);
        xiangmu_btn = (RadioButton) inflate.findViewById(R.id.xiangmu_btn);
        chuzhi_btn = (RadioButton) inflate.findViewById(R.id.chuzhi_btn);
        xiche_btn = (RadioButton) inflate.findViewById(R.id.xiche_btn);
        yuequan_btn = (RadioButton) inflate.findViewById(R.id.yuequan_btn);
        jibiezhekou_btn = (RadioButton) inflate.findViewById(R.id.jibiezhekou_btn);
        dingequan_btn = (RadioButton) inflate.findViewById(R.id.dingequan_btn);
        rid_group = (RadioGroup) inflate.findViewById(R.id.rid_group);
        frag_zhanghu = (FrameLayout) inflate.findViewById(R.id.frag_zhanghu);

        icon_login.setOnClickListener(this);
        my_car = (RelativeLayout) inflate.findViewById(R.id.my_car);
        my_car.setOnClickListener(this);
        dangqian_car = (RelativeLayout) inflate.findViewById(R.id.dangqian_car);
        dangqian_car.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.icon_login:
                Intent intent = new Intent(getActivity(), PersonalcenterActivity.class);
                startActivityForResult(intent, 100);
                break;
            case R.id.my_car:
                Intent intent1 = new Intent(getActivity(), ChooseCarActivity.class);
                startActivity(intent1);
                break;
            case R.id.my_dingdan:

                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == 100) {
            String tex = data.getStringExtra("tex");
            name_login.setText(tex);
        }
    }
}
