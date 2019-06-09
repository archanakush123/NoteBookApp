package com.example.notebookapp.base.manager;

import com.example.notebookapp.NoteApplication;
import com.example.notebookapp.base.livedata.EventCenter;
import com.example.notebookapp.base.livedata.EventObject;
import com.example.notebookapp.base.livedata.LiveDataEvent;
import com.example.notebookapp.bean.NoteModel;

import androidx.lifecycle.MediatorLiveData;

import java.util.ArrayList;

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

    public void getNote(){

        NoteApplication.getInstance().getAppExecutors().networkIO().execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<NoteModel> noteModelArrayList = new ArrayList<>();
                for (int i = 0; i < 5; i++) {
                    NoteModel noteModel = new NoteModel((long) i,"Ram " +i,"Very nice boy " +i,"","");
                    noteModelArrayList.add(noteModel);
                }

                updateBroadCastEventPost(EventCenter.RESPONSE_NOTE_DATA, noteModelArrayList);
            }
        });
    }

}
