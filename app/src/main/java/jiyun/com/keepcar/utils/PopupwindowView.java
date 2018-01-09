package jiyun.com.keepcar.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;

import jiyun.com.keepcar.R;
import jiyun.com.keepcar.ui.App;

/**
 * Created by 阿三 on 2018/1/3.
 */
public class PopupwindowView {
   private Context context;
   private View contentView;
   private View relayView;
   private PopupWindow popupWindow;
   private View parent;
    private float alpha=1;
   public Handler handler=new Handler(){
       @Override
       public void handleMessage(Message msg) {
           super.handleMessage(msg);
           switch (msg.what){
               case 1:
                   backgroundAlpha((Float) msg.obj);
                   break;
           }
       }
   };

    public PopupwindowView(Context context, View view, View relayView){
       this.context=context;
       this.contentView=view;

       this.relayView=relayView;
      init();
   }

   private void init() {
      popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,true);
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
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while(alpha>0.5f){
                        try {
                            //4是根据弹出动画时间和减少的透明度计算
                            Thread.sleep(4);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        Message msg =handler.obtainMessage();
                        msg.what = 1;
                        //每次减少0.01，精度越高，变暗的效果越流畅
                        alpha-=0.01f;
                        msg.obj =alpha ;
                        handler.sendMessage(msg);
                    }
                }
            }).start();

       popupdismiss();
       if(Build.VERSION.SDK_INT<24){
           popupWindow.setAnimationStyle(R.style.mypopupwindow);
           popupWindow.showAtLocation(relayView,Gravity.BOTTOM,0,0);
       }
       else {
          int[]location=new int[2];
          relayView .getLocationOnScreen(location);
          int x=location[0];

          int y =location[1];
           popupWindow.setAnimationStyle(R.style.mypopupwindow);
          popupWindow.showAtLocation(relayView,Gravity.BOTTOM,0,-location[1]);
       }

   }
   public void  popupdismiss() {
     popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
         @Override
         public void onDismiss() {
             new Thread(new Runnable() {
                 @Override
                 public void run() {
                     while(alpha<1f){
                         try {
                             Thread.sleep(4);
                         } catch (InterruptedException e) {
                             e.printStackTrace();
                         }
                         Log.d("HeadPortrait","alpha:"+alpha);
                         Message msg =handler.obtainMessage();
                         msg.what = 1;
                         alpha+=0.01f;
                         msg.obj =alpha ;
                         handler.sendMessage(msg);
                     }

                 }
             }).start();
         }
     });

   }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param bgAlpha
     */
    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = App.activity.getWindow().getAttributes();
        lp.alpha=bgAlpha;
        App.activity.getWindow().setAttributes(lp);

    }


}
