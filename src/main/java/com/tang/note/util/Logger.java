package com.tang.note.util;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
public class Logger {

    private static boolean isDebug = true;

    public static void log(String log) {
        if (isDebug) {
            System.out.println(log);
        }
    }
}
