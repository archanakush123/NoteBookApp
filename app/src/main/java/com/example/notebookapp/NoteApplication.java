package com.example.notebookapp;

import com.example.notebookapp.base.ui.BaseApplication;

public class NoteApplication extends BaseApplication {

    private static NoteApplication mInstance;

    public NoteApplication() {
        mInstance = this;
    }

    public static  NoteApplication getInstance() {
        if(mInstance == null) {
            mInstance = new NoteApplication();
        }
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
