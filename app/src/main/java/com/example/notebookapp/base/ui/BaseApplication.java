package com.example.notebookapp.base.ui;


import androidx.multidex.MultiDexApplication;

import com.example.notebookapp.base.manager.AppExecutors;


/**
 * This class is base class for App Application class which added support for Multidex Application.
 */
public class BaseApplication extends MultiDexApplication {

    public static final String TAG = BaseApplication.class.getName();

    private static BaseApplication mInstance;
    private AppExecutors mAppExecutors;

    //Constructor
    protected BaseApplication() {
        mInstance = this;
    }

    public static BaseApplication getInstance() {
        if (mInstance == null) {
            mInstance = new BaseApplication();
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
