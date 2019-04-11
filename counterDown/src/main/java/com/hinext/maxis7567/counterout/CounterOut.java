package com.hinext.maxis7567.counterout;

import android.content.Context;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class CounterOut  {

    private TextView hour;
    private TextView minute;
    private TextView second,dot,dot1;
    private final Time time;
    private CountDownTimer countDownTimer;


    public CounterOut( View view,Time time,String color){
        hour=view.findViewById(R.id.hour);
        minute=view.findViewById(R.id.minute);
        second =view.findViewById(R.id.secend);
        dot=view.findViewById(R.id.dot);
        dot1=view.findViewById(R.id.dot1);
        hour.setTextColor(Color.parseColor(color));
        minute.setTextColor(Color.parseColor(color));
        second.setTextColor(Color.parseColor(color));
        dot.setTextColor(Color.parseColor(color));
        dot1.setTextColor(Color.parseColor(color));
        this.time = time;
    } public CounterOut( View view,Time time){
        hour=view.findViewById(R.id.hour);
        minute=view.findViewById(R.id.minute);
        second =view.findViewById(R.id.secend);
        dot=view.findViewById(R.id.dot);
        dot1=view.findViewById(R.id.dot1);

        this.time = time;
    }
    public void setCounter(long Time){
        if (Time>0){
            long counter = Time*1000;

            Timer(counter);
        }

    }
    private void Timer(long counter){
        countDownTimer=new CountDownTimer(counter, 1000) {

            public void onTick(long millisUntilFinished) {
                time.OnTick();
                hour.setText(aa(String.valueOf(String.valueOf(TimeUnit.MILLISECONDS.toHours( millisUntilFinished)))));
                minute.setText(aa(String.valueOf(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished-TimeUnit.HOURS.toMillis(TimeUnit.MILLISECONDS.toHours(millisUntilFinished))))));
                second.setText(aa(String.valueOf(TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished-TimeUnit.MINUTES.toMillis(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))))));
            }

            public void onFinish() {
                time.OnFinish();
            }

        }.start();


    }
    private String aa(String a){
        if (a.length()==1){
            String tmp="0";
            tmp=tmp.concat(a);
            return tmp;
        }else return a;
    }

    public void Reset(){
        if (countDownTimer!=null) {
            countDownTimer.cancel();
        }
    }
}
