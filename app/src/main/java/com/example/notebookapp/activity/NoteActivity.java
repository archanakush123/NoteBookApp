package com.example.notebookapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.notebookapp.R;
import com.example.notebookapp.base.livedata.EventObject;
import com.example.notebookapp.base.ui.BaseActivity;
import com.example.notebookapp.databinding.ActivityNoteBinding;
import com.example.notebookapp.listeners.NoteActivityListener;
import com.example.notebookapp.viewmodel.NoteActivityViewModel;

public class NoteActivity extends BaseActivity<ActivityNoteBinding, NoteActivityViewModel> implements NoteActivityListener {

    public static final String TAG = NoteActivity.class.getSimpleName();

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_note;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialization();
    }

    private void initialization() {
        createViewModel(new NoteActivityViewModel(getApplication()), NoteActivityViewModel.class);
        subscribeViewModel();
    }

    private void subscribeViewModel() {
        getViewModel().getLiveDataEvent().observe(this, eventObjectLiveDataEvent -> {
            EventObject event = eventObjectLiveDataEvent.peekContent();
            if (event == null) {
                return;
            }

            Log.d(TAG, "Event receive :  " + event.getKey());

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Toast.makeText(this, "Added....", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_edit:
                Toast.makeText(this, "Edited....", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_save:
                Toast.makeText(this, "Saved....", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
