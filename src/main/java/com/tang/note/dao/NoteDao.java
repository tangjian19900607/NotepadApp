package com.tang.note.dao;

import com.tang.note.db.DBManager;
import com.tang.note.domain.Notepad;
import com.tang.note.util.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
public class NoteDao {

    /**
     * add notepad
     *
     * @param notepad
     * @return
     */
    public int insertNote(Notepad notepad) {
        int row = 0;
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "insert INTO NOTEPAD (noteId,title,content,time) VALUES (?,?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, notepad.getNoteId());
            preparedStatement.setString(2, notepad.getTitle());
            preparedStatement.setString(3, notepad.getContent());
            preparedStatement.setString(4,notepad.getTime());
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.log("insert into notepad error");
            e.printStackTrace();
        }
        return row;
    }

    /**
     * update notepad
     *
     * @param notepad
     * @return
     */
    public int updateNote(Notepad notepad) {
        int row = 0;
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "UPDATE NOTEPAD SET title = ?,content = ?,time = ? WHERE noteId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, notepad.getTitle());
            preparedStatement.setString(2, notepad.getContent());
            preparedStatement.setString(3,notepad.getTime());
            preparedStatement.setLong(4, notepad.getNoteId());
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.log("update notepad error");
            e.printStackTrace();
        }
        return row;
    }

    /**
     * delete a note
     *
     * @param noteId
     * @return
     */
    public int deleteNoteById(long noteId) {
        int row = 0;
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM NOTEPAD WHERE noteId = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, noteId);
            row = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.log("delete notepad error");
            e.printStackTrace();
        }
        return row;
    }

    /**
     * findAll note
     *
     * @return
     */
    public List<Notepad> findAllNote() {
        ArrayList<Notepad> list = new ArrayList<Notepad>();
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        String sql = "select * from notepad";
        try {
            preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Notepad notepad = new Notepad();
                notepad.setNoteId(resultSet.getLong("noteId"));
                notepad.setTitle(resultSet.getString("title"));
                notepad.setContent(resultSet.getString("content"));
                notepad.setTime(resultSet.getString("time"));
                list.add(notepad);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            Logger.log("find all notepad error");
            e.printStackTrace();
        }
        return list;
    }

}
