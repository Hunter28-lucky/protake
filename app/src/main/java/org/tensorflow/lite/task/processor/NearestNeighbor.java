package org.tensorflow.lite.task.processor;

import com.google.auto.value.AutoValue;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.tensorflow.lite.task.core.annotations.UsedByReflection;

@AutoValue
@UsedByReflection
/* loaded from: classes2.dex */
public abstract class NearestNeighbor {
    @UsedByReflection
    public static NearestNeighbor create(byte[] bArr, float f) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        byteBufferWrap.order(ByteOrder.nativeOrder());
        return new AutoValue_NearestNeighbor(byteBufferWrap, f);
    }

    public abstract float getDistance();

    public abstract ByteBuffer getMetadata();
}
