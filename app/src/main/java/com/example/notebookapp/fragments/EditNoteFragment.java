package com.example.notebookapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.notebookapp.R;
import com.example.notebookapp.base.ui.BaseFragment;
import com.example.notebookapp.databinding.FragmentEditNoteBinding;
import com.example.notebookapp.listeners.NoteActivityListener;
import com.example.notebookapp.viewmodel.EditNoteViewModel;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditNoteFragment extends BaseFragment<FragmentEditNoteBinding, EditNoteViewModel> {

    private NoteActivityListener mListener;

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_edit_note;
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
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.getItem(0).setVisible(false);
        menu.getItem(1).setVisible(false);
        menu.getItem(2).setVisible(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menu_save) {
            Toast.makeText(getView().getContext(), "Saved...", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
