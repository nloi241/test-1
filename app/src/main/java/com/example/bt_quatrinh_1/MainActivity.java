package com.example.bt_quatrinh_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button Linerlayout;
Button Relativelayout;
Button Tablelayout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Linerlayout = (Button) findViewById(R.id.bt1);
        Relativelayout = (Button) findViewById(R.id.bt2);
        Tablelayout = (Button) findViewById(R.id.bt3);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.bt1:
                        Intent intent =  new Intent(MainActivity.this,Main2.class);
                        startActivity(intent);
                        break;
                    case R.id.bt2:
                        Intent intent1 =  new Intent(MainActivity.this,Main3.class);
                        startActivity(intent1);
                    case R.id.bt3:
                        Intent intent2 =  new Intent(MainActivity.this,Main4.class);
                        startActivity(intent2);
                }
            }
        };
        Linerlayout.setOnClickListener(onClickListener);
        Relativelayout.setOnClickListener(onClickListener);
        Tablelayout.setOnClickListener(onClickListener);



    }}


