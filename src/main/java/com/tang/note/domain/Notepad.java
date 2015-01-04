package com.tang.note.domain;

import java.io.Serializable;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
public class Notepad implements Serializable{

    private long noteId;
    private String title;
    private String content;
    private String time;

    public Notepad() {

    }

    public Notepad(long noteId, String title, String content, String time) {
        this.noteId = noteId;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public long getNoteId() {
        return noteId;
    }

    public void setNoteId(long noteId) {
        this.noteId = noteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
