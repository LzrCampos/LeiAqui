package com.example.leiaqui.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leiaqui.DBController;
import com.example.leiaqui.Models.CustomerModel;
import com.example.leiaqui.R;

public class CustomerRegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_register);

        Button btnNewCustomer = (Button)findViewById(R.id.btnRegisterCustomer);

        btnNewCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBController dbController = new DBController(getBaseContext());
                CustomerModel customer = new CustomerModel();

                EditText etName = (EditText)findViewById(R.id.etName);
                EditText etEmail = (EditText)findViewById(R.id.etEmail);
                EditText etCpf = (EditText)findViewById(R.id.etCpf);
                EditText etCellphone = (EditText)findViewById(R.id.etCellphone);
                EditText etAddress = (EditText)findViewById(R.id.etAddress);
                EditText etBirthday = (EditText)findViewById(R.id.etBirthday);
                EditText etCode = (EditText)findViewById(R.id.etCode);

                customer.setName(etName.getText().toString());
                customer.setEmail(etEmail.getText().toString());
                customer.setCpf(etCpf.getText().toString());
                customer.setAddress(etCellphone.getText().toString());
                customer.setCellphone(etAddress.getText().toString());
                customer.setBirthday(etBirthday.getText().toString());
                customer.setCode(Integer.parseInt(etCode.getText().toString()));

                String result;
                result = dbController.insertCustomer(customer);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

                finish();

            }
        });
    }
}
