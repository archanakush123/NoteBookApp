package com.example.notebookapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.notebookapp.R;
import com.example.notebookapp.adapters.NoteListAdapter;
import com.example.notebookapp.base.livedata.EventCenter;
import com.example.notebookapp.base.livedata.EventObject;
import com.example.notebookapp.base.manager.NoteManager;
import com.example.notebookapp.base.ui.BaseFragment;
import com.example.notebookapp.bean.NoteModel;
import com.example.notebookapp.databinding.FragmentNoteListBinding;
import com.example.notebookapp.listeners.NoteActivityListener;
import com.example.notebookapp.listeners.NoteItemClickListener;
import com.example.notebookapp.viewmodel.NoteListViewModel;

import java.util.ArrayList;
import java.util.List;

public class NoteListFragment extends BaseFragment<FragmentNoteListBinding, NoteListViewModel> implements NoteItemClickListener {

    public static final String TAG = NoteListFragment.class.getSimpleName();

    private NoteActivityListener mListener;

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_note_list;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (NoteActivityListener) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        return getViewDataBinding().getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setHasOptionsMenu(true);
        initialization();
    }

    private void initialization() {
        createViewModel(new NoteListViewModel(getActivity().getApplication()), NoteListViewModel.class);
        subscribeLiveData();
        getViewModel().getData();
    }

    private void subscribeLiveData() {
        getViewModel().getLiveDataEvent().observe(this, eventObjectLiveDataEvent->{
            EventObject event = eventObjectLiveDataEvent.peekContent();
            if (event == null) {
                return;
            }

            Log.d(TAG, "Event receive :  " + event.getKey());

            switch (event.getKey()){

                case EventCenter.RESPONSE_NOTE_DATA:
                    ArrayList<NoteModel> noteModelList = (ArrayList<NoteModel>) event.getValue()[0];
                    setNoteAdapter(noteModelList);
                    break;
            }
        });
    }

    private void setNoteAdapter(ArrayList<NoteModel> noteModelList) {
        if(noteModelList != null){
            NoteListAdapter noteListAdapter = new NoteListAdapter(noteModelList, this);
            getViewDataBinding().noteListRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
            getViewDataBinding().noteListRecylerView.setAdapter(noteListAdapter);
        }else{
            Toast.makeText(getView().getContext(), "List is empty", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.getItem(0).setVisible(true);
        menu.getItem(1).setVisible(false);
        menu.getItem(2).setVisible(false);
    }

    @Override
    public void onNoteClick(NoteModel noteModel) {
        NoteManager.getInstance().setNoteModel(noteModel);
        mListener.launchNoteDetailFragment();
    }
}
