package com.example.atmocontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new CountDownTimer(6000, 3000)
        {
            @Override
            public void onTick (long l)
            {

            }
            public void onFinish()
            {
                String url = "http://api.blueberry.gq/check_conn.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(StartActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StartActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    public Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> value = new HashMap<String, String>();
                        value.put("checking", "query");
                        return value;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(StartActivity.this);
                requestQueue.add(stringRequest);
                Intent intent = new Intent(StartActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        }.start();
    }
}