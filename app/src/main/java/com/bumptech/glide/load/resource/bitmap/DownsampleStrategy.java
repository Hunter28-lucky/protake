package com.bumptech.glide.load.resource.bitmap;

import defpackage.C4238;

/* loaded from: classes.dex */
public abstract class DownsampleStrategy {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final DownsampleStrategy f5357 = new C1833();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final DownsampleStrategy f5358;

    /* renamed from: ԩ, reason: contains not printable characters */
    public static final DownsampleStrategy f5359;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static final DownsampleStrategy f5360;

    /* renamed from: ԫ, reason: contains not printable characters */
    public static final DownsampleStrategy f5361;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static final DownsampleStrategy f5362;

    /* renamed from: ԭ, reason: contains not printable characters */
    public static final DownsampleStrategy f5363;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final C4238<DownsampleStrategy> f5364;

    public enum SampleSizeRounding {
        MEMORY,
        QUALITY
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$Ϳ, reason: contains not printable characters */
    public static class C1829 extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ϳ */
        public SampleSizeRounding mo4988(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ԩ */
        public float mo4989(int i, int i2, int i3, int i4) {
            if (Math.min(i2 / i4, i / i3) == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(r1);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$Ԩ, reason: contains not printable characters */
    public static class C1830 extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ϳ */
        public SampleSizeRounding mo4988(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.MEMORY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ԩ */
        public float mo4989(int i, int i2, int i3, int i4) {
            int iCeil = (int) Math.ceil(Math.max(i2 / i4, i / i3));
            return 1.0f / (r2 << (Math.max(1, Integer.highestOneBit(iCeil)) >= iCeil ? 0 : 1));
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$Ԫ, reason: contains not printable characters */
    public static class C1831 extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ϳ */
        public SampleSizeRounding mo4988(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ԩ */
        public float mo4989(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, DownsampleStrategy.f5357.mo4989(i, i2, i3, i4));
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$Ԭ, reason: contains not printable characters */
    public static class C1832 extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ϳ */
        public SampleSizeRounding mo4988(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ԩ */
        public float mo4989(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$Ԯ, reason: contains not printable characters */
    public static class C1833 extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ϳ */
        public SampleSizeRounding mo4988(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ԩ */
        public float mo4989(int i, int i2, int i3, int i4) {
            return Math.min(i3 / i, i4 / i2);
        }
    }

    /* renamed from: com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$ՠ, reason: contains not printable characters */
    public static class C1834 extends DownsampleStrategy {
        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ϳ */
        public SampleSizeRounding mo4988(int i, int i2, int i3, int i4) {
            return SampleSizeRounding.QUALITY;
        }

        @Override // com.bumptech.glide.load.resource.bitmap.DownsampleStrategy
        /* renamed from: Ԩ */
        public float mo4989(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    static {
        C1832 c1832 = new C1832();
        f5358 = c1832;
        f5359 = new C1829();
        f5360 = new C1830();
        f5361 = new C1831();
        f5362 = new C1834();
        f5363 = c1832;
        f5364 = C4238.m13342("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", c1832);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public abstract SampleSizeRounding mo4988(int i, int i2, int i3, int i4);

    /* renamed from: Ԩ, reason: contains not printable characters */
    public abstract float mo4989(int i, int i2, int i3, int i4);
}
