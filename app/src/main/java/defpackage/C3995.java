package defpackage;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* compiled from: AndroidLog.kt */
/* renamed from: ࢷ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3995 extends Handler {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final C3995 f13948 = new C3995();

    @Override // java.util.logging.Handler
    public void close() {
    }

    @Override // java.util.logging.Handler
    public void flush() {
    }

    @Override // java.util.logging.Handler
    public void publish(LogRecord logRecord) {
        C3921.m12667(logRecord, "record");
        C3994 c3994 = C3994.f13947;
        String loggerName = logRecord.getLoggerName();
        C3921.m12663(loggerName, "record.loggerName");
        int iM12863 = C3996.m12863(logRecord);
        String message = logRecord.getMessage();
        C3921.m12663(message, "record.message");
        c3994.m12858(loggerName, iM12863, message, logRecord.getThrown());
    }
}
