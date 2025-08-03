package defpackage;

import android.graphics.Bitmap;
import android.hardware.Camera;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.UnsupportedEncodingException;
import java.nio.IntBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import org.jcodec.platform.Platform;

/* compiled from: OpenGlUtils.java */
/* renamed from: ಱ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4650 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final char[] f15817 = "0123456789ABCDEF".toCharArray();

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static HashMap<String, Integer> f15818 = new HashMap<>();

    /* renamed from: ԩ, reason: contains not printable characters */
    public static HashMap<String, Integer> f15819 = new HashMap<>();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static HashMap<String, C4651> f15820 = new HashMap<>();

    /* renamed from: ԫ, reason: contains not printable characters */
    public static HashMap<Integer, C4651> f15821 = new HashMap<>();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static HashSet<EGLContext> f15822 = new HashSet<>();

    /* compiled from: OpenGlUtils.java */
    /* renamed from: ಱ$Ϳ, reason: contains not printable characters */
    public static final class C4651 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public boolean f15823;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m14120(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & ExifInterface.MARKER;
            int i3 = i * 2;
            char[] cArr2 = f15817;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m14121() {
        if (EGL14.eglGetCurrentContext() == null) {
            throw new RuntimeException("no egl context");
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m14122(String str) {
        boolean z = false;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            Log.e("OpenGlUtils", str + ": GL error: 0x" + Integer.toHexString(iGlGetError));
            z = true;
        }
        if (z) {
            throw new RuntimeException("GL error encountered (see log)");
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static void m14123(String str) {
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            }
            Log.e("OpenGlUtils", str + ": GL error: 0x" + Integer.toHexString(iGlGetError));
        }
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static long m14124(EGLContext eGLContext) {
        return eGLContext.getNativeHandle();
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static long m14125() {
        return m14124(EGL14.eglGetCurrentContext());
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static synchronized int m14126(String str, String str2) {
        EGL14.eglGetCurrentContext();
        GLES20.glGetString(7937).startsWith("Adreno");
        String strM14130 = m14130(str);
        String strM141302 = m14130(str2);
        StringBuilder sb = new StringBuilder();
        sb.append(strM14130);
        sb.append("_");
        sb.append(strM141302);
        int iM14127 = m14127(str, 35633);
        if (iM14127 == 0) {
            Log.e("Load Program", "Vertex Shader Failed");
            return 0;
        }
        int iM141272 = m14127(str2, 35632);
        if (iM141272 == 0) {
            Log.e("Load Program", "Fragment Shader Failed");
            return 0;
        }
        int[] iArr = new int[1];
        int iGlCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(iGlCreateProgram, iM14127);
        GLES20.glAttachShader(iGlCreateProgram, iM141272);
        GLES20.glLinkProgram(iGlCreateProgram);
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] > 0) {
            return iGlCreateProgram;
        }
        Log.e("Load Program", "Linking Failed" + GLES20.glGetProgramInfoLog(iGlCreateProgram));
        return 0;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static int m14127(String str, int i) {
        int[] iArr = new int[1];
        int iGlCreateShader = GLES20.glCreateShader(i);
        GLES20.glShaderSource(iGlCreateShader, str);
        GLES20.glCompileShader(iGlCreateShader);
        GLES20.glGetShaderiv(iGlCreateShader, 35713, iArr, 0);
        if (iArr[0] == 0) {
            return 0;
        }
        return iGlCreateShader;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public static int m14128(Bitmap bitmap, int i, boolean z) {
        int[] iArr = new int[1];
        if (i == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            C4462.m13724(iArr[0], "bitmap", bitmap.getWidth(), bitmap.getHeight(), 4);
        } else {
            GLES20.glBindTexture(3553, i);
            GLUtils.texSubImage2D(3553, 0, 0, 0, bitmap);
            iArr[0] = i;
        }
        if (z) {
            bitmap.recycle();
        }
        return iArr[0];
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static int m14129(IntBuffer intBuffer, Camera.Size size, int i) {
        int[] iArr = new int[1];
        if (i == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLES20.glTexImage2D(3553, 0, 6408, size.width, size.height, 0, 6408, 5121, intBuffer);
            C4462.m13724(iArr[0], "intbuffer", size.width, size.height, 4);
        } else {
            GLES20.glBindTexture(3553, i);
            GLES20.glTexSubImage2D(3553, 0, 0, 0, size.width, size.height, 6408, 5121, intBuffer);
            iArr[0] = i;
        }
        return iArr[0];
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static String m14130(String str) {
        try {
            return m14131(str.getBytes(Platform.UTF_8));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static String m14131(byte[] bArr) {
        try {
            return m14120(MessageDigest.getInstance("md5").digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public static synchronized void m14132(int i) {
        EGL14.eglGetCurrentContext();
        C4651 c4651 = f15821.get(Integer.valueOf(i));
        if (c4651 == null) {
            return;
        }
        c4651.f15823 = false;
    }
}
