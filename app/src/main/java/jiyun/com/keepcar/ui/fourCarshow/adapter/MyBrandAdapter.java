package jiyun.com.keepcar.ui.fourCarshow.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.fourCarshow.bean.MyBrandBean;

/**
 * Created by  on 2017/12/28.
 */

public class MyBrandAdapter extends RecyclerView.Adapter<MyBrandAdapter.ViewHolder> {

    private List<MyBrandBean> myBrandBeen;
    private Context context;


    public MyBrandAdapter(List<MyBrandBean> myBrandBeen, Context context) {
        this.myBrandBeen = myBrandBeen;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.item_brand, parent, false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MyBrandBean myBrandBean = myBrandBeen.get(position);
        if (position == 0 || !myBrandBeen.get(position - 1).getIndex().equals(myBrandBean.getIndex())) {
            holder.tv_index.setVisibility(View.VISIBLE);
            holder.tv_index.setText(myBrandBean.getIndex());
        } else {
            holder.tv_index.setVisibility(View.GONE);
        }
        holder.tv_name.setText(myBrandBean.getName());
        if(myBrandBean.getName().equals("品牌不限")){
            holder.tv_index.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return myBrandBeen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv_index;
        private final TextView tv_name;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_index = (TextView) itemView.findViewById(R.id.tv_index);

            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        }

    }
}
/*BaseAdapter {

    private Context context;
    List<MyCarBrand.DataBean.BrandListBean> data;

    public MyBrandAdapter(Context context, List<MyCarBrand.DataBean.BrandListBean> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder viewHolder;
        if(view==null){
            viewHolder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.item_brand,null);
            viewHolder.imageView = view.findViewById(R.id.icon);
            viewHolder.textView = view.findViewById(R.id.title);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textView.setText(data.get(position).getValue());

        return view;
    }
    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}*/
