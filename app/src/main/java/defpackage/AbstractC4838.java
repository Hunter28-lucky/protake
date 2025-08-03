package defpackage;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.BiConsumerSingleObserver;
import io.reactivex.internal.observers.ConsumerSingleObserver;
import io.reactivex.internal.operators.flowable.FlowableConcatMap;
import io.reactivex.internal.operators.mixed.SingleFlatMapObservable;
import io.reactivex.internal.operators.observable.ObservableConcatMap;
import io.reactivex.internal.operators.single.C2109;
import io.reactivex.internal.operators.single.C2111;
import io.reactivex.internal.operators.single.SingleCache;
import io.reactivex.internal.operators.single.SingleCreate;
import io.reactivex.internal.operators.single.SingleDelayWithCompletable;
import io.reactivex.internal.operators.single.SingleDelayWithObservable;
import io.reactivex.internal.operators.single.SingleDelayWithPublisher;
import io.reactivex.internal.operators.single.SingleDelayWithSingle;
import io.reactivex.internal.operators.single.SingleDoFinally;
import io.reactivex.internal.operators.single.SingleDoOnDispose;
import io.reactivex.internal.operators.single.SingleFlatMap;
import io.reactivex.internal.operators.single.SingleFlatMapCompletable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableFlowable;
import io.reactivex.internal.operators.single.SingleFlatMapIterableObservable;
import io.reactivex.internal.operators.single.SingleFlatMapMaybe;
import io.reactivex.internal.operators.single.SingleFlatMapPublisher;
import io.reactivex.internal.operators.single.SingleInternalHelper;
import io.reactivex.internal.operators.single.SingleObserveOn;
import io.reactivex.internal.operators.single.SingleResumeNext;
import io.reactivex.internal.operators.single.SingleSubscribeOn;
import io.reactivex.internal.operators.single.SingleTakeUntil;
import io.reactivex.internal.operators.single.SingleTimeout;
import io.reactivex.internal.operators.single.SingleTimer;
import io.reactivex.internal.operators.single.SingleToFlowable;
import io.reactivex.internal.operators.single.SingleToObservable;
import io.reactivex.internal.operators.single.SingleUnsubscribeOn;
import io.reactivex.internal.operators.single.SingleUsing;
import io.reactivex.internal.operators.single.SingleZipArray;
import io.reactivex.internal.util.ErrorMode;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.observers.TestObserver;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.reactivestreams.Publisher;

