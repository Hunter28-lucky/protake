package kotlinx.coroutines.channels;

import java.util.Arrays;

/* compiled from: BufferOverflow.kt */
/* loaded from: classes2.dex */
public enum BufferOverflow {
    SUSPEND,
    DROP_OLDEST,
    DROP_LATEST;

    /* renamed from: values, reason: to resolve conflict with enum method */
    public static BufferOverflow[] valuesCustom() {
        BufferOverflow[] bufferOverflowArrValuesCustom = values();
        return (BufferOverflow[]) Arrays.copyOf(bufferOverflowArrValuesCustom, bufferOverflowArrValuesCustom.length);
    }
}
