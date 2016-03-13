package org.kd.dhk.activity;


import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.rest.RestService;
import org.kd.dhk.R;
import org.kd.dhk.error.BaseRestClientErrorHandling;
import org.kd.dhk.presenter.MainActPter;
import org.kd.dhk.service.LbsWallService;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

  @Bean
  MainActPter mainActPter;


  @RestService
  LbsWallService lbsWallService;
  @Bean
  BaseRestClientErrorHandling baseRestClientErrorHandling;
  @AfterInject
  void afterInject() {
    lbsWallService.setRestErrorHandler(baseRestClientErrorHandling);
  }

  @Background
  void sysList() {
    System.out.println(lbsWallService.getImageList());
  }


  @Click(R.id.buttom_lbs)
  void ButtomLbs() {

    System.out.println("LbsFragPter");
    mainActPter.toggleFragment(R.id.fl_mainAct, "MainLbsFragMent_", "mainLbsFragMent");
  }

  @Click(R.id.buttom_new)
  void buttomNew() {
    System.out.println("new");
    mainActPter.toggleFragment(R.id.fl_mainAct, "MainNewFragMent_", "mainNewFragMent");
  }

  @Click(R.id.buttom_reply)
  void buttomReply() {
    System.out.println("reply");
    mainActPter.toggleFragment(R.id.fl_mainAct, "MainRePlayFragMent_", "MainRePlayFragMent");
  }

  @Click(R.id.buttom_me)
  void buttomMe() {
    System.out.println("me");
    mainActPter.toggleFragment(R.id.fl_mainAct, "MainMeFragMent_", "MainMeFragMent");
  }
  /**
   *
   * 最好用radioGroup.setOnCheckedChangeListener
   * 因为 上面 @Click方式 再次点击按钮时 会再次触发按钮点击事件
   * radioGroup 是改变时 触发事件
   *
   */
  //    mianSwapVP.setAdapter(new MainSwapViwepager(getSupportFragmentManager()));
//    radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//      @Override
//      public void onCheckedChanged(RadioGroup radioGroup, int i) {
//       switch (i){
//         case R.id.buttom_lbs:
//           System.out.println("0");
//           mianSwapVP.setCurrentItem(0, false);
//           break;
//         case R.id.buttom_new:
//           System.out.println("1");
//           mianSwapVP.setCurrentItem(1,false);
//           break;
//         case R.id.buttom_reply:
//           System.out.println("2");
//           mianSwapVP.setCurrentItem(2,false);
//           break;
//         case R.id.buttom_me:
//           System.out.println("3");
//           mianSwapVP.setCurrentItem(3,false);
//           break;
//       }
//      }
//    });
}