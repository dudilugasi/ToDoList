package com.example.dudilugasi.todolist.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.dudilugasi.todolist.common.TaskItem;

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
            TasksDbContract.TaskEntry.COLUMN_TASK_DESCRIPTION,
            TasksDbContract.TaskEntry.COLUMN_TASK_DONE};


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
    public List<TaskItem> GetUncompletedTasks() {
        SQLiteDatabase database = null;
        try {
            List<TaskItem> tasks = new ArrayList<>();
            database = dbHelper.getReadableDatabase();
            Cursor cursor = database.query(TasksDbContract.TaskEntry.TABLE_NAME,tasksColumns,
                    TasksDbContract.TaskEntry.COLUMN_TASK_DONE + " = 0",null,null,null,null);
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
            values.put(TasksDbContract.TaskEntry.COLUMN_TASK_DONE, item.isDone());
            return database.insert(TasksDbContract.TaskEntry.TABLE_NAME, null, values);
        } finally {
            if (database != null) {
                database.close();
            }
        }
    }

    @Override
    public int removeTask(TaskItem task) {
        SQLiteDatabase database = null;
        try {
            database = dbHelper.getWritableDatabase();
            if (task == null) {
                return 0;
            }
            return database.delete(TasksDbContract.TaskEntry.TABLE_NAME,
                    TasksDbContract.TaskEntry._ID + " = ?" ,new String[] {String.valueOf(task.getId())});
        } finally {
            if (database != null) {
                database.close();
            }
        }
    }

    @Override
    public int updateTask(TaskItem task) {
        SQLiteDatabase database = null;
        try {
            database = dbHelper.getWritableDatabase();
            if (task == null) {
                return 0;
            }
            ContentValues values = new ContentValues();
            values.put(TasksDbContract.TaskEntry.COLUMN_TASK_DESCRIPTION , task.getDescription());
            values.put(TasksDbContract.TaskEntry.COLUMN_TASK_DONE, task.isDone() ? 1 : 0);

            int success = database.update(TasksDbContract.TaskEntry.TABLE_NAME,
                    values,TasksDbContract.TaskEntry._ID + " = ?",
                    new String[]{String.valueOf(task.getId())});

            return success;
        }

        finally {
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
        boolean done = cursor.getInt(cursor.getColumnIndex(TasksDbContract.TaskEntry.COLUMN_TASK_DONE)) == 1;
        t.setDone(done);
        return t;
    }
}
