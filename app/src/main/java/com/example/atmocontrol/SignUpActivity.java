package com.example.atmocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void sign_up(View v)
    {
        Toast.makeText(getApplicationContext(),"Пользователь и устройство с такими данными уже существует, введите другие данные или авторизируйтесь!", Toast.LENGTH_SHORT).show();
        /*Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);*/
    }

    public void to_log_in(View v)
    {
        Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
        startActivity(intent);
    }
}