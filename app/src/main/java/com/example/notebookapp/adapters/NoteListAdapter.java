package com.example.notebookapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notebookapp.R;
import com.example.notebookapp.bean.NoteModel;
import com.example.notebookapp.databinding.ItemsNoteBinding;
import com.example.notebookapp.listeners.NoteItemClickListener;

import java.util.List;

public class NoteListAdapter extends RecyclerView.Adapter<NoteListAdapter.NoteViewHolder> {

    private List<NoteModel> mNoteModelList;
    private NoteItemClickListener mListener;

    public NoteListAdapter(List<NoteModel> mNoteModelList, NoteItemClickListener mListener) {
        this.mNoteModelList = mNoteModelList;
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemsNoteBinding itemsNoteBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getRootView().getContext()), R.layout.items_note, parent, false);
        return new NoteViewHolder(itemsNoteBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        NoteModel noteModel = mNoteModelList.get(position);
        holder.itemsNoteBinding.noteTitle.setText(noteModel.getNoteTitle());
        holder.itemsNoteBinding.noteDescription.setText(noteModel.getNoteDescription());
        holder.itemsNoteBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return mNoteModelList.size();
    }

    public class NoteViewHolder extends RecyclerView.ViewHolder {
        public ItemsNoteBinding itemsNoteBinding;
        public NoteViewHolder(@NonNull ItemsNoteBinding binding) {
            super(binding.getRoot());
            itemsNoteBinding = binding;
            bindView(binding);
        }

        private void bindView(ItemsNoteBinding binding) {
            binding.rootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onNoteClick(mNoteModelList.get(getAdapterPosition()));
                }
            });
        }
    }
}
