package jiyun.com.keepcar.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
            viewHolder =new ViewHolder(view);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.testText.setText(arrayList.get(i).getName());
        return view;
    }

    public static class ViewHolder {
        public View rootView;
        public TextView testText;

        public ViewHolder(View rootView) {
            this.rootView = rootView;
            this.testText = (TextView) rootView.findViewById(R.id.testText);
        }

    }
}
