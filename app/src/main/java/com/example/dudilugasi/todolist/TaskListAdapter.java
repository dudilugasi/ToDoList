package com.example.dudilugasi.todolist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * TaskListAdapter
 */
public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {
    private final List<TaskItem> taskItems;

    public TaskListAdapter(List<TaskItem> tasks) {
        this.taskItems = tasks;
    }

    @Override
    public TaskListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_view_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TaskListAdapter.ViewHolder holder, int position) {
        TaskItem item = taskItems.get(position);
        holder.mTvDescription.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return taskItems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        //Each item is a view in the card.
        private TextView mTvDescription;
        private Button mTvDoneButton;
        public ViewHolder(View parentView) {
            super(parentView);
            mTvDescription = (TextView) parentView.findViewById(R.id.textView_description);
            mTvDoneButton = (Button) parentView.findViewById(R.id.button_done);
        }
    }

}
