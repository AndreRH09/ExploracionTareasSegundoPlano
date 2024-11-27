package com.example.exploraciontareassegundoplano;

import android.os.Handler;
import android.os.HandlerThread;

public class ExampleHandlerThread extends HandlerThread {

    public Handler handler;

    public ExampleHandlerThread(String name) {
        super(name);
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        handler = new Handler(getLooper()); // Asigna un Handler al Looper
    }

    @Override
    public boolean quit() {
        if (getLooper() != null) {
            getLooper().quitSafely(); // Finaliza el Looper de forma segura
        }
        return true;
    }
}
