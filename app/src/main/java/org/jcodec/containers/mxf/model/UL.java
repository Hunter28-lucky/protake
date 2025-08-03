package org.jcodec.containers.mxf.model;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.cb;
import io.jsonwebtoken.JwtParser;
import java.nio.ByteBuffer;
import org.jcodec.common.Preconditions;
import org.jcodec.common.StringUtils;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class UL {
    private static final char[] hex = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private final byte[] bytes;

    public UL(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        this.bytes = bArr;
    }

    public static UL newUL(String str) {
        Preconditions.checkNotNull(str);
        String[] strArrSplitS = StringUtils.splitS(str, ".");
        byte[] bArr = new byte[strArrSplitS.length];
        for (int i = 0; i < strArrSplitS.length; i++) {
            bArr[i] = (byte) Integer.parseInt(strArrSplitS[i], 16);
        }
        return new UL(bArr);
    }

    public static UL newULFromInts(int[] iArr) {
        byte[] bArr = new byte[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            bArr[i] = (byte) iArr[i];
        }
        return new UL(bArr);
    }

    public static UL read(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[16];
        byteBuffer.get(bArr);
        return new UL(bArr);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof UL)) {
            return false;
        }
        byte[] bArr = ((UL) obj).bytes;
        for (int i = 4; i < Math.min(this.bytes.length, bArr.length); i++) {
            if (this.bytes[i] != bArr[i]) {
                return false;
            }
        }
        return true;
    }

    public int get(int i) {
        return this.bytes[i];
    }

    public int hashCode() {
        byte[] bArr = this.bytes;
        return (bArr[7] & ExifInterface.MARKER) | ((bArr[4] & ExifInterface.MARKER) << 24) | ((bArr[5] & ExifInterface.MARKER) << 16) | ((bArr[6] & ExifInterface.MARKER) << 8);
    }

    public boolean maskEquals(UL ul, int i) {
        if (ul == null) {
            return false;
        }
        byte[] bArr = ul.bytes;
        int i2 = 4;
        int i3 = i >> 4;
        while (i2 < Math.min(this.bytes.length, bArr.length)) {
            if ((i3 & 1) == 1 && this.bytes[i2] != bArr[i2]) {
                return false;
            }
            i2++;
            i3 >>= 1;
        }
        return true;
    }

    public String toString() {
        if (this.bytes.length == 0) {
            return "";
        }
        char[] cArr = new char[(r0.length * 3) - 1];
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.bytes;
            if (i >= bArr.length - 1) {
                char[] cArr2 = hex;
                byte b = bArr[i];
                cArr[i2] = cArr2[(b >> 4) & 15];
                cArr[i2 + 1] = cArr2[b & cb.m];
                return Platform.stringFromChars(cArr);
            }
            int i3 = i2 + 1;
            char[] cArr3 = hex;
            byte b2 = bArr[i];
            cArr[i2] = cArr3[(b2 >> 4) & 15];
            int i4 = i3 + 1;
            cArr[i3] = cArr3[b2 & cb.m];
            cArr[i4] = JwtParser.SEPARATOR_CHAR;
            i++;
            i2 = i4 + 1;
        }
    }
}
