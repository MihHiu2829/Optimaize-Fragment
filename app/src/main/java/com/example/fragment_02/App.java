package com.example.fragment_02;

import android.app.Application;

import androidx.appcompat.app.AppCompatActivity;

public class App extends Application {
    private static App Instance ;
    private Storage storage ;
    @Override
    public void onCreate() {
        super.onCreate();
        storage = new Storage() ;
        Instance = this ;


    }

    public Storage getStorage() {
        return storage;
    }

    public static App getInstance() {
        return Instance;
    }
}
