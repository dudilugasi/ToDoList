package com.example.dudilugasi.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class TaskListActivity extends AppCompatActivity {

    private ITaskController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_list);
        controller = new TaskController();
        ListView lv = (ListView) findViewById(R.id.task_list_view);
        if (lv != null) {
            TaskListBaseAdapter adapter = new TaskListBaseAdapter(this,controller.getTasks());
            lv.setAdapter(adapter);

        }

    }

    public void addTask(View view) {
        Intent intent = new Intent(this,CreateTaskActivity.class);
        startActivity(intent);
    }
}
