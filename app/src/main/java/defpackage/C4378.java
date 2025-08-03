package defpackage;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.util.Log;
import android.view.Surface;

/* compiled from: OESTexture.java */
/* renamed from: ૡ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4378 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public Surface f15059;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public SurfaceTexture f15060;

    /* renamed from: ԩ, reason: contains not printable characters */
    public int f15061 = m13547();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int f15062;

    /* renamed from: ԫ, reason: contains not printable characters */
    public final int f15063;

    public C4378(int i, int i2, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(this.f15061);
        this.f15060 = surfaceTexture;
        surfaceTexture.setOnFrameAvailableListener(onFrameAvailableListener);
        this.f15060.setDefaultBufferSize(i, i2);
        this.f15062 = i;
        this.f15063 = i2;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m13547() {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        C3732.m11942("before createOESTexture");
        GLES20.glBindTexture(36197, iArr[0]);
        GLES20.glTexParameteri(36197, 10242, 33071);
        GLES20.glTexParameteri(36197, 10243, 33071);
        GLES20.glTexParameteri(36197, 10241, 9729);
        GLES20.glTexParameteri(36197, 10240, 9729);
        C3732.m11942("createOESTexture");
        Log.d("OESTexture", String.format("created oes texture:%d", Integer.valueOf(iArr[0])));
        return iArr[0];
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m13548(int i) {
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, 0);
        C3732.m11943("delete oes");
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        Log.d("OESTexture", String.format("deleted oes texture:%d", Integer.valueOf(i)));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public void m13549() {
        Surface surface = this.f15059;
        if (surface != null) {
            surface.release();
            this.f15059 = null;
        }
        this.f15060.setOnFrameAvailableListener(null);
        this.f15060.release();
        this.f15060 = null;
        m13548(this.f15061);
        this.f15061 = -1;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public synchronized Surface m13550() {
        if (this.f15059 == null) {
            this.f15059 = new Surface(this.f15060);
        }
        return this.f15059;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public SurfaceTexture m13551() {
        return this.f15060;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m13552() {
        return this.f15061;
    }
}
