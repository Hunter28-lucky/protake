package androidx.core.util;

import androidx.annotation.RequiresApi;
import defpackage.C3921;
import defpackage.InterfaceC4355;

/* compiled from: Consumer.kt */
@RequiresApi(24)
/* loaded from: classes.dex */
public final class ConsumerKt {
    @RequiresApi(24)
    public static final <T> java.util.function.Consumer<T> asConsumer(InterfaceC4355<? super T> interfaceC4355) {
        C3921.m12666(interfaceC4355, "<this>");
        return new ContinuationConsumer(interfaceC4355);
    }
}
