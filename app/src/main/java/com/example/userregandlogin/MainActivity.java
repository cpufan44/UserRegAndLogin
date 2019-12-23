package com.example.userregandlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mUserName, mPassword;
    private Button mLogin;
    private Button mRegistration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserName = findViewById(R.id.UserNameLogin);
        mPassword = findViewById(R.id.PasswordLogin);
        mLogin = findViewById(R.id.LoginBtn);
        mRegistration = findViewById(R.id.RegBtn);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = mUserName.getText().toString();
                String passWord = mPassword.getText().toString();
                String notFound = "Username or Password is incorrect";

                SharedPreferences preferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
                String userDetails = preferences.getString(userName + ' ' + passWord + "\n", "Username or Password is incorrect");

                if (userName.isEmpty() || passWord.isEmpty()) {
                    mUserName.setHintTextColor(Color.parseColor("#ff0000"));
                    mPassword.setHintTextColor(Color.parseColor("#ff0000"));
                    Toast.makeText(MainActivity.this, "Please input username and password", Toast.LENGTH_LONG).show();
                } else if (userDetails == notFound) {
                    mUserName.setHintTextColor(Color.parseColor("#ff0000"));
                    mPassword.setHintTextColor(Color.parseColor("#ff0000"));
                    Toast.makeText(MainActivity.this, "incorrect credentials", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

        mRegistration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent regIntent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(regIntent);
            }
        });
    }
}
