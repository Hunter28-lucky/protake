package androidx.core.os;

import android.os.OutcomeReceiver;
import androidx.annotation.RequiresApi;
import com.umeng.analytics.pro.d;
import defpackage.C3921;
import defpackage.C4817;
import defpackage.InterfaceC4355;
import java.lang.Throwable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;

/* compiled from: OutcomeReceiver.kt */
@RequiresApi(31)
/* loaded from: classes.dex */
final class ContinuationOutcomeReceiver<R, E extends Throwable> extends AtomicBoolean implements OutcomeReceiver {
    private final InterfaceC4355<R> continuation;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ContinuationOutcomeReceiver(InterfaceC4355<? super R> interfaceC4355) {
        super(false);
        C3921.m12666(interfaceC4355, "continuation");
        this.continuation = interfaceC4355;
    }

    public void onError(E e2) {
        C3921.m12666(e2, d.O);
        if (compareAndSet(false, true)) {
            InterfaceC4355<R> interfaceC4355 = this.continuation;
            Result.C2137 c2137 = Result.f7828;
            interfaceC4355.resumeWith(Result.m7211(C4817.m14541(e2)));
        }
    }

    public void onResult(R r) {
        if (compareAndSet(false, true)) {
            this.continuation.resumeWith(Result.m7211(r));
        }
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "ContinuationOutcomeReceiver(outcomeReceived = " + get() + ')';
    }
}
