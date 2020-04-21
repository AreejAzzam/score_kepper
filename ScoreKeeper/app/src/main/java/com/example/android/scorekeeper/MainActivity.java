package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays the given score for Teams
     */
    public void display(int score, int id) {
        TextView scoreView = findViewById(id);
        scoreView.setText(String.valueOf(score));
    }

    int goalACount = 0;

    public void TeamAGoals(View view) {
        goalACount += 1;
        display(goalACount, R.id.team_a_score);
    }

    int goalBCount = 0;

    public void TeamBGoals(View view) {
        goalBCount += 1;
        display(goalBCount, R.id.team_B_score);
    }

    int foulsACount = 0;

    public void FoulsACount(View view) {
        foulsACount += 1;
        display(foulsACount, R.id.foulsTeamA);
    }

    int foulsBCount = 0;

    public void FoulsTeamB(View view) {
        foulsBCount += 1;
        display(foulsBCount, R.id.foulsTeamB);
    }

    /*
    * to count the number of exchange of teams
    * */
    int numOfExchangeA = 0;

    public void ExchangeTeamA(View view) {
        if (numOfExchangeA == 3)
            Toast.makeText(MainActivity.this, " can't Exchange more than 3 times", Toast.LENGTH_LONG).show();
        else {
            numOfExchangeA += 1;
            display(numOfExchangeA, R.id.ExchangeTeamA);
        }
    }

    int numOfExchangeB = 0;

    public void ExchangeTeamB(View view) {
        if (numOfExchangeB == 3)
            Toast.makeText(MainActivity.this, " can't Exchange more than 3 times", Toast.LENGTH_LONG).show();
        else {
            numOfExchangeB += 1;
            display(numOfExchangeB, R.id.ExchangeTaemB);
        }
    }

    public void reset(View view) {
        goalBCount = 0;
        goalACount = 0;
        foulsACount = 0;
        foulsBCount = 0;
        numOfExchangeA = 0;
        numOfExchangeB = 0;
        display(foulsBCount, R.id.foulsTeamB);
        display(foulsACount, R.id.foulsTeamA);

        display(goalBCount, R.id.team_B_score);
        display(goalACount, R.id.team_a_score);
        display(numOfExchangeB, R.id.ExchangeTaemB);
        display(numOfExchangeA, R.id.ExchangeTeamA);
    }

    public void TheWinnerIs(View view) {
        if (goalACount == goalBCount)
            Toast.makeText(MainActivity.this, " Tie game", Toast.LENGTH_LONG).show();
        else if (goalACount > goalBCount)
            Toast.makeText(MainActivity.this, " Team A win", Toast.LENGTH_LONG).show();
        else if (goalACount < goalBCount)
            Toast.makeText(MainActivity.this, " Team B win", Toast.LENGTH_LONG).show();
    }
}
