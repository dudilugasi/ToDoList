package com.example.dudilugasi.todolist;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

/**
 *  Activity that responsible for adding new task
 */
public class CreateTaskActivity extends AppCompatActivity {

    private static final String TAG = CreateTaskActivity.class.getName();

    private EditText taskEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG,"CreateTaskActivity was created");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_task);
    }


    /**
     * An method to be called when pressing the done button. the description text is received from
     * the EditText and the message is sent back to the intent
     * @param view
     */
    public void taskList(View view) {
        Log.i(TAG,"Done button was pressed");
        Intent intent = new Intent();
        EditText text = (EditText) findViewById(R.id.description);
        String taskString = text.getText().toString();
        intent.putExtra(Constants.ADD_NEW_TASK, taskString);
        setResult(RESULT_OK,intent);
        finish();
    }

}
