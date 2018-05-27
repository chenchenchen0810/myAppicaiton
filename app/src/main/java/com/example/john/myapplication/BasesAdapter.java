package com.example.john.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2018/4/1.
 */

public abstract class BasesAdapter<T> extends BaseAdapter {

    public Context context;
    public List<T> mList = new ArrayList<>();

    public BasesAdapter(Context context, List<T> mList) {
        this.context = context;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 :mList.size();
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
        return myGetView(position,convertView,parent);
    }

    protected View getInflateView(int resourceId,ViewGroup parent){
        return LayoutInflater.from(context).inflate(resourceId,parent,false);
    }

    public abstract View myGetView(int position, View convertView, ViewGroup parent);
}
