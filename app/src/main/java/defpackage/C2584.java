package defpackage;

import android.graphics.Bitmap;
import android.opengl.EGL14;
import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: ɡ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C2584 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f9619 = C4625.m14082("AR8IARceOgAIBxY=");

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final char[] f9620 = C4625.m14082("fl5fXGRHWUNZUiRwcHd2CA==").toCharArray();

    /* renamed from: ԩ, reason: contains not printable characters */
    public static HashMap<String, Integer> f9621 = new HashMap<>();

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static HashMap<String, Integer> f9622 = new HashMap<>();

    /* renamed from: ԫ, reason: contains not printable characters */
    public static HashMap<String, C2585> f9623 = new HashMap<>();

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static HashMap<Integer, C2585> f9624 = new HashMap<>();

    /* renamed from: ԭ, reason: contains not printable characters */
    public static HashSet<EGLContext> f9625 = new HashSet<>();

    /* renamed from: ɡ$Ϳ, reason: contains not printable characters */
    public static final class C2585 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public C2585 f9626;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public int f9627;

        /* renamed from: ԩ, reason: contains not printable characters */
        public boolean f9628;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static String m9459(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & ExifInterface.MARKER;
            int i3 = i * 2;
            char[] cArr2 = f9620;
            cArr[i3] = cArr2[i2 >>> 4];
            cArr[i3 + 1] = cArr2[i2 & 15];
        }
        return new String(cArr);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m9460() {
        if (EGL14.eglGetCurrentContext() == null) {
            throw new RuntimeException(C4625.m14082("IABNCjceTxcOBRFXS0c="));
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static void m9461(String str) {
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                return;
            }
            Log.e(f9619, str + C4625.m14082("dE8qI3AXHQYOGV8SA0s=") + Integer.toHexString(iGlGetError));
        }
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static long m9462(EGLContext eGLContext) {
        return eGLContext.getNativeHandle();
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static long m9463() {
        return m9462(EGL14.eglGetCurrentContext());
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static synchronized int m9464(String str, String str2) {
        int iM9465;
        int iM94652;
        EGL14.eglGetCurrentContext();
        boolean zStartsWith = GLES20.glGetString(7937).startsWith(C4625.m14082("DwsfCj4d"));
        boolean z = !zStartsWith;
        boolean z2 = !zStartsWith;
        String strM9467 = m9467(str);
        String strM94672 = m9467(str2);
        String str3 = strM9467 + C4625.m14082("EQ==") + strM94672;
        if (z2 && f9623.containsKey(str3)) {
            for (C2585 c2585 = f9623.get(str3); c2585 != null; c2585 = c2585.f9626) {
                if (!c2585.f9628) {
                    c2585.f9628 = true;
                    return c2585.f9627;
                }
            }
        }
        if (z && f9621.containsKey(strM9467)) {
            iM9465 = f9621.get(strM9467).intValue();
        } else {
            iM9465 = m9465(str, 35633);
            if (iM9465 == 0) {
                Log.e(C4625.m14082("AgAMC3AiHRsGGQRf"), C4625.m14082("GAofGzUKTycJCgFXQRN1LwYBCjQ="));
                return 0;
            }
            if (z) {
                f9621.put(strM9467, Integer.valueOf(iM9465));
            }
        }
        if (z && f9622.containsKey(strM94672)) {
            iM94652 = f9622.get(strM94672).intValue();
        } else {
            iM94652 = m9465(str2, 35632);
            if (iM94652 == 0) {
                Log.e(C4625.m14082("AgAMC3AiHRsGGQRf"), C4625.m14082("CB0MCD0XAQBBOA1TV1ZBbikMBjwXCw=="));
                return 0;
            }
            if (z) {
                f9622.put(strM94672, Integer.valueOf(iM94652));
            }
        }
        int[] iArr = new int[1];
        int iGlCreateProgram = GLES20.glCreateProgram();
        GLES20.glAttachShader(iGlCreateProgram, iM9465);
        GLES20.glAttachShader(iGlCreateProgram, iM94652);
        GLES20.glLinkProgram(iGlCreateProgram);
        GLES20.glGetProgramiv(iGlCreateProgram, 35714, iArr, 0);
        if (iArr[0] <= 0) {
            Log.e(C4625.m14082("AgAMC3AiHRsGGQRf"), C4625.m14082("AgYDBDkcCFQnCgxeVlc=") + GLES20.glGetProgramInfoLog(iGlCreateProgram));
            return 0;
        }
        if (z2) {
            C2585 c25852 = new C2585();
            c25852.f9627 = iGlCreateProgram;
            c25852.f9628 = true;
            c25852.f9626 = f9623.get(str3);
            f9623.put(str3, c25852);
            f9624.put(Integer.valueOf(iGlCreateProgram), c25852);
        }
        return iGlCreateProgram;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public static int m9465(String str, int i) {
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

    /* renamed from: Ԯ, reason: contains not printable characters */
    public static int m9466(Bitmap bitmap, int i, boolean z) {
        int[] iArr = new int[1];
        if (i == -1) {
            GLES20.glGenTextures(1, iArr, 0);
            GLES20.glBindTexture(3553, iArr[0]);
            GLES20.glTexParameterf(3553, 10240, 9729.0f);
            GLES20.glTexParameterf(3553, 10241, 9729.0f);
            GLES20.glTexParameterf(3553, 10242, 33071.0f);
            GLES20.glTexParameterf(3553, 10243, 33071.0f);
            GLUtils.texImage2D(3553, 0, bitmap, 0);
            C4679.m14183(iArr[0], C4625.m14082("LAYZAjEC"), bitmap.getWidth(), bitmap.getHeight(), 4);
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

    /* renamed from: ԯ, reason: contains not printable characters */
    public static String m9467(String str) {
        try {
            return m9468(str.getBytes(C4625.m14082("GzsrQmg=")));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public static String m9468(byte[] bArr) {
        try {
            return m9459(MessageDigest.getInstance(C4625.m14082("IwtY")).digest(bArr));
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public static void m9469(int i) {
        GLES20.glDeleteTextures(1, new int[]{i}, 0);
        C4679.m14182(i);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public static synchronized void m9470(int i) {
        EGL14.eglGetCurrentContext();
        C2585 c2585 = f9624.get(Integer.valueOf(i));
        if (c2585 == null) {
            return;
        }
        c2585.f9628 = false;
    }
}
