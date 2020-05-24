package com.example.flipflop;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Play extends AppCompatActivity implements View.OnClickListener {

    Button s11, s12, s13, s21, s22, s23, s31, s32, s33;

    Boolean[][] board = new Boolean[][]{{true, true, true}, {false, false, false}, {true, false, true}};
    @ColorInt
    int black = Color.parseColor("#000000");
    int white = Color.parseColor("#ffffff");

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
                board[0][0] = !board[0][0];
                s11.setBackgroundColor(board[0][0] ? white : black);
                break;
            case R.id.s12:
                board[0][1] = !board[0][1];
                s12.setBackgroundColor(board[0][1] ? white : black);
                break;
            case R.id.s13:
                board[0][2] = !board[0][2];
                s13.setBackgroundColor(board[0][2] ? white : black);
                break;
            case R.id.s21:
                board[1][0] = !board[1][0];
                s21.setBackgroundColor(board[1][0] ? white : black);
                break;
            case R.id.s22:
                board[1][1] = !board[1][1];
                s22.setBackgroundColor(board[1][1] ? white : black);
                break;
            case R.id.s23:
                board[1][2] = !board[1][2];
                s23.setBackgroundColor(board[1][2] ? white : black);
                break;

            case R.id.s31:
                board[2][0] = !board[2][0];
                s31.setBackgroundColor(board[2][0] ? white : black);
                break;
            case R.id.s32:
                board[2][1] = !board[2][1];
                s32.setBackgroundColor(board[2][1] ? white : black);
                break;
            case R.id.s33:
                board[2][2] = !board[2][2];
                s33.setBackgroundColor(board[2][2] ? white : black);
                break;
        }
    }

    public void colorChange(View view, int i, int j){
    }


}
