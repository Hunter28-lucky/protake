package io.reactivex.internal.operators.flowable;

import defpackage.AbstractC3630;
import defpackage.AbstractC3731;
import defpackage.AbstractC4585;
import defpackage.C4246;
import defpackage.InterfaceC2368;
import defpackage.InterfaceC2857;
import defpackage.InterfaceC3487;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC5246;
import defpackage.InterfaceC5247;
import io.reactivex.internal.functions.Functions;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: classes2.dex */
public final class FlowableInternalHelper {

    public enum RequestMax implements InterfaceC2857<Subscription> {
        INSTANCE;

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Subscription subscription) throws Exception {
            subscription.request(Long.MAX_VALUE);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$Ϳ, reason: contains not printable characters */
    public static final class CallableC2025<T> implements Callable<AbstractC3731<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC3630<T> f6972;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final int f6973;

        public CallableC2025(AbstractC3630<T> abstractC3630, int i) {
            this.f6972 = abstractC3630;
            this.f6973 = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC3731<T> call() {
            return this.f6972.replay(this.f6973);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$Ԩ, reason: contains not printable characters */
    public static final class CallableC2026<T> implements Callable<AbstractC3731<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC3630<T> f6974;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final int f6975;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final long f6976;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final TimeUnit f6977;

        /* renamed from: ԯ, reason: contains not printable characters */
        public final AbstractC4585 f6978;

        public CallableC2026(AbstractC3630<T> abstractC3630, int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.f6974 = abstractC3630;
            this.f6975 = i;
            this.f6976 = j;
            this.f6977 = timeUnit;
            this.f6978 = abstractC4585;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC3731<T> call() {
            return this.f6974.replay(this.f6975, this.f6976, this.f6977, this.f6978);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$Ԫ, reason: contains not printable characters */
    public static final class C2027<T, U> implements InterfaceC2368<T, Publisher<U>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends Iterable<? extends U>> f6979;

        public C2027(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368) {
            this.f6979 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Publisher<U> apply(T t) throws Exception {
            return new FlowableFromIterable((Iterable) C4246.m13353(this.f6979.apply(t), "The mapper returned a null Iterable"));
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$Ԭ, reason: contains not printable characters */
    public static final class C2028<U, R, T> implements InterfaceC2368<U, R> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5247<? super T, ? super U, ? extends R> f6980;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final T f6981;

        public C2028(InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, T t) {
            this.f6980 = interfaceC5247;
            this.f6981 = t;
        }

        @Override // defpackage.InterfaceC2368
        public R apply(U u) throws Exception {
            return this.f6980.apply(this.f6981, u);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$Ԯ, reason: contains not printable characters */
    public static final class C2029<T, R, U> implements InterfaceC2368<T, Publisher<R>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC5247<? super T, ? super U, ? extends R> f6982;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends Publisher<? extends U>> f6983;

        public C2029(InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368) {
            this.f6982 = interfaceC5247;
            this.f6983 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Publisher<R> apply(T t) throws Exception {
            return new C2068((Publisher) C4246.m13353(this.f6983.apply(t), "The mapper returned a null Publisher"), new C2028(this.f6982, t));
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$ՠ, reason: contains not printable characters */
    public static final class C2030<T, U> implements InterfaceC2368<T, Publisher<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2368<? super T, ? extends Publisher<U>> f6984;

        public C2030(InterfaceC2368<? super T, ? extends Publisher<U>> interfaceC2368) {
            this.f6984 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Publisher<T> apply(T t) throws Exception {
            return new C2069((Publisher) C4246.m13353(this.f6984.apply(t), "The itemDelay returned a null Publisher"), 1L).map(Functions.m6325(t)).defaultIfEmpty(t);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$ֈ, reason: contains not printable characters */
    public static final class CallableC2031<T> implements Callable<AbstractC3731<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC3630<T> f6985;

        public CallableC2031(AbstractC3630<T> abstractC3630) {
            this.f6985 = abstractC3630;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC3731<T> call() {
            return this.f6985.replay();
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$֏, reason: contains not printable characters */
    public static final class C2032<T, R> implements InterfaceC2368<AbstractC3630<T>, Publisher<R>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> f6986;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final AbstractC4585 f6987;

        public C2032(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368, AbstractC4585 abstractC4585) {
            this.f6986 = interfaceC2368;
            this.f6987 = abstractC4585;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Publisher<R> apply(AbstractC3630<T> abstractC3630) throws Exception {
            return AbstractC3630.fromPublisher((Publisher) C4246.m13353(this.f6986.apply(abstractC3630), "The selector returned a null Publisher")).observeOn(this.f6987);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$ׯ, reason: contains not printable characters */
    public static final class C2033<T, S> implements InterfaceC5247<S, InterfaceC3487<T>, S> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC5246<S, InterfaceC3487<T>> f6988;

        public C2033(InterfaceC5246<S, InterfaceC3487<T>> interfaceC5246) {
            this.f6988 = interfaceC5246;
        }

        @Override // defpackage.InterfaceC5247
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public S apply(S s, InterfaceC3487<T> interfaceC3487) throws Exception {
            this.f6988.accept(s, interfaceC3487);
            return s;
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$ؠ, reason: contains not printable characters */
    public static final class C2034<T, S> implements InterfaceC5247<S, InterfaceC3487<T>, S> {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final InterfaceC2857<InterfaceC3487<T>> f6989;

        public C2034(InterfaceC2857<InterfaceC3487<T>> interfaceC2857) {
            this.f6989 = interfaceC2857;
        }

        @Override // defpackage.InterfaceC5247
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public S apply(S s, InterfaceC3487<T> interfaceC3487) throws Exception {
            this.f6989.accept(interfaceC3487);
            return s;
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$ހ, reason: contains not printable characters */
    public static final class C2035<T> implements InterfaceC3809 {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<T> f6990;

        public C2035(Subscriber<T> subscriber) {
            this.f6990 = subscriber;
        }

        @Override // defpackage.InterfaceC3809
        public void run() throws Exception {
            this.f6990.onComplete();
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$ށ, reason: contains not printable characters */
    public static final class C2036<T> implements InterfaceC2857<Throwable> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<T> f6991;

        public C2036(Subscriber<T> subscriber) {
            this.f6991 = subscriber;
        }

        @Override // defpackage.InterfaceC2857
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
            this.f6991.onError(th);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$ނ, reason: contains not printable characters */
    public static final class C2037<T> implements InterfaceC2857<T> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final Subscriber<T> f6992;

        public C2037(Subscriber<T> subscriber) {
            this.f6992 = subscriber;
        }

        @Override // defpackage.InterfaceC2857
        public void accept(T t) throws Exception {
            this.f6992.onNext(t);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$ރ, reason: contains not printable characters */
    public static final class CallableC2038<T> implements Callable<AbstractC3731<T>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final AbstractC3630<T> f6993;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public final long f6994;

        /* renamed from: ԭ, reason: contains not printable characters */
        public final TimeUnit f6995;

        /* renamed from: Ԯ, reason: contains not printable characters */
        public final AbstractC4585 f6996;

        public CallableC2038(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
            this.f6993 = abstractC3630;
            this.f6994 = j;
            this.f6995 = timeUnit;
            this.f6996 = abstractC4585;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public AbstractC3731<T> call() {
            return this.f6993.replay(this.f6994, this.f6995, this.f6996);
        }
    }

    /* renamed from: io.reactivex.internal.operators.flowable.FlowableInternalHelper$ބ, reason: contains not printable characters */
    public static final class C2039<T, R> implements InterfaceC2368<List<Publisher<? extends T>>, Publisher<? extends R>> {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final InterfaceC2368<? super Object[], ? extends R> f6997;

        public C2039(InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
            this.f6997 = interfaceC2368;
        }

        @Override // defpackage.InterfaceC2368
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public Publisher<? extends R> apply(List<Publisher<? extends T>> list) {
            return AbstractC3630.zipIterable(list, this.f6997, false, AbstractC3630.bufferSize());
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static <T, U> InterfaceC2368<T, Publisher<U>> m6490(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368) {
        return new C2027(interfaceC2368);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static <T, U, R> InterfaceC2368<T, Publisher<R>> m6491(InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        return new C2029(interfaceC5247, interfaceC2368);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static <T, U> InterfaceC2368<T, Publisher<T>> m6492(InterfaceC2368<? super T, ? extends Publisher<U>> interfaceC2368) {
        return new C2030(interfaceC2368);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static <T> Callable<AbstractC3731<T>> m6493(AbstractC3630<T> abstractC3630) {
        return new CallableC2031(abstractC3630);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static <T> Callable<AbstractC3731<T>> m6494(AbstractC3630<T> abstractC3630, int i) {
        return new CallableC2025(abstractC3630, i);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static <T> Callable<AbstractC3731<T>> m6495(AbstractC3630<T> abstractC3630, int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return new CallableC2026(abstractC3630, i, j, timeUnit, abstractC4585);
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static <T> Callable<AbstractC3731<T>> m6496(AbstractC3630<T> abstractC3630, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return new CallableC2038(abstractC3630, j, timeUnit, abstractC4585);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static <T, R> InterfaceC2368<AbstractC3630<T>, Publisher<R>> m6497(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368, AbstractC4585 abstractC4585) {
        return new C2032(interfaceC2368, abstractC4585);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static <T, S> InterfaceC5247<S, InterfaceC3487<T>, S> m6498(InterfaceC5246<S, InterfaceC3487<T>> interfaceC5246) {
        return new C2033(interfaceC5246);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static <T, S> InterfaceC5247<S, InterfaceC3487<T>, S> m6499(InterfaceC2857<InterfaceC3487<T>> interfaceC2857) {
        return new C2034(interfaceC2857);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static <T> InterfaceC3809 m6500(Subscriber<T> subscriber) {
        return new C2035(subscriber);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static <T> InterfaceC2857<Throwable> m6501(Subscriber<T> subscriber) {
        return new C2036(subscriber);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static <T> InterfaceC2857<T> m6502(Subscriber<T> subscriber) {
        return new C2037(subscriber);
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static <T, R> InterfaceC2368<List<Publisher<? extends T>>, Publisher<? extends R>> m6503(InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        return new C2039(interfaceC2368);
    }
}
