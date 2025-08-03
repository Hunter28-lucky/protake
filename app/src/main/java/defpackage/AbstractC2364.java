package defpackage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* compiled from: GlUtil.java */
/* renamed from: ņ, reason: contains not printable characters */
/* loaded from: classes.dex */
public abstract class AbstractC2364 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f8907 = "ņ";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final float[] f8908;

    static {
        float[] fArr = new float[16];
        f8908 = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m8831(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError != 0) {
            Log.e(f8907, str + ": glError 0x" + Integer.toHexString(iGlGetError));
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m8832(int i, String str) {
        if (i < 0) {
            Log.e(f8907, "Unable to locate '" + str + "' in program");
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static FloatBuffer m8833(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static float[] m8834(float[] fArr, boolean z, boolean z2) {
        if (z || z2) {
            Matrix.scaleM(fArr, 0, z ? -1.0f : 1.0f, z2 ? -1.0f : 1.0f, 1.0f);
        }
        return fArr;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static float[] m8835(float[] fArr, float f) {
        Matrix.rotateM(fArr, 0, f, 0.0f, 0.0f, 1.0f);
        return fArr;
    }
}
