package jp.co.cyberagent.android.gpuimage;

/* loaded from: classes2.dex */
public class GPUImageNativeLibrary {
    static {
        System.loadLibrary("gpuimage-library");
    }

    public static native void YUVtoRBGA(byte[] bArr, int i, int i2, int[] iArr);
}
