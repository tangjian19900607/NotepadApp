package com.tang.note.service;

import com.alibaba.fastjson.JSON;
import com.tang.note.common.ProtocolElement;
import com.tang.note.common.ResponseData;
import com.tang.note.dao.NoteDao;
import com.tang.note.domain.Notepad;
import com.tang.note.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
public class NoteService {
    private NoteDao notepadDao;

    public NoteService() {
        notepadDao = new NoteDao();
    }

    public ResponseData addNotepad(Notepad notepad) {
        ResponseData responseData = new ResponseData();
        if (notepad == null) {
            responseData.setCode(ProtocolElement.FALIURE_CODE);
            responseData.setMessage("notepad is null");
        } else {
            int row = notepadDao.insertNote(notepad);
            if (row > 0) {
                responseData.setCode(ProtocolElement.SUCCESS_CODE);
                responseData.setMessage("insert notepad success");
            } else {
                responseData.setCode(ProtocolElement.FALIURE_CODE);
                responseData.setMessage("failed to insert notepad");
            }
        }
        return responseData;
    }

    public ResponseData deleteNotepad(long noteId) {
        ResponseData responseData = new ResponseData();
        if (noteId == 0) {
            responseData.setCode(ProtocolElement.FALIURE_CODE);
            responseData.setMessage("noteId is null");
        } else {
            int row = notepadDao.deleteNoteById(noteId);
            if (row > 0) {
                responseData.setCode(ProtocolElement.SUCCESS_CODE);
                responseData.setMessage("delete notepad success");
            } else {
                responseData.setCode(ProtocolElement.FALIURE_CODE);
                responseData.setMessage("failed to delete notepad");
            }
        }
        return responseData;
    }

    public ResponseData updateNotepad(Notepad notepad) {
        ResponseData responseData = new ResponseData();
        int row = notepadDao.updateNote(notepad);
        if (null == notepad) {
            responseData.setCode(ProtocolElement.FALIURE_CODE);
            responseData.setMessage("notepad is null");
        } else {
            if (row > 0) {
                responseData.setCode(ProtocolElement.SUCCESS_CODE);
                responseData.setMessage("update notepad success");
            } else {
                responseData.setCode(ProtocolElement.FALIURE_CODE);
                responseData.setMessage("failed to update notepad");
            }
        }
        return responseData;
    }

    public ResponseData findAllNotepad() {
        ResponseData responseData = new ResponseData();
        List<Notepad> list = notepadDao.findAllNote();
        if (null == list) {
            list = new ArrayList<Notepad>();
        }
        responseData.getExtra().put(ProtocolElement.NOTEPAD_LIST, JSON.toJSONString(list));
        responseData.setCode(ProtocolElement.SUCCESS_CODE);
        responseData.setMessage("find all notepad success");
        return responseData;
    }

}