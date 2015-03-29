package com.example.randy.ninehundredmonth.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.randy.ninehundredmonth.R;
import com.example.randy.ninehundredmonth.data.Date;
import com.example.randy.ninehundredmonth.data.Month;
import com.example.randy.ninehundredmonth.model.MonthLayoutModel;

/**
 * Created by randy on 15-3-22.
 */
public class MonthLayout extends LinearLayout{
    private int mDay_num;
    private int mFirst_day_in_month;
    private Month month;
    private int mMonth;
    private final int mPaneRowNum=6;
    private final int mPaneColNum=7;
    private final int mPaneNum=mPaneColNum*mPaneRowNum;
    private final boolean auto_get_data;
    private static final int ERROR=-1;
    private MonthLayoutModel monthLayoutModel;
    public MonthLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a= context.obtainStyledAttributes(attrs, R.styleable.MonthLayout);
        auto_get_data=a.getBoolean(R.styleable.MonthLayout_auto_get_data,false);
        if (auto_get_data) {
            initData();
        } else {
//            mDay_num = a.getInt(R.styleable.MonthLayout_day_num, ERROR);
//            assert mDay_num != ERROR;
//            mFirst_day_in_month = a.getInt(R.styleable.MonthLayout_first_day_int_month, ERROR);
//            assert mFirst_day_in_month != ERROR;
        }
        this.setOrientation(LinearLayout.VERTICAL);
        initChildView();
    }

    private void initData() {
        this.monthLayoutModel=new MonthLayoutModel(getContext());
        /**
         * 注意只有这个样子才能测出大小
         */
        int w= View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        int h= View.MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED);
        this.measure(w,h);
        int width=this.getMeasuredHeight();
        int height=this.getMeasuredHeight();
        Log.e("MonthLayout"," "+width+" "+height);
        monthLayoutModel.setMeasure(width,height);
//        month=new Month();
//        mDay_num=month.getDayNum();
//        mFirst_day_in_month=month.getFirstDay();
//        mMonth=month.getCurMonth();
    }



    private void initChildView() {
        int firstDayNum=mFirst_day_in_month;
        int dayNum=0;
        for (int i=0;i<mPaneRowNum;i++) {
            LinearLayout linearLayout=new LinearLayout(getContext());
            linearLayout.setOrientation(LinearLayout.HORIZONTAL);
            for (int j=0;j<mPaneColNum;j++) {
                LinearLayout.LayoutParams layoutParams=new LayoutParams(
                        LayoutParams.MATCH_PARENT,
                        LayoutParams.MATCH_PARENT
                );
                layoutParams.weight=1;
                Pane pane=monthLayoutModel.generate();
                linearLayout.addView(pane,layoutParams);
            }
            LinearLayout.LayoutParams params=new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
            );
            params.weight=1;
            this.addView(linearLayout,params);
        }
    }



}
