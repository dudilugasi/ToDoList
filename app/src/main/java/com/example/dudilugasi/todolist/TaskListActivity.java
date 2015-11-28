package com.example.dudilugasi.todolist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.List;

/**
 *  Activity which shows all the current tasks and the button to add new task
 */
public class TaskListActivity extends AppCompatActivity {


    private static final String TAG = TaskListActivity.class.getName();
    private ITaskController controller;
    private RecyclerView mRecyclerView;
    private TaskListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        controller = new TaskController(this);
        mRecyclerView = (RecyclerView) findViewById(R.id.task_list_view);
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        mAdapter = new TaskListAdapter(this,controller.getTasks());
        mRecyclerView.setAdapter(mAdapter);
    }

    /**
     * If the activity returned with result the request code is checked.
     * In case the code is for creating new task, A new task is created and added by the controller.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Constants.REQUEST_CODE_ADD_TASK && resultCode == Activity.RESULT_OK) {
            String description = data.getStringExtra(Constants.ADD_NEW_TASK);
            if (description != null) {
                controller.addTask(new TaskItem(description));
                try {
                    mAdapter.updateDataSource(controller.getTasks());
                }
                catch (Exception e) {
                    Toast.makeText(this, e.getMessage() , Toast.LENGTH_SHORT).show();
                }
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * When pressing the ADD TASK button, activity is started for result to get the new task
     * @param view
     */
    public void addTask(View view) {
        Log.i(TAG, "addTask was called");
        Intent intent = new Intent(this, CreateTaskActivity.class);
        startActivityForResult(intent, Constants.REQUEST_CODE_ADD_TASK);
    }
}
