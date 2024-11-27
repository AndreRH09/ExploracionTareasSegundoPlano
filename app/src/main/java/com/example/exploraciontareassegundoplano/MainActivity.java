package com.example.exploraciontareassegundoplano;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.exploraciontareassegundoplano.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    private static final String TAG = "MainActivity";

    private Button btnStart;
    private Button btnStop;
    private Button btnTareaA;
    private Button btnTareaB;

    ExampleHandlerThread exampleHandlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnTareaA = findViewById(R.id.btnTareaA);
        btnTareaB = findViewById(R.id.btnTareaB);


        activityMainBinding.btnStart.setOnClickListener( view ->{
            exampleHandlerThread.start();
        });

        activityMainBinding.btnStop.setOnClickListener( view ->{

        });
        activityMainBinding.btnTareaA.setOnClickListener( view ->{
            exampleHandlerThread.handler.post(new Runnable() {
                @Override
                public void run() {
                    for (int i =0; i < 5; i++){
                        Log.d(TAG, "run> " + i);
                        SystemClock.sleep(1000);
                    }
                }
            });
        });

        activityMainBinding.btnTareaB.setOnClickListener( view ->{

        });

    }
}