/* compiled from: Single.java */
/* renamed from: බ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC4838<T> implements InterfaceC3951<T> {
    public static <T> AbstractC4838<T> amb(Iterable<? extends InterfaceC3951<? extends T>> iterable) {
        C4246.m13353(iterable, "sources is null");
        return C3671.m11800(new C2546(null, iterable));
    }

    public static <T> AbstractC4838<T> ambArray(InterfaceC3951<? extends T>... interfaceC3951Arr) {
        return interfaceC3951Arr.length == 0 ? error(SingleInternalHelper.m6954()) : interfaceC3951Arr.length == 1 ? wrap(interfaceC3951Arr[0]) : C3671.m11800(new C2546(interfaceC3951Arr, null));
    }

    public static <T> AbstractC3630<T> concat(Iterable<? extends InterfaceC3951<? extends T>> iterable) {
        return concat(AbstractC3630.fromIterable(iterable));
    }

    public static <T> AbstractC3630<T> concatArray(InterfaceC3951<? extends T>... interfaceC3951Arr) {
        return C3671.m11796(new FlowableConcatMap(AbstractC3630.fromArray(interfaceC3951Arr), SingleInternalHelper.m6955(), 2, ErrorMode.BOUNDARY));
    }

    public static <T> AbstractC3630<T> concatArrayEager(InterfaceC3951<? extends T>... interfaceC3951Arr) {
        return AbstractC3630.fromArray(interfaceC3951Arr).concatMapEager(SingleInternalHelper.m6955());
    }

    public static <T> AbstractC3630<T> concatEager(Publisher<? extends InterfaceC3951<? extends T>> publisher) {
        return AbstractC3630.fromPublisher(publisher).concatMapEager(SingleInternalHelper.m6955());
    }

    public static <T> AbstractC4838<T> create(InterfaceC4807<T> interfaceC4807) {
        C4246.m13353(interfaceC4807, "source is null");
        return C3671.m11800(new SingleCreate(interfaceC4807));
    }

    public static <T> AbstractC4838<T> defer(Callable<? extends InterfaceC3951<? extends T>> callable) {
        C4246.m13353(callable, "singleSupplier is null");
        return C3671.m11800(new C4504(callable));
    }

    public static <T> AbstractC4838<Boolean> equals(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512) {
        C4246.m13353(interfaceC3951, "first is null");
        C4246.m13353(interfaceC39512, "second is null");
        return C3671.m11800(new C4772(interfaceC3951, interfaceC39512));
    }

    public static <T> AbstractC4838<T> error(Callable<? extends Throwable> callable) {
        C4246.m13353(callable, "errorSupplier is null");
        return C3671.m11800(new C4791(callable));
    }

    public static <T> AbstractC4838<T> fromCallable(Callable<? extends T> callable) {
        C4246.m13353(callable, "callable is null");
        return C3671.m11800(new C4796(callable));
    }

    public static <T> AbstractC4838<T> fromFuture(Future<? extends T> future) {
        return toSingle(AbstractC3630.fromFuture(future));
    }

    public static <T> AbstractC4838<T> fromObservable(InterfaceC2856<? extends T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "observableSource is null");
        return C3671.m11800(new C3876(interfaceC2856, null));
    }

    public static <T> AbstractC4838<T> fromPublisher(Publisher<? extends T> publisher) {
        C4246.m13353(publisher, "publisher is null");
        return C3671.m11800(new C4833(publisher));
    }

    public static <T> AbstractC4838<T> just(T t) {
        C4246.m13353(t, "item is null");
        return C3671.m11800(new C4751(t));
    }

    public static <T> AbstractC3630<T> merge(Iterable<? extends InterfaceC3951<? extends T>> iterable) {
        return merge(AbstractC3630.fromIterable(iterable));
    }

    public static <T> AbstractC3630<T> mergeDelayError(Iterable<? extends InterfaceC3951<? extends T>> iterable) {
        return mergeDelayError(AbstractC3630.fromIterable(iterable));
    }

    public static <T> AbstractC4838<T> never() {
        return C3671.m11800(C4781.f16120);
    }

    private AbstractC4838<T> timeout0(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, InterfaceC3951<? extends T> interfaceC3951) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11800(new SingleTimeout(this, j, timeUnit, abstractC4585, interfaceC3951));
    }

    public static AbstractC4838<Long> timer(long j, TimeUnit timeUnit) {
        return timer(j, timeUnit, C4877.m14600());
    }

    private static <T> AbstractC4838<T> toSingle(AbstractC3630<T> abstractC3630) {
        return C3671.m11800(new C3626(abstractC3630, null));
    }

    public static <T> AbstractC4838<T> unsafeCreate(InterfaceC3951<T> interfaceC3951) {
        C4246.m13353(interfaceC3951, "onSubscribe is null");
        if (interfaceC3951 instanceof AbstractC4838) {
            throw new IllegalArgumentException("unsafeCreate(Single) should be upgraded");
        }
        return C3671.m11800(new C4776(interfaceC3951));
    }

    public static <T, U> AbstractC4838<T> using(Callable<U> callable, InterfaceC2368<? super U, ? extends InterfaceC3951<? extends T>> interfaceC2368, InterfaceC2857<? super U> interfaceC2857) {
        return using(callable, interfaceC2368, interfaceC2857, true);
    }

    public static <T> AbstractC4838<T> wrap(InterfaceC3951<T> interfaceC3951) {
        C4246.m13353(interfaceC3951, "source is null");
        return interfaceC3951 instanceof AbstractC4838 ? C3671.m11800((AbstractC4838) interfaceC3951) : C3671.m11800(new C4776(interfaceC3951));
    }

    public static <T, R> AbstractC4838<R> zip(Iterable<? extends InterfaceC3951<? extends T>> iterable, InterfaceC2368<? super Object[], ? extends R> interfaceC2368) {
        C4246.m13353(interfaceC2368, "zipper is null");
        C4246.m13353(iterable, "sources is null");
        return C3671.m11800(new C2111(iterable, interfaceC2368));
    }

    public static <T, R> AbstractC4838<R> zipArray(InterfaceC2368<? super Object[], ? extends R> interfaceC2368, InterfaceC3951<? extends T>... interfaceC3951Arr) {
        C4246.m13353(interfaceC2368, "zipper is null");
        C4246.m13353(interfaceC3951Arr, "sources is null");
        return interfaceC3951Arr.length == 0 ? error(new NoSuchElementException()) : C3671.m11800(new SingleZipArray(interfaceC3951Arr, interfaceC2368));
    }

    public final AbstractC4838<T> ambWith(InterfaceC3951<? extends T> interfaceC3951) {
        C4246.m13353(interfaceC3951, "other is null");
        return ambArray(this, interfaceC3951);
    }

    public final <R> R as(InterfaceC4597<T, ? extends R> interfaceC4597) {
        return (R) ((InterfaceC4597) C4246.m13353(interfaceC4597, "converter is null")).apply(this);
    }

    public final T blockingGet() {
        C2350 c2350 = new C2350();
        subscribe(c2350);
        return (T) c2350.m8797();
    }

    public final AbstractC4838<T> cache() {
        return C3671.m11800(new SingleCache(this));
    }

    public final <U> AbstractC4838<U> cast(Class<? extends U> cls) {
        C4246.m13353(cls, "clazz is null");
        return (AbstractC4838<U>) map(Functions.m6317(cls));
    }

    public final <R> AbstractC4838<R> compose(InterfaceC4452<? super T, ? extends R> interfaceC4452) {
        return wrap(((InterfaceC4452) C4246.m13353(interfaceC4452, "transformer is null")).apply(this));
    }

    public final AbstractC3630<T> concatWith(InterfaceC3951<? extends T> interfaceC3951) {
        return concat(this, interfaceC3951);
    }

    public final AbstractC4838<Boolean> contains(Object obj) {
        return contains(obj, C4246.m13352());
    }

    public final AbstractC4838<T> delay(long j, TimeUnit timeUnit) {
        return delay(j, timeUnit, C4877.m14600(), false);
    }

    public final AbstractC4838<T> delaySubscription(InterfaceC2837 interfaceC2837) {
        C4246.m13353(interfaceC2837, "other is null");
        return C3671.m11800(new SingleDelayWithCompletable(this, interfaceC2837));
    }

    public final <R> AbstractC4274<R> dematerialize(InterfaceC2368<? super T, C3906<R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "selector is null");
        return C3671.m11797(new C2947(this, interfaceC2368));
    }

    public final AbstractC4838<T> doAfterSuccess(InterfaceC2857<? super T> interfaceC2857) {
        C4246.m13353(interfaceC2857, "onAfterSuccess is null");
        return C3671.m11800(new C4783(this, interfaceC2857));
    }

    public final AbstractC4838<T> doAfterTerminate(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "onAfterTerminate is null");
        return C3671.m11800(new C2698(this, interfaceC3809));
    }

    public final AbstractC4838<T> doFinally(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "onFinally is null");
        return C3671.m11800(new SingleDoFinally(this, interfaceC3809));
    }

    public final AbstractC4838<T> doOnDispose(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "onDispose is null");
        return C3671.m11800(new SingleDoOnDispose(this, interfaceC3809));
    }

    public final AbstractC4838<T> doOnError(InterfaceC2857<? super Throwable> interfaceC2857) {
        C4246.m13353(interfaceC2857, "onError is null");
        return C3671.m11800(new C5133(this, interfaceC2857));
    }

    public final AbstractC4838<T> doOnEvent(InterfaceC5246<? super T, ? super Throwable> interfaceC5246) {
        C4246.m13353(interfaceC5246, "onEvent is null");
        return C3671.m11800(new C4456(this, interfaceC5246));
    }

    public final AbstractC4838<T> doOnSubscribe(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        C4246.m13353(interfaceC2857, "onSubscribe is null");
        return C3671.m11800(new C4785(this, interfaceC2857));
    }

    public final AbstractC4838<T> doOnSuccess(InterfaceC2857<? super T> interfaceC2857) {
        C4246.m13353(interfaceC2857, "onSuccess is null");
        return C3671.m11800(new C4794(this, interfaceC2857));
    }

    public final AbstractC4838<T> doOnTerminate(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "onTerminate is null");
        return C3671.m11800(new C4839(this, interfaceC3809));
    }

    public final AbstractC4274<T> filter(InterfaceC4178<? super T> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11797(new C4614(this, interfaceC4178));
    }

    public final <R> AbstractC4838<R> flatMap(InterfaceC2368<? super T, ? extends InterfaceC3951<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11800(new SingleFlatMap(this, interfaceC2368));
    }

    public final AbstractC2900 flatMapCompletable(InterfaceC2368<? super T, ? extends InterfaceC2837> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11793(new SingleFlatMapCompletable(this, interfaceC2368));
    }

    public final <R> AbstractC4274<R> flatMapMaybe(InterfaceC2368<? super T, ? extends InterfaceC3517<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11797(new SingleFlatMapMaybe(this, interfaceC2368));
    }

    public final <R> AbstractC4262<R> flatMapObservable(InterfaceC2368<? super T, ? extends InterfaceC2856<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new SingleFlatMapObservable(this, interfaceC2368));
    }

    public final <R> AbstractC3630<R> flatMapPublisher(InterfaceC2368<? super T, ? extends Publisher<? extends R>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11796(new SingleFlatMapPublisher(this, interfaceC2368));
    }

    public final <U> AbstractC3630<U> flattenAsFlowable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11796(new SingleFlatMapIterableFlowable(this, interfaceC2368));
    }

    public final <U> AbstractC4262<U> flattenAsObservable(InterfaceC2368<? super T, ? extends Iterable<? extends U>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11798(new SingleFlatMapIterableObservable(this, interfaceC2368));
    }

    public final AbstractC4838<T> hide() {
        return C3671.m11800(new C4800(this));
    }

    public final AbstractC2900 ignoreElement() {
        return C3671.m11793(new C2525(this));
    }

    public final <R> AbstractC4838<R> lift(InterfaceC5259<? extends R, ? super T> interfaceC5259) {
        C4246.m13353(interfaceC5259, "lift is null");
        return C3671.m11800(new C4681(this, interfaceC5259));
    }

    public final <R> AbstractC4838<R> map(InterfaceC2368<? super T, ? extends R> interfaceC2368) {
        C4246.m13353(interfaceC2368, "mapper is null");
        return C3671.m11800(new C2109(this, interfaceC2368));
    }

    public final AbstractC4838<C3906<T>> materialize() {
        return C3671.m11800(new C4471(this));
    }

    public final AbstractC3630<T> mergeWith(InterfaceC3951<? extends T> interfaceC3951) {
        return merge(this, interfaceC3951);
    }

    public final AbstractC4838<T> observeOn(AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11800(new SingleObserveOn(this, abstractC4585));
    }

    public final AbstractC4838<T> onErrorResumeNext(AbstractC4838<? extends T> abstractC4838) {
        C4246.m13353(abstractC4838, "resumeSingleInCaseOfError is null");
        return onErrorResumeNext(Functions.m6325(abstractC4838));
    }

    public final AbstractC4838<T> onErrorReturn(InterfaceC2368<Throwable, ? extends T> interfaceC2368) {
        C4246.m13353(interfaceC2368, "resumeFunction is null");
        return C3671.m11800(new C5135(this, interfaceC2368, null));
    }

    public final AbstractC4838<T> onErrorReturnItem(T t) {
        C4246.m13353(t, "value is null");
        return C3671.m11800(new C5135(this, null, t));
    }

    public final AbstractC4838<T> onTerminateDetach() {
        return C3671.m11800(new C4530(this));
    }

    public final AbstractC3630<T> repeat() {
        return toFlowable().repeat();
    }

    public final AbstractC3630<T> repeatUntil(InterfaceC2881 interfaceC2881) {
        return toFlowable().repeatUntil(interfaceC2881);
    }

    public final AbstractC3630<T> repeatWhen(InterfaceC2368<? super AbstractC3630<Object>, ? extends Publisher<?>> interfaceC2368) {
        return toFlowable().repeatWhen(interfaceC2368);
    }

    public final AbstractC4838<T> retry() {
        return toSingle(toFlowable().retry());
    }

    public final AbstractC4838<T> retryWhen(InterfaceC2368<? super AbstractC3630<Throwable>, ? extends Publisher<?>> interfaceC2368) {
        return toSingle(toFlowable().retryWhen(interfaceC2368));
    }

    public final InterfaceC4478 subscribe() {
        return subscribe(Functions.m6320(), Functions.f6801);
    }

    public abstract void subscribeActual(InterfaceC4782<? super T> interfaceC4782);

    public final AbstractC4838<T> subscribeOn(AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11800(new SingleSubscribeOn(this, abstractC4585));
    }

    public final <E extends InterfaceC4782<? super T>> E subscribeWith(E e2) {
        subscribe(e2);
        return e2;
    }

    public final AbstractC4838<T> takeUntil(InterfaceC2837 interfaceC2837) {
        C4246.m13353(interfaceC2837, "other is null");
        return takeUntil(new C5046(interfaceC2837));
    }

    public final TestObserver<T> test() {
        TestObserver<T> testObserver = new TestObserver<>();
        subscribe(testObserver);
        return testObserver;
    }

    public final AbstractC4838<T> timeout(long j, TimeUnit timeUnit) {
        return timeout0(j, timeUnit, C4877.m14600(), null);
    }

    public final <R> R to(InterfaceC2368<? super AbstractC4838<T>, R> interfaceC2368) {
        try {
            return (R) ((InterfaceC2368) C4246.m13353(interfaceC2368, "convert is null")).apply(this);
        } catch (Throwable th) {
            C4089.m13026(th);
            throw ExceptionHelper.m7024(th);
        }
    }

    @Deprecated
    public final AbstractC2900 toCompletable() {
        return C3671.m11793(new C2525(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AbstractC3630<T> toFlowable() {
        return this instanceof InterfaceC2583 ? ((InterfaceC2583) this).mo6444() : C3671.m11796(new SingleToFlowable(this));
    }

    public final Future<T> toFuture() {
        return (Future) subscribeWith(new FutureC2576());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AbstractC4274<T> toMaybe() {
        return this instanceof InterfaceC2797 ? ((InterfaceC2797) this).m10108() : C3671.m11797(new C3603(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final AbstractC4262<T> toObservable() {
        return this instanceof InterfaceC2325 ? ((InterfaceC2325) this).mo6779() : C3671.m11798(new SingleToObservable(this));
    }

    public final AbstractC4838<T> unsubscribeOn(AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11800(new SingleUnsubscribeOn(this, abstractC4585));
    }

    public final <U, R> AbstractC4838<R> zipWith(InterfaceC3951<U> interfaceC3951, InterfaceC5247<? super T, ? super U, ? extends R> interfaceC5247) {
        return zip(this, interfaceC3951, interfaceC5247);
    }

    public static <T> AbstractC4262<T> concat(InterfaceC2856<? extends InterfaceC3951<? extends T>> interfaceC2856) {
        C4246.m13353(interfaceC2856, "sources is null");
        return C3671.m11798(new ObservableConcatMap(interfaceC2856, SingleInternalHelper.m6956(), 2, ErrorMode.IMMEDIATE));
    }

    public static <T> AbstractC3630<T> concatEager(Iterable<? extends InterfaceC3951<? extends T>> iterable) {
        return AbstractC3630.fromIterable(iterable).concatMapEager(SingleInternalHelper.m6955());
    }

    public static <T> AbstractC4838<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return toSingle(AbstractC3630.fromFuture(future, j, timeUnit));
    }

    public static <T> AbstractC3630<T> merge(Publisher<? extends InterfaceC3951<? extends T>> publisher) {
        C4246.m13353(publisher, "sources is null");
        return C3671.m11796(new C4074(publisher, SingleInternalHelper.m6955(), false, Integer.MAX_VALUE, AbstractC3630.bufferSize()));
    }

    public static <T> AbstractC3630<T> mergeDelayError(Publisher<? extends InterfaceC3951<? extends T>> publisher) {
        C4246.m13353(publisher, "sources is null");
        return C3671.m11796(new C4074(publisher, SingleInternalHelper.m6955(), true, Integer.MAX_VALUE, AbstractC3630.bufferSize()));
    }

    public static AbstractC4838<Long> timer(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11800(new SingleTimer(j, timeUnit, abstractC4585));
    }

    public static <T, U> AbstractC4838<T> using(Callable<U> callable, InterfaceC2368<? super U, ? extends InterfaceC3951<? extends T>> interfaceC2368, InterfaceC2857<? super U> interfaceC2857, boolean z) {
        C4246.m13353(callable, "resourceSupplier is null");
        C4246.m13353(interfaceC2368, "singleFunction is null");
        C4246.m13353(interfaceC2857, "disposer is null");
        return C3671.m11800(new SingleUsing(callable, interfaceC2368, interfaceC2857, z));
    }

    public final AbstractC4838<Boolean> contains(Object obj, InterfaceC5324<Object, Object> interfaceC5324) {
        C4246.m13353(obj, "value is null");
        C4246.m13353(interfaceC5324, "comparer is null");
        return C3671.m11800(new C4677(this, obj, interfaceC5324));
    }

    public final AbstractC4838<T> delay(long j, TimeUnit timeUnit, boolean z) {
        return delay(j, timeUnit, C4877.m14600(), z);
    }

    public final AbstractC3630<T> repeat(long j) {
        return toFlowable().repeat(j);
    }

    public final AbstractC4838<T> retry(long j) {
        return toSingle(toFlowable().retry(j));
    }

    public final InterfaceC4478 subscribe(InterfaceC5246<? super T, ? super Throwable> interfaceC5246) {
        C4246.m13353(interfaceC5246, "onCallback is null");
        BiConsumerSingleObserver biConsumerSingleObserver = new BiConsumerSingleObserver(interfaceC5246);
        subscribe(biConsumerSingleObserver);
        return biConsumerSingleObserver;
    }

    public final AbstractC4838<T> timeout(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return timeout0(j, timeUnit, abstractC4585, null);
    }

    public static <T> AbstractC4838<T> error(Throwable th) {
        C4246.m13353(th, "exception is null");
        return error((Callable<? extends Throwable>) Functions.m6324(th));
    }

    public static <T> AbstractC4838<T> fromFuture(Future<? extends T> future, long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return toSingle(AbstractC3630.fromFuture(future, j, timeUnit, abstractC4585));
    }

    public final AbstractC4838<T> delay(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return delay(j, timeUnit, abstractC4585, false);
    }

    public final <U> AbstractC4838<T> delaySubscription(InterfaceC3951<U> interfaceC3951) {
        C4246.m13353(interfaceC3951, "other is null");
        return C3671.m11800(new SingleDelayWithSingle(this, interfaceC3951));
    }

    public final AbstractC4838<T> onErrorResumeNext(InterfaceC2368<? super Throwable, ? extends InterfaceC3951<? extends T>> interfaceC2368) {
        C4246.m13353(interfaceC2368, "resumeFunctionInCaseOfError is null");
        return C3671.m11800(new SingleResumeNext(this, interfaceC2368));
    }

    public final AbstractC4838<T> retry(InterfaceC5324<? super Integer, ? super Throwable> interfaceC5324) {
        return toSingle(toFlowable().retry(interfaceC5324));
    }

    public final <E> AbstractC4838<T> takeUntil(Publisher<E> publisher) {
        C4246.m13353(publisher, "other is null");
        return C3671.m11800(new SingleTakeUntil(this, publisher));
    }

    public final TestObserver<T> test(boolean z) {
        TestObserver<T> testObserver = new TestObserver<>();
        if (z) {
            testObserver.cancel();
        }
        subscribe(testObserver);
        return testObserver;
    }

    public final AbstractC4838<T> timeout(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, InterfaceC3951<? extends T> interfaceC3951) {
        C4246.m13353(interfaceC3951, "other is null");
        return timeout0(j, timeUnit, abstractC4585, interfaceC3951);
    }

    public static <T> AbstractC3630<T> concat(Publisher<? extends InterfaceC3951<? extends T>> publisher) {
        return concat(publisher, 2);
    }

    public static <T> AbstractC4838<T> fromFuture(Future<? extends T> future, AbstractC4585 abstractC4585) {
        return toSingle(AbstractC3630.fromFuture(future, abstractC4585));
    }

    public static <T> AbstractC4838<T> merge(InterfaceC3951<? extends InterfaceC3951<? extends T>> interfaceC3951) {
        C4246.m13353(interfaceC3951, "source is null");
        return C3671.m11800(new SingleFlatMap(interfaceC3951, Functions.m6322()));
    }

    public static <T> AbstractC3630<T> mergeDelayError(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        return mergeDelayError(AbstractC3630.fromArray(interfaceC3951, interfaceC39512));
    }

    public static <T1, T2, R> AbstractC4838<R> zip(InterfaceC3951<? extends T1> interfaceC3951, InterfaceC3951<? extends T2> interfaceC39512, InterfaceC5247<? super T1, ? super T2, ? extends R> interfaceC5247) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        return zipArray(Functions.m6335(interfaceC5247), interfaceC3951, interfaceC39512);
    }

    public final AbstractC4838<T> delay(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585, boolean z) {
        C4246.m13353(timeUnit, "unit is null");
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11800(new C4518(this, j, timeUnit, abstractC4585, z));
    }

    public final AbstractC4838<T> retry(long j, InterfaceC4178<? super Throwable> interfaceC4178) {
        return toSingle(toFlowable().retry(j, interfaceC4178));
    }

    public static <T> AbstractC3630<T> concat(Publisher<? extends InterfaceC3951<? extends T>> publisher, int i) {
        C4246.m13353(publisher, "sources is null");
        C4246.m13354(i, "prefetch");
        return C3671.m11796(new C3148(publisher, SingleInternalHelper.m6955(), i, ErrorMode.IMMEDIATE));
    }

    public final <U> AbstractC4838<T> delaySubscription(InterfaceC2856<U> interfaceC2856) {
        C4246.m13353(interfaceC2856, "other is null");
        return C3671.m11800(new SingleDelayWithObservable(this, interfaceC2856));
    }

    public final AbstractC4838<T> retry(InterfaceC4178<? super Throwable> interfaceC4178) {
        return toSingle(toFlowable().retry(interfaceC4178));
    }

    public final InterfaceC4478 subscribe(InterfaceC2857<? super T> interfaceC2857) {
        return subscribe(interfaceC2857, Functions.f6801);
    }

    public final <E> AbstractC4838<T> takeUntil(InterfaceC3951<? extends E> interfaceC3951) {
        C4246.m13353(interfaceC3951, "other is null");
        return takeUntil(new SingleToFlowable(interfaceC3951));
    }

    public final AbstractC4838<T> timeout(long j, TimeUnit timeUnit, InterfaceC3951<? extends T> interfaceC3951) {
        C4246.m13353(interfaceC3951, "other is null");
        return timeout0(j, timeUnit, C4877.m14600(), interfaceC3951);
    }

    public static <T> AbstractC3630<T> merge(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        return merge(AbstractC3630.fromArray(interfaceC3951, interfaceC39512));
    }

    public final InterfaceC4478 subscribe(InterfaceC2857<? super T> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572) {
        C4246.m13353(interfaceC2857, "onSuccess is null");
        C4246.m13353(interfaceC28572, "onError is null");
        ConsumerSingleObserver consumerSingleObserver = new ConsumerSingleObserver(interfaceC2857, interfaceC28572);
        subscribe(consumerSingleObserver);
        return consumerSingleObserver;
    }

    public static <T> AbstractC3630<T> mergeDelayError(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512, InterfaceC3951<? extends T> interfaceC39513) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        return mergeDelayError(AbstractC3630.fromArray(interfaceC3951, interfaceC39512, interfaceC39513));
    }

    public static <T1, T2, T3, R> AbstractC4838<R> zip(InterfaceC3951<? extends T1> interfaceC3951, InterfaceC3951<? extends T2> interfaceC39512, InterfaceC3951<? extends T3> interfaceC39513, InterfaceC3482<? super T1, ? super T2, ? super T3, ? extends R> interfaceC3482) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        return zipArray(Functions.m6336(interfaceC3482), interfaceC3951, interfaceC39512, interfaceC39513);
    }

    public final <U> AbstractC4838<T> delaySubscription(Publisher<U> publisher) {
        C4246.m13353(publisher, "other is null");
        return C3671.m11800(new SingleDelayWithPublisher(this, publisher));
    }

    public static <T> AbstractC3630<T> concat(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        return concat(AbstractC3630.fromArray(interfaceC3951, interfaceC39512));
    }

    public static <T> AbstractC3630<T> merge(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512, InterfaceC3951<? extends T> interfaceC39513) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        return merge(AbstractC3630.fromArray(interfaceC3951, interfaceC39512, interfaceC39513));
    }

    public final AbstractC4838<T> delaySubscription(long j, TimeUnit timeUnit) {
        return delaySubscription(j, timeUnit, C4877.m14600());
    }

    public final AbstractC4838<T> delaySubscription(long j, TimeUnit timeUnit, AbstractC4585 abstractC4585) {
        return delaySubscription(AbstractC4262.timer(j, timeUnit, abstractC4585));
    }

    @Override // defpackage.InterfaceC3951
    public final void subscribe(InterfaceC4782<? super T> interfaceC4782) {
        C4246.m13353(interfaceC4782, "observer is null");
        InterfaceC4782<? super T> interfaceC4782M11810 = C3671.m11810(this, interfaceC4782);
        C4246.m13353(interfaceC4782M11810, "The RxJavaPlugins.onSubscribe hook returned a null SingleObserver. Please check the handler provided to RxJavaPlugins.setOnSingleSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
        try {
            subscribeActual(interfaceC4782M11810);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            C4089.m13026(th);
            NullPointerException nullPointerException = new NullPointerException("subscribeActual failed");
            nullPointerException.initCause(th);
            throw nullPointerException;
        }
    }

    public static <T> AbstractC3630<T> concat(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512, InterfaceC3951<? extends T> interfaceC39513) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        return concat(AbstractC3630.fromArray(interfaceC3951, interfaceC39512, interfaceC39513));
    }

    public static <T> AbstractC3630<T> mergeDelayError(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512, InterfaceC3951<? extends T> interfaceC39513, InterfaceC3951<? extends T> interfaceC39514) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        C4246.m13353(interfaceC39514, "source4 is null");
        return mergeDelayError(AbstractC3630.fromArray(interfaceC3951, interfaceC39512, interfaceC39513, interfaceC39514));
    }

    public static <T1, T2, T3, T4, R> AbstractC4838<R> zip(InterfaceC3951<? extends T1> interfaceC3951, InterfaceC3951<? extends T2> interfaceC39512, InterfaceC3951<? extends T3> interfaceC39513, InterfaceC3951<? extends T4> interfaceC39514, InterfaceC4216<? super T1, ? super T2, ? super T3, ? super T4, ? extends R> interfaceC4216) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        C4246.m13353(interfaceC39514, "source4 is null");
        return zipArray(Functions.m6337(interfaceC4216), interfaceC3951, interfaceC39512, interfaceC39513, interfaceC39514);
    }

    public static <T> AbstractC3630<T> merge(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512, InterfaceC3951<? extends T> interfaceC39513, InterfaceC3951<? extends T> interfaceC39514) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        C4246.m13353(interfaceC39514, "source4 is null");
        return merge(AbstractC3630.fromArray(interfaceC3951, interfaceC39512, interfaceC39513, interfaceC39514));
    }

    public static <T> AbstractC3630<T> concat(InterfaceC3951<? extends T> interfaceC3951, InterfaceC3951<? extends T> interfaceC39512, InterfaceC3951<? extends T> interfaceC39513, InterfaceC3951<? extends T> interfaceC39514) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        C4246.m13353(interfaceC39514, "source4 is null");
        return concat(AbstractC3630.fromArray(interfaceC3951, interfaceC39512, interfaceC39513, interfaceC39514));
    }

    public static <T1, T2, T3, T4, T5, R> AbstractC4838<R> zip(InterfaceC3951<? extends T1> interfaceC3951, InterfaceC3951<? extends T2> interfaceC39512, InterfaceC3951<? extends T3> interfaceC39513, InterfaceC3951<? extends T4> interfaceC39514, InterfaceC3951<? extends T5> interfaceC39515, InterfaceC2568<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? extends R> interfaceC2568) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        C4246.m13353(interfaceC39514, "source4 is null");
        C4246.m13353(interfaceC39515, "source5 is null");
        return zipArray(Functions.m6338(interfaceC2568), interfaceC3951, interfaceC39512, interfaceC39513, interfaceC39514, interfaceC39515);
    }

    public static <T1, T2, T3, T4, T5, T6, R> AbstractC4838<R> zip(InterfaceC3951<? extends T1> interfaceC3951, InterfaceC3951<? extends T2> interfaceC39512, InterfaceC3951<? extends T3> interfaceC39513, InterfaceC3951<? extends T4> interfaceC39514, InterfaceC3951<? extends T5> interfaceC39515, InterfaceC3951<? extends T6> interfaceC39516, InterfaceC2485<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? extends R> interfaceC2485) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        C4246.m13353(interfaceC39514, "source4 is null");
        C4246.m13353(interfaceC39515, "source5 is null");
        C4246.m13353(interfaceC39516, "source6 is null");
        return zipArray(Functions.m6339(interfaceC2485), interfaceC3951, interfaceC39512, interfaceC39513, interfaceC39514, interfaceC39515, interfaceC39516);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, R> AbstractC4838<R> zip(InterfaceC3951<? extends T1> interfaceC3951, InterfaceC3951<? extends T2> interfaceC39512, InterfaceC3951<? extends T3> interfaceC39513, InterfaceC3951<? extends T4> interfaceC39514, InterfaceC3951<? extends T5> interfaceC39515, InterfaceC3951<? extends T6> interfaceC39516, InterfaceC3951<? extends T7> interfaceC39517, InterfaceC2825<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? extends R> interfaceC2825) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        C4246.m13353(interfaceC39514, "source4 is null");
        C4246.m13353(interfaceC39515, "source5 is null");
        C4246.m13353(interfaceC39516, "source6 is null");
        C4246.m13353(interfaceC39517, "source7 is null");
        return zipArray(Functions.m6340(interfaceC2825), interfaceC3951, interfaceC39512, interfaceC39513, interfaceC39514, interfaceC39515, interfaceC39516, interfaceC39517);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, R> AbstractC4838<R> zip(InterfaceC3951<? extends T1> interfaceC3951, InterfaceC3951<? extends T2> interfaceC39512, InterfaceC3951<? extends T3> interfaceC39513, InterfaceC3951<? extends T4> interfaceC39514, InterfaceC3951<? extends T5> interfaceC39515, InterfaceC3951<? extends T6> interfaceC39516, InterfaceC3951<? extends T7> interfaceC39517, InterfaceC3951<? extends T8> interfaceC39518, InterfaceC4399<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? extends R> interfaceC4399) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        C4246.m13353(interfaceC39514, "source4 is null");
        C4246.m13353(interfaceC39515, "source5 is null");
        C4246.m13353(interfaceC39516, "source6 is null");
        C4246.m13353(interfaceC39517, "source7 is null");
        C4246.m13353(interfaceC39518, "source8 is null");
        return zipArray(Functions.m6341(interfaceC4399), interfaceC3951, interfaceC39512, interfaceC39513, interfaceC39514, interfaceC39515, interfaceC39516, interfaceC39517, interfaceC39518);
    }

    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9, R> AbstractC4838<R> zip(InterfaceC3951<? extends T1> interfaceC3951, InterfaceC3951<? extends T2> interfaceC39512, InterfaceC3951<? extends T3> interfaceC39513, InterfaceC3951<? extends T4> interfaceC39514, InterfaceC3951<? extends T5> interfaceC39515, InterfaceC3951<? extends T6> interfaceC39516, InterfaceC3951<? extends T7> interfaceC39517, InterfaceC3951<? extends T8> interfaceC39518, InterfaceC3951<? extends T9> interfaceC39519, InterfaceC2954<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super T6, ? super T7, ? super T8, ? super T9, ? extends R> interfaceC2954) {
        C4246.m13353(interfaceC3951, "source1 is null");
        C4246.m13353(interfaceC39512, "source2 is null");
        C4246.m13353(interfaceC39513, "source3 is null");
        C4246.m13353(interfaceC39514, "source4 is null");
        C4246.m13353(interfaceC39515, "source5 is null");
        C4246.m13353(interfaceC39516, "source6 is null");
        C4246.m13353(interfaceC39517, "source7 is null");
        C4246.m13353(interfaceC39518, "source8 is null");
        C4246.m13353(interfaceC39519, "source9 is null");
        return zipArray(Functions.m6342(interfaceC2954), interfaceC3951, interfaceC39512, interfaceC39513, interfaceC39514, interfaceC39515, interfaceC39516, interfaceC39517, interfaceC39518, interfaceC39519);
    }
}
