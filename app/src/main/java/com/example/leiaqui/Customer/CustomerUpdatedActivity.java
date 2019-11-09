package com.example.leiaqui.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leiaqui.DAO.CustomerDAO;
import com.example.leiaqui.Models.CustomerModel;
import com.example.leiaqui.R;

public class CustomerUpdatedActivity extends AppCompatActivity {

    public CustomerModel customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_updated);

        final CustomerDAO db = new CustomerDAO(getBaseContext());

        final String id = this.getIntent().getStringExtra("customerModel");

        customer = db.findCustomerById(Integer.parseInt(id));

        final EditText etUpdateName = (EditText) findViewById(R.id.etUpdateName);
        etUpdateName.setText(customer.getName());

        final EditText etUpdateEmail = (EditText) findViewById(R.id.etUpdateEmail);
        etUpdateEmail.setText(customer.getEmail());

        final EditText etUpdateCpf = (EditText) findViewById(R.id.etUpdateCpf);
        etUpdateCpf.setText(customer.getCpf());

        final EditText etUpdateCellphone = (EditText) findViewById(R.id.etUpdateCellphone);
        etUpdateCellphone.setText(customer.getCellphone());

        final EditText etUpdateAddress = (EditText) findViewById(R.id.etUpdateAddress);
        etUpdateAddress.setText(customer.getAddress());

        final EditText etUpdateBirthday = (EditText) findViewById(R.id.etUpdateBirthday);
        etUpdateBirthday.setText(customer.getBirthday());

        final EditText etUpdateCode = (EditText) findViewById(R.id.etUpdateCode);
        etUpdateCode.setText(String.valueOf(customer.getCode()));

        Button btnUpdatedCustomer = (Button)findViewById(R.id.btnUpdatedCustomer);
        Button btnDeleteCustomer = (Button)findViewById(R.id.btnDeleteCustomer);

        btnUpdatedCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerDAO customerDAO = new CustomerDAO(getBaseContext());
                CustomerModel customer = new CustomerModel();

                customer.setName(etUpdateName.getText().toString());
                customer.setEmail(etUpdateEmail.getText().toString());
                customer.setCpf(etUpdateCpf.getText().toString());
                customer.setAddress(etUpdateCellphone.getText().toString());
                customer.setCellphone(etUpdateAddress.getText().toString());
                customer.setBirthday(etUpdateBirthday.getText().toString());
                customer.setCode(Integer.parseInt(etUpdateCode.getText().toString()));

                String result;
                result = customerDAO.updatedCustomer(customer, id);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                finish();
            }
        });

        btnDeleteCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomerDAO customerDAO = new CustomerDAO(getBaseContext());

                String result = customerDAO.deleteCustomerById(id);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
