package defpackage;

import io.reactivex.internal.functions.Functions;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* compiled from: ObservableInternalHelper.java */
/* renamed from: ڳ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public final class C3587 {

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$Ϳ, reason: contains not printable characters */
    public static final class CallableC3588<T> implements Callable<AbstractC4945<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC4262<T> f12504;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final int f12505;

        public CallableC3588(AbstractC4262<T> abstractC4262, int i) {
            this.f12504 = abstractC4262;
            this.f12505 = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC4945<T> call() {
            return this.f12504.replay(this.f12505);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$Ԩ, reason: contains not printable characters */
    public static final class CallableC3589<T> implements Callable<AbstractC4945<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC4262<T> f12506;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final int f12507;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final long f12508;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final TimeUnit f12509;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final AbstractC4585 f12510;

        public CallableC3589(AbstractC4262<T> abstractC4262, int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.f12506 = abstractC4262;
            this.f12507 = i;
            this.f12508 = j;
            this.f12509 = timeUnit;
            this.f12510 = abstractC4585;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC4945<T> call() {
            return this.f12506.replay(this.f12507, this.f12508, this.f12509, this.f12510);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$Ԫ, reason: contains not printable characters */
    public static final class C3590<T, U> implements InterfaceC2368<T, InterfaceC2856<U>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends Iterable<? extends U>> f12511;

        public C3590(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368) {
            this.f12511 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<U> apply(T t) throws Exception {
            return new C4388((Iterable) C4246.m13353(this.f12511.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$Ԭ, reason: contains not printable characters */
    public static final class C3591<U, R, T> implements InterfaceC2368<U, R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5247<? super T, ? super U, ? extends R> f12512;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final T f12513;

        public C3591(InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, T t) {
            this.f12512 = interfaceC5247;
            this.f12513 = t;
        }

        @Override // defpackage.InterfaceC2368
        public R apply(U u) throws Exception {
            return this.f12512.apply(this.f12513, u);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$Ԯ, reason: contains not printable characters */
    public static final class C3592<T, R, U> implements InterfaceC2368<T, InterfaceC2856<R>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5247<? super T, ? super U, ? extends R> f12514;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> f12515;

        public C3592(InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368) {
            this.f12514 = interfaceC5247;
            this.f12515 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<R> apply(T t) throws Exception {
            return new C4113((InterfaceC2856) C4246.m13353(this.f12515.apply(t), "The mapper returned a null ObservableSource"), new C3591(this.f12514, t));
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$ՠ, reason: contains not printable characters */
    public static final class C3593<T, U> implements InterfaceC2368<T, InterfaceC2856<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends InterfaceC2856<U>> f12516;

        public C3593(InterfaceC2368<? super T, ? extends InterfaceC2856<U>> interfaceC2368) {
            this.f12516 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<T> apply(T t) throws Exception {
            return new C4612((InterfaceC2856) C4246.m13353(this.f12516.apply(t), "The itemDelay returned a null ObservableSource"), 1L).map(Functions.m6325(t)).defaultIfEmpty(t);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$ֈ, reason: contains not printable characters */
    public static final class C3594<T> implements InterfaceC3809 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<T> f12517;

        public C3594(InterfaceC5102<T> interfaceC5102) {
            this.f12517 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC3809
        public void run() throws Exception {
            this.f12517.onComplete();
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$֏, reason: contains not printable characters */
    public static final class C3595<T> implements InterfaceC2857<Throwable> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<T> f12518;

        public C3595(InterfaceC5102<T> interfaceC5102) {
            this.f12518 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f12518.onError(th);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$ׯ, reason: contains not printable characters */
    public static final class C3596<T> implements InterfaceC2857<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5102<T> f12519;

        public C3596(InterfaceC5102<T> interfaceC5102) {
            this.f12519 = interfaceC5102;
        }

        @Override // defpackage.InterfaceC2857
        public void accept(T t) throws Exception {
            this.f12519.onNext(t);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$ؠ, reason: contains not printable characters */
    public static final class CallableC3597<T> implements Callable<AbstractC4945<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC4262<T> f12520;

        public CallableC3597(AbstractC4262<T> abstractC4262) {
            this.f12520 = abstractC4262;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC4945<T> call() {
            return this.f12520.replay();
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$ހ, reason: contains not printable characters */
    public static final class C3598<T, R> implements InterfaceC2368<AbstractC4262<T>, InterfaceC2856<R>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> f12521;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AbstractC4585 f12522;

        public C3598(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368, AbstractC4585 abstractC4585) {
            this.f12521 = interfaceC2368;
            this.f12522 = abstractC4585;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<R> apply(AbstractC4262<T> abstractC4262) throws Exception {
            return AbstractC4262.wrap((InterfaceC2856) C4246.m13353(this.f12521.apply(abstractC4262), "The selector returned a null ObservableSource")).observeOn(this.f12522);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$ށ, reason: contains not printable characters */
    public static final class C3599<T, S> implements InterfaceC5247<S, InterfaceC3487<T>, S> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC5246<S, InterfaceC3487<T>> f12523;

        public C3599(InterfaceC5246<S, InterfaceC3487<T>> interfaceC5246) {
            this.f12523 = interfaceC5246;
        }

        @Override // defpackage.InterfaceC5247
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public S apply(S s, InterfaceC3487<T> interfaceC3487) throws Exception {
            this.f12523.accept(s, interfaceC3487);
            return s;
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$ނ, reason: contains not printable characters */
    public static final class C3600<T, S> implements InterfaceC5247<S, InterfaceC3487<T>, S> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC2857<InterfaceC3487<T>> f12524;

        public C3600(InterfaceC2857<InterfaceC3487<T>> interfaceC2857) {
            this.f12524 = interfaceC2857;
        }

        @Override // defpackage.InterfaceC5247
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public S apply(S s, InterfaceC3487<T> interfaceC3487) throws Exception {
            this.f12524.accept(interfaceC3487);
            return s;
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$ރ, reason: contains not printable characters */
    public static final class CallableC3601<T> implements Callable<AbstractC4945<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC4262<T> f12525;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f12526;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final TimeUnit f12527;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AbstractC4585 f12528;

        public CallableC3601(AbstractC4262<T> abstractC4262, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.f12525 = abstractC4262;
            this.f12526 = j;
            this.f12527 = timeUnit;
            this.f12528 = abstractC4585;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC4945<T> call() {
            return this.f12525.replay(this.f12526, this.f12527, this.f12528);
        }
    }

    /* compiled from: ObservableInternalHelper.java */
    /* renamed from: ڳ$ބ, reason: contains not printable characters */
    public static final class C3602<T, R> implements InterfaceC2368<List<InterfaceC2856<? extends T>>, InterfaceC2856<? extends R>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2368<? super Object[], ? extends R> f12529;

        public C3602(InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
            this.f12529 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public InterfaceC2856<? extends R> apply(List<InterfaceC2856<? extends T>> list) {
            return AbstractC4262.zipIterable(list, this.f12529, false, AbstractC4262.bufferSize());
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T, U> InterfaceC2368<T, InterfaceC2856<U>> m11609(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368) {
        return new C3590(interfaceC2368);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T, U, R> InterfaceC2368<T, InterfaceC2856<R>> m11610(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        return new C3592(interfaceC5247, interfaceC2368);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T, U> InterfaceC2368<T, InterfaceC2856<T>> m11611(InterfaceC2368<? super T, ? extends InterfaceC2856<U>> interfaceC2368) {
        return new C3593(interfaceC2368);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T> InterfaceC3809 m11612(InterfaceC5102<T> interfaceC5102) {
        return new C3594(interfaceC5102);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> InterfaceC2857<Throwable> m11613(InterfaceC5102<T> interfaceC5102) {
        return new C3595(interfaceC5102);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T> InterfaceC2857<T> m11614(InterfaceC5102<T> interfaceC5102) {
        return new C3596(interfaceC5102);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static <T> Callable<AbstractC4945<T>> m11615(AbstractC4262<T> abstractC4262) {
        return new CallableC3597(abstractC4262);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static <T> Callable<AbstractC4945<T>> m11616(AbstractC4262<T> abstractC4262, int i) {
        return new CallableC3588(abstractC4262, i);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static <T> Callable<AbstractC4945<T>> m11617(AbstractC4262<T> abstractC4262, int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return new CallableC3589(abstractC4262, i, j, timeUnit, abstractC4585);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static <T> Callable<AbstractC4945<T>> m11618(AbstractC4262<T> abstractC4262, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return new CallableC3601(abstractC4262, j, timeUnit, abstractC4585);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static <T, R> InterfaceC2368<AbstractC4262<T>, InterfaceC2856<R>> m11619(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368, AbstractC4585 abstractC4585) {
        return new C3598(interfaceC2368, abstractC4585);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static <T, S> InterfaceC5247<S, InterfaceC3487<T>, S> m11620(InterfaceC5246<S, InterfaceC3487<T>> interfaceC5246) {
        return new C3599(interfaceC5246);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static <T, S> InterfaceC5247<S, InterfaceC3487<T>, S> m11621(InterfaceC2857<InterfaceC3487<T>> interfaceC2857) {
        return new C3600(interfaceC2857);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static <T, R> InterfaceC2368<List<InterfaceC2856<? extends T>>, InterfaceC2856<? extends R>> m11622(InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        return new C3602(interfaceC2368);
    }
}
