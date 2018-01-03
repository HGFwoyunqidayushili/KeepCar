package jiyun.com.keepcar.ui.adapter.carRenewal.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.adapter.carRenewal.activity.RenewalAcrivity;
import jiyun.com.keepcar.ui.adapter.carRenewal.bean.Insurancecompany;

/**
 * Created by 阿三 on 2018/1/3.
 */
public class InsuranceName extends BaseAdapter {
    private Context context;
    private  List<Insurancecompany.DataBean> insurancecompanyList;
    public InsuranceName(RenewalAcrivity renewalAcrivity, List<Insurancecompany.DataBean> insurancecompanyList) {
        this.context=renewalAcrivity;
        this.insurancecompanyList=insurancecompanyList;
    }

    @Override
    public int getCount() {
        return insurancecompanyList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        MyViewHolder holder=null;
        if(holder==null){
            holder=new MyViewHolder();
            view=LayoutInflater.from(context).inflate(R.layout.item,null);
            holder.name= (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        }
        else {
            holder= (MyViewHolder) view.getTag();
        }

        holder.name.setText(insurancecompanyList.get(i).getName());
        return view;


    }
    class MyViewHolder{
        private TextView name;
    }
}
