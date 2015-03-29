package com.example.randy.ninehundredmonth.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by randy on 15-3-22.
 *
 */
public class CalendarUtil {
    private final static int monthModify=1;



    /**
     * 获得年
     * @return
     */
    public static int getYear() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }

    /**
     * 获得月份的天数
     * @param month  0~11
     * @return
     */
    public static int getDayNumInMonth() {
        Calendar cur=Calendar.getInstance();
        return cur.getActualMaximum(Calendar.DAY_OF_MONTH);

    }

    /**
     * 获得月数
     * @return
     */
    public static int getMonth() {
        return Calendar.getInstance().get(Calendar.MONTH);
    }

    /**
     * 获得第一天的星期数
     * @return
     */
    public static int getFirstDayOfMonth() {
        Calendar cur=Calendar.getInstance();
        cur.set(Calendar.DAY_OF_MONTH,1);
        return cur.DAY_OF_WEEK;

    }

    /**
     * 获得当前时间
     * @return
     */
    public static int getHourTime() {
        Calendar cur=Calendar.getInstance();
        return cur.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 获得日期格式啊
     * @return
     */
    public static String getNowDay() {
        Date date=Calendar.getInstance().getTime();
        DateFormat dateFormat= DateFormat.getDateInstance();
        return dateFormat.format(date);
    }

    /**
     * 获得星期数
     * @return
     */
    public static int getCurDayInWeek() {
        return  Calendar.getInstance().DAY_OF_WEEK;
    }

}
