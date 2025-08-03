package com.polidea.rxandroidble2.internal.scan;

import androidx.annotation.RestrictTo;
import com.polidea.rxandroidble2.internal.operations.Operation;
import defpackage.InterfaceC5298;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class ScanSetup {
    public final Operation<RxBleInternalScanResult> scanOperation;
    public final InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> scanOperationBehaviourEmulatorTransformer;

    public ScanSetup(Operation<RxBleInternalScanResult> operation, InterfaceC5298<RxBleInternalScanResult, RxBleInternalScanResult> interfaceC5298) {
        this.scanOperation = operation;
        this.scanOperationBehaviourEmulatorTransformer = interfaceC5298;
    }
}
