package com.example.randy.ninehundredmonth.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.randy.ninehundredmonth.R;
import com.example.randy.ninehundredmonth.model.PlanFragmentModel;

/**
 * Created by randy on 15-3-29.
 */
public class PlanFragment extends BaseFragment {
    private ListView mDrawerList;
    private PlanFragmentModel mPlanModel;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPlanModel=new PlanFragmentModel(this);
    }

    @Override
    void initView() {
        mDrawerList=(ListView)mRootView.findViewById(R.id.plan_sildebar);
        mDrawerList.setAdapter(mPlanModel.getAdapter());
        mDrawerLayout=(DrawerLayout)mRootView.findViewById(R.id.drawer_layout);
        mToggle=mPlanModel.getmDrawerToggle(mDrawerLayout,R.drawable.ic_launcher,
                R.string.drawer_open,R.string.drawer_close);
        mDrawerLayout.setDrawerListener(mToggle);
        mDrawerLayout.openDrawer(Gravity.START);
    }

    @Override
    int getLayout() {
        return R.layout.fragment_plan;
    }
}
