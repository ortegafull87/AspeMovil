package com.example.victordavid.aspemovil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by VictorDavid on 04/05/2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME; // Nombre Base de Datos

    static {
        DB_NAME = "aspe.sqlite";
    }

    private static final int DB_SCHEME_VERSION = 1; // Version de nuestra DB

    /*public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/
    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DataBaseManager.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
