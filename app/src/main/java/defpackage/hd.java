package defpackage;

/* loaded from: classes.dex */
public class hd {
    /* renamed from: Ϳ, reason: contains not printable characters */
    public static byte[] m6201(int i) {
        byte[] bArr = {(byte) ((i >> 8) % 256), (byte) (i % 256), (byte) (i % 256), (byte) (i % 256)};
        int i2 = i >> 8;
        int i3 = i2 >> 8;
        return bArr;
    }
}
