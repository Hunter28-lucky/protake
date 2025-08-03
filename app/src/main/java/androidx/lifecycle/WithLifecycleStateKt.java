package androidx.lifecycle;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import defpackage.AbstractC3847;
import defpackage.C2679;
import defpackage.C2888;
import defpackage.C3921;
import defpackage.C4441;
import defpackage.C4817;
import defpackage.C5148;
import defpackage.C5199;
import defpackage.InterfaceC2392;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC4355;
import defpackage.i4;
import kotlin.Result;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineDispatcher;

/* compiled from: WithLifecycleState.kt */
/* loaded from: classes.dex */
public final class WithLifecycleStateKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: WithLifecycleState.kt */
    /* renamed from: androidx.lifecycle.WithLifecycleStateKt$withStateAtLeastUnchecked$2, reason: invalid class name */
    public static final class AnonymousClass2<R> extends Lambda implements InterfaceC4090<R> {
        public final /* synthetic */ InterfaceC4090<R> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass2(InterfaceC4090<? extends R> interfaceC4090) {
            super(0);
            this.$block = interfaceC4090;
        }

        @Override // defpackage.InterfaceC4090
        public final R invoke() {
            return this.$block.invoke();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [androidx.lifecycle.LifecycleObserver, androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1] */
    public static final <R> Object suspendWithStateAtLeastUnchecked(final Lifecycle lifecycle, final Lifecycle.State state, boolean z, final CoroutineDispatcher coroutineDispatcher, final InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) throws Throwable {
        final C4441 c4441 = new C4441(IntrinsicsKt__IntrinsicsJvmKt.m7255(interfaceC4355), 1);
        c4441.m13687();
        final ?? r1 = new LifecycleEventObserver() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Object objM7211;
                C3921.m12666(lifecycleOwner, "source");
                C3921.m12666(event, NotificationCompat.CATEGORY_EVENT);
                if (event != Lifecycle.Event.upTo(state)) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        lifecycle.removeObserver(this);
                        InterfaceC4355 interfaceC43552 = c4441;
                        LifecycleDestroyedException lifecycleDestroyedException = new LifecycleDestroyedException();
                        Result.C2137 c2137 = Result.f7828;
                        interfaceC43552.resumeWith(Result.m7211(C4817.m14541(lifecycleDestroyedException)));
                        return;
                    }
                    return;
                }
                lifecycle.removeObserver(this);
                InterfaceC4355 interfaceC43553 = c4441;
                InterfaceC4090<R> interfaceC40902 = interfaceC4090;
                try {
                    Result.C2137 c21372 = Result.f7828;
                    objM7211 = Result.m7211(interfaceC40902.invoke());
                } catch (Throwable th) {
                    Result.C2137 c21373 = Result.f7828;
                    objM7211 = Result.m7211(C4817.m14541(th));
                }
                interfaceC43553.resumeWith(objM7211);
            }
        };
        if (z) {
            coroutineDispatcher.dispatch(EmptyCoroutineContext.f7835, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1
                @Override // java.lang.Runnable
                public final void run() {
                    lifecycle.addObserver(r1);
                }
            });
        } else {
            lifecycle.addObserver(r1);
        }
        c4441.mo13670(new InterfaceC2392<Throwable, i4>() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // defpackage.InterfaceC2392
            public /* bridge */ /* synthetic */ i4 invoke(Throwable th) {
                invoke2(th);
                return i4.f6762;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Throwable th) {
                CoroutineDispatcher coroutineDispatcher2 = coroutineDispatcher;
                EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f7835;
                if (!coroutineDispatcher2.isDispatchNeeded(emptyCoroutineContext)) {
                    lifecycle.removeObserver(r1);
                    return;
                }
                CoroutineDispatcher coroutineDispatcher3 = coroutineDispatcher;
                final Lifecycle lifecycle2 = lifecycle;
                final WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 = r1;
                coroutineDispatcher3.dispatch(emptyCoroutineContext, new Runnable() { // from class: androidx.lifecycle.WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        lifecycle2.removeObserver(withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1);
                    }
                });
            }
        });
        Object objM13684 = c4441.m13684();
        if (objM13684 == C5199.m15170()) {
            C5148.m15061(interfaceC4355);
        }
        return objM13684;
    }

    public static final <R> Object withCreated(Lifecycle lifecycle, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        Lifecycle.State state = Lifecycle.State.CREATED;
        AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
        boolean zIsDispatchNeeded = abstractC3847Mo10951.isDispatchNeeded(interfaceC4355.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return interfaceC4090.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC3847Mo10951, new AnonymousClass2(interfaceC4090), interfaceC4355);
    }

    private static final <R> Object withCreated$$forInline(Lifecycle lifecycle, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2888.m10244().mo10951();
        C2679.m9827(3);
        throw null;
    }

    public static final <R> Object withResumed(Lifecycle lifecycle, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        Lifecycle.State state = Lifecycle.State.RESUMED;
        AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
        boolean zIsDispatchNeeded = abstractC3847Mo10951.isDispatchNeeded(interfaceC4355.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return interfaceC4090.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC3847Mo10951, new AnonymousClass2(interfaceC4090), interfaceC4355);
    }

    private static final <R> Object withResumed$$forInline(Lifecycle lifecycle, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2888.m10244().mo10951();
        C2679.m9827(3);
        throw null;
    }

    public static final <R> Object withStarted(Lifecycle lifecycle, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        Lifecycle.State state = Lifecycle.State.STARTED;
        AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
        boolean zIsDispatchNeeded = abstractC3847Mo10951.isDispatchNeeded(interfaceC4355.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return interfaceC4090.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC3847Mo10951, new AnonymousClass2(interfaceC4090), interfaceC4355);
    }

    private static final <R> Object withStarted$$forInline(Lifecycle lifecycle, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2888.m10244().mo10951();
        C2679.m9827(3);
        throw null;
    }

    public static final <R> Object withStateAtLeast(Lifecycle lifecycle, Lifecycle.State state, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(C3921.m12673("target state must be CREATED or greater, found ", state).toString());
        }
        AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
        boolean zIsDispatchNeeded = abstractC3847Mo10951.isDispatchNeeded(interfaceC4355.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return interfaceC4090.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC3847Mo10951, new AnonymousClass2(interfaceC4090), interfaceC4355);
    }

    private static final <R> Object withStateAtLeast$$forInline(Lifecycle lifecycle, Lifecycle.State state, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(C3921.m12673("target state must be CREATED or greater, found ", state).toString());
        }
        C2888.m10244().mo10951();
        C2679.m9827(3);
        throw null;
    }

    public static final <R> Object withStateAtLeastUnchecked(Lifecycle lifecycle, Lifecycle.State state, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
        boolean zIsDispatchNeeded = abstractC3847Mo10951.isDispatchNeeded(interfaceC4355.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
                throw new LifecycleDestroyedException();
            }
            if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                return interfaceC4090.invoke();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC3847Mo10951, new AnonymousClass2(interfaceC4090), interfaceC4355);
    }

    private static final <R> Object withStateAtLeastUnchecked$$forInline(Lifecycle lifecycle, Lifecycle.State state, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        C2888.m10244().mo10951();
        C2679.m9827(3);
        throw null;
    }

    private static final <R> Object withCreated$$forInline(LifecycleOwner lifecycleOwner, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        C3921.m12665(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2888.m10244().mo10951();
        C2679.m9827(3);
        throw null;
    }

    private static final <R> Object withResumed$$forInline(LifecycleOwner lifecycleOwner, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        C3921.m12665(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2888.m10244().mo10951();
        C2679.m9827(3);
        throw null;
    }

    private static final <R> Object withStarted$$forInline(LifecycleOwner lifecycleOwner, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        C3921.m12665(lifecycleOwner.getLifecycle(), "lifecycle");
        Lifecycle.State state = Lifecycle.State.DESTROYED;
        C2888.m10244().mo10951();
        C2679.m9827(3);
        throw null;
    }

    private static final <R> Object withStateAtLeast$$forInline(LifecycleOwner lifecycleOwner, Lifecycle.State state, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        C3921.m12665(lifecycleOwner.getLifecycle(), "lifecycle");
        if (!(state.compareTo(Lifecycle.State.CREATED) >= 0)) {
            throw new IllegalArgumentException(C3921.m12673("target state must be CREATED or greater, found ", state).toString());
        }
        C2888.m10244().mo10951();
        C2679.m9827(3);
        throw null;
    }

    public static final <R> Object withCreated(LifecycleOwner lifecycleOwner, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C3921.m12665(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.CREATED;
        AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
        boolean zIsDispatchNeeded = abstractC3847Mo10951.isDispatchNeeded(interfaceC4355.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return interfaceC4090.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC3847Mo10951, new AnonymousClass2(interfaceC4090), interfaceC4355);
    }

    public static final <R> Object withResumed(LifecycleOwner lifecycleOwner, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C3921.m12665(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.RESUMED;
        AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
        boolean zIsDispatchNeeded = abstractC3847Mo10951.isDispatchNeeded(interfaceC4355.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return interfaceC4090.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC3847Mo10951, new AnonymousClass2(interfaceC4090), interfaceC4355);
    }

    public static final <R> Object withStarted(LifecycleOwner lifecycleOwner, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C3921.m12665(lifecycle, "lifecycle");
        Lifecycle.State state = Lifecycle.State.STARTED;
        AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
        boolean zIsDispatchNeeded = abstractC3847Mo10951.isDispatchNeeded(interfaceC4355.getContext());
        if (!zIsDispatchNeeded) {
            if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                    return interfaceC4090.invoke();
                }
            } else {
                throw new LifecycleDestroyedException();
            }
        }
        return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC3847Mo10951, new AnonymousClass2(interfaceC4090), interfaceC4355);
    }

    public static final <R> Object withStateAtLeast(LifecycleOwner lifecycleOwner, Lifecycle.State state, InterfaceC4090<? extends R> interfaceC4090, InterfaceC4355<? super R> interfaceC4355) {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C3921.m12665(lifecycle, "lifecycle");
        if (state.compareTo(Lifecycle.State.CREATED) >= 0) {
            AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
            boolean zIsDispatchNeeded = abstractC3847Mo10951.isDispatchNeeded(interfaceC4355.getContext());
            if (!zIsDispatchNeeded) {
                if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
                    if (lifecycle.getCurrentState().compareTo(state) >= 0) {
                        return interfaceC4090.invoke();
                    }
                } else {
                    throw new LifecycleDestroyedException();
                }
            }
            return suspendWithStateAtLeastUnchecked(lifecycle, state, zIsDispatchNeeded, abstractC3847Mo10951, new AnonymousClass2(interfaceC4090), interfaceC4355);
        }
        throw new IllegalArgumentException(C3921.m12673("target state must be CREATED or greater, found ", state).toString());
    }
}
