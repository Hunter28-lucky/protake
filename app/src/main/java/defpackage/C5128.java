package defpackage;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: PictureDecoder2.java */
/* renamed from: ဠ, reason: contains not printable characters */
/* loaded from: classes.dex */
public final class C5128 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public C4327 f17040;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public FloatBuffer f17041 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();

    /* renamed from: ԩ, reason: contains not printable characters */
    public FloatBuffer f17042 = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder()).asFloatBuffer();

    public C5128() {
        C4327 c4327 = new C4327();
        this.f17040 = c4327;
        c4327.m13477();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m15046(Bitmap bitmap, int i, int i2) {
        int iM14128 = C4650.m14128(bitmap, -1, true);
        this.f17040.mo9491(i, i2);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, iM14128);
        GLES20.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glClear(16384);
        this.f17041.clear();
        this.f17041.put(new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}).position(0);
        this.f17042.clear();
        this.f17042.put(new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f}).position(0);
        this.f17040.m13479(iM14128, this.f17041, this.f17042);
        C3732.m11943("blit");
        C4462.m13723(iM14128);
        GLES20.glDeleteTextures(1, new int[]{iM14128}, 0);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m15047() {
        this.f17040.m13471();
    }
}
