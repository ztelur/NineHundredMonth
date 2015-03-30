package com.example.randy.ninehundredmonth.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by randy on 15-3-29.
 */
public abstract class BaseFragment extends Fragment {
    protected Context context;
    protected View mRootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        this.mRootView=inflater.inflate(getLayout(),null);
        initView();
        return this.mRootView;
    }
    abstract void initView();
    abstract int getLayout();


}
