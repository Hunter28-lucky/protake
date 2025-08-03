package defpackage;

/* compiled from: Tasks.kt */
/* loaded from: classes2.dex */
public final class i1 extends g1 {

    /* renamed from: ԭ, reason: contains not printable characters */
    public final Runnable f6760;

    public i1(Runnable runnable, long j, h1 h1Var) {
        super(j, h1Var);
        this.f6760 = runnable;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f6760.run();
        } finally {
            this.f6646.mo6177();
        }
    }

    public String toString() {
        return "Task[" + C2316.m8690(this.f6760) + '@' + C2316.m8691(this.f6760) + ", " + this.f6645 + ", " + this.f6646 + ']';
    }
}
