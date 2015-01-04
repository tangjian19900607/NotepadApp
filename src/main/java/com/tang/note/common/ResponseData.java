package com.tang.note.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
public class ResponseData implements Serializable {
    private String message;
    private int command;
    private int code;
    private Map<String, String> extra = new HashMap<String, String>();

    public ResponseData() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Map<String, String> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
    }
}
