package androidx.core.animation;

import android.animation.Animator;
import androidx.annotation.RequiresApi;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: Animator.kt */
/* loaded from: classes.dex */
public final class AnimatorKt {
    public static final Animator.AnimatorListener addListener(Animator animator, InterfaceC2392<? super Animator, i4> interfaceC2392, InterfaceC2392<? super Animator, i4> interfaceC23922, InterfaceC2392<? super Animator, i4> interfaceC23923, InterfaceC2392<? super Animator, i4> interfaceC23924) {
        C3921.m12666(animator, "<this>");
        C3921.m12666(interfaceC2392, "onEnd");
        C3921.m12666(interfaceC23922, "onStart");
        C3921.m12666(interfaceC23923, "onCancel");
        C3921.m12666(interfaceC23924, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(interfaceC23924, interfaceC2392, interfaceC23923, interfaceC23922);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorListener addListener$default(Animator animator, InterfaceC2392 interfaceC2392, InterfaceC2392 interfaceC23922, InterfaceC2392 interfaceC23923, InterfaceC2392 interfaceC23924, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC2392 = new InterfaceC2392<Animator, i4>() { // from class: androidx.core.animation.AnimatorKt.addListener.1
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Animator animator2) {
                    invoke2(animator2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animator animator2) {
                    C3921.m12666(animator2, "it");
                }
            };
        }
        if ((i & 2) != 0) {
            interfaceC23922 = new InterfaceC2392<Animator, i4>() { // from class: androidx.core.animation.AnimatorKt.addListener.2
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Animator animator2) {
                    invoke2(animator2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animator animator2) {
                    C3921.m12666(animator2, "it");
                }
            };
        }
        if ((i & 4) != 0) {
            interfaceC23923 = new InterfaceC2392<Animator, i4>() { // from class: androidx.core.animation.AnimatorKt.addListener.3
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Animator animator2) {
                    invoke2(animator2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animator animator2) {
                    C3921.m12666(animator2, "it");
                }
            };
        }
        if ((i & 8) != 0) {
            interfaceC23924 = new InterfaceC2392<Animator, i4>() { // from class: androidx.core.animation.AnimatorKt.addListener.4
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Animator animator2) {
                    invoke2(animator2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animator animator2) {
                    C3921.m12666(animator2, "it");
                }
            };
        }
        C3921.m12666(animator, "<this>");
        C3921.m12666(interfaceC2392, "onEnd");
        C3921.m12666(interfaceC23922, "onStart");
        C3921.m12666(interfaceC23923, "onCancel");
        C3921.m12666(interfaceC23924, "onRepeat");
        AnimatorKt$addListener$listener$1 animatorKt$addListener$listener$1 = new AnimatorKt$addListener$listener$1(interfaceC23924, interfaceC2392, interfaceC23923, interfaceC23922);
        animator.addListener(animatorKt$addListener$listener$1);
        return animatorKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener addPauseListener(Animator animator, InterfaceC2392<? super Animator, i4> interfaceC2392, InterfaceC2392<? super Animator, i4> interfaceC23922) {
        C3921.m12666(animator, "<this>");
        C3921.m12666(interfaceC2392, "onResume");
        C3921.m12666(interfaceC23922, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(interfaceC23922, interfaceC2392);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static /* synthetic */ Animator.AnimatorPauseListener addPauseListener$default(Animator animator, InterfaceC2392 interfaceC2392, InterfaceC2392 interfaceC23922, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC2392 = new InterfaceC2392<Animator, i4>() { // from class: androidx.core.animation.AnimatorKt.addPauseListener.1
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Animator animator2) {
                    invoke2(animator2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animator animator2) {
                    C3921.m12666(animator2, "it");
                }
            };
        }
        if ((i & 2) != 0) {
            interfaceC23922 = new InterfaceC2392<Animator, i4>() { // from class: androidx.core.animation.AnimatorKt.addPauseListener.2
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Animator animator2) {
                    invoke2(animator2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Animator animator2) {
                    C3921.m12666(animator2, "it");
                }
            };
        }
        C3921.m12666(animator, "<this>");
        C3921.m12666(interfaceC2392, "onResume");
        C3921.m12666(interfaceC23922, "onPause");
        AnimatorKt$addPauseListener$listener$1 animatorKt$addPauseListener$listener$1 = new AnimatorKt$addPauseListener$listener$1(interfaceC23922, interfaceC2392);
        animator.addPauseListener(animatorKt$addPauseListener$listener$1);
        return animatorKt$addPauseListener$listener$1;
    }

    public static final Animator.AnimatorListener doOnCancel(Animator animator, final InterfaceC2392<? super Animator, i4> interfaceC2392) {
        C3921.m12666(animator, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                C3921.m12666(animator2, "animator");
                interfaceC2392.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    public static final Animator.AnimatorListener doOnEnd(Animator animator, final InterfaceC2392<? super Animator, i4> interfaceC2392) {
        C3921.m12666(animator, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                C3921.m12666(animator2, "animator");
                interfaceC2392.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnPause(Animator animator, final InterfaceC2392<? super Animator, i4> interfaceC2392) {
        C3921.m12666(animator, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnPause$$inlined$addPauseListener$default$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator2) {
                C3921.m12666(animator2, "animator");
                interfaceC2392.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static final Animator.AnimatorListener doOnRepeat(Animator animator, final InterfaceC2392<? super Animator, i4> interfaceC2392) {
        C3921.m12666(animator, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnRepeat$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                C3921.m12666(animator2, "animator");
                interfaceC2392.invoke(animator2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }

    @RequiresApi(19)
    public static final Animator.AnimatorPauseListener doOnResume(Animator animator, final InterfaceC2392<? super Animator, i4> interfaceC2392) {
        C3921.m12666(animator, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Animator.AnimatorPauseListener animatorPauseListener = new Animator.AnimatorPauseListener() { // from class: androidx.core.animation.AnimatorKt$doOnResume$$inlined$addPauseListener$default$1
            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator2) {
                C3921.m12666(animator2, "animator");
                interfaceC2392.invoke(animator2);
            }
        };
        animator.addPauseListener(animatorPauseListener);
        return animatorPauseListener;
    }

    public static final Animator.AnimatorListener doOnStart(Animator animator, final InterfaceC2392<? super Animator, i4> interfaceC2392) {
        C3921.m12666(animator, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() { // from class: androidx.core.animation.AnimatorKt$doOnStart$$inlined$addListener$default$1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator2) {
                C3921.m12666(animator2, "animator");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                C3921.m12666(animator2, "animator");
                interfaceC2392.invoke(animator2);
            }
        };
        animator.addListener(animatorListener);
        return animatorListener;
    }
}
