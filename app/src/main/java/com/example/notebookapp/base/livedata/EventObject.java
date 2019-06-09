package com.example.notebookapp.base.livedata;

/**
 * This class is wrapper for data with event using Live Data
 */
public class EventObject {

    private int key;
    private Object[] value;

    //Constructor
    public EventObject(int key, Object... value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Get key for Event
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     * Get Value associated with Broadcast Event.
     * @return
     */
    public Object[] getValue() {
        return value;
    }
}
