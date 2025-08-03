package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: Atomic.kt */
/* renamed from: ྈ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC5074<T> extends AbstractC4290 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f16856 = AtomicReferenceFieldUpdater.newUpdater(AbstractC5074.class, Object.class, "_consensus");
    private volatile /* synthetic */ Object _consensus = C5016.f16777;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.AbstractC4290
    /* renamed from: Ϳ */
    public AbstractC5074<?> mo13403() {
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.AbstractC4290
    /* renamed from: ԩ */
    public final Object mo13405(Object obj) {
        Object objM14896 = this._consensus;
        if (objM14896 == C5016.f16777) {
            objM14896 = m14896(mo7353(obj));
        }
        mo7421(obj, objM14896);
        return objM14896;
    }

    /* renamed from: Ԫ */
    public abstract void mo7421(T t, Object obj);

    /* renamed from: ԫ, reason: contains not printable characters */
    public final Object m14896(Object obj) {
        Object obj2 = this._consensus;
        Object obj3 = C5016.f16777;
        return obj2 != obj3 ? obj2 : C3777.m12082(f16856, this, obj3, obj) ? obj : this._consensus;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public long m14897() {
        return 0L;
    }

    /* renamed from: ԭ */
    public abstract Object mo7353(T t);
}
