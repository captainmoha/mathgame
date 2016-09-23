package com.mobile.captainmoha.math;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends Activity implements View.OnClickListener{

    int correctAns;
    Button ans1;
    Button ans2;
    Button ans3;

    TextView txtObj1;
    TextView txtObj2;
    TextView txtObjScore;
    TextView txtObjLevel;

    int currScore = 0;
    int currLevel = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        txtObj1 = (TextView) findViewById(R.id.num1);
        txtObj2 = (TextView) findViewById(R.id.num2);

        txtObjScore = (TextView) findViewById(R.id.score);
        txtObjLevel = (TextView) findViewById(R.id.level);

        ans1 = (Button) findViewById(R.id.ans1);
        ans2 = (Button) findViewById(R.id.ans2);
        ans3 = (Button) findViewById(R.id.ans3);

        ans1.setOnClickListener(this);
        ans2.setOnClickListener(this);
        ans3.setOnClickListener(this);

        setQuestion();

    }

    @Override
    public void onClick(View view) {

        int userAns = 0;

        switch (view.getId()) {

            case R.id.ans1:
                userAns = Integer.parseInt("" + ans1.getText());
                break;

            case R.id.ans2:
                userAns = Integer.parseInt("" + ans2.getText());
                break;

            case R.id.ans3:
                userAns = Integer.parseInt("" +  ans3.getText());
                break;
        }

        updateScoreAndLevel(userAns);
    }

    public void setQuestion() {
        // generate the question
        int numberRange = currLevel * 3;
        Random randInt = new Random();

        int leftSide = randInt.nextInt(numberRange);
        leftSide++;

        int rightSide = randInt.nextInt(numberRange);
        rightSide++;

        correctAns = leftSide * rightSide;

        int wrongAns1 = correctAns - 2;
        int wrongAns2 = correctAns + 3;

        txtObj1.setText("" + leftSide);
        txtObj2.setText("" + rightSide);

        // a number between 0 and 2
        int buttonLayout = randInt.nextInt(3);

        switch (buttonLayout) {

            case 0:
                ans1.setText("" + correctAns);
                ans2.setText("" + wrongAns1);
                ans3.setText("" + wrongAns2);
                break;

            case 1:
                ans2.setText("" + wrongAns1);
                ans2.setText("" + correctAns);
                ans3.setText("" + wrongAns2);
                break;

            case 2:
                ans2.setText("" + wrongAns1);
                ans2.setText("" + wrongAns2);
                ans3.setText("" + correctAns);
                break;
        }

    }

    public boolean isCorrect(int answerGiven) {
        boolean correct;

        if (answerGiven == correctAns) {
            Toast.makeText(getApplicationContext(), "Well done!", Toast.LENGTH_SHORT);
            correct = true;
        }

        else {
            Toast.makeText(getApplicationContext(), "Sorry", Toast.LENGTH_SHORT);
            correct = false;
        }

        return  correct;
    }

    public void updateScoreAndLevel(int answerGiven) {

        if (isCorrect(answerGiven)) {

            for (int i = 1; i <= currLevel; i++) {
                currScore += i;
            }

            currLevel++;

        }

        else {
            currScore = 0;
            currLevel = 1;
        }


        // update text views

        txtObjScore.setText("Score: " + currScore);
        txtObjLevel.setText("Level: " + currLevel);

        setQuestion();
    }



}