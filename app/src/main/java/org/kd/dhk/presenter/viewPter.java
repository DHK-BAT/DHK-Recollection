package org.kd.dhk.presenter;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.kd.dhk.activity.Main2Activity;
import org.kd.dhk.view.view2;

/**
 * 代号:隐无为
 * 时间:2016/1/25
 * 用途：
 */
@EBean
public class viewPter {
    @Bean
    public view2 view2;
    @RootContext
    Main2Activity main2Activity;
}
