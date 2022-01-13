package com.example.android.court_counter;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.NumberFormat;

class TestSleepMethod1 extends Thread{
    public void run(){
        try{Thread.sleep(500000);}catch(InterruptedException e){System.out.println(e);}
    }

}
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    static int TeamA_points=0;
    static int TeamB_points=0;
    public void displayPoints()
    {
        TextView textViewShow=(TextView) findViewById(R.id.teamA_points_text_view);
        textViewShow.setText(NumberFormat.getNumberInstance().format(TeamA_points));
        TextView textViewShow1=(TextView) findViewById(R.id.teamB_points_text_view);
        textViewShow1.setText(NumberFormat.getNumberInstance().format(TeamB_points));
    }
    public void Reset(View view)
    {
        this.TeamA_points=0;
        this.TeamB_points=0;
        displayPoints();
        TextView textViewShow=(TextView) findViewById(R.id.deciderA_shower);
        TextView textViewShow1=(TextView) findViewById(R.id.deciderB_shower);
        textViewShow.setText("Points");
        textViewShow1.setText("Points");
    }
    public void Decider(View view)
    {
        if(TeamA_points>TeamB_points)
        {
            TextView textViewShow=(TextView) findViewById(R.id.deciderA_shower);
            TextView textViewShow1=(TextView) findViewById(R.id.deciderB_shower);
            textViewShow.setText("Winner");
            textViewShow1.setText("Loser");
            displayPoints();
            this.TeamA_points=0;
            this.TeamB_points=0;

        }
        else if(TeamA_points<TeamB_points)
        {
            TextView textViewShow=(TextView) findViewById(R.id.deciderA_shower);
            TextView textViewShow1=(TextView) findViewById(R.id.deciderB_shower);
            textViewShow1.setText("Winner");
            textViewShow.setText("Loser");
            displayPoints();
            this.TeamA_points=0;
            this.TeamB_points=0;
        }
        else
        {
            TextView textViewShow=(TextView) findViewById(R.id.header_id);
            textViewShow.setText("Match Drawn");

            TestSleepMethod1 t1=new TestSleepMethod1();
            t1.start();

            TextView textViewShow1=(TextView) findViewById(R.id.header_id);
            textViewShow1.setText("Court Counter");
        }
    }
    public void teamA_HighInc(View view)
    {
        TeamA_points+=3;
        displayPoints();
    }
    public void teamA_MidInc(View view)
    {
        TeamA_points+=2;
        displayPoints();
    }
    public void teamA_LowInc(View view)
    {
        TeamA_points+=1;
        displayPoints();
    }
    public void teamB_HighInc(View view)
    {
        TeamB_points+=3;
        displayPoints();
    }
    public void teamB_MidInc(View view)
    {
        TeamB_points+=2;
        displayPoints();
    }
    public void teamB_LowInc(View view)
    {
        TeamB_points+=1;
        displayPoints();
    }



}