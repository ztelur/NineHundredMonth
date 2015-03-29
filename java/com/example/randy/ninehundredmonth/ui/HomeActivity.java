package com.example.randy.ninehundredmonth.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;

import com.example.randy.ninehundredmonth.R;

import java.util.HashMap;

/**
 * Created by randy on 15-3-29.
 */
public class HomeActivity extends FragmentActivity{
    private static final int FRAGMENT_SIZE=3;
    private static final int TAB_POS_0=0;
    private static final int TAB_POS_1=1;
    private static final int TAB_POS_2=2;
    private HashMap<Integer,Fragment> mFragmentMap;
    private ViewPager mViewPager;
//    private ArrayList<>
    /**
     * 这个是用来监控VIewPager的界面的转换的，但是如果除了PageView之外，没有界面使用
     * 其实，并不需要这个接口
     */
    private ViewPager.OnPageChangeListener mPageChangedListener =
        new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int i, float v, int i2) {

    }

    @Override
    public void onPageSelected(int i) {

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }
    private void initView() {
        mViewPager=(ViewPager)findViewById(R.id.viewPager);

    }

    private class HomePagerAdapter extends FragmentPagerAdapter {
        public HomePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            super.destroyItem(container, position, object);
        }

        @Override
        public Fragment getItem(int i) {
            Fragment fragment=null;
            switch (i) {
                case TAB_POS_0:
                    fragment=new PlanFragment();
                    break;
                case TAB_POS_1:
                    fragment=new MonthFragment();
                    break;
                case TAB_POS_2:
                    fragment=new LifeFragment();
                    break;
                default:
                    assert true;
                    break;

            }
            mFragmentMap.put(i,fragment);
            return fragment;
        }

        @Override
        public int getCount() {
            return FRAGMENT_SIZE;
        }

    }
}
