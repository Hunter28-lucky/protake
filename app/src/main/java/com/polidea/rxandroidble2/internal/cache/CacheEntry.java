package com.polidea.rxandroidble2.internal.cache;

import com.polidea.rxandroidble2.internal.DeviceComponent;
import java.util.Map;

/* loaded from: classes2.dex */
class CacheEntry implements Map.Entry<String, DeviceComponent> {
    private final DeviceComponentWeakReference deviceComponentWeakReference;
    private final String string;

    public CacheEntry(String str, DeviceComponentWeakReference deviceComponentWeakReference) {
        this.string = str;
        this.deviceComponentWeakReference = deviceComponentWeakReference;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CacheEntry)) {
            return false;
        }
        CacheEntry cacheEntry = (CacheEntry) obj;
        return this.string.equals(cacheEntry.getKey()) && this.deviceComponentWeakReference.equals(cacheEntry.deviceComponentWeakReference);
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (this.string.hashCode() * 31) + this.deviceComponentWeakReference.hashCode();
    }

    @Override // java.util.Map.Entry
    public String getKey() {
        return this.string;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.util.Map.Entry
    public DeviceComponent getValue() {
        return this.deviceComponentWeakReference.get();
    }

    @Override // java.util.Map.Entry
    public DeviceComponent setValue(DeviceComponent deviceComponent) {
        throw new UnsupportedOperationException("Not implemented");
    }
}
