package defpackage;

import kotlin.KotlinNothingValueException;
import kotlin.coroutines.CoroutineContext;

/* compiled from: MainDispatchers.kt */
/* renamed from: ฤ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4907 extends AbstractC3847 {

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Throwable f16560;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final String f16561;

    public C4907(Throwable th, String str) {
        this.f16560 = th;
        this.f16561 = str;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    public boolean isDispatchNeeded(CoroutineContext coroutineContext) {
        m14633();
        throw new KotlinNothingValueException();
    }

    @Override // defpackage.AbstractC3847, kotlinx.coroutines.CoroutineDispatcher
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dispatchers.Main[missing");
        Throwable th = this.f16560;
        sb.append(th != null ? C3921.m12673(", cause=", th) : "");
        sb.append(']');
        return sb.toString();
    }

    @Override // defpackage.AbstractC3847
    /* renamed from: Ԭ */
    public AbstractC3847 mo10951() {
        return this;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    /* renamed from: ԯ, reason: contains not printable characters and merged with bridge method [inline-methods] */
    public Void dispatch(CoroutineContext coroutineContext, Runnable runnable) {
        m14633();
        throw new KotlinNothingValueException();
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final Void m14633() {
        String strM12673;
        if (this.f16560 == null) {
            C2575.m9433();
            throw new KotlinNothingValueException();
        }
        String str = this.f16561;
        String str2 = "";
        if (str != null && (strM12673 = C3921.m12673(". ", str)) != null) {
            str2 = strM12673;
        }
        throw new IllegalStateException(C3921.m12673("Module with the Main dispatcher had failed to initialize", str2), this.f16560);
    }
}
