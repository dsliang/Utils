package com.tuodi.utils;

import android.util.Log;

import java.util.Locale;

/**
 * Log工具，类似android.util.Log。
 * tag自动产生，格式: log_tag_prefix:className.methodName(L:lineNumber),
 * log_tag_prefix为空时只输出：className.methodName(L:lineNumber)。
 */
public class LogUtils {
    public static String log_tag_prefix = "debug_log";
    private static boolean mIsDebug = true;

    private LogUtils() {
    }


    public static boolean isPrintDebugLog() {
        return mIsDebug;
    }

    public static void setIsPrintDebugLog(boolean state) {
        mIsDebug = state;
    }

    private static String generateTag() {
        StackTraceElement caller = new Throwable().getStackTrace()[2];
        String tag = "%s.%s(L:%d)";
        String callerClazzName = caller.getClassName();
        callerClazzName = callerClazzName.substring(callerClazzName.lastIndexOf(".") + 1);
        tag = String.format(Locale.getDefault(), tag, callerClazzName, caller.getMethodName(), caller.getLineNumber());
        tag = StringUtils.isEmptyOrSpace(log_tag_prefix) ? tag : log_tag_prefix + ":" + tag;
        return tag;
    }

    public static void d(String content) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.d(tag, content);
    }

    public static void d(String content, Throwable tr) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.d(tag, content, tr);
    }

    public static void e(String content) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.e(tag, content);
    }

    public static void e(String content, Throwable tr) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.e(tag, content, tr);
    }

    public static void i(String content) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.i(tag, content);
    }

    public static void i(String content, Throwable tr) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.i(tag, content, tr);
    }

    public static void v(String content) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.v(tag, content);
    }

    public static void v(String content, Throwable tr) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.v(tag, content, tr);
    }

    public static void w(String content) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.w(tag, content);
    }

    public static void w(String content, Throwable tr) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.w(tag, content, tr);
    }

    public static void w(Throwable tr) {
        if (!mIsDebug) return;
        String tag = generateTag();

        Log.w(tag, tr);
    }
}