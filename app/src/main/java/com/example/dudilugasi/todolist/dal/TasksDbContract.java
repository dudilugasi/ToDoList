package com.example.dudilugasi.todolist.dal;

import android.provider.BaseColumns;


public class TasksDbContract  {
    public static final class TaskEntry implements BaseColumns {
        // Table name
        public static final String TABLE_NAME = "tasks";

        public static final String COLUMN_TASK_DESCRIPTION = "task_description";

        public static final String COLUMN_TASK_DONE = "task_done";

    }
}
