package defpackage;

import kotlin.coroutines.CoroutineContext;

/* compiled from: ThreadContext.kt */
/* loaded from: classes2.dex */
public final class h2 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final CoroutineContext f6718;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final Object[] f6719;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final d2<Object>[] f6720;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f6721;

    public h2(CoroutineContext coroutineContext, int i) {
        this.f6718 = coroutineContext;
        this.f6719 = new Object[i];
        this.f6720 = new d2[i];
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m6179(d2<?> d2Var, Object obj) {
        Object[] objArr = this.f6719;
        int i = this.f6721;
        objArr[i] = obj;
        d2<Object>[] d2VarArr = this.f6720;
        this.f6721 = i + 1;
        d2VarArr[i] = d2Var;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m6180(CoroutineContext coroutineContext) {
        int length = this.f6720.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i = length - 1;
            d2<Object> d2Var = this.f6720[length];
            C3921.m12664(d2Var);
            d2Var.m5914(coroutineContext, this.f6719[length]);
            if (i < 0) {
                return;
            } else {
                length = i;
            }
        }
    }
}
