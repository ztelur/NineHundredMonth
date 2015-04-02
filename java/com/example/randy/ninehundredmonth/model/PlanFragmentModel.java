package com.example.randy.ninehundredmonth.model;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.randy.ninehundredmonth.R;
import com.example.randy.ninehundredmonth.ui.BaseFragment;

import java.util.ArrayList;

/**
 * Created by randy on 15-4-2.
 */
public class PlanFragmentModel {
    private ArrayList<Entry> datalist;
    private LayoutInflater inflate;
    private FragmentActivity context;
    public PlanFragmentModel(BaseFragment fragment) {
        this.context=fragment.getActivity();
        this.inflate=LayoutInflater.from(context);
        datalist=new ArrayList<Entry>();
        datalist.add(new Entry("11",1));
    }
    public ActionBarDrawerToggle getmDrawerToggle(DrawerLayout drawerLayout,
                            int drawerImageRes, int openDrawerContentDescRes,
                            int closeDrawerContentDescRes) {
        return new MyDrawerToggle(context,drawerLayout,drawerImageRes,openDrawerContentDescRes,
                                                                        closeDrawerContentDescRes);
    }
    public BaseAdapter getAdapter() {
        return new DrawListAdapter();
    }
    class MyDrawerToggle extends ActionBarDrawerToggle {
        public MyDrawerToggle(Activity activity, DrawerLayout drawerLayout, int drawerImageRes, int openDrawerContentDescRes, int closeDrawerContentDescRes) {
            super(activity, drawerLayout, drawerImageRes, openDrawerContentDescRes, closeDrawerContentDescRes);
        }

        @Override
        public void onDrawerOpened(View drawerView) {
            Log.e("DrawerToogle","opened");
            super.onDrawerOpened(drawerView);
        }

        @Override
        public void onDrawerSlide(View drawerView, float slideOffset) {
            Log.e("DrawerToogle","slide");
            super.onDrawerSlide(drawerView, slideOffset);
        }

        @Override
        public void onDrawerClosed(View drawerView) {
            Log.e("DrawerToogle","closed");
            super.onDrawerClosed(drawerView);
        }
    }

    class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.e("drawer-item-click",datalist.get(position).text);
            //在这里边可以调用外层的函数
        }

    }
    class DrawListAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return datalist.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder viewHolder;
            if (convertView==null||!(convertView.getTag() instanceof ViewHolder)) {
                viewHolder=new ViewHolder();
                convertView=inflate.inflate(R.layout.drawe_list_item,null);
                viewHolder.img=(ImageView)convertView.findViewById(R.id.slidebar_item_img);
                viewHolder.textView=(TextView)convertView.findViewById(R.id.slidebar_item_text);
                convertView.setTag(viewHolder);
            } else {
                viewHolder=(ViewHolder)convertView.getTag();
            }
//            viewHolder.img.setImageDrawable();
            viewHolder.textView.setText(datalist.get(position).text);
            return convertView;
        }

        class ViewHolder {
            TextView textView;
            ImageView img;
        }
    }
    static class Entry {
        public Entry(String str,int id) {
            this.text=str;
            this.img_id=id;
        }
        String text;
        int  img_id;
    }
}
