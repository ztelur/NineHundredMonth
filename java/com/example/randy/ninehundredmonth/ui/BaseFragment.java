package com.example.randy.ninehundredmonth.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by randy on 15-3-29.
 */
public abstract class BaseFragment extends Fragment {
    protected Context context;
    protected View mView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
        initRootView();
    }
    abstract void initRootView();
}
