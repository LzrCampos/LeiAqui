package com.example.leiaqui.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.leiaqui.DAO.CustomerDAO;
import com.example.leiaqui.Models.CustomerModel;
import com.example.leiaqui.R;

import java.util.List;

public class CustomerActivity extends AppCompatActivity {

    private ListView list;
    private static List<CustomerModel> customerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        Button btnNewCustomer = (Button) findViewById(R.id.btnNewCustomer);

        btnNewCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerActivity.this, CustomerRegisterActivity.class);
                startActivity(intent);
            }
        });

        final CustomerDAO db = new CustomerDAO(getBaseContext());

        list = (ListView) findViewById(R.id.listViewCustomer);
        customerList = db.findAllCustomer();
        ArrayAdapter<CustomerModel> adapter = new ArrayAdapter<CustomerModel>(this, android.R.layout.simple_list_item_1, customerList);
        list.setAdapter(adapter);

        list.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final CustomerModel customerModel;
                customerModel = customerList.get(position);
                Intent intent = new Intent(CustomerActivity.this, CustomerUpdatedActivity.class);
                String x = String.valueOf(customerModel.getId());
                intent.putExtra("customerModel", x);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        CustomerDAO db = new CustomerDAO(getBaseContext());
        customerList.clear();
        list.invalidateViews();

        list = (ListView) findViewById(R.id.listViewCustomer);
        customerList = db.findAllCustomer();
        ArrayAdapter<CustomerModel> adapter = new ArrayAdapter<CustomerModel>(this, android.R.layout.simple_list_item_1, customerList);
        list.setAdapter(adapter);
    }
}
