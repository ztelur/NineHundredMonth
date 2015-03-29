package com.example.randy.ninehundredmonth.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;

import com.example.randy.ninehundredmonth.R;

/**
 * Created by randy on 15-3-29.
 */
public class LifeFragment extends BaseFragment {
    private Context context;
    private View mView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    void initRootView() {
        mView= LayoutInflater.from(context).inflate(R.layout.fragment_life,null);
    }
}
