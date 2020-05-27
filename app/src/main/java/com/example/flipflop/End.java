package com.example.flipflop;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class End extends AppCompatActivity  implements View.OnClickListener {

    Button reset, next;
    TextView yourScore, perfectScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);

        int nrMoves = getIntent().getIntExtra("Score",0);
        int perfectMoves = getIntent().getIntExtra("Perfect",0);
        int currentLevel = getIntent().getIntExtra("Current Level", 0);
        int maxLevel = getIntent().getIntExtra("Max Level", 0);


        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);

        yourScore = (TextView) findViewById(R.id.your_score);
        String result = yourScore.getText() + Integer.toString(nrMoves);
        yourScore.setText(result);

        perfectScore = (TextView) findViewById(R.id.perfect_score);
        result = perfectScore.getText() + Integer.toString(perfectMoves);
        perfectScore.setText(result);


        if(nrMoves <= perfectMoves && currentLevel < maxLevel) {
            next.setText("Next");
            findViewById(R.id.the_end).setVisibility(View.GONE);
        }
        else{
            next.setText("Reset");
            if(currentLevel >= maxLevel)
                findViewById(R.id.the_end).setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onClick(View view){
        finish();
    }
}
