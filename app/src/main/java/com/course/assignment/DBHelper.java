package com.course.assignment;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE if not exists food ("
                + "_id integer primary key autoincrement,"
                + "food_name text not null,"
                + "food_count text not null,"
                + "content text not null,"
                + "place text not null,"
                + "date text not null,"
                + "time text not null,"
                + "image blob not null);";

        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE if exists food";
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
}
