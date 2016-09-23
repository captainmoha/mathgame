package com.mobile.captainmoha.math;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{


    Button play;
    Button scores;
    Button quit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        play = (Button) findViewById(R.id.play);
        scores = (Button) findViewById(R.id.scores);
        quit = (Button) findViewById(R.id.quit);

        play.setOnClickListener(this);
        scores.setOnClickListener(this);
        quit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent i = new Intent(this, GameActivity.class);
        startActivity(i);
    }
}

