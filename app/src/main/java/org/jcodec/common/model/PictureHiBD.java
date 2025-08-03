package org.jcodec.common.model;

/* loaded from: classes2.dex */
public class PictureHiBD {
    private int bitDepth;
    private ColorSpace color;
    private Rect crop;
    private int[][] data;
    private int height;
    private int width;

    public PictureHiBD(int i, int i2, int[][] iArr, ColorSpace colorSpace, int i3, Rect rect) {
        this.width = i;
        this.height = i2;
        this.data = iArr;
        this.color = colorSpace;
        this.crop = rect;
        this.bitDepth = i3;
    }

    public static PictureHiBD clonePicture(PictureHiBD pictureHiBD) {
        return new PictureHiBD(pictureHiBD.width, pictureHiBD.height, pictureHiBD.data, pictureHiBD.color, pictureHiBD.bitDepth, pictureHiBD.crop);
    }

    public static PictureHiBD create(int i, int i2, ColorSpace colorSpace) {
        return doCreate(i, i2, colorSpace, 8, null);
    }

    public static PictureHiBD createCropped(int i, int i2, ColorSpace colorSpace, Rect rect) {
        return doCreate(i, i2, colorSpace, 8, rect);
    }

    public static PictureHiBD createPicture(int i, int i2, int[][] iArr, ColorSpace colorSpace) {
        return new PictureHiBD(i, i2, iArr, colorSpace, 8, new Rect(0, 0, i, i2));
    }

    public static PictureHiBD createPictureCropped(int i, int i2, int[][] iArr, ColorSpace colorSpace, Rect rect) {
        return new PictureHiBD(i, i2, iArr, colorSpace, 8, rect);
    }

    public static PictureHiBD createPictureWithDepth(int i, int i2, int[][] iArr, ColorSpace colorSpace, int i3) {
        return new PictureHiBD(i, i2, iArr, colorSpace, i3, new Rect(0, 0, i, i2));
    }

    public static PictureHiBD createWithDepth(int i, int i2, ColorSpace colorSpace, int i3) {
        return doCreate(i, i2, colorSpace, i3, null);
    }

    private void cropSub(int[] iArr, int i, int i2, int i3, int i4, int i5, int[] iArr2) {
        int i6 = (i2 * i5) + i;
        int i7 = 0;
        for (int i8 = 0; i8 < i4; i8++) {
            for (int i9 = 0; i9 < i3; i9++) {
                iArr2[i7 + i9] = iArr[i6 + i9];
            }
            i6 += i5;
            i7 += i3;
        }
    }

    public static PictureHiBD doCreate(int i, int i2, ColorSpace colorSpace, int i3, Rect rect) {
        int[] iArr = new int[4];
        for (int i4 = 0; i4 < colorSpace.nComp; i4++) {
            int i5 = colorSpace.compPlane[i4];
            iArr[i5] = iArr[i5] + ((i >> colorSpace.compWidth[i4]) * (i2 >> colorSpace.compHeight[i4]));
        }
        int i6 = 0;
        for (int i7 = 0; i7 < 4; i7++) {
            i6 += iArr[i7] != 0 ? 1 : 0;
        }
        int[][] iArr2 = new int[i6][];
        int i8 = 0;
        for (int i9 = 0; i9 < 4; i9++) {
            int i10 = iArr[i9];
            if (i10 != 0) {
                iArr2[i8] = new int[i10];
                i8++;
            }
        }
        return new PictureHiBD(i, i2, iArr2, colorSpace, 8, rect);
    }

