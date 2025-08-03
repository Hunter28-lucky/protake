package defpackage;

import java.util.concurrent.TimeUnit;

/* compiled from: ConnectionPool.kt */
/* renamed from: Ⴄ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C5198 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C2861 f17252;

    public C5198(C2861 c2861) {
        C3921.m12667(c2861, "delegate");
        this.f17252 = c2861;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final C2861 m15169() {
        return this.f17252;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public C5198(int i, long j, TimeUnit timeUnit) {
        this(new C2861(m1.f7970, i, j, timeUnit));
        C3921.m12667(timeUnit, "timeUnit");
    }

    public C5198() {
        this(5, 5L, TimeUnit.MINUTES);
    }
}
