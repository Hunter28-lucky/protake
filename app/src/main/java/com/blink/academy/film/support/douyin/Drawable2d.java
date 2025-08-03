package com.blink.academy.film.support.douyin;

import defpackage.AbstractC2364;
import java.nio.FloatBuffer;

/* loaded from: classes.dex */
public class Drawable2d {

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static final float[] f1524;

    /* renamed from: ԯ, reason: contains not printable characters */
    public static final float[] f1525;

    /* renamed from: ՠ, reason: contains not printable characters */
    public static final FloatBuffer f1526;

    /* renamed from: ֈ, reason: contains not printable characters */
    public static final FloatBuffer f1527;

    /* renamed from: ֏, reason: contains not printable characters */
    public static final float[] f1528;

    /* renamed from: ׯ, reason: contains not printable characters */
    public static final float[] f1529;

    /* renamed from: ؠ, reason: contains not printable characters */
    public static final FloatBuffer f1530;

    /* renamed from: ހ, reason: contains not printable characters */
    public static final FloatBuffer f1531;

    /* renamed from: ށ, reason: contains not printable characters */
    public static final float[] f1532;

    /* renamed from: ނ, reason: contains not printable characters */
    public static final float[] f1533;

    /* renamed from: ރ, reason: contains not printable characters */
    public static final float[] f1534 = {0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: ބ, reason: contains not printable characters */
    public static final FloatBuffer f1535;

    /* renamed from: ޅ, reason: contains not printable characters */
    public static final FloatBuffer f1536;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public FloatBuffer f1537;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public FloatBuffer f1538;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f1539;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f1540;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f1541;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f1542;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Prefab f1543;

    public enum Prefab {
        TRIANGLE,
        RECTANGLE,
        FULL_RECTANGLE
    }

    /* renamed from: com.blink.academy.film.support.douyin.Drawable2d$Ϳ, reason: contains not printable characters */
    public static /* synthetic */ class C0785 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public static final /* synthetic */ int[] f1548;

        static {
            int[] iArr = new int[Prefab.values().length];
            f1548 = iArr;
            try {
                iArr[Prefab.TRIANGLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1548[Prefab.RECTANGLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1548[Prefab.FULL_RECTANGLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        float[] fArr = {0.0f, 0.57735026f, -0.5f, -0.28867513f, 0.5f, -0.28867513f};
        f1524 = fArr;
        float[] fArr2 = {0.5f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        f1525 = fArr2;
        f1526 = AbstractC2364.m8833(fArr);
        f1527 = AbstractC2364.m8833(fArr2);
        float[] fArr3 = {-0.5f, -0.5f, 0.5f, -0.5f, -0.5f, 0.5f, 0.5f, 0.5f};
        f1528 = fArr3;
        float[] fArr4 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f1529 = fArr4;
        f1530 = AbstractC2364.m8833(fArr3);
        f1531 = AbstractC2364.m8833(fArr4);
        float[] fArr5 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        f1532 = fArr5;
        float[] fArr6 = {0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        f1533 = fArr6;
        f1535 = AbstractC2364.m8833(fArr5);
        f1536 = AbstractC2364.m8833(fArr6);
    }

    public Drawable2d(Prefab prefab) {
        int i = C0785.f1548[prefab.ordinal()];
        if (i == 1) {
            this.f1537 = f1526;
            this.f1538 = f1527;
            this.f1540 = 2;
            this.f1541 = 2 * 4;
            this.f1539 = f1524.length / 2;
        } else if (i == 2) {
            this.f1537 = f1530;
            this.f1538 = f1531;
            this.f1540 = 2;
            this.f1541 = 2 * 4;
            this.f1539 = f1528.length / 2;
        } else {
            if (i != 3) {
                throw new RuntimeException("Unknown shape " + prefab);
            }
            this.f1537 = f1535;
            this.f1538 = f1536;
            this.f1540 = 2;
            this.f1541 = 2 * 4;
            this.f1539 = f1532.length / 2;
        }
        this.f1542 = 8;
        this.f1543 = prefab;
    }

    public String toString() {
        if (this.f1543 == null) {
            return "[Drawable2d: ...]";
        }
        return "[Drawable2d: " + this.f1543 + "]";
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public FloatBuffer m1879() {
        return this.f1538;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public FloatBuffer m1880() {
        return this.f1537;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m1881() {
        return this.f1539;
    }
}
