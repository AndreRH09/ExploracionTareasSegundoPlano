package com.example.exploraciontareassegundoplano;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private Button btnStart, btnStop, btnTareaA, btnTareaB;
    private ExampleHandlerThread exampleHandlerThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asociar botones a las vistas del XML
        btnStart = findViewById(R.id.btnStart);
        btnStop = findViewById(R.id.btnStop);
        btnTareaA = findViewById(R.id.btnTareaA);
        btnTareaB = findViewById(R.id.btnTareaB);

        // Inicializar el HandlerThread
        exampleHandlerThread = new ExampleHandlerThread("ExampleHandlerThread");

        // Botón para iniciar el hilo
        btnStart.setOnClickListener(view -> {
            if (!exampleHandlerThread.isAlive()) {
                exampleHandlerThread.start();
                Log.d(TAG, "HandlerThread iniciado.");
            } else {
                Log.d(TAG, "HandlerThread ya estaba en ejecución.");
            }
        });

        // Botón para detener el hilo
        btnStop.setOnClickListener(view -> {
            if (exampleHandlerThread != null) {
                exampleHandlerThread.quit();
                Log.d(TAG, "HandlerThread detenido.");
            }
        });

        // Tarea A: Contar del 1 al 5
        btnTareaA.setOnClickListener(view -> {
            if (exampleHandlerThread != null && exampleHandlerThread.handler != null) {
                exampleHandlerThread.handler.post(() -> {
                    for (int i = 1; i <= 5; i++) {
                        Log.d(TAG, "Tarea A - Contando: " + i);
                        SystemClock.sleep(1000);
                    }
                    Log.d(TAG, "Tarea A completada.");
                });
            } else {
                Log.e(TAG, "HandlerThread no está inicializado o no está en ejecución.");
            }
        });

        // Tarea B: Contar de 'A' a 'E'
        btnTareaB.setOnClickListener(view -> {
            if (exampleHandlerThread != null && exampleHandlerThread.handler != null) {
                exampleHandlerThread.handler.post(() -> {
                    for (char c = 'A'; c <= 'E'; c++) {
                        Log.d(TAG, "Tarea B - Letra: " + c);
                        SystemClock.sleep(1000);
                    }
                    Log.d(TAG, "Tarea B completada.");
                });
            } else {
                Log.e(TAG, "HandlerThread no está inicializado o no está en ejecución.");
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (exampleHandlerThread != null) {
            exampleHandlerThread.quit();
        }
    }
}
