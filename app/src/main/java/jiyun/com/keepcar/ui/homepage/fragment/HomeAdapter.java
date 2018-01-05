package jiyun.com.keepcar.ui.homepage.fragment;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.entity.homepage.CarActivity;

/**
 * Created by 阿三 on 2018/1/5.
 */
public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private Context context;
    private List<CarActivity.DataBean> data;

    public HomeAdapter(FragmentActivity activity, List<CarActivity.DataBean> data) {
        this.context = activity;
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.homeitem, parent, false);
         ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.productName.setText(data.get(position).getProductName());
        holder.productType.setText(data.get(position).getProductType());
        holder.fukuan.setText(data.get(position).getOriginalPrice()+"");

    }

    @Override
    public int getItemCount() {
        Log.e("TAG","首页的热门----------------"+data.size());
        return data.size();
    }





    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public ImageView img;
        public TextView productName;
        public TextView productType;
        public TextView fukuan;
        public TextView price;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.img = (ImageView) rootView.findViewById(R.id.img);
            this.productName = (TextView) rootView.findViewById(R.id.productName);
            this.productType = (TextView) rootView.findViewById(R.id.productType);
            this.fukuan = (TextView) rootView.findViewById(R.id.fukuan);
            this.price = (TextView) rootView.findViewById(R.id.price);
        }

    }
}
