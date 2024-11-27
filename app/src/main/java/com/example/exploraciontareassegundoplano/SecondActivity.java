package com.example.exploraciontareassegundoplano;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SecondActivity extends AppCompatActivity {

    private static final String TAG = "SecondActivity";
    private Button btnStartTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btnStartTask = findViewById(R.id.btnStartTask);

        // Configurar el botón para iniciar la tarea en segundo plano
        btnStartTask.setOnClickListener(view -> startBackgroundTask());
    }

    // Método para iniciar la tarea en segundo plano
    private void startBackgroundTask() {
        // Crear un ExecutorService para manejar la tarea en segundo plano
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Ejecutar la tarea en segundo plano
        executorService.execute(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    Thread.sleep(1000); // Simulando trabajo en segundo plano
                    Log.d(TAG, "Tarea en segundo plano - Contando: " + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Log.d(TAG, "Tarea en segundo plano completada.");
        });
    }
}
