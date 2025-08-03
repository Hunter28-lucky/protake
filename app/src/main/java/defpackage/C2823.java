package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* compiled from: CompletionState.kt */
/* renamed from: ν, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C2823 {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10292 = AtomicIntegerFieldUpdater.newUpdater(C2823.class, "_handled");
    private volatile /* synthetic */ int _handled;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final Throwable f10293;

    public C2823(Throwable th, boolean z) {
        this.f10293 = th;
        this._handled = z ? 1 : 0;
    }

    public String toString() {
        return C2316.m8690(this) + '[' + this.f10293 + ']';
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [boolean, int] */
    /* renamed from: Ϳ, reason: contains not printable characters */
    public final boolean m10167() {
        return this._handled;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final boolean m10168() {
        return f10292.compareAndSet(this, 0, 1);
    }

    public /* synthetic */ C2823(Throwable th, boolean z, int i, C4184 c4184) {
        this(th, (i & 2) != 0 ? false : z);
    }
}
