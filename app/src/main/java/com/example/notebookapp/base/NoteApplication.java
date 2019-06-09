package com.example.notebookapp.base;


import com.example.notebookapp.base.manager.AppExecutors;

import androidx.multidex.MultiDexApplication;

/**
 * This class is base class for App Application class which added support for Multidex Application.
 */
public class NoteApplication extends MultiDexApplication {

    public static final String TAG = NoteApplication.class.getName();

    private static NoteApplication mInstance;
    private AppExecutors mAppExecutors;

    //Constructor
    protected NoteApplication() {
        mInstance = this;

    }

    public static NoteApplication getInstance() {
        if (mInstance == null) {
            mInstance = new NoteApplication();
        }
        return mInstance;
    }


    @Override
    public void onCreate() {
        super.onCreate();
    }


    /**
     * This implementation create AppExecutor instance If already not created and return.
     *
     * @return
     */
    public AppExecutors getAppExecutors() {
        if (mAppExecutors == null) {
            mAppExecutors = new AppExecutors();
        }
        return mAppExecutors;
    }
}
