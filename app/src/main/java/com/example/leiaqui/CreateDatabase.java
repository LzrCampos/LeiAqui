package com.example.leiaqui;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.CaseMap;

import androidx.annotation.Nullable;

public class CreateDatabase extends SQLiteOpenHelper {

    private static final String DB_Name = "banco.db";
    private static final String Table = "USER";
    private static final String ID = "_id";
    private static final String User = "USER";
    private static final String Password = "Password";
    private static final int VERSAO = 1;

    public CreateDatabase(@Nullable Context context) {
        super(context, getUser(), null, getVERSAO());
    }

    public static String getDbName() {
        return DB_Name;
    }

    public static String getTable() {
        return Table;
    }

    public static String getID() {
        return ID;
    }

    public static String getUser() {
        return User;
    }

    public static String getPassword() {
        return Password;
    }

    public static int getVERSAO() {
        return VERSAO;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + Table + "("
                + ID + " integer primary key autoincrement,"
                + User + " TEXT,"
                + Password + " TEXT"
                + ")";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Table);
        onCreate(db);
    }
}
