package com.example.randy.ninehundredmonth.data;

/**
 * Created by randy on 15-3-23.
 * 放置一些关于日期的常量和标示当前时间
 */
public class Date {
    public static final int HOUR_A_DAY=24;
    private int hour;
    private int min;
    private int second;
    private int month;
    private int year;
    private int day;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}
