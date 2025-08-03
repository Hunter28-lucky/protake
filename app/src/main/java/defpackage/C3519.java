package defpackage;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ContinuationImpl.kt */
/* renamed from: ډ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3519 implements InterfaceC4355<Object> {

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final C3519 f12308 = new C3519();

    @Override // defpackage.InterfaceC4355
    public CoroutineContext getContext() {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    @Override // defpackage.InterfaceC4355
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete".toString());
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
