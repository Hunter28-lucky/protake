package defpackage;

import android.opengl.GLES20;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: FilmLutCreator4096.java */
/* renamed from: ခ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C5083 {

    /* renamed from: ՠ, reason: contains not printable characters */
    public static float[] f16883 = {63.0f, 0.0f, 0.015625f, 2.4414062E-4f};

    /* renamed from: ֈ, reason: contains not printable characters */
    public static int f16884 = 0;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public boolean f16885 = false;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public int f16886 = -1;

    /* renamed from: ԩ, reason: contains not printable characters */
    public final FloatBuffer f16887 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final FloatBuffer f16888 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* renamed from: ԫ, reason: contains not printable characters */
    public C4327 f16889 = null;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public List<C4327> f16890 = new ArrayList();

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f16891 = 64;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f16892 = 4096;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f16893 = 64;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m14911() {
        m14913();
        C4327 c4327 = this.f16889;
        if (c4327 != null) {
            c4327.m13471();
            this.f16889.mo10877();
            this.f16889 = null;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public synchronized void m14912() throws Throwable {
        C5083 c5083 = this;
        synchronized (this) {
            try {
                if (!c5083.f16885) {
                    c5083.f16885 = true;
                    int[] iArr = new int[1];
                    int i = 0;
                    GLES20.glGenTextures(1, iArr, 0);
                    GLES20.glBindTexture(3553, iArr[0]);
                    GLES20.glTexParameterf(3553, 10240, 9729.0f);
                    GLES20.glTexParameterf(3553, 10241, 9729.0f);
                    GLES20.glTexParameterf(3553, 10242, 33071.0f);
                    GLES20.glTexParameterf(3553, 10243, 33071.0f);
                    c5083.f16886 = iArr[0];
                    byte[] bArr = new byte[c5083.f16892 * c5083.f16893 * 4];
                    int i2 = 0;
                    while (i2 < c5083.f16891) {
                        int i3 = i;
                        while (i3 < c5083.f16891) {
                            try {
                                int i4 = i;
                                while (true) {
                                    int i5 = c5083.f16891;
                                    if (i4 < i5) {
                                        int i6 = (i3 * i5 * i5 * 4) + (i5 * i4 * 4) + (i2 * 4);
                                        bArr[i6 + 0] = (byte) ((i2 / (i5 - 1.0d)) * 255.0d);
                                        bArr[i6 + 1] = (byte) ((i3 / (i5 - 1.0d)) * 255.0d);
                                        bArr[i6 + 2] = (byte) ((i4 / (i5 - 1.0d)) * 255.0d);
                                        bArr[i6 + 3] = -1;
                                        i4++;
                                        c5083 = this;
                                    }
                                }
                                i3++;
                                i = 0;
                                c5083 = this;
                            } catch (Throwable th) {
                                th = th;
                                throw th;
                            }
                        }
                        i2++;
                        i = 0;
                        c5083 = this;
                    }
                    ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(c5083.f16892 * c5083.f16893 * 4);
                    byteBufferAllocateDirect.put(bArr);
                    byteBufferAllocateDirect.position(0);
                    GLES20.glTexImage2D(3553, 0, 6408, c5083.f16892, c5083.f16893, 0, 6408, 5121, byteBufferAllocateDirect);
                    C4462.m13724(c5083.f16886, "LUTCreator", c5083.f16892, c5083.f16893, 4);
                    c5083.f16887.clear();
                    c5083.f16887.put(new float[]{-1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f}).position(0);
                    c5083.f16888.clear();
                    c5083.f16888.put(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f}).position(0);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public synchronized void m14913() {
        int i = this.f16886;
        if (i != -1) {
            GLES20.glDeleteTextures(1, new int[]{i}, 0);
            C4462.m13723(this.f16886);
            this.f16886 = -1;
        }
        this.f16885 = false;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public void m14914(C4327 c4327, C2390 c2390) {
        long jNanoTime = System.nanoTime();
        if (!C4092.m13040(this.f16889, c4327)) {
            C4327 c43272 = this.f16889;
            if (c43272 != null) {
                c43272.m13471();
                this.f16889.mo10877();
            }
            this.f16889 = c4327;
            c4327.m13477();
            this.f16889.mo9491(this.f16892, this.f16893);
        }
        this.f16889.m13477();
        this.f16889.mo9491(this.f16892, this.f16893);
        long jNanoTime2 = System.nanoTime();
        c2390.m8878();
        GLES20.glViewport(0, 0, this.f16892, this.f16893);
        GLES20.glClearColor(1.0f, 0.0f, 1.0f, 1.0f);
        GLES20.glClear(16384);
        GLES20.glDisable(3089);
        this.f16889.m13479(this.f16886, this.f16887, this.f16888);
        long jNanoTime3 = System.nanoTime();
        GLES20.glBindFramebuffer(36160, 0);
        long jNanoTime4 = System.nanoTime();
        Log.d("FilmLutCreator", String.format("init:%dms", Long.valueOf((jNanoTime2 - jNanoTime) / 1000000)));
        Log.d("FilmLutCreator", String.format("draw:%dms", Long.valueOf((jNanoTime3 - jNanoTime2) / 1000000)));
        Log.d("FilmLutCreator", String.format("bind:%dms", Long.valueOf((jNanoTime4 - jNanoTime3) / 1000000)));
    }
}
