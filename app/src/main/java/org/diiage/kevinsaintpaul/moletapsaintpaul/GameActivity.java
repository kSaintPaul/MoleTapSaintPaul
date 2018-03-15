package org.diiage.kevinsaintpaul.moletapsaintpaul;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import Model.Score;

public class GameActivity extends AppCompatActivity {

    private Score score;

    private int nbPoint;
    private int nbTaupeManque;
    private int tempReactionMax;
    private int tempsReactionMin;
    private ImageButton currentMole;
    private Timer timer;
    private int cptTime;


    private TextView chrono;
    private ImageButton mole1;
    private ImageButton mole2;
    private ImageButton mole3;
    private ImageButton mole4;
    private ImageButton mole5;
    private ImageButton mole6;
    private ImageButton mole7;
    private ImageButton mole8;
    private ImageButton mole9;

    private ArrayList<ImageButton> listImg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Bundle extra = getIntent().getExtras();

        if(extra != null){
            score = (Score) getIntent().getSerializableExtra("score");
        }

        chrono = findViewById(R.id.txtChrono);
        mole1 = findViewById(R.id.mole1);
        mole2 = findViewById(R.id.mole2);
        mole3 = findViewById(R.id.mole3);
        mole4 = findViewById(R.id.mole4);
        mole5 = findViewById(R.id.mole5);
        mole6 = findViewById(R.id.mole6);
        mole7 = findViewById(R.id.mole7);
        mole8 = findViewById(R.id.mole8);
        mole9 = findViewById(R.id.mole9);

        listImg = new ArrayList<>();
        listImg.add(mole1);
        listImg.add(mole2);
        listImg.add(mole3);
        listImg.add(mole4);
        listImg.add(mole5);
        listImg.add(mole6);
        listImg.add(mole7);
        listImg.add(mole8);
        listImg.add(mole9);

        nbPoint = 0;

        timer = new Timer();

        startTimer();

    }

    protected void startTimer() {
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                cptTime += 1; //increase every sec
                mHandler.obtainMessage(1).sendToTarget();
                if(cptTime >= 30){
                    cancel();
                }
            }
        }, 0, 1000);
    }

    @SuppressLint("HandlerLeak")
    public Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            chrono.setText(String.valueOf(30 - cptTime));
            Random rnd = new Random();
            int position = rnd.nextInt(9 - 0 + 1) + 0;
            NewMole(position);
        }

        private void NewMole(int position) {
            ImageButton button = listImg.get(position);

            if(currentMole != button){
                if(currentMole != null) {
                    currentMole.setImageDrawable(null);
                }
                button.setImageResource(R.drawable.lilmole);
                currentMole = button;
            }
        }
    };

    public void TapMole(View view) {
        ((ImageButton) view).setImageDrawable(null);
        currentMole = null;
        nbPoint++;
    }
}
