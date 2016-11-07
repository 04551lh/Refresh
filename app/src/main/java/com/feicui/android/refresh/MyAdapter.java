package com.feicui.android.refresh;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/10/10.
 */
public class MyAdapter extends BaseAdapter {

    ArrayList<String> mList;

    Context mcontext;

    public  MyAdapter(Context context, ArrayList<String> list){
        mcontext = context;
        mList = list;
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //声明ViewHolder
        MyAdapter.ViewHolder holder = null;
        if(convertView == null){
            //获取布局加载器
            LayoutInflater inflater = LayoutInflater.from(mcontext);
            convertView = inflater.inflate(R.layout.layout, null);
            holder = new MyAdapter.ViewHolder();
            holder.tv_data = (TextView)convertView.findViewById(R.id.tv_data);
            convertView.setTag(holder);
        }
        else{
            holder = (MyAdapter.ViewHolder)convertView.getTag();
        }

        holder.tv_data.setText(mList.get(position));
        return convertView;
    }

    public class ViewHolder{
        public TextView tv_data;
    }
}
