package org.jcodec.common.model;

/* loaded from: classes2.dex */
public class Plane {
    public int[] data;
    public Size size;

    public Plane(int[] iArr, Size size) {
        this.data = iArr;
        this.size = size;
    }

    public int[] getData() {
        return this.data;
    }

    public Size getSize() {
        return this.size;
    }
}
