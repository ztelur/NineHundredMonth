package com.example.randy.ninehundredmonth.model;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Matrix;
import android.util.Log;

import com.example.randy.ninehundredmonth.data.Month;
import com.example.randy.ninehundredmonth.ui.Pane;

/**
 * Created by randy on 15-3-26.
 */
public class MonthLayoutModel {
    private Context context;
    private Month month;
    private int dayIter;
    //TODO:这里的curDay应该动态获得
    private int curDay=15;
    private int curTime=9;
    //MonthLayoutModel的组件的大小
    private int height;
    private int width;
    private static final int ROW_SIZE=7;
    private static final int COL_SIZE=6;
    private int paneSize;
    public MonthLayoutModel(Context context) {
        this.context=context;
        this.month=new Month();
        this.dayIter=1;

    }
    public void setMeasure(int w,int h) {
        this.width=w;
        this.height=h;
        paneSize=figurePaneMatrix();
    }

    /**
     * 用来计算Pane的大小，而且是要保证Pane的大小必须是正方形
     * @return
     */
    private int figurePaneMatrix() {
        //一般来说宽比较小，所以按照宽来计算
        return width/ROW_SIZE;
    }
    //TODO:完善这里啊，使用30次之后呢？很多问题的啊。
    public boolean hasNext() {
        return dayIter<=ROW_SIZE*COL_SIZE;
    }
    public Pane generate() {
        Pane pane=new Pane(context);

        PaneModel paneModel;
        if (dayIter<month.getFirstDay()) {
            paneModel=new PaneModel(PaneModel.NO_USE_FLAG,
                    Color.WHITE,24);
        } else if (dayIter<curDay) {
            pane.setText(String.valueOf(dayIter));
            paneModel=new PaneModel(PaneModel.USE_FLAG,
                    Color.YELLOW,24);
        } else if (dayIter==curDay) {
            pane.setText(String.valueOf(dayIter));
            paneModel=new PaneModel(PaneModel.USE_FLAG,
                    Color.YELLOW,9);
        } else if (dayIter<=month.getDayNum()){
            pane.setText(String.valueOf(dayIter));
            paneModel=new PaneModel(PaneModel.USE_FLAG,
                    Color.YELLOW,0);
        } else {
            paneModel=new PaneModel(PaneModel.NO_USE_FLAG,
                    Color.WHITE,24);
        }

        pane.setPaneModel(paneModel);
        Log.e("MonthLayoutModel",paneSize+"");
        pane.setWidth(paneSize);
        pane.setHeight(paneSize);
        dayIter++;
        return pane;
    }

}
