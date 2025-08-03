package org.jcodec.common.model;

import java.util.Arrays;
import org.jcodec.common.tools.MathUtil;
import org.jcodec.containers.mxf.model.BER;

/* loaded from: classes2.dex */
public class Picture {
    private ColorSpace color;
    private Rect crop;
    private byte[][] data;
    private int height;
    private byte[][] lowBits;
    private int lowBitsNum;
    private int width;

    public Picture(int i, int i2, byte[][] bArr, byte[][] bArr2, ColorSpace colorSpace, int i3, Rect rect) {
        this.width = i;
        this.height = i2;
        this.data = bArr;
        this.lowBits = bArr2;
        this.color = colorSpace;
        this.lowBitsNum = i3;
        this.crop = rect;
        if (colorSpace != null) {
            for (int i4 = 0; i4 < colorSpace.nComp; i4++) {
                int i5 = 255 >> (8 - colorSpace.compWidth[i4]);
                if ((i & i5) != 0) {
                    throw new IllegalArgumentException("Component " + i4 + " width should be a multiple of " + (1 << colorSpace.compWidth[i4]) + " for colorspace: " + colorSpace);
                }
                if (rect != null && (i5 & rect.getWidth()) != 0) {
                    throw new IllegalArgumentException("Component " + i4 + " cropped width should be a multiple of " + (1 << colorSpace.compWidth[i4]) + " for colorspace: " + colorSpace);
                }
                int i6 = 255 >> (8 - colorSpace.compHeight[i4]);
                if ((i2 & i6) != 0) {
                    throw new IllegalArgumentException("Component " + i4 + " height should be a multiple of " + (1 << colorSpace.compHeight[i4]) + " for colorspace: " + colorSpace);
                }
                if (rect != null && (i6 & rect.getHeight()) != 0) {
                    throw new IllegalArgumentException("Component " + i4 + " cropped height should be a multiple of " + (1 << colorSpace.compHeight[i4]) + " for colorspace: " + colorSpace);
                }
            }
        }
    }

    public static Picture copyPicture(Picture picture) {
        return new Picture(picture.width, picture.height, picture.data, picture.lowBits, picture.color, 0, picture.crop);
    }

    public static Picture create(int i, int i2, ColorSpace colorSpace) {
        return createCropped(i, i2, colorSpace, null);
    }

