package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;

/* compiled from: AndroidSchedulers.java */
/* renamed from: ࢺ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4000 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final AbstractC4585 f13955 = C3548.m11490(new CallableC4001());

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: ࢺ$Ϳ, reason: contains not printable characters */
    public static class CallableC4001 implements Callable<AbstractC4585> {
        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC4585 call() throws Exception {
            return C4002.f13956;
        }
    }

    /* compiled from: AndroidSchedulers.java */
    /* renamed from: ࢺ$Ԩ, reason: contains not printable characters */
    public static final class C4002 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final AbstractC4585 f13956 = new C3291(new Handler(Looper.getMainLooper()));
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static AbstractC4585 m12867() {
        return C3548.m11491(f13955);
    }
}
