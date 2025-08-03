package defpackage;

import io.reactivex.BackpressureOverflowStrategy;
import io.reactivex.BackpressureStrategy;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.operators.flowable.BlockingFlowableIterable;
import io.reactivex.internal.operators.flowable.C2064;
import io.reactivex.internal.operators.flowable.C2065;
import io.reactivex.internal.operators.flowable.FlowableAmb;
import io.reactivex.internal.operators.flowable.FlowableBuffer;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary;
import io.reactivex.internal.operators.flowable.FlowableCache;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest;
import io.reactivex.internal.operators.flowable.FlowableConcatArray;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.flowable.FlowableConcatMapEager;
import io.reactivex.internal.operators.flowable.FlowableConcatWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableConcatWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableConcatWithSingle;
import io.reactivex.internal.operators.flowable.FlowableCreate;
import io.reactivex.internal.operators.flowable.FlowableDebounce;
import io.reactivex.internal.operators.flowable.FlowableDebounceTimed;
import io.reactivex.internal.operators.flowable.FlowableDelaySubscriptionOther;
import io.reactivex.internal.operators.flowable.FlowableDoFinally;
import io.reactivex.internal.operators.flowable.FlowableFlatMap;
import io.reactivex.internal.operators.flowable.FlowableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.flowable.FlowableFlatMapMaybe;
import io.reactivex.internal.operators.flowable.FlowableFlatMapSingle;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable;
import io.reactivex.internal.operators.flowable.FlowableFromArray;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.operators.flowable.FlowableGenerate;
import io.reactivex.internal.operators.flowable.FlowableGroupBy;
import io.reactivex.internal.operators.flowable.FlowableGroupJoin;
import io.reactivex.internal.operators.flowable.FlowableInternalHelper;
import io.reactivex.internal.operators.flowable.FlowableInterval;
import io.reactivex.internal.operators.flowable.FlowableIntervalRange;
import io.reactivex.internal.operators.flowable.FlowableJoin;
import io.reactivex.internal.operators.flowable.FlowableLimit;
import io.reactivex.internal.operators.flowable.FlowableMapNotification;
import io.reactivex.internal.operators.flowable.FlowableMaterialize;
import io.reactivex.internal.operators.flowable.FlowableMergeWithCompletable;
import io.reactivex.internal.operators.flowable.FlowableMergeWithMaybe;
import io.reactivex.internal.operators.flowable.FlowableMergeWithSingle;
import io.reactivex.internal.operators.flowable.FlowableObserveOn;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBuffer;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureBufferStrategy;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureDrop;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureLatest;
import io.reactivex.internal.operators.flowable.FlowableOnErrorNext;
import io.reactivex.internal.operators.flowable.FlowableOnErrorReturn;
import io.reactivex.internal.operators.flowable.FlowablePublish;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast;
import io.reactivex.internal.operators.flowable.FlowableRange;
import io.reactivex.internal.operators.flowable.FlowableRangeLong;
import io.reactivex.internal.operators.flowable.FlowableRepeat;
import io.reactivex.internal.operators.flowable.FlowableRepeatUntil;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen;
import io.reactivex.internal.operators.flowable.FlowableReplay;
import io.reactivex.internal.operators.flowable.FlowableRetryBiPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryPredicate;
import io.reactivex.internal.operators.flowable.FlowableRetryWhen;
import io.reactivex.internal.operators.flowable.FlowableSamplePublisher;
import io.reactivex.internal.operators.flowable.FlowableSampleTimed;
import io.reactivex.internal.operators.flowable.FlowableScanSeed;
import io.reactivex.internal.operators.flowable.FlowableSequenceEqualSingle;
import io.reactivex.internal.operators.flowable.FlowableSkipLast;
import io.reactivex.internal.operators.flowable.FlowableSkipLastTimed;
import io.reactivex.internal.operators.flowable.FlowableSkipUntil;
import io.reactivex.internal.operators.flowable.FlowableSubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableSwitchMap;
import io.reactivex.internal.operators.flowable.FlowableTake;
import io.reactivex.internal.operators.flowable.FlowableTakeLast;
import io.reactivex.internal.operators.flowable.FlowableTakeLastOne;
import io.reactivex.internal.operators.flowable.FlowableTakeLastTimed;
import io.reactivex.internal.operators.flowable.FlowableTakeUntil;
import io.reactivex.internal.operators.flowable.FlowableThrottleFirstTimed;
import io.reactivex.internal.operators.flowable.FlowableThrottleLatest;
import io.reactivex.internal.operators.flowable.FlowableTimeout;
import io.reactivex.internal.operators.flowable.FlowableTimeoutTimed;
import io.reactivex.internal.operators.flowable.FlowableTimer;
import io.reactivex.internal.operators.flowable.FlowableUnsubscribeOn;
import io.reactivex.internal.operators.flowable.FlowableUsing;
import io.reactivex.internal.operators.flowable.FlowableWindow;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundary;
import io.reactivex.internal.operators.flowable.FlowableWindowBoundarySupplier;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany;
import io.reactivex.internal.operators.flowable.FlowableZip;
import io.reactivex.internal.operators.mixed.FlowableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableConcatMapSingle;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle;
import io.reactivex.internal.subscribers.ForEachWhileSubscriber;
import io.reactivex.internal.subscribers.LambdaSubscriber;
import io.reactivex.internal.subscribers.StrictSubscriber;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.subscribers.TestSubscriber;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* compiled from: Flowable.java */
/* renamed from: ۊ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC3630<T> implements Publisher<T> {
    public static final int BUFFER_SIZE = Math.max(1, Integer.getInteger("rx2.buffer-size", 128).intValue());

    public static <T> AbstractC3630<T> amb(Iterable<? extends Publisher<? extends T>> iterable) {
        C4246.m13353(iterable, "sources is null");
        return C3671.m11796(new FlowableAmb(null, iterable));
    }

    public static <T> AbstractC3630<T> ambArray(Publisher<? extends T>... publisherArr) {
        C4246.m13353(publisherArr, "sources is null");
        int length = publisherArr.length;
        return length == 0 ? empty() : length == 1 ? fromPublisher(publisherArr[0]) : C3671.m11796(new FlowableAmb(publisherArr, null));
    }

    public static int bufferSize() {
        return BUFFER_SIZE;
    }

    public static <T, R> AbstractC3630<R> combineLatest(Publisher<? extends T>[] publisherArr, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        return combineLatest(publisherArr, interfaceC2368, bufferSize());
    }

    public static <T, R> AbstractC3630<R> combineLatestDelayError(Publisher<? extends T>[] publisherArr, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        return combineLatestDelayError(publisherArr, interfaceC2368, bufferSize());
    }

    public static <T> AbstractC3630<T> concat(Iterable<? extends Publisher<? extends T>> iterable) {
        C4246.m13353(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.m6322(), 2, false);
    }

    public static <T> AbstractC3630<T> concatArray(Publisher<? extends T>... publisherArr) {
        return publisherArr.length == 0 ? empty() : publisherArr.length == 1 ? fromPublisher(publisherArr[0]) : C3671.m11796(new FlowableConcatArray(publisherArr, false));
    }

    public static <T> AbstractC3630<T> concatArrayDelayError(Publisher<? extends T>... publisherArr) {
        return publisherArr.length == 0 ? empty() : publisherArr.length == 1 ? fromPublisher(publisherArr[0]) : C3671.m11796(new FlowableConcatArray(publisherArr, true));
    }

    public static <T> AbstractC3630<T> concatArrayEager(Publisher<? extends T>... publisherArr) {
        return concatArrayEager(bufferSize(), bufferSize(), publisherArr);
    }

    public static <T> AbstractC3630<T> concatArrayEagerDelayError(Publisher<? extends T>... publisherArr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), publisherArr);
    }

    public static <T> AbstractC3630<T> concatDelayError(Iterable<? extends Publisher<? extends T>> iterable) {
        C4246.m13353(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.m6322());
    }

    public static <T> AbstractC3630<T> concatEager(Publisher<? extends Publisher<? extends T>> publisher) {
        return concatEager(publisher, bufferSize(), bufferSize());
    }

    public static <T> AbstractC3630<T> create(InterfaceC4354<T> interfaceC4354, BackpressureStrategy backpressureStrategy) {
        C4246.m13353(interfaceC4354, "source is null");
        C4246.m13353(backpressureStrategy, "mode is null");
        return C3671.m11796(new FlowableCreate(interfaceC4354, backpressureStrategy));
    }

    public static <T> AbstractC3630<T> defer(Callable<? extends Publisher<? extends T>> callable) {
        C4246.m13353(callable, "supplier is null");
        return C3671.m11796(new C3150(callable));
    }

    private AbstractC3630<T> doOnEach(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC3809 interfaceC38092) {
        C4246.m13353(interfaceC2857, "onNext is null");
        C4246.m13353(interfaceC28572, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        C4246.m13353(interfaceC38092, "onAfterTerminate is null");
        return C3671.m11796(new C2416(this, interfaceC2857, interfaceC28572, interfaceC3809, interfaceC38092));
    }

    public static <T> AbstractC3630<T> empty() {
        return C3671.m11796(C4197.f14472);
    }

    public static <T> AbstractC3630<T> error(Callable<? extends Throwable> callable) {
        C4246.m13353(callable, "supplier is null");
        return C3671.m11796(new C5297(callable));
    }

    public static <T> AbstractC3630<T> fromArray(T... tArr) {
        C4246.m13353(tArr, "items is null");
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : C3671.m11796(new FlowableFromArray(tArr));
    }

    public static <T> AbstractC3630<T> fromCallable(Callable<? extends T> callable) {
        C4246.m13353(callable, "supplier is null");
        return C3671.m11796(new CallableC4940(callable));
    }

    public static <T> AbstractC3630<T> fromFuture(Future<? extends T> future) {
        C4246.m13353(future, "future is null");
        return C3671.m11796(new C3087(future, 0L, null));
    }

    public static <T> AbstractC3630<T> fromIterable(Iterable<? extends T> iterable) {
        C4246.m13353(iterable, "source is null");
        return C3671.m11796(new FlowableFromIterable(iterable));
    }

    public static <T> AbstractC3630<T> fromPublisher(Publisher<? extends T> publisher) {
        if (publisher instanceof AbstractC3630) {
            return C3671.m11796((AbstractC3630) publisher);
        }
        C4246.m13353(publisher, "source is null");
        return C3671.m11796(new C2647(publisher));
    }

    public static <T> AbstractC3630<T> generate(InterfaceC2857<InterfaceC3487<T>> interfaceC2857) {
        C4246.m13353(interfaceC2857, "generator is null");
        return generate(Functions.m6332(), FlowableInternalHelper.m6499(interfaceC2857), Functions.m6320());
    }

    public static AbstractC3630<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, C4877.m14600());
    }

    public static AbstractC3630<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, C4877.m14600());
    }

    public static <T> AbstractC3630<T> just(T t) {
        C4246.m13353(t, "item is null");
        return C3671.m11796(new C3631(t));
    }

    public static <T> AbstractC3630<T> merge(Iterable<? extends Publisher<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.m6322(), false, i, i2);
    }

    public static <T> AbstractC3630<T> mergeArray(int i, int i2, Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.m6322(), false, i, i2);
    }

    public static <T> AbstractC3630<T> mergeArrayDelayError(int i, int i2, Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.m6322(), true, i, i2);
    }

    public static <T> AbstractC3630<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.m6322(), true);
    }

    public static <T> AbstractC3630<T> never() {
        return C3671.m11796(C2868.f10496);
    }

    public static AbstractC3630<Integer> range(int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + i2);
        }
        if (i2 == 0) {
            return empty();
        }
        if (i2 == 1) {
            return just(Integer.valueOf(i));
        }
        if (i + (i2 - 1) <= 2147483647L) {
            return C3671.m11796(new FlowableRange(i, i2));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    public static AbstractC3630<Long> rangeLong(long j, long j2) {
        if (j2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        if (j2 == 0) {
            return empty();
        }
        if (j2 == 1) {
            return just(Long.valueOf(j));
        }
        long j3 = (j2 - 1) + j;
        if (j <= 0 || j3 >= 0) {
            return C3671.m11796(new FlowableRangeLong(j, j2));
        }
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    public static <T> AbstractC4838<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        return sequenceEqual(publisher, publisher2, C4246.m13352(), bufferSize());
    }

    public static <T> AbstractC3630<T> switchOnNext(Publisher<? extends Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).switchMap(Functions.m6322(), i);
    }

    public static <T> AbstractC3630<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return switchOnNextDelayError(publisher, bufferSize());
    }

    private AbstractC3630<T> timeout0(long j, TimeUnit timeUnit, Publisher<? extends T> publisher, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "timeUnit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableTimeoutTimed(this, j, timeUnit, abstractC4585, publisher));
    }

    public static AbstractC3630<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, C4877.m14600());
    }

    public static <T> AbstractC3630<T> unsafeCreate(Publisher<T> publisher) {
        C4246.m13353(publisher, "onSubscribe is null");
        if (publisher instanceof AbstractC3630) {
            throw new IllegalArgumentException("unsafeCreate(Flowable) should be upgraded");
        }
        return C3671.m11796(new C2647(publisher));
    }

    public static <T, D> AbstractC3630<T> using(Callable<? extends D> callable, InterfaceC2368<? super D, ? extends Publisher<? extends T>> interfaceC2368, InterfaceC2857<? super D> interfaceC2857) {
        return using(callable, interfaceC2368, interfaceC2857, true);
    }

    public static <T, R> AbstractC3630<R> zip(Iterable<? extends Publisher<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        C4246.m13353(interfaceC2368, "zipper is null");
        C4246.m13353(iterable, "sources is null");
        return C3671.m11796(new FlowableZip(null, iterable, interfaceC2368, bufferSize(), false));
    }

    public static <T, R> AbstractC3630<R> zipArray(InterfaceC2368<? super Object[], ? extends R> interfaceC2368, boolean z, int i, Publisher<? extends T>... publisherArr) {
        if (publisherArr.length == 0) {
            return empty();
        }
        C4246.m13353(interfaceC2368, "zipper is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableZip(publisherArr, null, interfaceC2368, i, z));
    }

    public static <T, R> AbstractC3630<R> zipIterable(Iterable<? extends Publisher<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "zipper is null");
        C4246.m13353(iterable, "sources is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableZip(null, iterable, interfaceC2368, i, z));
    }

    public final AbstractC4838<Boolean> all(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11800(new C3245(this, interfaceC4178));
    }

    public final AbstractC3630<T> ambWith(Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "other is null");
        return ambArray(this, publisher);
    }

    public final AbstractC4838<Boolean> any(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11800(new C4430(this, interfaceC4178));
    }

    public final <R> R as(InterfaceC4192<T, ? extends R> interfaceC4192) {
        return (R) ((InterfaceC4192) C4246.m13353(interfaceC4192, "converter is null")).apply(this);
    }

    public final T blockingFirst() throws InterruptedException {
        C2345 c2345 = new C2345();
        subscribe((InterfaceC3899) c2345);
        T tM11413 = c2345.m11413();
        if (tM11413 != null) {
            return tM11413;
        }
        throw new NoSuchElementException();
    }

    public final void blockingForEach(InterfaceC2857<? super T> interfaceC2857) {
        Iterator<T> it = blockingIterable().iterator();
        while (it.hasNext()) {
            try {
                interfaceC2857.accept(it.next());
            } catch (Throwable th) {
                C4089.m13026(th);
                ((InterfaceC4478) it).dispose();
                throw ExceptionHelper.m7024(th);
            }
        }
    }

    public final Iterable<T> blockingIterable() {
        return blockingIterable(bufferSize());
    }

    public final T blockingLast() throws InterruptedException {
        C2792 c2792 = new C2792();
        subscribe((InterfaceC3899) c2792);
        T tM11413 = c2792.m11413();
        if (tM11413 != null) {
            return tM11413;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new C4218(this);
    }

    public final Iterable<T> blockingMostRecent(T t) {
        return new C5077(this, t);
    }

    public final Iterable<T> blockingNext() {
        return new C2744(this);
    }

    public final T blockingSingle() {
        return singleOrError().blockingGet();
    }

    public final void blockingSubscribe() {
        C3497.m11414(this);
    }

    public final AbstractC3630<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    public final AbstractC3630<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final AbstractC3630<T> cacheWithInitialCapacity(int i) {
        C4246.m13354(i, "initialCapacity");
        return C3671.m11796(new FlowableCache(this, i));
    }

    public final <U> AbstractC3630<U> cast(Class<U> cls) {
        C4246.m13353(cls, "clazz is null");
        return (AbstractC3630<U>) map(Functions.m6317(cls));
    }

    public final <U> AbstractC4838<U> collect(Callable<? extends U> callable, InterfaceC5246<? super U, ? super T> interfaceC5246) {
        C4246.m13353(callable, "initialItemSupplier is null");
        C4246.m13353(interfaceC5246, "collector is null");
        return C3671.m11800(new C3826(this, callable, interfaceC5246));
    }

    public final <U> AbstractC4838<U> collectInto(U u, InterfaceC5246<? super U, ? super T> interfaceC5246) {
        C4246.m13353(u, "initialItem is null");
        return collect(Functions.m6324(u), interfaceC5246);
    }

    public final <R> AbstractC3630<R> compose(InterfaceC5242<? super T, ? extends R> interfaceC5242) {
        return fromPublisher(((InterfaceC5242) C4246.m13353(interfaceC5242, "composer is null")).apply(this));
    }

    public final <R> AbstractC3630<R> concatMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368) {
        return concatMap(interfaceC2368, 2);
    }

    public final AbstractC2900 concatMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        return concatMapCompletable(interfaceC2368, 2);
    }

    public final AbstractC2900 concatMapCompletableDelayError(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        return concatMapCompletableDelayError(interfaceC2368, true, 2);
    }

    public final <R> AbstractC3630<R> concatMapDelayError(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368) {
        return concatMapDelayError(interfaceC2368, 2, true);
    }

    public final <R> AbstractC3630<R> concatMapEager(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368) {
        return concatMapEager(interfaceC2368, bufferSize(), bufferSize());
    }

    public final <R> AbstractC3630<R> concatMapEagerDelayError(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, boolean z) {
        return concatMapEagerDelayError(interfaceC2368, bufferSize(), bufferSize(), z);
    }

    public final <U> AbstractC3630<U> concatMapIterable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368) {
        return concatMapIterable(interfaceC2368, 2);
    }

    public final <R> AbstractC3630<R> concatMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        return concatMapMaybe(interfaceC2368, 2);
    }

    public final <R> AbstractC3630<R> concatMapMaybeDelayError(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        return concatMapMaybeDelayError(interfaceC2368, true, 2);
    }

    public final <R> AbstractC3630<R> concatMapSingle(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        return concatMapSingle(interfaceC2368, 2);
    }

    public final <R> AbstractC3630<R> concatMapSingleDelayError(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        return concatMapSingleDelayError(interfaceC2368, true, 2);
    }

    public final AbstractC3630<T> concatWith(Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "other is null");
        return concat(this, publisher);
    }

    public final AbstractC4838<Boolean> contains(Object obj) {
        C4246.m13353(obj, "item is null");
        return any(Functions.m6321(obj));
    }

    public final AbstractC4838<Long> count() {
        return C3671.m11800(new C2955(this));
    }

    public final <U> AbstractC3630<T> debounce(InterfaceC2368<? super T, ? extends Publisher<U>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "debounceIndicator is null");
        return C3671.m11796(new FlowableDebounce(this, interfaceC2368));
    }

    public final AbstractC3630<T> defaultIfEmpty(T t) {
        C4246.m13353(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    public final <U> AbstractC3630<T> delay(InterfaceC2368<? super T, ? extends Publisher<U>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "itemDelayIndicator is null");
        return (AbstractC3630<T>) flatMap(FlowableInternalHelper.m6492(interfaceC2368));
    }

    public final <U> AbstractC3630<T> delaySubscription(Publisher<U> publisher) {
        C4246.m13353(publisher, "subscriptionIndicator is null");
        return C3671.m11796(new FlowableDelaySubscriptionOther(this, publisher));
    }

    @Deprecated
    public final <T2> AbstractC3630<T2> dematerialize() {
        return C3671.m11796(new C5286(this, Functions.m6322()));
    }

    public final AbstractC3630<T> distinct() {
        return distinct(Functions.m6322(), Functions.m6319());
    }

    public final AbstractC3630<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.m6322());
    }

    public final AbstractC3630<T> doAfterNext(InterfaceC2857<? super T> interfaceC2857) {
        C4246.m13353(interfaceC2857, "onAfterNext is null");
        return C3671.m11796(new C4180(this, interfaceC2857));
    }

    public final AbstractC3630<T> doAfterTerminate(InterfaceC3809 interfaceC3809) {
        return doOnEach(Functions.m6320(), Functions.m6320(), Functions.f6798, interfaceC3809);
    }

    public final AbstractC3630<T> doFinally(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "onFinally is null");
        return C3671.m11796(new FlowableDoFinally(this, interfaceC3809));
    }

    public final AbstractC3630<T> doOnCancel(InterfaceC3809 interfaceC3809) {
        return doOnLifecycle(Functions.m6320(), Functions.f6802, interfaceC3809);
    }

    public final AbstractC3630<T> doOnComplete(InterfaceC3809 interfaceC3809) {
        return doOnEach(Functions.m6320(), Functions.m6320(), interfaceC3809, Functions.f6798);
    }

    public final AbstractC3630<T> doOnError(InterfaceC2857<? super Throwable> interfaceC2857) {
        InterfaceC2857<? super T> interfaceC2857M6320 = Functions.m6320();
        InterfaceC3809 interfaceC3809 = Functions.f6798;
        return doOnEach(interfaceC2857M6320, interfaceC2857, interfaceC3809, interfaceC3809);
    }

    public final AbstractC3630<T> doOnLifecycle(InterfaceC2857<? super Subscription> interfaceC2857, InterfaceC4719 interfaceC4719, InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC2857, "onSubscribe is null");
        C4246.m13353(interfaceC4719, "onRequest is null");
        C4246.m13353(interfaceC3809, "onCancel is null");
        return C3671.m11796(new C5192(this, interfaceC2857, interfaceC4719, interfaceC3809));
    }

    public final AbstractC3630<T> doOnNext(InterfaceC2857<? super T> interfaceC2857) {
        InterfaceC2857<? super Throwable> interfaceC2857M6320 = Functions.m6320();
        InterfaceC3809 interfaceC3809 = Functions.f6798;
        return doOnEach(interfaceC2857, interfaceC2857M6320, interfaceC3809, interfaceC3809);
    }

    public final AbstractC3630<T> doOnRequest(InterfaceC4719 interfaceC4719) {
        return doOnLifecycle(Functions.m6320(), interfaceC4719, Functions.f6798);
    }

    public final AbstractC3630<T> doOnSubscribe(InterfaceC2857<? super Subscription> interfaceC2857) {
        return doOnLifecycle(interfaceC2857, Functions.f6802, Functions.f6798);
    }

    public final AbstractC3630<T> doOnTerminate(InterfaceC3809 interfaceC3809) {
        return doOnEach(Functions.m6320(), Functions.m6313(interfaceC3809), interfaceC3809, Functions.f6798);
    }

    public final AbstractC4274<T> elementAt(long j) {
        if (j >= 0) {
            return C3671.m11797(new C4516(this, j));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final AbstractC4838<T> elementAtOrError(long j) {
        if (j >= 0) {
            return C3671.m11800(new C3125(this, j, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final AbstractC3630<T> filter(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11796(new C4858(this, interfaceC4178));
    }

    public final AbstractC4838<T> first(T t) {
        return elementAt(0L, t);
    }

    public final AbstractC4274<T> firstElement() {
        return elementAt(0L);
    }

    public final AbstractC4838<T> firstOrError() {
        return elementAtOrError(0L);
    }

    public final <R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368) {
        return flatMap((InterfaceC2368) interfaceC2368, false, bufferSize(), bufferSize());
    }

    public final AbstractC2900 flatMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        return flatMapCompletable(interfaceC2368, false, Integer.MAX_VALUE);
    }

    public final <U> AbstractC3630<U> flatMapIterable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368) {
        return flatMapIterable(interfaceC2368, bufferSize());
    }

    public final <R> AbstractC3630<R> flatMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        return flatMapMaybe(interfaceC2368, false, Integer.MAX_VALUE);
    }

    public final <R> AbstractC3630<R> flatMapSingle(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        return flatMapSingle(interfaceC2368, false, Integer.MAX_VALUE);
    }

    public final InterfaceC4478 forEach(InterfaceC2857<? super T> interfaceC2857) {
        return subscribe(interfaceC2857);
    }

    public final InterfaceC4478 forEachWhile(InterfaceC4178<? super T> interfaceC4178) {
        return forEachWhile(interfaceC4178, Functions.f6801, Functions.f6798);
    }

    public final <K> AbstractC3630<AbstractC2965<K, T>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368) {
        return (AbstractC3630<AbstractC2965<K, T>>) groupBy(interfaceC2368, Functions.m6322(), false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> AbstractC3630<R> groupJoin(Publisher<? extends TRight> publisher, InterfaceC2368<? super T, ? extends Publisher<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends Publisher<TRightEnd>> interfaceC23682, InterfaceC5247<? super T, ? super AbstractC3630<TRight>, ? extends R> interfaceC5247) {
        C4246.m13353(publisher, "other is null");
        C4246.m13353(interfaceC2368, "leftEnd is null");
        C4246.m13353(interfaceC23682, "rightEnd is null");
        C4246.m13353(interfaceC5247, "resultSelector is null");
        return C3671.m11796(new FlowableGroupJoin(this, publisher, interfaceC2368, interfaceC23682, interfaceC5247));
    }

    public final AbstractC3630<T> hide() {
        return C3671.m11796(new C2765(this));
    }

    public final AbstractC2900 ignoreElements() {
        return C3671.m11793(new C5111(this));
    }

    public final AbstractC4838<Boolean> isEmpty() {
        return all(Functions.m6314());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> AbstractC3630<R> join(Publisher<? extends TRight> publisher, InterfaceC2368<? super T, ? extends Publisher<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends Publisher<TRightEnd>> interfaceC23682, InterfaceC5247<? super T, ? super TRight, ? extends R> interfaceC5247) {
        C4246.m13353(publisher, "other is null");
        C4246.m13353(interfaceC2368, "leftEnd is null");
        C4246.m13353(interfaceC23682, "rightEnd is null");
        C4246.m13353(interfaceC5247, "resultSelector is null");
        return C3671.m11796(new FlowableJoin(this, publisher, interfaceC2368, interfaceC23682, interfaceC5247));
    }

    public final AbstractC4838<T> last(T t) {
        C4246.m13353(t, "defaultItem");
        return C3671.m11800(new C4963(this, t));
    }

    public final AbstractC4274<T> lastElement() {
        return C3671.m11797(new C3123(this));
    }

    public final AbstractC4838<T> lastOrError() {
        return C3671.m11800(new C4963(this, null));
    }

    public final <R> AbstractC3630<R> lift(InterfaceC2824<? extends R, ? super T> interfaceC2824) {
        C4246.m13353(interfaceC2824, "lifter is null");
        return C3671.m11796(new C4944(this, interfaceC2824));
    }

    public final AbstractC3630<T> limit(long j) {
        if (j >= 0) {
            return C3671.m11796(new FlowableLimit(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public final <R> AbstractC3630<R> map(InterfaceC2368<? super T, ? extends R> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11796(new C2065(this, interfaceC2368));
    }

    public final AbstractC3630<C3906<T>> materialize() {
        return C3671.m11796(new FlowableMaterialize(this));
    }

    public final AbstractC3630<T> mergeWith(Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "other is null");
        return merge(this, publisher);
    }

    public final AbstractC3630<T> observeOn(AbstractC4585 abstractC4585) {
        return observeOn(abstractC4585, false, bufferSize());
    }

    public final <U> AbstractC3630<U> ofType(Class<U> cls) {
        C4246.m13353(cls, "clazz is null");
        return filter(Functions.m6323(cls)).cast(cls);
    }

    public final AbstractC3630<T> onBackpressureBuffer() {
        return onBackpressureBuffer(bufferSize(), false, true);
    }

    public final AbstractC3630<T> onBackpressureDrop() {
        return C3671.m11796(new FlowableOnBackpressureDrop(this));
    }

    public final AbstractC3630<T> onBackpressureLatest() {
        return C3671.m11796(new FlowableOnBackpressureLatest(this));
    }

    public final AbstractC3630<T> onErrorResumeNext(InterfaceC2368<? super Throwable, ? extends Publisher<? extends T>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "resumeFunction is null");
        return C3671.m11796(new FlowableOnErrorNext(this, interfaceC2368, false));
    }

    public final AbstractC3630<T> onErrorReturn(InterfaceC2368<? super Throwable, ? extends T> interfaceC2368) {
        C4246.m13353(interfaceC2368, "valueSupplier is null");
        return C3671.m11796(new FlowableOnErrorReturn(this, interfaceC2368));
    }

    public final AbstractC3630<T> onErrorReturnItem(T t) {
        C4246.m13353(t, "item is null");
        return onErrorReturn(Functions.m6325(t));
    }

    public final AbstractC3630<T> onExceptionResumeNext(Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "next is null");
        return C3671.m11796(new FlowableOnErrorNext(this, Functions.m6325(publisher), true));
    }

    public final AbstractC3630<T> onTerminateDetach() {
        return C3671.m11796(new C3500(this));
    }

    public final AbstractC2624<T> parallel() {
        return AbstractC2624.m9583(this);
    }

    public final AbstractC3731<T> publish() {
        return publish(bufferSize());
    }

    public final AbstractC3630<T> rebatchRequests(int i) {
        return observeOn(C3725.f12915, true, i);
    }

    public final AbstractC4274<T> reduce(InterfaceC5247<T, T, T> interfaceC5247) {
        C4246.m13353(interfaceC5247, "reducer is null");
        return C3671.m11797(new C4447(this, interfaceC5247));
    }

    public final <R> AbstractC4838<R> reduceWith(Callable<R> callable, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        C4246.m13353(callable, "seedSupplier is null");
        C4246.m13353(interfaceC5247, "reducer is null");
        return C3671.m11800(new C2836(this, callable, interfaceC5247));
    }

    public final AbstractC3630<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final AbstractC3630<T> repeatUntil(InterfaceC2881 interfaceC2881) {
        C4246.m13353(interfaceC2881, "stop is null");
        return C3671.m11796(new FlowableRepeatUntil(this, interfaceC2881));
    }

    public final AbstractC3630<T> repeatWhen(InterfaceC2368<? super AbstractC3630<Object>, ? extends Publisher<?>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "handler is null");
        return C3671.m11796(new FlowableRepeatWhen(this, interfaceC2368));
    }

    public final AbstractC3731<T> replay() {
        return FlowableReplay.m6589(this);
    }

    public final AbstractC3630<T> retry() {
        return retry(Long.MAX_VALUE, Functions.m6315());
    }

    public final AbstractC3630<T> retryUntil(InterfaceC2881 interfaceC2881) {
        C4246.m13353(interfaceC2881, "stop is null");
        return retry(Long.MAX_VALUE, Functions.m6333(interfaceC2881));
    }

    public final AbstractC3630<T> retryWhen(InterfaceC2368<? super AbstractC3630<Throwable>, ? extends Publisher<?>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "handler is null");
        return C3671.m11796(new FlowableRetryWhen(this, interfaceC2368));
    }

    public final void safeSubscribe(Subscriber<? super T> subscriber) {
        C4246.m13353(subscriber, "s is null");
        if (subscriber instanceof C4687) {
            subscribe((InterfaceC3899) subscriber);
        } else {
            subscribe((InterfaceC3899) new C4687(subscriber));
        }
    }

    public final AbstractC3630<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, C4877.m14600());
    }

    public final AbstractC3630<T> scan(InterfaceC5247<T, T, T> interfaceC5247) {
        C4246.m13353(interfaceC5247, "accumulator is null");
        return C3671.m11796(new C5230(this, interfaceC5247));
    }

    public final <R> AbstractC3630<R> scanWith(Callable<R> callable, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        C4246.m13353(callable, "seedSupplier is null");
        C4246.m13353(interfaceC5247, "accumulator is null");
        return C3671.m11796(new FlowableScanSeed(this, callable, interfaceC5247));
    }

    public final AbstractC3630<T> serialize() {
        return C3671.m11796(new C4367(this));
    }

    public final AbstractC3630<T> share() {
        return publish().m11940();
    }

    public final AbstractC4838<T> single(T t) {
        C4246.m13353(t, "defaultItem is null");
        return C3671.m11800(new C3626(this, t));
    }

    public final AbstractC4274<T> singleElement() {
        return C3671.m11797(new C4992(this));
    }

    public final AbstractC4838<T> singleOrError() {
        return C3671.m11800(new C3626(this, null));
    }

    public final AbstractC3630<T> skip(long j) {
        return j <= 0 ? C3671.m11796(this) : C3671.m11796(new C2586(this, j));
    }

    public final AbstractC3630<T> skipLast(int i) {
        if (i >= 0) {
            return i == 0 ? C3671.m11796(this) : C3671.m11796(new FlowableSkipLast(this, i));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    public final <U> AbstractC3630<T> skipUntil(Publisher<U> publisher) {
        C4246.m13353(publisher, "other is null");
        return C3671.m11796(new FlowableSkipUntil(this, publisher));
    }

    public final AbstractC3630<T> skipWhile(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11796(new C5039(this, interfaceC4178));
    }

    public final AbstractC3630<T> sorted() {
        return toList().toFlowable().map(Functions.m6326(Functions.m6327())).flatMapIterable(Functions.m6322());
    }

    public final AbstractC3630<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final AbstractC3630<T> startWithArray(T... tArr) {
        AbstractC3630 abstractC3630FromArray = fromArray(tArr);
        return abstractC3630FromArray == empty() ? C3671.m11796(this) : concatArray(abstractC3630FromArray, this);
    }

    public final InterfaceC4478 subscribe() {
        return subscribe(Functions.m6320(), Functions.f6801, Functions.f6798, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public abstract void subscribeActual(Subscriber<? super T> subscriber);

    public final AbstractC3630<T> subscribeOn(AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return subscribeOn(abstractC4585, !(this instanceof FlowableCreate));
    }

    public final <E extends Subscriber<? super T>> E subscribeWith(E e2) {
        subscribe(e2);
        return e2;
    }

    public final AbstractC3630<T> switchIfEmpty(Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "other is null");
        return C3671.m11796(new C4468(this, publisher));
    }

    public final <R> AbstractC3630<R> switchMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368) {
        return switchMap(interfaceC2368, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <R> AbstractC3630<R> switchMap0(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, boolean z) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "bufferSize");
        if (!(this instanceof InterfaceCallableC5143)) {
            return C3671.m11796(new FlowableSwitchMap(this, interfaceC2368, i, z));
        }
        Object objCall = ((InterfaceCallableC5143) this).call();
        return objCall == null ? empty() : C2930.m10332(objCall, interfaceC2368);
    }

    public final AbstractC2900 switchMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11793(new FlowableSwitchMapCompletable(this, interfaceC2368, false));
    }

    public final AbstractC2900 switchMapCompletableDelayError(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11793(new FlowableSwitchMapCompletable(this, interfaceC2368, true));
    }

    public final <R> AbstractC3630<R> switchMapDelayError(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368) {
        return switchMapDelayError(interfaceC2368, bufferSize());
    }

    public final <R> AbstractC3630<R> switchMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11796(new FlowableSwitchMapMaybe(this, interfaceC2368, false));
    }

    public final <R> AbstractC3630<R> switchMapMaybeDelayError(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11796(new FlowableSwitchMapMaybe(this, interfaceC2368, true));
    }

    public final <R> AbstractC3630<R> switchMapSingle(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11796(new FlowableSwitchMapSingle(this, interfaceC2368, false));
    }

    public final <R> AbstractC3630<R> switchMapSingleDelayError(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11796(new FlowableSwitchMapSingle(this, interfaceC2368, true));
    }

    public final AbstractC3630<T> take(long j) {
        if (j >= 0) {
            return C3671.m11796(new FlowableTake(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public final AbstractC3630<T> takeLast(int i) {
        if (i >= 0) {
            return i == 0 ? C3671.m11796(new C5281(this)) : i == 1 ? C3671.m11796(new FlowableTakeLastOne(this)) : C3671.m11796(new FlowableTakeLast(this, i));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    public final AbstractC3630<T> takeUntil(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "stopPredicate is null");
        return C3671.m11796(new C2458(this, interfaceC4178));
    }

    public final AbstractC3630<T> takeWhile(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11796(new C2767(this, interfaceC4178));
    }

    public final TestSubscriber<T> test() {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>();
        subscribe((InterfaceC3899) testSubscriber);
        return testSubscriber;
    }

    public final AbstractC3630<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, C4877.m14600());
    }

    public final AbstractC3630<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    public final AbstractC3630<T> throttleLatest(long j, TimeUnit timeUnit) {
        return throttleLatest(j, timeUnit, C4877.m14600(), false);
    }

    public final AbstractC3630<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    public final AbstractC3630<o2<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, C4877.m14600());
    }

    public final <V> AbstractC3630<T> timeout(InterfaceC2368<? super T, ? extends Publisher<V>> interfaceC2368) {
        return timeout0(null, interfaceC2368, null);
    }

    public final AbstractC3630<o2<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, C4877.m14600());
    }

    public final <R> R to(InterfaceC2368<? super AbstractC3630<T>, R> interfaceC2368) {
        try {
            return (R) ((InterfaceC2368) C4246.m13353(interfaceC2368, "converter is null")).apply(this);
        } catch (Throwable th) {
            C4089.m13026(th);
            throw ExceptionHelper.m7024(th);
        }
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureC5219());
    }

    public final AbstractC4838<List<T>> toList() {
        return C3671.m11800(new C3431(this));
    }

    public final <K> AbstractC4838<Map<K, T>> toMap(InterfaceC2368<? super T, ? extends K> interfaceC2368) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        return (AbstractC4838<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.m6343(interfaceC2368));
    }

    public final <K> AbstractC4838<Map<K, Collection<T>>> toMultimap(InterfaceC2368<? super T, ? extends K> interfaceC2368) {
        return (AbstractC4838<Map<K, Collection<T>>>) toMultimap(interfaceC2368, Functions.m6322(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final AbstractC4262<T> toObservable() {
        return C3671.m11798(new C5257(this));
    }

    public final AbstractC4838<List<T>> toSortedList() {
        return toSortedList(Functions.m6327());
    }

    public final AbstractC3630<T> unsubscribeOn(AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableUnsubscribeOn(this, abstractC4585));
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    public final <U, R> AbstractC3630<R> withLatestFrom(Publisher<? extends U> publisher, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        C4246.m13353(publisher, "other is null");
        C4246.m13353(interfaceC5247, "combiner is null");
        return C3671.m11796(new FlowableWithLatestFrom(this, interfaceC5247, publisher));
    }

    public final <U, R> AbstractC3630<R> zipWith(Iterable<U> iterable, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        C4246.m13353(iterable, "other is null");
        C4246.m13353(interfaceC5247, "zipper is null");
        return C3671.m11796(new C4075(this, iterable, interfaceC5247));
    }

    public static <T, R> AbstractC3630<R> combineLatest(InterfaceC2368<? super Object[], ? extends R> interfaceC2368, Publisher<? extends T>... publisherArr) {
        return combineLatest(publisherArr, interfaceC2368, bufferSize());
    }

    public static <T, R> AbstractC3630<R> combineLatestDelayError(InterfaceC2368<? super Object[], ? extends R> interfaceC2368, Publisher<? extends T>... publisherArr) {
        return combineLatestDelayError(publisherArr, interfaceC2368, bufferSize());
    }

    public static <T> AbstractC3630<T> concatArrayEager(int i, int i2, Publisher<? extends T>... publisherArr) {
        C4246.m13353(publisherArr, "sources is null");
        C4246.m13354(i, "maxConcurrency");
        C4246.m13354(i2, "prefetch");
        return C3671.m11796(new FlowableConcatMapEager(new FlowableFromArray(publisherArr), Functions.m6322(), i, i2, ErrorMode.IMMEDIATE));
    }

    public static <T> AbstractC3630<T> concatArrayEagerDelayError(int i, int i2, Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).concatMapEagerDelayError(Functions.m6322(), i, i2, true);
    }

    public static <T> AbstractC3630<T> concatEager(Publisher<? extends Publisher<? extends T>> publisher, int i, int i2) {
        C4246.m13353(publisher, "sources is null");
        C4246.m13354(i, "maxConcurrency");
        C4246.m13354(i2, "prefetch");
        return C3671.m11796(new C2064(publisher, Functions.m6322(), i, i2, ErrorMode.IMMEDIATE));
    }

    public static AbstractC3630<Long> interval(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, abstractC4585));
    }

    public static AbstractC3630<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        if (j2 < 0) {
            throw new IllegalArgumentException("count >= 0 required but it was " + j2);
        }
        if (j2 == 0) {
            return empty().delay(j3, timeUnit, abstractC4585);
        }
        long j5 = j + (j2 - 1);
        if (j > 0 && j5 < 0) {
            throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
        }
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableIntervalRange(j, j5, Math.max(0L, j3), Math.max(0L, j4), timeUnit, abstractC4585));
    }

    public static <T> AbstractC3630<T> merge(Iterable<? extends Publisher<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.m6322());
    }

    public static <T> AbstractC3630<T> mergeArray(Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.m6322(), publisherArr.length);
    }

    public static <T> AbstractC3630<T> mergeArrayDelayError(Publisher<? extends T>... publisherArr) {
        return fromArray(publisherArr).flatMap(Functions.m6322(), true, publisherArr.length);
    }

    public static <T> AbstractC3630<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.m6322(), true, i, i2);
    }

    public static <T> AbstractC4838<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, InterfaceC5324<? super T, ? super T> interfaceC5324) {
        return sequenceEqual(publisher, publisher2, interfaceC5324, bufferSize());
    }

    public static <T> AbstractC3630<T> switchOnNext(Publisher<? extends Publisher<? extends T>> publisher) {
        return fromPublisher(publisher).switchMap(Functions.m6322());
    }

    public static <T> AbstractC3630<T> switchOnNextDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).switchMapDelayError(Functions.m6322(), i);
    }

    public static AbstractC3630<Long> timer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableTimer(Math.max(0L, j), timeUnit, abstractC4585));
    }

    public static <T, D> AbstractC3630<T> using(Callable<? extends D> callable, InterfaceC2368<? super D, ? extends Publisher<? extends T>> interfaceC2368, InterfaceC2857<? super D> interfaceC2857, boolean z) {
        C4246.m13353(callable, "resourceSupplier is null");
        C4246.m13353(interfaceC2368, "sourceSupplier is null");
        C4246.m13353(interfaceC2857, "resourceDisposer is null");
        return C3671.m11796(new FlowableUsing(callable, interfaceC2368, interfaceC2857, z));
    }

    public final Iterable<T> blockingIterable(int i) {
        C4246.m13354(i, "bufferSize");
        return new BlockingFlowableIterable(this, i);
    }

    public final T blockingSingle(T t) {
        return single(t).blockingGet();
    }

    public final void blockingSubscribe(InterfaceC2857<? super T> interfaceC2857) {
        C3497.m11415(this, interfaceC2857, Functions.f6801, Functions.f6798);
    }

    public final AbstractC3630<List<T>> buffer(int i, int i2) {
        return (AbstractC3630<List<T>>) buffer(i, i2, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> AbstractC3630<R> concatMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        if (!(this instanceof InterfaceCallableC5143)) {
            return C3671.m11796(new FlowableConcatMap(this, interfaceC2368, i, ErrorMode.IMMEDIATE));
        }
        Object objCall = ((InterfaceCallableC5143) this).call();
        return objCall == null ? empty() : C2930.m10332(objCall, interfaceC2368);
    }

    public final AbstractC2900 concatMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11793(new FlowableConcatMapCompletable(this, interfaceC2368, ErrorMode.IMMEDIATE, i));
    }

    public final AbstractC2900 concatMapCompletableDelayError(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
        return concatMapCompletableDelayError(interfaceC2368, z, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> AbstractC3630<R> concatMapDelayError(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, boolean z) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        if (!(this instanceof InterfaceCallableC5143)) {
            return C3671.m11796(new FlowableConcatMap(this, interfaceC2368, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        Object objCall = ((InterfaceCallableC5143) this).call();
        return objCall == null ? empty() : C2930.m10332(objCall, interfaceC2368);
    }

    public final <R> AbstractC3630<R> concatMapEager(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, int i2) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "maxConcurrency");
        C4246.m13354(i2, "prefetch");
        return C3671.m11796(new FlowableConcatMapEager(this, interfaceC2368, i, i2, ErrorMode.IMMEDIATE));
    }

    public final <R> AbstractC3630<R> concatMapEagerDelayError(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i, int i2, boolean z) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "maxConcurrency");
        C4246.m13354(i2, "prefetch");
        return C3671.m11796(new FlowableConcatMapEager(this, interfaceC2368, i, i2, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public final <U> AbstractC3630<U> concatMapIterable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11796(new FlowableFlattenIterable(this, interfaceC2368, i));
    }

    public final <R> AbstractC3630<R> concatMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11796(new FlowableConcatMapMaybe(this, interfaceC2368, ErrorMode.IMMEDIATE, i));
    }

    public final <R> AbstractC3630<R> concatMapMaybeDelayError(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z) {
        return concatMapMaybeDelayError(interfaceC2368, z, 2);
    }

    public final <R> AbstractC3630<R> concatMapSingle(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11796(new FlowableConcatMapSingle(this, interfaceC2368, ErrorMode.IMMEDIATE, i));
    }

    public final <R> AbstractC3630<R> concatMapSingleDelayError(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z) {
        return concatMapSingleDelayError(interfaceC2368, z, 2);
    }

    public final <R> AbstractC3630<R> dematerialize(InterfaceC2368<? super T, C3906<R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "selector is null");
        return C3671.m11796(new C5286(this, interfaceC2368));
    }

    public final <K> AbstractC3630<T> distinct(InterfaceC2368<? super T, K> interfaceC2368) {
        return distinct(interfaceC2368, Functions.m6319());
    }

    public final <K> AbstractC3630<T> distinctUntilChanged(InterfaceC2368<? super T, K> interfaceC2368) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        return C3671.m11796(new C5116(this, interfaceC2368, C4246.m13352()));
    }

    public final <R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, boolean z) {
        return flatMap(interfaceC2368, z, bufferSize(), bufferSize());
    }

    public final AbstractC2900 flatMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "maxConcurrency");
        return C3671.m11793(new FlowableFlatMapCompletableCompletable(this, interfaceC2368, z, i));
    }

    public final <U> AbstractC3630<U> flatMapIterable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableFlattenIterable(this, interfaceC2368, i));
    }

    public final <R> AbstractC3630<R> flatMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "maxConcurrency");
        return C3671.m11796(new FlowableFlatMapMaybe(this, interfaceC2368, z, i));
    }

    public final <R> AbstractC3630<R> flatMapSingle(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "maxConcurrency");
        return C3671.m11796(new FlowableFlatMapSingle(this, interfaceC2368, z, i));
    }

    public final InterfaceC4478 forEachWhile(InterfaceC4178<? super T> interfaceC4178, InterfaceC2857<? super Throwable> interfaceC2857) {
        return forEachWhile(interfaceC4178, interfaceC2857, Functions.f6798);
    }

    public final <K> AbstractC3630<AbstractC2965<K, T>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368, boolean z) {
        return (AbstractC3630<AbstractC2965<K, T>>) groupBy(interfaceC2368, Functions.m6322(), z, bufferSize());
    }

    public final AbstractC3630<T> observeOn(AbstractC4585 abstractC4585, boolean z) {
        return observeOn(abstractC4585, z, bufferSize());
    }

    public final AbstractC3630<T> onBackpressureBuffer(boolean z) {
        return onBackpressureBuffer(bufferSize(), z, true);
    }

    public final AbstractC3630<T> onBackpressureDrop(InterfaceC2857<? super T> interfaceC2857) {
        C4246.m13353(interfaceC2857, "onDrop is null");
        return C3671.m11796(new FlowableOnBackpressureDrop(this, interfaceC2857));
    }

    public final AbstractC2624<T> parallel(int i) {
        C4246.m13354(i, "parallelism");
        return AbstractC2624.m9584(this, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> AbstractC3630<R> publish(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368) {
        return publish(interfaceC2368, bufferSize());
    }

    public final AbstractC3630<T> repeat(long j) {
        if (j >= 0) {
            return j == 0 ? empty() : C3671.m11796(new FlowableRepeat(this, j));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final <R> AbstractC3630<R> replay(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "selector is null");
        return FlowableReplay.m6590(FlowableInternalHelper.m6493(this), interfaceC2368);
    }

    public final AbstractC3630<T> retry(InterfaceC5324<? super Integer, ? super Throwable> interfaceC5324) {
        C4246.m13353(interfaceC5324, "predicate is null");
        return C3671.m11796(new FlowableRetryBiPredicate(this, interfaceC5324));
    }

    public final AbstractC3630<T> sample(long j, TimeUnit timeUnit, boolean z) {
        return sample(j, timeUnit, C4877.m14600(), z);
    }

    public final AbstractC3630<T> sorted(Comparator<? super T> comparator) {
        C4246.m13353(comparator, "sortFunction");
        return toList().toFlowable().map(Functions.m6326(comparator)).flatMapIterable(Functions.m6322());
    }

    public final AbstractC3630<T> startWith(Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "other is null");
        return concatArray(publisher, this);
    }

    public final InterfaceC4478 subscribe(InterfaceC2857<? super T> interfaceC2857) {
        return subscribe(interfaceC2857, Functions.f6801, Functions.f6798, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public final <R> AbstractC3630<R> switchMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i) {
        return switchMap0(interfaceC2368, i, false);
    }

    public final <R> AbstractC3630<R> switchMapDelayError(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i) {
        return switchMap0(interfaceC2368, i, true);
    }

    public final AbstractC3630<T> throttleFirst(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableThrottleFirstTimed(this, j, timeUnit, abstractC4585));
    }

    public final AbstractC3630<T> throttleLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return sample(j, timeUnit, abstractC4585);
    }

    public final AbstractC3630<T> throttleLatest(long j, TimeUnit timeUnit, boolean z) {
        return throttleLatest(j, timeUnit, C4877.m14600(), z);
    }

    public final AbstractC3630<T> throttleWithTimeout(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return debounce(j, timeUnit, abstractC4585);
    }

    public final AbstractC3630<o2<T>> timeInterval(AbstractC4585 abstractC4585) {
        return timeInterval(TimeUnit.MILLISECONDS, abstractC4585);
    }

    public final <V> AbstractC3630<T> timeout(InterfaceC2368<? super T, ? extends Publisher<V>> interfaceC2368, AbstractC3630<? extends T> abstractC3630) {
        C4246.m13353(abstractC3630, "other is null");
        return timeout0(null, interfaceC2368, abstractC3630);
    }

    public final AbstractC3630<o2<T>> timestamp(AbstractC4585 abstractC4585) {
        return timestamp(TimeUnit.MILLISECONDS, abstractC4585);
    }

    public final AbstractC4838<List<T>> toList(int i) {
        C4246.m13354(i, "capacityHint");
        return C3671.m11800(new C3431(this, Functions.m6318(i)));
    }

    public final AbstractC4838<List<T>> toSortedList(Comparator<? super T> comparator) {
        C4246.m13353(comparator, "comparator is null");
        return (AbstractC4838<List<T>>) toList().map(Functions.m6326(comparator));
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    public static <T, R> AbstractC3630<R> combineLatest(Publisher<? extends T>[] publisherArr, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i) {
        C4246.m13353(publisherArr, "sources is null");
        if (publisherArr.length == 0) {
            return empty();
        }
        C4246.m13353(interfaceC2368, "combiner is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableCombineLatest((Publisher[]) publisherArr, (InterfaceC2368) interfaceC2368, i, false));
    }

    public static <T, R> AbstractC3630<R> combineLatestDelayError(InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, Publisher<? extends T>... publisherArr) {
        return combineLatestDelayError(publisherArr, interfaceC2368, i);
    }

    public static <T> AbstractC3630<T> concat(Publisher<? extends Publisher<? extends T>> publisher) {
        return concat(publisher, bufferSize());
    }

    public static <T> AbstractC3630<T> concatDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return concatDelayError(publisher, bufferSize(), true);
    }

    public static <T> AbstractC3630<T> error(Throwable th) {
        C4246.m13353(th, "throwable is null");
        return error((Callable<? extends Throwable>) Functions.m6324(th));
    }

    public static <T> AbstractC3630<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        C4246.m13353(future, "future is null");
        C4246.m13353(timeUnit, "unit is null");
        return C3671.m11796(new C3087(future, j, timeUnit));
    }

    public static <T> AbstractC3630<T> just(T t, T t2) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        return fromArray(t, t2);
    }

    public static <T> AbstractC3630<T> merge(Iterable<? extends Publisher<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.m6322(), i);
    }

    public static <T> AbstractC3630<T> mergeDelayError(Iterable<? extends Publisher<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.m6322(), true, i);
    }

    public static <T> AbstractC4838<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, InterfaceC5324<? super T, ? super T> interfaceC5324, int i) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(interfaceC5324, "isEqual is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11800(new FlowableSequenceEqualSingle(publisher, publisher2, interfaceC5324, i));
    }

    public final void blockingSubscribe(InterfaceC2857<? super T> interfaceC2857, int i) {
        C3497.m11416(this, interfaceC2857, Functions.f6801, Functions.f6798, i);
    }

    public final <U extends Collection<? super T>> AbstractC3630<U> buffer(int i, int i2, Callable<U> callable) {
        C4246.m13354(i, "count");
        C4246.m13354(i2, "skip");
        C4246.m13353(callable, "bufferSupplier is null");
        return C3671.m11796(new FlowableBuffer(this, i, i2, callable));
    }

    public final AbstractC2900 concatMapCompletableDelayError(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11793(new FlowableConcatMapCompletable(this, interfaceC2368, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    public final <R> AbstractC3630<R> concatMapMaybeDelayError(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11796(new FlowableConcatMapMaybe(this, interfaceC2368, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    public final <R> AbstractC3630<R> concatMapSingleDelayError(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11796(new FlowableConcatMapSingle(this, interfaceC2368, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    public final AbstractC3630<T> concatWith(InterfaceC3951<? extends T> interfaceC3951) {
        C4246.m13353(interfaceC3951, "other is null");
        return C3671.m11796(new FlowableConcatWithSingle(this, interfaceC3951));
    }

    public final AbstractC3630<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, C4877.m14600());
    }

    public final AbstractC3630<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, C4877.m14600(), false);
    }

    public final AbstractC3630<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, C4877.m14600());
    }

    public final <K> AbstractC3630<T> distinct(InterfaceC2368<? super T, K> interfaceC2368, Callable<? extends Collection<? super K>> callable) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(callable, "collectionSupplier is null");
        return C3671.m11796(new C4325(this, interfaceC2368, callable));
    }

    public final AbstractC4838<T> elementAt(long j, T t) {
        if (j >= 0) {
            C4246.m13353(t, "defaultItem is null");
            return C3671.m11800(new C3125(this, j, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final <R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, int i) {
        return flatMap((InterfaceC2368) interfaceC2368, false, i, bufferSize());
    }

    public final InterfaceC4478 forEachWhile(InterfaceC4178<? super T> interfaceC4178, InterfaceC2857<? super Throwable> interfaceC2857, InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC4178, "onNext is null");
        C4246.m13353(interfaceC2857, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        ForEachWhileSubscriber forEachWhileSubscriber = new ForEachWhileSubscriber(interfaceC4178, interfaceC2857, interfaceC3809);
        subscribe((InterfaceC3899) forEachWhileSubscriber);
        return forEachWhileSubscriber;
    }

    public final <K, V> AbstractC3630<AbstractC2965<K, V>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682) {
        return groupBy(interfaceC2368, interfaceC23682, false, bufferSize());
    }

    public final AbstractC3630<T> mergeWith(InterfaceC3951<? extends T> interfaceC3951) {
        C4246.m13353(interfaceC3951, "other is null");
        return C3671.m11796(new FlowableMergeWithSingle(this, interfaceC3951));
    }

    public final AbstractC3630<T> observeOn(AbstractC4585 abstractC4585, boolean z, int i) {
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableObserveOn(this, abstractC4585, z, i));
    }

    public final AbstractC3630<T> onBackpressureBuffer(int i) {
        return onBackpressureBuffer(i, false, false);
    }

    public final AbstractC3630<T> onErrorResumeNext(Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "next is null");
        return onErrorResumeNext(Functions.m6325(publisher));
    }

    public final <R> AbstractC3630<R> publish(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<? extends R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11796(new FlowablePublishMulticast(this, interfaceC2368, i, false));
    }

    public final <R> AbstractC4838<R> reduce(R r, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        C4246.m13353(r, "seed is null");
        C4246.m13353(interfaceC5247, "reducer is null");
        return C3671.m11800(new C3127(this, r, interfaceC5247));
    }

    public final AbstractC3630<T> sample(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableSampleTimed(this, j, timeUnit, abstractC4585, false));
    }

    public final <R> AbstractC3630<R> scan(R r, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        C4246.m13353(r, "initialValue is null");
        return scanWith(Functions.m6324(r), interfaceC5247);
    }

    public final AbstractC3630<T> skip(long j, TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    public final InterfaceC4478 subscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572) {
        return subscribe(interfaceC2857, interfaceC28572, Functions.f6798, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public final AbstractC3630<T> subscribeOn(AbstractC4585 abstractC4585, boolean z) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableSubscribeOn(this, abstractC4585, z));
    }

    public final AbstractC3630<T> take(long j, TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    public final <U> AbstractC3630<T> takeUntil(Publisher<U> publisher) {
        C4246.m13353(publisher, "other is null");
        return C3671.m11796(new FlowableTakeUntil(this, publisher));
    }

    public final TestSubscriber<T> test(long j) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j);
        subscribe((InterfaceC3899) testSubscriber);
        return testSubscriber;
    }

    public final AbstractC3630<T> throttleLatest(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return throttleLatest(j, timeUnit, abstractC4585, false);
    }

    public final AbstractC3630<o2<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, C4877.m14600());
    }

    public final AbstractC3630<o2<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, C4877.m14600());
    }

    public final <K, V> AbstractC4838<Map<K, V>> toMap(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(interfaceC23682, "valueSelector is null");
        return (AbstractC4838<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.m6344(interfaceC2368, interfaceC23682));
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, long j2, int i) {
        C4246.m13355(j2, "skip");
        C4246.m13355(j, "count");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableWindow(this, j, j2, i));
    }

    public static <T, R> AbstractC3630<R> combineLatestDelayError(Publisher<? extends T>[] publisherArr, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i) {
        C4246.m13353(publisherArr, "sources is null");
        C4246.m13353(interfaceC2368, "combiner is null");
        C4246.m13354(i, "bufferSize");
        if (publisherArr.length == 0) {
            return empty();
        }
        return C3671.m11796(new FlowableCombineLatest((Publisher[]) publisherArr, (InterfaceC2368) interfaceC2368, i, true));
    }

    public static <T> AbstractC3630<T> concat(Publisher<? extends Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).concatMap(Functions.m6322(), i);
    }

    public static <T> AbstractC3630<T> concatDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i, boolean z) {
        return fromPublisher(publisher).concatMapDelayError(Functions.m6322(), i, z);
    }

    public static <T> AbstractC3630<T> merge(Publisher<? extends Publisher<? extends T>> publisher) {
        return merge(publisher, bufferSize());
    }

    public static <T> AbstractC3630<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> publisher) {
        return mergeDelayError(publisher, bufferSize());
    }

    private <U, V> AbstractC3630<T> timeout0(Publisher<U> publisher, InterfaceC2368<? super T, ? extends Publisher<V>> interfaceC2368, Publisher<? extends T> publisher2) {
        C4246.m13353(interfaceC2368, "itemTimeoutIndicator is null");
        return C3671.m11796(new FlowableTimeout(this, publisher, interfaceC2368, publisher2));
    }

    public static <T, R> AbstractC3630<R> zip(Publisher<? extends Publisher<? extends T>> publisher, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        C4246.m13353(interfaceC2368, "zipper is null");
        return fromPublisher(publisher).toList().flatMapPublisher(FlowableInternalHelper.m6503(interfaceC2368));
    }

    public final void blockingSubscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572) {
        C3497.m11415(this, interfaceC2857, interfaceC28572, Functions.f6798);
    }

    public final AbstractC3630<T> debounce(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableDebounceTimed(this, j, timeUnit, abstractC4585));
    }

    public final AbstractC3630<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, C4877.m14600(), z);
    }

    public final AbstractC3630<T> delaySubscription(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return delaySubscription(timer(j, timeUnit, abstractC4585));
    }

    public final AbstractC3630<T> distinctUntilChanged(InterfaceC5324<? super T, ? super T> interfaceC5324) {
        C4246.m13353(interfaceC5324, "comparer is null");
        return C3671.m11796(new C5116(this, Functions.m6322(), interfaceC5324));
    }

    public final <R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, boolean z, int i) {
        return flatMap(interfaceC2368, z, i, bufferSize());
    }

    public final <K, V> AbstractC3630<AbstractC2965<K, V>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, boolean z) {
        return groupBy(interfaceC2368, interfaceC23682, z, bufferSize());
    }

    public final AbstractC3630<T> onBackpressureBuffer(int i, boolean z) {
        return onBackpressureBuffer(i, z, false);
    }

    public final AbstractC2624<T> parallel(int i, int i2) {
        C4246.m13354(i, "parallelism");
        C4246.m13354(i2, "prefetch");
        return AbstractC2624.m9585(this, i, i2);
    }

    public final <R> AbstractC3630<R> replay(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13354(i, "bufferSize");
        return FlowableReplay.m6590(FlowableInternalHelper.m6494(this, i), interfaceC2368);
    }

    public final AbstractC3630<T> retry(long j) {
        return retry(j, Functions.m6315());
    }

    public final AbstractC3630<T> skip(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return skipUntil(timer(j, timeUnit, abstractC4585));
    }

    public final AbstractC3630<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, C4877.m14600(), false, bufferSize());
    }

    public final AbstractC3630<T> startWith(T t) {
        C4246.m13353(t, "value is null");
        return concatArray(just(t), this);
    }

    public final InterfaceC4478 subscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809) {
        return subscribe(interfaceC2857, interfaceC28572, interfaceC3809, FlowableInternalHelper.RequestMax.INSTANCE);
    }

    public final AbstractC3630<T> take(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return takeUntil(timer(j, timeUnit, abstractC4585));
    }

    public final AbstractC3630<T> throttleLatest(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableThrottleLatest(this, j, timeUnit, abstractC4585, z));
    }

    public final AbstractC3630<o2<T>> timeInterval(TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new C5264(this, timeUnit, abstractC4585));
    }

    public final AbstractC3630<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, null, C4877.m14600());
    }

    public final AbstractC3630<o2<T>> timestamp(TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return (AbstractC3630<o2<T>>) map(Functions.m6334(timeUnit, abstractC4585));
    }

    public final <U extends Collection<? super T>> AbstractC4838<U> toList(Callable<U> callable) {
        C4246.m13353(callable, "collectionSupplier is null");
        return C3671.m11800(new C3431(this, callable));
    }

    public final AbstractC4838<List<T>> toSortedList(Comparator<? super T> comparator, int i) {
        C4246.m13353(comparator, "comparator is null");
        return (AbstractC4838<List<T>>) toList(i).map(Functions.m6326(comparator));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, R> AbstractC3630<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, InterfaceC3482<? super T, ? super T1, ? super T2, R> interfaceC3482) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        return withLatestFrom((Publisher<?>[]) new Publisher[]{publisher, publisher2}, Functions.m6336(interfaceC3482));
    }

    public final <U, R> AbstractC3630<R> zipWith(Publisher<? extends U> publisher, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        C4246.m13353(publisher, "other is null");
        return zip(this, publisher, interfaceC5247);
    }

    public static <T> AbstractC3630<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        return concatArray(publisher, publisher2);
    }

    public static AbstractC3630<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, C4877.m14600());
    }

    public static <T> AbstractC3630<T> merge(Publisher<? extends Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).flatMap(Functions.m6322(), i);
    }

    public static <T> AbstractC3630<T> mergeDelayError(Publisher<? extends Publisher<? extends T>> publisher, int i) {
        return fromPublisher(publisher).flatMap(Functions.m6322(), true, i);
    }

    public final T blockingFirst(T t) throws InterruptedException {
        C2345 c2345 = new C2345();
        subscribe((InterfaceC3899) c2345);
        T tM11413 = c2345.m11413();
        return tM11413 != null ? tM11413 : t;
    }

    public final T blockingLast(T t) throws InterruptedException {
        C2792 c2792 = new C2792();
        subscribe((InterfaceC3899) c2792);
        T tM11413 = c2792.m11413();
        return tM11413 != null ? tM11413 : t;
    }

    public final void blockingSubscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, int i) {
        C3497.m11416(this, interfaceC2857, interfaceC28572, Functions.f6798, i);
    }

    public final AbstractC3630<T> concatWith(InterfaceC3517<? extends T> interfaceC3517) {
        C4246.m13353(interfaceC3517, "other is null");
        return C3671.m11796(new FlowableConcatWithMaybe(this, interfaceC3517));
    }

    public final AbstractC3630<T> delay(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return delay(j, timeUnit, abstractC4585, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, boolean z, int i, int i2) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "maxConcurrency");
        C4246.m13354(i2, "bufferSize");
        if (this instanceof InterfaceCallableC5143) {
            Object objCall = ((InterfaceCallableC5143) this).call();
            if (objCall == null) {
                return empty();
            }
            return C2930.m10332(objCall, interfaceC2368);
        }
        return C3671.m11796(new FlowableFlatMap(this, interfaceC2368, z, i, i2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> AbstractC3630<V> flatMapIterable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends V> interfaceC5247) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13353(interfaceC5247, "resultSelector is null");
        return (AbstractC3630<V>) flatMap(FlowableInternalHelper.m6490(interfaceC2368), interfaceC5247, false, bufferSize(), bufferSize());
    }

    public final <K, V> AbstractC3630<AbstractC2965<K, V>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, boolean z, int i) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(interfaceC23682, "valueSelector is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableGroupBy(this, interfaceC2368, interfaceC23682, i, z, null));
    }

    public final AbstractC3630<T> mergeWith(InterfaceC3517<? extends T> interfaceC3517) {
        C4246.m13353(interfaceC3517, "other is null");
        return C3671.m11796(new FlowableMergeWithMaybe(this, interfaceC3517));
    }

    public final AbstractC3630<T> onBackpressureBuffer(int i, boolean z, boolean z2) {
        C4246.m13354(i, "capacity");
        return C3671.m11796(new FlowableOnBackpressureBuffer(this, i, z2, z, Functions.f6798));
    }

    public final AbstractC3630<T> retry(long j, InterfaceC4178<? super Throwable> interfaceC4178) {
        if (j >= 0) {
            C4246.m13353(interfaceC4178, "predicate is null");
            return C3671.m11796(new FlowableRetryPredicate(this, j, interfaceC4178));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final AbstractC3630<T> skipLast(long j, TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, C4877.m14600(), z, bufferSize());
    }

    public final InterfaceC4478 subscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC2857<? super Subscription> interfaceC28573) {
        C4246.m13353(interfaceC2857, "onNext is null");
        C4246.m13353(interfaceC28572, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        C4246.m13353(interfaceC28573, "onSubscribe is null");
        LambdaSubscriber lambdaSubscriber = new LambdaSubscriber(interfaceC2857, interfaceC28572, interfaceC3809, interfaceC28573);
        subscribe((InterfaceC3899) lambdaSubscriber);
        return lambdaSubscriber;
    }

    public final AbstractC3630<T> takeLast(long j, long j2, TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, C4877.m14600(), false, bufferSize());
    }

    public final TestSubscriber<T> test(long j, boolean z) {
        TestSubscriber<T> testSubscriber = new TestSubscriber<>(j);
        if (z) {
            testSubscriber.cancel();
        }
        subscribe((InterfaceC3899) testSubscriber);
        return testSubscriber;
    }

    public final AbstractC3630<T> timeout(long j, TimeUnit timeUnit, Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "other is null");
        return timeout0(j, timeUnit, publisher, C4877.m14600());
    }

    public final <K, V> AbstractC4838<Map<K, Collection<V>>> toMultimap(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682) {
        return toMultimap(interfaceC2368, interfaceC23682, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public static <T> AbstractC3630<T> concatEager(Iterable<? extends Publisher<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> AbstractC3630<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(abstractC4585);
    }

    public static <T, S> AbstractC3630<T> generate(Callable<S> callable, InterfaceC5246<S, InterfaceC3487<T>> interfaceC5246) {
        C4246.m13353(interfaceC5246, "generator is null");
        return generate(callable, FlowableInternalHelper.m6498(interfaceC5246), Functions.m6320());
    }

    public static AbstractC3630<Long> interval(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return interval(j, j, timeUnit, abstractC4585);
    }

    public static <T> AbstractC3630<T> just(T t, T t2, T t3) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        return fromArray(t, t2, t3);
    }

    public static <T> AbstractC3630<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        return fromArray(publisher, publisher2).flatMap(Functions.m6322(), false, 2);
    }

    public static <T> AbstractC3630<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        return fromArray(publisher, publisher2).flatMap(Functions.m6322(), true, 2);
    }

    public static <T1, T2, R> AbstractC3630<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        return zipArray(Functions.m6335(interfaceC5247), false, bufferSize(), publisher, publisher2);
    }

    public final void blockingSubscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809) {
        C3497.m11415(this, interfaceC2857, interfaceC28572, interfaceC3809);
    }

    public final AbstractC3630<T> delay(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new C2912(this, Math.max(0L, j), timeUnit, abstractC4585, z));
    }

    public final AbstractC3630<T> doOnEach(InterfaceC2857<? super C3906<T>> interfaceC2857) {
        C4246.m13353(interfaceC2857, "onNotification is null");
        return doOnEach(Functions.m6331(interfaceC2857), Functions.m6330(interfaceC2857), Functions.m6329(interfaceC2857), Functions.f6798);
    }

    public final AbstractC3731<T> publish(int i) {
        C4246.m13354(i, "bufferSize");
        return FlowablePublish.m6549(this, i);
    }

    public final AbstractC3630<T> sample(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11796(new FlowableSampleTimed(this, j, timeUnit, abstractC4585, z));
    }

    public final AbstractC3630<T> skipLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return skipLast(j, timeUnit, abstractC4585, false, bufferSize());
    }

    public final AbstractC3630<T> takeLast(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return takeLast(j, j2, timeUnit, abstractC4585, false, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> AbstractC4838<Map<K, V>> toMap(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, Callable<? extends Map<K, V>> callable) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(interfaceC23682, "valueSelector is null");
        return (AbstractC4838<Map<K, V>>) collect(callable, Functions.m6344(interfaceC2368, interfaceC23682));
    }

    public final AbstractC4838<List<T>> toSortedList(int i) {
        return toSortedList(Functions.m6327(), i);
    }

    public final <U, R> AbstractC3630<R> zipWith(Publisher<? extends U> publisher, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, boolean z) {
        return zip(this, publisher, interfaceC5247, z);
    }

    public static <T> AbstractC3630<T> concatEager(Iterable<? extends Publisher<? extends T>> iterable, int i, int i2) {
        C4246.m13353(iterable, "sources is null");
        C4246.m13354(i, "maxConcurrency");
        C4246.m13354(i2, "prefetch");
        return C3671.m11796(new FlowableConcatMapEager(new FlowableFromIterable(iterable), Functions.m6322(), i, i2, ErrorMode.IMMEDIATE));
    }

    public final void blockingSubscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, int i) {
        C3497.m11416(this, interfaceC2857, interfaceC28572, interfaceC3809, i);
    }

    public final <U extends Collection<? super T>> AbstractC3630<U> buffer(int i, Callable<U> callable) {
        return buffer(i, i, callable);
    }

    public final AbstractC3630<T> concatWith(InterfaceC2837 interfaceC2837) {
        C4246.m13353(interfaceC2837, "other is null");
        return C3671.m11796(new FlowableConcatWithCompletable(this, interfaceC2837));
    }

    public final AbstractC3630<T> mergeWith(InterfaceC2837 interfaceC2837) {
        C4246.m13353(interfaceC2837, "other is null");
        return C3671.m11796(new FlowableMergeWithCompletable(this, interfaceC2837));
    }

    public final AbstractC3630<T> onBackpressureBuffer(int i, boolean z, boolean z2, InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "onOverflow is null");
        C4246.m13354(i, "capacity");
        return C3671.m11796(new FlowableOnBackpressureBuffer(this, i, z2, z, interfaceC3809));
    }

    public final <R> AbstractC3630<R> replay(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368, int i, long j, TimeUnit timeUnit) {
        return replay(interfaceC2368, i, j, timeUnit, C4877.m14600());
    }

    public final AbstractC3630<T> skipLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        return skipLast(j, timeUnit, abstractC4585, z, bufferSize());
    }

    public final AbstractC3630<T> takeLast(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z, int i) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13354(i, "bufferSize");
        if (j >= 0) {
            return C3671.m11796(new FlowableTakeLastTimed(this, j, j2, timeUnit, abstractC4585, i, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j);
    }

    public final AbstractC3630<T> timeout(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "other is null");
        return timeout0(j, timeUnit, publisher, abstractC4585);
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, C4877.m14600(), bufferSize());
    }

    public final <U, R> AbstractC3630<R> zipWith(Publisher<? extends U> publisher, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, boolean z, int i) {
        return zip(this, publisher, interfaceC5247, z, i);
    }

    public static <T> AbstractC3630<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        return concatArray(publisher, publisher2, publisher3);
    }

    public static <T> AbstractC3630<T> fromFuture(Future<? extends T> future, AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return fromFuture(future).subscribeOn(abstractC4585);
    }

    public static <T> AbstractC4838<Boolean> sequenceEqual(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, int i) {
        return sequenceEqual(publisher, publisher2, C4246.m13352(), i);
    }

    public final void blockingSubscribe(Subscriber<? super T> subscriber) {
        C3497.m11417(this, subscriber);
    }

    public final AbstractC3630<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return (AbstractC3630<List<T>>) buffer(j, j2, timeUnit, C4877.m14600(), ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> AbstractC3630<V> flatMapIterable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends V> interfaceC5247, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13353(interfaceC5247, "resultSelector is null");
        return (AbstractC3630<V>) flatMap(FlowableInternalHelper.m6490(interfaceC2368), interfaceC5247, false, bufferSize(), i);
    }

    public final <R> AbstractC3630<R> replay(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368, int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13354(i, "bufferSize");
        C4246.m13353(abstractC4585, "scheduler is null");
        return FlowableReplay.m6590(FlowableInternalHelper.m6495(this, i, j, timeUnit, abstractC4585), interfaceC2368);
    }

    public final AbstractC3630<T> retry(InterfaceC4178<? super Throwable> interfaceC4178) {
        return retry(Long.MAX_VALUE, interfaceC4178);
    }

    public final AbstractC3630<T> skipLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z, int i) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableSkipLastTimed(this, j, timeUnit, abstractC4585, i << 1, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> AbstractC4838<Map<K, Collection<V>>> toMultimap(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, Callable<? extends Map<K, Collection<V>>> callable, InterfaceC2368<? super K, ? extends Collection<? super V>> interfaceC23683) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(interfaceC23682, "valueSelector is null");
        C4246.m13353(callable, "mapSupplier is null");
        C4246.m13353(interfaceC23683, "collectionFactory is null");
        return (AbstractC4838<Map<K, Collection<V>>>) collect(callable, Functions.m6345(interfaceC2368, interfaceC23682, interfaceC23683));
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return window(j, j2, timeUnit, abstractC4585, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, R> AbstractC3630<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, InterfaceC4216<? super T, ? super T1, ? super T2, ? super T3, R> interfaceC4216) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        return withLatestFrom((Publisher<?>[]) new Publisher[]{publisher, publisher2, publisher3}, Functions.m6337(interfaceC4216));
    }

    public static <T, R> AbstractC3630<R> combineLatest(Iterable<? extends Publisher<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        return combineLatest(iterable, interfaceC2368, bufferSize());
    }

    public static <T> AbstractC3630<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        return fromArray(publisher, publisher2, publisher3).flatMap(Functions.m6322(), false, 3);
    }

    public static <T> AbstractC3630<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        return fromArray(publisher, publisher2, publisher3).flatMap(Functions.m6322(), true, 3);
    }

    public static <T1, T2, R> AbstractC3630<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247, boolean z) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        return zipArray(Functions.m6335(interfaceC5247), z, bufferSize(), publisher, publisher2);
    }

    public final AbstractC3630<List<T>> buffer(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return (AbstractC3630<List<T>>) buffer(j, j2, timeUnit, abstractC4585, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> AbstractC3630<T> delay(Publisher<U> publisher, InterfaceC2368<? super T, ? extends Publisher<V>> interfaceC2368) {
        return delaySubscription(publisher).delay(interfaceC2368);
    }

    public final <K, V> AbstractC3630<AbstractC2965<K, V>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, boolean z, int i, InterfaceC2368<? super InterfaceC2857<Object>, ? extends Map<K, Object>> interfaceC23683) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(interfaceC23682, "valueSelector is null");
        C4246.m13354(i, "bufferSize");
        C4246.m13353(interfaceC23683, "evictingMapFactory is null");
        return C3671.m11796(new FlowableGroupBy(this, interfaceC2368, interfaceC23682, i, z, interfaceC23683));
    }

    public final <U> AbstractC3630<T> sample(Publisher<U> publisher) {
        C4246.m13353(publisher, "sampler is null");
        return C3671.m11796(new FlowableSamplePublisher(this, publisher, false));
    }

    public final AbstractC3630<T> timeout(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return timeout0(j, timeUnit, null, abstractC4585);
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i) {
        C4246.m13354(i, "bufferSize");
        C4246.m13355(j, "timespan");
        C4246.m13355(j2, "timeskip");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13353(timeUnit, "unit is null");
        return C3671.m11796(new C3677(this, j, j2, timeUnit, abstractC4585, Long.MAX_VALUE, i, false));
    }

    public static <T, R> AbstractC3630<R> combineLatest(Iterable<? extends Publisher<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i) {
        C4246.m13353(iterable, "sources is null");
        C4246.m13353(interfaceC2368, "combiner is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableCombineLatest((Iterable) iterable, (InterfaceC2368) interfaceC2368, i, false));
    }

    public static <T, R> AbstractC3630<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        return combineLatestDelayError(iterable, interfaceC2368, bufferSize());
    }

    public static <T, S> AbstractC3630<T> generate(Callable<S> callable, InterfaceC5246<S, InterfaceC3487<T>> interfaceC5246, InterfaceC2857<? super S> interfaceC2857) {
        C4246.m13353(interfaceC5246, "generator is null");
        return generate(callable, FlowableInternalHelper.m6498(interfaceC5246), interfaceC2857);
    }

    public static <T> AbstractC3630<T> just(T t, T t2, T t3, T t4) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        return fromArray(t, t2, t3, t4);
    }

    public final <U extends Collection<? super T>> AbstractC3630<U> buffer(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, Callable<U> callable) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13353(callable, "bufferSupplier is null");
        return C3671.m11796(new C3434(this, j, j2, timeUnit, abstractC4585, callable, Integer.MAX_VALUE, false));
    }

    public final AbstractC3630<T> onBackpressureBuffer(int i, InterfaceC3809 interfaceC3809) {
        return onBackpressureBuffer(i, false, false, interfaceC3809);
    }

    public final <U, V> AbstractC3630<T> timeout(Publisher<U> publisher, InterfaceC2368<? super T, ? extends Publisher<V>> interfaceC2368) {
        C4246.m13353(publisher, "firstTimeoutIndicator is null");
        return timeout0(publisher, interfaceC2368, null);
    }

    public static <T, R> AbstractC3630<R> combineLatestDelayError(Iterable<? extends Publisher<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i) {
        C4246.m13353(iterable, "sources is null");
        C4246.m13353(interfaceC2368, "combiner is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableCombineLatest((Iterable) iterable, (InterfaceC2368) interfaceC2368, i, true));
    }

    public final AbstractC3630<T> doOnEach(Subscriber<? super T> subscriber) {
        C4246.m13353(subscriber, "subscriber is null");
        return doOnEach(FlowableInternalHelper.m6502(subscriber), FlowableInternalHelper.m6501(subscriber), FlowableInternalHelper.m6500(subscriber), Functions.f6798);
    }

    public final AbstractC3630<T> onBackpressureBuffer(long j, InterfaceC3809 interfaceC3809, BackpressureOverflowStrategy backpressureOverflowStrategy) {
        C4246.m13353(backpressureOverflowStrategy, "overflowStrategy is null");
        C4246.m13355(j, "capacity");
        return C3671.m11796(new FlowableOnBackpressureBufferStrategy(this, j, interfaceC3809, backpressureOverflowStrategy));
    }

    public final <U> AbstractC3630<T> sample(Publisher<U> publisher, boolean z) {
        C4246.m13353(publisher, "sampler is null");
        return C3671.m11796(new FlowableSamplePublisher(this, publisher, z));
    }

    @Override // org.reactivestreams.Publisher
    public final void subscribe(Subscriber<? super T> subscriber) {
        if (subscriber instanceof InterfaceC3899) {
            subscribe((InterfaceC3899) subscriber);
        } else {
            C4246.m13353(subscriber, "s is null");
            subscribe((InterfaceC3899) new StrictSubscriber(subscriber));
        }
    }

    public static <T> AbstractC3630<T> concat(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        return concatArray(publisher, publisher2, publisher3, publisher4);
    }

    public static <T, S> AbstractC3630<T> generate(Callable<S> callable, InterfaceC5247<S, InterfaceC3487<T>, S> interfaceC5247) {
        return generate(callable, interfaceC5247, Functions.m6320());
    }

    public static <T1, T2, R> AbstractC3630<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247, boolean z, int i) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        return zipArray(Functions.m6335(interfaceC5247), z, i, publisher, publisher2);
    }

    public final AbstractC3630<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, C4877.m14600(), false, bufferSize());
    }

    public final <U, V> AbstractC3630<T> timeout(Publisher<U> publisher, InterfaceC2368<? super T, ? extends Publisher<V>> interfaceC2368, Publisher<? extends T> publisher2) {
        C4246.m13353(publisher, "firstTimeoutSelector is null");
        C4246.m13353(publisher2, "other is null");
        return timeout0(publisher, interfaceC2368, publisher2);
    }

    public static <T, S> AbstractC3630<T> generate(Callable<S> callable, InterfaceC5247<S, InterfaceC3487<T>, S> interfaceC5247, InterfaceC2857<? super S> interfaceC2857) {
        C4246.m13353(callable, "initialState is null");
        C4246.m13353(interfaceC5247, "generator is null");
        C4246.m13353(interfaceC2857, "disposeState is null");
        return C3671.m11796(new FlowableGenerate(callable, interfaceC5247, interfaceC2857));
    }

    public static <T> AbstractC3630<T> merge(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.m6322(), false, 4);
    }

    public static <T> AbstractC3630<T> mergeDelayError(Publisher<? extends T> publisher, Publisher<? extends T> publisher2, Publisher<? extends T> publisher3, Publisher<? extends T> publisher4) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        return fromArray(publisher, publisher2, publisher3, publisher4).flatMap(Functions.m6322(), true, 4);
    }

    public final <R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, InterfaceC2368<? super Throwable, ? extends Publisher<? extends R>> interfaceC23682, Callable<? extends Publisher<? extends R>> callable) {
        C4246.m13353(interfaceC2368, "onNextMapper is null");
        C4246.m13353(interfaceC23682, "onErrorMapper is null");
        C4246.m13353(callable, "onCompleteSupplier is null");
        return merge(new FlowableMapNotification(this, interfaceC2368, interfaceC23682, callable));
    }

    public final AbstractC3630<T> takeLast(long j, TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, C4877.m14600(), z, bufferSize());
    }

    public final <K, V> AbstractC4838<Map<K, Collection<V>>> toMultimap(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(interfaceC2368, interfaceC23682, callable, ArrayListSupplier.asFunction());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, T4, R> AbstractC3630<R> withLatestFrom(Publisher<T1> publisher, Publisher<T2> publisher2, Publisher<T3> publisher3, Publisher<T4> publisher4, InterfaceC2568<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> interfaceC2568) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        return withLatestFrom((Publisher<?>[]) new Publisher[]{publisher, publisher2, publisher3, publisher4}, Functions.m6338(interfaceC2568));
    }

    public static <T1, T2, R> AbstractC3630<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        return combineLatest(Functions.m6335(interfaceC5247), publisher, publisher2);
    }

    public final AbstractC3630<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, C4877.m14600(), Integer.MAX_VALUE);
    }

    public final <R> AbstractC3630<R> replay(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368, int i, AbstractC4585 abstractC4585) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13354(i, "bufferSize");
        return FlowableReplay.m6590(FlowableInternalHelper.m6494(this, i), FlowableInternalHelper.m6497(interfaceC2368, abstractC4585));
    }

    public final AbstractC3630<T> takeLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return takeLast(j, timeUnit, abstractC4585, false, bufferSize());
    }

    public static <T> AbstractC3630<T> just(T t, T t2, T t3, T t4, T t5) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        C4246.m13353(t5, "item5 is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    public static <T1, T2, T3, R> AbstractC3630<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, InterfaceC3482<? super T1, ? super T2, ? super T3, ? extends R> interfaceC3482) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        return zipArray(Functions.m6336(interfaceC3482), false, bufferSize(), publisher, publisher2, publisher3);
    }

    public final AbstractC3630<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        return buffer(j, timeUnit, C4877.m14600(), i);
    }

    public final void subscribe(InterfaceC3899<? super T> interfaceC3899) {
        C4246.m13353(interfaceC3899, "s is null");
        try {
            Subscriber<? super T> subscriberM11811 = C3671.m11811(this, interfaceC3899);
            C4246.m13353(subscriberM11811, "The RxJavaPlugins.onSubscribe hook returned a null FlowableSubscriber. Please check the handler provided to RxJavaPlugins.setOnFlowableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(subscriberM11811);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
            NullPointerException nullPointerException = new NullPointerException("Actually not, but can't throw other exceptions due to RS");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public final AbstractC3630<T> takeLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        return takeLast(j, timeUnit, abstractC4585, z, bufferSize());
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, TimeUnit timeUnit) {
        return window(j, timeUnit, C4877.m14600(), Long.MAX_VALUE, false);
    }

    public final AbstractC3630<List<T>> buffer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i) {
        return (AbstractC3630<List<T>>) buffer(j, timeUnit, abstractC4585, i, ArrayListSupplier.asCallable(), false);
    }

    public final AbstractC3630<T> takeLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z, int i) {
        return takeLast(Long.MAX_VALUE, j, timeUnit, abstractC4585, z, i);
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, C4877.m14600(), j2, false);
    }

    public final <U extends Collection<? super T>> AbstractC3630<U> buffer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, Callable<U> callable, boolean z) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13353(callable, "bufferSupplier is null");
        C4246.m13354(i, "count");
        return C3671.m11796(new C3434(this, j, j, timeUnit, abstractC4585, callable, i, z));
    }

    public final <R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368, InterfaceC2368<Throwable, ? extends Publisher<? extends R>> interfaceC23682, Callable<? extends Publisher<? extends R>> callable, int i) {
        C4246.m13353(interfaceC2368, "onNextMapper is null");
        C4246.m13353(interfaceC23682, "onErrorMapper is null");
        C4246.m13353(callable, "onCompleteSupplier is null");
        return merge(new FlowableMapNotification(this, interfaceC2368, interfaceC23682, callable), i);
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, C4877.m14600(), j2, z);
    }

    public static <T1, T2, T3, R> AbstractC3630<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, InterfaceC3482<? super T1, ? super T2, ? super T3, ? extends R> interfaceC3482) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        return combineLatest(Functions.m6336(interfaceC3482), publisher, publisher2, publisher3);
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return window(j, timeUnit, abstractC4585, Long.MAX_VALUE, false);
    }

    public static <T1, T2, T3, T4, R> AbstractC3630<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, InterfaceC4216<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> interfaceC4216) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        return zipArray(Functions.m6337(interfaceC4216), false, bufferSize(), publisher, publisher2, publisher3, publisher4);
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, long j2) {
        return window(j, timeUnit, abstractC4585, j2, false);
    }

    public final <R> AbstractC3630<R> withLatestFrom(Publisher<?>[] publisherArr, InterfaceC2368<? super Object[], R> interfaceC2368) {
        C4246.m13353(publisherArr, "others is null");
        C4246.m13353(interfaceC2368, "combiner is null");
        return C3671.m11796(new FlowableWithLatestFromMany(this, publisherArr, interfaceC2368));
    }

    public final <R> AbstractC3630<R> replay(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368, long j, TimeUnit timeUnit) {
        return replay(interfaceC2368, j, timeUnit, C4877.m14600());
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, long j2, boolean z) {
        return window(j, timeUnit, abstractC4585, j2, z, bufferSize());
    }

    public static <T> AbstractC3630<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        C4246.m13353(t5, "item5 is null");
        C4246.m13353(t6, "item6 is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    public final <U, R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        return flatMap(interfaceC2368, interfaceC5247, false, bufferSize(), bufferSize());
    }

    public final <R> AbstractC3630<R> replay(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return FlowableReplay.m6590(FlowableInternalHelper.m6496(this, j, timeUnit, abstractC4585), interfaceC2368);
    }

    public final AbstractC3630<AbstractC3630<T>> window(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, long j2, boolean z, int i) {
        C4246.m13354(i, "bufferSize");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13355(j2, "count");
        return C3671.m11796(new C3677(this, j, j, timeUnit, abstractC4585, j2, i, z));
    }

    public static <T1, T2, T3, T4, R> AbstractC3630<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, InterfaceC4216<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> interfaceC4216) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        return combineLatest(Functions.m6337(interfaceC4216), publisher, publisher2, publisher3, publisher4);
    }

    public final AbstractC3630<List<T>> buffer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return (AbstractC3630<List<T>>) buffer(j, timeUnit, abstractC4585, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    public final <U, R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, boolean z) {
        return flatMap(interfaceC2368, interfaceC5247, z, bufferSize(), bufferSize());
    }

    public final <R> AbstractC3630<R> withLatestFrom(Iterable<? extends Publisher<?>> iterable, InterfaceC2368<? super Object[], R> interfaceC2368) {
        C4246.m13353(iterable, "others is null");
        C4246.m13353(interfaceC2368, "combiner is null");
        return C3671.m11796(new FlowableWithLatestFromMany(this, iterable, interfaceC2368));
    }

    public final <TOpening, TClosing> AbstractC3630<List<T>> buffer(AbstractC3630<? extends TOpening> abstractC3630, InterfaceC2368<? super TOpening, ? extends Publisher<? extends TClosing>> interfaceC2368) {
        return (AbstractC3630<List<T>>) buffer(abstractC3630, interfaceC2368, ArrayListSupplier.asCallable());
    }

    public final <U, R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, boolean z, int i) {
        return flatMap(interfaceC2368, interfaceC5247, z, i, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> AbstractC3630<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, InterfaceC2568<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> interfaceC2568) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        C4246.m13353(publisher5, "source5 is null");
        return zipArray(Functions.m6338(interfaceC2568), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> AbstractC3630<U> buffer(AbstractC3630<? extends TOpening> abstractC3630, InterfaceC2368<? super TOpening, ? extends Publisher<? extends TClosing>> interfaceC2368, Callable<U> callable) {
        C4246.m13353(abstractC3630, "openingIndicator is null");
        C4246.m13353(interfaceC2368, "closingIndicator is null");
        C4246.m13353(callable, "bufferSupplier is null");
        return C3671.m11796(new FlowableBufferBoundary(this, abstractC3630, interfaceC2368, callable));
    }

    public final <U, R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, boolean z, int i, int i2) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13353(interfaceC5247, "combiner is null");
        C4246.m13354(i, "maxConcurrency");
        C4246.m13354(i2, "bufferSize");
        return flatMap(FlowableInternalHelper.m6491(interfaceC2368, interfaceC5247), z, i, i2);
    }

    public final <R> AbstractC3630<R> replay(InterfaceC2368<? super AbstractC3630<T>, ? extends Publisher<R>> interfaceC2368, AbstractC4585 abstractC4585) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return FlowableReplay.m6590(FlowableInternalHelper.m6493(this), FlowableInternalHelper.m6497(interfaceC2368, abstractC4585));
    }

    public final <B> AbstractC3630<AbstractC3630<T>> window(Publisher<B> publisher) {
        return window(publisher, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> AbstractC3630<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, InterfaceC2568<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> interfaceC2568) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        C4246.m13353(publisher5, "source5 is null");
        return combineLatest(Functions.m6338(interfaceC2568), publisher, publisher2, publisher3, publisher4, publisher5);
    }

    public final <B> AbstractC3630<AbstractC3630<T>> window(Publisher<B> publisher, int i) {
        C4246.m13353(publisher, "boundaryIndicator is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableWindowBoundary(this, publisher, i));
    }

    public static <T> AbstractC3630<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        C4246.m13353(t5, "item5 is null");
        C4246.m13353(t6, "item6 is null");
        C4246.m13353(t7, "item7 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    public final <B> AbstractC3630<List<T>> buffer(Publisher<B> publisher) {
        return (AbstractC3630<List<T>>) buffer(publisher, ArrayListSupplier.asCallable());
    }

    public final <B> AbstractC3630<List<T>> buffer(Publisher<B> publisher, int i) {
        C4246.m13354(i, "initialCapacity");
        return (AbstractC3630<List<T>>) buffer(publisher, Functions.m6318(i));
    }

    public final <U, R> AbstractC3630<R> flatMap(InterfaceC2368<? super T, ? extends Publisher<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, int i) {
        return flatMap(interfaceC2368, interfaceC5247, false, i, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, T6, R> AbstractC3630<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, InterfaceC2485<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> interfaceC2485) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        C4246.m13353(publisher5, "source5 is null");
        C4246.m13353(publisher6, "source6 is null");
        return zipArray(Functions.m6339(interfaceC2485), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    public final AbstractC3731<T> replay(int i) {
        C4246.m13354(i, "bufferSize");
        return FlowableReplay.m6585(this, i);
    }

    public final <U, V> AbstractC3630<AbstractC3630<T>> window(Publisher<U> publisher, InterfaceC2368<? super U, ? extends Publisher<V>> interfaceC2368) {
        return window(publisher, interfaceC2368, bufferSize());
    }

    public final <B, U extends Collection<? super T>> AbstractC3630<U> buffer(Publisher<B> publisher, Callable<U> callable) {
        C4246.m13353(publisher, "boundaryIndicator is null");
        C4246.m13353(callable, "bufferSupplier is null");
        return C3671.m11796(new C3532(this, publisher, callable));
    }

    public final <U, V> AbstractC3630<AbstractC3630<T>> window(Publisher<U> publisher, InterfaceC2368<? super U, ? extends Publisher<V>> interfaceC2368, int i) {
        C4246.m13353(publisher, "openingIndicator is null");
        C4246.m13353(interfaceC2368, "closingIndicator is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new C5087(this, publisher, interfaceC2368, i));
    }

    public final AbstractC3731<T> replay(int i, long j, TimeUnit timeUnit) {
        return replay(i, j, timeUnit, C4877.m14600());
    }

    public static <T1, T2, T3, T4, T5, T6, R> AbstractC3630<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, InterfaceC2485<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> interfaceC2485) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        C4246.m13353(publisher5, "source5 is null");
        C4246.m13353(publisher6, "source6 is null");
        return combineLatest(Functions.m6339(interfaceC2485), publisher, publisher2, publisher3, publisher4, publisher5, publisher6);
    }

    public final AbstractC3731<T> replay(int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13354(i, "bufferSize");
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13354(i, "bufferSize");
        return FlowableReplay.m6587(this, j, timeUnit, abstractC4585, i);
    }

    public final <B> AbstractC3630<List<T>> buffer(Callable<? extends Publisher<B>> callable) {
        return (AbstractC3630<List<T>>) buffer(callable, ArrayListSupplier.asCallable());
    }

    public final <B, U extends Collection<? super T>> AbstractC3630<U> buffer(Callable<? extends Publisher<B>> callable, Callable<U> callable2) {
        C4246.m13353(callable, "boundaryIndicatorSupplier is null");
        C4246.m13353(callable2, "bufferSupplier is null");
        return C3671.m11796(new C2814(this, callable, callable2));
    }

    public final <B> AbstractC3630<AbstractC3630<T>> window(Callable<? extends Publisher<B>> callable) {
        return window(callable, bufferSize());
    }

    public static <T> AbstractC3630<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        C4246.m13353(t5, "item5 is null");
        C4246.m13353(t6, "item6 is null");
        C4246.m13353(t7, "item7 is null");
        C4246.m13353(t8, "item8 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8);
    }

    public final <B> AbstractC3630<AbstractC3630<T>> window(Callable<? extends Publisher<B>> callable, int i) {
        C4246.m13353(callable, "boundaryIndicatorSupplier is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11796(new FlowableWindowBoundarySupplier(this, callable, i));
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> AbstractC3630<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, InterfaceC2825<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> interfaceC2825) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        C4246.m13353(publisher5, "source5 is null");
        C4246.m13353(publisher6, "source6 is null");
        C4246.m13353(publisher7, "source7 is null");
        return zipArray(Functions.m6340(interfaceC2825), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    public final AbstractC3731<T> replay(int i, AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return FlowableReplay.m6591(replay(i), abstractC4585);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> AbstractC3630<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, InterfaceC2825<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> interfaceC2825) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        C4246.m13353(publisher5, "source5 is null");
        C4246.m13353(publisher6, "source6 is null");
        C4246.m13353(publisher7, "source7 is null");
        return combineLatest(Functions.m6340(interfaceC2825), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7);
    }

    public final AbstractC3731<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, C4877.m14600());
    }

    public final AbstractC3731<T> replay(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return FlowableReplay.m6586(this, j, timeUnit, abstractC4585);
    }

    public final AbstractC3731<T> replay(AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return FlowableReplay.m6591(replay(), abstractC4585);
    }

    public static <T> AbstractC3630<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        C4246.m13353(t5, "item5 is null");
        C4246.m13353(t6, "item6 is null");
        C4246.m13353(t7, "item7 is null");
        C4246.m13353(t8, "item8 is null");
        C4246.m13353(t9, "item9 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> AbstractC3630<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, InterfaceC4399<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> interfaceC4399) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        C4246.m13353(publisher5, "source5 is null");
        C4246.m13353(publisher6, "source6 is null");
        C4246.m13353(publisher7, "source7 is null");
        C4246.m13353(publisher8, "source8 is null");
        return zipArray(Functions.m6341(interfaceC4399), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> AbstractC3630<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, InterfaceC4399<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> interfaceC4399) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        C4246.m13353(publisher5, "source5 is null");
        C4246.m13353(publisher6, "source6 is null");
        C4246.m13353(publisher7, "source7 is null");
        C4246.m13353(publisher8, "source8 is null");
        return combineLatest(Functions.m6341(interfaceC4399), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> AbstractC3630<R> zip(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Publisher<? extends T9> publisher9, InterfaceC2954<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> interfaceC2954) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        C4246.m13353(publisher5, "source5 is null");
        C4246.m13353(publisher6, "source6 is null");
        C4246.m13353(publisher7, "source7 is null");
        C4246.m13353(publisher8, "source8 is null");
        C4246.m13353(publisher9, "source9 is null");
        return zipArray(Functions.m6342(interfaceC2954), false, bufferSize(), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }

    public static <T> AbstractC3630<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        C4246.m13353(t5, "item5 is null");
        C4246.m13353(t6, "item6 is null");
        C4246.m13353(t7, "item7 is null");
        C4246.m13353(t8, "item8 is null");
        C4246.m13353(t9, "item9 is null");
        C4246.m13353(t10, "item10 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7, t8, t9, t10);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> AbstractC3630<R> combineLatest(Publisher<? extends T1> publisher, Publisher<? extends T2> publisher2, Publisher<? extends T3> publisher3, Publisher<? extends T4> publisher4, Publisher<? extends T5> publisher5, Publisher<? extends T6> publisher6, Publisher<? extends T7> publisher7, Publisher<? extends T8> publisher8, Publisher<? extends T9> publisher9, InterfaceC2954<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> interfaceC2954) {
        C4246.m13353(publisher, "source1 is null");
        C4246.m13353(publisher2, "source2 is null");
        C4246.m13353(publisher3, "source3 is null");
        C4246.m13353(publisher4, "source4 is null");
        C4246.m13353(publisher5, "source5 is null");
        C4246.m13353(publisher6, "source6 is null");
        C4246.m13353(publisher7, "source7 is null");
        C4246.m13353(publisher8, "source8 is null");
        C4246.m13353(publisher9, "source9 is null");
        return combineLatest(Functions.m6342(interfaceC2954), publisher, publisher2, publisher3, publisher4, publisher5, publisher6, publisher7, publisher8, publisher9);
    }
}
