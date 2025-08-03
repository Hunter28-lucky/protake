package net.sourceforge.jaad.aac.syntax;

import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.SampleFrequency;
import net.sourceforge.jaad.aac.sbr.SBR;

/* loaded from: classes2.dex */
public abstract class Element implements SyntaxConstants {
    private int elementInstanceTag;
    private SBR sbr;

    public void decodeSBR(IBitStream iBitStream, SampleFrequency sampleFrequency, int i, boolean z, boolean z2, boolean z3, boolean z4) throws AACException {
        if (this.sbr == null) {
            this.sbr = new SBR(z4, this.elementInstanceTag == 1, sampleFrequency, z3);
        }
        this.sbr.decode(iBitStream, i);
    }

    public int getElementInstanceTag() {
        return this.elementInstanceTag;
    }

    public SBR getSBR() {
        return this.sbr;
    }

    public boolean isSBRPresent() {
        return this.sbr != null;
    }

    public void readElementInstanceTag(IBitStream iBitStream) throws AACException {
        this.elementInstanceTag = iBitStream.readBits(4);
    }
}
