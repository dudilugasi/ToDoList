package com.example.dudilugasi.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * MockDao responsible for storing , getting and adding for a list of tasks
 */
public class DAO implements IDataAccess {

    private static DAO instance;
    private Context context;
    private TasksDbHelper dbHelper;
    private String[] tasksColumns = { TasksDbContract.TaskEntry._ID,
            TasksDbContract.TaskEntry.COLUMN_TASK_DESCRIPTION};


    private DAO(Context context) {
        this.context = context;
        dbHelper = new TasksDbHelper(this.context);
    }
    public static DAO getInstance(Context applicationContext)
    {
        if(instance ==  null)
            instance = new DAO(applicationContext);
        return instance;
    }

    @Override
    public List<TaskItem> GetTasks() {
        SQLiteDatabase database = null;
        try {
            List<TaskItem> tasks = new ArrayList<>();
            database = dbHelper.getReadableDatabase();
            Cursor cursor = database.query(TasksDbContract.TaskEntry.TABLE_NAME,tasksColumns,
                    null,null,null,null,null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                TaskItem t = cursorToTask(cursor);
                tasks.add(t);
                cursor.moveToNext();
            }

            cursor.close();
            return tasks;
        } finally {
            if (database != null) {
                database.close();
            }
        }
    }

    @Override
    public long addTask(TaskItem item) {
        SQLiteDatabase database = null;
        try {
            database = dbHelper.getReadableDatabase();
            if (item == null) {
                return 0;
            }
            ContentValues values = new ContentValues();
            values.put(TasksDbContract.TaskEntry.COLUMN_TASK_DESCRIPTION, item.getDescription());
            return database.insert(TasksDbContract.TaskEntry.TABLE_NAME, null, values);
        } finally {
            if (database != null) {
                database.close();
            }
        }
    }

    private TaskItem cursorToTask(Cursor cursor) {
        TaskItem t = new TaskItem();
        t.setId(cursor.getInt(cursor.getColumnIndex(TasksDbContract.TaskEntry._ID)));
        t.setDescription(cursor.getString(cursor
                .getColumnIndex(TasksDbContract.TaskEntry.COLUMN_TASK_DESCRIPTION)));
        return t;
    }
}
