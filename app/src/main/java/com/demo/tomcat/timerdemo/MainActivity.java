package com.demo.tomcat.timerdemo;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity
{
    private static final String TAG = MainActivity.class.getSimpleName();

    Button      btnStart, btnStop;
    TextView    tvView;
    //long        startTime;
    long        periodTime = 0L;
    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            update();
            handler.postDelayed(this, getPeriod());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initControl();

    }

    public void onClickStart(View view)
    {
        setPeriod(1000);
        handler.postDelayed(runnable, 1000*60);
    }

    public void onClickStop(View view)
    {
        handler.removeCallbacks(runnable);
    }


    //---------- User define function ----------------//
    private void initView()
    {
        tvView = findViewById(R.id.textView);
        btnStart = findViewById(R.id.button_start);
        btnStop = findViewById(R.id.button_stop);
    }

    private void initControl()
    {
        tvView.setTextColor(Color.BLACK);
        tvView.setText("");

        //startTime = System.currentTimeMillis();
        handler.removeCallbacks(runnable);
        //setPeriod(1000);
        //handler.postDelayed(runnable, 1000);

        update();
    }

    //long updateCounts = 0L;
    private void update()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd  HH:mm:ss");
        tvView.setText(sdf.format(new Date(System.currentTimeMillis())));
        //Log.i(TAG, "update(), updateCounts: " + (++updateCounts));
    }

    private long getPeriod()
    {
        return periodTime;
    }

    private void setPeriod(long period)
    {
        periodTime = period;
    }

    private void eventNotification()
    {
        NotificationManager nManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification.Builder nNotify = new NotificationCompat.Builder(this)
                .setContentTitle(this.getApplication().getPackageName())
                .setContentText(" Test Notification !!")
                .setSmallIcon(android.os.i)
    }




}


