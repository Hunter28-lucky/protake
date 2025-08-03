package com.polidea.rxandroidble2.utils;

import com.polidea.rxandroidble2.RxBleConnection;
import defpackage.AbstractC4262;
import defpackage.InterfaceC2856;
import defpackage.InterfaceC3809;
import defpackage.InterfaceC5298;
import java.util.concurrent.atomic.AtomicReference;

@Deprecated
/* loaded from: classes2.dex */
public class ConnectionSharingAdapter implements InterfaceC5298<RxBleConnection, RxBleConnection> {
    public final AtomicReference<AbstractC4262<RxBleConnection>> connectionObservable = new AtomicReference<>();

    @Override // defpackage.InterfaceC5298
    public InterfaceC2856<RxBleConnection> apply(AbstractC4262<RxBleConnection> abstractC4262) {
        synchronized (this.connectionObservable) {
            AbstractC4262<RxBleConnection> abstractC42622 = this.connectionObservable.get();
            if (abstractC42622 != null) {
                return abstractC42622;
            }
            AbstractC4262<RxBleConnection> abstractC4262M14718 = abstractC4262.doFinally(new InterfaceC3809() { // from class: com.polidea.rxandroidble2.utils.ConnectionSharingAdapter.1
                @Override // defpackage.InterfaceC3809
                public void run() {
                    ConnectionSharingAdapter.this.connectionObservable.set(null);
                }
            }).replay(1).m14718();
            this.connectionObservable.set(abstractC4262M14718);
            return abstractC4262M14718;
        }
    }
}
