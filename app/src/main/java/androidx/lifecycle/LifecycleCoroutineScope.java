package androidx.lifecycle;

import defpackage.C3921;
import defpackage.C4817;
import defpackage.C5022;
import defpackage.C5199;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3539;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import defpackage.InterfaceC5238;
import defpackage.i4;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: Lifecycle.kt */
/* loaded from: classes.dex */
public abstract class LifecycleCoroutineScope implements InterfaceC3539 {

    /* compiled from: Lifecycle.kt */
    @InterfaceC3540(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", l = {79}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
        public final /* synthetic */ InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> $block;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849, InterfaceC4355<? super AnonymousClass1> interfaceC4355) {
            super(2, interfaceC4355);
            this.$block = interfaceC2849;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
            return LifecycleCoroutineScope.this.new AnonymousClass1(this.$block, interfaceC4355);
        }

        @Override // defpackage.InterfaceC2849
        public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
            return ((AnonymousClass1) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM15170 = C5199.m15170();
            int i = this.label;
            if (i == 0) {
                C4817.m14542(obj);
                Lifecycle lifecycle$lifecycle_runtime_ktx_release = LifecycleCoroutineScope.this.getLifecycle$lifecycle_runtime_ktx_release();
                InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> interfaceC2849 = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenCreated(lifecycle$lifecycle_runtime_ktx_release, interfaceC2849, this) == objM15170) {
                    return objM15170;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4817.m14542(obj);
            }
            return i4.f6762;
        }
    }

    /* compiled from: Lifecycle.kt */
    @InterfaceC3540(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1", f = "Lifecycle.kt", l = {114}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenResumed$1, reason: invalid class name and case insensitive filesystem */
    public static final class C53381 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
        public final /* synthetic */ InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> $block;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C53381(InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849, InterfaceC4355<? super C53381> interfaceC4355) {
            super(2, interfaceC4355);
            this.$block = interfaceC2849;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
            return LifecycleCoroutineScope.this.new C53381(this.$block, interfaceC4355);
        }

        @Override // defpackage.InterfaceC2849
        public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
            return ((C53381) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM15170 = C5199.m15170();
            int i = this.label;
            if (i == 0) {
                C4817.m14542(obj);
                Lifecycle lifecycle$lifecycle_runtime_ktx_release = LifecycleCoroutineScope.this.getLifecycle$lifecycle_runtime_ktx_release();
                InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> interfaceC2849 = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenResumed(lifecycle$lifecycle_runtime_ktx_release, interfaceC2849, this) == objM15170) {
                    return objM15170;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4817.m14542(obj);
            }
            return i4.f6762;
        }
    }

    /* compiled from: Lifecycle.kt */
    @InterfaceC3540(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1", f = "Lifecycle.kt", l = {97}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.LifecycleCoroutineScope$launchWhenStarted$1, reason: invalid class name and case insensitive filesystem */
    public static final class C53391 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
        public final /* synthetic */ InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> $block;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C53391(InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849, InterfaceC4355<? super C53391> interfaceC4355) {
            super(2, interfaceC4355);
            this.$block = interfaceC2849;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
            return LifecycleCoroutineScope.this.new C53391(this.$block, interfaceC4355);
        }

        @Override // defpackage.InterfaceC2849
        public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
            return ((C53391) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM15170 = C5199.m15170();
            int i = this.label;
            if (i == 0) {
                C4817.m14542(obj);
                Lifecycle lifecycle$lifecycle_runtime_ktx_release = LifecycleCoroutineScope.this.getLifecycle$lifecycle_runtime_ktx_release();
                InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> interfaceC2849 = this.$block;
                this.label = 1;
                if (PausingDispatcherKt.whenStarted(lifecycle$lifecycle_runtime_ktx_release, interfaceC2849, this) == objM15170) {
                    return objM15170;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4817.m14542(obj);
            }
            return i4.f6762;
        }
    }

    @Override // defpackage.InterfaceC3539
    public abstract /* synthetic */ CoroutineContext getCoroutineContext();

    public abstract Lifecycle getLifecycle$lifecycle_runtime_ktx_release();

    public final InterfaceC5238 launchWhenCreated(InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849) {
        C3921.m12666(interfaceC2849, "block");
        return C5022.m14810(this, null, null, new AnonymousClass1(interfaceC2849, null), 3, null);
    }

    public final InterfaceC5238 launchWhenResumed(InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849) {
        C3921.m12666(interfaceC2849, "block");
        return C5022.m14810(this, null, null, new C53381(interfaceC2849, null), 3, null);
    }

    public final InterfaceC5238 launchWhenStarted(InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849) {
        C3921.m12666(interfaceC2849, "block");
        return C5022.m14810(this, null, null, new C53391(interfaceC2849, null), 3, null);
    }
}
