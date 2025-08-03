package org.dom4j;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public class DocumentException extends Exception {
    private Throwable nestedException;

    public DocumentException(String str, Throwable th) {
        super(str);
        this.nestedException = th;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.nestedException == null) {
            return super.getMessage();
        }
        return super.getMessage() + " Nested exception: " + this.nestedException.getMessage();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        super.printStackTrace();
        if (this.nestedException != null) {
            System.err.print("Nested exception: ");
            this.nestedException.printStackTrace();
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.nestedException != null) {
            printStream.println("Nested exception: ");
            this.nestedException.printStackTrace(printStream);
        }
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.nestedException != null) {
            printWriter.println("Nested exception: ");
            this.nestedException.printStackTrace(printWriter);
        }
    }
}
