package defpackage;

import java.lang.reflect.Array;
import net.sourceforge.jaad.aac.AACDecoderConfig;
import net.sourceforge.jaad.aac.AACException;
import net.sourceforge.jaad.aac.huffman.Huffman;
import net.sourceforge.jaad.aac.syntax.Element;
import net.sourceforge.jaad.aac.syntax.IBitStream;
import net.sourceforge.jaad.aac.syntax.ICSInfo;
import net.sourceforge.jaad.aac.syntax.ICStream;

/* compiled from: CCE.java */
/* renamed from: ཬ, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C5073 extends Element {

    /* renamed from: ߿, reason: contains not printable characters */
    public static final float[] f16847 = {1.0905077f, 1.1892071f, 1.4142135f, 2.0f};

    /* renamed from: ޠ, reason: contains not printable characters */
    public final ICStream f16848;

    /* renamed from: ޡ, reason: contains not printable characters */
    public float[] f16849;

    /* renamed from: ޢ, reason: contains not printable characters */
    public int f16850;

    /* renamed from: ޣ, reason: contains not printable characters */
    public int f16851;

    /* renamed from: ޤ, reason: contains not printable characters */
    public final boolean[] f16852 = new boolean[8];

    /* renamed from: ޥ, reason: contains not printable characters */
    public final int[] f16853 = new int[8];

    /* renamed from: ޱ, reason: contains not printable characters */
    public final int[] f16854 = new int[8];

    /* renamed from: ߾, reason: contains not printable characters */
    public final float[][] f16855 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, 16, 120);

    public C5073(int i) {
        this.f16848 = new ICStream(i);
    }

    public void decode(IBitStream iBitStream, AACDecoderConfig aACDecoderConfig) throws AACException {
        int[][] iArr;
        int iDecodeScaleFactor;
        int i;
        boolean z;
        int i2;
        int i3;
        int iDecodeScaleFactor2;
        int i4;
        int i5;
        int i6 = 2;
        this.f16850 = iBitStream.readBit() * 2;
        this.f16851 = iBitStream.readBits(3);
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 <= this.f16851; i9++) {
            i8++;
            this.f16852[i9] = iBitStream.readBool();
            this.f16853[i9] = iBitStream.readBits(4);
            if (this.f16852[i9]) {
                this.f16854[i9] = iBitStream.readBits(2);
                if (this.f16854[i9] == 3) {
                    i8++;
                }
            } else {
                this.f16854[i9] = 2;
            }
        }
        int bit = this.f16850 + iBitStream.readBit();
        this.f16850 = bit | (bit >> 1);
        boolean bool = iBitStream.readBool();
        double d = f16847[iBitStream.readBits(2)];
        this.f16848.decode(iBitStream, false, aACDecoderConfig);
        ICSInfo info = this.f16848.getInfo();
        int windowGroupCount = info.getWindowGroupCount();
        int maxSFB = info.getMaxSFB();
        int i10 = 1;
        int[][] iArr2 = {new int[0]};
        int i11 = 0;
        while (i11 < i8) {
            float fPow = 1.0f;
            if (i11 > 0) {
                int bit2 = this.f16850 == i6 ? i10 : iBitStream.readBit();
                iDecodeScaleFactor = bit2 == 0 ? i7 : Huffman.decodeScaleFactor(iBitStream) - 60;
                iArr = iArr2;
                int i12 = bit2;
                fPow = (float) Math.pow(d, -iDecodeScaleFactor);
                i = i12;
            } else {
                iArr = iArr2;
                iDecodeScaleFactor = i7;
                i = 1;
            }
            if (this.f16850 == i6) {
                this.f16855[i11][i7] = fPow;
            } else {
                int i13 = i7;
                int i14 = i13;
                while (i13 < windowGroupCount) {
                    while (i7 < maxSFB) {
                        if (iArr[i13][i7] != 0) {
                            if (i != 0 || Huffman.decodeScaleFactor(iBitStream) - 60 == 0) {
                                z = bool;
                                i2 = maxSFB;
                                i3 = i8;
                            } else {
                                iDecodeScaleFactor += iDecodeScaleFactor2;
                                if (bool) {
                                    i4 = iDecodeScaleFactor;
                                    i5 = 1;
                                } else {
                                    i5 = 1 - ((iDecodeScaleFactor & 1) * i6);
                                    i4 = iDecodeScaleFactor >> 1;
                                }
                                z = bool;
                                double dPow = Math.pow(d, -i4);
                                i2 = maxSFB;
                                i3 = i8;
                                fPow = (float) (dPow * i5);
                            }
                            this.f16855[i11][i14] = fPow;
                        } else {
                            z = bool;
                            i2 = maxSFB;
                            i3 = i8;
                        }
                        i7++;
                        i14++;
                        maxSFB = i2;
                        i8 = i3;
                        bool = z;
                        i6 = 2;
                    }
                    i13++;
                    i6 = 2;
                    i7 = 0;
                }
            }
            i11++;
            maxSFB = maxSFB;
            i8 = i8;
            iArr2 = iArr;
            i10 = 1;
            bool = bool;
            i6 = 2;
            i7 = 0;
        }
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public void m14888(int i, float[] fArr) {
        ICSInfo info = this.f16848.getInfo();
        int[] sWBOffsets = info.getSWBOffsets();
        int windowGroupCount = info.getWindowGroupCount();
        int maxSFB = info.getMaxSFB();
        int i2 = 0;
        int[][] iArr = {new int[0]};
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        while (i3 < windowGroupCount) {
            int windowGroupLength = info.getWindowGroupLength(i3);
            int i7 = i2;
            while (i7 < maxSFB) {
                if (iArr[i3][i7] != 0) {
                    float f = this.f16855[i][i6];
                    for (int i8 = i2; i8 < windowGroupLength; i8++) {
                        int i9 = sWBOffsets[i7];
                        while (i9 < sWBOffsets[i7 + 1]) {
                            int i10 = i8 * 128;
                            int i11 = i5 + i10 + i9;
                            fArr[i11] = fArr[i11] + (this.f16849[i10 + i4 + i9] * f);
                            i9++;
                            info = info;
                        }
                    }
                }
                i7++;
                i6++;
                info = info;
                i2 = 0;
            }
            int i12 = windowGroupLength * 128;
            i5 += i12;
            i4 += i12;
            i3++;
            i2 = 0;
        }
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public void m14889(int i, float[] fArr) {
        double d = this.f16855[i][0];
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = (float) (fArr[i2] + (this.f16849[i2] * d));
        }
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public int m14890(int i) {
        return this.f16854[i];
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public int m14891() {
        return this.f16851;
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public int m14892() {
        return this.f16850;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int m14893(int i) {
        return this.f16853[i];
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public boolean m14894(int i) {
        return this.f16852[i];
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public void m14895() throws AACException {
        this.f16849 = this.f16848.getInvQuantData();
    }
}
