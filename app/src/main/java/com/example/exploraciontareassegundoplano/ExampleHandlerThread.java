package com.example.exploraciontareassegundoplano;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;

public class ExampleHandlerThread extends Thread{

    private static final String TAG = "ExampleHandlerThread";

    Handler handler;

    @Override
    public void run(){

        Looper.prepare();
        handler = new Handler();

        Looper.loop();

//        for (int i =0; i < 5; i++){
//            Log.d(TAG, "run> " + i);
//            SystemClock.sleep(1000);
//
//        }
        Log.d(TAG, "Final de la Tarea");
    }
}
