package androidx.core.animation;

import android.animation.Animator;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt$addListener$listener$1 implements Animator.AnimatorListener {
    public final /* synthetic */ InterfaceC2392<Animator, i4> $onCancel;
    public final /* synthetic */ InterfaceC2392<Animator, i4> $onEnd;
    public final /* synthetic */ InterfaceC2392<Animator, i4> $onRepeat;
    public final /* synthetic */ InterfaceC2392<Animator, i4> $onStart;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addListener$listener$1(InterfaceC2392<? super Animator, i4> interfaceC2392, InterfaceC2392<? super Animator, i4> interfaceC23922, InterfaceC2392<? super Animator, i4> interfaceC23923, InterfaceC2392<? super Animator, i4> interfaceC23924) {
        this.$onRepeat = interfaceC2392;
        this.$onEnd = interfaceC23922;
        this.$onCancel = interfaceC23923;
        this.$onStart = interfaceC23924;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        C3921.m12666(animator, "animator");
        this.$onCancel.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        C3921.m12666(animator, "animator");
        this.$onEnd.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
        C3921.m12666(animator, "animator");
        this.$onRepeat.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        C3921.m12666(animator, "animator");
        this.$onStart.invoke(animator);
    }
}
