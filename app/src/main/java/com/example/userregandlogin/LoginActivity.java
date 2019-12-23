package com.example.userregandlogin;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        setContentView(R.layout.activity_login);

        SharedPreferences preferences = getSharedPreferences("MyPreferences", MODE_PRIVATE);
        String display = preferences.getString("display", "");
        TextView displayInfo =  findViewById(R.id.infoLogged);
        displayInfo.setText(display);

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }
}
