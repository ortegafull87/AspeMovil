package com.example.victordavid.aspemovil.DAO;

/**
 * Created by VictorDavid on 04/05/2016.
 */
public class DataBaseManager {
    public static final String TABLE_NAME = "usuario";

    public static final String CN_ID = "_id"; // CN : Column Name
    public static final String CN_NAME = "nombre";
    public static final String CN_USER = "usuario";
    public static final String CN_PASS = "contrasena";

/*create table usuario(
            _id integer primary key autoincrement,
            nombre text not null,
            usuario text not null,
            contrasena  text not null

    )*/
    public static final String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + " ("
        + CN_ID + " integer primary key autoincrement,"
        + CN_NAME + " text not null,"
        + CN_USER + " text not null,"
        + CN_PASS + " text);";
}
