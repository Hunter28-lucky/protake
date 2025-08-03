package okio;

import defpackage.C2679;
import defpackage.C3921;
import defpackage.C5241;
import defpackage.InterfaceC4090;

/* compiled from: -Platform.kt */
/* renamed from: okio.-Platform, reason: invalid class name */
/* loaded from: classes2.dex */
public final class Platform {
    public static final byte[] asUtf8ToByteArray(String str) {
        C3921.m12667(str, "$this$asUtf8ToByteArray");
        byte[] bytes = str.getBytes(C5241.f17365);
        C3921.m12663(bytes, "(this as java.lang.String).getBytes(charset)");
        return bytes;
    }

    /* renamed from: synchronized, reason: not valid java name */
    public static final <R> R m7859synchronized(Object obj, InterfaceC4090<? extends R> interfaceC4090) {
        R rInvoke;
        C3921.m12667(obj, "lock");
        C3921.m12667(interfaceC4090, "block");
        synchronized (obj) {
            try {
                rInvoke = interfaceC4090.invoke();
                C2679.m9826(1);
            } catch (Throwable th) {
                C2679.m9826(1);
                C2679.m9825(1);
                throw th;
            }
        }
        C2679.m9825(1);
        return rInvoke;
    }

    public static final String toUtf8String(byte[] bArr) {
        C3921.m12667(bArr, "$this$toUtf8String");
        return new String(bArr, C5241.f17365);
    }
}
