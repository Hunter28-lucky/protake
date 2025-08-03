package com.xiaomi.push;

import java.io.PrintStream;
import java.io.PrintWriter;

/* loaded from: classes2.dex */
public class fj extends Exception {
    private fs a;

    /* renamed from: a, reason: collision with other field name */
    private ft f5925a;

    /* renamed from: a, reason: collision with other field name */
    private Throwable f5926a;

    public fj() {
        this.a = null;
        this.f5925a = null;
        this.f5926a = null;
    }

    public Throwable a() {
        return this.f5926a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        fs fsVar;
        ft ftVar;
        String message = super.getMessage();
        return (message != null || (ftVar = this.f5925a) == null) ? (message != null || (fsVar = this.a) == null) ? message : fsVar.toString() : ftVar.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String message = super.getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(": ");
        }
        ft ftVar = this.f5925a;
        if (ftVar != null) {
            sb.append(ftVar);
        }
        fs fsVar = this.a;
        if (fsVar != null) {
            sb.append(fsVar);
        }
        if (this.f5926a != null) {
            sb.append("\n  -- caused by: ");
            sb.append(this.f5926a);
        }
        return sb.toString();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        super.printStackTrace(printStream);
        if (this.f5926a != null) {
            printStream.println("Nested Exception: ");
            this.f5926a.printStackTrace(printStream);
        }
    }

    public fj(String str) {
        super(str);
        this.a = null;
        this.f5925a = null;
        this.f5926a = null;
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        super.printStackTrace(printWriter);
        if (this.f5926a != null) {
            printWriter.println("Nested Exception: ");
            this.f5926a.printStackTrace(printWriter);
        }
    }

    public fj(Throwable th) {
        this.a = null;
        this.f5925a = null;
        this.f5926a = th;
    }

    public fj(fs fsVar) {
        this.f5925a = null;
        this.f5926a = null;
        this.a = fsVar;
    }

    public fj(String str, Throwable th) {
        super(str);
        this.a = null;
        this.f5925a = null;
        this.f5926a = th;
    }
}
