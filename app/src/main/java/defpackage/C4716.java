package defpackage;

import android.os.Bundle;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: ണ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C4716 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final Map<String, InterfaceC4717> f15981 = new ConcurrentHashMap();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static long f15982 = -1;

    /* renamed from: ണ$Ϳ, reason: contains not printable characters */
    public interface InterfaceC4717 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        void m14255(int i, String str, Bundle bundle);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m14254(String str, int i, String str2, Bundle bundle) {
        InterfaceC4717 interfaceC4717Remove = f15981.remove(str);
        if (interfaceC4717Remove != null) {
            try {
                interfaceC4717Remove.m14255(i, str2, bundle);
            } catch (Throwable th) {
                hf.m6205(th);
            }
        }
    }
}
