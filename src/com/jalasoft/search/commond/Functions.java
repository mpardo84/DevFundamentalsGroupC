package com.jalasoft.search.commond;

import java.io.PrintWriter;
import java.io.StringWriter;

public class Functions {

    public static String getStackTrace(Exception e) {
        StringWriter sWriter = new StringWriter();
        PrintWriter pWriter = new PrintWriter(sWriter);
        e.printStackTrace(pWriter);
        return sWriter.toString();
    }
}
