package com.example.leiaqui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.leiaqui.Login.SignInActivity;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashscreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                showSignInActivity();
            }
        }, 100);
    }
    private void showMainActivity() {
        Intent intent = new Intent(
                SplashscreenActivity.this,MainActivity.class
        );
        startActivity(intent);
        finish();
    }

    private void showSignInActivity() {
        Intent intent = new Intent(
                SplashscreenActivity.this, SignInActivity.class
        );
        startActivity(intent);
        finish();
    }
}
