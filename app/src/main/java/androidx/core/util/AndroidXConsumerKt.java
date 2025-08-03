package androidx.core.util;

import defpackage.C3921;
import defpackage.InterfaceC4355;

/* compiled from: AndroidXConsumer.kt */
/* loaded from: classes.dex */
public final class AndroidXConsumerKt {
    public static final <T> Consumer<T> asAndroidXConsumer(InterfaceC4355<? super T> interfaceC4355) {
        C3921.m12666(interfaceC4355, "<this>");
        return new AndroidXContinuationConsumer(interfaceC4355);
    }
}
