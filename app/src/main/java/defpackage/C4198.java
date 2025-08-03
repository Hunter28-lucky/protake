package defpackage;

import android.graphics.Point;
import android.graphics.PointF;
import android.opengl.GLES20;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

/* compiled from: GPUImageToneCurveFilter.java */
/* renamed from: র, reason: contains not printable characters */
/* loaded from: classes2.dex */
public class C4198 extends C4327 {

    /* renamed from: ބ, reason: contains not printable characters */
    public int[] f14473;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f14474;

    /* renamed from: ކ, reason: contains not printable characters */
    public PointF[] f14475;

    /* renamed from: އ, reason: contains not printable characters */
    public PointF[] f14476;

    /* renamed from: ވ, reason: contains not printable characters */
    public PointF[] f14477;

    /* renamed from: މ, reason: contains not printable characters */
    public PointF[] f14478;

    /* renamed from: ފ, reason: contains not printable characters */
    public ArrayList<Float> f14479;

    /* renamed from: ދ, reason: contains not printable characters */
    public ArrayList<Float> f14480;

    /* renamed from: ތ, reason: contains not printable characters */
    public ArrayList<Float> f14481;

    /* renamed from: ލ, reason: contains not printable characters */
    public ArrayList<Float> f14482;

    /* compiled from: GPUImageToneCurveFilter.java */
    /* renamed from: র$Ϳ, reason: contains not printable characters */
    public class RunnableC4199 implements Runnable {
        public RunnableC4199() {
        }

