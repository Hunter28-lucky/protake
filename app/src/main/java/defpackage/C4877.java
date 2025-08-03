package defpackage;

import io.reactivex.internal.schedulers.C2117;
import io.reactivex.internal.schedulers.ExecutorScheduler;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: Schedulers.java */
/* renamed from: ฒ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C4877 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final AbstractC4585 f16504 = C3671.m11790(new CallableC4885());

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final AbstractC4585 f16505 = C3671.m11787(new CallableC4879());

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final AbstractC4585 f16506 = C3671.m11788(new CallableC4880());

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final AbstractC4585 f16507 = y2.m8617();

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final AbstractC4585 f16508 = C3671.m11789(new CallableC4883());

    /* compiled from: Schedulers.java */
    /* renamed from: ฒ$Ϳ, reason: contains not printable characters */
    public static final class C4878 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final AbstractC4585 f16509 = new C3455();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: ฒ$Ԩ, reason: contains not printable characters */
    public static final class CallableC4879 implements Callable<AbstractC4585> {
        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC4585 call() throws Exception {
            return C4878.f16509;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: ฒ$Ԫ, reason: contains not printable characters */
    public static final class CallableC4880 implements Callable<AbstractC4585> {
        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC4585 call() throws Exception {
            return C4881.f16510;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: ฒ$Ԭ, reason: contains not printable characters */
    public static final class C4881 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final AbstractC4585 f16510 = new C2674();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: ฒ$Ԯ, reason: contains not printable characters */
    public static final class C4882 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final AbstractC4585 f16511 = new C4844();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: ฒ$ՠ, reason: contains not printable characters */
    public static final class CallableC4883 implements Callable<AbstractC4585> {
        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC4585 call() throws Exception {
            return C4882.f16511;
        }
    }

    /* compiled from: Schedulers.java */
    /* renamed from: ฒ$ֈ, reason: contains not printable characters */
    public static final class C4884 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final AbstractC4585 f16512 = new C2117();
    }

    /* compiled from: Schedulers.java */
    /* renamed from: ฒ$֏, reason: contains not printable characters */
    public static final class CallableC4885 implements Callable<AbstractC4585> {
        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC4585 call() throws Exception {
            return C4884.f16512;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static AbstractC4585 m14600() {
        return C3671.m11802(f16505);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static AbstractC4585 m14601(Executor executor) {
        return new ExecutorScheduler(executor, false);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static AbstractC4585 m14602() {
        return C3671.m11804(f16506);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static AbstractC4585 m14603() {
        return C3671.m11806(f16504);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static AbstractC4585 m14604() {
        return f16507;
    }
}
