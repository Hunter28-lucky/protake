package defpackage;

import kotlinx.coroutines.sync.MutexImpl;

/* compiled from: Mutex.kt */
/* renamed from: ફ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4357 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final r0 f14913 = new r0("LOCK_FAIL");

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final r0 f14914 = new r0("UNLOCK_FAIL");

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final r0 f14915 = new r0("SELECT_SUCCESS");

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final r0 f14916;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final r0 f14917;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final C3660 f14918;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final C3660 f14919;

    static {
        r0 r0Var = new r0("LOCKED");
        f14916 = r0Var;
        r0 r0Var2 = new r0("UNLOCKED");
        f14917 = r0Var2;
        f14918 = new C3660(r0Var);
        f14919 = new C3660(r0Var2);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final InterfaceC3750 m13512(boolean z) {
        return new MutexImpl(z);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static /* synthetic */ InterfaceC3750 m13513(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return m13512(z);
    }
}
