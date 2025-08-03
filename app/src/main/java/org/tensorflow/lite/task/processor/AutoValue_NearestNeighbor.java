package org.tensorflow.lite.task.processor;

import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
final class AutoValue_NearestNeighbor extends NearestNeighbor {
    private final float distance;
    private final ByteBuffer metadata;

    public AutoValue_NearestNeighbor(ByteBuffer byteBuffer, float f) {
        if (byteBuffer == null) {
            throw new NullPointerException("Null metadata");
        }
        this.metadata = byteBuffer;
        this.distance = f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NearestNeighbor)) {
            return false;
        }
        NearestNeighbor nearestNeighbor = (NearestNeighbor) obj;
        return this.metadata.equals(nearestNeighbor.getMetadata()) && Float.floatToIntBits(this.distance) == Float.floatToIntBits(nearestNeighbor.getDistance());
    }

    @Override // org.tensorflow.lite.task.processor.NearestNeighbor
    public float getDistance() {
        return this.distance;
    }

    @Override // org.tensorflow.lite.task.processor.NearestNeighbor
    public ByteBuffer getMetadata() {
        return this.metadata;
    }

    public int hashCode() {
        return ((this.metadata.hashCode() ^ 1000003) * 1000003) ^ Float.floatToIntBits(this.distance);
    }

    public String toString() {
        return "NearestNeighbor{metadata=" + this.metadata + ", distance=" + this.distance + "}";
    }
}
