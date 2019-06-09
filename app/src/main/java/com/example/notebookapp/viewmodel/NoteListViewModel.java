package com.example.notebookapp.viewmodel;

import android.app.Application;

import com.example.notebookapp.base.manager.DataRepository;
import com.example.notebookapp.base.ui.BaseViewModel;

public class NoteListViewModel extends BaseViewModel {
    public NoteListViewModel(Application application) {
        super(application);
    }

    public void getData(){
        DataRepository.getInstance().getNote();
    }
}
