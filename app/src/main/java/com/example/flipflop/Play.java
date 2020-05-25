package com.example.flipflop;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Play extends AppCompatActivity implements View.OnClickListener {

    Button s11, s12, s13, s21, s22, s23, s31, s32, s33;
    Boolean[][] board = new Boolean[][]{{true, true, true}, {true, true, true}, {true, true, true}};

    int nrMoves;

    Button[][] neighboursBtn;
    Pair[][] neighboursBoard;


    @ColorInt
    int black = Color.parseColor("#000000");
    int white = Color.parseColor("#ffffff");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        s11 = (Button) findViewById(R.id.s11);
        s11.setBackgroundColor(board[0][0] ? black : white);

        s12 = (Button) findViewById(R.id.s12);
        s12.setBackgroundColor(board[0][1] ? black : white);

        s13 = (Button) findViewById(R.id.s13);
        s13.setBackgroundColor(board[0][2] ? black : white);

        s21 = (Button) findViewById(R.id.s21);
        s21.setBackgroundColor(board[1][0] ? black : white);

        s22 = (Button) findViewById(R.id.s22);
        s22.setBackgroundColor(board[1][1] ? black : white);

        s23 = (Button) findViewById(R.id.s23);
        s23.setBackgroundColor(board[1][2] ? black : white);

        s31 = (Button) findViewById(R.id.s31);
        s31.setBackgroundColor(board[2][0] ? black : white);

        s32 = (Button) findViewById(R.id.s32);
        s32.setBackgroundColor(board[2][1] ? black : white);

        s33 = (Button) findViewById(R.id.s33);
        s33.setBackgroundColor(board[2][2] ? black : white);

        s11.setOnClickListener(this);
        s12.setOnClickListener(this);
        s13.setOnClickListener(this);

        s21.setOnClickListener(this);
        s22.setOnClickListener(this);
        s23.setOnClickListener(this);

        s31.setOnClickListener(this);
        s32.setOnClickListener(this);
        s33.setOnClickListener(this);

        initNeighbours();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.s11:
                update_board(0);
                break;
            case R.id.s12:
                update_board(1);
                break;
            case R.id.s13:
                update_board(2);
                break;
            case R.id.s21:
                update_board(3);
                break;
            case R.id.s22:
                update_board(4);
                break;
            case R.id.s23:
                update_board(5);
                break;
            case R.id.s31:
                update_board(6);
                break;
            case R.id.s32:
                update_board(7);
                break;
            case R.id.s33:
                update_board(8);
                break;
        }

        if (check_final()) {
            finish();
        }

    }

    public void initNeighbours() {
        neighboursBtn = new Button[][]
                {
                        {s11, s12, s21},
                        {s12, s11, s13, s22},
                        {s13, s12, s23},
                        {s21, s11, s22, s31},
                        {s22, s12, s21, s23, s32},
                        {s23, s13, s22, s33},
                        {s31, s21, s32},
                        {s32, s22, s31, s33},
                        {s33, s23, s32}
                };
        neighboursBoard = new Pair[][]{
                {new Pair<>(0, 0), new Pair<>(0, 1), new Pair<>(1, 0)},
                {new Pair<>(0, 1), new Pair<>(0, 0), new Pair<>(0, 2), new Pair<>(1, 1)},
                {new Pair<>(0, 2), new Pair<>(0, 1), new Pair<>(1, 2)},
                {new Pair<>(1, 0), new Pair<>(0, 0), new Pair<>(1, 1), new Pair<>(2, 0)},
                {new Pair<>(1, 1), new Pair<>(0, 1), new Pair<>(1, 0), new Pair<>(1, 2), new Pair<>(2, 1)},
                {new Pair<>(1, 2), new Pair<>(0, 2), new Pair<>(1, 1), new Pair<>(2, 2)},
                {new Pair<>(2, 0), new Pair<>(1, 0), new Pair<>(2, 1)},
                {new Pair<>(2, 1), new Pair<>(1, 1), new Pair<>(2, 0), new Pair<>(2, 2)},
                {new Pair<>(2, 2), new Pair<>(1, 2), new Pair<>(2, 1)}
        };
    }

    public void update_board(int i) {
        for (int j = 0; j < neighboursBoard[i].length; j++) {
            int index_i = (int) neighboursBoard[i][j].first;
            int index_j = (int) neighboursBoard[i][j].second;
            board[index_i][index_j] = ! board[index_i][index_j];
            if(board[index_i][index_j])
                neighboursBtn[i][j].setBackgroundColor(black);
            else
                neighboursBtn[i][j].setBackgroundColor(white);
        }
        nrMoves++;
        TextView score = (TextView)findViewById(R.id.score);
        score.setText(Integer.toString(nrMoves));
    }

    public boolean check_final() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j])
                    return false;
            }
        }
        return true;
    }


}
