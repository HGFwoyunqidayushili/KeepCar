package jiyun.com.keepcar.ui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.bean.ForeCarXaingQingBean;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class ShopForeCar extends XRecyclerView.Adapter<ShopForeCar.ViewHolder> {
    private List<ForeCarXaingQingBean.DataBean.ListBean> arrayList;
    private Context context;
    private ImageView foreshopImage;
    private TextView foreshopTitle;
    private ImageView foreshoplogo;
    private TextView foreshopLogName;
    private TextView foreshopLogPrice;
    private TextView foreshoppeople;

    public ShopForeCar(List<ForeCarXaingQingBean.DataBean.ListBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.forecariteam, null, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load("http://i01.pictn.sogoucdn.com/6cfc0ff17bbdf9f1").into(holder.foreshopImage);
        Glide.with(context).load("https://img02.sogoucdn.com/net/a/04/link?url=http%3A%2F%2Fi01.pictn.sogoucdn.com%2F6f8ce2037d5016fe&appid=122").into(holder.foreshoplogo);
        holder.foreshopTitle.setText(arrayList.get(position).getProductName());
        holder.foreshopLogName.setText(arrayList.get(position).getShopName());
        holder.foreshopLogPrice.setText(arrayList.get(position).getDiscountPrice()+"");
        holder.foreshoppeople.setText("69999人付过款");
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
/*    private ImageView foreshopImage;
    private TextView foreshopTitle;
    private ImageView foreshoplogo;
    private TextView foreshopLogName;
    private TextView foreshopLogPrice;
    private TextView foreshoppeople;*/

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView foreshopImage;
        private TextView foreshopTitle;
        private ImageView foreshoplogo;
        private TextView foreshopLogName;
        private TextView foreshopLogPrice;
        private TextView foreshoppeople;
        public ViewHolder(View itemView) {
            super(itemView);
            foreshopImage = (ImageView) itemView.findViewById(R.id.foreshopImage);
            foreshopTitle = (TextView) itemView.findViewById(R.id.foreshopTitle);
            foreshoplogo = (ImageView) itemView.findViewById(R.id.foreshoplogo);
            foreshopLogName = (TextView) itemView.findViewById(R.id.foreshopLogName);
            foreshopLogPrice = (TextView) itemView.findViewById(R.id.foreshopLogPrice);
            foreshoppeople = (TextView) itemView.findViewById(R.id.foreshoppeople);
        }
    }
}
