package com.example.notebookapp.base.manager;

import com.example.notebookapp.base.NoteApplication;
import com.example.notebookapp.base.livedata.EventObject;
import com.example.notebookapp.base.livedata.LiveDataEvent;

import androidx.lifecycle.MediatorLiveData;

/**
 * This class handle all api request and broadcast response
 */
public class DataRepository {

    private static final String TAG = DataRepository.class.getSimpleName();
    private static DataRepository mInstance;

    // Live Data Object for Broadcast
    private MediatorLiveData<LiveDataEvent<EventObject>> mBroadcastEvent;

    // Constructor
    private DataRepository() {
        mBroadcastEvent = new MediatorLiveData<>();
    }

    //Single instance
    public static synchronized DataRepository getInstance() {
        if (mInstance == null) {
            mInstance = new DataRepository();
        }
        return mInstance;
    }

    /**
     * This implementation return subscriber for Live event.
     *
     * @return
     */
    public MediatorLiveData<LiveDataEvent<EventObject>> getBroadCastEvent() {
        return mBroadcastEvent;
    }

    /**
     * This implementation post event to all subscriber
     *
     * @param event
     * @param value
     */
    public void updateBroadCastEvent(int event, Object... value) {
        NoteApplication.getInstance().getAppExecutors().mainThread().execute(() ->
                mBroadcastEvent.setValue(new LiveDataEvent(new EventObject(event, value))));
    }

    public void updateBroadCastEventPost(int event, Object... value) {
        mBroadcastEvent.postValue(new LiveDataEvent(new EventObject(event, value)));
    }
}
