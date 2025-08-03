package defpackage;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import androidx.core.util.Preconditions;
import com.google.mlkit.vision.face.Face;
import com.google.mlkit.vision.face.FaceContour;
import java.util.Arrays;
import java.util.Iterator;
import org.jcodec.codecs.mpeg12.MPEGConst;

/* renamed from: ૐ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4374 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public float[] f15038;

    /* renamed from: Ԩ, reason: contains not printable characters */
    public float[] f15039;

    /* renamed from: ԩ, reason: contains not printable characters */
    public float[] f15040;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public float[] f15041;

    /* renamed from: ԫ, reason: contains not printable characters */
    public float[] f15042;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public C4376 f15043;

    /* renamed from: ԭ, reason: contains not printable characters */
    public C4376 f15044;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4376 f15045;

    /* renamed from: ԯ, reason: contains not printable characters */
    public C4376 f15046;

    /* renamed from: ՠ, reason: contains not printable characters */
    public C4376 f15047;

    /* renamed from: ֈ, reason: contains not printable characters */
    public C4376 f15048;

    /* renamed from: ֏, reason: contains not printable characters */
    public boolean f15049 = true;

    /* renamed from: ૐ$Ϳ, reason: contains not printable characters */
    public static class C4375 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public float f15050;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public float f15051;

        public C4375(float f, float f2) {
            this.f15050 = f;
            this.f15051 = f2;
        }

        public String toString() {
            return C4625.m14082("DyIrAz8TGyQOAgtGSEsO") + this.f15050 + C4625.m14082("Yk8UUg==") + this.f15051 + '}';
        }
    }

    /* renamed from: ૐ$Ԩ, reason: contains not printable characters */
    public static class C4376 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public int f15052;

        /* renamed from: Ԩ, reason: contains not printable characters */
        public float f15053;

        /* renamed from: ԩ, reason: contains not printable characters */
        public float f15054;

        /* renamed from: Ԫ, reason: contains not printable characters */
        public float f15055;

        /* renamed from: ԫ, reason: contains not printable characters */
        public float f15056;

        /* renamed from: Ԭ, reason: contains not printable characters */
        public C4375 f15057;

        /* renamed from: ԭ, reason: contains not printable characters */
        public C4375 f15058;

        public String toString() {
            return C4625.m14082("DAoMGiQLJhoHBB5GSkNWcw==") + this.f15052 + C4625.m14082("Yk8fADweUg==") + this.f15053 + C4625.m14082("Yk8EASQXAQcIHxwP") + this.f15054 + C4625.m14082("Yk8eGyIXARMVA1g=") + this.f15055 + C4625.m14082("Yk8MATceCkk=") + this.f15056 + C4625.m14082("Yk8OCj4GCgZc") + this.f15057 + C4625.m14082("Yk8fDjQbAEk=") + this.f15058 + '}';
        }
    }

    @SuppressLint({"RestrictedApi"})
    public C4374(Face face, C4390 c4390, float f, float f2, int i) {
        int iM13584 = c4390.m13584();
        int iM13583 = c4390.m13583();
        int iM135842 = c4390.m13584();
        int iM135832 = c4390.m13583();
        if (i % MPEGConst.SEQUENCE_ERROR_CODE == 90) {
            iM135832 = iM135842;
            iM135842 = iM135832;
        }
        Iterator<FaceContour> it = face.getAllContours().iterator();
        FaceContour faceContour = null;
        FaceContour faceContour2 = null;
        FaceContour faceContour3 = null;
        FaceContour faceContour4 = null;
        FaceContour faceContour5 = null;
        FaceContour faceContour6 = null;
        FaceContour faceContour7 = null;
        while (it.hasNext()) {
            FaceContour next = it.next();
            Iterator<FaceContour> it2 = it;
            int faceContourType = next.getFaceContourType();
            if (faceContourType != 1) {
                if (faceContourType == 6) {
                    faceContour2 = next;
                } else if (faceContourType == 7) {
                    faceContour = next;
                } else if (faceContourType == 9) {
                    faceContour6 = next;
                } else if (faceContourType == 10) {
                    faceContour5 = next;
                } else if (faceContourType == 12) {
                    faceContour4 = next;
                } else if (faceContourType == 13) {
                    faceContour7 = next;
                }
                it = it2;
            } else {
                faceContour3 = next;
                it = it2;
            }
        }
        Preconditions.checkNotNull(faceContour4);
        Preconditions.checkNotNull(faceContour7);
        Preconditions.checkNotNull(faceContour3);
        Preconditions.checkNotNull(faceContour2);
        Preconditions.checkNotNull(faceContour);
        Preconditions.checkNotNull(faceContour6);
        Preconditions.checkNotNull(faceContour5);
        PointF pointF = faceContour4.getPoints().get(0);
        PointF pointF2 = faceContour4.getPoints().get(1);
        C4375 c4375M13534 = m13534(iM135842, iM135832, pointF, i);
        C4375 c4375M135342 = m13534(iM135842, iM135832, pointF2, i);
        FaceContour faceContour8 = faceContour4;
        FaceContour faceContour9 = faceContour5;
        C4375 c4375 = new C4375(c4375M135342.f15050, c4375M135342.f15051);
        float fM13200 = (float) (C4179.m13200(c4375M13534, c4375M135342) - 1.5707963267948966d);
        C4375 c4375M135343 = m13534(iM135842, iM135832, faceContour3.getPoints().get(26), i);
        C4375 c4375M135344 = m13534(iM135842, iM135832, faceContour3.getPoints().get(10), i);
        FaceContour faceContour10 = faceContour6;
        C4375 c4375M135345 = m13534(iM135842, iM135832, faceContour3.getPoints().get(22), i);
        C4375 c4375M135346 = m13534(iM135842, iM135832, faceContour3.getPoints().get(14), i);
        PointF pointF3 = faceContour2.getPoints().get(0);
        FaceContour faceContour11 = faceContour2;
        PointF pointF4 = faceContour2.getPoints().get(8);
        C4375 c4375M135347 = m13534(iM135842, iM135832, pointF3, i);
        C4375 c4375M13535 = m13535(c4375M135347, m13534(iM135842, iM135832, pointF4, i));
        float fM13202 = C4179.m13202(C4625.m14082("IgoLGxULCiY="), c4375M135347, c4375M13535, iM13584, iM13583);
        PointF pointF5 = faceContour.getPoints().get(0);
        FaceContour faceContour12 = faceContour;
        PointF pointF6 = faceContour.getPoints().get(8);
        C4375 c4375M135348 = m13534(iM135842, iM135832, pointF5, i);
        C4375 c4375M135352 = m13535(c4375M135348, m13534(iM135842, iM135832, pointF6, i));
        float fM132022 = C4179.m13202(C4625.m14082("PAYKByQ3FhEz"), c4375M135348, c4375M135352, iM13584, iM13583);
        float fM132023 = C4179.m13202(C4625.m14082("LQcEARwXCQAz"), c4375M135343, c4375M135344, iM13584, iM13583) / 2.0f;
        float fM132024 = C4179.m13202(C4625.m14082("LQcEAQIbCBwVOQ=="), c4375M135343, c4375M135344, iM13584, iM13583) / 2.0f;
        int i2 = iM135842;
        float fM132025 = C4179.m13202(C4625.m14082("IgoLGwAXHRcEBRE="), c4375M135343, c4375, iM13584, iM13583);
        int i3 = iM135832;
        float fM132026 = C4179.m13202(C4625.m14082("PAYKByQiCgYCDgtG"), c4375M135344, c4375, iM13584, iM13583);
        float f3 = fM132023 * 0.05f;
        float fMax = (f3 * fM132025) / Math.max(fM132025, fM132026);
        float f4 = 0.05f * fM132024;
        float fMax2 = (f4 * fM132026) / Math.max(fM132025, fM132026);
        float fMax3 = ((f3 * 0.85f) * fM132025) / Math.max(fM132025, fM132026);
        float fMax4 = ((f4 * 0.85f) * fM132026) / Math.max(fM132025, fM132026);
        C4376 c4376 = new C4376();
        c4376.f15052 = 2;
        c4376.f15053 = fM13200;
        c4376.f15054 = f;
        c4376.f15055 = fMax3;
        c4376.f15056 = C4179.m13200(c4375M135343, c4375);
        c4376.f15057 = c4375M135343;
        c4376.f15058 = m13533(fM132023, fM132023);
        this.f15043 = c4376;
        C4376 c43762 = new C4376();
        c43762.f15052 = 2;
        c43762.f15053 = fM13200;
        c43762.f15054 = f;
        c43762.f15055 = fMax4;
        c43762.f15056 = C4179.m13200(c4375M135344, c4375);
        c43762.f15057 = c4375M135344;
        c43762.f15058 = m13533(fM132024, fM132024);
        this.f15044 = c43762;
        C4376 c43763 = new C4376();
        c43763.f15052 = 2;
        c43763.f15053 = fM13200;
        c43763.f15054 = f;
        c43763.f15055 = fMax;
        c43763.f15056 = C4179.m13200(c4375M135345, c4375);
        c43763.f15057 = c4375M135345;
        c43763.f15058 = m13533(fM132023, fM132023);
        this.f15045 = c43763;
        C4376 c43764 = new C4376();
        c43764.f15052 = 2;
        c43764.f15053 = fM13200;
        c43764.f15054 = f;
        c43764.f15055 = fMax2;
        c43764.f15056 = C4179.m13200(c4375M135346, c4375);
        c43764.f15057 = c4375M135346;
        c43764.f15058 = m13533(fM132024, fM132024);
        this.f15046 = c43764;
        C4376 c43765 = new C4376();
        c43765.f15052 = 1;
        c43765.f15053 = fM13200;
        c43765.f15054 = f2;
        c43765.f15055 = 0.23f;
        c43765.f15056 = 0.0f;
        c43765.f15057 = c4375M13535;
        c43765.f15058 = m13533(fM13202, fM13202);
        this.f15047 = c43765;
        C4376 c43766 = new C4376();
        c43766.f15052 = 1;
        c43766.f15053 = fM13200;
        c43766.f15054 = f2;
        c43766.f15055 = 0.23f;
        c43766.f15056 = 0.0f;
        c43766.f15057 = c4375M135352;
        c43766.f15058 = m13533(fM132022, fM132022);
        this.f15048 = c43766;
        this.f15038 = new float[36];
        int[] iArr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] iArr2 = {8, 7, 6, 5, 4, 3, 2, 1, 0};
        int i4 = 0;
        for (int i5 = 9; i4 < i5; i5 = 9) {
            int i6 = iArr[i4];
            int i7 = iArr2[i4];
            PointF pointF7 = faceContour10.getPoints().get(i6);
            PointF pointF8 = faceContour9.getPoints().get(i7);
            C4375 c4375M135349 = m13534(i2, i3, pointF7, i);
            C4375 c4375M1353410 = m13534(i2, i3, pointF8, i);
            float[] fArr = this.f15038;
            int i8 = i4 * 4;
            fArr[i8 + 0] = (c4375M135349.f15050 * 2.0f) - 1.0f;
            fArr[i8 + 1] = 1.0f - (c4375M135349.f15051 * 2.0f);
            fArr[i8 + 2] = (c4375M1353410.f15050 * 2.0f) - 1.0f;
            fArr[i8 + 3] = 1.0f - (c4375M1353410.f15051 * 2.0f);
            i4++;
        }
        this.f15039 = new float[32];
        int[] iArr3 = {0, 1, 15, 2, 14, 3, 13, 4, 12, 5, 11, 6, 10, 7, 9, 8};
        for (int i9 = 0; i9 < 16; i9++) {
            C4375 c4375M1353411 = m13534(i2, i3, faceContour11.getPoints().get(iArr3[i9]), i);
            float[] fArr2 = this.f15039;
            int i10 = i9 * 2;
            fArr2[i10 + 0] = (c4375M1353411.f15050 * 2.0f) - 1.0f;
            fArr2[i10 + 1] = 1.0f - (c4375M1353411.f15051 * 2.0f);
        }
        this.f15040 = new float[32];
        int[] iArr4 = {0, 15, 1, 14, 2, 13, 3, 12, 4, 11, 5, 10, 6, 9, 7, 8};
        for (int i11 = 0; i11 < 16; i11++) {
            C4375 c4375M1353412 = m13534(i2, i3, faceContour12.getPoints().get(iArr4[i11]), i);
            float[] fArr3 = this.f15040;
            int i12 = i11 * 2;
            fArr3[i12 + 0] = (c4375M1353412.f15050 * 2.0f) - 1.0f;
            fArr3[i12 + 1] = 1.0f - (c4375M1353412.f15051 * 2.0f);
        }
        this.f15041 = new float[8];
        C4375 c4375M1353413 = m13534(i2, i3, faceContour11.getPoints().get(0), i);
        float[] fArr4 = this.f15041;
        fArr4[4] = (c4375M1353413.f15050 * 2.0f) - 1.0f;
        fArr4[5] = 1.0f - (c4375M1353413.f15051 * 2.0f);
        C4375 c4375M1353414 = m13534(i2, i3, faceContour8.getPoints().get(0), i);
        float[] fArr5 = this.f15041;
        fArr5[6] = (c4375M1353414.f15050 * 2.0f) - 1.0f;
        fArr5[7] = 1.0f - (c4375M1353414.f15051 * 2.0f);
        C4375 c4375M1353415 = m13534(i2, i3, faceContour7.getPoints().get(0), i);
        float[] fArr6 = this.f15041;
        float f5 = (c4375M1353415.f15050 * 2.0f) - 1.0f;
        fArr6[2] = f5;
        float f6 = 1.0f - (c4375M1353415.f15051 * 2.0f);
        fArr6[3] = f6;
        fArr6[0] = (f5 + fArr6[4]) - fArr6[6];
        fArr6[1] = (f6 + fArr6[5]) - fArr6[7];
        this.f15042 = new float[8];
        C4375 c4375M1353416 = m13534(i2, i3, faceContour12.getPoints().get(8), i);
        float[] fArr7 = this.f15042;
        fArr7[4] = (c4375M1353416.f15050 * 2.0f) - 1.0f;
        fArr7[5] = 1.0f - (c4375M1353416.f15051 * 2.0f);
        C4375 c4375M1353417 = m13534(i2, i3, faceContour8.getPoints().get(0), i);
        float[] fArr8 = this.f15042;
        fArr8[6] = (c4375M1353417.f15050 * 2.0f) - 1.0f;
        fArr8[7] = 1.0f - (c4375M1353417.f15051 * 2.0f);
        C4375 c4375M1353418 = m13534(i2, i3, faceContour7.getPoints().get(2), i);
        float[] fArr9 = this.f15042;
        float f7 = (c4375M1353418.f15050 * 2.0f) - 1.0f;
        fArr9[2] = f7;
        float f8 = 1.0f - (c4375M1353418.f15051 * 2.0f);
        fArr9[3] = f8;
        fArr9[0] = (f7 + fArr9[4]) - fArr9[6];
        fArr9[1] = (f8 + fArr9[5]) - fArr9[7];
    }

    public String toString() {
        return C4625.m14082("DyIrDjMXFBkOHhFad1JHL1I=") + Arrays.toString(this.f15038) + C4625.m14082("Yk8BCjYGKg0ELwRGUg4=") + Arrays.toString(this.f15039) + C4625.m14082("Yk8fBjcaGzEYDiFTR1IO") + Arrays.toString(this.f15040) + C4625.m14082("Yk8BCjYGKjYlChFTDg==") + Arrays.toString(this.f15041) + C4625.m14082("Yk8fBjcaGzEjLwRGUg4=") + Arrays.toString(this.f15042) + C4625.m14082("Yk8BCjYGKRUCDixcVVwO") + this.f15043 + C4625.m14082("Yk8fBjcaGzIACAB7XVVccw==") + this.f15044 + C4625.m14082("Yk8BCjYGLBwIBSxcVVwO") + this.f15045 + C4625.m14082("Yk8fBjcaGzcJAgt7XVVccw==") + this.f15046 + C4625.m14082("Yk8BCjYGKg0EIgtUXA4=") + this.f15047 + C4625.m14082("Yk8fBjcaGzEYDixcVVwO") + this.f15048 + '}';
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public float[] m13532() {
        return this.f15040;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final C4375 m13533(float f, float f2) {
        return new C4375(f, f2);
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public final C4375 m13534(int i, int i2, PointF pointF, int i3) {
        float f = pointF.x / i;
        float f2 = pointF.y / i2;
        return i3 == 0 ? new C4375(f, f2) : i3 == 90 ? new C4375(f2, 1.0f - f) : i3 == 180 ? new C4375(1.0f - f, 1.0f - f2) : i3 == 270 ? new C4375(1.0f - f2, f) : new C4375(f, f2);
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public final C4375 m13535(C4375 c4375, C4375 c43752) {
        return new C4375((c4375.f15050 + c43752.f15050) / 2.0f, (c4375.f15051 + c43752.f15051) / 2.0f);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public C4376 m13536() {
        return this.f15045;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float[] m13537() {
        return this.f15041;
    }

    /* renamed from: ԭ, reason: contains not printable characters */
    public float[] m13538() {
        return this.f15039;
    }

    /* renamed from: Ԯ, reason: contains not printable characters */
    public C4376 m13539() {
        return this.f15047;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public float[] m13540() {
        return this.f15038;
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public C4376 m13541() {
        return this.f15043;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public C4376 m13542() {
        return this.f15046;
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public float[] m13543() {
        return this.f15042;
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public C4376 m13544() {
        return this.f15048;
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public C4376 m13545() {
        return this.f15044;
    }
}
