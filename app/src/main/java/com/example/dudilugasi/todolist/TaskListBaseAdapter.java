package com.example.dudilugasi.todolist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by dudilugasi on 10/29/15.
 */
public class TaskListBaseAdapter extends BaseAdapter {

    private Context context;
    private List<TaskItem> items;

    static class ViewHolder {
        TextView tv_description;
        Button tv_done;
    }

    public TaskListBaseAdapter(Context context, List<TaskItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        if (this.items != null && items.size() > position)
            return this.items.get(position);
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item,null);
            holder = new ViewHolder();
            holder.tv_description = (TextView) convertView.findViewById(R.id.textView_description);
            holder.tv_done = (Button) convertView.findViewById(R.id.button_done);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tv_description.setText(items.get(position).getDescription());
        return convertView;
    }
}



















