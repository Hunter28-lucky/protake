package net.sourceforge.jaad.aac.error;

import net.sourceforge.jaad.aac.syntax.SyntaxConstants;

/* loaded from: classes2.dex */
public class HCR implements SyntaxConstants {
    private static final int MAX_CB = 32;
    private static final int NUM_CB = 6;
    private static final int NUM_CB_ER = 22;
    private static final int VCB11_FIRST = 16;
    private static final int VCB11_LAST = 31;
    private static final int[] PRE_SORT_CB_STD = {11, 9, 7, 5, 3, 1};
    private static final int[] PRE_SORT_CB_ER = {11, 31, 30, 29, 28, 27, 26, 25, 24, 23, 22, 21, 20, 19, 18, 17, 16, 9, 7, 5, 3, 1};
    private static final int[] MAX_CW_LEN = {0, 11, 9, 20, 16, 13, 11, 14, 12, 17, 14, 49, 0, 0, 0, 0, 14, 17, 21, 21, 25, 25, 29, 29, 29, 29, 33, 33, 33, 37, 37, 41};

    /* renamed from: net.sourceforge.jaad.aac.error.HCR$Ϳ, reason: contains not printable characters */
    public static class C2196 {
        /* renamed from: Ϳ, reason: contains not printable characters */
        public static /* synthetic */ void m7648(C2196 c2196, int i, int i2) {
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x01d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void decodeReorderedSpectralData(net.sourceforge.jaad.aac.syntax.ICStream r39, net.sourceforge.jaad.aac.syntax.IBitStream r40, short[] r41, boolean r42) throws net.sourceforge.jaad.aac.AACException {
        /*
            Method dump skipped, instructions count: 690
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sourceforge.jaad.aac.error.HCR.decodeReorderedSpectralData(net.sourceforge.jaad.aac.syntax.ICStream, net.sourceforge.jaad.aac.syntax.IBitStream, short[], boolean):void");
    }

    private static boolean isGoodCB(int i, int i2) {
        if ((i2 <= 0 || i2 > 11) && (i2 < 16 || i2 > 31)) {
            return false;
        }
        if (i < 11) {
            if (i2 != i && i2 != i + 1) {
                return false;
            }
        } else if (i2 != i) {
            return false;
        }
        return true;
    }
}
