package com.blink.academy.film.videotools;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.blink.academy.film.videotools.FrameRenderer;
import defpackage.C3732;
import defpackage.C4462;
import defpackage.C4638;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: OutputSurfaceArray.java */
/* renamed from: com.blink.academy.film.videotools.Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C0851 {

    /* renamed from: ނ, reason: contains not printable characters */
    public static int f1853 = 1048576;

    /* renamed from: ރ, reason: contains not printable characters */
    public static int f1854;

    /* renamed from: ބ, reason: contains not printable characters */
    public static int f1855;

    /* renamed from: ޅ, reason: contains not printable characters */
    public static int f1856;

    /* renamed from: ކ, reason: contains not printable characters */
    public static C0853 f1857;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public int f1858;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f1859;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f1860;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int f1861;

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f1862;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f1863;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f1864;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f1865;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float[] f1866;

    /* renamed from: ֏, reason: contains not printable characters */
    public FloatBuffer f1869;

    /* renamed from: ׯ, reason: contains not printable characters */
    public FloatBuffer f1870;

    /* renamed from: ށ, reason: contains not printable characters */
    public C0853 f1873;

    /* renamed from: ՠ, reason: contains not printable characters */
    public boolean f1867 = false;

    /* renamed from: ֈ, reason: contains not printable characters */
    public long f1868 = 0;

    /* renamed from: ؠ, reason: contains not printable characters */
    public ArrayList<C0854> f1871 = new ArrayList<>();

    /* renamed from: ހ, reason: contains not printable characters */
    public ArrayList<C0854> f1872 = new ArrayList<>();

    /* compiled from: OutputSurfaceArray.java */
    /* renamed from: com.blink.academy.film.videotools.Ϳ$Ԩ, reason: contains not printable characters */
    public static final class C0853 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final int f1881;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public final int f1882;

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f1883;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public ArrayList<C0852> f1884 = new ArrayList<>();

        /* renamed from: ԫ, reason: contains not printable characters */
        public ArrayList<C0852> f1885 = new ArrayList<>();

        public C0853(int i, int i2, int i3) {
            this.f1883 = i;
            this.f1881 = i2;
            this.f1882 = i3;
            for (int i4 = 0; i4 < i; i4++) {
                C0852 c0852 = new C0852(i2, i3);
                this.f1884.add(c0852);
                this.f1885.add(c0852);
            }
        }

        /* renamed from: Ԩ, reason: contains not printable characters */
        public boolean m2101() {
            return this.f1884.size() == this.f1883;
        }

        /* renamed from: ԩ, reason: contains not printable characters */
        public C0852 m2102() {
            if (this.f1884.size() != 0) {
                return this.f1884.remove(0);
            }
            throw new RuntimeException("out of buffers");
        }

        /* renamed from: Ԫ, reason: contains not printable characters */
        public boolean m2103(C0852 c0852) {
            return this.f1885.contains(c0852);
        }

        /* renamed from: ԫ, reason: contains not printable characters */
        public void m2104(C0852 c0852) {
            if (!this.f1885.contains(c0852)) {
                if (c0852 != C0852.f1875) {
                    throw new RuntimeException("freeing unowned buffer!");
                }
                throw new RuntimeException("freeing sentinel buffer!");
            }
            if (this.f1884.contains(c0852)) {
                return;
            }
            this.f1884.add(c0852);
        }

        /* renamed from: Ԭ, reason: contains not printable characters */
        public int m2105() {
            return this.f1884.size();
        }

        /* renamed from: ԭ, reason: contains not printable characters */
        public void m2106() {
            C3732.m11941();
            if (!m2101()) {
                Log.e("OutputSurfaceArray", "not all buffers safely released!");
            }
            if (this == C0851.f1857) {
                this.f1884.clear();
                this.f1884.addAll(this.f1885);
                return;
            }
            for (int i = 0; i < this.f1885.size(); i++) {
                this.f1885.get(i).m2099();
            }
            this.f1884.clear();
            this.f1885.clear();
            this.f1883 = 0;
        }
    }

    /* compiled from: OutputSurfaceArray.java */
    /* renamed from: com.blink.academy.film.videotools.Ϳ$Ԫ, reason: contains not printable characters */
    public static final class C0854 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public long f1886;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public C0852 f1887;

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f1888;

        public C0854() {
        }

        public C0854(C0852 c0852, long j, int i) {
            this.f1886 = j;
            this.f1887 = c0852;
            this.f1888 = i;
        }
    }

    public C0851() {
        f1856 = 0;
        this.f1869 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f1870 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();
        float[] fArr = new float[16];
        this.f1866 = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static /* synthetic */ int m2082(int i) {
        int i2 = f1854 + i;
        f1854 = i2;
        return i2;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static /* synthetic */ int m2083(int i) {
        int i2 = f1854 - i;
        f1854 = i2;
        return i2;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static /* synthetic */ int m2085(int i) {
        int i2 = f1855 + i;
        f1855 = i2;
        return i2;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static /* synthetic */ int m2086(int i) {
        int i2 = f1855 - i;
        f1855 = i2;
        return i2;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static void m2088(String str) {
        C3732.m11942(str);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static int m2089(int i, int i2) {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i3 = iArr[0];
        C4638.m14101("OutputSurfaceArray", "createTexture:" + i3);
        C3732.m11942("before glBindTexture mTextureID");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i3);
        C3732.m11942("glBindTexture mTextureID" + i3);
        GLES20.glTexParameterf(3553, 10241, 9729.0f);
        GLES20.glTexParameterf(3553, 10240, 9729.0f);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        m2088("glTexParameter");
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        C3732.m11942("glTexImage2D");
        return i3;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public static float[] m2090(FrameRenderer.RenderMode renderMode, float[] fArr, float f, float f2, float f3, float f4, float f5, float f6) {
        float[] fArr2 = new float[16];
        Matrix.invertM(fArr2, 0, fArr, 0);
        float fAbs = Math.abs((fArr2[0] * f3) + (fArr2[4] * f4));
        float fAbs2 = Math.abs((f3 * fArr2[1]) + (f4 * fArr2[5]));
        float f7 = fAbs / f5;
        float f8 = fAbs2 / f6;
        float f9 = 1.0f;
        float fMin = renderMode == FrameRenderer.RenderMode.RENDER_CROP ? Math.min(f7, f8) : renderMode == FrameRenderer.RenderMode.RENDER_FILL ? Math.max(f7, f8) : 1.0f;
        float fRound = fAbs / Math.round(f5 * fMin);
        float fRound2 = fAbs2 / Math.round(f6 * fMin);
        if (renderMode == FrameRenderer.RenderMode.RENDER_STRETCH) {
            fRound = 1.0f;
        } else {
            f9 = fRound2;
        }
        float f10 = (-f9) + f;
        float f11 = fRound + f2;
        float f12 = f9 + f;
        float f13 = (-fRound) + f2;
        float[] fArr3 = {f10, f11, f12, f11, f10, f13, f12, f13};
        m2091(fArr3, fArr);
        return fArr3;
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public static void m2091(float[] fArr, float[] fArr2) {
        float[] fArr3 = new float[4];
        for (int i = 0; i < 8; i += 2) {
            int i2 = i + 0;
            fArr3[0] = fArr[i2];
            int i3 = i + 1;
            fArr3[1] = fArr[i3];
            fArr3[2] = 0.0f;
            fArr3[3] = 1.0f;
            Matrix.multiplyMV(fArr3, 0, fArr2, 0, fArr3, 0);
            fArr[i2] = fArr3[0];
            fArr[i3] = fArr3[1];
        }
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public static float[] m2092(double d, double d2, double d3, double d4, boolean z) {
        float f = ((float) d) / ((float) d3);
        float f2 = ((float) d2) / ((float) d4);
        return z ? new float[]{0.0f, f2, f, f2, 0.0f, 0.0f, f, 0.0f} : new float[]{0.0f, 0.0f, f, 0.0f, 0.0f, f2, f, f2};
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public synchronized void m2093(int i, int i2, int i3) {
        this.f1858 = i;
        this.f1859 = i2;
        this.f1860 = i3;
        this.f1861 = i2;
        this.f1862 = i3;
        this.f1863 = i2;
        this.f1864 = i3;
        C0853 c0853 = this.f1873;
        if (c0853 != null && i == c0853.f1883) {
            C0853 c08532 = this.f1873;
            if (i2 != c08532.f1881 || i3 != c08532.f1882) {
            }
        }
        C0853 c08533 = this.f1873;
        if (c08533 != null) {
            c08533.m2106();
        }
        this.f1873 = new C0853(i, i2, i3);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public C0854 m2094(long j, long j2, int i) {
        C0852 c0852M2102 = this.f1873.m2102();
        c0852M2102.f1880 = j;
        C0854 c0854 = new C0854(c0852M2102, j2, i);
        m2088("before copyTexImage2D");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, c0852M2102.f1879);
        GLES20.glCopyTexImage2D(3553, 0, 6407, 0, 0, this.f1861, this.f1862, 0);
        GLES20.glFinish();
        m2088("copyTexImage2D");
        return c0854;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public synchronized C0854 m2095(long j) {
        C0854 c0854M2094;
        if (this.f1871.size() == 0) {
            this.f1868 = j;
        }
        c0854M2094 = m2094(j, j - this.f1868, this.f1871.size());
        this.f1871.add(c0854M2094);
        this.f1872.add(c0854M2094);
        return c0854M2094;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public synchronized C0854 m2096(int i) {
        try {
        } catch (RuntimeException e2) {
            e2.printStackTrace();
            return null;
        }
        return this.f1871.get(i);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public synchronized void m2097() {
        Iterator<C0854> it = this.f1872.iterator();
        while (it.hasNext()) {
            C0854 next = it.next();
            if (next != null) {
                this.f1873.m2104(next.f1887);
            }
        }
        this.f1871.clear();
        this.f1872.clear();
        C0853 c0853 = this.f1873;
        if (c0853 != null && !c0853.m2101()) {
            throw new RuntimeException("not all buffers have been released!");
        }
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public synchronized void m2098() {
        C0853 c0853 = this.f1873;
        if (c0853 != null) {
            c0853.m2106();
        }
        this.f1858 = 0;
    }

    /* compiled from: OutputSurfaceArray.java */
    /* renamed from: com.blink.academy.film.videotools.Ϳ$Ϳ, reason: contains not printable characters */
    public static final class C0852 {

        /* renamed from: Ԭ, reason: contains not printable characters */
        public static int f1874;

        /* renamed from: ԭ, reason: contains not printable characters */
        public static C0852 f1875 = new C0852();

        /* renamed from: Ϳ, reason: contains not printable characters */
        public int f1876;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f1877;

        /* renamed from: ԩ, reason: contains not printable characters */
        public int f1878;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public int f1879;

        /* renamed from: ԫ, reason: contains not printable characters */
        public long f1880;

        public C0852() {
            int i = f1874;
            f1874 = i + 1;
            this.f1876 = i;
            this.f1877 = 0;
            this.f1878 = 0;
            this.f1879 = 0;
            this.f1880 = 0L;
        }

        /* renamed from: Ϳ, reason: contains not printable characters */
        public void m2099() {
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(3553, 0);
            GLES20.glDeleteTextures(1, new int[]{this.f1879}, 0);
            try {
                C4462.m13723(this.f1879);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            C0851.m2083(1);
            C0851.m2086(this.f1877 * this.f1878 * 3);
            Log.d("OutputSurfaceArray", String.format("Freed a buffer, texture:%d total:%d size:%d\n", Integer.valueOf(this.f1879), Integer.valueOf(C0851.f1854), Integer.valueOf(C0851.f1855 / C0851.f1853)));
            this.f1879 = 0;
        }

        public C0852(int i, int i2) {
            this(i, i2, C0851.m2089(i, i2));
            C0851.m2082(1);
            C0851.m2085(this.f1877 * this.f1878 * 3);
            Log.d("OutputSurfaceArray", String.format("Allocated a buffer, texture:%d, total:%d size:%d\n", Integer.valueOf(this.f1879), Integer.valueOf(C0851.f1854), Integer.valueOf(C0851.f1855 / C0851.f1853)));
            C4462.m13724(this.f1879, "surfacearray", this.f1877, this.f1878, 3);
        }

        public C0852(int i, int i2, int i3) {
            int i4 = f1874;
            f1874 = i4 + 1;
            this.f1876 = i4;
            this.f1877 = i;
            this.f1878 = i2;
            this.f1879 = i3;
        }
    }
}
