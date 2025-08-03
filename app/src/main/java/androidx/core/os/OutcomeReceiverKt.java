package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import defpackage.C3921;
import defpackage.InterfaceC4355;

/* compiled from: OutcomeReceiver.kt */
@RequiresApi(31)
/* loaded from: classes.dex */
public final class OutcomeReceiverKt {
    @RequiresApi(31)
    public static final <R, E extends Throwable> OutcomeReceiver asOutcomeReceiver(InterfaceC4355<? super R> interfaceC4355) {
        C3921.m12666(interfaceC4355, "<this>");
        return new ContinuationOutcomeReceiver(interfaceC4355);
    }
}
