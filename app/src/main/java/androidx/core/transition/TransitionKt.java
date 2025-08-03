package androidx.core.transition;

import android.annotation.SuppressLint;
import android.transition.Transition;
import androidx.annotation.RequiresApi;
import defpackage.C3921;
import defpackage.InterfaceC2392;
import defpackage.i4;

/* compiled from: Transition.kt */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: classes.dex */
public final class TransitionKt {
    @RequiresApi(19)
    public static final Transition.TransitionListener addListener(Transition transition, InterfaceC2392<? super Transition, i4> interfaceC2392, InterfaceC2392<? super Transition, i4> interfaceC23922, InterfaceC2392<? super Transition, i4> interfaceC23923, InterfaceC2392<? super Transition, i4> interfaceC23924, InterfaceC2392<? super Transition, i4> interfaceC23925) {
        C3921.m12666(transition, "<this>");
        C3921.m12666(interfaceC2392, "onEnd");
        C3921.m12666(interfaceC23922, "onStart");
        C3921.m12666(interfaceC23923, "onCancel");
        C3921.m12666(interfaceC23924, "onResume");
        C3921.m12666(interfaceC23925, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(interfaceC2392, interfaceC23924, interfaceC23925, interfaceC23923, interfaceC23922);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    public static /* synthetic */ Transition.TransitionListener addListener$default(Transition transition, InterfaceC2392 interfaceC2392, InterfaceC2392 interfaceC23922, InterfaceC2392 interfaceC23923, InterfaceC2392 interfaceC23924, InterfaceC2392 interfaceC23925, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC2392 = new InterfaceC2392<Transition, i4>() { // from class: androidx.core.transition.TransitionKt.addListener.1
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Transition transition2) {
                    invoke2(transition2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Transition transition2) {
                    C3921.m12666(transition2, "it");
                }
            };
        }
        if ((i & 2) != 0) {
            interfaceC23922 = new InterfaceC2392<Transition, i4>() { // from class: androidx.core.transition.TransitionKt.addListener.2
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Transition transition2) {
                    invoke2(transition2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Transition transition2) {
                    C3921.m12666(transition2, "it");
                }
            };
        }
        InterfaceC2392 interfaceC23926 = interfaceC23922;
        if ((i & 4) != 0) {
            interfaceC23923 = new InterfaceC2392<Transition, i4>() { // from class: androidx.core.transition.TransitionKt.addListener.3
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Transition transition2) {
                    invoke2(transition2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Transition transition2) {
                    C3921.m12666(transition2, "it");
                }
            };
        }
        InterfaceC2392 interfaceC23927 = interfaceC23923;
        if ((i & 8) != 0) {
            interfaceC23924 = new InterfaceC2392<Transition, i4>() { // from class: androidx.core.transition.TransitionKt.addListener.4
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Transition transition2) {
                    invoke2(transition2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Transition transition2) {
                    C3921.m12666(transition2, "it");
                }
            };
        }
        if ((i & 16) != 0) {
            interfaceC23925 = new InterfaceC2392<Transition, i4>() { // from class: androidx.core.transition.TransitionKt.addListener.5
                @Override // defpackage.InterfaceC2392
                public /* bridge */ /* synthetic */ i4 invoke(Transition transition2) {
                    invoke2(transition2);
                    return i4.f6762;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Transition transition2) {
                    C3921.m12666(transition2, "it");
                }
            };
        }
        C3921.m12666(transition, "<this>");
        C3921.m12666(interfaceC2392, "onEnd");
        C3921.m12666(interfaceC23926, "onStart");
        C3921.m12666(interfaceC23927, "onCancel");
        C3921.m12666(interfaceC23924, "onResume");
        C3921.m12666(interfaceC23925, "onPause");
        TransitionKt$addListener$listener$1 transitionKt$addListener$listener$1 = new TransitionKt$addListener$listener$1(interfaceC2392, interfaceC23924, interfaceC23925, interfaceC23927, interfaceC23926);
        transition.addListener(transitionKt$addListener$listener$1);
        return transitionKt$addListener$listener$1;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnCancel(Transition transition, final InterfaceC2392<? super Transition, i4> interfaceC2392) {
        C3921.m12666(transition, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnCancel$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                C3921.m12666(transition2, "transition");
                interfaceC2392.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnEnd(Transition transition, final InterfaceC2392<? super Transition, i4> interfaceC2392) {
        C3921.m12666(transition, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnEnd$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                C3921.m12666(transition2, "transition");
                interfaceC2392.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnPause(Transition transition, final InterfaceC2392<? super Transition, i4> interfaceC2392) {
        C3921.m12666(transition, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnPause$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                C3921.m12666(transition2, "transition");
                interfaceC2392.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnResume(Transition transition, final InterfaceC2392<? super Transition, i4> interfaceC2392) {
        C3921.m12666(transition, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnResume$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                C3921.m12666(transition2, "transition");
                interfaceC2392.invoke(transition2);
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }

    @RequiresApi(19)
    public static final Transition.TransitionListener doOnStart(Transition transition, final InterfaceC2392<? super Transition, i4> interfaceC2392) {
        C3921.m12666(transition, "<this>");
        C3921.m12666(interfaceC2392, "action");
        Transition.TransitionListener transitionListener = new Transition.TransitionListener() { // from class: androidx.core.transition.TransitionKt$doOnStart$$inlined$addListener$default$1
            @Override // android.transition.Transition.TransitionListener
            public void onTransitionCancel(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionEnd(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionPause(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionResume(Transition transition2) {
                C3921.m12666(transition2, "transition");
            }

            @Override // android.transition.Transition.TransitionListener
            public void onTransitionStart(Transition transition2) {
                C3921.m12666(transition2, "transition");
                interfaceC2392.invoke(transition2);
            }
        };
        transition.addListener(transitionListener);
        return transitionListener;
    }
}
