package org.kd.dhk.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import org.kd.dhk.fragment.MainLbsFragMent_;
import org.kd.dhk.fragment.MainMeFragMent_;
import org.kd.dhk.fragment.MainNewFragMent_;
import org.kd.dhk.fragment.MainRePlayFragMent_;

import java.util.ArrayList;
import java.util.List;

/**
 * 代号:隐无为
 * 时间:2016/1/24
 * 用途：
 */
public class MainSwapViwepager extends FragmentPagerAdapter {


    List<Fragment> fragmentList = null;


    public MainSwapViwepager(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new MainLbsFragMent_());
        fragmentList.add(new MainNewFragMent_());
        fragmentList.add(new MainRePlayFragMent_());
        fragmentList.add(new MainMeFragMent_());


    }

    @Override
    public Fragment getItem(int position) {
        System.out.println("getItem:" + position);
        return fragmentList.get(position);
    }


    @Override
    public int getCount() {
        return fragmentList.size();
    }
}
