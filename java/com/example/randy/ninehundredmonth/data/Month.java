package com.example.randy.ninehundredmonth.data;

import android.util.Log;

import com.example.randy.ninehundredmonth.util.CalendarUtil;

/**
 * Created by randy on 15-3-22.
 */
public class Month {
    public static int JAN=1;
    public static int FEB=2;
    public static int MAR=3;
    public static int APR=4;
    public static int MAY=5;
    public static int JUNE=6;
    public static int JULY=7;
    public static int AUG=8;
    public static int SEPT=9;
    public static int OCT=10;
    public static int NOV=11;
    public static int DEC=12;
    public enum MONTH {
        JAN,FEB,MAR,APR,MAY,JUNE,JULY,AUG,SEPT,OCT,NOV,DEC
    }
    private int curMonth;
    private int firstDay;
    private int dayNum;
    public Month() {
        initData();
    }
    private void initData() {
        this.curMonth= CalendarUtil.getMonth();
        this.firstDay=CalendarUtil.getFirstDayOfMonth();
        this.dayNum=CalendarUtil.getDayNumInMonth();
        Log.i("Month","dayNum"+dayNum);
    }
    public int getCurMonth() {
        return curMonth;
    }

    public void setCurMonth(int curMonth) {
        this.curMonth = curMonth;
    }

    public int getFirstDay() {
        return firstDay;
    }

    public void setFirstDay(int firstDay) {
        this.firstDay = firstDay;
    }

    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }
}
