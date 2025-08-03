package com.mob.commons.cc;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public final class t extends RuntimeException {
    public t(String str, Throwable th) {
        super(str, th);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        printStream.println("" + getMessage());
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        printWriter.println("" + getMessage());
    }
}
