package org.jcodec.common.model;

/* loaded from: classes2.dex */
public final class ColorSpace {
    public static final ColorSpace BGR;
    public static final int MAX_PLANES = 4;
    public static final ColorSpace MONO;
    public static final ColorSpace RGB;
    public static final ColorSpace YUV420;
    public static final ColorSpace YUV420J;
    public static final ColorSpace YUV422;
    public static final ColorSpace YUV422J;
    public static final ColorSpace YUV422_10;
    public static final ColorSpace YUV444;
    public static final ColorSpace YUV444J;
    public static final ColorSpace YUV444_10;
    private static final int[] _000;
    private static final int[] _011;
    private static final int[] _012;
    private String _name;
    public int bitsPerPixel;
    public int[] compHeight;
    public int[] compPlane;
    public int[] compWidth;
    public int nComp;
    public boolean planar;
    public static final ColorSpace GREY = new ColorSpace("GREY", 1, new int[]{0}, new int[]{0}, new int[]{0}, true);
    public static final ColorSpace ANY = new ColorSpace("ANY", 0, null, null, null, true);
    public static final ColorSpace ANY_PLANAR = new ColorSpace("ANY_PLANAR", 0, null, null, null, true);
    public static final ColorSpace ANY_INTERLEAVED = new ColorSpace("ANY_INTERLEAVED", 0, null, null, null, false);
    public static final ColorSpace SAME = new ColorSpace("SAME", 0, null, null, null, false);

    static {
        int[] iArr = {0, 0, 0};
        _000 = iArr;
        int[] iArr2 = {0, 1, 1};
        _011 = iArr2;
        int[] iArr3 = {0, 1, 2};
        _012 = iArr3;
        BGR = new ColorSpace("BGR", 3, iArr, iArr, iArr, false);
        RGB = new ColorSpace("RGB", 3, iArr, iArr, iArr, false);
        YUV420 = new ColorSpace("YUV420", 3, iArr3, iArr2, iArr2, true);
        YUV420J = new ColorSpace("YUV420J", 3, iArr3, iArr2, iArr2, true);
        YUV422 = new ColorSpace("YUV422", 3, iArr3, iArr2, iArr, true);
        YUV422J = new ColorSpace("YUV422J", 3, iArr3, iArr2, iArr, true);
        YUV444 = new ColorSpace("YUV444", 3, iArr3, iArr, iArr, true);
        YUV444J = new ColorSpace("YUV444J", 3, iArr3, iArr, iArr, true);
        YUV422_10 = new ColorSpace("YUV422_10", 3, iArr3, iArr2, iArr, true);
        MONO = new ColorSpace("MONO", 1, iArr, iArr, iArr, true);
        YUV444_10 = new ColorSpace("YUV444_10", 3, iArr3, iArr, iArr, true);
    }

    private ColorSpace(String str, int i, int[] iArr, int[] iArr2, int[] iArr3, boolean z) {
        this._name = str;
        this.nComp = i;
        this.compPlane = iArr;
        this.compWidth = iArr2;
        this.compHeight = iArr3;
        this.planar = z;
        this.bitsPerPixel = calcBitsPerPixel(i, iArr2, iArr3);
    }

    private static int calcBitsPerPixel(int i, int[] iArr, int[] iArr2) {
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            i2 += (8 >> iArr[i3]) >> iArr2[i3];
        }
        return i2;
    }

    public Size compSize(Size size, int i) {
        return (this.compWidth[i] == 0 && this.compHeight[i] == 0) ? size : new Size(size.getWidth() >> this.compWidth[i], size.getHeight() >> this.compHeight[i]);
    }

    public int getHeightMask() {
        return ~(this.nComp > 1 ? this.compHeight[1] : 0);
    }

    public int getWidthMask() {
        return ~(this.nComp > 1 ? this.compWidth[1] : 0);
    }

    public boolean matches(ColorSpace colorSpace) {
        ColorSpace colorSpace2;
        ColorSpace colorSpace3;
        if (colorSpace == this || colorSpace == (colorSpace2 = ANY) || this == colorSpace2) {
            return true;
        }
        ColorSpace colorSpace4 = ANY_INTERLEAVED;
        return (colorSpace == colorSpace4 || this == colorSpace4 || colorSpace == (colorSpace3 = ANY_PLANAR) || this == colorSpace3) && colorSpace.planar == this.planar;
    }

    public String toString() {
        return this._name;
    }
}
