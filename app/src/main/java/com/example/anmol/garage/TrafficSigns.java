package com.example.anmol.garage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class TrafficSigns extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_signs);



    }
    public void Rules(View view)
    {
        startActivity(new Intent(TrafficSigns.this,Rules.class));
    }
}
