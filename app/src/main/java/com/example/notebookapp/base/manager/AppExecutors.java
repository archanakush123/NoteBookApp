package com.example.notebookapp.base.manager;

import android.os.Handler;
import android.os.Looper;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.annotation.NonNull;

/**
 * This class handle Executors service to handle background threads
 */
public class AppExecutors {

    private final Executor mDiskIO;
    private final Executor mNetworkIO;
    private final Executor mMainThread;

    /**
     * Constructor for pass DiskIO executor service , Network executor service and Main thread executor service.
     * @param diskIO
     * @param networkIO
     * @param mainThread
     */
    private AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        this.mDiskIO = diskIO;
        this.mNetworkIO = networkIO;
        this.mMainThread = mainThread;
    }

    //Constructor
    public AppExecutors() {
        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(5),
                new MainThreadExecutor());
    }

    /**
     * This implementation returns Disk Executor Service to handle Database operation
     * @return
     */
    public Executor diskIO() {
        return mDiskIO;
    }

    /**
     * This implementation returns Network Executor Service to handle Network operation
     * @return
     */
    public Executor networkIO() {
        return mNetworkIO;
    }

    /**
     * This implementation returns Main Executor Service to handle Main thread operation
     * @return
     */
    public Executor mainThread() {
        return mMainThread;
    }

    /**
     * executor class to send callback to main thread
     */
    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}


