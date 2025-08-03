package androidx.databinding;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import defpackage.C3921;
import defpackage.C5022;
import defpackage.InterfaceC2715;
import defpackage.InterfaceC5238;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* compiled from: ViewDataBindingKtx.kt */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes.dex */
public final class ViewDataBindingKtx {
    public static final ViewDataBindingKtx INSTANCE = new ViewDataBindingKtx();
    private static final CreateWeakListener CREATE_STATE_FLOW_LISTENER = new CreateWeakListener() { // from class: androidx.databinding.Ϳ
        @Override // androidx.databinding.CreateWeakListener
        public final WeakListener create(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
            return ViewDataBindingKtx.m104CREATE_STATE_FLOW_LISTENER$lambda0(viewDataBinding, i, referenceQueue);
        }
    };

    /* compiled from: ViewDataBindingKtx.kt */
    public static final class StateFlowListener implements ObservableReference<InterfaceC2715<? extends Object>> {
        private WeakReference<LifecycleOwner> _lifecycleOwnerRef;
        private final WeakListener<InterfaceC2715<Object>> listener;
        private InterfaceC5238 observerJob;

        public StateFlowListener(ViewDataBinding viewDataBinding, int i, ReferenceQueue<ViewDataBinding> referenceQueue) {
            C3921.m12666(referenceQueue, "referenceQueue");
            this.listener = new WeakListener<>(viewDataBinding, i, this, referenceQueue);
        }

        private final void startCollection(LifecycleOwner lifecycleOwner, InterfaceC2715<? extends Object> interfaceC2715) {
            InterfaceC5238 interfaceC5238 = this.observerJob;
            if (interfaceC5238 != null) {
                InterfaceC5238.C5239.m15254(interfaceC5238, null, 1, null);
            }
            this.observerJob = C5022.m14810(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new ViewDataBindingKtx$StateFlowListener$startCollection$1(lifecycleOwner, interfaceC2715, this, null), 3, null);
        }

        @Override // androidx.databinding.ObservableReference
        public WeakListener<InterfaceC2715<? extends Object>> getListener() {
            return this.listener;
        }

        @Override // androidx.databinding.ObservableReference
        public void setLifecycleOwner(LifecycleOwner lifecycleOwner) {
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            if ((weakReference == null ? null : weakReference.get()) == lifecycleOwner) {
                return;
            }
            InterfaceC5238 interfaceC5238 = this.observerJob;
            if (interfaceC5238 != null) {
                InterfaceC5238.C5239.m15254(interfaceC5238, null, 1, null);
            }
            if (lifecycleOwner == null) {
                this._lifecycleOwnerRef = null;
                return;
            }
            this._lifecycleOwnerRef = new WeakReference<>(lifecycleOwner);
            InterfaceC2715<? extends Object> interfaceC2715 = (InterfaceC2715) this.listener.getTarget();
            if (interfaceC2715 != null) {
                startCollection(lifecycleOwner, interfaceC2715);
            }
        }

        @Override // androidx.databinding.ObservableReference
        public void addListener(InterfaceC2715<? extends Object> interfaceC2715) {
            WeakReference<LifecycleOwner> weakReference = this._lifecycleOwnerRef;
            LifecycleOwner lifecycleOwner = weakReference == null ? null : weakReference.get();
            if (lifecycleOwner == null || interfaceC2715 == null) {
                return;
            }
            startCollection(lifecycleOwner, interfaceC2715);
        }

        @Override // androidx.databinding.ObservableReference
        public void removeListener(InterfaceC2715<? extends Object> interfaceC2715) {
            InterfaceC5238 interfaceC5238 = this.observerJob;
            if (interfaceC5238 != null) {
                InterfaceC5238.C5239.m15254(interfaceC5238, null, 1, null);
            }
            this.observerJob = null;
        }
    }

    private ViewDataBindingKtx() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CREATE_STATE_FLOW_LISTENER$lambda-0, reason: not valid java name */
    public static final WeakListener m104CREATE_STATE_FLOW_LISTENER$lambda0(ViewDataBinding viewDataBinding, int i, ReferenceQueue referenceQueue) {
        C3921.m12665(referenceQueue, "referenceQueue");
        return new StateFlowListener(viewDataBinding, i, referenceQueue).getListener();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final boolean updateStateFlowRegistration(ViewDataBinding viewDataBinding, int i, InterfaceC2715<?> interfaceC2715) {
        C3921.m12666(viewDataBinding, "viewDataBinding");
        viewDataBinding.mInStateFlowRegisterObserver = true;
        try {
            return viewDataBinding.updateRegistration(i, interfaceC2715, CREATE_STATE_FLOW_LISTENER);
        } finally {
            viewDataBinding.mInStateFlowRegisterObserver = false;
        }
    }
}
