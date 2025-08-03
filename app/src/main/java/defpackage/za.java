package defpackage;

import com.zhiyun.protocol.constants.ExpandInterface;
import com.zhiyun.protocol.constants.ParamType;
import com.zhiyun.protocol.constants.VID;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.protocol.utils.b;
import defpackage.td;
import java.nio.ByteBuffer;

/* loaded from: classes2.dex */
public class za extends ca {

    /* renamed from: Ԩ, reason: contains not printable characters */
    public td f8785 = new td();

    /* renamed from: ԫ, reason: contains not printable characters */
    public static boolean m8664(int i, int i2) {
        return ((i >>> i2) & 1) != 0;
    }

    @Override // com.zhiyun.protocol.message.Body
    public boolean parseFrom(byte[] bArr) {
        if (bArr.length < 10) {
            return false;
        }
        ByteBuffer byteBufferA = b.a(bArr, m275());
        short s = byteBufferA.getShort();
        short s2 = byteBufferA.getShort();
        short s3 = byteBufferA.getShort();
        int i = byteBufferA.getInt();
        m8668(s);
        m8667(s2);
        m8666(s3);
        m8665(i);
        return true;
    }

    @Override // com.zhiyun.protocol.message.Body
    public byte[] toData() {
        return new byte[0];
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final void m8665(int i) {
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final void m8666(short s) {
        int i = s & 15;
        int i2 = (s & 240) >>> 4;
        int i3 = (61440 & s) >>> 12;
        m8664(s, 9);
        boolean zM8664 = m8664(s, 9);
        boolean zM86642 = m8664(s, 10);
        boolean zM86643 = m8664(s, 11);
        this.f8785.m8303(ParamType.from(i));
        this.f8785.m8304(VID.from(i2));
        this.f8785.m8302(ExpandInterface.from(i3));
        this.f8785.m8308(zM8664);
        this.f8785.m8307(zM86642);
        this.f8785.m8306(zM86643);
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public final void m8667(short s) {
        this.f8785.m8305(WorkingMode.from(s & 15));
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public final void m8668(short s) {
        this.f8785.m8301(new td.C2288(m8664(s, 0), m8664(s, 1), m8664(s, 2), m8664(s, 3), m8664(s, 4), m8664(s, 5), m8664(s, 6), m8664(s, 7), m8664(s, 8), m8664(s, 9), m8664(s, 10), m8664(s, 11), m8664(s, 12), m8664(s, 13), m8664(s, 14), m8664(s, 15)));
    }
}
