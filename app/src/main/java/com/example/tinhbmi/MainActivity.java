package com.example.tinhbmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText height,weight;
    TextView result;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//will hide the title.
        getSupportActionBar().hide(); //hide the title bar.
        setContentView(R.layout.activity_main);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        bt = findViewById(R.id.button);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean run = true;
                double bmi;
                if (String.valueOf(height.getText()).equals(""))
                {
                    Toast tx =Toast.makeText(MainActivity.this,"Chưa nhập chiều cao",Toast.LENGTH_SHORT);
                    tx.show();
                    run=false;
                }
                if (String.valueOf(weight.getText()).equals("") && run)
                {
                    Toast tx =Toast.makeText(MainActivity.this,"Chưa nhập cân nặng",Toast.LENGTH_SHORT);
                    tx.show();
                    run=false;
                }
                if (run)
                {
                    int weightkg = Integer.parseInt(String.valueOf(weight.getText()));
                    double heightm = Double.parseDouble(String.valueOf(height.getText()))/100;
                    bmi= weightkg/(heightm*heightm);
                    Bundle bundle = new Bundle();
                    bundle.putDouble("bmi",bmi);
                    Intent mh2 = new Intent(MainActivity.this,ManHinh2.class);
                    mh2.putExtra("Data",bundle);
                    startActivity(mh2);
                }
            }
        });
    }
}