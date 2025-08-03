package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import defpackage.AbstractC3847;
import defpackage.C2404;
import defpackage.C2888;
import defpackage.C2945;
import defpackage.C3921;
import defpackage.C4817;
import defpackage.C5199;
import defpackage.InterfaceC2849;
import defpackage.InterfaceC3539;
import defpackage.InterfaceC3540;
import defpackage.InterfaceC4355;
import defpackage.i4;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* compiled from: RepeatOnLifecycle.kt */
/* loaded from: classes.dex */
public final class RepeatOnLifecycleKt {

    /* compiled from: RepeatOnLifecycle.kt */
    @InterfaceC3540(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3", f = "RepeatOnLifecycle.kt", l = {84}, m = "invokeSuspend")
    /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3, reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
        public final /* synthetic */ InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> $block;
        public final /* synthetic */ Lifecycle.State $state;
        public final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
        private /* synthetic */ Object L$0;
        public int label;

        /* compiled from: RepeatOnLifecycle.kt */
        @InterfaceC3540(c = "androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1", f = "RepeatOnLifecycle.kt", l = {166}, m = "invokeSuspend")
        /* renamed from: androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> {
            public final /* synthetic */ InterfaceC3539 $$this$coroutineScope;
            public final /* synthetic */ InterfaceC2849<InterfaceC3539, InterfaceC4355<? super i4>, Object> $block;
            public final /* synthetic */ Lifecycle.State $state;
            public final /* synthetic */ Lifecycle $this_repeatOnLifecycle;
            public Object L$0;
            public Object L$1;
            public Object L$2;
            public Object L$3;
            public Object L$4;
            public Object L$5;
            public int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(Lifecycle lifecycle, Lifecycle.State state, InterfaceC3539 interfaceC3539, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849, InterfaceC4355<? super AnonymousClass1> interfaceC4355) {
                super(2, interfaceC4355);
                this.$this_repeatOnLifecycle = lifecycle;
                this.$state = state;
                this.$$this$coroutineScope = interfaceC3539;
                this.$block = interfaceC2849;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
                return new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, this.$$this$coroutineScope, this.$block, interfaceC4355);
            }

            @Override // defpackage.InterfaceC2849
            public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
                return ((AnonymousClass1) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
            }

            /* JADX WARN: Removed duplicated region for block: B:26:0x00ab  */
            /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x00c8  */
            /* JADX WARN: Removed duplicated region for block: B:42:0x00d3  */
            /* JADX WARN: Type inference failed for: r10v0, types: [T, androidx.lifecycle.RepeatOnLifecycleKt$repeatOnLifecycle$3$1$1$1] */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
                /*
                    Method dump skipped, instructions count: 217
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.RepeatOnLifecycleKt.AnonymousClass3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass3(Lifecycle lifecycle, Lifecycle.State state, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849, InterfaceC4355<? super AnonymousClass3> interfaceC4355) {
            super(2, interfaceC4355);
            this.$this_repeatOnLifecycle = lifecycle;
            this.$state = state;
            this.$block = interfaceC2849;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4355<i4> create(Object obj, InterfaceC4355<?> interfaceC4355) {
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(this.$this_repeatOnLifecycle, this.$state, this.$block, interfaceC4355);
            anonymousClass3.L$0 = obj;
            return anonymousClass3;
        }

        @Override // defpackage.InterfaceC2849
        public final Object invoke(InterfaceC3539 interfaceC3539, InterfaceC4355<? super i4> interfaceC4355) {
            return ((AnonymousClass3) create(interfaceC3539, interfaceC4355)).invokeSuspend(i4.f6762);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objM15170 = C5199.m15170();
            int i = this.label;
            if (i == 0) {
                C4817.m14542(obj);
                InterfaceC3539 interfaceC3539 = (InterfaceC3539) this.L$0;
                AbstractC3847 abstractC3847Mo10951 = C2888.m10244().mo10951();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$this_repeatOnLifecycle, this.$state, interfaceC3539, this.$block, null);
                this.label = 1;
                if (C2404.m8899(abstractC3847Mo10951, anonymousClass1, this) == objM15170) {
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

    public static final Object repeatOnLifecycle(Lifecycle lifecycle, Lifecycle.State state, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849, InterfaceC4355<? super i4> interfaceC4355) throws Throwable {
        if (!(state != Lifecycle.State.INITIALIZED)) {
            throw new IllegalArgumentException("repeatOnLifecycle cannot start work with the INITIALIZED lifecycle state.".toString());
        }
        if (lifecycle.getCurrentState() == Lifecycle.State.DESTROYED) {
            return i4.f6762;
        }
        Object objM10347 = C2945.m10347(new AnonymousClass3(lifecycle, state, interfaceC2849, null), interfaceC4355);
        return objM10347 == C5199.m15170() ? objM10347 : i4.f6762;
    }

    public static final Object repeatOnLifecycle(LifecycleOwner lifecycleOwner, Lifecycle.State state, InterfaceC2849<? super InterfaceC3539, ? super InterfaceC4355<? super i4>, ? extends Object> interfaceC2849, InterfaceC4355<? super i4> interfaceC4355) throws Throwable {
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        C3921.m12665(lifecycle, "lifecycle");
        Object objRepeatOnLifecycle = repeatOnLifecycle(lifecycle, state, interfaceC2849, interfaceC4355);
        return objRepeatOnLifecycle == C5199.m15170() ? objRepeatOnLifecycle : i4.f6762;
    }
}
