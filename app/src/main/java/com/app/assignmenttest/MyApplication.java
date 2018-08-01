package com.app.assignmenttest;

import android.app.Application;

import com.app.assignmenttest.Observer.Manager.AppJobManager;

/**
 * Created by Devanshu on 27/7/18.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {

        super.onCreate();

        initApp();
    }
    private void initApp() {
        AppJobManager.getJobManager(this);
    }
}
