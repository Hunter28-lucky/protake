package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes2.dex */
abstract class DecodedObject {
    private final int newPosition;

    public DecodedObject(int i) {
        this.newPosition = i;
    }

    public final int getNewPosition() {
        return this.newPosition;
    }
}