    private boolean planeEquals(PictureHiBD pictureHiBD, int i) {
        ColorSpace colorSpace = this.color;
        int i2 = colorSpace.compWidth[i];
        int i3 = colorSpace.compHeight[i];
        int x = pictureHiBD.getCrop() == null ? 0 : (pictureHiBD.getCrop().getX() >> i2) + ((pictureHiBD.getCrop().getY() >> i3) * (pictureHiBD.getWidth() >> i2));
        Rect rect = this.crop;
        int x2 = rect == null ? 0 : (rect.getX() >> i2) + ((this.crop.getY() >> i3) * (this.width >> i2));
        int[] planeData = pictureHiBD.getPlaneData(i);
        int i4 = 0;
        while (i4 < (getCroppedHeight() >> i3)) {
            for (int i5 = 0; i5 < (getCroppedWidth() >> i2); i5++) {
                if (planeData[x + i5] != this.data[i][x2 + i5]) {
                    return false;
                }
            }
            i4++;
            x += pictureHiBD.getWidth() >> i2;
            x2 += this.width >> i2;
        }
        return true;
    }

    public boolean compatible(PictureHiBD pictureHiBD) {
        return pictureHiBD.color == this.color && pictureHiBD.width == this.width && pictureHiBD.height == this.height;
    }

    public void copyFrom(PictureHiBD pictureHiBD) {
        if (!compatible(pictureHiBD)) {
            throw new IllegalArgumentException("Can not copy to incompatible picture");
        }
        int i = 0;
        while (true) {
            ColorSpace colorSpace = this.color;
            if (i >= colorSpace.nComp) {
                return;
            }
            int[] iArr = this.data[i];
            if (iArr != null) {
                System.arraycopy(pictureHiBD.data[i], 0, iArr, 0, (this.width >> colorSpace.compWidth[i]) * (this.height >> colorSpace.compHeight[i]));
            }
            i++;
        }
    }

    public PictureHiBD createCompatible() {
        return create(this.width, this.height, this.color);
    }

    public PictureHiBD cropped() {
        Rect rect = this.crop;
        if (rect == null || (rect.getX() == 0 && this.crop.getY() == 0 && this.crop.getWidth() == this.width && this.crop.getHeight() == this.height)) {
            return this;
        }
        PictureHiBD pictureHiBDCreate = create(this.crop.getWidth(), this.crop.getHeight(), this.color);
        for (int i = 0; i < this.color.nComp; i++) {
            int[] iArr = this.data[i];
            if (iArr != null) {
                int x = this.crop.getX() >> this.color.compWidth[i];
                int y = this.crop.getY() >> this.color.compHeight[i];
                int width = this.crop.getWidth() >> this.color.compWidth[i];
                int height = this.crop.getHeight();
                ColorSpace colorSpace = this.color;
                cropSub(iArr, x, y, width, height >> colorSpace.compHeight[i], this.width >> colorSpace.compWidth[i], pictureHiBDCreate.data[i]);
            }
        }
        return pictureHiBDCreate;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof PictureHiBD)) {
            PictureHiBD pictureHiBD = (PictureHiBD) obj;
            if (pictureHiBD.getCroppedWidth() == getCroppedWidth() && pictureHiBD.getCroppedHeight() == getCroppedHeight() && pictureHiBD.getColor() == this.color) {
                for (int i = 0; i < getData().length; i++) {
                    if (!planeEquals(pictureHiBD, i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public int getBitDepth() {
        return this.bitDepth;
    }

    public ColorSpace getColor() {
        return this.color;
    }

    public Rect getCrop() {
        return this.crop;
    }

    public int getCroppedHeight() {
        Rect rect = this.crop;
        return rect == null ? this.height : rect.getHeight();
    }

    public int getCroppedWidth() {
        Rect rect = this.crop;
        return rect == null ? this.width : rect.getWidth();
    }

    public int[][] getData() {
        return this.data;
    }

    public int getHeight() {
        return this.height;
    }

    public int[] getPlaneData(int i) {
        return this.data[i];
    }

    public int getPlaneHeight(int i) {
        return this.height >> this.color.compHeight[i];
    }

    public int getPlaneWidth(int i) {
        return this.width >> this.color.compWidth[i];
    }

    public int getWidth() {
        return this.width;
    }

    public void setBitDepth(int i) {
        this.bitDepth = i;
    }

    public void setCrop(Rect rect) {
        this.crop = rect;
    }
}
