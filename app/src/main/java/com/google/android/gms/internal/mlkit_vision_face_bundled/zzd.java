package com.google.android.gms.internal.mlkit_vision_face_bundled;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

/* compiled from: com.google.mlkit:face-detection@@16.1.5 */
/* loaded from: classes2.dex */
public final class zzd {
    public static ByteBuffer zza(Bitmap bitmap, boolean z) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        int iCeil = (int) Math.ceil(height / 2.0d);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(((iCeil + iCeil) * ((int) Math.ceil(width / 2.0d))) + i);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < height; i4++) {
            int i5 = 0;
            while (i5 < width) {
                int i6 = iArr[i2];
                int i7 = (i6 >> 16) & 255;
                int i8 = (i6 >> 8) & 255;
                int i9 = i6 & 255;
                int i10 = (((((i7 * (-38)) - (i8 * 74)) + (i9 * 112)) + 128) >> 8) + 128;
                int i11 = (((((i7 * 112) - (i8 * 94)) - (i9 * 18)) + 128) >> 8) + 128;
                int i12 = i3 + 1;
                byteBufferAllocateDirect.put(i3, (byte) Math.min(255, (((((i7 * 66) + (i8 * 129)) + (i9 * 25)) + 128) >> 8) + 16));
                if (i4 % 2 == 0 && i2 % 2 == 0) {
                    int i13 = i + 1;
                    byteBufferAllocateDirect.put(i, (byte) Math.min(255, i11));
                    i = i13 + 1;
                    byteBufferAllocateDirect.put(i13, (byte) Math.min(255, i10));
                }
                i2++;
                i5++;
                i3 = i12;
            }
        }
        return byteBufferAllocateDirect;
    }
}
