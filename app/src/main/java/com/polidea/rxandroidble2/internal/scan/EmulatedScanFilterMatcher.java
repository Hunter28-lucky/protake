package com.polidea.rxandroidble2.internal.scan;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* loaded from: classes2.dex */
public class EmulatedScanFilterMatcher {
    private final boolean isEmpty;

    @Nullable
    private final ScanFilterInterface[] scanFilters;

    public EmulatedScanFilterMatcher(@Nullable ScanFilterInterface... scanFilterInterfaceArr) {
        this.scanFilters = scanFilterInterfaceArr;
        boolean z = false;
        if (scanFilterInterfaceArr == null || scanFilterInterfaceArr.length == 0) {
            z = true;
        } else {
            for (ScanFilterInterface scanFilterInterface : scanFilterInterfaceArr) {
                if (!scanFilterInterface.isAllFieldsEmpty()) {
                    break;
                }
            }
            z = true;
        }
        this.isEmpty = z;
    }

    public boolean isEmpty() {
        return this.isEmpty;
    }

    public boolean matches(RxBleInternalScanResult rxBleInternalScanResult) {
        ScanFilterInterface[] scanFilterInterfaceArr = this.scanFilters;
        if (scanFilterInterfaceArr == null || scanFilterInterfaceArr.length == 0) {
            return true;
        }
        for (ScanFilterInterface scanFilterInterface : scanFilterInterfaceArr) {
            if (scanFilterInterface.matches(rxBleInternalScanResult)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "emulatedFilters=" + Arrays.toString(this.scanFilters);
    }
}
