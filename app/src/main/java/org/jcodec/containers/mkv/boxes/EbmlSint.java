package org.jcodec.containers.mkv.boxes;

import com.xiaomi.clientreport.data.Config;
import java.nio.ByteBuffer;
import org.jcodec.containers.mkv.util.EbmlUtil;

/* loaded from: classes2.dex */
public class EbmlSint extends EbmlBin {
    public static final long[] signedComplement = {0, 63, 8191, 1048575, 134217727, 17179869183L, 2199023255551L, 281474976710655L, 36028797018963967L};

    public EbmlSint(byte[] bArr) {
        super(bArr);
    }

    public static byte[] convertToBytes(long j) {
        int iEbmlSignedLength = ebmlSignedLength(j);
        return EbmlUtil.ebmlEncodeLen(j + signedComplement[iEbmlSignedLength], iEbmlSignedLength);
    }

    public static int ebmlSignedLength(long j) {
        if (j <= 64 && j >= -63) {
            return 1;
        }
        if (j <= 8192 && j >= -8191) {
            return 2;
        }
        if (j <= Config.DEFAULT_MAX_FILE_LENGTH && j >= -1048575) {
            return 3;
        }
        if (j <= 134217728 && j >= -134217727) {
            return 4;
        }
        if (j <= 17179869184L && j >= -17179869183L) {
            return 5;
        }
        if (j > 2199023255552L || j < -2199023255551L) {
            return (j > 281474976710656L || j < -281474976710655L) ? 8 : 7;
        }
        return 6;
    }

    public long getLong() {
        if (this.data.limit() - this.data.position() == 8) {
            return this.data.duplicate().getLong();
        }
        long length = 0;
        for (int length2 = this.data.array().length - 1; length2 >= 0; length2--) {
            length |= (r0[length2] & 255) << (((r0.length - 1) - length2) * 8);
        }
        return length;
    }

    public void setLong(long j) {
        this.data = ByteBuffer.wrap(convertToBytes(j));
    }
}
