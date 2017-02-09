package com.example.mohit.quizzer.activities;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by mohit on 08/02/17.
 */

public class QZApplication extends MultiDexApplication {

    private static Context mContext;
   // final EventBus eventBus = EventBus.getDefault();
    public static boolean isMainActivityRunning = false;

    public static Context getContext() {
        return mContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
       // eventBus.register(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
