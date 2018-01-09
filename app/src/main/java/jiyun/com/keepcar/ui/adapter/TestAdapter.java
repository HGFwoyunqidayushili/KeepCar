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
public class TestAdapter extends BaseAdapter {
    private ArrayList<TestBean> arrayList;
    private Context context;
    private ViewHolder viewHolder;

    public TestAdapter(ArrayList<TestBean> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
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
        if (view == null) {
            view = View.inflate(context, R.layout.testiteam, null);
             viewHolder = new ViewHolder(view);
            Glide.with(context).load(arrayList.get(i).getImage()).into(viewHolder.xiecheImage);
            viewHolder.xicheName.setText(arrayList.get(i).getName());
            viewHolder.xicheContent.setText(arrayList.get(i).getContent());
            viewHolder.xichePrice.setText(arrayList.get(i).getPrice());
            viewHolder.xicheShuxing.setText(arrayList.get(i).getCarattribute());
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        return view;
    }


    public static class ViewHolder {
        public View rootView;
        public ImageView xiecheImage;
        public TextView xicheName;
        public TextView xicheContent;
        public TextView xichePrice;
        public TextView xicheShuxing;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.xiecheImage = (ImageView) rootView.findViewById(R.id.xiecheImage);
            this.xicheName = (TextView) rootView.findViewById(R.id.xicheName);
            this.xicheContent = (TextView) rootView.findViewById(R.id.xicheContent);
            this.xichePrice = (TextView) rootView.findViewById(R.id.xichePrice);
            this.xicheShuxing = (TextView) rootView.findViewById(R.id.xicheShuxing);
        }

    }
}
