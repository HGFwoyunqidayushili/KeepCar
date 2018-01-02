package jiyun.com.keepcar.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * 这个世界上没有天才和大神,只有不努力的笨蛋和菜鸟   ____刘荣斌_____
 */
public class InsertFragment extends FragmentPagerAdapter {
    private ArrayList<Fragment> arrayList;
    private ArrayList<String> strings;

    public InsertFragment(FragmentManager fm, ArrayList<Fragment> arrayList, ArrayList<String> strings) {
        super(fm);
        this.arrayList = arrayList;
        this.strings = strings;
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings.get(position);
    }
}
