package defpackage;

import net.sourceforge.jaad.aac.AACDecoderConfig;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.syntax.Element;
import net.sourceforge.jaad.aac.syntax.IBitStream;
import net.sourceforge.jaad.aac.syntax.ICStream;

/* compiled from: SCE_LFE.java */
/* renamed from: ည, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5096 extends Element {

    /* renamed from: ޠ, reason: contains not printable characters */
    public final ICStream f16930;

    public C5096(int i) {
        this.f16930 = new ICStream(i);
    }

    public void decode(IBitStream iBitStream, AACDecoderConfig aACDecoderConfig) throws AACException {
        readElementInstanceTag(iBitStream);
        this.f16930.decode(iBitStream, false, aACDecoderConfig);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public ICStream m14926() {
        return this.f16930;
    }
}
