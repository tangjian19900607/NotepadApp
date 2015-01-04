package com.tang.note.util;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
public class StringUtils {

    public static boolean isEmpty(String string) {

        if ((null == string) || string.length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isNoteEmpty(String string){
        if ((null == string) || string.length() == 0) {
            return false;
        }
        return true;
    }
}
