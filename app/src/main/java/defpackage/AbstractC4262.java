package defpackage;

import io.reactivex.BackpressureStrategy;
import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.ForEachWhileObserver;
import io.reactivex.internal.observers.LambdaObserver;
import io.reactivex.internal.operators.flowable.FlowableOnBackpressureError;
import io.reactivex.internal.operators.mixed.ObservableConcatMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableConcatMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableConcatMapSingle;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapCompletable;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapMaybe;
import io.reactivex.internal.operators.mixed.ObservableSwitchMapSingle;
import io.reactivex.internal.operators.observable.BlockingObservableIterable;
import io.reactivex.internal.operators.observable.C2105;
import io.reactivex.internal.operators.observable.ObservableAmb;
import io.reactivex.internal.operators.observable.ObservableBuffer;
import io.reactivex.internal.operators.observable.ObservableBufferBoundary;
import io.reactivex.internal.operators.observable.ObservableCache;
import io.reactivex.internal.operators.observable.ObservableCombineLatest;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.observable.ObservableConcatMapEager;
import io.reactivex.internal.operators.observable.ObservableConcatWithCompletable;
import io.reactivex.internal.operators.observable.ObservableConcatWithMaybe;
import io.reactivex.internal.operators.observable.ObservableConcatWithSingle;
import io.reactivex.internal.operators.observable.ObservableCreate;
import io.reactivex.internal.operators.observable.ObservableDebounceTimed;
import io.reactivex.internal.operators.observable.ObservableDoFinally;
import io.reactivex.internal.operators.observable.ObservableFlatMap;
import io.reactivex.internal.operators.observable.ObservableFlatMapCompletableCompletable;
import io.reactivex.internal.operators.observable.ObservableFlatMapMaybe;
import io.reactivex.internal.operators.observable.ObservableFlatMapSingle;
import io.reactivex.internal.operators.observable.ObservableGroupBy;
import io.reactivex.internal.operators.observable.ObservableGroupJoin;
import io.reactivex.internal.operators.observable.ObservableInterval;
import io.reactivex.internal.operators.observable.ObservableIntervalRange;
import io.reactivex.internal.operators.observable.ObservableJoin;
import io.reactivex.internal.operators.observable.ObservableMergeWithCompletable;
import io.reactivex.internal.operators.observable.ObservableMergeWithMaybe;
import io.reactivex.internal.operators.observable.ObservableMergeWithSingle;
import io.reactivex.internal.operators.observable.ObservableObserveOn;
import io.reactivex.internal.operators.observable.ObservablePublish;
import io.reactivex.internal.operators.observable.ObservablePublishSelector;
import io.reactivex.internal.operators.observable.ObservableRange;
import io.reactivex.internal.operators.observable.ObservableRangeLong;
import io.reactivex.internal.operators.observable.ObservableRepeat;
import io.reactivex.internal.operators.observable.ObservableRepeatUntil;
import io.reactivex.internal.operators.observable.ObservableRepeatWhen;
import io.reactivex.internal.operators.observable.ObservableReplay;
import io.reactivex.internal.operators.observable.ObservableRetryBiPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryPredicate;
import io.reactivex.internal.operators.observable.ObservableRetryWhen;
import io.reactivex.internal.operators.observable.ObservableSampleTimed;
import io.reactivex.internal.operators.observable.ObservableSampleWithObservable;
import io.reactivex.internal.operators.observable.ObservableScalarXMap;
import io.reactivex.internal.operators.observable.ObservableSequenceEqualSingle;
import io.reactivex.internal.operators.observable.ObservableSkipLast;
import io.reactivex.internal.operators.observable.ObservableSkipLastTimed;
import io.reactivex.internal.operators.observable.ObservableSubscribeOn;
import io.reactivex.internal.operators.observable.ObservableSwitchMap;
import io.reactivex.internal.operators.observable.ObservableTakeLast;
import io.reactivex.internal.operators.observable.ObservableTakeLastTimed;
import io.reactivex.internal.operators.observable.ObservableTakeUntil;
import io.reactivex.internal.operators.observable.ObservableThrottleFirstTimed;
import io.reactivex.internal.operators.observable.ObservableThrottleLatest;
import io.reactivex.internal.operators.observable.ObservableTimeout;
import io.reactivex.internal.operators.observable.ObservableTimeoutTimed;
import io.reactivex.internal.operators.observable.ObservableTimer;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn;
import io.reactivex.internal.operators.observable.ObservableUsing;
import io.reactivex.internal.operators.observable.ObservableWindow;
import io.reactivex.internal.operators.observable.ObservableWindowBoundary;
import io.reactivex.internal.operators.observable.ObservableWindowBoundarySupplier;
import io.reactivex.internal.operators.observable.ObservableWithLatestFrom;
import io.reactivex.internal.operators.observable.ObservableWithLatestFromMany;
import io.reactivex.internal.operators.observable.ObservableZip;
import io.reactivex.internal.util.ArrayListSupplier;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.HashMapSupplier;
import io.reactivex.observers.TestObserver;
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

