package defpackage;

/* compiled from: Task.kt */
/* loaded from: classes2.dex */
public abstract class f1 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public l1 f6630;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public long f6631;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final String f6632;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final boolean f6633;

    public f1(String str, boolean z) {
        C3921.m12667(str, "name");
        this.f6632 = str;
        this.f6633 = z;
        this.f6631 = -1L;
    }

    public String toString() {
        return this.f6632;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m6029() {
        return this.f6633;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final String m6030() {
        return this.f6632;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final long m6031() {
        return this.f6631;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final l1 m6032() {
        return this.f6630;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final void m6033(l1 l1Var) {
        C3921.m12667(l1Var, "queue");
        l1 l1Var2 = this.f6630;
        if (l1Var2 == l1Var) {
            return;
        }
        if (!(l1Var2 == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.f6630 = l1Var;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public abstract long mo6034();

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m6035(long j) {
        this.f6631 = j;
    }

    public /* synthetic */ f1(String str, boolean z, int i, C4184 c4184) {
        this(str, (i & 2) != 0 ? true : z);
    }
}
