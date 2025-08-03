package androidx.lifecycle;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import defpackage.C2313;
import defpackage.C3921;
import defpackage.InterfaceC2623;
import defpackage.InterfaceC4090;
import defpackage.InterfaceC4870;

/* compiled from: ViewModelLazy.kt */
/* loaded from: classes.dex */
public final class ViewModelLazy<VM extends ViewModel> implements InterfaceC4870<VM> {
    private VM cached;
    private final InterfaceC4090<ViewModelProvider.Factory> factoryProducer;
    private final InterfaceC4090<ViewModelStore> storeProducer;
    private final InterfaceC2623<VM> viewModelClass;

    /* JADX WARN: Multi-variable type inference failed */
    public ViewModelLazy(InterfaceC2623<VM> interfaceC2623, InterfaceC4090<? extends ViewModelStore> interfaceC4090, InterfaceC4090<? extends ViewModelProvider.Factory> interfaceC40902) {
        C3921.m12666(interfaceC2623, "viewModelClass");
        C3921.m12666(interfaceC4090, "storeProducer");
        C3921.m12666(interfaceC40902, "factoryProducer");
        this.viewModelClass = interfaceC2623;
        this.storeProducer = interfaceC4090;
        this.factoryProducer = interfaceC40902;
    }

    public boolean isInitialized() {
        return this.cached != null;
    }

    @Override // defpackage.InterfaceC4870
    public VM getValue() {
        VM vm = this.cached;
        if (vm != null) {
            return vm;
        }
        VM vm2 = (VM) new ViewModelProvider(this.storeProducer.invoke(), this.factoryProducer.invoke()).get(C2313.m8678(this.viewModelClass));
        this.cached = vm2;
        return vm2;
    }
}
