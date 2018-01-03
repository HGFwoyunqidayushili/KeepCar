package jiyun.com.keepcar.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.bean.TestBean;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class ForeCarAdapter extends BaseAdapter {
    private ArrayList<TestBean> arrayList;
    private Context context;
    private ViewHolder viewHoder;

    public ForeCarAdapter(ArrayList<TestBean> arrayList, Context context) {
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
            viewHoder = new ViewHolder(convertView);
            convertView.setTag(viewHoder);
        }else {
            viewHoder = (ViewHolder) convertView.getTag();
        }
        viewHoder.carName.setText(arrayList.get(position).getName());

        return convertView;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView carName;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.carName = (TextView) rootView.findViewById(R.id.carName);
        }

    }
}
