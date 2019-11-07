package com.example.leiaqui.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.leiaqui.MainActivity;
import com.example.leiaqui.R;

public class CustomerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        Button btnNewCustomer = (Button)findViewById(R.id.btnNewCustomer);

        btnNewCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerActivity.this, CustomerRegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}
