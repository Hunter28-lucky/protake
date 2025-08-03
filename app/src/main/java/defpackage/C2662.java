package defpackage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import com.blink.academy.film.support.stream.ts.google.API.MyUTIL;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: GlUtil.java */
/* renamed from: ʋ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2662 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final float[] f9920;

    static {
        float[] fArr = new float[16];
        f9920 = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m9801(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        String str2 = str + ": glError 0x" + Integer.toHexString(iGlGetError);
        Log.e("Grafika", str2);
        throw new RuntimeException(str2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static int m9802(String str, String str2) {
        int iM9803;
        int iM98032 = m9803(35633, str);
        if (iM98032 == 0 || (iM9803 = m9803(35632, str2)) == 0) {
            return 0;
        }
        int iGlCreateProgram = GLES20.glCreateProgram();
        m9801("glCreateProgram");
        if (iGlCreateProgram == 0) {
            Log.e("Grafika", "Could not create program");
        }
        GLES20.glAttachShader(iGlCreateProgram, iM98032);
        m9801("glAttachShader");
        GLES20.glAttachShader(iGlCreateProgram, iM9803);
        m9801("glAttachShader");
        GLES20.glLinkProgram(iGlCreateProgram);
        int[] iArr = new int[1];
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] == 1) {
            return iGlCreateProgram;
        }
        Log.e("Grafika", "Could not link program: ");
        Log.e("Grafika", GLES20.glGetProgramInfoLog(iGlCreateProgram));
        GLES20.glDeleteProgram(iGlCreateProgram);
        return 0;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static int m9803(int i, String str) {
        int iGlCreateShader = GLES20.glCreateShader(i);
        m9801("glCreateShader type=" + i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        int[] iArr = new int[1];
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] != 0) {
            return iGlCreateShader;
        }
        Log.e("Grafika", "Could not compile shader " + i + Constants.COLON_SEPARATOR);
        StringBuilder sb = new StringBuilder();
        sb.append(MyUTIL.white_space);
        sb.append(GLES20.glGetShaderInfoLog(iGlCreateShader));
        Log.e("Grafika", sb.toString());
        GLES20.glDeleteShader(iGlCreateShader);
        return 0;
    }
}
