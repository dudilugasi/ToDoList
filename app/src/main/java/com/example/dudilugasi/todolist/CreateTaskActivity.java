package com.example.dudilugasi.todolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CreateTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
    }

    public void taskList(View view) {
        Intent intent = new Intent(this,TaskListActivity.class);
        startActivity(intent);
        finish();
    }
}
