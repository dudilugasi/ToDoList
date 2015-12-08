package com.example.dudilugasi.todolist.dal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TasksDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "tasks.db";

    public TasksDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_LOCATION_TABLE = "CREATE TABLE "
                + TasksDbContract.TaskEntry.TABLE_NAME + " (" + TasksDbContract.TaskEntry._ID
                + " INTEGER PRIMARY KEY," + TasksDbContract.TaskEntry.COLUMN_TASK_DESCRIPTION
                + " TEXT NOT NULL, " + TasksDbContract.TaskEntry.COLUMN_TASK_DONE + " INT DEFAULT 0 NOT NULL)";
        db.execSQL(SQL_CREATE_LOCATION_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
