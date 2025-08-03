package defpackage;

import android.opengl.GLES20;
import android.opengl.Matrix;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* renamed from: ۅ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3624 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static final String f12577 = C4625.m14082("CR0MCTkZDg==");

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static final float[] f12578;

    static {
        float[] fArr = new float[16];
        f12578 = fArr;
        Matrix.setIdentityM(fArr, 0);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static void m11696(String str) {
        int iGlGetError = GLES20.glGetError();
        if (iGlGetError == 0) {
            return;
        }
        String str2 = str + C4625.m14082("dE8KAxUAHRsTS1VK") + Integer.toHexString(iGlGetError);
        Log.e(f12577, str2);
        throw new RuntimeException(str2);
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static void m11697(int i, String str) {
        if (i >= 0) {
            return;
        }
        Log.e(f12577, C4625.m14082("GwEMDTwXTwAOSwldUFJHK09K") + str + C4625.m14082("aU8EAXACHRsGGQRf"));
        throw new RuntimeException(C4625.m14082("GwEMDTwXTwAOSwldUFJHK09K") + str + C4625.m14082("aU8EAXACHRsGGQRf"));
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static FloatBuffer m11698(float[] fArr) {
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        byteBufferAllocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer floatBufferAsFloatBuffer = byteBufferAllocateDirect.asFloatBuffer();
        floatBufferAsFloatBuffer.put(fArr);
        floatBufferAsFloatBuffer.position(0);
        return floatBufferAsFloatBuffer;
    }
}
