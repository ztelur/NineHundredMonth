package com.example.randy.ninehundredmonth.ui;

import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.os.MessageQueue;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
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
    private HashMap<Integer,BaseFragment> mFragmentMap;
    private int cur_Fragment=TAB_POS_1;
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
//    private ArrayList<>
    /**
     * 这个是用来监控VIewPager的界面的转换的，但是如果除了PageView之外，没有界面使用
     * 其实，并不需要这个接口
     */
    private ViewPager.OnPageChangeListener mPageChangedListener =
        new ViewPager.OnPageChangeListener() {
    @Override
    public void onPageScrolled(int i, float v, int i2) {
        Log.e("onPageScrollled",i+" "+v+" "+i2);
        mFragmentMap.get(cur_Fragment).onPageScolled(i,v,i2);
    }

    @Override
    public void onPageSelected(int i) {
        Log.e("onPageSelected",i+"");
        cur_Fragment=i;
        getActionBar().setSelectedNavigationItem(i);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
};
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initActionBar();
        initView();
        mFragmentMap=new HashMap<Integer, BaseFragment>();

    }
    private void initActionBar() {
        final ActionBar actionBar=getActionBar();
        //这是设置的ｔａｂ的显示的模式
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        ActionBar.TabListener tabListener=new ActionBar.TabListener() {
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
                if (mViewPager!=null) {
                    mViewPager.setCurrentItem(tab.getPosition());
                }
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

            }
        };
        for(int i=0;i<FRAGMENT_SIZE;i++) {
            ActionBar.Tab tab=actionBar.newTab();
            actionBar.addTab(actionBar.newTab().setText("tab"+i).setTabListener(tabListener));
        }

    }
    private void initView() {
        mViewPager=(ViewPager)findViewById(R.id.viewPager);
        //所有的view如果忘记了添加adapter的话，都没有结果的啊。
        mPagerAdapter=new HomePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOnPageChangeListener(mPageChangedListener);
        mViewPager.setCurrentItem(TAB_POS_1);
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
            BaseFragment fragment=null;
//            if (mFragmentMap.containsKey(i)) {
//                return mFragmentMap.get(i);
//            }
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
            Log.e("getItem","fragment is"+i);
            mFragmentMap.put(i,fragment);
            return fragment;

        }

        @Override
        public int getCount() {
            return FRAGMENT_SIZE;
        }

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        boolean result=super.dispatchTouchEvent(ev);
        int action=ev.getAction();
        if (action==MotionEvent.ACTION_SCROLL) {

        }
        return result;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_home,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_find:
                Log.e("MenuItem","find");
                return true;
            case R.id.action_search:
                Log.e("MenuItem","search");
                return true;
            case R.id.action_settings:
                Log.e("MenuItem","setting");
                return true;
            default:
                return super.onMenuItemSelected(featureId, item);
        }
    }
}
