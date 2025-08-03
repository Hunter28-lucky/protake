package androidx.lifecycle;

import androidx.annotation.MainThread;
import androidx.lifecycle.Lifecycle;
import defpackage.C3921;
import defpackage.InterfaceC5238;

/* compiled from: LifecycleController.kt */
@MainThread
/* loaded from: classes.dex */
public final class LifecycleController {
    private final DispatchQueue dispatchQueue;
    private final Lifecycle lifecycle;
    private final Lifecycle.State minState;
    private final LifecycleEventObserver observer;

    public LifecycleController(Lifecycle lifecycle, Lifecycle.State state, DispatchQueue dispatchQueue, final InterfaceC5238 interfaceC5238) {
        C3921.m12666(lifecycle, "lifecycle");
        C3921.m12666(state, "minState");
        C3921.m12666(dispatchQueue, "dispatchQueue");
        C3921.m12666(interfaceC5238, "parentJob");
        this.lifecycle = lifecycle;
        this.minState = state;
        this.dispatchQueue = dispatchQueue;
        LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: androidx.lifecycle.LifecycleController$observer$1
            @Override // androidx.lifecycle.LifecycleEventObserver
            public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                C3921.m12666(lifecycleOwner, "source");
                C3921.m12666(event, "$noName_1");
                if (lifecycleOwner.getLifecycle().getCurrentState() == Lifecycle.State.DESTROYED) {
                    LifecycleController lifecycleController = this.this$0;
                    InterfaceC5238.C5239.m15254(interfaceC5238, null, 1, null);
                    lifecycleController.finish();
                } else if (lifecycleOwner.getLifecycle().getCurrentState().compareTo(this.this$0.minState) < 0) {
                    this.this$0.dispatchQueue.pause();
                } else {
                    this.this$0.dispatchQueue.resume();
                }
            }
        };
        this.observer = lifecycleEventObserver;
        if (lifecycle.getCurrentState() != Lifecycle.State.DESTROYED) {
            lifecycle.addObserver(lifecycleEventObserver);
        } else {
            InterfaceC5238.C5239.m15254(interfaceC5238, null, 1, null);
            finish();
        }
    }

    private final void handleDestroy(InterfaceC5238 interfaceC5238) {
        InterfaceC5238.C5239.m15254(interfaceC5238, null, 1, null);
        finish();
    }

    @MainThread
    public final void finish() {
        this.lifecycle.removeObserver(this.observer);
        this.dispatchQueue.finish();
    }
}
