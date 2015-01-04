package com.tang.note.db;

import com.tang.note.common.DBConstant;
import com.tang.note.util.Logger;

import java.sql.*;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
public final class DBManager {
    private static Connection mConnection = null;

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            mConnection = DriverManager.getConnection(DBConstant.URL, DBConstant.USER_NAME, DBConstant.USER_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            Logger.log("obtain connection error");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            Logger.log("driver load error");
        } finally {
            Logger.log("obtain connection");
        }
        return mConnection;
    }

    public static void closeConnection(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
        try {
            if (null != resultSet) {
                resultSet.close();
            }
            if (null != preparedStatement) {
                preparedStatement.close();
            }
            if (null != connection) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Logger.log("close connection error");
        } finally {
            Logger.log("close connection");
        }

    }
}

