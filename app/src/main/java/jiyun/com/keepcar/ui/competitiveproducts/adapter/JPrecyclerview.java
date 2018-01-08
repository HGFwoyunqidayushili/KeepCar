package jiyun.com.keepcar.ui.competitiveproducts.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.competitiveproducts.activity.JingpinActivity;
import jiyun.com.keepcar.ui.competitiveproducts.bean.Competpd;

/**
 * Created by 阿三 on 2018/1/5.
 */
public class JPrecyclerview extends RecyclerView.Adapter<JPrecyclerview.ViewHolder> {
    private Context context;
    private List<Competpd.DataBean.ListBean> listBeen;
    private ItemOnclick itemOnclick;
    public JPrecyclerview(JingpinActivity jingpinActivity, List<Competpd.DataBean.ListBean> listBeen) {
        this.context = jingpinActivity;
        this.listBeen = listBeen;
    }

    @Override
    public  ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
         View view=LayoutInflater.from(context).inflate(R.layout.jpitem,parent,false);
        ViewHolder holder=new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
            holder.productName.setText(listBeen.get(position).getProductName());
            holder.shopName.setText(listBeen.get(position).getShopName());
            holder.product_price.setText(listBeen.get(position).getOriginalPrice()+"");
        Log.e("TAG","-------------------------------------"+listBeen.get(position).getProductName());
           holder.rootView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   itemOnclick.setItemOnclick(position);
               }
           });
    }

    @Override
    public int getItemCount() {
        Log.e("TAG","适配器的数组长度为-------------"+listBeen.size());
        return listBeen.size();

    }



    class ViewHolder extends RecyclerView.ViewHolder{
        public View rootView;
        public TextView productName;
        public TextView shopName;
        public TextView product_price;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.productName = (TextView) rootView.findViewById(R.id.productName);
            this.shopName = (TextView) rootView.findViewById(R.id.shopName);
            this.product_price = (TextView) rootView.findViewById(R.id.product_price);
        }

    }
    public interface ItemOnclick{
        void setItemOnclick(int position);
    }
    public void ItemOnclick(ItemOnclick itemOnclick){
        this.itemOnclick=itemOnclick;
    }


}
