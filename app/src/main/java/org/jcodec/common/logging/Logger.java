package org.jcodec.common.logging;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class Logger {
    private static List<LogSink> sinks;
    private static List<LogSink> stageSinks = new LinkedList();
    private static LogLevel globalLogLevel = LogLevel.INFO;

    public static void addSink(LogSink logSink) {
        List<LogSink> list = stageSinks;
        if (list == null) {
            throw new IllegalStateException("Logger already started");
        }
        list.add(logSink);
    }

    public static void debug(String str) {
        message(LogLevel.DEBUG, str, null);
    }

    public static void error(String str) {
        message(LogLevel.ERROR, str, null);
    }

    public static synchronized LogLevel getLevel() {
        return globalLogLevel;
    }

    public static void info(String str) {
        message(LogLevel.INFO, str, null);
    }

    private static void message(LogLevel logLevel, String str, Object[] objArr) {
        Message message;
        if (globalLogLevel.ordinal() >= logLevel.ordinal()) {
            return;
        }
        if (sinks == null) {
            synchronized (Logger.class) {
                if (sinks == null) {
                    List<LogSink> list = stageSinks;
                    sinks = list;
                    stageSinks = null;
                    if (list.isEmpty()) {
                        sinks.add(OutLogSink.createOutLogSink());
                    }
                }
            }
        }
        if (LogLevel.DEBUG.equals(globalLogLevel)) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            message = new Message(logLevel, stackTraceElement.getFileName(), stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getLineNumber(), str, objArr);
        } else {
            message = new Message(logLevel, "", "", "", 0, str, objArr);
        }
        Iterator<LogSink> it = sinks.iterator();
        while (it.hasNext()) {
            it.next().postMessage(message);
        }
    }

    public static synchronized void setLevel(LogLevel logLevel) {
        globalLogLevel = logLevel;
    }

    public static void warn(String str) {
        message(LogLevel.WARN, str, null);
    }

    public static void debug(String str, Object... objArr) {
        message(LogLevel.DEBUG, str, objArr);
    }

    public static void error(String str, Object... objArr) {
        message(LogLevel.ERROR, str, objArr);
    }

    public static void info(String str, Object... objArr) {
        message(LogLevel.INFO, str, objArr);
    }

    public static void warn(String str, Object... objArr) {
        message(LogLevel.WARN, str, objArr);
    }
}
