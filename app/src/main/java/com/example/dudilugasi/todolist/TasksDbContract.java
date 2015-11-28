package com.example.dudilugasi.todolist;

import android.provider.BaseColumns;


public class TasksDbContract  {
    public static final class TaskEntry implements BaseColumns {
        // Table name
        public static final String TABLE_NAME = "tasks";

        public static final String COLUMN_TASK_DESCRIPTION = "task_description";

    }
}
