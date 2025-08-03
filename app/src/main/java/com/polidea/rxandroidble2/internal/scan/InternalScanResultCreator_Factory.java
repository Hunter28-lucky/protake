package com.polidea.rxandroidble2.internal.scan;

import com.polidea.rxandroidble2.internal.util.UUIDUtil;
import defpackage.InterfaceC3628;
import defpackage.InterfaceC4461;

/* loaded from: classes2.dex */
public final class InternalScanResultCreator_Factory implements InterfaceC3628<InternalScanResultCreator> {
    private final InterfaceC4461<UUIDUtil> uuidUtilProvider;

    public InternalScanResultCreator_Factory(InterfaceC4461<UUIDUtil> interfaceC4461) {
        this.uuidUtilProvider = interfaceC4461;
    }

    public static InternalScanResultCreator_Factory create(InterfaceC4461<UUIDUtil> interfaceC4461) {
        return new InternalScanResultCreator_Factory(interfaceC4461);
    }

    @Override // defpackage.InterfaceC4461
    public InternalScanResultCreator get() {
        return new InternalScanResultCreator(this.uuidUtilProvider.get());
    }
}
