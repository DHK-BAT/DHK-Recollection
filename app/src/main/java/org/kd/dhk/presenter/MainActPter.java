package org.kd.dhk.presenter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.kd.dhk.activity.MainActivity;
import org.kd.dhk.view.MainActView;

import java.util.ArrayList;
import java.util.List;

/**
 * 代号:隐无为
 * 时间:2016/1/27
 * 用途：主界面的交互类
 */
@EBean
public class MainActPter {
    @Bean
    public MainActView mainActView;
    @RootContext
    MainActivity mainActivity;
//    @FragmentByTag
//    MainLbsFragMent mainLbsFragMent;
//    @FragmentByTag
//    MainNewFragMent mainNewFragMent;
//    @FragmentByTag
//    MainRePlayFragMent mainRePlayFragMent;
//    @FragmentByTag
//    MainMeFragMent mainMeFragMent;

    List<String>MainFList=new ArrayList<String>();


    /**
     * 功能:初始化Fragment
     * 代号:隐无为
     * 时间:2016/1/27
     * 参数:
     */
    public  void initFragment(){



    }
    /**
     * 功能:初始化ViewPage
     * 代号:隐无为
     * 时间:2016/1/27
     * 参数:
     */
    public  void initMianSwapVP(){
        
    }
   /**
    * 功能:切换fragment
    * 代号:隐无为
    * 时间:2016/1/27<p>
    * 参数: frarment  layout 布局文件
    * clazz (反射类)
    * frarment 名字
    */
     public  void toggleFragment(int layout,String clazz,String frarmentTagName){

       FragmentManager fragmentManager = mainActivity.getSupportFragmentManager();
       FragmentTransaction transaction = fragmentManager.beginTransaction();
       for (String name:MainFList) {
         Fragment tag = fragmentManager.findFragmentByTag(name);
         if (tag!=null){
           transaction.hide(tag);
         }
       }
       Fragment frarmentNameTag = fragmentManager.findFragmentByTag(frarmentTagName);
       if(frarmentNameTag==null){
         try {
           transaction.add(layout,(Fragment)Class.forName("org.kd.dhk.fragment."+clazz).newInstance(),frarmentTagName);
           MainFList.add(frarmentTagName);
         } catch (Exception e) {
           e.printStackTrace();
         }

       }else{
         transaction.show(frarmentNameTag);
       }
       transaction.commit();// 提交事务
      }

}
