package com.example.userregandlogin;

import android.app.AppComponentFactory;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText mUserName, mPassword, mPassRepeat, mEmail;
    private Button mRegister;

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_register);

        mUserName = findViewById(R.id.UserNameReg);
        mPassword = findViewById(R.id.PasswordReg);
        mPassRepeat = findViewById(R.id.RePasswordReg);
        mEmail = findViewById(R.id.EmailReg);
        mRegister = findViewById(R.id.RegisterBtn);

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
                String newUserName = mUserName.getText().toString();
                String newEmail = mEmail.getText().toString();
                String newPassword = mPassword.getText().toString();
                String newPasswordMatch = mPassRepeat.getText().toString();

                SharedPreferences.Editor editor = preferences.edit();

                if(newPassword.equals(newPasswordMatch)){
                    editor.putString(newUserName + ' ' + newPassword + "\n", newUserName +  ' ' + newEmail + "\n");
                    editor.commit();

                    Intent login = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(login);
                }
                else{
                    Toast.makeText(RegisterActivity.this, "Passwords don't match", Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }
}