/* compiled from: Observable.java */
/* renamed from: ਥ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC4262<T> implements InterfaceC2856<T> {

    /* compiled from: Observable.java */
    /* renamed from: ਥ$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C4263 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f14622;

        static {
            int[] iArr = new int[BackpressureStrategy.values().length];
            f14622 = iArr;
            try {
                iArr[BackpressureStrategy.DROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f14622[BackpressureStrategy.LATEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f14622[BackpressureStrategy.MISSING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f14622[BackpressureStrategy.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static <T> AbstractC4262<T> amb(Iterable<? extends InterfaceC2856<? extends T>> iterable) {
        C4246.m13353(iterable, "sources is null");
        return C3671.m11798(new ObservableAmb(null, iterable));
    }

    public static <T> AbstractC4262<T> ambArray(InterfaceC2856<? extends T>... interfaceC2856Arr) {
        C4246.m13353(interfaceC2856Arr, "sources is null");
        int length = interfaceC2856Arr.length;
        return length == 0 ? empty() : length == 1 ? wrap(interfaceC2856Arr[0]) : C3671.m11798(new ObservableAmb(interfaceC2856Arr, null));
    }

    public static int bufferSize() {
        return AbstractC3630.bufferSize();
    }

    public static <T, R> AbstractC4262<R> combineLatest(InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return combineLatest(interfaceC2856Arr, interfaceC2368, i);
    }

    public static <T, R> AbstractC4262<R> combineLatestDelayError(InterfaceC2856<? extends T>[] interfaceC2856Arr, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        return combineLatestDelayError(interfaceC2856Arr, interfaceC2368, bufferSize());
    }

    public static <T> AbstractC4262<T> concat(Iterable<? extends InterfaceC2856<? extends T>> iterable) {
        C4246.m13353(iterable, "sources is null");
        return fromIterable(iterable).concatMapDelayError(Functions.m6322(), bufferSize(), false);
    }

    public static <T> AbstractC4262<T> concatArray(InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return interfaceC2856Arr.length == 0 ? empty() : interfaceC2856Arr.length == 1 ? wrap(interfaceC2856Arr[0]) : C3671.m11798(new ObservableConcatMap(fromArray(interfaceC2856Arr), Functions.m6322(), bufferSize(), ErrorMode.BOUNDARY));
    }

    public static <T> AbstractC4262<T> concatArrayDelayError(InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return interfaceC2856Arr.length == 0 ? empty() : interfaceC2856Arr.length == 1 ? wrap(interfaceC2856Arr[0]) : concatDelayError(fromArray(interfaceC2856Arr));
    }

    public static <T> AbstractC4262<T> concatArrayEager(InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return concatArrayEager(bufferSize(), bufferSize(), interfaceC2856Arr);
    }

    public static <T> AbstractC4262<T> concatArrayEagerDelayError(InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return concatArrayEagerDelayError(bufferSize(), bufferSize(), interfaceC2856Arr);
    }

    public static <T> AbstractC4262<T> concatDelayError(Iterable<? extends InterfaceC2856<? extends T>> iterable) {
        C4246.m13353(iterable, "sources is null");
        return concatDelayError(fromIterable(iterable));
    }

    public static <T> AbstractC4262<T> concatEager(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856) {
        return concatEager(interfaceC2856, bufferSize(), bufferSize());
    }

    public static <T> AbstractC4262<T> create(InterfaceC5201<T> interfaceC5201) {
        C4246.m13353(interfaceC5201, "source is null");
        return C3671.m11798(new ObservableCreate(interfaceC5201));
    }

    public static <T> AbstractC4262<T> defer(Callable<? extends InterfaceC2856<? extends T>> callable) {
        C4246.m13353(callable, "supplier is null");
        return C3671.m11798(new C4607(callable));
    }

    private AbstractC4262<T> doOnEach(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC3809 interfaceC38092) {
        C4246.m13353(interfaceC2857, "onNext is null");
        C4246.m13353(interfaceC28572, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        C4246.m13353(interfaceC38092, "onAfterTerminate is null");
        return C3671.m11798(new C4392(this, interfaceC2857, interfaceC28572, interfaceC3809, interfaceC38092));
    }

    public static <T> AbstractC4262<T> empty() {
        return C3671.m11798(C4130.f14309);
    }

    public static <T> AbstractC4262<T> error(Callable<? extends Throwable> callable) {
        C4246.m13353(callable, "errorSupplier is null");
        return C3671.m11798(new C5217(callable));
    }

    public static <T> AbstractC4262<T> fromArray(T... tArr) {
        C4246.m13353(tArr, "items is null");
        return tArr.length == 0 ? empty() : tArr.length == 1 ? just(tArr[0]) : C3671.m11798(new C4282(tArr));
    }

    public static <T> AbstractC4262<T> fromCallable(Callable<? extends T> callable) {
        C4246.m13353(callable, "supplier is null");
        return C3671.m11798(new CallableC4661(callable));
    }

    public static <T> AbstractC4262<T> fromFuture(Future<? extends T> future) {
        C4246.m13353(future, "future is null");
        return C3671.m11798(new C2490(future, 0L, null));
    }

    public static <T> AbstractC4262<T> fromIterable(Iterable<? extends T> iterable) {
        C4246.m13353(iterable, "source is null");
        return C3671.m11798(new C4388(iterable));
    }

    public static <T> AbstractC4262<T> fromPublisher(Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "publisher is null");
        return C3671.m11798(new C5257(publisher));
    }

    public static <T> AbstractC4262<T> generate(InterfaceC2857<InterfaceC3487<T>> interfaceC2857) {
        C4246.m13353(interfaceC2857, "generator is null");
        return generate(Functions.m6332(), C3587.m11621(interfaceC2857), Functions.m6320());
    }

    public static AbstractC4262<Long> interval(long j, long j2, TimeUnit timeUnit) {
        return interval(j, j2, timeUnit, C4877.m14600());
    }

    public static AbstractC4262<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit) {
        return intervalRange(j, j2, j3, j4, timeUnit, C4877.m14600());
    }

    public static <T> AbstractC4262<T> just(T t) {
        C4246.m13353(t, "item is null");
        return C3671.m11798(new C2105(t));
    }

    public static <T> AbstractC4262<T> merge(Iterable<? extends InterfaceC2856<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.m6322(), false, i, i2);
    }

    public static <T> AbstractC4262<T> mergeArray(int i, int i2, InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return fromArray(interfaceC2856Arr).flatMap(Functions.m6322(), false, i, i2);
    }

    public static <T> AbstractC4262<T> mergeArrayDelayError(int i, int i2, InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return fromArray(interfaceC2856Arr).flatMap(Functions.m6322(), true, i, i2);
    }

    public static <T> AbstractC4262<T> mergeDelayError(Iterable<? extends InterfaceC2856<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.m6322(), true);
    }

    public static <T> AbstractC4262<T> never() {
        return C3671.m11798(C3166.f11233);
    }

    public static AbstractC4262<Integer> range(int i, int i2) {
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
            return C3671.m11798(new ObservableRange(i, i2));
        }
        throw new IllegalArgumentException("Integer overflow");
    }

    public static AbstractC4262<Long> rangeLong(long j, long j2) {
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
            return C3671.m11798(new ObservableRangeLong(j, j2));
        }
        throw new IllegalArgumentException("Overflow! start + count is bigger than Long.MAX_VALUE");
    }

    public static <T> AbstractC4838<Boolean> sequenceEqual(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562) {
        return sequenceEqual(interfaceC2856, interfaceC28562, C4246.m13352(), bufferSize());
    }

    public static <T> AbstractC4262<T> switchOnNext(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856, int i) {
        C4246.m13353(interfaceC2856, "sources is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableSwitchMap(interfaceC2856, Functions.m6322(), i, false));
    }

    public static <T> AbstractC4262<T> switchOnNextDelayError(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856) {
        return switchOnNextDelayError(interfaceC2856, bufferSize());
    }

    private AbstractC4262<T> timeout0(long j, TimeUnit timeUnit, InterfaceC2856<? extends T> interfaceC2856, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "timeUnit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new ObservableTimeoutTimed(this, j, timeUnit, abstractC4585, interfaceC2856));
    }

    public static AbstractC4262<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, C4877.m14600());
    }

    public static <T> AbstractC4262<T> unsafeCreate(InterfaceC2856<T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "onSubscribe is null");
        if (interfaceC2856 instanceof AbstractC4262) {
            throw new IllegalArgumentException("unsafeCreate(Observable) should be upgraded");
        }
        return C3671.m11798(new C4559(interfaceC2856));
    }

    public static <T, D> AbstractC4262<T> using(Callable<? extends D> callable, InterfaceC2368<? super D, ? extends InterfaceC2856<? extends T>> interfaceC2368, InterfaceC2857<? super D> interfaceC2857) {
        return using(callable, interfaceC2368, interfaceC2857, true);
    }

    public static <T> AbstractC4262<T> wrap(InterfaceC2856<T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "source is null");
        return interfaceC2856 instanceof AbstractC4262 ? C3671.m11798((AbstractC4262) interfaceC2856) : C3671.m11798(new C4559(interfaceC2856));
    }

    public static <T, R> AbstractC4262<R> zip(Iterable<? extends InterfaceC2856<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        C4246.m13353(interfaceC2368, "zipper is null");
        C4246.m13353(iterable, "sources is null");
        return C3671.m11798(new ObservableZip(null, iterable, interfaceC2368, bufferSize(), false));
    }

    public static <T, R> AbstractC4262<R> zipArray(InterfaceC2368<? super Object[], ? extends R> interfaceC2368, boolean z, int i, InterfaceC2856<? extends T>... interfaceC2856Arr) {
        if (interfaceC2856Arr.length == 0) {
            return empty();
        }
        C4246.m13353(interfaceC2368, "zipper is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableZip(interfaceC2856Arr, null, interfaceC2368, i, z));
    }

    public static <T, R> AbstractC4262<R> zipIterable(Iterable<? extends InterfaceC2856<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "zipper is null");
        C4246.m13353(iterable, "sources is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableZip(null, iterable, interfaceC2368, i, z));
    }

    public final AbstractC4838<Boolean> all(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11800(new C2660(this, interfaceC4178));
    }

    public final AbstractC4262<T> ambWith(InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return ambArray(this, interfaceC2856);
    }

    public final AbstractC4838<Boolean> any(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11800(new C4508(this, interfaceC4178));
    }

    public final <R> R as(InterfaceC3489<T, ? extends R> interfaceC3489) {
        return (R) ((InterfaceC3489) C4246.m13353(interfaceC3489, "converter is null")).apply(this);
    }

    public final T blockingFirst() {
        C3646 c3646 = new C3646();
        subscribe(c3646);
        T tM10001 = c3646.m10001();
        if (tM10001 != null) {
            return tM10001;
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

    public final T blockingLast() {
        C2480 c2480 = new C2480();
        subscribe(c2480);
        T tM10001 = c2480.m10001();
        if (tM10001 != null) {
            return tM10001;
        }
        throw new NoSuchElementException();
    }

    public final Iterable<T> blockingLatest() {
        return new C3271(this);
    }

    public final Iterable<T> blockingMostRecent(T t) {
        return new C3103(this, t);
    }

    public final Iterable<T> blockingNext() {
        return new C4743(this);
    }

    public final T blockingSingle() {
        T tM13386 = singleElement().m13386();
        if (tM13386 != null) {
            return tM13386;
        }
        throw new NoSuchElementException();
    }

    public final void blockingSubscribe() {
        C3693.m11840(this);
    }

    public final AbstractC4262<List<T>> buffer(int i) {
        return buffer(i, i);
    }

    public final AbstractC4262<T> cache() {
        return cacheWithInitialCapacity(16);
    }

    public final AbstractC4262<T> cacheWithInitialCapacity(int i) {
        C4246.m13354(i, "initialCapacity");
        return C3671.m11798(new ObservableCache(this, i));
    }

    public final <U> AbstractC4262<U> cast(Class<U> cls) {
        C4246.m13353(cls, "clazz is null");
        return (AbstractC4262<U>) map(Functions.m6317(cls));
    }

    public final <U> AbstractC4838<U> collect(Callable<? extends U> callable, InterfaceC5246<? super U, ? super T> interfaceC5246) {
        C4246.m13353(callable, "initialValueSupplier is null");
        C4246.m13353(interfaceC5246, "collector is null");
        return C3671.m11800(new C5099(this, callable, interfaceC5246));
    }

    public final <U> AbstractC4838<U> collectInto(U u, InterfaceC5246<? super U, ? super T> interfaceC5246) {
        C4246.m13353(u, "initialValue is null");
        return collect(Functions.m6324(u), interfaceC5246);
    }

    public final <R> AbstractC4262<R> compose(InterfaceC5298<? super T, ? extends R> interfaceC5298) {
        return wrap(((InterfaceC5298) C4246.m13353(interfaceC5298, "composer is null")).apply(this));
    }

    public final <R> AbstractC4262<R> concatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
        return concatMap(interfaceC2368, 2);
    }

    public final AbstractC2900 concatMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        return concatMapCompletable(interfaceC2368, 2);
    }

    public final AbstractC2900 concatMapCompletableDelayError(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        return concatMapCompletableDelayError(interfaceC2368, true, 2);
    }

    public final <R> AbstractC4262<R> concatMapDelayError(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
        return concatMapDelayError(interfaceC2368, bufferSize(), true);
    }

    public final <R> AbstractC4262<R> concatMapEager(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
        return concatMapEager(interfaceC2368, Integer.MAX_VALUE, bufferSize());
    }

    public final <R> AbstractC4262<R> concatMapEagerDelayError(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, boolean z) {
        return concatMapEagerDelayError(interfaceC2368, Integer.MAX_VALUE, bufferSize(), z);
    }

    public final <U> AbstractC4262<U> concatMapIterable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new C4174(this, interfaceC2368));
    }

    public final <R> AbstractC4262<R> concatMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        return concatMapMaybe(interfaceC2368, 2);
    }

    public final <R> AbstractC4262<R> concatMapMaybeDelayError(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        return concatMapMaybeDelayError(interfaceC2368, true, 2);
    }

    public final <R> AbstractC4262<R> concatMapSingle(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        return concatMapSingle(interfaceC2368, 2);
    }

    public final <R> AbstractC4262<R> concatMapSingleDelayError(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        return concatMapSingleDelayError(interfaceC2368, true, 2);
    }

    public final AbstractC4262<T> concatWith(InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return concat(this, interfaceC2856);
    }

    public final AbstractC4838<Boolean> contains(Object obj) {
        C4246.m13353(obj, "element is null");
        return any(Functions.m6321(obj));
    }

    public final AbstractC4838<Long> count() {
        return C3671.m11800(new C4544(this));
    }

    public final <U> AbstractC4262<T> debounce(InterfaceC2368<? super T, ? extends InterfaceC2856<U>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "debounceSelector is null");
        return C3671.m11798(new C3943(this, interfaceC2368));
    }

    public final AbstractC4262<T> defaultIfEmpty(T t) {
        C4246.m13353(t, "defaultItem is null");
        return switchIfEmpty(just(t));
    }

    public final <U> AbstractC4262<T> delay(InterfaceC2368<? super T, ? extends InterfaceC2856<U>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "itemDelay is null");
        return (AbstractC4262<T>) flatMap(C3587.m11611(interfaceC2368));
    }

    public final <U> AbstractC4262<T> delaySubscription(InterfaceC2856<U> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return C3671.m11798(new C4592(this, interfaceC2856));
    }

    @Deprecated
    public final <T2> AbstractC4262<T2> dematerialize() {
        return C3671.m11798(new C3154(this, Functions.m6322()));
    }

    public final AbstractC4262<T> distinct() {
        return distinct(Functions.m6322(), Functions.m6319());
    }

    public final AbstractC4262<T> distinctUntilChanged() {
        return distinctUntilChanged(Functions.m6322());
    }

    public final AbstractC4262<T> doAfterNext(InterfaceC2857<? super T> interfaceC2857) {
        C4246.m13353(interfaceC2857, "onAfterNext is null");
        return C3671.m11798(new C4656(this, interfaceC2857));
    }

    public final AbstractC4262<T> doAfterTerminate(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "onFinally is null");
        return doOnEach(Functions.m6320(), Functions.m6320(), Functions.f6798, interfaceC3809);
    }

    public final AbstractC4262<T> doFinally(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "onFinally is null");
        return C3671.m11798(new ObservableDoFinally(this, interfaceC3809));
    }

    public final AbstractC4262<T> doOnComplete(InterfaceC3809 interfaceC3809) {
        return doOnEach(Functions.m6320(), Functions.m6320(), interfaceC3809, Functions.f6798);
    }

    public final AbstractC4262<T> doOnDispose(InterfaceC3809 interfaceC3809) {
        return doOnLifecycle(Functions.m6320(), interfaceC3809);
    }

    public final AbstractC4262<T> doOnError(InterfaceC2857<? super Throwable> interfaceC2857) {
        InterfaceC2857<? super T> interfaceC2857M6320 = Functions.m6320();
        InterfaceC3809 interfaceC3809 = Functions.f6798;
        return doOnEach(interfaceC2857M6320, interfaceC2857, interfaceC3809, interfaceC3809);
    }

    public final AbstractC4262<T> doOnLifecycle(InterfaceC2857<? super InterfaceC4478> interfaceC2857, InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC2857, "onSubscribe is null");
        C4246.m13353(interfaceC3809, "onDispose is null");
        return C3671.m11798(new C2927(this, interfaceC2857, interfaceC3809));
    }

    public final AbstractC4262<T> doOnNext(InterfaceC2857<? super T> interfaceC2857) {
        InterfaceC2857<? super Throwable> interfaceC2857M6320 = Functions.m6320();
        InterfaceC3809 interfaceC3809 = Functions.f6798;
        return doOnEach(interfaceC2857, interfaceC2857M6320, interfaceC3809, interfaceC3809);
    }

    public final AbstractC4262<T> doOnSubscribe(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        return doOnLifecycle(interfaceC2857, Functions.f6798);
    }

    public final AbstractC4262<T> doOnTerminate(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "onTerminate is null");
        return doOnEach(Functions.m6320(), Functions.m6313(interfaceC3809), interfaceC3809, Functions.f6798);
    }

    public final AbstractC4274<T> elementAt(long j) {
        if (j >= 0) {
            return C3671.m11797(new C4777(this, j));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final AbstractC4838<T> elementAtOrError(long j) {
        if (j >= 0) {
            return C3671.m11800(new C4813(this, j, null));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final AbstractC4262<T> filter(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11798(new C4397(this, interfaceC4178));
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

    public final <R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
        return flatMap((InterfaceC2368) interfaceC2368, false);
    }

    public final AbstractC2900 flatMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        return flatMapCompletable(interfaceC2368, false);
    }

    public final <U> AbstractC4262<U> flatMapIterable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new C4174(this, interfaceC2368));
    }

    public final <R> AbstractC4262<R> flatMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        return flatMapMaybe(interfaceC2368, false);
    }

    public final <R> AbstractC4262<R> flatMapSingle(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        return flatMapSingle(interfaceC2368, false);
    }

    public final InterfaceC4478 forEach(InterfaceC2857<? super T> interfaceC2857) {
        return subscribe(interfaceC2857);
    }

    public final InterfaceC4478 forEachWhile(InterfaceC4178<? super T> interfaceC4178) {
        return forEachWhile(interfaceC4178, Functions.f6801, Functions.f6798);
    }

    public final <K> AbstractC4262<AbstractC3101<K, T>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368) {
        return (AbstractC4262<AbstractC3101<K, T>>) groupBy(interfaceC2368, Functions.m6322(), false, bufferSize());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> AbstractC4262<R> groupJoin(InterfaceC2856<? extends TRight> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends InterfaceC2856<TRightEnd>> interfaceC23682, InterfaceC5247<? super T, ? super AbstractC4262<TRight>, ? extends R> interfaceC5247) {
        C4246.m13353(interfaceC2856, "other is null");
        C4246.m13353(interfaceC2368, "leftEnd is null");
        C4246.m13353(interfaceC23682, "rightEnd is null");
        C4246.m13353(interfaceC5247, "resultSelector is null");
        return C3671.m11798(new ObservableGroupJoin(this, interfaceC2856, interfaceC2368, interfaceC23682, interfaceC5247));
    }

    public final AbstractC4262<T> hide() {
        return C3671.m11798(new C3156(this));
    }

    public final AbstractC2900 ignoreElements() {
        return C3671.m11793(new C4475(this));
    }

    public final AbstractC4838<Boolean> isEmpty() {
        return all(Functions.m6314());
    }

    public final <TRight, TLeftEnd, TRightEnd, R> AbstractC4262<R> join(InterfaceC2856<? extends TRight> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<TLeftEnd>> interfaceC2368, InterfaceC2368<? super TRight, ? extends InterfaceC2856<TRightEnd>> interfaceC23682, InterfaceC5247<? super T, ? super TRight, ? extends R> interfaceC5247) {
        C4246.m13353(interfaceC2856, "other is null");
        C4246.m13353(interfaceC2368, "leftEnd is null");
        C4246.m13353(interfaceC23682, "rightEnd is null");
        C4246.m13353(interfaceC5247, "resultSelector is null");
        return C3671.m11798(new ObservableJoin(this, interfaceC2856, interfaceC2368, interfaceC23682, interfaceC5247));
    }

    public final AbstractC4838<T> last(T t) {
        C4246.m13353(t, "defaultItem is null");
        return C3671.m11800(new C4528(this, t));
    }

    public final AbstractC4274<T> lastElement() {
        return C3671.m11797(new C4804(this));
    }

    public final AbstractC4838<T> lastOrError() {
        return C3671.m11800(new C4528(this, null));
    }

    public final <R> AbstractC4262<R> lift(InterfaceC4312<? extends R, ? super T> interfaceC4312) {
        C4246.m13353(interfaceC4312, "lifter is null");
        return C3671.m11798(new C5280(this, interfaceC4312));
    }

    public final <R> AbstractC4262<R> map(InterfaceC2368<? super T, ? extends R> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new C4113(this, interfaceC2368));
    }

    public final AbstractC4262<C3906<T>> materialize() {
        return C3671.m11798(new C3878(this));
    }

    public final AbstractC4262<T> mergeWith(InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return merge(this, interfaceC2856);
    }

    public final AbstractC4262<T> observeOn(AbstractC4585 abstractC4585) {
        return observeOn(abstractC4585, false, bufferSize());
    }

    public final <U> AbstractC4262<U> ofType(Class<U> cls) {
        C4246.m13353(cls, "clazz is null");
        return filter(Functions.m6323(cls)).cast(cls);
    }

    public final AbstractC4262<T> onErrorResumeNext(InterfaceC2368<? super Throwable, ? extends InterfaceC2856<? extends T>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "resumeFunction is null");
        return C3671.m11798(new C4522(this, interfaceC2368, false));
    }

    public final AbstractC4262<T> onErrorReturn(InterfaceC2368<? super Throwable, ? extends T> interfaceC2368) {
        C4246.m13353(interfaceC2368, "valueSupplier is null");
        return C3671.m11798(new C3585(this, interfaceC2368));
    }

    public final AbstractC4262<T> onErrorReturnItem(T t) {
        C4246.m13353(t, "item is null");
        return onErrorReturn(Functions.m6325(t));
    }

    public final AbstractC4262<T> onExceptionResumeNext(InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "next is null");
        return C3671.m11798(new C4522(this, Functions.m6325(interfaceC2856), true));
    }

    public final AbstractC4262<T> onTerminateDetach() {
        return C3671.m11798(new C4547(this));
    }

    public final AbstractC4945<T> publish() {
        return ObservablePublish.m6832(this);
    }

    public final AbstractC4274<T> reduce(InterfaceC5247<T, T, T> interfaceC5247) {
        C4246.m13353(interfaceC5247, "reducer is null");
        return C3671.m11797(new C4698(this, interfaceC5247));
    }

    public final <R> AbstractC4838<R> reduceWith(Callable<R> callable, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        C4246.m13353(callable, "seedSupplier is null");
        C4246.m13353(interfaceC5247, "reducer is null");
        return C3671.m11800(new C4827(this, callable, interfaceC5247));
    }

    public final AbstractC4262<T> repeat() {
        return repeat(Long.MAX_VALUE);
    }

    public final AbstractC4262<T> repeatUntil(InterfaceC2881 interfaceC2881) {
        C4246.m13353(interfaceC2881, "stop is null");
        return C3671.m11798(new ObservableRepeatUntil(this, interfaceC2881));
    }

    public final AbstractC4262<T> repeatWhen(InterfaceC2368<? super AbstractC4262<Object>, ? extends InterfaceC2856<?>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "handler is null");
        return C3671.m11798(new ObservableRepeatWhen(this, interfaceC2368));
    }

    public final AbstractC4945<T> replay() {
        return ObservableReplay.m6858(this);
    }

    public final AbstractC4262<T> retry() {
        return retry(Long.MAX_VALUE, Functions.m6315());
    }

    public final AbstractC4262<T> retryUntil(InterfaceC2881 interfaceC2881) {
        C4246.m13353(interfaceC2881, "stop is null");
        return retry(Long.MAX_VALUE, Functions.m6333(interfaceC2881));
    }

    public final AbstractC4262<T> retryWhen(InterfaceC2368<? super AbstractC4262<Throwable>, ? extends InterfaceC2856<?>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "handler is null");
        return C3671.m11798(new ObservableRetryWhen(this, interfaceC2368));
    }

    public final void safeSubscribe(InterfaceC5102<? super T> interfaceC5102) {
        C4246.m13353(interfaceC5102, "observer is null");
        if (interfaceC5102 instanceof C5289) {
            subscribe(interfaceC5102);
        } else {
            subscribe(new C5289(interfaceC5102));
        }
    }

    public final AbstractC4262<T> sample(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit, C4877.m14600());
    }

    public final AbstractC4262<T> scan(InterfaceC5247<T, T, T> interfaceC5247) {
        C4246.m13353(interfaceC5247, "accumulator is null");
        return C3671.m11798(new C4318(this, interfaceC5247));
    }

    public final <R> AbstractC4262<R> scanWith(Callable<R> callable, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        C4246.m13353(callable, "seedSupplier is null");
        C4246.m13353(interfaceC5247, "accumulator is null");
        return C3671.m11798(new C4736(this, callable, interfaceC5247));
    }

    public final AbstractC4262<T> serialize() {
        return C3671.m11798(new C5313(this));
    }

    public final AbstractC4262<T> share() {
        return publish().m14718();
    }

    public final AbstractC4838<T> single(T t) {
        C4246.m13353(t, "defaultItem is null");
        return C3671.m11800(new C3876(this, t));
    }

    public final AbstractC4274<T> singleElement() {
        return C3671.m11797(new C3558(this));
    }

    public final AbstractC4838<T> singleOrError() {
        return C3671.m11800(new C3876(this, null));
    }

    public final AbstractC4262<T> skip(long j) {
        return j <= 0 ? C3671.m11798(this) : C3671.m11798(new C2558(this, j));
    }

    public final AbstractC4262<T> skipLast(int i) {
        if (i >= 0) {
            return i == 0 ? C3671.m11798(this) : C3671.m11798(new ObservableSkipLast(this, i));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    public final <U> AbstractC4262<T> skipUntil(InterfaceC2856<U> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return C3671.m11798(new C4524(this, interfaceC2856));
    }

    public final AbstractC4262<T> skipWhile(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11798(new C2331(this, interfaceC4178));
    }

    public final AbstractC4262<T> sorted() {
        return toList().toObservable().map(Functions.m6326(Functions.m6327())).flatMapIterable(Functions.m6322());
    }

    public final AbstractC4262<T> startWith(Iterable<? extends T> iterable) {
        return concatArray(fromIterable(iterable), this);
    }

    public final AbstractC4262<T> startWithArray(T... tArr) {
        AbstractC4262 abstractC4262FromArray = fromArray(tArr);
        return abstractC4262FromArray == empty() ? C3671.m11798(this) : concatArray(abstractC4262FromArray, this);
    }

    public final InterfaceC4478 subscribe() {
        return subscribe(Functions.m6320(), Functions.f6801, Functions.f6798, Functions.m6320());
    }

    public abstract void subscribeActual(InterfaceC5102<? super T> interfaceC5102);

    public final AbstractC4262<T> subscribeOn(AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new ObservableSubscribeOn(this, abstractC4585));
    }

    public final <E extends InterfaceC5102<? super T>> E subscribeWith(E e2) {
        subscribe(e2);
        return e2;
    }

    public final AbstractC4262<T> switchIfEmpty(InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return C3671.m11798(new C2706(this, interfaceC2856));
    }

    public final <R> AbstractC4262<R> switchMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
        return switchMap(interfaceC2368, bufferSize());
    }

    public final AbstractC2900 switchMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11793(new ObservableSwitchMapCompletable(this, interfaceC2368, false));
    }

    public final AbstractC2900 switchMapCompletableDelayError(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11793(new ObservableSwitchMapCompletable(this, interfaceC2368, true));
    }

    public final <R> AbstractC4262<R> switchMapDelayError(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
        return switchMapDelayError(interfaceC2368, bufferSize());
    }

    public final <R> AbstractC4262<R> switchMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new ObservableSwitchMapMaybe(this, interfaceC2368, false));
    }

    public final <R> AbstractC4262<R> switchMapMaybeDelayError(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new ObservableSwitchMapMaybe(this, interfaceC2368, true));
    }

    public final <R> AbstractC4262<R> switchMapSingle(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new ObservableSwitchMapSingle(this, interfaceC2368, false));
    }

    public final <R> AbstractC4262<R> switchMapSingleDelayError(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new ObservableSwitchMapSingle(this, interfaceC2368, true));
    }

    public final AbstractC4262<T> take(long j) {
        if (j >= 0) {
            return C3671.m11798(new C4612(this, j));
        }
        throw new IllegalArgumentException("count >= 0 required but it was " + j);
    }

    public final AbstractC4262<T> takeLast(int i) {
        if (i >= 0) {
            return i == 0 ? C3671.m11798(new C4856(this)) : i == 1 ? C3671.m11798(new C2668(this)) : C3671.m11798(new ObservableTakeLast(this, i));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + i);
    }

    public final <U> AbstractC4262<T> takeUntil(InterfaceC2856<U> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return C3671.m11798(new ObservableTakeUntil(this, interfaceC2856));
    }

    public final AbstractC4262<T> takeWhile(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11798(new C3917(this, interfaceC4178));
    }

    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    public final AbstractC4262<T> throttleFirst(long j, TimeUnit timeUnit) {
        return throttleFirst(j, timeUnit, C4877.m14600());
    }

    public final AbstractC4262<T> throttleLast(long j, TimeUnit timeUnit) {
        return sample(j, timeUnit);
    }

    public final AbstractC4262<T> throttleLatest(long j, TimeUnit timeUnit) {
        return throttleLatest(j, timeUnit, C4877.m14600(), false);
    }

    public final AbstractC4262<T> throttleWithTimeout(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit);
    }

    public final AbstractC4262<o2<T>> timeInterval() {
        return timeInterval(TimeUnit.MILLISECONDS, C4877.m14600());
    }

    public final <V> AbstractC4262<T> timeout(InterfaceC2368<? super T, ? extends InterfaceC2856<V>> interfaceC2368) {
        return timeout0(null, interfaceC2368, null);
    }

    public final AbstractC4262<o2<T>> timestamp() {
        return timestamp(TimeUnit.MILLISECONDS, C4877.m14600());
    }

    public final <R> R to(InterfaceC2368<? super AbstractC4262<T>, R> interfaceC2368) {
        try {
            return (R) ((InterfaceC2368) C4246.m13353(interfaceC2368, "converter is null")).apply(this);
        } catch (Throwable th) {
            C4089.m13026(th);
            throw ExceptionHelper.m7024(th);
        }
    }

    public final AbstractC3630<T> toFlowable(BackpressureStrategy backpressureStrategy) {
        C5321 c5321 = new C5321(this);
        int i = C4263.f14622[backpressureStrategy.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? c5321.onBackpressureBuffer() : C3671.m11796(new FlowableOnBackpressureError(c5321)) : c5321 : c5321.onBackpressureLatest() : c5321.onBackpressureDrop();
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureC3572());
    }

    public final AbstractC4838<List<T>> toList() {
        return toList(16);
    }

    public final <K> AbstractC4838<Map<K, T>> toMap(InterfaceC2368<? super T, ? extends K> interfaceC2368) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        return (AbstractC4838<Map<K, T>>) collect(HashMapSupplier.asCallable(), Functions.m6343(interfaceC2368));
    }

    public final <K> AbstractC4838<Map<K, Collection<T>>> toMultimap(InterfaceC2368<? super T, ? extends K> interfaceC2368) {
        return (AbstractC4838<Map<K, Collection<T>>>) toMultimap(interfaceC2368, Functions.m6322(), HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public final AbstractC4838<List<T>> toSortedList() {
        return toSortedList(Functions.m6328());
    }

    public final AbstractC4262<T> unsubscribeOn(AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new ObservableUnsubscribeOn(this, abstractC4585));
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j) {
        return window(j, j, bufferSize());
    }

    public final <U, R> AbstractC4262<R> withLatestFrom(InterfaceC2856<? extends U> interfaceC2856, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        C4246.m13353(interfaceC2856, "other is null");
        C4246.m13353(interfaceC5247, "combiner is null");
        return C3671.m11798(new ObservableWithLatestFrom(this, interfaceC5247, interfaceC2856));
    }

    public final <U, R> AbstractC4262<R> zipWith(Iterable<U> iterable, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        C4246.m13353(iterable, "other is null");
        C4246.m13353(interfaceC5247, "zipper is null");
        return C3671.m11798(new C3565(this, iterable, interfaceC5247));
    }

    public static <T, R> AbstractC4262<R> combineLatest(Iterable<? extends InterfaceC2856<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        return combineLatest(iterable, interfaceC2368, bufferSize());
    }

    public static <T, R> AbstractC4262<R> combineLatestDelayError(InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i, InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return combineLatestDelayError(interfaceC2856Arr, interfaceC2368, i);
    }

    public static <T> AbstractC4262<T> concatArrayEager(int i, int i2, InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return fromArray(interfaceC2856Arr).concatMapEagerDelayError(Functions.m6322(), i, i2, false);
    }

    public static <T> AbstractC4262<T> concatArrayEagerDelayError(int i, int i2, InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return fromArray(interfaceC2856Arr).concatMapEagerDelayError(Functions.m6322(), i, i2, true);
    }

    public static <T> AbstractC4262<T> concatEager(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856, int i, int i2) {
        return wrap(interfaceC2856).concatMapEager(Functions.m6322(), i, i2);
    }

    public static AbstractC4262<Long> interval(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new ObservableInterval(Math.max(0L, j), Math.max(0L, j2), timeUnit, abstractC4585));
    }

    public static AbstractC4262<Long> intervalRange(long j, long j2, long j3, long j4, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
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
        return C3671.m11798(new ObservableIntervalRange(j, j5, Math.max(0L, j3), Math.max(0L, j4), timeUnit, abstractC4585));
    }

    public static <T> AbstractC4262<T> merge(Iterable<? extends InterfaceC2856<? extends T>> iterable) {
        return fromIterable(iterable).flatMap(Functions.m6322());
    }

    public static <T> AbstractC4262<T> mergeArray(InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return fromArray(interfaceC2856Arr).flatMap(Functions.m6322(), interfaceC2856Arr.length);
    }

    public static <T> AbstractC4262<T> mergeArrayDelayError(InterfaceC2856<? extends T>... interfaceC2856Arr) {
        return fromArray(interfaceC2856Arr).flatMap(Functions.m6322(), true, interfaceC2856Arr.length);
    }

    public static <T> AbstractC4262<T> mergeDelayError(Iterable<? extends InterfaceC2856<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).flatMap(Functions.m6322(), true, i, i2);
    }

    public static <T> AbstractC4838<Boolean> sequenceEqual(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC5324<? super T, ? super T> interfaceC5324) {
        return sequenceEqual(interfaceC2856, interfaceC28562, interfaceC5324, bufferSize());
    }

    public static <T> AbstractC4262<T> switchOnNextDelayError(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856, int i) {
        C4246.m13353(interfaceC2856, "sources is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11798(new ObservableSwitchMap(interfaceC2856, Functions.m6322(), i, true));
    }

    public static AbstractC4262<Long> timer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new ObservableTimer(Math.max(j, 0L), timeUnit, abstractC4585));
    }

    public static <T, D> AbstractC4262<T> using(Callable<? extends D> callable, InterfaceC2368<? super D, ? extends InterfaceC2856<? extends T>> interfaceC2368, InterfaceC2857<? super D> interfaceC2857, boolean z) {
        C4246.m13353(callable, "resourceSupplier is null");
        C4246.m13353(interfaceC2368, "sourceSupplier is null");
        C4246.m13353(interfaceC2857, "disposer is null");
        return C3671.m11798(new ObservableUsing(callable, interfaceC2368, interfaceC2857, z));
    }

    public final Iterable<T> blockingIterable(int i) {
        C4246.m13354(i, "bufferSize");
        return new BlockingObservableIterable(this, i);
    }

    public final void blockingSubscribe(InterfaceC2857<? super T> interfaceC2857) {
        C3693.m11841(this, interfaceC2857, Functions.f6801, Functions.f6798);
    }

    public final AbstractC4262<List<T>> buffer(int i, int i2) {
        return (AbstractC4262<List<T>>) buffer(i, i2, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> AbstractC4262<R> concatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        if (!(this instanceof InterfaceCallableC5143)) {
            return C3671.m11798(new ObservableConcatMap(this, interfaceC2368, i, ErrorMode.IMMEDIATE));
        }
        Object objCall = ((InterfaceCallableC5143) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.m6894(objCall, interfaceC2368);
    }

    public final AbstractC2900 concatMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "capacityHint");
        return C3671.m11793(new ObservableConcatMapCompletable(this, interfaceC2368, ErrorMode.IMMEDIATE, i));
    }

    public final AbstractC2900 concatMapCompletableDelayError(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
        return concatMapCompletableDelayError(interfaceC2368, z, 2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> AbstractC4262<R> concatMapDelayError(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i, boolean z) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        if (!(this instanceof InterfaceCallableC5143)) {
            return C3671.m11798(new ObservableConcatMap(this, interfaceC2368, i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
        }
        Object objCall = ((InterfaceCallableC5143) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.m6894(objCall, interfaceC2368);
    }

    public final <R> AbstractC4262<R> concatMapEager(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i, int i2) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "maxConcurrency");
        C4246.m13354(i2, "prefetch");
        return C3671.m11798(new ObservableConcatMapEager(this, interfaceC2368, ErrorMode.IMMEDIATE, i, i2));
    }

    public final <R> AbstractC4262<R> concatMapEagerDelayError(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i, int i2, boolean z) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "maxConcurrency");
        C4246.m13354(i2, "prefetch");
        return C3671.m11798(new ObservableConcatMapEager(this, interfaceC2368, z ? ErrorMode.END : ErrorMode.BOUNDARY, i, i2));
    }

    public final <R> AbstractC4262<R> concatMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11798(new ObservableConcatMapMaybe(this, interfaceC2368, ErrorMode.IMMEDIATE, i));
    }

    public final <R> AbstractC4262<R> concatMapMaybeDelayError(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z) {
        return concatMapMaybeDelayError(interfaceC2368, z, 2);
    }

    public final <R> AbstractC4262<R> concatMapSingle(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11798(new ObservableConcatMapSingle(this, interfaceC2368, ErrorMode.IMMEDIATE, i));
    }

    public final <R> AbstractC4262<R> concatMapSingleDelayError(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z) {
        return concatMapSingleDelayError(interfaceC2368, z, 2);
    }

    public final <R> AbstractC4262<R> dematerialize(InterfaceC2368<? super T, C3906<R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "selector is null");
        return C3671.m11798(new C3154(this, interfaceC2368));
    }

    public final <K> AbstractC4262<T> distinct(InterfaceC2368<? super T, K> interfaceC2368) {
        return distinct(interfaceC2368, Functions.m6319());
    }

    public final <K> AbstractC4262<T> distinctUntilChanged(InterfaceC2368<? super T, K> interfaceC2368) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        return C3671.m11798(new C4915(this, interfaceC2368, C4246.m13352()));
    }

    public final <R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, boolean z) {
        return flatMap(interfaceC2368, z, Integer.MAX_VALUE);
    }

    public final AbstractC2900 flatMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11793(new ObservableFlatMapCompletableCompletable(this, interfaceC2368, z));
    }

    public final <R> AbstractC4262<R> flatMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new ObservableFlatMapMaybe(this, interfaceC2368, z));
    }

    public final <R> AbstractC4262<R> flatMapSingle(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new ObservableFlatMapSingle(this, interfaceC2368, z));
    }

    public final InterfaceC4478 forEachWhile(InterfaceC4178<? super T> interfaceC4178, InterfaceC2857<? super Throwable> interfaceC2857) {
        return forEachWhile(interfaceC4178, interfaceC2857, Functions.f6798);
    }

    public final <K> AbstractC4262<AbstractC3101<K, T>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368, boolean z) {
        return (AbstractC4262<AbstractC3101<K, T>>) groupBy(interfaceC2368, Functions.m6322(), z, bufferSize());
    }

    public final AbstractC4262<T> observeOn(AbstractC4585 abstractC4585, boolean z) {
        return observeOn(abstractC4585, z, bufferSize());
    }

    public final <R> AbstractC4262<R> publish(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "selector is null");
        return C3671.m11798(new ObservablePublishSelector(this, interfaceC2368));
    }

    public final AbstractC4262<T> repeat(long j) {
        if (j >= 0) {
            return j == 0 ? empty() : C3671.m11798(new ObservableRepeat(this, j));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final <R> AbstractC4262<R> replay(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "selector is null");
        return ObservableReplay.m6859(C3587.m11615(this), interfaceC2368);
    }

    public final AbstractC4262<T> retry(InterfaceC5324<? super Integer, ? super Throwable> interfaceC5324) {
        C4246.m13353(interfaceC5324, "predicate is null");
        return C3671.m11798(new ObservableRetryBiPredicate(this, interfaceC5324));
    }

    public final AbstractC4262<T> sample(long j, TimeUnit timeUnit, boolean z) {
        return sample(j, timeUnit, C4877.m14600(), z);
    }

    public final AbstractC4262<T> sorted(Comparator<? super T> comparator) {
        C4246.m13353(comparator, "sortFunction is null");
        return toList().toObservable().map(Functions.m6326(comparator)).flatMapIterable(Functions.m6322());
    }

    public final AbstractC4262<T> startWith(InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return concatArray(interfaceC2856, this);
    }

    public final InterfaceC4478 subscribe(InterfaceC2857<? super T> interfaceC2857) {
        return subscribe(interfaceC2857, Functions.f6801, Functions.f6798, Functions.m6320());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> AbstractC4262<R> switchMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "bufferSize");
        if (!(this instanceof InterfaceCallableC5143)) {
            return C3671.m11798(new ObservableSwitchMap(this, interfaceC2368, i, false));
        }
        Object objCall = ((InterfaceCallableC5143) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.m6894(objCall, interfaceC2368);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> AbstractC4262<R> switchMapDelayError(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "bufferSize");
        if (!(this instanceof InterfaceCallableC5143)) {
            return C3671.m11798(new ObservableSwitchMap(this, interfaceC2368, i, true));
        }
        Object objCall = ((InterfaceCallableC5143) this).call();
        return objCall == null ? empty() : ObservableScalarXMap.m6894(objCall, interfaceC2368);
    }

    public final AbstractC4262<T> throttleFirst(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new ObservableThrottleFirstTimed(this, j, timeUnit, abstractC4585));
    }

    public final AbstractC4262<T> throttleLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return sample(j, timeUnit, abstractC4585);
    }

    public final AbstractC4262<T> throttleLatest(long j, TimeUnit timeUnit, boolean z) {
        return throttleLatest(j, timeUnit, C4877.m14600(), z);
    }

    public final AbstractC4262<T> throttleWithTimeout(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return debounce(j, timeUnit, abstractC4585);
    }

    public final AbstractC4262<o2<T>> timeInterval(AbstractC4585 abstractC4585) {
        return timeInterval(TimeUnit.MILLISECONDS, abstractC4585);
    }

    public final <V> AbstractC4262<T> timeout(InterfaceC2368<? super T, ? extends InterfaceC2856<V>> interfaceC2368, InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return timeout0(null, interfaceC2368, interfaceC2856);
    }

    public final AbstractC4262<o2<T>> timestamp(AbstractC4585 abstractC4585) {
        return timestamp(TimeUnit.MILLISECONDS, abstractC4585);
    }

    public final AbstractC4838<List<T>> toList(int i) {
        C4246.m13354(i, "capacityHint");
        return C3671.m11800(new C2410(this, i));
    }

    public final AbstractC4838<List<T>> toSortedList(Comparator<? super T> comparator) {
        C4246.m13353(comparator, "comparator is null");
        return (AbstractC4838<List<T>>) toList().map(Functions.m6326(comparator));
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, long j2) {
        return window(j, j2, bufferSize());
    }

    public static <T, R> AbstractC4262<R> combineLatest(Iterable<? extends InterfaceC2856<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i) {
        C4246.m13353(iterable, "sources is null");
        C4246.m13353(interfaceC2368, "combiner is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableCombineLatest(null, iterable, interfaceC2368, i << 1, false));
    }

    public static <T, R> AbstractC4262<R> combineLatestDelayError(InterfaceC2856<? extends T>[] interfaceC2856Arr, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i) {
        C4246.m13354(i, "bufferSize");
        C4246.m13353(interfaceC2368, "combiner is null");
        if (interfaceC2856Arr.length == 0) {
            return empty();
        }
        return C3671.m11798(new ObservableCombineLatest(interfaceC2856Arr, null, interfaceC2368, i << 1, true));
    }

    public static <T> AbstractC4262<T> concat(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856) {
        return concat(interfaceC2856, bufferSize());
    }

    public static <T> AbstractC4262<T> concatDelayError(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856) {
        return concatDelayError(interfaceC2856, bufferSize(), true);
    }

    public static <T> AbstractC4262<T> concatEager(Iterable<? extends InterfaceC2856<? extends T>> iterable) {
        return concatEager(iterable, bufferSize(), bufferSize());
    }

    public static <T> AbstractC4262<T> error(Throwable th) {
        C4246.m13353(th, "exception is null");
        return error((Callable<? extends Throwable>) Functions.m6324(th));
    }

    public static <T> AbstractC4262<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        C4246.m13353(future, "future is null");
        C4246.m13353(timeUnit, "unit is null");
        return C3671.m11798(new C2490(future, j, timeUnit));
    }

    public static <T> AbstractC4262<T> just(T t, T t2) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        return fromArray(t, t2);
    }

    public static <T> AbstractC4262<T> merge(Iterable<? extends InterfaceC2856<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.m6322(), i);
    }

    public static <T> AbstractC4262<T> mergeDelayError(Iterable<? extends InterfaceC2856<? extends T>> iterable, int i) {
        return fromIterable(iterable).flatMap(Functions.m6322(), true, i);
    }

    public static <T> AbstractC4838<Boolean> sequenceEqual(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC5324<? super T, ? super T> interfaceC5324, int i) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC5324, "isEqual is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11800(new ObservableSequenceEqualSingle(interfaceC2856, interfaceC28562, interfaceC5324, i));
    }

    public final T blockingSingle(T t) {
        return single(t).blockingGet();
    }

    public final void blockingSubscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572) {
        C3693.m11841(this, interfaceC2857, interfaceC28572, Functions.f6798);
    }

    public final <U extends Collection<? super T>> AbstractC4262<U> buffer(int i, int i2, Callable<U> callable) {
        C4246.m13354(i, "count");
        C4246.m13354(i2, "skip");
        C4246.m13353(callable, "bufferSupplier is null");
        return C3671.m11798(new ObservableBuffer(this, i, i2, callable));
    }

    public final AbstractC2900 concatMapCompletableDelayError(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11793(new ObservableConcatMapCompletable(this, interfaceC2368, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    public final <U> AbstractC4262<U> concatMapIterable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return (AbstractC4262<U>) concatMap(C3587.m11609(interfaceC2368), i);
    }

    public final <R> AbstractC4262<R> concatMapMaybeDelayError(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11798(new ObservableConcatMapMaybe(this, interfaceC2368, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    public final <R> AbstractC4262<R> concatMapSingleDelayError(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368, boolean z, int i) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11798(new ObservableConcatMapSingle(this, interfaceC2368, z ? ErrorMode.END : ErrorMode.BOUNDARY, i));
    }

    public final AbstractC4262<T> concatWith(InterfaceC3951<? extends T> interfaceC3951) {
        C4246.m13353(interfaceC3951, "other is null");
        return C3671.m11798(new ObservableConcatWithSingle(this, interfaceC3951));
    }

    public final AbstractC4262<T> debounce(long j, TimeUnit timeUnit) {
        return debounce(j, timeUnit, C4877.m14600());
    }

    public final AbstractC4262<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, C4877.m14600(), false);
    }

    public final AbstractC4262<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, C4877.m14600());
    }

    public final <K> AbstractC4262<T> distinct(InterfaceC2368<? super T, K> interfaceC2368, Callable<? extends Collection<? super K>> callable) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(callable, "collectionSupplier is null");
        return C3671.m11798(new C4466(this, interfaceC2368, callable));
    }

    public final AbstractC4838<T> elementAt(long j, T t) {
        if (j >= 0) {
            C4246.m13353(t, "defaultItem is null");
            return C3671.m11800(new C4813(this, j, t));
        }
        throw new IndexOutOfBoundsException("index >= 0 required but it was " + j);
    }

    public final <R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, boolean z, int i) {
        return flatMap(interfaceC2368, z, i, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> AbstractC4262<V> flatMapIterable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends V> interfaceC5247) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13353(interfaceC5247, "resultSelector is null");
        return (AbstractC4262<V>) flatMap(C3587.m11609(interfaceC2368), interfaceC5247, false, bufferSize(), bufferSize());
    }

    public final InterfaceC4478 forEachWhile(InterfaceC4178<? super T> interfaceC4178, InterfaceC2857<? super Throwable> interfaceC2857, InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC4178, "onNext is null");
        C4246.m13353(interfaceC2857, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        ForEachWhileObserver forEachWhileObserver = new ForEachWhileObserver(interfaceC4178, interfaceC2857, interfaceC3809);
        subscribe(forEachWhileObserver);
        return forEachWhileObserver;
    }

    public final <K, V> AbstractC4262<AbstractC3101<K, V>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682) {
        return groupBy(interfaceC2368, interfaceC23682, false, bufferSize());
    }

    public final AbstractC4262<T> mergeWith(InterfaceC3951<? extends T> interfaceC3951) {
        C4246.m13353(interfaceC3951, "other is null");
        return C3671.m11798(new ObservableMergeWithSingle(this, interfaceC3951));
    }

    public final AbstractC4262<T> observeOn(AbstractC4585 abstractC4585, boolean z, int i) {
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableObserveOn(this, abstractC4585, z, i));
    }

    public final AbstractC4262<T> onErrorResumeNext(InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "next is null");
        return onErrorResumeNext(Functions.m6325(interfaceC2856));
    }

    public final <R> AbstractC4838<R> reduce(R r, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        C4246.m13353(r, "seed is null");
        C4246.m13353(interfaceC5247, "reducer is null");
        return C3671.m11800(new C3690(this, r, interfaceC5247));
    }

    public final AbstractC4262<T> sample(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new ObservableSampleTimed(this, j, timeUnit, abstractC4585, false));
    }

    public final <R> AbstractC4262<R> scan(R r, InterfaceC5247<R, ? super T, R> interfaceC5247) {
        C4246.m13353(r, "initialValue is null");
        return scanWith(Functions.m6324(r), interfaceC5247);
    }

    public final AbstractC4262<T> skip(long j, TimeUnit timeUnit) {
        return skipUntil(timer(j, timeUnit));
    }

    public final InterfaceC4478 subscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572) {
        return subscribe(interfaceC2857, interfaceC28572, Functions.f6798, Functions.m6320());
    }

    public final AbstractC4262<T> take(long j, TimeUnit timeUnit) {
        return takeUntil(timer(j, timeUnit));
    }

    public final AbstractC4262<T> takeUntil(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "stopPredicate is null");
        return C3671.m11798(new C3081(this, interfaceC4178));
    }

    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.dispose();
        }
        subscribe(testObserver);
        return testObserver;
    }

    public final AbstractC4262<T> throttleLatest(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return throttleLatest(j, timeUnit, abstractC4585, false);
    }

    public final AbstractC4262<o2<T>> timeInterval(TimeUnit timeUnit) {
        return timeInterval(timeUnit, C4877.m14600());
    }

    public final AbstractC4262<o2<T>> timestamp(TimeUnit timeUnit) {
        return timestamp(timeUnit, C4877.m14600());
    }

    public final <K, V> AbstractC4838<Map<K, V>> toMap(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(interfaceC23682, "valueSelector is null");
        return (AbstractC4838<Map<K, V>>) collect(HashMapSupplier.asCallable(), Functions.m6344(interfaceC2368, interfaceC23682));
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, long j2, int i) {
        C4246.m13355(j, "count");
        C4246.m13355(j2, "skip");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableWindow(this, j, j2, i));
    }

    public static <T> AbstractC4262<T> concat(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856, int i) {
        C4246.m13353(interfaceC2856, "sources is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11798(new ObservableConcatMap(interfaceC2856, Functions.m6322(), i, ErrorMode.IMMEDIATE));
    }

    public static <T> AbstractC4262<T> concatDelayError(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856, int i, boolean z) {
        C4246.m13353(interfaceC2856, "sources is null");
        C4246.m13354(i, "prefetch is null");
        return C3671.m11798(new ObservableConcatMap(interfaceC2856, Functions.m6322(), i, z ? ErrorMode.END : ErrorMode.BOUNDARY));
    }

    public static <T> AbstractC4262<T> concatEager(Iterable<? extends InterfaceC2856<? extends T>> iterable, int i, int i2) {
        return fromIterable(iterable).concatMapEagerDelayError(Functions.m6322(), i, i2, false);
    }

    public static <T> AbstractC4262<T> merge(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856) {
        C4246.m13353(interfaceC2856, "sources is null");
        return C3671.m11798(new ObservableFlatMap(interfaceC2856, Functions.m6322(), false, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> AbstractC4262<T> mergeDelayError(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856) {
        C4246.m13353(interfaceC2856, "sources is null");
        return C3671.m11798(new ObservableFlatMap(interfaceC2856, Functions.m6322(), true, Integer.MAX_VALUE, bufferSize()));
    }

    public static <T> AbstractC4262<T> switchOnNext(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856) {
        return switchOnNext(interfaceC2856, bufferSize());
    }

    private <U, V> AbstractC4262<T> timeout0(InterfaceC2856<U> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<V>> interfaceC2368, InterfaceC2856<? extends T> interfaceC28562) {
        C4246.m13353(interfaceC2368, "itemTimeoutIndicator is null");
        return C3671.m11798(new ObservableTimeout(this, interfaceC2856, interfaceC2368, interfaceC28562));
    }

    public static <T, R> AbstractC4262<R> zip(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        C4246.m13353(interfaceC2368, "zipper is null");
        C4246.m13353(interfaceC2856, "sources is null");
        return C3671.m11798(new C4349(interfaceC2856, 16).flatMap(C3587.m11622(interfaceC2368)));
    }

    public final void blockingSubscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809) {
        C3693.m11841(this, interfaceC2857, interfaceC28572, interfaceC3809);
    }

    public final AbstractC4262<T> debounce(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new ObservableDebounceTimed(this, j, timeUnit, abstractC4585));
    }

    public final AbstractC4262<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, C4877.m14600(), z);
    }

    public final AbstractC4262<T> delaySubscription(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return delaySubscription(timer(j, timeUnit, abstractC4585));
    }

    public final AbstractC4262<T> distinctUntilChanged(InterfaceC5324<? super T, ? super T> interfaceC5324) {
        C4246.m13353(interfaceC5324, "comparer is null");
        return C3671.m11798(new C4915(this, Functions.m6322(), interfaceC5324));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, boolean z, int i, int i2) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13354(i, "maxConcurrency");
        C4246.m13354(i2, "bufferSize");
        if (this instanceof InterfaceCallableC5143) {
            Object objCall = ((InterfaceCallableC5143) this).call();
            if (objCall == null) {
                return empty();
            }
            return ObservableScalarXMap.m6894(objCall, interfaceC2368);
        }
        return C3671.m11798(new ObservableFlatMap(this, interfaceC2368, z, i, i2));
    }

    public final <K, V> AbstractC4262<AbstractC3101<K, V>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, boolean z) {
        return groupBy(interfaceC2368, interfaceC23682, z, bufferSize());
    }

    public final <R> AbstractC4262<R> replay(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13354(i, "bufferSize");
        return ObservableReplay.m6859(C3587.m11616(this, i), interfaceC2368);
    }

    public final AbstractC4262<T> retry(long j) {
        return retry(j, Functions.m6315());
    }

    public final AbstractC4262<T> skip(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return skipUntil(timer(j, timeUnit, abstractC4585));
    }

    public final AbstractC4262<T> skipLast(long j, TimeUnit timeUnit) {
        return skipLast(j, timeUnit, C4877.m14604(), false, bufferSize());
    }

    public final AbstractC4262<T> startWith(T t) {
        C4246.m13353(t, "item is null");
        return concatArray(just(t), this);
    }

    public final InterfaceC4478 subscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809) {
        return subscribe(interfaceC2857, interfaceC28572, interfaceC3809, Functions.m6320());
    }

    public final AbstractC4262<T> take(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return takeUntil(timer(j, timeUnit, abstractC4585));
    }

    public final AbstractC4262<T> throttleLatest(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new ObservableThrottleLatest(this, j, timeUnit, abstractC4585, z));
    }

    public final AbstractC4262<o2<T>> timeInterval(TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new C4236(this, timeUnit, abstractC4585));
    }

    public final AbstractC4262<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, null, C4877.m14600());
    }

    public final AbstractC4262<o2<T>> timestamp(TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return (AbstractC4262<o2<T>>) map(Functions.m6334(timeUnit, abstractC4585));
    }

    public final <U extends Collection<? super T>> AbstractC4838<U> toList(Callable<U> callable) {
        C4246.m13353(callable, "collectionSupplier is null");
        return C3671.m11800(new C2410(this, callable));
    }

    public final AbstractC4838<List<T>> toSortedList(Comparator<? super T> comparator, int i) {
        C4246.m13353(comparator, "comparator is null");
        return (AbstractC4838<List<T>>) toList(i).map(Functions.m6326(comparator));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, R> AbstractC4262<R> withLatestFrom(InterfaceC2856<T1> interfaceC2856, InterfaceC2856<T2> interfaceC28562, InterfaceC3482<? super T, ? super T1, ? super T2, R> interfaceC3482) {
        C4246.m13353(interfaceC2856, "o1 is null");
        C4246.m13353(interfaceC28562, "o2 is null");
        C4246.m13353(interfaceC3482, "combiner is null");
        return withLatestFrom((InterfaceC2856<?>[]) new InterfaceC2856[]{interfaceC2856, interfaceC28562}, Functions.m6336(interfaceC3482));
    }

    public final <U, R> AbstractC4262<R> zipWith(InterfaceC2856<? extends U> interfaceC2856, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        C4246.m13353(interfaceC2856, "other is null");
        return zip(this, interfaceC2856, interfaceC5247);
    }

    public static <T, S> AbstractC4262<T> generate(Callable<S> callable, InterfaceC5246<S, InterfaceC3487<T>> interfaceC5246) {
        C4246.m13353(interfaceC5246, "generator is null");
        return generate(callable, C3587.m11620(interfaceC5246), Functions.m6320());
    }

    public static AbstractC4262<Long> interval(long j, TimeUnit timeUnit) {
        return interval(j, j, timeUnit, C4877.m14600());
    }

    public final T blockingFirst(T t) {
        C3646 c3646 = new C3646();
        subscribe(c3646);
        T tM10001 = c3646.m10001();
        return tM10001 != null ? tM10001 : t;
    }

    public final T blockingLast(T t) {
        C2480 c2480 = new C2480();
        subscribe(c2480);
        T tM10001 = c2480.m10001();
        return tM10001 != null ? tM10001 : t;
    }

    public final void blockingSubscribe(InterfaceC5102<? super T> interfaceC5102) {
        C3693.m11842(this, interfaceC5102);
    }

    public final AbstractC4262<T> concatWith(InterfaceC3517<? extends T> interfaceC3517) {
        C4246.m13353(interfaceC3517, "other is null");
        return C3671.m11798(new ObservableConcatWithMaybe(this, interfaceC3517));
    }

    public final AbstractC4262<T> delay(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return delay(j, timeUnit, abstractC4585, false);
    }

    public final <K, V> AbstractC4262<AbstractC3101<K, V>> groupBy(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, boolean z, int i) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(interfaceC23682, "valueSelector is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableGroupBy(this, interfaceC2368, interfaceC23682, i, z));
    }

    public final AbstractC4262<T> mergeWith(InterfaceC3517<? extends T> interfaceC3517) {
        C4246.m13353(interfaceC3517, "other is null");
        return C3671.m11798(new ObservableMergeWithMaybe(this, interfaceC3517));
    }

    public final AbstractC4262<T> retry(long j, InterfaceC4178<? super Throwable> interfaceC4178) {
        if (j >= 0) {
            C4246.m13353(interfaceC4178, "predicate is null");
            return C3671.m11798(new ObservableRetryPredicate(this, j, interfaceC4178));
        }
        throw new IllegalArgumentException("times >= 0 required but it was " + j);
    }

    public final AbstractC4262<T> skipLast(long j, TimeUnit timeUnit, boolean z) {
        return skipLast(j, timeUnit, C4877.m14604(), z, bufferSize());
    }

    public final InterfaceC4478 subscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC2857<? super InterfaceC4478> interfaceC28573) {
        C4246.m13353(interfaceC2857, "onNext is null");
        C4246.m13353(interfaceC28572, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        C4246.m13353(interfaceC28573, "onSubscribe is null");
        LambdaObserver lambdaObserver = new LambdaObserver(interfaceC2857, interfaceC28572, interfaceC3809, interfaceC28573);
        subscribe(lambdaObserver);
        return lambdaObserver;
    }

    public final AbstractC4262<T> takeLast(long j, long j2, TimeUnit timeUnit) {
        return takeLast(j, j2, timeUnit, C4877.m14604(), false, bufferSize());
    }

    public final AbstractC4262<T> timeout(long j, TimeUnit timeUnit, InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return timeout0(j, timeUnit, interfaceC2856, C4877.m14600());
    }

    public final <K, V> AbstractC4838<Map<K, Collection<V>>> toMultimap(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682) {
        return toMultimap(interfaceC2368, interfaceC23682, HashMapSupplier.asCallable(), ArrayListSupplier.asFunction());
    }

    public static <T> AbstractC4262<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return fromFuture(future, j, timeUnit).subscribeOn(abstractC4585);
    }

    public static AbstractC4262<Long> interval(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return interval(j, j, timeUnit, abstractC4585);
    }

    public static <T> AbstractC4262<T> just(T t, T t2, T t3) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        return fromArray(t, t2, t3);
    }

    public static <T> AbstractC4262<T> merge(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856, int i) {
        C4246.m13353(interfaceC2856, "sources is null");
        C4246.m13354(i, "maxConcurrency");
        return C3671.m11798(new ObservableFlatMap(interfaceC2856, Functions.m6322(), false, i, bufferSize()));
    }

    public static <T> AbstractC4262<T> mergeDelayError(InterfaceC2856<? extends InterfaceC2856<? extends T>> interfaceC2856, int i) {
        C4246.m13353(interfaceC2856, "sources is null");
        C4246.m13354(i, "maxConcurrency");
        return C3671.m11798(new ObservableFlatMap(interfaceC2856, Functions.m6322(), true, i, bufferSize()));
    }

    public final AbstractC4262<T> delay(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new C4313(this, j, timeUnit, abstractC4585, z));
    }

    public final AbstractC4262<T> doOnEach(InterfaceC2857<? super C3906<T>> interfaceC2857) {
        C4246.m13353(interfaceC2857, "onNotification is null");
        return doOnEach(Functions.m6331(interfaceC2857), Functions.m6330(interfaceC2857), Functions.m6329(interfaceC2857), Functions.f6798);
    }

    public final AbstractC4262<T> sample(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11798(new ObservableSampleTimed(this, j, timeUnit, abstractC4585, z));
    }

    public final AbstractC4262<T> skipLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return skipLast(j, timeUnit, abstractC4585, false, bufferSize());
    }

    public final AbstractC4262<T> takeLast(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return takeLast(j, j2, timeUnit, abstractC4585, false, bufferSize());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> AbstractC4838<Map<K, V>> toMap(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, Callable<? extends Map<K, V>> callable) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(interfaceC23682, "valueSelector is null");
        C4246.m13353(callable, "mapSupplier is null");
        return (AbstractC4838<Map<K, V>>) collect(callable, Functions.m6344(interfaceC2368, interfaceC23682));
    }

    public final AbstractC4838<List<T>> toSortedList(int i) {
        return toSortedList(Functions.m6328(), i);
    }

    public final <U, R> AbstractC4262<R> zipWith(InterfaceC2856<? extends U> interfaceC2856, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, boolean z) {
        return zip(this, interfaceC2856, interfaceC5247, z);
    }

    public static <T, R> AbstractC4262<R> combineLatest(InterfaceC2856<? extends T>[] interfaceC2856Arr, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        return combineLatest(interfaceC2856Arr, interfaceC2368, bufferSize());
    }

    public static <T> AbstractC4262<T> concat(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        return concatArray(interfaceC2856, interfaceC28562);
    }

    public static <T, S> AbstractC4262<T> generate(Callable<S> callable, InterfaceC5246<S, InterfaceC3487<T>> interfaceC5246, InterfaceC2857<? super S> interfaceC2857) {
        C4246.m13353(interfaceC5246, "generator is null");
        return generate(callable, C3587.m11620(interfaceC5246), interfaceC2857);
    }

    public final <U extends Collection<? super T>> AbstractC4262<U> buffer(int i, Callable<U> callable) {
        return buffer(i, i, callable);
    }

    public final AbstractC4262<T> concatWith(InterfaceC2837 interfaceC2837) {
        C4246.m13353(interfaceC2837, "other is null");
        return C3671.m11798(new ObservableConcatWithCompletable(this, interfaceC2837));
    }

    public final AbstractC4262<T> mergeWith(InterfaceC2837 interfaceC2837) {
        C4246.m13353(interfaceC2837, "other is null");
        return C3671.m11798(new ObservableMergeWithCompletable(this, interfaceC2837));
    }

    public final <R> AbstractC4262<R> replay(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368, int i, long j, TimeUnit timeUnit) {
        return replay(interfaceC2368, i, j, timeUnit, C4877.m14600());
    }

    public final AbstractC4262<T> skipLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        return skipLast(j, timeUnit, abstractC4585, z, bufferSize());
    }

    public final AbstractC4262<T> takeLast(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z, int i) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13354(i, "bufferSize");
        if (j >= 0) {
            return C3671.m11798(new ObservableTakeLastTimed(this, j, j2, timeUnit, abstractC4585, i, z));
        }
        throw new IndexOutOfBoundsException("count >= 0 required but it was " + j);
    }

    public final AbstractC4262<T> timeout(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return timeout0(j, timeUnit, interfaceC2856, abstractC4585);
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, long j2, TimeUnit timeUnit) {
        return window(j, j2, timeUnit, C4877.m14600(), bufferSize());
    }

    public final <U, R> AbstractC4262<R> zipWith(InterfaceC2856<? extends U> interfaceC2856, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, boolean z, int i) {
        return zip(this, interfaceC2856, interfaceC5247, z, i);
    }

    public static <T, R> AbstractC4262<R> combineLatest(InterfaceC2856<? extends T>[] interfaceC2856Arr, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i) {
        C4246.m13353(interfaceC2856Arr, "sources is null");
        if (interfaceC2856Arr.length == 0) {
            return empty();
        }
        C4246.m13353(interfaceC2368, "combiner is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableCombineLatest(interfaceC2856Arr, null, interfaceC2368, i << 1, false));
    }

    public static <T, R> AbstractC4262<R> combineLatestDelayError(Iterable<? extends InterfaceC2856<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        return combineLatestDelayError(iterable, interfaceC2368, bufferSize());
    }

    public static <T> AbstractC4838<Boolean> sequenceEqual(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, int i) {
        return sequenceEqual(interfaceC2856, interfaceC28562, C4246.m13352(), i);
    }

    public final AbstractC4262<List<T>> buffer(long j, long j2, TimeUnit timeUnit) {
        return (AbstractC4262<List<T>>) buffer(j, j2, timeUnit, C4877.m14600(), ArrayListSupplier.asCallable());
    }

    public final <R> AbstractC4262<R> replay(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368, int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13354(i, "bufferSize");
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return ObservableReplay.m6859(C3587.m11617(this, i, j, timeUnit, abstractC4585), interfaceC2368);
    }

    public final AbstractC4262<T> retry(InterfaceC4178<? super Throwable> interfaceC4178) {
        return retry(Long.MAX_VALUE, interfaceC4178);
    }

    public final AbstractC4262<T> skipLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z, int i) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableSkipLastTimed(this, j, timeUnit, abstractC4585, i << 1, z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <K, V> AbstractC4838<Map<K, Collection<V>>> toMultimap(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, Callable<? extends Map<K, Collection<V>>> callable, InterfaceC2368<? super K, ? extends Collection<? super V>> interfaceC23683) {
        C4246.m13353(interfaceC2368, "keySelector is null");
        C4246.m13353(interfaceC23682, "valueSelector is null");
        C4246.m13353(callable, "mapSupplier is null");
        C4246.m13353(interfaceC23683, "collectionFactory is null");
        return (AbstractC4838<Map<K, Collection<V>>>) collect(callable, Functions.m6345(interfaceC2368, interfaceC23682, interfaceC23683));
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return window(j, j2, timeUnit, abstractC4585, bufferSize());
    }

    public static <T, R> AbstractC4262<R> combineLatestDelayError(Iterable<? extends InterfaceC2856<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368, int i) {
        C4246.m13353(iterable, "sources is null");
        C4246.m13353(interfaceC2368, "combiner is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableCombineLatest(null, iterable, interfaceC2368, i << 1, true));
    }

    public static <T> AbstractC4262<T> fromFuture(Future<? extends T> future, AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return fromFuture(future).subscribeOn(abstractC4585);
    }

    public static <T, S> AbstractC4262<T> generate(Callable<S> callable, InterfaceC5247<S, InterfaceC3487<T>, S> interfaceC5247) {
        return generate(callable, interfaceC5247, Functions.m6320());
    }

    public static <T> AbstractC4262<T> merge(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        return fromArray(interfaceC2856, interfaceC28562).flatMap(Functions.m6322(), false, 2);
    }

    public static <T> AbstractC4262<T> mergeDelayError(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        return fromArray(interfaceC2856, interfaceC28562).flatMap(Functions.m6322(), true, 2);
    }

    public static <T1, T2, R> AbstractC4262<R> zip(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        return zipArray(Functions.m6335(interfaceC5247), false, bufferSize(), interfaceC2856, interfaceC28562);
    }

    public final AbstractC4262<List<T>> buffer(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return (AbstractC4262<List<T>>) buffer(j, j2, timeUnit, abstractC4585, ArrayListSupplier.asCallable());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <U, V> AbstractC4262<T> delay(InterfaceC2856<U> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<V>> interfaceC2368) {
        return delaySubscription(interfaceC2856).delay(interfaceC2368);
    }

    public final <U> AbstractC4262<T> sample(InterfaceC2856<U> interfaceC2856) {
        C4246.m13353(interfaceC2856, "sampler is null");
        return C3671.m11798(new ObservableSampleWithObservable(this, interfaceC2856, false));
    }

    public final AbstractC4262<T> timeout(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return timeout0(j, timeUnit, null, abstractC4585);
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i) {
        C4246.m13355(j, "timespan");
        C4246.m13355(j2, "timeskip");
        C4246.m13354(i, "bufferSize");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13353(timeUnit, "unit is null");
        return C3671.m11798(new C4639(this, j, j2, timeUnit, abstractC4585, Long.MAX_VALUE, i, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, R> AbstractC4262<R> withLatestFrom(InterfaceC2856<T1> interfaceC2856, InterfaceC2856<T2> interfaceC28562, InterfaceC2856<T3> interfaceC28563, InterfaceC4216<? super T, ? super T1, ? super T2, ? super T3, R> interfaceC4216) {
        C4246.m13353(interfaceC2856, "o1 is null");
        C4246.m13353(interfaceC28562, "o2 is null");
        C4246.m13353(interfaceC28563, "o3 is null");
        C4246.m13353(interfaceC4216, "combiner is null");
        return withLatestFrom((InterfaceC2856<?>[]) new InterfaceC2856[]{interfaceC2856, interfaceC28562, interfaceC28563}, Functions.m6337(interfaceC4216));
    }

    public static <T> AbstractC4262<T> concat(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC2856<? extends T> interfaceC28563) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        return concatArray(interfaceC2856, interfaceC28562, interfaceC28563);
    }

    public static <T, S> AbstractC4262<T> generate(Callable<S> callable, InterfaceC5247<S, InterfaceC3487<T>, S> interfaceC5247, InterfaceC2857<? super S> interfaceC2857) {
        C4246.m13353(callable, "initialState is null");
        C4246.m13353(interfaceC5247, "generator is null");
        C4246.m13353(interfaceC2857, "disposeState is null");
        return C3671.m11798(new C5319(callable, interfaceC5247, interfaceC2857));
    }

    public static <T> AbstractC4262<T> just(T t, T t2, T t3, T t4) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        return fromArray(t, t2, t3, t4);
    }

    public final <U extends Collection<? super T>> AbstractC4262<U> buffer(long j, long j2, TimeUnit timeUnit, AbstractC4585 abstractC4585, Callable<U> callable) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13353(callable, "bufferSupplier is null");
        return C3671.m11798(new C3091(this, j, j2, timeUnit, abstractC4585, callable, Integer.MAX_VALUE, false));
    }

    public final <U, V> AbstractC4262<T> timeout(InterfaceC2856<U> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<V>> interfaceC2368) {
        C4246.m13353(interfaceC2856, "firstTimeoutIndicator is null");
        return timeout0(interfaceC2856, interfaceC2368, null);
    }

    public final AbstractC4262<T> doOnEach(InterfaceC5102<? super T> interfaceC5102) {
        C4246.m13353(interfaceC5102, "observer is null");
        return doOnEach(C3587.m11614(interfaceC5102), C3587.m11613(interfaceC5102), C3587.m11612(interfaceC5102), Functions.f6798);
    }

    public final <U> AbstractC4262<T> sample(InterfaceC2856<U> interfaceC2856, boolean z) {
        C4246.m13353(interfaceC2856, "sampler is null");
        return C3671.m11798(new ObservableSampleWithObservable(this, interfaceC2856, z));
    }

    @Override // defpackage.InterfaceC2856
    public final void subscribe(InterfaceC5102<? super T> interfaceC5102) {
        C4246.m13353(interfaceC5102, "observer is null");
        try {
            InterfaceC5102<? super T> interfaceC5102M11809 = C3671.m11809(this, interfaceC5102);
            C4246.m13353(interfaceC5102M11809, "The RxJavaPlugins.onSubscribe hook returned a null Observer. Please change the handler provided to RxJavaPlugins.setOnObservableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            subscribeActual(interfaceC5102M11809);
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

    public static <T> AbstractC4262<T> merge(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC2856<? extends T> interfaceC28563) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        return fromArray(interfaceC2856, interfaceC28562, interfaceC28563).flatMap(Functions.m6322(), false, 3);
    }

    public static <T> AbstractC4262<T> mergeDelayError(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC2856<? extends T> interfaceC28563) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        return fromArray(interfaceC2856, interfaceC28562, interfaceC28563).flatMap(Functions.m6322(), true, 3);
    }

    public static <T1, T2, R> AbstractC4262<R> zip(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247, boolean z) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        return zipArray(Functions.m6335(interfaceC5247), z, bufferSize(), interfaceC2856, interfaceC28562);
    }

    public final <R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, InterfaceC2368<? super Throwable, ? extends InterfaceC2856<? extends R>> interfaceC23682, Callable<? extends InterfaceC2856<? extends R>> callable) {
        C4246.m13353(interfaceC2368, "onNextMapper is null");
        C4246.m13353(interfaceC23682, "onErrorMapper is null");
        C4246.m13353(callable, "onCompleteSupplier is null");
        return merge(new C5081(this, interfaceC2368, interfaceC23682, callable));
    }

    public final AbstractC4262<T> takeLast(long j, TimeUnit timeUnit) {
        return takeLast(j, timeUnit, C4877.m14604(), false, bufferSize());
    }

    public final <U, V> AbstractC4262<T> timeout(InterfaceC2856<U> interfaceC2856, InterfaceC2368<? super T, ? extends InterfaceC2856<V>> interfaceC2368, InterfaceC2856<? extends T> interfaceC28562) {
        C4246.m13353(interfaceC2856, "firstTimeoutIndicator is null");
        C4246.m13353(interfaceC28562, "other is null");
        return timeout0(interfaceC2856, interfaceC2368, interfaceC28562);
    }

    public final AbstractC4262<T> takeLast(long j, TimeUnit timeUnit, boolean z) {
        return takeLast(j, timeUnit, C4877.m14604(), z, bufferSize());
    }

    public final <K, V> AbstractC4838<Map<K, Collection<V>>> toMultimap(InterfaceC2368<? super T, ? extends K> interfaceC2368, InterfaceC2368<? super T, ? extends V> interfaceC23682, Callable<Map<K, Collection<V>>> callable) {
        return toMultimap(interfaceC2368, interfaceC23682, callable, ArrayListSupplier.asFunction());
    }

    public static <T1, T2, R> AbstractC4262<R> combineLatest(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        return combineLatest(Functions.m6335(interfaceC5247), bufferSize(), interfaceC2856, interfaceC28562);
    }

    public static <T> AbstractC4262<T> concat(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC2856<? extends T> interfaceC28563, InterfaceC2856<? extends T> interfaceC28564) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        return concatArray(interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564);
    }

    public final AbstractC4262<List<T>> buffer(long j, TimeUnit timeUnit) {
        return buffer(j, timeUnit, C4877.m14600(), Integer.MAX_VALUE);
    }

    public final <R> AbstractC4262<R> replay(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368, int i, AbstractC4585 abstractC4585) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13354(i, "bufferSize");
        return ObservableReplay.m6859(C3587.m11616(this, i), C3587.m11619(interfaceC2368, abstractC4585));
    }

    public final AbstractC4262<T> takeLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return takeLast(j, timeUnit, abstractC4585, false, bufferSize());
    }

    public static <T> AbstractC4262<T> just(T t, T t2, T t3, T t4, T t5) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        C4246.m13353(t5, "item5 is null");
        return fromArray(t, t2, t3, t4, t5);
    }

    public static <T1, T2, R> AbstractC4262<R> zip(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247, boolean z, int i) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        return zipArray(Functions.m6335(interfaceC5247), z, i, interfaceC2856, interfaceC28562);
    }

    public final AbstractC4262<List<T>> buffer(long j, TimeUnit timeUnit, int i) {
        return buffer(j, timeUnit, C4877.m14600(), i);
    }

    public final AbstractC4262<T> takeLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        return takeLast(j, timeUnit, abstractC4585, z, bufferSize());
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, TimeUnit timeUnit) {
        return window(j, timeUnit, C4877.m14600(), Long.MAX_VALUE, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T1, T2, T3, T4, R> AbstractC4262<R> withLatestFrom(InterfaceC2856<T1> interfaceC2856, InterfaceC2856<T2> interfaceC28562, InterfaceC2856<T3> interfaceC28563, InterfaceC2856<T4> interfaceC28564, InterfaceC2568<? super T, ? super T1, ? super T2, ? super T3, ? super T4, R> interfaceC2568) {
        C4246.m13353(interfaceC2856, "o1 is null");
        C4246.m13353(interfaceC28562, "o2 is null");
        C4246.m13353(interfaceC28563, "o3 is null");
        C4246.m13353(interfaceC28564, "o4 is null");
        C4246.m13353(interfaceC2568, "combiner is null");
        return withLatestFrom((InterfaceC2856<?>[]) new InterfaceC2856[]{interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564}, Functions.m6338(interfaceC2568));
    }

    public static <T> AbstractC4262<T> merge(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC2856<? extends T> interfaceC28563, InterfaceC2856<? extends T> interfaceC28564) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        return fromArray(interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564).flatMap(Functions.m6322(), false, 4);
    }

    public static <T> AbstractC4262<T> mergeDelayError(InterfaceC2856<? extends T> interfaceC2856, InterfaceC2856<? extends T> interfaceC28562, InterfaceC2856<? extends T> interfaceC28563, InterfaceC2856<? extends T> interfaceC28564) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        return fromArray(interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564).flatMap(Functions.m6322(), true, 4);
    }

    public final AbstractC4262<List<T>> buffer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i) {
        return (AbstractC4262<List<T>>) buffer(j, timeUnit, abstractC4585, i, ArrayListSupplier.asCallable(), false);
    }

    public final <R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, InterfaceC2368<Throwable, ? extends InterfaceC2856<? extends R>> interfaceC23682, Callable<? extends InterfaceC2856<? extends R>> callable, int i) {
        C4246.m13353(interfaceC2368, "onNextMapper is null");
        C4246.m13353(interfaceC23682, "onErrorMapper is null");
        C4246.m13353(callable, "onCompleteSupplier is null");
        return merge(new C5081(this, interfaceC2368, interfaceC23682, callable), i);
    }

    public final AbstractC4262<T> takeLast(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z, int i) {
        return takeLast(Long.MAX_VALUE, j, timeUnit, abstractC4585, z, i);
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, TimeUnit timeUnit, long j2) {
        return window(j, timeUnit, C4877.m14600(), j2, false);
    }

    public static <T1, T2, T3, R> AbstractC4262<R> combineLatest(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC3482<? super T1, ? super T2, ? super T3, ? extends R> interfaceC3482) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        return combineLatest(Functions.m6336(interfaceC3482), bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563);
    }

    public final <U extends Collection<? super T>> AbstractC4262<U> buffer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, int i, Callable<U> callable, boolean z) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13353(callable, "bufferSupplier is null");
        C4246.m13354(i, "count");
        return C3671.m11798(new C3091(this, j, j, timeUnit, abstractC4585, callable, i, z));
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, TimeUnit timeUnit, long j2, boolean z) {
        return window(j, timeUnit, C4877.m14600(), j2, z);
    }

    public static <T1, T2, T3, R> AbstractC4262<R> zip(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC3482<? super T1, ? super T2, ? super T3, ? extends R> interfaceC3482) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        return zipArray(Functions.m6336(interfaceC3482), false, bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563);
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return window(j, timeUnit, abstractC4585, Long.MAX_VALUE, false);
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, long j2) {
        return window(j, timeUnit, abstractC4585, j2, false);
    }

    public final <R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368, int i) {
        return flatMap((InterfaceC2368) interfaceC2368, false, i, bufferSize());
    }

    public final <R> AbstractC4262<R> replay(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368, long j, TimeUnit timeUnit) {
        return replay(interfaceC2368, j, timeUnit, C4877.m14600());
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, long j2, boolean z) {
        return window(j, timeUnit, abstractC4585, j2, z, bufferSize());
    }

    public static <T1, T2, T3, T4, R> AbstractC4262<R> combineLatest(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC4216<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> interfaceC4216) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        return combineLatest(Functions.m6337(interfaceC4216), bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564);
    }

    public static <T> AbstractC4262<T> just(T t, T t2, T t3, T t4, T t5, T t6) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        C4246.m13353(t5, "item5 is null");
        C4246.m13353(t6, "item6 is null");
        return fromArray(t, t2, t3, t4, t5, t6);
    }

    public final <U, R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        return flatMap(interfaceC2368, interfaceC5247, false, bufferSize(), bufferSize());
    }

    public final <R> AbstractC4262<R> replay(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return ObservableReplay.m6859(C3587.m11618(this, j, timeUnit, abstractC4585), interfaceC2368);
    }

    public final AbstractC4262<AbstractC4262<T>> window(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, long j2, boolean z, int i) {
        C4246.m13354(i, "bufferSize");
        C4246.m13353(abstractC4585, "scheduler is null");
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13355(j2, "count");
        return C3671.m11798(new C4639(this, j, j, timeUnit, abstractC4585, j2, i, z));
    }

    public static <T1, T2, T3, T4, R> AbstractC4262<R> zip(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC4216<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> interfaceC4216) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        return zipArray(Functions.m6337(interfaceC4216), false, bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564);
    }

    public final AbstractC4262<List<T>> buffer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return (AbstractC4262<List<T>>) buffer(j, timeUnit, abstractC4585, Integer.MAX_VALUE, ArrayListSupplier.asCallable(), false);
    }

    public final <U, R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, boolean z) {
        return flatMap(interfaceC2368, interfaceC5247, z, bufferSize(), bufferSize());
    }

    public final <R> AbstractC4262<R> withLatestFrom(InterfaceC2856<?>[] interfaceC2856Arr, InterfaceC2368<? super Object[], R> interfaceC2368) {
        C4246.m13353(interfaceC2856Arr, "others is null");
        C4246.m13353(interfaceC2368, "combiner is null");
        return C3671.m11798(new ObservableWithLatestFromMany(this, interfaceC2856Arr, interfaceC2368));
    }

    public final <TOpening, TClosing> AbstractC4262<List<T>> buffer(InterfaceC2856<? extends TOpening> interfaceC2856, InterfaceC2368<? super TOpening, ? extends InterfaceC2856<? extends TClosing>> interfaceC2368) {
        return (AbstractC4262<List<T>>) buffer(interfaceC2856, interfaceC2368, ArrayListSupplier.asCallable());
    }

    public final <U, R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, boolean z, int i) {
        return flatMap(interfaceC2368, interfaceC5247, z, i, bufferSize());
    }

    public final <TOpening, TClosing, U extends Collection<? super T>> AbstractC4262<U> buffer(InterfaceC2856<? extends TOpening> interfaceC2856, InterfaceC2368<? super TOpening, ? extends InterfaceC2856<? extends TClosing>> interfaceC2368, Callable<U> callable) {
        C4246.m13353(interfaceC2856, "openingIndicator is null");
        C4246.m13353(interfaceC2368, "closingIndicator is null");
        C4246.m13353(callable, "bufferSupplier is null");
        return C3671.m11798(new ObservableBufferBoundary(this, interfaceC2856, interfaceC2368, callable));
    }

    public final <U, R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, boolean z, int i, int i2) {
        C4246.m13353(interfaceC2368, "mapper is null");
        C4246.m13353(interfaceC5247, "combiner is null");
        return flatMap(C3587.m11610(interfaceC2368, interfaceC5247), z, i, i2);
    }

    public final <R> AbstractC4262<R> replay(InterfaceC2368<? super AbstractC4262<T>, ? extends InterfaceC2856<R>> interfaceC2368, AbstractC4585 abstractC4585) {
        C4246.m13353(interfaceC2368, "selector is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return ObservableReplay.m6859(C3587.m11615(this), C3587.m11619(interfaceC2368, abstractC4585));
    }

    public final <R> AbstractC4262<R> withLatestFrom(Iterable<? extends InterfaceC2856<?>> iterable, InterfaceC2368<? super Object[], R> interfaceC2368) {
        C4246.m13353(iterable, "others is null");
        C4246.m13353(interfaceC2368, "combiner is null");
        return C3671.m11798(new ObservableWithLatestFromMany(this, iterable, interfaceC2368));
    }

    public static <T1, T2, T3, T4, T5, R> AbstractC4262<R> combineLatest(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC2856<? extends T5> interfaceC28565, InterfaceC2568<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> interfaceC2568) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        C4246.m13353(interfaceC28565, "source5 is null");
        return combineLatest(Functions.m6338(interfaceC2568), bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564, interfaceC28565);
    }

    public final <B> AbstractC4262<AbstractC4262<T>> window(InterfaceC2856<B> interfaceC2856) {
        return window(interfaceC2856, bufferSize());
    }

    public static <T1, T2, T3, T4, T5, R> AbstractC4262<R> zip(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC2856<? extends T5> interfaceC28565, InterfaceC2568<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> interfaceC2568) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        C4246.m13353(interfaceC28565, "source5 is null");
        return zipArray(Functions.m6338(interfaceC2568), false, bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564, interfaceC28565);
    }

    public final <U, R> AbstractC4262<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends U>> interfaceC2368, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247, int i) {
        return flatMap(interfaceC2368, interfaceC5247, false, i, bufferSize());
    }

    public final <B> AbstractC4262<AbstractC4262<T>> window(InterfaceC2856<B> interfaceC2856, int i) {
        C4246.m13353(interfaceC2856, "boundary is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableWindowBoundary(this, interfaceC2856, i));
    }

    public static <T> AbstractC4262<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7) {
        C4246.m13353(t, "item1 is null");
        C4246.m13353(t2, "item2 is null");
        C4246.m13353(t3, "item3 is null");
        C4246.m13353(t4, "item4 is null");
        C4246.m13353(t5, "item5 is null");
        C4246.m13353(t6, "item6 is null");
        C4246.m13353(t7, "item7 is null");
        return fromArray(t, t2, t3, t4, t5, t6, t7);
    }

    public final <B> AbstractC4262<List<T>> buffer(InterfaceC2856<B> interfaceC2856) {
        return (AbstractC4262<List<T>>) buffer(interfaceC2856, ArrayListSupplier.asCallable());
    }

    public final <B> AbstractC4262<List<T>> buffer(InterfaceC2856<B> interfaceC2856, int i) {
        C4246.m13354(i, "initialCapacity");
        return (AbstractC4262<List<T>>) buffer(interfaceC2856, Functions.m6318(i));
    }

    public final AbstractC4945<T> replay(int i) {
        C4246.m13354(i, "bufferSize");
        return ObservableReplay.m6854(this, i);
    }

    public final <U, V> AbstractC4262<AbstractC4262<T>> window(InterfaceC2856<U> interfaceC2856, InterfaceC2368<? super U, ? extends InterfaceC2856<V>> interfaceC2368) {
        return window(interfaceC2856, interfaceC2368, bufferSize());
    }

    public final <B, U extends Collection<? super T>> AbstractC4262<U> buffer(InterfaceC2856<B> interfaceC2856, Callable<U> callable) {
        C4246.m13353(interfaceC2856, "boundary is null");
        C4246.m13353(callable, "bufferSupplier is null");
        return C3671.m11798(new C4223(this, interfaceC2856, callable));
    }

    public final <U, V> AbstractC4262<AbstractC4262<T>> window(InterfaceC2856<U> interfaceC2856, InterfaceC2368<? super U, ? extends InterfaceC2856<V>> interfaceC2368, int i) {
        C4246.m13353(interfaceC2856, "openingIndicator is null");
        C4246.m13353(interfaceC2368, "closingIndicator is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new C5314(this, interfaceC2856, interfaceC2368, i));
    }

    public static <T1, T2, T3, T4, T5, T6, R> AbstractC4262<R> combineLatest(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC2856<? extends T5> interfaceC28565, InterfaceC2856<? extends T6> interfaceC28566, InterfaceC2485<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> interfaceC2485) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        C4246.m13353(interfaceC28565, "source5 is null");
        C4246.m13353(interfaceC28566, "source6 is null");
        return combineLatest(Functions.m6339(interfaceC2485), bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564, interfaceC28565, interfaceC28566);
    }

    public final AbstractC4945<T> replay(int i, long j, TimeUnit timeUnit) {
        return replay(i, j, timeUnit, C4877.m14600());
    }

    public static <T1, T2, T3, T4, T5, T6, R> AbstractC4262<R> zip(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC2856<? extends T5> interfaceC28565, InterfaceC2856<? extends T6> interfaceC28566, InterfaceC2485<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> interfaceC2485) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        C4246.m13353(interfaceC28565, "source5 is null");
        C4246.m13353(interfaceC28566, "source6 is null");
        return zipArray(Functions.m6339(interfaceC2485), false, bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564, interfaceC28565, interfaceC28566);
    }

    public final AbstractC4945<T> replay(int i, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13354(i, "bufferSize");
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return ObservableReplay.m6856(this, j, timeUnit, abstractC4585, i);
    }

    public final <B> AbstractC4262<List<T>> buffer(Callable<? extends InterfaceC2856<B>> callable) {
        return (AbstractC4262<List<T>>) buffer(callable, ArrayListSupplier.asCallable());
    }

    public final <B, U extends Collection<? super T>> AbstractC4262<U> buffer(Callable<? extends InterfaceC2856<B>> callable, Callable<U> callable2) {
        C4246.m13353(callable, "boundarySupplier is null");
        C4246.m13353(callable2, "bufferSupplier is null");
        return C3671.m11798(new C4275(this, callable, callable2));
    }

    public final <B> AbstractC4262<AbstractC4262<T>> window(Callable<? extends InterfaceC2856<B>> callable) {
        return window(callable, bufferSize());
    }

    public static <T> AbstractC4262<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8) {
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

    public final <B> AbstractC4262<AbstractC4262<T>> window(Callable<? extends InterfaceC2856<B>> callable, int i) {
        C4246.m13353(callable, "boundary is null");
        C4246.m13354(i, "bufferSize");
        return C3671.m11798(new ObservableWindowBoundarySupplier(this, callable, i));
    }

    public final AbstractC4945<T> replay(int i, AbstractC4585 abstractC4585) {
        C4246.m13354(i, "bufferSize");
        return ObservableReplay.m6860(replay(i), abstractC4585);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> AbstractC4262<R> combineLatest(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC2856<? extends T5> interfaceC28565, InterfaceC2856<? extends T6> interfaceC28566, InterfaceC2856<? extends T7> interfaceC28567, InterfaceC2825<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> interfaceC2825) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        C4246.m13353(interfaceC28565, "source5 is null");
        C4246.m13353(interfaceC28566, "source6 is null");
        C4246.m13353(interfaceC28567, "source7 is null");
        return combineLatest(Functions.m6340(interfaceC2825), bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564, interfaceC28565, interfaceC28566, interfaceC28567);
    }

    public final AbstractC4945<T> replay(long j, TimeUnit timeUnit) {
        return replay(j, timeUnit, C4877.m14600());
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> AbstractC4262<R> zip(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC2856<? extends T5> interfaceC28565, InterfaceC2856<? extends T6> interfaceC28566, InterfaceC2856<? extends T7> interfaceC28567, InterfaceC2825<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> interfaceC2825) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        C4246.m13353(interfaceC28565, "source5 is null");
        C4246.m13353(interfaceC28566, "source6 is null");
        C4246.m13353(interfaceC28567, "source7 is null");
        return zipArray(Functions.m6340(interfaceC2825), false, bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564, interfaceC28565, interfaceC28566, interfaceC28567);
    }

    public final AbstractC4945<T> replay(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return ObservableReplay.m6855(this, j, timeUnit, abstractC4585);
    }

    public final AbstractC4945<T> replay(AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return ObservableReplay.m6860(replay(), abstractC4585);
    }

    public static <T> AbstractC4262<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9) {
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

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> AbstractC4262<R> combineLatest(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC2856<? extends T5> interfaceC28565, InterfaceC2856<? extends T6> interfaceC28566, InterfaceC2856<? extends T7> interfaceC28567, InterfaceC2856<? extends T8> interfaceC28568, InterfaceC4399<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> interfaceC4399) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        C4246.m13353(interfaceC28565, "source5 is null");
        C4246.m13353(interfaceC28566, "source6 is null");
        C4246.m13353(interfaceC28567, "source7 is null");
        C4246.m13353(interfaceC28568, "source8 is null");
        return combineLatest(Functions.m6341(interfaceC4399), bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564, interfaceC28565, interfaceC28566, interfaceC28567, interfaceC28568);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> AbstractC4262<R> zip(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC2856<? extends T5> interfaceC28565, InterfaceC2856<? extends T6> interfaceC28566, InterfaceC2856<? extends T7> interfaceC28567, InterfaceC2856<? extends T8> interfaceC28568, InterfaceC4399<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> interfaceC4399) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        C4246.m13353(interfaceC28565, "source5 is null");
        C4246.m13353(interfaceC28566, "source6 is null");
        C4246.m13353(interfaceC28567, "source7 is null");
        C4246.m13353(interfaceC28568, "source8 is null");
        return zipArray(Functions.m6341(interfaceC4399), false, bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564, interfaceC28565, interfaceC28566, interfaceC28567, interfaceC28568);
    }

    public static <T> AbstractC4262<T> just(T t, T t2, T t3, T t4, T t5, T t6, T t7, T t8, T t9, T t10) {
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

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> AbstractC4262<R> combineLatest(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC2856<? extends T5> interfaceC28565, InterfaceC2856<? extends T6> interfaceC28566, InterfaceC2856<? extends T7> interfaceC28567, InterfaceC2856<? extends T8> interfaceC28568, InterfaceC2856<? extends T9> interfaceC28569, InterfaceC2954<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> interfaceC2954) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        C4246.m13353(interfaceC28565, "source5 is null");
        C4246.m13353(interfaceC28566, "source6 is null");
        C4246.m13353(interfaceC28567, "source7 is null");
        C4246.m13353(interfaceC28568, "source8 is null");
        C4246.m13353(interfaceC28569, "source9 is null");
        return combineLatest(Functions.m6342(interfaceC2954), bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564, interfaceC28565, interfaceC28566, interfaceC28567, interfaceC28568, interfaceC28569);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> AbstractC4262<R> zip(InterfaceC2856<? extends T1> interfaceC2856, InterfaceC2856<? extends T2> interfaceC28562, InterfaceC2856<? extends T3> interfaceC28563, InterfaceC2856<? extends T4> interfaceC28564, InterfaceC2856<? extends T5> interfaceC28565, InterfaceC2856<? extends T6> interfaceC28566, InterfaceC2856<? extends T7> interfaceC28567, InterfaceC2856<? extends T8> interfaceC28568, InterfaceC2856<? extends T9> interfaceC28569, InterfaceC2954<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> interfaceC2954) {
        C4246.m13353(interfaceC2856, "source1 is null");
        C4246.m13353(interfaceC28562, "source2 is null");
        C4246.m13353(interfaceC28563, "source3 is null");
        C4246.m13353(interfaceC28564, "source4 is null");
        C4246.m13353(interfaceC28565, "source5 is null");
        C4246.m13353(interfaceC28566, "source6 is null");
        C4246.m13353(interfaceC28567, "source7 is null");
        C4246.m13353(interfaceC28568, "source8 is null");
        C4246.m13353(interfaceC28569, "source9 is null");
        return zipArray(Functions.m6342(interfaceC2954), false, bufferSize(), interfaceC2856, interfaceC28562, interfaceC28563, interfaceC28564, interfaceC28565, interfaceC28566, interfaceC28567, interfaceC28568, interfaceC28569);
    }
}
