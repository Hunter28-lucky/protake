package com.blink.academy.film.videotools;

import android.graphics.Bitmap;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.blink.academy.film.stream.ACHelper;
import com.blink.academy.film.videotools.C0851;
import defpackage.C2390;
import defpackage.C2483;
import defpackage.C2721;
import defpackage.C2735;
import defpackage.C2813;
import defpackage.C3606;
import defpackage.C3732;
import defpackage.C4327;
import defpackage.C4638;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public class FrameRenderer {

    /* renamed from: ދ, reason: contains not printable characters */
    public static long f1769;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C0851 f1771;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C2390 f1777;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C2390 f1778;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C4327[] f1779;

    /* renamed from: ՠ, reason: contains not printable characters */
    public C4327[] f1780;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f1784;

    /* renamed from: ހ, reason: contains not printable characters */
    public int f1785;

    /* renamed from: ފ, reason: contains not printable characters */
    public static final float[] f1768 = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};

    /* renamed from: ތ, reason: contains not printable characters */
    public static int f1770 = 0;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f1772 = true;

    /* renamed from: ԩ, reason: contains not printable characters */
    public C4327 f1773 = new C4327();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public RenderMode f1774 = RenderMode.RENDER_CROP;

    /* renamed from: ԫ, reason: contains not printable characters */
    public FloatBuffer f1775 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public FloatBuffer f1776 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f1781 = 0;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f1782 = 0;

    /* renamed from: ׯ, reason: contains not printable characters */
    public boolean f1783 = false;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f1786 = 0.0f;

    /* renamed from: ނ, reason: contains not printable characters */
    public float f1787 = 0.0f;

    /* renamed from: ރ, reason: contains not printable characters */
    public float f1788 = 0.0f;

    /* renamed from: ބ, reason: contains not printable characters */
    public float f1789 = 0.0f;

    /* renamed from: ޅ, reason: contains not printable characters */
    public float f1790 = 1.0f;

    /* renamed from: ކ, reason: contains not printable characters */
    public float f1791 = 1.0f;

    /* renamed from: އ, reason: contains not printable characters */
    public int f1792 = -1;

    /* renamed from: ވ, reason: contains not printable characters */
    public double f1793 = 0.0d;

    /* renamed from: މ, reason: contains not printable characters */
    public boolean f1794 = false;

    public enum RenderMode {
        RENDER_STRETCH,
        RENDER_CROP,
        RENDER_FILL
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static void m2048(C4327 c4327, int i, int i2) {
        boolean z;
        long jNanoTime = System.nanoTime();
        if (c4327.m13478()) {
            z = false;
        } else {
            c4327.m13477();
            C3732.m11943("createFilter");
            z = true;
        }
        if (z || c4327.m13473() != i || c4327.m13472() != i2) {
            c4327.mo9491(i, i2);
        }
        long jNanoTime2 = System.nanoTime();
        long j = (jNanoTime2 - jNanoTime) / 1000000;
        if (j > 10) {
            Log.d("FrameRenderer", String.format("initfilter took %d ms", Long.valueOf(j)));
        }
        long j2 = f1769;
        if (j2 != 0) {
            Log.d("FrameRenderer", String.format("setfilter took %d ms", Long.valueOf((jNanoTime2 - j2) / 1000000)));
            f1769 = 0L;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m2049() {
        m2050();
        C4327[] c4327Arr = this.f1780;
        if (c4327Arr != null && c4327Arr.length > 0) {
            for (C4327 c4327 : c4327Arr) {
                c4327.m13471();
                c4327.mo10877();
            }
            this.f1780 = null;
        }
        C4327 c43272 = this.f1773;
        if (c43272 != null) {
            c43272.m13471();
            this.f1773 = null;
        }
        C2390 c2390 = this.f1778;
        if (c2390 != null) {
            c2390.m8880();
            this.f1778 = null;
        }
        C2390 c23902 = this.f1777;
        if (c23902 != null) {
            c23902.m8880();
            this.f1777 = null;
        }
        this.f1771 = null;
        this.f1792 = -1;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m2050() {
        C4327[] c4327Arr = this.f1779;
        if (c4327Arr == null || c4327Arr.length <= 0) {
            return;
        }
        for (C4327 c4327 : c4327Arr) {
            c4327.m13471();
            c4327.mo10877();
        }
        this.f1779 = null;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m2051(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, C4327 c4327, int i10, int i11, int i12, int i13, int i14, int i15, int i16, float[] fArr, boolean z2, boolean z3) {
        if (c4327 instanceof C3606) {
            ((C3606) c4327).m11638().size();
        }
        m2054(z, i, i2, i3, i4, i5, i6, i7, i8, i9, c4327, i10, i11, i12, i13, i14, i15, i16, fArr, 0, false, false, z3);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m2052(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, C4327 c4327, int i10, int i11, int i12, int i13, int i14) {
        C3732.m11943("before FrameRenderer");
        for (int i15 = 0; i15 < 4; i15++) {
            GLES20.glActiveTexture(33984 + i15);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
        }
        if (!c4327.getClass().equals(C2483.class)) {
            c4327.getClass().equals(C4327.class);
        }
        System.nanoTime();
        C3732.m11943("foo2");
        m2048(c4327, i4, i5);
        float f = i13 / i11;
        float f2 = i14 / i12;
        this.f1775.clear();
        this.f1775.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}).position(0);
        this.f1776.clear();
        this.f1776.put(new float[]{0.0f, f2, f, f2, 0.0f, 0.0f, f, 0.0f}).position(0);
        GLES20.glBindFramebuffer(36160, i);
        if (z) {
            GLES20.glClearColor(0.0745f, 0.0706f, 0.0667f, 1.0f);
            GLES20.glClear(16384);
        }
        GLES20.glViewport(i2, i3, i4, i5);
        GLES20.glScissor(i6, i7, i8, i9);
        GLES20.glEnable(3089);
        System.nanoTime();
        c4327.m13479(i10, ACHelper.getInstance().getGLCubeBuffer(), ACHelper.getInstance().getGLTextureBuffer());
        GLES20.glDisable(3089);
        GLES20.glBindFramebuffer(36160, 0);
        C3732.m11943("foo3");
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public void m2053(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, C4327 c4327, int i10, int i11, int i12, int i13, int i14, int i15, int i16, float[] fArr, int i17, boolean z2) {
        m2054(z, i, i2, i3, i4, i5, i6, i7, i8, i9, c4327, i10, i11, i12, i13, i14, i15, i16, fArr, i17, false, false, z2);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public void m2054(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, C4327 c4327, int i10, int i11, int i12, int i13, int i14, int i15, int i16, float[] fArr, int i17, boolean z2, boolean z3, boolean z4) {
        if (z2) {
            int i18 = f1770 + 1;
            f1770 = i18;
            C4638.m14099("RecordEveryFrame1", String.format("frameCount : %s , clearOutput : %s , tgtfbo : %s , outX : %s , outY : %s ,outWidth : %s , outHeight : %s , scissorX : %s , scissorY : %s , scissorW : %s , scissOrH : %s , textureId : %s , texWidth : %s , texHeight : %s , captureWidth : %s , captureHeight : %s , filterWidth : %s , filterHeight : %s , m : %s , cameraId : %s ", Integer.valueOf(i18), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), fArr, Integer.valueOf(i17)));
        }
        C3732.m11943("before FrameRenderer");
        for (int i19 = 0; i19 < 4; i19++) {
            GLES20.glActiveTexture(33984 + i19);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
        }
        if (!c4327.getClass().equals(C2483.class)) {
            c4327.getClass().equals(C4327.class);
        }
        System.nanoTime();
        if (i15 != this.f1784 || i16 != this.f1785) {
            m2058(i15, i16);
            this.f1783 = false;
        }
        System.nanoTime();
        C3732.m11943("foo2");
        m2048(c4327, this.f1784, this.f1785);
        float[] fArr2 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        if (z4) {
            fArr2 = new float[]{1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};
        }
        float f = i13 / i11;
        float f2 = i14 / i12;
        float[] fArr3 = {0.0f, 0.0f, f, 0.0f, 0.0f, f2, f, f2};
        this.f1775.clear();
        this.f1775.put(fArr2).position(0);
        this.f1776.clear();
        this.f1776.put(fArr3).position(0);
        GLES20.glBindFramebuffer(36160, this.f1778.m8881());
        GLES20.glViewport(0, 0, this.f1784, this.f1785);
        GLES20.glScissor(0, 0, this.f1784, this.f1785);
        System.nanoTime();
        if (z2) {
            C4638.m14099("RecordEveryFrame2", String.format("frameCount : %s , cube : %s , tex : %s ", Integer.valueOf(f1770), Arrays.toString(fArr2), Arrays.toString(fArr3)));
        }
        c4327.m13479(i10, this.f1775, this.f1776);
        int i20 = this.f1784;
        int i21 = this.f1785;
        C3732.m11943("foo3");
        System.nanoTime();
        System.nanoTime();
        System.nanoTime();
        if (i5 < 0) {
            throw new RuntimeException("upside down");
        }
        float[] fArrM2090 = z3 ? new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f} : C0851.m2090(this.f1774, fArr, this.f1786, this.f1787, i4, i5, i15, i16);
        float[] fArrM2092 = C0851.m2092(i20, i21, i20, i21, false);
        if (z2) {
            C4638.m14099("RecordEveryFrame3", String.format("frameCount : %s , final cube : %s , m : %s , mode : %s , xOffset : %s , yOffset : %s , outWidth : %s , outHeight : %s , filterWidth : %s , filterHeight : %s ", Integer.valueOf(f1770), Arrays.toString(fArrM2090), Arrays.toString(fArr), this.f1774, Float.valueOf(this.f1786), Float.valueOf(this.f1787), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i15), Integer.valueOf(i16)));
        }
        this.f1775.clear();
        this.f1775.put(fArrM2090).position(0);
        this.f1776.clear();
        this.f1776.put(fArrM2092).position(0);
        if (z2) {
            C4638.m14099("RecordEveryFrame3", String.format("frameCount : %s , final cube : %s , m : %s , tex : %s ", Integer.valueOf(f1770), Arrays.toString(fArrM2090), Arrays.toString(fArr), Arrays.toString(fArrM2092)));
        }
        System.nanoTime();
        C3732.m11943("foo4");
        GLES20.glBindFramebuffer(36160, i);
        C4327 c43272 = this.f1773;
        m2048(c43272, i4, i5);
        if (z) {
            GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
            GLES20.glClear(16384);
        }
        GLES20.glViewport(i2, i3, i4, i5);
        GLES20.glScissor(i6, i7, i8, i9);
        GLES20.glEnable(3089);
        c43272.m13479(this.f1778.m8882(), this.f1775, this.f1776);
        GLES20.glDisable(3089);
        GLES20.glBindFramebuffer(36160, 0);
        C3732.m11943("after FrameRenderer");
        System.nanoTime();
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public void m2055(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, C4327 c4327, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        float f;
        float f2;
        float f3;
        float f4;
        if (z2) {
            int i18 = f1770 + 1;
            f1770 = i18;
            C4638.m14099("RecordEveryFrame1", String.format("frameCount : %s , clearOutput : %s , tgtfbo : %s , outX : %s , outY : %s ,outWidth : %s , outHeight : %s , scissorX : %s , scissorY : %s , scissorW : %s , scissOrH : %s , textureId : %s , texWidth : %s , texHeight : %s , captureWidth : %s , captureHeight : %s , filterWidth : %s , filterHeight : %s , cameraId : %s ", Integer.valueOf(i18), Boolean.valueOf(z), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8), Integer.valueOf(i9), Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13), Integer.valueOf(i14), Integer.valueOf(i15), Integer.valueOf(i16), Integer.valueOf(i17)));
        }
        C3732.m11943("before FrameRenderer");
        for (int i19 = 0; i19 < 4; i19++) {
            GLES20.glActiveTexture(33984 + i19);
            GLES20.glBindTexture(3553, 0);
            GLES20.glBindTexture(36197, 0);
        }
        c4327.getClass().equals(C2483.class);
        System.nanoTime();
        System.nanoTime();
        C3732.m11943("foo2");
        m2048(c4327, i4, i5);
        float[] fArr = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
        if (z4) {
            fArr = new float[]{1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f};
        }
        if (z5 && z4) {
            fArr = new float[]{1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f};
        } else if (z5) {
            fArr = new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f};
        }
        float f5 = 1.0f;
        if (C2813.f10261) {
            float f6 = (i11 * 1.0f) / i12;
            float f7 = (i15 * 1.0f) / i16;
            float f8 = i4;
            float f9 = i5;
            float f10 = (f8 * 1.0f) / f9;
            if (z5) {
                f10 = (f9 * 1.0f) / f8;
            }
            float f11 = f10 / (f7 / f6);
            if (f11 > f6) {
                f4 = f6 / f11;
                f2 = (1.0f - f4) / 2.0f;
                f3 = 0.0f;
            } else {
                float f12 = f11 / f6;
                f3 = (1.0f - f12) / 2.0f;
                f4 = 1.0f;
                f5 = f12;
                f2 = 0.0f;
            }
            f5 = f3 + f5;
            f = f2 + f4;
        } else {
            f = 1.0f;
            f2 = 0.0f;
            f3 = 0.0f;
        }
        float[] fArr2 = (z3 && z6) ? new float[]{f5, f, f3, f, f5, f2, f3, f2} : (z3 && z5) ? new float[]{f5, f2, f3, f2, f5, f, f3, f} : z3 ? new float[]{f3, f, f5, f, f3, f2, f5, f2} : new float[]{f3, f, f5, f, f3, f2, f5, f2};
        this.f1775.clear();
        this.f1775.put(fArr).position(0);
        this.f1776.clear();
        this.f1776.put(fArr2).position(0);
        GLES20.glBindFramebuffer(36160, i);
        GLES20.glViewport(i2, i3, i4, i5);
        GLES20.glScissor(i6, i7, i8, i9);
        GLES20.glEnable(3089);
        System.nanoTime();
        if (z2) {
            C4638.m14099("RecordEveryFrame2", String.format("frameCount : %s , cube : %s , tex : %s ", Integer.valueOf(f1770), Arrays.toString(fArr), Arrays.toString(fArr2)));
        }
        c4327.m13479(i10, this.f1775, this.f1776);
        GLES20.glDisable(3089);
        GLES20.glBindFramebuffer(36160, 0);
        C3732.m11943("foo3");
        System.nanoTime();
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public ArrayList<Bitmap> m2056(C3732 c3732, int i, int i2, C4327[] c4327Arr, int[] iArr) throws InterruptedException {
        int i3;
        int i4;
        EGLSurface eGLSurface;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        C4327 c4327;
        int i10;
        ArrayList<Bitmap> arrayList;
        int i11;
        C0851.C0852 c0852;
        FrameRenderer frameRenderer = this;
        C3732 c37322 = c3732;
        int i12 = i;
        int i13 = i2;
        C4327[] c4327Arr2 = c4327Arr;
        int[] iArr2 = iArr;
        float[] fArrM2057 = frameRenderer.m2057(true);
        C0851 c0851 = frameRenderer.f1771;
        int i14 = 0;
        int iAbs = (int) Math.abs((c0851.f1861 * fArrM2057[0]) + (c0851.f1862 * fArrM2057[4]));
        C0851 c08512 = frameRenderer.f1771;
        int iAbs2 = (int) Math.abs((c08512.f1861 * fArrM2057[1]) + (c08512.f1862 * fArrM2057[5]));
        C0851 c08513 = frameRenderer.f1771;
        if (c08513.f1861 != c08513.f1863) {
            iAbs = iAbs2;
            iAbs2 = iAbs;
        }
        float fM9979 = C2721.m9979(i13, i12, iAbs, iAbs2);
        int iCeil = (int) Math.ceil(iAbs / fM9979);
        int iCeil2 = (int) Math.ceil(iAbs2 / fM9979);
        EGLSurface eGLSurfaceM11950 = c37322.m11950(iCeil, iCeil2);
        c37322.m11957(eGLSurfaceM11950);
        GLES20.glBindFramebuffer(36160, 0);
        C3732.m11943("before getBitmaps");
        ArrayList<Bitmap> arrayList2 = new ArrayList<>();
        int length = c4327Arr2.length;
        int i15 = 0;
        while (i15 < length) {
            C4327 c43272 = c4327Arr2[i15];
            c43272.m13477();
            c43272.mo9491(iCeil, iCeil2);
            int length2 = iArr2.length;
            int i16 = i14;
            while (i16 < length2) {
                int i17 = iArr2[i16];
                C3732.m11943("before drawFrameAtIndex 8");
                C0851.C0854 c0854M2096 = frameRenderer.f1771.m2096(i17);
                if (c0854M2096 == null || (c0852 = c0854M2096.f1887) == null) {
                    i3 = i15;
                    i4 = length;
                    eGLSurface = eGLSurfaceM11950;
                    i5 = i13;
                    i6 = iCeil;
                    i7 = i12;
                    i8 = i16;
                    i9 = length2;
                    c4327 = c43272;
                    i10 = 0;
                    arrayList = arrayList2;
                    i11 = iCeil2;
                } else {
                    int i18 = c0852.f1879;
                    i8 = i16;
                    C0851 c08514 = frameRenderer.f1771;
                    i9 = length2;
                    c4327 = c43272;
                    i3 = i15;
                    i4 = length;
                    ArrayList<Bitmap> arrayList3 = arrayList2;
                    eGLSurface = eGLSurfaceM11950;
                    int i19 = iCeil2;
                    int i20 = iCeil;
                    i10 = 0;
                    m2053(true, 0, 0, 0, i20, i19, 0, 0, i20, i19, c4327, i18, c08514.f1859, c08514.f1860, c08514.f1861, c08514.f1862, c08514.f1863, c08514.f1864, fArrM2057, 0, false);
                    C3732.m11943("after drawFrameAtIndex");
                    i7 = i;
                    i5 = i2;
                    i11 = i19;
                    i6 = i20;
                    Bitmap bitmapM9975 = C2721.m9975(i5, i7, i6, i11);
                    Bitmap bitmapM9976 = C2721.m9976(bitmapM9975);
                    C2735.m9988(bitmapM9975);
                    arrayList = arrayList3;
                    arrayList.add(bitmapM9976);
                }
                i16 = i8 + 1;
                frameRenderer = this;
                i12 = i7;
                i13 = i5;
                iCeil = i6;
                iCeil2 = i11;
                arrayList2 = arrayList;
                length2 = i9;
                c43272 = c4327;
                i15 = i3;
                length = i4;
                eGLSurfaceM11950 = eGLSurface;
                i14 = i10;
                iArr2 = iArr;
            }
            frameRenderer = this;
            c37322 = c3732;
            arrayList2 = arrayList2;
            i15++;
            length = length;
            eGLSurfaceM11950 = eGLSurfaceM11950;
            c4327Arr2 = c4327Arr;
            iArr2 = iArr;
        }
        EGLSurface eGLSurface2 = eGLSurfaceM11950;
        ArrayList<Bitmap> arrayList4 = arrayList2;
        c37322.m11953(eGLSurface2);
        return arrayList4;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public float[] m2057(boolean z) {
        float[] fArr = new float[16];
        Matrix.setIdentityM(fArr, 0);
        Matrix.scaleM(fArr, 0, 1.0f, 1.0f, 1.0f);
        Matrix.rotateM(fArr, 0, z ? -90.0f : 0.0f, 0.0f, 0.0f, 1.0f);
        for (int i = 0; i < 16; i++) {
            fArr[i] = Math.round(fArr[i]);
        }
        return fArr;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m2058(int i, int i2) {
        this.f1783 = true;
        this.f1784 = i;
        this.f1785 = i2;
        C4327[] c4327Arr = this.f1779;
        if (c4327Arr != null) {
            for (C4327 c4327 : c4327Arr) {
                m2048(c4327, i, i2);
            }
        }
        C2390 c2390 = this.f1778;
        if (c2390 != null && (c2390.f8945 != i || c2390.f8946 != i2)) {
            c2390.m8880();
            this.f1778 = null;
        }
        if (this.f1778 == null) {
            this.f1778 = new C2390(i, i2, true);
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public void m2059(C0851 c0851) {
        this.f1771 = c0851;
        C2390 c2390 = this.f1777;
        if (c2390 != null) {
            c2390.m8880();
            this.f1777 = null;
        }
    }
}
