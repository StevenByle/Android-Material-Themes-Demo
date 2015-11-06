package com.stevenbyle.androidmaterialdesign.global;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;

/**
 * Created by sbyle on 10/27/15.
 */
public class LogUtil {

    public static String generateTag(Class c) {
        return c.getSimpleName();
    }

    public static int logMessage(LogLevel logLevel, String tag, String methodName) {
        return logMessage(logLevel, tag, methodName, null);
    }

    public static int logMessage(LogLevel logLevel, String tag, String methodName, @Nullable String logMessage) {
        return logMessage(logLevel, tag, methodName, logMessage, null);
    }

    public static int logMessage(LogLevel logLevel, String tag, String methodName, String logMessage, @Nullable Throwable throwable) {
        StringBuilder fullMessage = new StringBuilder(methodName);
        if (!TextUtils.isEmpty(logMessage)) {
            fullMessage.append(": ").append(logMessage);
        }
        return log(logLevel, tag, fullMessage.toString(), throwable);
    }

    public static int logOnAttach(String tag) {
        return logMessage(LogLevel.VERBOSE, tag, "onAttach");
    }

    public static int logOnCreate(String tag, Bundle savedInstanceState) {
        return logMessage(LogLevel.VERBOSE, tag, "onCreate", getSavedInstanceStateNullMessage(savedInstanceState));
    }

    public static int logOnCreateView(String tag, Bundle savedInstanceState) {
        return logMessage(LogLevel.VERBOSE, tag, "onCreateView", getSavedInstanceStateNullMessage(savedInstanceState));
    }

    public static int logOnViewCreated(String tag, Bundle savedInstanceState) {
        return logMessage(LogLevel.VERBOSE, tag, "onViewCreated", getSavedInstanceStateNullMessage(savedInstanceState));
    }

    public static int logOnActivityCreated(String tag, Bundle savedInstanceState) {
        return logMessage(LogLevel.VERBOSE, tag, "onActivityCreated", getSavedInstanceStateNullMessage(savedInstanceState));
    }

    public static int logOnViewStateRestored(String tag, Bundle savedInstanceState) {
        return logMessage(LogLevel.VERBOSE, tag, "onViewStateRestored", getSavedInstanceStateNullMessage(savedInstanceState));
    }

    public static int logOnStart(String tag) {
        return logMessage(LogLevel.VERBOSE, tag, "onStart");
    }

    public static int logOnResume(String tag) {
        return logMessage(LogLevel.VERBOSE, tag, "onResume");
    }

    public static int logOnPause(String tag) {
        return logMessage(LogLevel.VERBOSE, tag, "onPause");
    }

    public static int logOnSaveInstanceState(String tag) {
        return logMessage(LogLevel.VERBOSE, tag, "onSaveInstanceState");
    }

    public static int logOnStop(String tag) {
        return logMessage(LogLevel.VERBOSE, tag, "onStop");
    }

    public static int logOnDestroyView(String tag) {
        return logMessage(LogLevel.VERBOSE, tag, "onDestroyView");
    }

    public static int logOnDestroy(String tag) {
        return logMessage(LogLevel.VERBOSE, tag, "onDestroy");
    }

    private static String getSavedInstanceStateNullMessage(Bundle savedInstanceState) {
        StringBuilder stringBuilder = new StringBuilder("savedInstanceState")
                .append(savedInstanceState == null ? " == " : " != ")
                .append("null");
        return stringBuilder.toString();
    }

    private static int log(LogLevel logLevel, String tag, String message, @Nullable Throwable throwable) {
        switch (logLevel) {
            case VERBOSE:
                if (throwable != null) {
                    return Log.v(tag, message, throwable);
                }
                else {
                    return Log.v(tag, message);
                }
            case DEBUG:
                if (throwable != null) {
                    return Log.d(tag, message, throwable);
                }
                else {
                    return Log.d(tag, message);
                }
            case INFO:
                if (throwable != null) {
                    return Log.i(tag, message, throwable);
                }
                else {
                    return Log.i(tag, message);
                }
            case WARN:
                if (throwable != null) {
                    return Log.w(tag, message, throwable);
                }
                else {
                    return Log.w(tag, message);
                }
            case ERROR:
                if (throwable != null) {
                    return Log.e(tag, message, throwable);
                }
                else {
                    return Log.e(tag, message);
                }
            default:
                throw new IllegalArgumentException("logLevel must be specified");
        }
    }

    public enum LogLevel {
        VERBOSE, DEBUG, INFO, WARN, ERROR
    }
}
