package com.tang.note.controller;

import com.alibaba.fastjson.JSON;
import com.tang.note.common.ProtocolElement;
import com.tang.note.common.RequestData;
import com.tang.note.common.ResponseData;
import com.tang.note.dao.NoteDao;
import com.tang.note.domain.Notepad;
import com.tang.note.service.NoteService;
import com.tang.note.util.IOUtils;
import com.tang.note.util.Logger;
import com.tang.note.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
@WebServlet(name = "NoteServlet", value = {"/note"})
public class NoteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");
        String data = request.getParameter(ProtocolElement.REQUEST_DATA);
        Logger.log("requestData:"+data.replace("\\",""));
        if (StringUtils.isEmpty(data)) {
            ResponseData responseData = new ResponseData();
            responseData.setCode(ProtocolElement.FALIURE_CODE);
            responseData.setMessage("request data is null");
            responseData.setCommand(-1);
            IOUtils.write(response, responseData);
        } else {
            try {
                RequestData requestData = JSON.parseObject(data, RequestData.class);
                writeData(response,requestData);
            } catch (Exception e) {
                e.printStackTrace();
                Logger.log("response error");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Notepad notepad = new Notepad();
        notepad.setNoteId(System.currentTimeMillis());
        notepad.setTitle("android design");
        notepad.setContent("Welcome to earth,I am tibby");
        notepad.setTime("2014-12-29");
        NoteDao dao = new NoteDao();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        if (dao.insertNote(notepad) > 0){
            writer.write("<h1>success</h1>");
        }else {
            writer.write("<h1>faliure</h1>");
        }
        writer.flush();
        writer.close();
    }

    private void writeData(HttpServletResponse response, RequestData requestData) throws Exception {
        NoteService service = new NoteService();
        int command = requestData.getCommand();
        String note = requestData.getExtra().get(ProtocolElement.NOTEPAD);
        Notepad notepad = JSON.parseObject(note, Notepad.class);

        switch (command) {
            case 0:
                //add
                ResponseData responseData1 = service.addNotepad(notepad);
                responseData1.setCommand(0);
                IOUtils.write(response,responseData1);
                break;
            case 1:
                // delete
                ResponseData responseData2 = service.deleteNotepad(notepad.getNoteId());
                responseData2.setCommand(1);
                IOUtils.write(response,responseData2);
                break;
            case 2:
                // update
                ResponseData responseData3 = service.updateNotepad(notepad);
                responseData3.setCommand(2);
                IOUtils.write(response,responseData3);
                break;
            case 3:
                // find
                ResponseData responseData4 = service.findAllNotepad();
                responseData4.setCommand(3);
                IOUtils.write(response,responseData4);
                break;
            default:
                break;
        }
    }
}
