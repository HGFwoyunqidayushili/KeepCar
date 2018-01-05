package jiyun.com.keepcar.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.bean.TestBeanXiChe;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class TestXiCheAdapter extends BaseAdapter {
    private ArrayList<TestBeanXiChe> arrayList;
    private Context context;
    private ViewHolder viewHolder;

    public TestXiCheAdapter(ArrayList<TestBeanXiChe> arrayList, Context context) {
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
            view = View.inflate(context, R.layout.testxicheiteam, null);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(arrayList.get(i).getImage()).into(viewHolder.xicheImage);
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public ImageView xicheImage;
        public RelativeLayout relativeLayout;
        public TextView textView4;
        public TextView textView6;
        public TextView textView7;
        public TextView textView8;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.xicheImage = (ImageView) rootView.findViewById(R.id.xicheImage);
            this.relativeLayout = (RelativeLayout) rootView.findViewById(R.id.relativeLayout);
            this.textView4 = (TextView) rootView.findViewById(R.id.textView4);
            this.textView6 = (TextView) rootView.findViewById(R.id.textView6);
            this.textView7 = (TextView) rootView.findViewById(R.id.textView7);
            this.textView8 = (TextView) rootView.findViewById(R.id.textView8);
        }

    }
}
