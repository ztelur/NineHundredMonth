package com.example.randy.ninehundredmonth.ui;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.randy.ninehundredmonth.R;

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
