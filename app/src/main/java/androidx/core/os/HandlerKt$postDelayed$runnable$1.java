package androidx.core.os;

import defpackage.InterfaceC4090;
import defpackage.i4;

/* compiled from: Handler.kt */
/* loaded from: classes.dex */
public final class HandlerKt$postDelayed$runnable$1 implements Runnable {
    public final /* synthetic */ InterfaceC4090<i4> $action;

    public HandlerKt$postDelayed$runnable$1(InterfaceC4090<i4> interfaceC4090) {
        this.$action = interfaceC4090;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$action.invoke();
    }
}
