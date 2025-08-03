package org.jcodec.containers.mkv.boxes;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import org.jcodec.platform.Platform;

/* loaded from: classes2.dex */
public class EbmlString extends EbmlBin {
    public String charset;

    public EbmlString(byte[] bArr) {
        super(bArr);
        this.charset = Platform.UTF_8;
    }

    public static EbmlString createEbmlString(byte[] bArr, String str) {
        EbmlString ebmlString = new EbmlString(bArr);
        ebmlString.setString(str);
        return ebmlString;
    }

    public String getString() {
        try {
            return new String(this.data.array(), this.charset);
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public void setString(String str) {
        try {
            this.data = ByteBuffer.wrap(str.getBytes(this.charset));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }
}
