package defpackage;

import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.syntax.Element;
import net.sourceforge.jaad.aac.syntax.IBitStream;

/* compiled from: DSE.java */
/* renamed from: ձ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C3244 extends Element {

    /* renamed from: ޠ, reason: contains not printable characters */
    public byte[] f11407;

    public void decode(IBitStream iBitStream) throws AACException {
        boolean bool = iBitStream.readBool();
        int bits = iBitStream.readBits(8);
        if (bits == 255) {
            bits += iBitStream.readBits(8);
        }
        if (bool) {
            iBitStream.byteAlign();
        }
        this.f11407 = new byte[bits];
        for (int i = 0; i < bits; i++) {
            this.f11407[i] = (byte) iBitStream.readBits(8);
        }
    }
}
