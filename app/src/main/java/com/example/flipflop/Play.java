package com.example.flipflop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Play extends AppCompatActivity implements View.OnClickListener {

    Button s11, s12, s13, s21, s22, s23, s31, s32, s33;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        s11 = (Button) findViewById(R.id.s11);
        s12 = (Button) findViewById(R.id.s12);
        s13 = (Button) findViewById(R.id.s13);

        s21 = (Button) findViewById(R.id.s21);
        s22 = (Button) findViewById(R.id.s22);
        s23 = (Button) findViewById(R.id.s23);

        s31 = (Button) findViewById(R.id.s31);
        s32 = (Button) findViewById(R.id.s32);
        s33 = (Button) findViewById(R.id.s33);

        s11.setOnClickListener(this);
        s12.setOnClickListener(this);
        s13.setOnClickListener(this);

        s21.setOnClickListener(this);
        s22.setOnClickListener(this);
        s23.setOnClickListener(this);

        s31.setOnClickListener(this);
        s32.setOnClickListener(this);
        s33.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.s11:
                s12.setText("1");
                break;
            case R.id.s12:
                s12.setText("2");
                break;
            case R.id.s13:
                s13.setText("3");
                break;

            case R.id.s21:
                s21.setText("4");
                break;
            case R.id.s22:
                s22.setText("5");
                break;
            case R.id.s23:
                s23.setText("6");
                break;

            case R.id.s31:
                s31.setText("7");
                break;
            case R.id.s32:
                s32.setText("8");
                break;
            case R.id.s33:
                s33.setText("9");
                break;
        }
    }
}
