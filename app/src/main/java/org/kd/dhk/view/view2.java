package org.kd.dhk.view;

import android.widget.RadioGroup;
import android.widget.TextView;

import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.ViewById;
import org.kd.dhk.R;

/**
 * 代号:隐无为
 * 时间:2016/1/25
 * 用途：
 */
@EBean
public class view2 {
    @ViewById(R.id.tx_main_view)
   public TextView textView;
   @ViewById(R.id.Rg)
   public RadioGroup radioGroup232;
}
