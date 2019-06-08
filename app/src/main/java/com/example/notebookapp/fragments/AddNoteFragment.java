package com.example.notebookapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.notebookapp.R;
import com.example.notebookapp.listeners.NoteActivityListener;

public class AddNoteFragment extends Fragment {

    private NoteActivityListener mListener;

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
        View view = inflater.inflate(R.layout.fragment_add_note, container, false);
        return view;
    }
}
