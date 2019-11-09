package com.example.leiaqui.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.leiaqui.Models.UserModel;

public class UserDAO {
    private SQLiteDatabase db;
    private CreateDatabase createDB;

    public UserDAO(Context context) {
        createDB = new CreateDatabase(context);
    }

    public String insertUser(String user, String password) {
        ContentValues values;
        long resultado;
        db = createDB.getWritableDatabase();
        values = new ContentValues();
        values.put(CreateDatabase.getUser(), user);
        values.put(CreateDatabase.getPassword(), password);
        resultado = db.insert(CreateDatabase.getTable(), null, values);
        db.close();
        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public Cursor loadData() {
        Cursor cursor;
        String[] fields = {CreateDatabase.getID(), CreateDatabase.getUser(), CreateDatabase.getPassword()};
        db = createDB.getReadableDatabase();
        cursor = db.query(CreateDatabase.getTable(), fields, null, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Boolean verifyUserCredentials(String user, String password) {
        Cursor cursor;
        try {
            String sql = "SELECT * FROM USER WHERE User = '" + user + "' and password = '" + password + "'";
            db = createDB.getReadableDatabase();
            cursor = db.rawQuery(sql, null);
            if (cursor != null) {
                final UserModel userModel = new UserModel();
                cursor.moveToFirst();
                userModel.setUser(cursor.getString(1).toString());
                userModel.setPassword(cursor.getString(2).toString());
                db.close();
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            return false;
        }
    }
}
