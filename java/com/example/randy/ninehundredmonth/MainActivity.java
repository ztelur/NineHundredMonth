package com.example.randy.ninehundredmonth;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.randy.ninehundredmonth.util.CalendarUtil;


public class MainActivity extends Activity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        textView=(TextView)findViewById(R.id.test1);
//        StringBuilder builder=new StringBuilder();
//        builder.append("当前年份 "+ CalendarUtil.getYear());
//        builder.append("当前月份 "+CalendarUtil.getMonth());
//        builder.append("当前月份的第一天"+CalendarUtil.getFirstDayOfMonth());
//        builder.append("当前日期："+CalendarUtil.getNowDay());
//        builder.append("当前星期几："+CalendarUtil.getCurDayInWeek());
//        textView.setText(builder.toString());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
