package com.example.randy.ninehundredmonth.model;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;

import com.example.randy.ninehundredmonth.data.Date;

/**
 * Created by randy on 15-3-26.
 */
public class PaneModel {
    private RectF mRectF;
    private Paint mPaint;
    public static final int NO_USE_FLAG=-1;
    public static final int USE_FLAG=0;
    private int flag;
    private int color;
    private int time;
    public PaneModel(int flag,int color,int time) {
        this.flag=flag;
        this.color=color;
        this.time=time;
        initPaint();
    }

    public void initRect(int w,int h) {
       int  lineWidth=(int)(w/ Date.HOUR_A_DAY);
//        int hour=CalendarUtil.getHourTime();  //获取当前时间
        mRectF=new RectF();
        //TODO: 这里要改正的,-3???
        mRectF.bottom=h-3;
        mRectF.top=3;
        mRectF.left=3;
        mRectF.right=lineWidth*time-3;
    }
    public void initPaint() {
        mPaint=new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(color);
        mPaint.setAlpha(100);
    }
    public Paint getPaint() {

        return this.mPaint;
    }

    public void setFlag(int flag) {
        this.flag=flag;
    }
    public void setColor(int color) {
        this.color=color;
    }
    public void setTime(int time) {
        this.time=time;
    }
    public RectF getRectF() {
        return this.mRectF;
    }
}
