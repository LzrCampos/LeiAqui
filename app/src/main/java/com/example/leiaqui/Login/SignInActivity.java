package com.example.leiaqui.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leiaqui.CreateDatabase;
import com.example.leiaqui.DBController;
import com.example.leiaqui.MainActivity;
import com.example.leiaqui.R;

public class SignInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        Button btnLogin = (Button)findViewById(R.id.btnSignIn);
        Button btnRegister = (Button)findViewById(R.id.btnSignUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etUser = (EditText)findViewById(R.id.etLoginUser);
                EditText etPassword = (EditText)findViewById(R.id.etLoginPassword);

                String user = etUser.getText().toString();
                String password = etPassword.getText().toString();

                DBController crud = new DBController(getBaseContext());
                UserModel userModel = crud.findUserByName(user, password);
                if(userModel!=null){
                    String dbUser = userModel.getUser();
                    String dbPassword = userModel.getPassword();

                    if(verifyUserCredentials(dbUser, dbPassword, dbUser, dbPassword)) {
                        Intent intent = new Intent(
                                SignInActivity.this, MainActivity.class
                        );
                        startActivity(intent);
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Usuario ou senha incorretos!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        SignInActivity.this, SignUpActivity.class
                );
                startActivity(intent);
            }
        });
    }

    private boolean verifyUserCredentials(String user, String password, String cUser, String cPassword){
        Toast.makeText(getApplicationContext(),cUser, Toast.LENGTH_SHORT).show();
        if(user.equals(cUser) && password.equals(cPassword)){
            return false;
        }
        return false;
    }
}
