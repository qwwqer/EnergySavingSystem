package com.example.ln.energy_saving_system.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.example.ln.energy_saving_system.Fragment.CopyFragment;
import com.example.ln.energy_saving_system.Fragment.MeFragment;
import com.example.ln.energy_saving_system.Fragment.MeasurementFragment;
import com.example.ln.energy_saving_system.Fragment.StatisticalFragment;
import com.example.ln.energy_saving_system.MainActivity;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 4;
    private CopyFragment myFragment1 = null;
    private MeasurementFragment myFragment2 = null;
    private MeFragment myFragment3 = null;
    private StatisticalFragment MyFragment4 = null;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new CopyFragment();//接收数据(第二)
        myFragment2 = new MeasurementFragment();//计量终端(第一)
        myFragment3 = new MeFragment();//个人中心(第四)
        MyFragment4 = new StatisticalFragment();//统计报表(第三)
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        return super.instantiateItem(container, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainActivity.PAGE_ONE:
                fragment = myFragment2;
                break;
            case MainActivity.PAGE_TWO:
                fragment = myFragment1;
                break;
            case MainActivity.PAGE_THREE:
                fragment = MyFragment4;
                break;
            case MainActivity.PAGE_FOUR:
                fragment = myFragment3;
                break;
        }
        return fragment;
    }
}