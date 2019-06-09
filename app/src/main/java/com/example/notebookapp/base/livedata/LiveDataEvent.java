package com.example.notebookapp.base.livedata;

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
public class LiveDataEvent<T> {

    private boolean hasBeenHandled = false;
    private T content;


   public LiveDataEvent(T content){
       this.content = content;
   }


    /**
     * Returns the content and prevents its use again.
     */
    public T getContentIfNotHandled() {
         if (hasBeenHandled) {
           return null;
        }
        hasBeenHandled = true;
         return content;
    }


    /**
     * Returns the content, even if it's already been handled.
     */
    public T peekContent() {
       return content;
    }
}