        @Override // java.lang.Runnable
        public void run() {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, C4198.this.f14473[0]);
            if (C4198.this.f14480.size() < 256 || C4198.this.f14481.size() < 256 || C4198.this.f14482.size() < 256 || C4198.this.f14479.size() < 256) {
                return;
            }
            byte[] bArr = new byte[1024];
            for (int i = 0; i < 256; i++) {
                int i2 = i * 4;
                float f = i;
                bArr[i2 + 2] = (byte) (((int) Math.min(Math.max(((Float) C4198.this.f14482.get(i)).floatValue() + f + ((Float) C4198.this.f14479.get(i)).floatValue(), 0.0f), 255.0f)) & 255);
                bArr[i2 + 1] = (byte) (((int) Math.min(Math.max(((Float) C4198.this.f14481.get(i)).floatValue() + f + ((Float) C4198.this.f14479.get(i)).floatValue(), 0.0f), 255.0f)) & 255);
                bArr[i2] = (byte) (((int) Math.min(Math.max(f + ((Float) C4198.this.f14480.get(i)).floatValue() + ((Float) C4198.this.f14479.get(i)).floatValue(), 0.0f), 255.0f)) & 255);
                bArr[i2 + 3] = -1;
            }
            GLES20.glTexImage2D(3553, 0, 6408, 256, 1, 0, 6408, 5121, ByteBuffer.wrap(bArr));
        }
    }

    /* compiled from: GPUImageToneCurveFilter.java */
    /* renamed from: র$Ԩ, reason: contains not printable characters */
    public class C4200 implements Comparator<PointF> {
        public C4200() {
        }

        @Override // java.util.Comparator
        /* renamed from: Ϳ, reason: contains not printable characters and merged with bridge method [inline-methods] */
        public int compare(PointF pointF, PointF pointF2) {
            float f = pointF.x;
            float f2 = pointF2.x;
            if (f < f2) {
                return -1;
            }
            return f > f2 ? 1 : 0;
        }
    }

    public C4198() {
        super("attribute vec4 position;\nattribute vec4 inputTextureCoordinate;\n \nvarying vec2 textureCoordinate;\n \nvoid main()\n{\n    gl_Position = position;\n    textureCoordinate = inputTextureCoordinate.xy;\n}", " varying highp vec2 textureCoordinate;\n uniform sampler2D inputImageTexture;\n uniform sampler2D toneCurveTexture;\n\n void main()\n {\n     lowp vec4 textureColor = texture2D(inputImageTexture, textureCoordinate);\n     lowp float redCurveValue = texture2D(toneCurveTexture, vec2(textureColor.r, 0.0)).r;\n     lowp float greenCurveValue = texture2D(toneCurveTexture, vec2(textureColor.g, 0.0)).g;\n     lowp float blueCurveValue = texture2D(toneCurveTexture, vec2(textureColor.b, 0.0)).b;\n\n     gl_FragColor = vec4(redCurveValue, greenCurveValue, blueCurveValue, textureColor.a);\n }");
        this.f14473 = new int[]{-1};
        this.f14474 = m13476("toneCurveTexture");
        PointF[] pointFArr = {new PointF(0.0f, 0.0f), new PointF(0.5f, 0.5f), new PointF(1.0f, 1.0f)};
        this.f14475 = pointFArr;
        this.f14476 = pointFArr;
        this.f14477 = pointFArr;
        this.f14478 = pointFArr;
    }

    @Override // defpackage.C4327
    /* renamed from: ؠ */
    public void mo10879() {
        if (this.f14473[0] != -1) {
            GLES20.glActiveTexture(33987);
            GLES20.glBindTexture(3553, this.f14473[0]);
            GLES20.glUniform1i(m13474(this.f14474), 3);
        }
    }

    @Override // defpackage.C4327
    /* renamed from: ހ */
    public void mo8361() {
        super.mo8361();
        GLES20.glActiveTexture(33987);
        GLES20.glGenTextures(1, this.f14473, 0);
        GLES20.glBindTexture(3553, this.f14473[0]);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
    }

    @Override // defpackage.C4327
    /* renamed from: ށ */
    public void mo9737() {
        super.mo9737();
        m13267(this.f14475);
        m13266(this.f14476);
        m13265(this.f14477);
        m13264(this.f14478);
    }

    /* renamed from: ޏ, reason: contains not printable characters */
    public final ArrayList<Double> m13261(Point[] pointArr) {
        int i;
        int length = pointArr.length;
        char c = 1;
        if (length <= 1) {
            return null;
        }
        char c2 = 0;
        double[][] dArr = (double[][]) Array.newInstance((Class<?>) Double.TYPE, length, 3);
        double[] dArr2 = new double[length];
        double[] dArr3 = dArr[0];
        dArr3[1] = 1.0d;
        double d = 0.0d;
        dArr3[0] = 0.0d;
        dArr3[2] = 0.0d;
        int i2 = 1;
        while (true) {
            i = length - 1;
            if (i2 >= i) {
                break;
            }
            Point point = pointArr[i2 - 1];
            Point point2 = pointArr[i2];
            int i3 = i2 + 1;
            Point point3 = pointArr[i3];
            double[] dArr4 = dArr[i2];
            int i4 = point2.x;
            int i5 = point.x;
            dArr4[c2] = (i4 - i5) / 6.0d;
            int i6 = point3.x;
            dArr4[c] = (i6 - i5) / 3.0d;
            dArr4[2] = (i6 - i4) / 6.0d;
            int i7 = point3.y;
            int i8 = point2.y;
            dArr2[i2] = ((i7 - i8) / (i6 - i4)) - ((i8 - point.y) / (i4 - i5));
            i2 = i3;
            c = 1;
            c2 = 0;
            d = 0.0d;
        }
        char c3 = c2;
        double d2 = d;
        dArr2[c3] = d2;
        dArr2[i] = d2;
        double[] dArr5 = dArr[i];
        char c4 = 1;
        dArr5[1] = 1.0d;
        dArr5[c3] = d2;
        char c5 = 2;
        dArr5[2] = d2;
        int i9 = 1;
        while (i9 < length) {
            double[] dArr6 = dArr[i9];
            double d3 = dArr6[c3];
            int i10 = i9 - 1;
            double[] dArr7 = dArr[i10];
            double d4 = d3 / dArr7[c4];
            dArr6[c4] = dArr6[c4] - (dArr7[c5] * d4);
            dArr6[c3] = 0.0d;
            dArr2[i9] = dArr2[i9] - (d4 * dArr2[i10]);
            i9++;
            c3 = 0;
            c5 = 2;
            c4 = 1;
        }
        for (int i11 = length - 2; i11 >= 0; i11--) {
            double[] dArr8 = dArr[i11];
            double d5 = dArr8[2];
            int i12 = i11 + 1;
            double[] dArr9 = dArr[i12];
            double d6 = d5 / dArr9[1];
            dArr8[1] = dArr8[1] - (dArr9[0] * d6);
            dArr8[2] = 0.0d;
            dArr2[i11] = dArr2[i11] - (d6 * dArr2[i12]);
        }
        ArrayList<Double> arrayList = new ArrayList<>(length);
        for (int i13 = 0; i13 < length; i13++) {
            arrayList.add(Double.valueOf(dArr2[i13] / dArr[i13][1]));
        }
        return arrayList;
    }

    /* renamed from: ސ, reason: contains not printable characters */
    public final ArrayList<Float> m13262(PointF[] pointFArr) {
        if (pointFArr == null || pointFArr.length <= 0) {
            return null;
        }
        PointF[] pointFArr2 = (PointF[]) pointFArr.clone();
        Arrays.sort(pointFArr2, new C4200());
        Point[] pointArr = new Point[pointFArr2.length];
        for (int i = 0; i < pointFArr.length; i++) {
            PointF pointF = pointFArr2[i];
            pointArr[i] = new Point((int) (pointF.x * 255.0f), (int) (pointF.y * 255.0f));
        }
        ArrayList<Point> arrayListM13263 = m13263(pointArr);
        int i2 = arrayListM13263.get(0).x;
        if (i2 > 0) {
            while (i2 >= 0) {
                arrayListM13263.add(0, new Point(i2, 0));
                i2--;
            }
        }
        int i3 = arrayListM13263.get(arrayListM13263.size() - 1).x;
        if (i3 < 255) {
            while (true) {
                i3++;
                if (i3 > 255) {
                    break;
                }
                arrayListM13263.add(new Point(i3, 255));
            }
        }
        ArrayList<Float> arrayList = new ArrayList<>(arrayListM13263.size());
        Iterator<Point> it = arrayListM13263.iterator();
        while (it.hasNext()) {
            Point next = it.next();
            int i4 = next.x;
            Point point = new Point(i4, i4);
            float fSqrt = (float) Math.sqrt(Math.pow(point.x - next.x, 2.0d) + Math.pow(point.y - next.y, 2.0d));
            if (point.y > next.y) {
                fSqrt = -fSqrt;
            }
            arrayList.add(Float.valueOf(fSqrt));
        }
        return arrayList;
    }

    /* renamed from: ޑ, reason: contains not printable characters */
    public final ArrayList<Point> m13263(Point[] pointArr) {
        Point[] pointArr2 = pointArr;
        ArrayList<Double> arrayListM13261 = m13261(pointArr);
        int size = arrayListM13261.size();
        if (size < 1) {
            return null;
        }
        double[] dArr = new double[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            dArr[i2] = arrayListM13261.get(i2).doubleValue();
        }
        ArrayList<Point> arrayList = new ArrayList<>(size + 1);
        while (i < size - 1) {
            Point point = pointArr2[i];
            int i3 = i + 1;
            Point point2 = pointArr2[i3];
            int i4 = point.x;
            while (true) {
                int i5 = point2.x;
                if (i4 < i5) {
                    double d = (i4 - r11) / (i5 - r11);
                    double d2 = 1.0d - d;
                    double d3 = i5 - point.x;
                    int i6 = size;
                    Point point3 = point;
                    ArrayList<Point> arrayList2 = arrayList;
                    double d4 = (point.y * d2) + (point2.y * d) + (((d3 * d3) / 6.0d) * (((((d2 * d2) * d2) - d2) * dArr[i]) + ((((d * d) * d) - d) * dArr[i3])));
                    if (d4 > 255.0d) {
                        d4 = 255.0d;
                    } else if (d4 < 0.0d) {
                        d4 = 0.0d;
                    }
                    arrayList = arrayList2;
                    arrayList.add(new Point(i4, (int) Math.round(d4)));
                    i4++;
                    size = i6;
                    point = point3;
                }
            }
            pointArr2 = pointArr;
            i = i3;
        }
        if (arrayList.size() == 255) {
            arrayList.add(pointArr[pointArr.length - 1]);
        }
        return arrayList;
    }

    /* renamed from: ޒ, reason: contains not printable characters */
    public void m13264(PointF[] pointFArr) {
        this.f14478 = pointFArr;
        this.f14482 = m13262(pointFArr);
        m13268();
    }

    /* renamed from: ޓ, reason: contains not printable characters */
    public void m13265(PointF[] pointFArr) {
        this.f14477 = pointFArr;
        this.f14481 = m13262(pointFArr);
        m13268();
    }

    /* renamed from: ޔ, reason: contains not printable characters */
    public void m13266(PointF[] pointFArr) {
        this.f14476 = pointFArr;
        this.f14480 = m13262(pointFArr);
        m13268();
    }

    /* renamed from: ޕ, reason: contains not printable characters */
    public void m13267(PointF[] pointFArr) {
        this.f14475 = pointFArr;
        this.f14479 = m13262(pointFArr);
        m13268();
    }

    /* renamed from: ޖ, reason: contains not printable characters */
    public final void m13268() {
        m13480(new RunnableC4199());
    }
}
