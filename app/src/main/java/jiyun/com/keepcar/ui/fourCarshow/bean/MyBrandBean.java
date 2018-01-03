package jiyun.com.keepcar.ui.fourCarshow.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by  on 2018/1/2.
 */

public class MyBrandBean {
    private String index;
    private String name;

    public MyBrandBean(String index, String name) {
        this.index = index;
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }

    public static List<MyBrandBean> getEnglishContacts() {
        List<MyBrandBean> myBrandBeen = new ArrayList<>();
        myBrandBeen.add(new MyBrandBean("", "品牌不限"));
        myBrandBeen.add(new MyBrandBean("A", ""));
        myBrandBeen.add(new MyBrandBean("A", ""));

        myBrandBeen.add(new MyBrandBean("B", ""));
        myBrandBeen.add(new MyBrandBean("B", ""));

        myBrandBeen.add(new MyBrandBean("C", ""));
        myBrandBeen.add(new MyBrandBean("C", ""));

        myBrandBeen.add(new MyBrandBean("D", ""));
        myBrandBeen.add(new MyBrandBean("D", ""));
        myBrandBeen.add(new MyBrandBean("E", ""));
        myBrandBeen.add(new MyBrandBean("E", ""));
        myBrandBeen.add(new MyBrandBean("E", ""));
        myBrandBeen.add(new MyBrandBean("F", ""));
        myBrandBeen.add(new MyBrandBean("F", ""));
        myBrandBeen.add(new MyBrandBean("I", ""));
        myBrandBeen.add(new MyBrandBean("J", ""));
        myBrandBeen.add(new MyBrandBean("J", ""));
        myBrandBeen.add(new MyBrandBean("J", ""));
        myBrandBeen.add(new MyBrandBean("K", ""));
        myBrandBeen.add(new MyBrandBean("K", ""));
        myBrandBeen.add(new MyBrandBean("K", ""));
        myBrandBeen.add(new MyBrandBean("L", ""));
        myBrandBeen.add(new MyBrandBean("L", ""));
        myBrandBeen.add(new MyBrandBean("M", ""));
        myBrandBeen.add(new MyBrandBean("M", ""));
        myBrandBeen.add(new MyBrandBean("M", ""));
        myBrandBeen.add(new MyBrandBean("P", ""));
        myBrandBeen.add(new MyBrandBean("P", ""));
        myBrandBeen.add(new MyBrandBean("Q", ""));
        myBrandBeen.add(new MyBrandBean("Q", ""));
        myBrandBeen.add(new MyBrandBean("Q", ""));
        myBrandBeen.add(new MyBrandBean("R", ""));
        myBrandBeen.add(new MyBrandBean("R", ""));
        myBrandBeen.add(new MyBrandBean("R", ""));
        myBrandBeen.add(new MyBrandBean("S", ""));
        myBrandBeen.add(new MyBrandBean("S", ""));
        myBrandBeen.add(new MyBrandBean("R", ""));
        myBrandBeen.add(new MyBrandBean("R", ""));
        myBrandBeen.add(new MyBrandBean("T", ""));
        myBrandBeen.add(new MyBrandBean("T", ""));
        myBrandBeen.add(new MyBrandBean("W", ""));
        myBrandBeen.add(new MyBrandBean("W", ""));
        myBrandBeen.add(new MyBrandBean("W", ""));
        myBrandBeen.add(new MyBrandBean("Z", ""));
        return myBrandBeen;
    }
///
}
