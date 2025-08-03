package defpackage;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/* compiled from: AndroidLog.kt */
/* renamed from: ࢸ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3996 {
    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final int m12863(LogRecord logRecord) {
        if (logRecord.getLevel().intValue() > Level.INFO.intValue()) {
            return 5;
        }
        return logRecord.getLevel().intValue() == Level.INFO.intValue() ? 4 : 3;
    }
}
