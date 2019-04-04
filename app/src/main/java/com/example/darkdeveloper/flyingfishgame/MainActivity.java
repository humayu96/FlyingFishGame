package com.example.darkdeveloper.flyingfishgame;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    public FlyingFishClass flyingFishClass;
    private Handler handler = new Handler();
    private final static long Interval = 30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();

        flyingFishClass = new FlyingFishClass(this);
        setContentView(flyingFishClass);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        flyingFishClass.invalidate();
                    }
                });
            }
        },0,Interval);

    }
}
