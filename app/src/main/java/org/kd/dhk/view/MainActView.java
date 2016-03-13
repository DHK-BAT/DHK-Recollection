package org.kd.dhk.view;

import android.support.v4.app.Fragment;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.FragmentById;
import org.androidannotations.annotations.ViewById;
import org.kd.dhk.R;

/**
 * 代号:隐无为
 * 时间:2016/1/27
 * 用途：主界面的UI控件
 */
@EBean
public class MainActView {
    @ViewById(R.id.ButtomRadioGroup)
    public RadioGroup radioGroup;
    @ViewById(R.id.buttom_lbs)
    public RadioButton radioButton;
    @FragmentById(R.id.fl_mainAct)
    Fragment fl_mainAct;
    @AfterViews
    void afterViews() {
        radioButton.setChecked(true);
        radioButton.performClick();
        //radioGroup.setVisibility(View.INVISIBLE);
    }


}
