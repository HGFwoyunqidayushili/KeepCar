package jiyun.com.keepcar.utils;

import android.content.SharedPreferences;
import android.text.TextUtils;

import jiyun.com.keepcar.ui.App;

/**
 * Created by 阿三 on 2017/12/11.
 */
public class UserManager {

  private static UserManager userManager;
  public Loginutil userInfo;

  private SharedPreferences sharedPreferences;
    public synchronized static UserManager getIntance(){
        if(userManager==null){
            userManager=new UserManager();
        }
        return userManager;

    }
    public UserManager(){
        sharedPreferences= App.getInstance().getSharedPreferences("user_info",0);

    }

    //保存当前用户
     public void saveUser(Loginutil userInfo){
         if(userInfo==null){
             return;
         }
         this.userInfo=userInfo;

         sharedPreferences.edit().putString("userId",userInfo.getData()).commit();
         sharedPreferences.edit().putString("userName",userInfo.getAccountUname()).commit();

     }


   //用户是否登陆
     public boolean isLogin(){
        String userId= sharedPreferences.getString("userId",null);
        String userName= sharedPreferences.getString("userName",null);
         return !TextUtils.isEmpty(userId);
     }


    //清除用户信息
    public void clearUser(){
//     userInfo=null;
//      saveUser(userInfo);
        sharedPreferences.edit().remove("userId").commit();
        sharedPreferences.edit().remove("userName").commit();
    }



    //获取id
    public  String getUserId(){
        String id=sharedPreferences.getString("userId",null);
        return id;
    }
    //湖区用户名
    public  String getUserName(){
        String name=sharedPreferences.getString("userName",null);
        return name;
    }
}
