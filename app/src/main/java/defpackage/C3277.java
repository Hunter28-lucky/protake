package defpackage;

import android.os.Handler;
import android.os.Looper;
import kotlin.coroutines.CoroutineContext;

/* compiled from: HandlerDispatcher.kt */
/* renamed from: ח, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3277 extends AbstractC4213 {
    private volatile C3277 _immediate;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Handler f11470;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String f11471;

    /* renamed from: ԭ, reason: contains not printable characters */
    public final boolean f11472;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public final C3277 f11473;

    public C3277(Handler handler, String str, boolean z) {
        super(null);
        this.f11470 = handler;
        this.f11471 = str;
        this.f11472 = z;
        this._immediate = z ? this : null;
        C3277 c3277 = this._immediate;
        if (c3277 == null) {
            c3277 = new C3277(handler, str, true);
            this._immediate = c3277;
            i4 i4Var = i4.f6762;
        }
        this.f11473 = c3277;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        this.f11470.post(runnable);
    }

    public boolean equals(Object obj) {
        return (obj instanceof C3277) && ((C3277) obj).f11470 == this.f11470;
    }

    public int hashCode() {
        return System.identityHashCode(this.f11470);
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        return (this.f11472 && C3921.m12662(Looper.myLooper(), this.f11470.getLooper())) ? false : true;
    }

    @Override // defpackage.AbstractC3847, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        String strM12262 = m12262();
        if (strM12262 != null) {
            return strM12262;
        }
        String string = this.f11471;
        if (string == null) {
            string = this.f11470.toString();
        }
        return this.f11472 ? C3921.m12673(string, ".immediate") : string;
    }

    @Override // defpackage.AbstractC3847
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public C3277 mo10951() {
        return this.f11473;
    }

    public /* synthetic */ C3277(Handler handler, String str, int i, C4184 c4184) {
        this(handler, (i & 2) != 0 ? null : str);
    }

    public C3277(Handler handler, String str) {
        this(handler, str, false);
    }
}
