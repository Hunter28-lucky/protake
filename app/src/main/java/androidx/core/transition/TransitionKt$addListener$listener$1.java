package androidx.core.transition;

import android.transition.Transition;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: Transition.kt */
/* loaded from: classes.dex */
public final class TransitionKt$addListener$listener$1 implements Transition.TransitionListener {
    public final /* synthetic */ InterfaceC2392<Transition, i4> $onCancel;
    public final /* synthetic */ InterfaceC2392<Transition, i4> $onEnd;
    public final /* synthetic */ InterfaceC2392<Transition, i4> $onPause;
    public final /* synthetic */ InterfaceC2392<Transition, i4> $onResume;
    public final /* synthetic */ InterfaceC2392<Transition, i4> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public TransitionKt$addListener$listener$1(InterfaceC2392<? super Transition, i4> interfaceC2392, InterfaceC2392<? super Transition, i4> interfaceC23922, InterfaceC2392<? super Transition, i4> interfaceC23923, InterfaceC2392<? super Transition, i4> interfaceC23924, InterfaceC2392<? super Transition, i4> interfaceC23925) {
        this.$onEnd = interfaceC2392;
        this.$onResume = interfaceC23922;
        this.$onPause = interfaceC23923;
        this.$onCancel = interfaceC23924;
        this.$onStart = interfaceC23925;
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionCancel(Transition transition) {
        C3921.m12666(transition, "transition");
        this.$onCancel.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionEnd(Transition transition) {
        C3921.m12666(transition, "transition");
        this.$onEnd.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionPause(Transition transition) {
        C3921.m12666(transition, "transition");
        this.$onPause.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionResume(Transition transition) {
        C3921.m12666(transition, "transition");
        this.$onResume.invoke(transition);
    }

    @Override // android.transition.Transition.TransitionListener
    public void onTransitionStart(Transition transition) {
        C3921.m12666(transition, "transition");
        this.$onStart.invoke(transition);
    }
}
