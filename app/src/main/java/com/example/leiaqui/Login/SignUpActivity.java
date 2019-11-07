package com.example.leiaqui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leiaqui.DBController;
import com.example.leiaqui.R;
import com.example.leiaqui.SplashscreenActivity;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button btnNewUser = (Button)findViewById(R.id.btnRegister);

        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBController dbController = new DBController(getBaseContext());

                EditText etUser = (EditText)findViewById(R.id.etUser);
                EditText etPassword = (EditText)findViewById(R.id.etPassword);
                EditText etConfirmPassword = (EditText)findViewById(R.id.etConfirmPassword);

                String User = etUser.getText().toString();
                String Password = etPassword.getText().toString();
                String ConfirmPassword = etConfirmPassword.getText().toString();

                String result;

                result = dbController.insertData(User, Password);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();

                showSignInActivity();
            }
        });
    }

    private void showSignInActivity() {
        Intent intent = new Intent(
                SignUpActivity.this, SignInActivity.class
        );
        startActivity(intent);
        finish();
    }
}
