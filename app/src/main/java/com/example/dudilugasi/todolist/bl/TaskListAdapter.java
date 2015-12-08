package com.example.dudilugasi.todolist.bl;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.dudilugasi.todolist.R;
import com.example.dudilugasi.todolist.common.TaskItem;
import com.example.dudilugasi.todolist.common.ToDoListException;

import java.util.List;

/**
 * TaskListAdapter
 */
public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {
    private final ITaskController controller;
    private List<TaskItem> taskItems;
    private Context context;

    public TaskListAdapter(Context context ,List<TaskItem> tasks, ITaskController controller) {
        this.taskItems = tasks;
        this.context = context;
        this.controller = controller;
    }

    @Override
    public TaskListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(context)
                .inflate(R.layout.list_view_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TaskListAdapter.ViewHolder holder, int position) {
        TaskItem item = taskItems.get(position);
        holder.mTvDescription.setText(item.getDescription());
        holder.mTvDoneButton.setOnClickListener(doneButtonOnClickListener);
        holder.mTvDoneButton.setTag(position);
    }

    private final View.OnClickListener doneButtonOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int position = (Integer) v.getTag();
            TaskItem task = taskItems.get(position);
            task.setDone(true);
            controller.updateTask(task);
            taskItems.remove(position);
            notifyItemRemoved(position);
        }
    };

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

    public void add(TaskItem task) throws ToDoListException{
        if (task == null) {
            throw new ToDoListException("error");
        }
        else {
            this.taskItems.add(task);
        }
    }

}
