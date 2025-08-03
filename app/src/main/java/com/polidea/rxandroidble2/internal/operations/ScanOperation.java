package com.polidea.rxandroidble2.internal.operations;

import android.os.DeadObjectException;
import com.polidea.rxandroidble2.exceptions.BleException;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import com.polidea.rxandroidble2.internal.QueueOperation;
import com.polidea.rxandroidble2.internal.RxBleLog;
import com.polidea.rxandroidble2.internal.serialization.QueueReleaseInterface;
import com.polidea.rxandroidble2.internal.util.RxBleAdapterWrapper;
import defpackage.InterfaceC2672;
import defpackage.InterfaceC5245;

/* loaded from: classes2.dex */
public abstract class ScanOperation<SCAN_RESULT_TYPE, SCAN_CALLBACK_TYPE> extends QueueOperation<SCAN_RESULT_TYPE> {
    public final RxBleAdapterWrapper rxBleAdapterWrapper;

    public ScanOperation(RxBleAdapterWrapper rxBleAdapterWrapper) {
        this.rxBleAdapterWrapper = rxBleAdapterWrapper;
    }

    public abstract SCAN_CALLBACK_TYPE createScanCallback(InterfaceC5245<SCAN_RESULT_TYPE> interfaceC5245);

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public final void protectedRun(InterfaceC5245<SCAN_RESULT_TYPE> interfaceC5245, QueueReleaseInterface queueReleaseInterface) {
        final SCAN_CALLBACK_TYPE scan_callback_typeCreateScanCallback = createScanCallback(interfaceC5245);
        try {
            interfaceC5245.mo6763(new InterfaceC2672() { // from class: com.polidea.rxandroidble2.internal.operations.ScanOperation.1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // defpackage.InterfaceC2672
                public void cancel() {
                    RxBleLog.i("Scan operation is requested to stop.", new Object[0]);
                    ScanOperation scanOperation = ScanOperation.this;
                    scanOperation.stopScan(scanOperation.rxBleAdapterWrapper, scan_callback_typeCreateScanCallback);
                }
            });
            RxBleLog.i("Scan operation is requested to start.", new Object[0]);
            if (!startScan(this.rxBleAdapterWrapper, scan_callback_typeCreateScanCallback)) {
                interfaceC5245.mo6761(new BleScanException(0));
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    @Override // com.polidea.rxandroidble2.internal.QueueOperation
    public BleException provideException(DeadObjectException deadObjectException) {
        return new BleScanException(1, deadObjectException);
    }

    public abstract boolean startScan(RxBleAdapterWrapper rxBleAdapterWrapper, SCAN_CALLBACK_TYPE scan_callback_type);

    public abstract void stopScan(RxBleAdapterWrapper rxBleAdapterWrapper, SCAN_CALLBACK_TYPE scan_callback_type);
}
