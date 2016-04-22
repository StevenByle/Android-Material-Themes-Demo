package com.stevenbyle.android.materialthemes.log;

import android.text.TextUtils;

import timber.log.Timber.DebugTree;

/**
 * @author Steven Byle
 */
public class DebugClassAndMethodTree extends DebugTree {
    public static final String MESSAGE_SHOW_METHOD_ONLY = "MESSAGE_SHOW_METHOD_ONLY";
    private static final int CALL_STACK_INDEX = 6;

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        // Get the message prefix and prepend it into the message
        String messagePrefix = getMessagePrefix();
        if (!TextUtils.isEmpty(messagePrefix)) {
            StringBuilder prefixedMessageBuilder = new StringBuilder(messagePrefix);
            // Only append the message if it isn't empty, and it isn't the special directive only show method
            if (!TextUtils.isEmpty(message) && !message.equals(MESSAGE_SHOW_METHOD_ONLY)) {
                prefixedMessageBuilder.append(": ").append(message);
            }
            message = prefixedMessageBuilder.toString();
        }
        super.log(priority, tag, message, t);
    }

    private String getMessagePrefix() {
        // DO NOT switch this to Thread.getCurrentThread().getStackTrace(). The test will pass
        // because Robolectric runs them on the JVM but on Android the elements are different.
        StackTraceElement[] stackTrace = new Throwable().getStackTrace();
        if (stackTrace.length <= CALL_STACK_INDEX) {
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        return stackTrace[CALL_STACK_INDEX].getMethodName();
    }
}
