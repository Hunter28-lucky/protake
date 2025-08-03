package androidx.core.animation;

import android.animation.Animator;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt$addPauseListener$listener$1 implements Animator.AnimatorPauseListener {
    public final /* synthetic */ InterfaceC2392<Animator, i4> $onPause;
    public final /* synthetic */ InterfaceC2392<Animator, i4> $onResume;

    /* JADX WARN: Multi-variable type inference failed */
    public AnimatorKt$addPauseListener$listener$1(InterfaceC2392<? super Animator, i4> interfaceC2392, InterfaceC2392<? super Animator, i4> interfaceC23922) {
        this.$onPause = interfaceC2392;
        this.$onResume = interfaceC23922;
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationPause(Animator animator) {
        C3921.m12666(animator, "animator");
        this.$onPause.invoke(animator);
    }

    @Override // android.animation.Animator.AnimatorPauseListener
    public void onAnimationResume(Animator animator) {
        C3921.m12666(animator, "animator");
        this.$onResume.invoke(animator);
    }
}
