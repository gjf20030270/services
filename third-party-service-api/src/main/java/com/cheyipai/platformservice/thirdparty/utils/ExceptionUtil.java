/**
 * Project Name:promotionplatform-o2o-provider
 * File Name:ExceptionUtil.java
 * Package Name:com.msds.platformservice.promotionplatform.o2o.promotion
 * Date:2015-4-16下午1:53:42
 */

package com.cheyipai.platformservice.thirdparty.utils;

import java.io.File;

/**
 * add by jiamingku 2017-3-9
 */
public class ExceptionUtil {

    /**
     * The system separator character.
     */
    private static final char SYSTEM_SEPARATOR = File.separatorChar;

    /**
     * The Windows separator character.
     */
    private static final char WINDOWS_SEPARATOR = '\\';
    private static final String UNIX_LINE_SEPARATOR = "\n";

    /**
     * The Windows line separator character.
     */
    private static final String WINDOWS_LINE_SEPARATOR = "\r\n";

    /**
     * The current system line separator.
     */
    private static final String LINE_SEPARATOR;

    static boolean isSystemWindows() {
        return SYSTEM_SEPARATOR == WINDOWS_SEPARATOR;
    }

    static {
        if (isSystemWindows()) {
            LINE_SEPARATOR = WINDOWS_LINE_SEPARATOR;
        } else {
            LINE_SEPARATOR = UNIX_LINE_SEPARATOR;
        }
    }

    public static String getExceptionTraceInfo(Exception e) {
        StackTraceElement[] trace = e.getStackTrace();
        StringBuffer sb = new StringBuffer();
        sb.append(e.getMessage() + LINE_SEPARATOR);
        for (int i = 0; i < trace.length; i++)
            sb.append("\tat " + trace[i] + LINE_SEPARATOR);

        return sb.toString();
    }
}
