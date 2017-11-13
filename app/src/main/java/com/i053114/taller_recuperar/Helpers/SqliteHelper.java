package com.i053114.taller_recuperar.Helpers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.i053114.taller_recuperar.Utilities.Constans;


/**
 * Created by chris on 13/11/2017.
 */

public class SqliteHelper extends SQLiteOpenHelper {


    public SqliteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constans.CREATE_TABLE_FOOD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ Constans.TABLA_NAME_FOOD);
        onCreate(db);
    }


}

