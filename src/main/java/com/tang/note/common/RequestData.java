package com.tang.note.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
public class RequestData implements Serializable {

    private int command;
    private String userId;
    private Map<String, String> extra = new HashMap<String, String>();

    public RequestData() {
    }

    public int getCommand() {
        return command;
    }

    public void setCommand(int command) {
        this.command = command;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map<String, String> getExtra() {
        return extra;
    }

    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
    }
}
