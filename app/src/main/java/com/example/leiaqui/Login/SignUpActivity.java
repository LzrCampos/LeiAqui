package com.example.leiaqui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leiaqui.DAO.CustomerDAO;
import com.example.leiaqui.DAO.UserDAO;
import com.example.leiaqui.R;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button btnNewUser = (Button)findViewById(R.id.btnRegister);

        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDAO userDAO = new UserDAO(getBaseContext());

                EditText etUser = (EditText)findViewById(R.id.etUser);
                EditText etPassword = (EditText)findViewById(R.id.etPassword);
                EditText etConfirmPassword = (EditText)findViewById(R.id.etConfirmPassword);

                String User = etUser.getText().toString();
                String Password = etPassword.getText().toString();
                String ConfirmPassword = etConfirmPassword.getText().toString();

                if(Password.equals(ConfirmPassword)){
                    String result  = userDAO.insertUser(User, Password);
                    Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "A senha e a confirmação devem ser iguais", Toast.LENGTH_LONG).show();
                    etPassword.setText("");
                    etConfirmPassword.setText("");
                }
            }
        });
    }
}
