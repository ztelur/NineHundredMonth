package com.example.randy.ninehundredmonth.ui;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.randy.ninehundredmonth.R;
import com.example.randy.ninehundredmonth.model.PlanFragmentModel;

public class MonthFragment extends BaseFragment{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    void initView() {

    }

    @Override
    int getLayout() {
        return R.layout.fragment_month;
    }
}
