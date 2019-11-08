package com.example.leiaqui.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.leiaqui.DBController;
import com.example.leiaqui.Models.CustomerModel;
import com.example.leiaqui.R;

public class CustomerUpdatedActivity extends AppCompatActivity {

    public CustomerModel customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_updated);

        final DBController db = new DBController(getBaseContext());

        String id = this.getIntent().getStringExtra("customerModel");

        customer = db.findCustomerById(Integer.parseInt(id));

        EditText etUpdateName = (EditText) findViewById(R.id.etUpdateName);
        etUpdateName.setText(customer.getName());

        EditText etUpdateEmail = (EditText) findViewById(R.id.etUpdateEmail);
        etUpdateEmail.setText(customer.getEmail());

        EditText etUpdateCpf = (EditText) findViewById(R.id.etUpdateCpf);
        etUpdateCpf.setText(customer.getCpf());

        EditText etUpdateCellphone = (EditText) findViewById(R.id.etUpdateCellphone);
        etUpdateCellphone.setText(customer.getCpf());

        EditText etUpdateAddress = (EditText) findViewById(R.id.etUpdateAddress);
        etUpdateAddress.setText(customer.getAddress());

        EditText etUpdateBirthday = (EditText) findViewById(R.id.etUpdateBirthday);
        etUpdateBirthday.setText(customer.getBirthday());

        EditText etUpdateCode = (EditText) findViewById(R.id.etUpdateCode);
        etUpdateCode.setText(String.valueOf(customer.getCode()));
    }
}
