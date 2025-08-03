package org.jcodec.codecs.raw;

import androidx.core.view.PointerIconCompat;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.jcodec.common.model.Picture;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class V210Encoder {
    public static final int clip(byte b) {
        return MathUtil.clip((b + BER.ASN_LONG_LEN) << 2, 8, PointerIconCompat.TYPE_ZOOM_OUT);
    }

    public ByteBuffer encodeFrame(ByteBuffer byteBuffer, Picture picture) throws IOException {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
        int planeWidth = ((picture.getPlaneWidth(0) + 47) / 48) * 48;
        byte[][] data = picture.getData();
        byte[] bArr = new byte[planeWidth];
        int i = planeWidth >> 1;
        byte[] bArr2 = new byte[i];
        byte[] bArr3 = new byte[i];
        int planeWidth2 = 0;
        int planeWidth3 = 0;
        int planeWidth4 = 0;
        for (int i2 = 0; i2 < picture.getHeight(); i2++) {
            System.arraycopy(data[0], planeWidth2, bArr, 0, picture.getPlaneWidth(0));
            System.arraycopy(data[1], planeWidth3, bArr2, 0, picture.getPlaneWidth(1));
            System.arraycopy(data[2], planeWidth4, bArr3, 0, picture.getPlaneWidth(2));
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            while (i3 < planeWidth) {
                int i6 = i4 + 1;
                int i7 = i3 + 1;
                int iClip = (clip(bArr[i3]) << 10) | (clip(bArr3[i4]) << 20) | 0;
                int i8 = i5 + 1;
                byteBufferDuplicate.putInt(iClip | clip(bArr2[i5]));
                int i9 = i7 + 1;
                int iClip2 = clip(bArr[i7]) | 0;
                int i10 = i9 + 1;
                int iClip3 = iClip2 | (clip(bArr[i9]) << 20);
                int i11 = i8 + 1;
                byteBufferDuplicate.putInt(iClip3 | (clip(bArr2[i8]) << 10));
                int i12 = i11 + 1;
                int iClip4 = (clip(bArr2[i11]) << 20) | 0;
                int i13 = i10 + 1;
                int iClip5 = iClip4 | (clip(bArr[i10]) << 10);
                int i14 = i6 + 1;
                byteBufferDuplicate.putInt(iClip5 | clip(bArr3[i6]));
                int i15 = i13 + 1;
                int i16 = i15 + 1;
                byteBufferDuplicate.putInt(clip(bArr[i13]) | 0 | (clip(bArr[i15]) << 20) | (clip(bArr3[i14]) << 10));
                i4 = i14 + 1;
                i5 = i12;
                i3 = i16;
            }
            planeWidth2 += picture.getPlaneWidth(0);
            planeWidth3 += picture.getPlaneWidth(1);
            planeWidth4 += picture.getPlaneWidth(2);
        }
        byteBufferDuplicate.flip();
        return byteBufferDuplicate;
    }
}
