package org.kd.dhk.fragment;

import android.support.v4.app.Fragment;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.kd.dhk.R;
import org.kd.dhk.presenter.LbsFragPter;


/**
 * 代号:隐无为
 * 时间:2016/1/24
 * 用途：
 */
@EFragment(R.layout.main_lbs_fragment)
public class MainLbsFragMent extends Fragment {

  @Bean
  LbsFragPter lbsFragPter;
  @Click(R.id.btn_top)
  void btnTop() {
    lbsFragPter.scrollToTop();
  }




}
