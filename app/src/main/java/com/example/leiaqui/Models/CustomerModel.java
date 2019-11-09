package com.example.leiaqui.Models;

import java.util.Date;
import java.util.jar.Attributes;

public class CustomerModel {
    private int Id;
    private String Name;
    private String Email;
    private String Cpf;
    private String Address;
    private String Cellphone;
    private String Birthday;
    private int Code;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCellphone() {
        return Cellphone;
    }

    public void setCellphone(String cellphine) {
        Cellphone = cellphine;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public int getCode() {
        return Code;
    }

    public void setCode(int code) {
        Code = code;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString(){
        return this.Name + "            " + this.Email;
    }

}
