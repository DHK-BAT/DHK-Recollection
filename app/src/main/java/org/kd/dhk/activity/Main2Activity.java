package org.kd.dhk.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;
import org.kd.dhk.R;
import org.kd.dhk.presenter.viewPter;


@EActivity
public class Main2Activity extends AppCompatActivity {

    @Bean
    viewPter vP ;
    @ViewById(R.id.tx_main_view)
    public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @AfterInject
    void ok(){
        System.out.println(vP.view2);
        System.out.println(vP.view2.textView);
//        System.out.println(view2);
//        vP.view2.radioGroup232.setVisibility(View.VISIBLE);
//        vP.view2.textView.setText("12");
}




}
