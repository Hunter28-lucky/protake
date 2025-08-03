package com.blink.academy.gpuimage;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class TexDecrypt {
    static {
        System.loadLibrary("nomogpuimage");
    }

    public static native int TexDecrypt_createTexture(ByteBuffer byteBuffer);

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static int m4831(ByteBuffer byteBuffer) {
        return TexDecrypt_createTexture(byteBuffer);
    }
}
