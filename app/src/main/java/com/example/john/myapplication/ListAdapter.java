package com.example.john.myapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by john on 2018/4/1.
 */

public class ListAdapter extends BasesAdapter {

    public ListAdapter(Context context, List mList) {
        super(context, mList);
    }

    @Override
    public View myGetView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView != null) {
            viewHolder = (ViewHolder) convertView.getTag();
        } else {
            convertView = getInflateView(R.layout.list_item_layout,parent);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);

        }
        viewHolder.tv.setText(mList.get(position).toString());
        viewHolder.iv.setImageResource(R.drawable.approve_fail);
        return convertView;
    }

    static class ViewHolder {
        @BindView(R2.id.iv)
        ImageView iv;
        @BindView(R2.id.tv)
        TextView tv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}

