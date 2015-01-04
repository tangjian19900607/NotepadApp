package com.tang.note.util;

import com.alibaba.fastjson.JSON;
import com.tang.note.common.ResponseData;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by tangjian on 29/12/14.
 * <p/>
 * Email:tangjian19900607@gmail.com
 */
public class IOUtils {

    public static void write(HttpServletResponse response,ResponseData responseData) throws IOException {
        String str = JSON.toJSONString(responseData);
        PrintWriter writer = response.getWriter();
        writer.write(str);
        Logger.log("responseData:"+str.replace("\\",""));
        writer.flush();
        writer.close();
    }
}
