package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/* compiled from: Closeable.kt */
/* renamed from: ٳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3494 {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final void m11412(Closeable closeable, Throwable th) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                C4147.m13130(th, th2);
            }
        }
    }
}
