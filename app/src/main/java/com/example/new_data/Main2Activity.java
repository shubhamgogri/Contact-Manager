package com.example.new_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private TextView dets_anme;
    private  TextView dets_phone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        dets_anme = findViewById(R.id.dets_name);
        dets_phone = findViewById(R.id.dets_phone);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String name =  "Name: " + " " + bundle.getString("name");
            String phone =  "Phone Number: " + " " + bundle.getString("phone");
            dets_phone.setText(phone);
            dets_anme.setText(name);
        }

    }
}
