package com.example.notebookapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.notebookapp.R;
import com.example.notebookapp.listeners.NoteActivityListener;

public class NoteActivity extends AppCompatActivity implements NoteActivityListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

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
        switch (item.getItemId()){
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
