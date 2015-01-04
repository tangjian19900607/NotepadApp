package com.tang.note.test;

import com.tang.note.dao.NoteDao;
import com.tang.note.domain.Notepad;
import com.tang.note.util.Logger;

import java.util.Date;
import java.util.List;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
public class NoteMain {
    public  static void  main(String[] args){
        NoteDao noteDao = new NoteDao();
        Notepad notepad = new Notepad();
        notepad.setNoteId(System.currentTimeMillis());
        notepad.setTitle("android design");
        notepad.setContent("Welcome to earth,I am tibby");
        notepad.setNoteId(1419829074873l);
        notepad.setTime(new Date().toLocaleString());
        noteDao.insertNote(notepad);
        List<Notepad> list =  noteDao.findAllNote();
        Logger.log(list.size()+"");
    }
}
