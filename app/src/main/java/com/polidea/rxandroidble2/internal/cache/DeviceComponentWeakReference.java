package com.polidea.rxandroidble2.internal.cache;

import com.polidea.rxandroidble2.internal.DeviceComponent;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
class DeviceComponentWeakReference extends WeakReference<DeviceComponent> {

    public interface Provider {
        DeviceComponentWeakReference provide(DeviceComponent deviceComponent);
    }

    public DeviceComponentWeakReference(DeviceComponent deviceComponent) {
        super(deviceComponent);
    }

    public boolean contains(Object obj) {
        DeviceComponent deviceComponent = get();
        return (obj instanceof DeviceComponent) && deviceComponent != null && deviceComponent.provideDevice() == ((DeviceComponent) obj).provideDevice();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof WeakReference)) {
            return false;
        }
        DeviceComponent deviceComponent = get();
        Object obj2 = ((WeakReference) obj).get();
        return deviceComponent != null && (obj2 instanceof DeviceComponent) && deviceComponent.provideDevice().equals(((DeviceComponent) obj2).provideDevice());
    }

    public int hashCode() {
        if (get() != null) {
            return get().hashCode();
        }
        return 0;
    }

    public boolean isEmpty() {
        return get() == null;
    }

    public DeviceComponentWeakReference(DeviceComponent deviceComponent, ReferenceQueue<? super DeviceComponent> referenceQueue) {
        super(deviceComponent, referenceQueue);
    }
}
