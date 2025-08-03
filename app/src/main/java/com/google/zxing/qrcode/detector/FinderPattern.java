package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

/* loaded from: classes2.dex */
public final class FinderPattern extends ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    public FinderPattern(float f, float f2, float f3) {
        this(f, f2, f3, 1);
    }

    public boolean aboutEquals(float f, float f2, float f3) {
        if (Math.abs(f2 - getY()) > f || Math.abs(f3 - getX()) > f) {
            return false;
        }
        float fAbs = Math.abs(f - this.estimatedModuleSize);
        return fAbs <= 1.0f || fAbs <= this.estimatedModuleSize;
    }

    public FinderPattern combineEstimate(float f, float f2, float f3) {
        int i = this.count;
        int i2 = i + 1;
        float x = (i * getX()) + f2;
        float f4 = i2;
        return new FinderPattern(x / f4, ((this.count * getY()) + f) / f4, ((this.count * this.estimatedModuleSize) + f3) / f4, i2);
    }

    public int getCount() {
        return this.count;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    private FinderPattern(float f, float f2, float f3, int i) {
        super(f, f2);
        this.estimatedModuleSize = f3;
        this.count = i;
    }
}
