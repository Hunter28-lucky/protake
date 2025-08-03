package defpackage;

import io.reactivex.internal.functions.Functions;
import io.reactivex.internal.observers.CallbackCompletableObserver;
import io.reactivex.internal.observers.EmptyCompletableObserver;
import io.reactivex.internal.operators.completable.CompletableAndThenCompletable;
import io.reactivex.internal.operators.completable.CompletableDoFinally;
import io.reactivex.internal.operators.completable.CompletableObserveOn;
import io.reactivex.internal.operators.completable.CompletableResumeNext;
import io.reactivex.internal.operators.mixed.CompletableAndThenObservable;
import java.util.concurrent.Callable;

/* compiled from: Completable.java */
/* renamed from: ч, reason: contains not printable characters */
/* loaded from: classes2.dex */
public abstract class AbstractC2900 implements InterfaceC2837 {
    /* renamed from: Ԭ, reason: contains not printable characters */
    public static AbstractC2900 m10268() {
        return C3671.m11793(C2397.f8967);
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static AbstractC2900 m10269(Callable<? extends InterfaceC2837> callable) {
        C4246.m13353(callable, "completableSupplier");
        return C3671.m11793(new C3658(callable));
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static AbstractC2900 m10270(Throwable th) {
        C4246.m13353(th, "error is null");
        return C3671.m11793(new C4353(th));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public static AbstractC2900 m10271(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "run is null");
        return C3671.m11793(new C3419(interfaceC3809));
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static AbstractC2900 m10272(Runnable runnable) {
        C4246.m13353(runnable, "run is null");
        return C3671.m11793(new C5047(runnable));
    }

    /* renamed from: ވ, reason: contains not printable characters */
    public static NullPointerException m10273(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    /* renamed from: ފ, reason: contains not printable characters */
    public static AbstractC2900 m10274(InterfaceC2837 interfaceC2837) {
        C4246.m13353(interfaceC2837, "source is null");
        return interfaceC2837 instanceof AbstractC2900 ? C3671.m11793((AbstractC2900) interfaceC2837) : C3671.m11793(new C5146(interfaceC2837));
    }

    @Override // defpackage.InterfaceC2837
    /* renamed from: Ԩ */
    public final void mo10180(InterfaceC5053 interfaceC5053) {
        C4246.m13353(interfaceC5053, "observer is null");
        try {
            InterfaceC5053 interfaceC5053M11807 = C3671.m11807(this, interfaceC5053);
            C4246.m13353(interfaceC5053M11807, "The RxJavaPlugins.onSubscribe hook returned a null CompletableObserver. Please check the handler provided to RxJavaPlugins.setOnCompletableSubscribe for invalid null returns. Further reading: https://github.com/ReactiveX/RxJava/wiki/Plugins");
            mo6373(interfaceC5053M11807);
        } catch (NullPointerException e2) {
            throw e2;
        } catch (Throwable th) {
            C4089.m13026(th);
            C3671.m11803(th);
            throw m10273(th);
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final AbstractC2900 m10275(InterfaceC2837 interfaceC2837) {
        C4246.m13353(interfaceC2837, "next is null");
        return C3671.m11793(new CompletableAndThenCompletable(this, interfaceC2837));
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public final <T> AbstractC4262<T> m10276(InterfaceC2856<T> interfaceC2856) {
        C4246.m13353(interfaceC2856, "next is null");
        return C3671.m11798(new CompletableAndThenObservable(this, interfaceC2856));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final AbstractC2900 m10277(InterfaceC5066 interfaceC5066) {
        return m10274(((InterfaceC5066) C4246.m13353(interfaceC5066, "transformer is null")).apply(this));
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public final AbstractC2900 m10278(InterfaceC3809 interfaceC3809) {
        C4246.m13353(interfaceC3809, "onFinally is null");
        return C3671.m11793(new CompletableDoFinally(this, interfaceC3809));
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final AbstractC2900 m10279(InterfaceC3809 interfaceC3809) {
        InterfaceC2857<? super InterfaceC4478> interfaceC2857M6320 = Functions.m6320();
        InterfaceC2857<? super Throwable> interfaceC2857M63202 = Functions.m6320();
        InterfaceC3809 interfaceC38092 = Functions.f6798;
        return m10280(interfaceC2857M6320, interfaceC2857M63202, interfaceC3809, interfaceC38092, interfaceC38092, interfaceC38092);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final AbstractC2900 m10280(InterfaceC2857<? super InterfaceC4478> interfaceC2857, InterfaceC2857<? super Throwable> interfaceC28572, InterfaceC3809 interfaceC3809, InterfaceC3809 interfaceC38092, InterfaceC3809 interfaceC38093, InterfaceC3809 interfaceC38094) {
        C4246.m13353(interfaceC2857, "onSubscribe is null");
        C4246.m13353(interfaceC28572, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        C4246.m13353(interfaceC38092, "onTerminate is null");
        C4246.m13353(interfaceC38093, "onAfterTerminate is null");
        C4246.m13353(interfaceC38094, "onDispose is null");
        return C3671.m11793(new C3241(this, interfaceC2857, interfaceC28572, interfaceC3809, interfaceC38092, interfaceC38093, interfaceC38094));
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final AbstractC2900 m10281(InterfaceC2857<? super InterfaceC4478> interfaceC2857) {
        InterfaceC2857<? super Throwable> interfaceC2857M6320 = Functions.m6320();
        InterfaceC3809 interfaceC3809 = Functions.f6798;
        return m10280(interfaceC2857, interfaceC2857M6320, interfaceC3809, interfaceC3809, interfaceC3809, interfaceC3809);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final AbstractC2900 m10282(AbstractC4585 abstractC4585) {
        C4246.m13353(abstractC4585, "scheduler is null");
        return C3671.m11793(new CompletableObserveOn(this, abstractC4585));
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final AbstractC2900 m10283() {
        return m10284(Functions.m6315());
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final AbstractC2900 m10284(InterfaceC4178<? super Throwable> interfaceC4178) {
        C4246.m13353(interfaceC4178, "predicate is null");
        return C3671.m11793(new C3251(this, interfaceC4178));
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public final AbstractC2900 m10285(InterfaceC2368<? super Throwable, ? extends InterfaceC2837> interfaceC2368) {
        C4246.m13353(interfaceC2368, "errorMapper is null");
        return C3671.m11793(new CompletableResumeNext(this, interfaceC2368));
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public final InterfaceC4478 m10286() {
        EmptyCompletableObserver emptyCompletableObserver = new EmptyCompletableObserver();
        mo10180(emptyCompletableObserver);
        return emptyCompletableObserver;
    }

    /* renamed from: ކ, reason: contains not printable characters */
    public final InterfaceC4478 m10287(InterfaceC3809 interfaceC3809, InterfaceC2857<? super Throwable> interfaceC2857) {
        C4246.m13353(interfaceC2857, "onError is null");
        C4246.m13353(interfaceC3809, "onComplete is null");
        CallbackCompletableObserver callbackCompletableObserver = new CallbackCompletableObserver(interfaceC2857, interfaceC3809);
        mo10180(callbackCompletableObserver);
        return callbackCompletableObserver;
    }

    /* renamed from: އ */
    public abstract void mo6373(InterfaceC5053 interfaceC5053);

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: މ, reason: contains not printable characters */
    public final <T> AbstractC4262<T> m10288() {
        return this instanceof InterfaceC2325 ? ((InterfaceC2325) this).mo6779() : C3671.m11798(new C2804(this));
    }
}
