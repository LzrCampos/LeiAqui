package com.example.leiaqui.DAO;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.icu.text.CaseMap;

import androidx.annotation.Nullable;

public class CreateDatabase extends SQLiteOpenHelper {

    private static final String DB_Name = "DB_LIBARY";
    private static final String Table = "USER";
    private static final String ID = "_id";
    private static final String User = "USER";
    private static final String Password = "Password";
    private static final int VERSAO = 1;

    public CreateDatabase(@Nullable Context context) {
        super(context, getDbName(), null, getVERSAO());
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

    public void createTableUser(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + Table + "("
                + ID + " integer primary key autoincrement,"
                + User + " TEXT,"
                + Password + " TEXT"
                + ")";

        db.execSQL(sql);
    }

    public void createTableCustomer(SQLiteDatabase db) {
        String sql = "create table CUSTOMER (ID integer primary key autoincrement, NAME TEXT, EMAIL TEXT, CPF TEXT, ADDRESS TEXT, CELLPHONE TEXT, BIRTHDAY TEXT, CODE INTEGER)";

        db.execSQL(sql);
    }
    public void createTableBook(SQLiteDatabase db) {
        String sql = "CREATE TABLE BOOK (ID integer primary key autoincrement, ISBN TEXT, TITLE TEXT, CATEGORY INTEGER, AUTHOR TEXT, KEYPHRASE TEXT, PDATE DATE, EDITION INTEGER, PUBLISHER TEXT, NPAGES INTEGER)";

        db.execSQL(sql);
    }

    public void createTableReaderCategory(SQLiteDatabase db) {
        String sql = "CREATE TABLE READERCATEGORY (ID integer primary key autoincrement, DESCRIPTION TEXT, NUMDAYS INTEGER)";

        db.execSQL(sql);
    }

    public void createTableBookCategory(SQLiteDatabase db) {
        String sql = "CREATE TABLE BOOKCATEGORY (ID integer primary key autoincrement, DESCRIPTION TEXT, NUMDAYS INTEGER, RATE INTEGER)";

        db.execSQL(sql);
    }

    public void updateTableUser(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS USER");
    }
    public void updateTableCustomer(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS CUSTOMER");
    }
    public void updateTableBook(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS BOOK");
    }

    public void updateTableReaderCategory(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS READERCATEGORY");
    }

    public void updateTableBookCategory(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS BOOKCATEGORY");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableUser(db);
        createTableBookCategory(db);
        createTableBook(db);
        createTableReaderCategory(db);
        createTableCustomer(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        updateTableUser(db);
        updateTableBookCategory(db);
        updateTableReaderCategory(db);
        updateTableCustomer(db);
        onCreate(db);
    }
}
