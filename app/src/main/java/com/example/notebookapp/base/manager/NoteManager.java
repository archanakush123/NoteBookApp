package com.example.notebookapp.base.manager;

import com.example.notebookapp.bean.NoteModel;

public class NoteManager {

    private static NoteManager mInstance;
    private NoteModel mNoteModel;

    public static synchronized NoteManager getInstance(){
        if(mInstance == null){
            mInstance = new NoteManager();
        }
        return mInstance;
    }

    public NoteModel getNoteModel() {
        return mNoteModel;
    }

    public void setNoteModel(NoteModel mNoteModel) {
        this.mNoteModel = mNoteModel;
    }
}
