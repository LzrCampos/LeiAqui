package com.example.leiaqui;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.leiaqui.Models.CustomerModel;
import com.example.leiaqui.Models.UserModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class DBController {
    private SQLiteDatabase db;
    private CreateDatabase createDB;

    public DBController(Context context) {
        createDB = new CreateDatabase(context);
    }

    /**
     * User methods
     */
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

    /**
     * Customer methods
     */
    public String insertCustomer(CustomerModel customer) {
        ContentValues values;
        long result;
        db = createDB.getWritableDatabase();
        values = new ContentValues();
        values.put("NAME", customer.getName());
        values.put("EMAIL", customer.getEmail());
        values.put("CPF", customer.getCpf());
        values.put("ADDRESS", customer.getAddress());
        values.put("BIRTHDAY", customer.getAddress());
        values.put("CELLPHONE", customer.getBirthday());
        values.put("CODE", customer.getCode());
        result = db.insert("CUSTOMER", null, values);
        db.close();
        if (result == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    public void updatedCustomer(CustomerModel customer) {
        long result;
        db = createDB.getWritableDatabase();
        String sql = "UPDATE CUSTOMER ("
                + customer.getName() + ","
                + customer.getEmail() + ","
                + customer.getCpf() + ","
                + customer.getCellphone() + ","
                + customer.getAddress() + ","
                + customer.getBirthday() + ","
                + customer.getCode() + ")"
                + "WHERE ID = " + customer.getId() + ";";
        db.execSQL(sql);
        db.close();
    }

    public List<CustomerModel> findAllCustomer() {
        Cursor cursor;
        //String sql = "SELECT * FROM CUSTOMER";
        List<CustomerModel> listCustomer = new ArrayList<>();
        db = createDB.getReadableDatabase();
        cursor = db.query("CUSTOMER", new String[]{"ID", "NAME", "EMAIL", "CPF", "ADDRESS", "CELLPHONE", "BIRTHDAY", "CODE"}, null, null, null, null, null);
        while (cursor.moveToNext()){
            CustomerModel customer = new CustomerModel();
            customer.setId(cursor.getInt(0));
            customer.setName(cursor.getString(1));
            customer.setEmail(cursor.getString(2));
            customer.setCpf(cursor.getString(3));
            customer.setAddress(cursor.getString(4));
            customer.setCellphone(cursor.getString(5));
            customer.setBirthday(cursor.getString(6));
            customer.setCode(cursor.getInt(7));
            listCustomer.add(customer);
        }
        db.close();
        return listCustomer;
    }

    public CustomerModel findCustomerById(int id) {
        Cursor cursor;
        //String sql = "SELECT * FROM CUSTOMER";
        CustomerModel customer = new CustomerModel();
        db = createDB.getReadableDatabase();
        cursor = db.query("CUSTOMER", new String[]{"ID", "NAME", "EMAIL", "CPF", "ADDRESS", "CELLPHONE", "BIRTHDAY", "CODE"}, "ID="+id, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            customer.setId(cursor.getInt(0));
            customer.setName(cursor.getString(1));
            customer.setEmail(cursor.getString(2));
            customer.setCpf(cursor.getString(3));
            customer.setAddress(cursor.getString(4));
            customer.setCellphone(cursor.getString(5));
            customer.setBirthday(cursor.getString(6));
            customer.setCode(cursor.getInt(7));
        }
        db.close();
        return customer;
    }
}
