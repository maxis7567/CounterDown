package com.hinext.maxis7567.counterdown;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hinext.maxis7567.counterout.CounterOut;
import com.hinext.maxis7567.counterout.Time;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view=findViewById(R.id.constraint);
        CounterOut counterOut=new CounterOut(view ,new Time() {
            @Override
            public void OnTick() {

            }

            @Override
            public void OnFinish() {

            }
        });
        counterOut.setCounter(500000);

    }
}
