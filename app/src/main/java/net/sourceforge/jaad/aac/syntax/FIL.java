package net.sourceforge.jaad.aac.syntax;

import defpackage.C5073;
import defpackage.C5096;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.SampleFrequency;

/* loaded from: classes2.dex */
public class FIL extends Element {

    /* renamed from: ޠ, reason: contains not printable characters */
    public final boolean f8062;

    /* renamed from: ޡ, reason: contains not printable characters */
    public DynamicRangeInfo f8063;

    public static class DynamicRangeInfo {
        private static final int MAX_NBR_BANDS = 7;
        private int[] bandTop;
        private int bandsIncrement;
        private boolean bandsPresent;
        private int[] dynRngCtl;
        private boolean[] dynRngSgn;
        private boolean excludedChannelsPresent;
        private int interpolationScheme;
        private int pceInstanceTag;
        private boolean pceTagPresent;
        private int progRefLevel;
        private boolean progRefLevelPresent;
        private int progRefLevelReservedBits;
        private int tagReservedBits;
        private final boolean[] excludeMask = new boolean[7];
        private final boolean[] additionalExcludedChannels = new boolean[7];
    }

    public FIL(boolean z) {
        this.f8062 = z;
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m7649(IBitStream iBitStream, Element element, SampleFrequency sampleFrequency, boolean z, boolean z2) throws AACException {
        int bits = iBitStream.readBits(4);
        if (bits == 15) {
            bits += iBitStream.readBits(8) - 1;
        }
        int i = bits * 8;
        int position = iBitStream.getPosition();
        int iM7652 = i;
        while (iM7652 > 0) {
            iM7652 = m7652(iBitStream, iM7652, element, sampleFrequency, z, z2);
        }
        int position2 = iBitStream.getPosition() - position;
        int i2 = i - position2;
        if (i2 > 0) {
            iBitStream.skipBits(position2);
        } else {
            if (i2 >= 0) {
                return;
            }
            throw new AACException("FIL element overread: " + i2);
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final int m7650(IBitStream iBitStream, int i) throws AACException {
        int i2;
        if (this.f8063 == null) {
            this.f8063 = new DynamicRangeInfo();
        }
        if (this.f8063.pceTagPresent = iBitStream.readBool()) {
            this.f8063.pceInstanceTag = iBitStream.readBits(4);
            this.f8063.tagReservedBits = iBitStream.readBits(4);
        }
        if (this.f8063.excludedChannelsPresent = iBitStream.readBool()) {
            i -= m7651(iBitStream);
        }
        if (this.f8063.bandsPresent = iBitStream.readBool()) {
            this.f8063.bandsIncrement = iBitStream.readBits(4);
            this.f8063.interpolationScheme = iBitStream.readBits(4);
            i -= 8;
            i2 = this.f8063.bandsIncrement + 1;
            this.f8063.bandTop = new int[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                this.f8063.bandTop[i3] = iBitStream.readBits(8);
                i -= 8;
            }
        } else {
            i2 = 1;
        }
        if (this.f8063.progRefLevelPresent = iBitStream.readBool()) {
            this.f8063.progRefLevel = iBitStream.readBits(7);
            this.f8063.progRefLevelReservedBits = iBitStream.readBits(1);
            i -= 8;
        }
        this.f8063.dynRngSgn = new boolean[i2];
        this.f8063.dynRngCtl = new int[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            this.f8063.dynRngSgn[i4] = iBitStream.readBool();
            this.f8063.dynRngCtl[i4] = iBitStream.readBits(7);
            i -= 8;
        }
        return i;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final int m7651(IBitStream iBitStream) throws AACException {
        int i = 0;
        do {
            for (int i2 = 0; i2 < 7; i2++) {
                this.f8063.excludeMask[i] = iBitStream.readBool();
                i++;
            }
            if (i >= 57) {
                break;
            }
        } while (iBitStream.readBool());
        return (i / 7) * 8;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final int m7652(IBitStream iBitStream, int i, Element element, SampleFrequency sampleFrequency, boolean z, boolean z2) throws AACException {
        int bits = iBitStream.readBits(4);
        int i2 = i - 4;
        if (bits == 11) {
            return m7650(iBitStream, i2);
        }
        if (bits == 13 || bits == 14) {
            if (z) {
                if ((element instanceof C5096) || (element instanceof CPE) || (element instanceof C5073)) {
                    element.decodeSBR(iBitStream, sampleFrequency, i2, element instanceof CPE, bits == 14, this.f8062, z2);
                    return 0;
                }
                throw new AACException("SBR applied on unexpected element: " + element);
            }
            iBitStream.skipBits(i2);
            i2 = 0;
        }
        iBitStream.skipBits(i2);
        return 0;
    }
}
