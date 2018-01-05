package jiyun.com.keepcar.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.bean.ForeCarBean;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class ForeCarAdapter extends BaseAdapter {
    private List<ForeCarBean.DataBean.ListBean> arrayList;
    private Context context;
    private ViewHolder viewHolder;

    public ForeCarAdapter(List<ForeCarBean.DataBean.ListBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return arrayList.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.forelistieam, null);
            viewHolder =new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.forecarName.setText(arrayList.get(position).getShopName());
        viewHolder.forecarContent.setText(arrayList.get(position).getProvinceName()+arrayList.get(position).getCityName());

        return convertView;
    }


    public static class ViewHolder {
        public View rootView;
        public ImageView forecar_Image;
        public TextView forecarName;
        public TextView forecarContent;
        public ImageView fprecarlogo;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.forecar_Image = (ImageView) rootView.findViewById(R.id.forecar_Image);
            this.forecarName = (TextView) rootView.findViewById(R.id.forecarName);
            this.forecarContent = (TextView) rootView.findViewById(R.id.forecarContent);
            this.fprecarlogo = (ImageView) rootView.findViewById(R.id.fprecarlogo);
        }

    }
}
