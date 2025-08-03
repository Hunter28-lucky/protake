package androidx.lifecycle;

import androidx.annotation.MainThread;
import defpackage.C3921;

/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public final class ViewModelProviderKt {
    @MainThread
    public static final /* synthetic */ <VM extends ViewModel> VM get(ViewModelProvider viewModelProvider) {
        C3921.m12666(viewModelProvider, "<this>");
        C3921.m12670(4, "VM");
        return (VM) viewModelProvider.get(ViewModel.class);
    }
}
