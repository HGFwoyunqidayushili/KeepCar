package jiyun.com.keepcar.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import jiyun.com.keepcar.R;

/**
 * Created by 阿三 on 2018/1/3.
 */
public class PopupwindowView {
   private Context context;
   private View contentView;
   private View relayView;
   private PopupWindow popupWindow;
   private View parent;

   public PopupwindowView(Context context, View view, View relayView){
       this.context=context;
       this.contentView=view;
       this.relayView=relayView;
      init();
   }

   private void init() {
      popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT,true);
      //动画效果

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
      if(Build.VERSION.SDK_INT<24){
         popupWindow.setAnimationStyle(R.style.AnimationTopFade);
         popupWindow.showAsDropDown(relayView);
      }
    else {
         int[]location=new int[2];
         relayView .getLocationOnScreen(location);
         int x=location[0];

         int y =location[1];

         popupWindow.showAsDropDown(relayView,0,relayView.getHeight());
      }

   }
   public void showAtLocation(){
       if(Build.VERSION.SDK_INT<24){
          popupWindow.showAtLocation(relayView, Gravity.BOTTOM,0,0);
       }
       else {
          int[]location=new int[2];
          relayView .getLocationOnScreen(location);
          int x=location[0];

          int y =location[1];
          popupWindow.showAtLocation(relayView,Gravity.BOTTOM,0,y+relayView.getHeight());
       }

   }
   public PopupWindow popupdismiss() {

     return popupWindow;
   }
}
