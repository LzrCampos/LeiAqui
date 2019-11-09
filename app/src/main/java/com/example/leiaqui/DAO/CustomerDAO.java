package com.example.leiaqui.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.leiaqui.Models.CustomerModel;
import com.example.leiaqui.Models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class CustomerDAO {
    private SQLiteDatabase db;
    private CreateDatabase createDB;

    public CustomerDAO(Context context) {
        createDB = new CreateDatabase(context);
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
            return "Erro ao inserir novo leitor";
        else
            return "Leitor Inserido com sucesso";
    }

    public String updatedCustomer(CustomerModel customer, String id) {
        long result;
        ContentValues values;
        db = createDB.getWritableDatabase();
        values = new ContentValues();
        values.put("NAME", customer.getName());
        values.put("EMAIL", customer.getEmail());
        values.put("CPF", customer.getCpf());
        values.put("ADDRESS", customer.getAddress());
        values.put("BIRTHDAY", customer.getAddress());
        values.put("CELLPHONE", customer.getBirthday());
        values.put("CODE", customer.getCode());

        result = db.update("CUSTOMER", values, "ID = ?", new String[]{id});
        db.close();

        if (result == -1)
            return "Erro ao atualizar leitor";
        else
            return "Leitaor atualizado com sucesso";
    }

    public  String deleteCustomerById(String id){
        long result;
        db = createDB.getWritableDatabase();

        result = db.delete("CUSTOMER", "ID = ?", new String[]{id});
        db.close();

        if (result == -1)
            return "Erro ao apagar leitor";
        else
            return "Leitaor apagado com sucesso";
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
