package com.example.randy.ninehundredmonth.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.randy.ninehundredmonth.R;
import com.example.randy.ninehundredmonth.data.Date;
import com.example.randy.ninehundredmonth.model.PaneModel;
import com.example.randy.ninehundredmonth.util.CalendarUtil;

/**
 * Created by randy on 15-3-23.
 */
public class Pane extends TextView{
    private PaneModel paneModel;
    public Pane(Context context) {
        super(context);
        this.setBackgroundDrawable(getResources().getDrawable(R.drawable.panebackground));
    }
    public void setPaneModel(PaneModel model) {
        this.paneModel=model;
    }
    public PaneModel getPaneModel() {
        return paneModel;
    }
    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        RectF rectF=paneModel.getRectF();
        Paint paint=paneModel.getPaint();
        if (canvas==null) {
            Log.e("Pane","canvas==null");
        }
        canvas.drawRect(rectF,paint);
        canvas.restore();
        super.dispatchDraw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.paneModel.initRect(w,h);
    }
}
