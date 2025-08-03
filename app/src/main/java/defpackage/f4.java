package defpackage;

import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.ThreadContextKt;

/* compiled from: CoroutineContext.kt */
/* loaded from: classes2.dex */
public final class f4<T> extends C4470<T> {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public CoroutineContext f6635;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Object f6636;

    /* JADX WARN: Illegal instructions before constructor call */
    public f4(CoroutineContext coroutineContext, InterfaceC4355<? super T> interfaceC4355) {
        h4 h4Var = h4.f6722;
        super(coroutineContext.get(h4Var) == null ? coroutineContext.plus(h4Var) : coroutineContext, interfaceC4355);
    }

    @Override // defpackage.C4470, defpackage.AbstractC3173
    /* renamed from: ࢧ, reason: contains not printable characters */
    public void mo6049(Object obj) {
        CoroutineContext coroutineContext = this.f6635;
        if (coroutineContext != null) {
            ThreadContextKt.m7370(coroutineContext, this.f6636);
            this.f6635 = null;
            this.f6636 = null;
        }
        Object objM9541 = C2609.m9541(obj, this.f15372);
        InterfaceC4355<T> interfaceC4355 = this.f15372;
        CoroutineContext context = interfaceC4355.getContext();
        Object objM7372 = ThreadContextKt.m7372(context, null);
        f4<?> f4VarM10653 = objM7372 != ThreadContextKt.f7879 ? C3079.m10653(interfaceC4355, context, objM7372) : null;
        try {
            this.f15372.resumeWith(objM9541);
            i4 i4Var = i4.f6762;
        } finally {
            if (f4VarM10653 == null || f4VarM10653.m6050()) {
                ThreadContextKt.m7370(context, objM7372);
            }
        }
    }

    /* renamed from: ࢫ, reason: contains not printable characters */
    public final boolean m6050() {
        if (this.f6635 == null) {
            return false;
        }
        this.f6635 = null;
        this.f6636 = null;
        return true;
    }

    /* renamed from: ࢬ, reason: contains not printable characters */
    public final void m6051(CoroutineContext coroutineContext, Object obj) {
        this.f6635 = coroutineContext;
        this.f6636 = obj;
    }
}
