package jiyun.com.keepcar.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import jiyun.com.keepcar.R;

/**
 * Created by 阿三 on 2018/1/3.
 */
public class Popupwindow {
   private Context context;
   private View contentView;
   private View relayView;
   private PopupWindow popupWindow;
   public Popupwindow (Context context, View view,View relayView){
       this.context=context;
       this.contentView=view;
       this.relayView=relayView;
      init();
   }

   private void init() {
      popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,true);
      //动画效果
      popupWindow.setAnimationStyle(R.style.AnimationTopFade);
      //菜单背景色
      ColorDrawable dw = new ColorDrawable(Color.TRANSPARENT);
      popupWindow.setBackgroundDrawable(dw);
      popupWindow.setOutsideTouchable(true);
      //关闭事件
      popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
      popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

   }
   public void show(){
      //显示位置
      popupWindow.showAsDropDown(relayView);
   }
}
