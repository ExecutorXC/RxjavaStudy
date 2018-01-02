package com.chenxiao.rxjavastudy.rxjavastudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("chenxiao", "I think it is useful");
        Log.v("chenxiao", "This will be updated by ssl");
    }
}
