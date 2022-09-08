package com.example.tinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class ManHinh2 extends AppCompatActivity {

    Button button;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_man_hinh2);
        Intent getit = getIntent();
        Bundle getdata = getit.getBundleExtra("Data");
        double bmi = getdata.getDouble("bmi");
        button = findViewById(R.id.button2);
        result= findViewById(R.id.textView2);
        result.setText("Chỉ số BMI là : "+((double) Math.round(bmi * 100) / 100));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}