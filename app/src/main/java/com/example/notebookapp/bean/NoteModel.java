package com.example.notebookapp.bean;

import java.io.Serializable;

public class NoteModel implements Serializable {

    private Long noteId;
    private String noteTitle;
    private String noteDescription;
    private String noteCreatedDate;
    private String noteModifyDate;

    public NoteModel(Long noteId, String noteTitle, String noteDescription, String noteCreatedDate, String noteModifyDate) {
        this.noteId = noteId;
        this.noteTitle = noteTitle;
        this.noteDescription = noteDescription;
        this.noteCreatedDate = noteCreatedDate;
        this.noteModifyDate = noteModifyDate;
    }

    public Long getNoteId() {
        return noteId;
    }

    public void setNoteId(Long noteId) {
        this.noteId = noteId;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteDescription() {
        return noteDescription;
    }

    public void setNoteDescription(String noteDescription) {
        this.noteDescription = noteDescription;
    }

    public String getNoteCreatedDate() {
        return noteCreatedDate;
    }

    public void setNoteCreatedDate(String noteCreatedDate) {
        this.noteCreatedDate = noteCreatedDate;
    }

    public String getNoteModifyDate() {
        return noteModifyDate;
    }

    public void setNoteModifyDate(String noteModifyDate) {
        this.noteModifyDate = noteModifyDate;
    }
}
