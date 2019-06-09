package com.example.notebookapp.base.ui;

import android.app.Application;

import com.example.notebookapp.base.livedata.EventObject;
import com.example.notebookapp.base.livedata.LiveDataEvent;
import com.example.notebookapp.base.manager.DataRepository;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

/**
 * This class is BaseViewModel class.
 */
public class BaseViewModel extends AndroidViewModel {

    private LiveData<LiveDataEvent<EventObject>> mBroadcastEvent;

    // Constructor
    public BaseViewModel(Application application){
        super(application);
        // Subscribe broadcase event.
        mBroadcastEvent = DataRepository.getInstance().getBroadCastEvent();
    }

    /**
     * This implementation return Broadcast event Live data object for subscribing and observing.
     * @return
     */
    public LiveData<LiveDataEvent<EventObject>> getLiveDataEvent(){
        return mBroadcastEvent;
    }
}