    public static Picture createCropped(int i, int i2, ColorSpace colorSpace, Rect rect) {
        int[] iArr = new int[4];
        for (int i3 = 0; i3 < colorSpace.nComp; i3++) {
            int i4 = colorSpace.compPlane[i3];
            iArr[i4] = iArr[i4] + ((i >> colorSpace.compWidth[i3]) * (i2 >> colorSpace.compHeight[i3]));
        }
        int i5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            i5 += iArr[i6] != 0 ? 1 : 0;
        }
        byte[][] bArr = new byte[i5][];
        int i7 = 0;
        for (int i8 = 0; i8 < 4; i8++) {
            int i9 = iArr[i8];
            if (i9 != 0) {
                bArr[i7] = new byte[i9];
                i7++;
            }
        }
        return new Picture(i, i2, bArr, null, colorSpace, 0, rect);
    }

    public static Picture createCroppedHiBD(int i, int i2, int i3, ColorSpace colorSpace, Rect rect) {
        Picture pictureCreateCropped = createCropped(i, i2, colorSpace, rect);
        if (i3 <= 0) {
            return pictureCreateCropped;
        }
        byte[][] data = pictureCreateCropped.getData();
        int length = data.length;
        byte[][] bArr = new byte[length][];
        int i4 = 0;
        int i5 = 0;
        while (i4 < length) {
            bArr[i5] = new byte[data[i4].length];
            i4++;
            i5++;
        }
        pictureCreateCropped.setLowBits(bArr);
        pictureCreateCropped.setLowBitsNum(i3);
        return pictureCreateCropped;
    }

    public static Picture createPicture(int i, int i2, byte[][] bArr, ColorSpace colorSpace) {
        return new Picture(i, i2, bArr, null, colorSpace, 0, new Rect(0, 0, i, i2));
    }

    public static Picture createPictureHiBD(int i, int i2, byte[][] bArr, byte[][] bArr2, ColorSpace colorSpace, int i3) {
        return new Picture(i, i2, bArr, bArr2, colorSpace, i3, new Rect(0, 0, i, i2));
    }

    private void cropSub(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, byte[] bArr2) {
        int i7 = (i2 * i5) + i;
        int i8 = 0;
        for (int i9 = 0; i9 < i4; i9++) {
            for (int i10 = 0; i10 < i6; i10++) {
                bArr2[i8 + i10] = bArr[i7 + i10];
            }
            i7 += i5;
            i8 += i6;
        }
    }

    public static Picture fromPictureHiBD(PictureHiBD pictureHiBD) {
        int bitDepth = pictureHiBD.getBitDepth() - 8;
        int i = (1 << bitDepth) >> 1;
        Picture pictureCreateCroppedHiBD = createCroppedHiBD(pictureHiBD.getWidth(), pictureHiBD.getHeight(), bitDepth, pictureHiBD.getColor(), pictureHiBD.getCrop());
        for (int i2 = 0; i2 < Math.min(pictureHiBD.getData().length, pictureCreateCroppedHiBD.getData().length); i2++) {
            for (int i3 = 0; i3 < Math.min(pictureHiBD.getData()[i2].length, pictureCreateCroppedHiBD.getData()[i2].length); i3++) {
                pictureCreateCroppedHiBD.getData()[i2][i3] = (byte) (MathUtil.clip((pictureHiBD.getData()[i2][i3] + i) >> bitDepth, 0, 255) - 128);
            }
        }
        byte[][] lowBits = pictureCreateCroppedHiBD.getLowBits();
        if (lowBits != null) {
            for (int i4 = 0; i4 < Math.min(pictureHiBD.getData().length, pictureCreateCroppedHiBD.getData().length); i4++) {
                for (int i5 = 0; i5 < Math.min(pictureHiBD.getData()[i4].length, pictureCreateCroppedHiBD.getData()[i4].length); i5++) {
                    int i6 = pictureHiBD.getData()[i4][i5];
                    lowBits[i4][i5] = (byte) (i6 - (MathUtil.clip((i6 + i) >> bitDepth, 0, 255) << 2));
                }
            }
        }
        return pictureCreateCroppedHiBD;
    }

    private boolean planeEquals(Picture picture, int i) {
        ColorSpace colorSpace = this.color;
        int i2 = colorSpace.compWidth[i];
        int i3 = colorSpace.compHeight[i];
        int x = picture.getCrop() == null ? 0 : (picture.getCrop().getX() >> i2) + ((picture.getCrop().getY() >> i3) * (picture.getWidth() >> i2));
        Rect rect = this.crop;
        int x2 = rect == null ? 0 : (rect.getX() >> i2) + ((this.crop.getY() >> i3) * (this.width >> i2));
        byte[] planeData = picture.getPlaneData(i);
        int i4 = 0;
        while (i4 < (getCroppedHeight() >> i3)) {
            for (int i5 = 0; i5 < (getCroppedWidth() >> i2); i5++) {
                if (planeData[x + i5] != this.data[i][x2 + i5]) {
                    return false;
                }
            }
            i4++;
            x += picture.getWidth() >> i2;
            x2 += this.width >> i2;
        }
        return true;
    }

    private void setLowBits(byte[][] bArr) {
        this.lowBits = bArr;
    }

    private void setLowBitsNum(int i) {
        this.lowBitsNum = i;
    }

    private PictureHiBD toPictureHiBDInternal(PictureHiBD pictureHiBD) {
        int[][] data = pictureHiBD.getData();
        for (int i = 0; i < this.data.length; i++) {
            int planeWidth = getPlaneWidth(i) * getPlaneHeight(i);
            for (int i2 = 0; i2 < planeWidth; i2++) {
                data[i][i2] = (this.data[i][i2] + BER.ASN_LONG_LEN) << this.lowBitsNum;
            }
        }
        if (this.lowBits != null) {
            for (int i3 = 0; i3 < this.lowBits.length; i3++) {
                int planeWidth2 = getPlaneWidth(i3) * getPlaneHeight(i3);
                for (int i4 = 0; i4 < planeWidth2; i4++) {
                    int[] iArr = data[i3];
                    iArr[i4] = iArr[i4] + this.lowBits[i3][i4];
                }
            }
        }
        return pictureHiBD;
    }

    public Picture cloneCropped() {
        if (cropNeeded()) {
            return cropped();
        }
        Picture pictureCreateCompatible = createCompatible();
        pictureCreateCompatible.copyFrom(this);
        return pictureCreateCompatible;
    }

    public boolean compatible(Picture picture) {
        return picture.color == this.color && picture.width == this.width && picture.height == this.height;
    }

    public void copyFrom(Picture picture) {
        if (!compatible(picture)) {
            throw new IllegalArgumentException("Can not copy to incompatible picture");
        }
        int i = 0;
        while (true) {
            ColorSpace colorSpace = this.color;
            if (i >= colorSpace.nComp) {
                return;
            }
            byte[] bArr = this.data[i];
            if (bArr != null) {
                System.arraycopy(picture.data[i], 0, bArr, 0, (this.width >> colorSpace.compWidth[i]) * (this.height >> colorSpace.compHeight[i]));
            }
            i++;
        }
    }

    public Picture createCompatible() {
        return create(this.width, this.height, this.color);
    }

    public boolean cropNeeded() {
        Rect rect = this.crop;
        return (rect == null || (rect.getX() == 0 && this.crop.getY() == 0 && this.crop.getWidth() == this.width && this.crop.getHeight() == this.height)) ? false : true;
    }

    public Picture cropped() {
        if (!cropNeeded()) {
            return this;
        }
        Picture pictureCreate = create(this.crop.getWidth(), this.crop.getHeight(), this.color);
        int i = 0;
        if (this.color.planar) {
            while (true) {
                byte[][] bArr = this.data;
                if (i >= bArr.length) {
                    break;
                }
                byte[] bArr2 = bArr[i];
                if (bArr2 != null) {
                    int x = this.crop.getX() >> this.color.compWidth[i];
                    int y = this.crop.getY() >> this.color.compHeight[i];
                    int width = this.crop.getWidth() >> this.color.compWidth[i];
                    int height = this.crop.getHeight();
                    ColorSpace colorSpace = this.color;
                    cropSub(bArr2, x, y, width, height >> colorSpace.compHeight[i], this.width >> colorSpace.compWidth[i], this.crop.getWidth() >> this.color.compWidth[i], pictureCreate.data[i]);
                }
                i++;
            }
        } else {
            cropSub(this.data[0], this.crop.getX(), this.crop.getY(), this.crop.getWidth(), this.crop.getHeight(), this.width * this.color.nComp, this.crop.getWidth() * this.color.nComp, pictureCreate.data[0]);
        }
        return pictureCreate;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Picture)) {
            Picture picture = (Picture) obj;
            if (picture.getCroppedWidth() == getCroppedWidth() && picture.getCroppedHeight() == getCroppedHeight() && picture.getColor() == this.color) {
                for (int i = 0; i < getData().length; i++) {
                    if (!planeEquals(picture, i)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public void fill(int i) {
        int i2 = 0;
        while (true) {
            byte[][] bArr = this.data;
            if (i2 >= bArr.length) {
                return;
            }
            Arrays.fill(bArr[i2], (byte) i);
            i2++;
        }
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

    public byte[][] getData() {
        return this.data;
    }

    public int getHeight() {
        return this.height;
    }

    public byte[][] getLowBits() {
        return this.lowBits;
    }

    public int getLowBitsNum() {
        return this.lowBitsNum;
    }

    public byte[] getPlaneData(int i) {
        return this.data[i];
    }

    public int getPlaneHeight(int i) {
        return this.height >> this.color.compHeight[i];
    }

    public int getPlaneWidth(int i) {
        return this.width >> this.color.compWidth[i];
    }

    public Size getSize() {
        return new Size(this.width, this.height);
    }

    public int getStartX() {
        Rect rect = this.crop;
        if (rect == null) {
            return 0;
        }
        return rect.getX();
    }

    public int getStartY() {
        Rect rect = this.crop;
        if (rect == null) {
            return 0;
        }
        return rect.getY();
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isHiBD() {
        return this.lowBits != null;
    }

    public void setCrop(Rect rect) {
        this.crop = rect;
    }

    public PictureHiBD toPictureHiBD() {
        return toPictureHiBDInternal(PictureHiBD.doCreate(this.width, this.height, this.color, this.lowBitsNum + 8, this.crop));
    }

    public PictureHiBD toPictureHiBDWithBuffer(int[][] iArr) {
        return toPictureHiBDInternal(new PictureHiBD(this.width, this.height, iArr, this.color, this.lowBitsNum + 8, this.crop));
    }
}
