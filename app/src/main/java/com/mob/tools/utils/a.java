package com.mob.tools.utils;

import com.mob.tools.utils.ExecutorDispatcher;

/* loaded from: classes2.dex */
public interface a {
    <T extends ExecutorDispatcher.SafeRunnable> void executeDelayed(T t, long j);

    <T extends ExecutorDispatcher.SafeRunnable> void executeDuctile(T t);

    <T extends ExecutorDispatcher.SafeRunnable> void executeImmediately(T t);

    <T extends ExecutorDispatcher.SafeRunnable> void executeSerial(T t);
}
