package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import defpackage.C2579;
import defpackage.C3444;
import defpackage.C4008;
import defpackage.C4792;
import defpackage.l5;

/* loaded from: classes.dex */
public class CameraCoverRatioView extends View {

    /* renamed from: ޟ, reason: contains not printable characters */
    public static float f2000 = 1.0f;

    /* renamed from: ԫ, reason: contains not printable characters */
    public Paint f2001;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f2002;

    /* renamed from: ԭ, reason: contains not printable characters */
    public Paint f2003;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f2004;

    /* renamed from: ԯ, reason: contains not printable characters */
    public int f2005;

    /* renamed from: ՠ, reason: contains not printable characters */
    public int f2006;

    /* renamed from: ֈ, reason: contains not printable characters */
    public int f2007;

    /* renamed from: ֏, reason: contains not printable characters */
    public int f2008;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f2009;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f2010;

    /* renamed from: ހ, reason: contains not printable characters */
    public float[] f2011;

    /* renamed from: ށ, reason: contains not printable characters */
    public float[] f2012;

    /* renamed from: ނ, reason: contains not printable characters */
    public Paint f2013;

    /* renamed from: ރ, reason: contains not printable characters */
    public int f2014;

    /* renamed from: ބ, reason: contains not printable characters */
    public int f2015;

    /* renamed from: ޅ, reason: contains not printable characters */
    public int f2016;

    /* renamed from: ކ, reason: contains not printable characters */
    public int f2017;

    /* renamed from: އ, reason: contains not printable characters */
    public int f2018;

    /* renamed from: ވ, reason: contains not printable characters */
    public int f2019;

    /* renamed from: މ, reason: contains not printable characters */
    public boolean f2020;

    /* renamed from: ފ, reason: contains not printable characters */
    public boolean f2021;

    /* renamed from: ދ, reason: contains not printable characters */
    public float[] f2022;

    /* renamed from: ތ, reason: contains not printable characters */
    public float f2023;

    /* renamed from: ލ, reason: contains not printable characters */
    public boolean f2024;

    /* renamed from: ގ, reason: contains not printable characters */
    public boolean f2025;

    /* renamed from: ޏ, reason: contains not printable characters */
    public boolean f2026;

    /* renamed from: ސ, reason: contains not printable characters */
    public int f2027;

    /* renamed from: ޑ, reason: contains not printable characters */
    public int f2028;

    /* renamed from: ޒ, reason: contains not printable characters */
    public boolean f2029;

    /* renamed from: ޓ, reason: contains not printable characters */
    public int f2030;

    /* renamed from: ޔ, reason: contains not printable characters */
    public int f2031;

    /* renamed from: ޕ, reason: contains not printable characters */
    public boolean f2032;

    /* renamed from: ޖ, reason: contains not printable characters */
    public boolean f2033;

    /* renamed from: ޗ, reason: contains not printable characters */
    public float f2034;

    /* renamed from: ޘ, reason: contains not printable characters */
    public boolean f2035;

    /* renamed from: ޙ, reason: contains not printable characters */
    public boolean f2036;

    /* renamed from: ޚ, reason: contains not printable characters */
    public boolean f2037;

    /* renamed from: ޛ, reason: contains not printable characters */
    public boolean f2038;

    /* renamed from: ޜ, reason: contains not printable characters */
    public int f2039;

    /* renamed from: ޝ, reason: contains not printable characters */
    public int f2040;

    /* renamed from: ޞ, reason: contains not printable characters */
    public InterfaceC0875 f2041;

    /* renamed from: com.blink.academy.film.widgets.CameraCoverRatioView$Ϳ, reason: contains not printable characters */
    public class C0873 implements l5 {

        /* renamed from: Ϳ, reason: contains not printable characters */
        public final /* synthetic */ int f2042;

        public C0873(int i) {
            this.f2042 = i;
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
            CameraCoverRatioView.this.f2027 = this.f2042;
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            CameraCoverRatioView.this.f2027 = (int) f;
            CameraCoverRatioView.this.m2207();
            CameraCoverRatioView.this.postInvalidate();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.CameraCoverRatioView$Ԩ, reason: contains not printable characters */
    public class C0874 implements l5 {
        public C0874() {
        }

        @Override // defpackage.l5
        /* renamed from: Ϳ */
        public void mo1305() {
        }

        @Override // defpackage.l5
        /* renamed from: Ԩ */
        public void mo1306() {
        }

        @Override // defpackage.l5
        /* renamed from: ԩ */
        public void mo1307(float f) {
            CameraCoverRatioView.this.f2023 = f;
            float f2 = 1.0f - f;
            CameraCoverRatioView.this.f2018 = (int) ((r4.f2008 * f2) / 2.0f);
            CameraCoverRatioView.this.f2019 = (int) ((r4.f2007 * f2) / 2.0f);
            CameraCoverRatioView.this.f2012 = new float[]{r4.f2014 + CameraCoverRatioView.this.f2018, CameraCoverRatioView.this.f2015 + CameraCoverRatioView.this.f2019, CameraCoverRatioView.this.f2016 - CameraCoverRatioView.this.f2018, CameraCoverRatioView.this.f2015 + CameraCoverRatioView.this.f2019, CameraCoverRatioView.this.f2014 + CameraCoverRatioView.this.f2018, CameraCoverRatioView.this.f2017 - CameraCoverRatioView.this.f2019, CameraCoverRatioView.this.f2016 - CameraCoverRatioView.this.f2018, CameraCoverRatioView.this.f2017 - CameraCoverRatioView.this.f2019, CameraCoverRatioView.this.f2014 + CameraCoverRatioView.this.f2018, CameraCoverRatioView.this.f2015 + CameraCoverRatioView.this.f2019, CameraCoverRatioView.this.f2014 + CameraCoverRatioView.this.f2018, CameraCoverRatioView.this.f2017 - CameraCoverRatioView.this.f2019, CameraCoverRatioView.this.f2016 - CameraCoverRatioView.this.f2018, CameraCoverRatioView.this.f2015 + CameraCoverRatioView.this.f2019, CameraCoverRatioView.this.f2016 - CameraCoverRatioView.this.f2018, CameraCoverRatioView.this.f2017 - CameraCoverRatioView.this.f2019};
            CameraCoverRatioView.this.postInvalidate();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.CameraCoverRatioView$Ԫ, reason: contains not printable characters */
    public interface InterfaceC0875 {
    }

    public CameraCoverRatioView(Context context) {
        this(context, null);
    }

    public float getRatio() {
        int i;
        int i2 = this.f2039;
        if (i2 == 0 || (i = this.f2040) == 0) {
            return 0.0f;
        }
        return (i2 * 1.0f) / i;
    }

    public float getTargetCameraHeight() {
        return this.f2030;
    }

    public float getTargetCameraWidth() {
        return this.f2031;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f2011 == null) {
            return;
        }
        if (this.f2023 != 1.0f) {
            if (!this.f2037 ? C3444.m11227().m11257() : this.f2038) {
                canvas.drawRect(this.f2014, this.f2015, this.f2016, this.f2012[1], this.f2003);
                float f = this.f2014;
                float[] fArr = this.f2012;
                canvas.drawRect(f, fArr[1], fArr[0], this.f2017, this.f2003);
                float[] fArr2 = this.f2012;
                canvas.drawRect(fArr2[0], fArr2[5], this.f2016, this.f2017, this.f2003);
                float[] fArr3 = this.f2012;
                canvas.drawRect(fArr3[2], fArr3[1], this.f2016, fArr3[5], this.f2003);
            }
            canvas.drawLines(this.f2012, this.f2001);
        }
        if (this.f2021) {
            canvas.drawLines(this.f2022, this.f2001);
        }
        if (this.f2025 || this.f2024) {
            canvas.drawLines(this.f2011, this.f2001);
        }
        m2205(canvas, PorterDuff.Mode.DST_OUT);
    }

    public void setCreateByMonitor(boolean z) {
        this.f2037 = z;
        this.f2001.setStrokeWidth(C2579.m9441());
        this.f2001.setColor(-1);
        this.f2002 = 51;
        this.f2001.setAlpha(51);
    }

    public void setCropAlpha(int i) {
        C4008.m12885(100L, this.f2027, i, new C0873(i));
    }

    public void setCross(boolean z) {
        this.f2021 = z;
        postInvalidate();
    }

    public void setOnDrawFinishListener(InterfaceC0875 interfaceC0875) {
        this.f2041 = interfaceC0875;
    }

    public void setRecordStart(boolean z) {
        boolean zM11256 = C3444.m11227().m11256();
        this.f2032 = false;
        this.f2033 = false;
        if (z) {
            if (this.f2029) {
                this.f2032 = true;
                float f = this.f2034;
                if (f <= 2.37f || f <= 2.76f) {
                    this.f2033 = zM11256;
                }
            } else if (zM11256) {
                this.f2032 = true;
                this.f2033 = true;
            }
        }
        postInvalidate();
    }

    public void setSafeRatio(float f) {
        f2000 = f;
        if (this.f2023 == 0.0f) {
            this.f2023 = 1.0f;
        }
        float f2 = this.f2023;
        if (f2 == f) {
            return;
        }
        C4008.m12880(f2, f, 100L, new C0874());
    }

    public void setShowSafeCover(boolean z) {
        this.f2038 = z;
        postInvalidate();
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m2205(Canvas canvas, PorterDuff.Mode mode) {
        if (!this.f2035 || this.f2027 == 255) {
            if (this.f2036) {
                this.f2026 = true;
                this.f2020 = false;
            }
            int iSaveLayer = canvas.saveLayer(0.0f, 0.0f, this.f2006, this.f2005, this.f2013, 31);
            this.f2013.setColor(ViewCompat.MEASURED_STATE_MASK);
            this.f2013.setAlpha(this.f2027);
            canvas.drawRect(0.0f, 0.0f, this.f2006, this.f2005, this.f2013);
            this.f2013.setXfermode(new PorterDuffXfermode(mode));
            this.f2013.setColor(0);
            this.f2013.setAlpha(255);
            canvas.drawRect(this.f2014, this.f2015, this.f2016, this.f2017, this.f2013);
            if (!this.f2026) {
                if (this.f2020) {
                    if (this.f2029) {
                        if (this.f2005 > this.f2006) {
                            float f = this.f2014;
                            int i = this.f2015;
                            canvas.drawLine(f, i, this.f2016, i, this.f2001);
                            float f2 = this.f2014;
                            int i2 = this.f2017;
                            canvas.drawLine(f2, i2, this.f2016, i2, this.f2001);
                        } else {
                            int i3 = this.f2014;
                            canvas.drawLine(i3, this.f2015, i3, this.f2017, this.f2001);
                            int i4 = this.f2016;
                            canvas.drawLine(i4, this.f2015, i4, this.f2017, this.f2001);
                        }
                    }
                    if (this.f2005 > this.f2006) {
                        int i5 = this.f2014;
                        canvas.drawLine(i5, this.f2015, i5, this.f2017, this.f2001);
                        int i6 = this.f2016;
                        canvas.drawLine(i6, this.f2015, i6, this.f2017, this.f2001);
                    } else {
                        float f3 = this.f2014;
                        int i7 = this.f2015;
                        canvas.drawLine(f3, i7, this.f2016, i7, this.f2001);
                        float f4 = this.f2014;
                        int i8 = this.f2017;
                        canvas.drawLine(f4, i8, this.f2016, i8, this.f2001);
                    }
                } else if (this.f2029) {
                    if (this.f2005 > this.f2006) {
                        int i9 = this.f2014;
                        canvas.drawLine(i9, this.f2015, i9, this.f2017, this.f2001);
                        int i10 = this.f2016;
                        canvas.drawLine(i10, this.f2015, i10, this.f2017, this.f2001);
                    } else {
                        float f5 = this.f2014;
                        int i11 = this.f2015;
                        canvas.drawLine(f5, i11, this.f2016, i11, this.f2001);
                        float f6 = this.f2014;
                        int i12 = this.f2017;
                        canvas.drawLine(f6, i12, this.f2016, i12, this.f2001);
                    }
                } else if (this.f2005 > this.f2006) {
                    float f7 = this.f2014;
                    int i13 = this.f2015;
                    canvas.drawLine(f7, i13, this.f2016, i13, this.f2001);
                    float f8 = this.f2014;
                    int i14 = this.f2017;
                    canvas.drawLine(f8, i14, this.f2016, i14, this.f2001);
                } else {
                    int i15 = this.f2014;
                    canvas.drawLine(i15, this.f2015, i15, this.f2017, this.f2001);
                    int i16 = this.f2016;
                    canvas.drawLine(i16, this.f2015, i16, this.f2017, this.f2001);
                }
            }
            this.f2013.setXfermode(null);
            canvas.restoreToCount(iSaveLayer);
            this.f2039 = this.f2008;
            this.f2040 = this.f2007;
        }
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m2206() {
        Paint paint = new Paint();
        this.f2001 = paint;
        paint.setColor(C4792.m14375().m14417());
        this.f2001.setStrokeWidth(C4792.m14375().m14489());
        Paint paint2 = new Paint();
        this.f2003 = paint2;
        paint2.setColor(ViewCompat.MEASURED_STATE_MASK);
        int iM14413 = C4792.m14375().m14413();
        this.f2004 = iM14413;
        this.f2003.setAlpha(iM14413);
        int iM14414 = C3444.m11227().m11256() ? C4792.m14375().m14414() : C4792.m14375().m14413();
        this.f2027 = iM14414;
        this.f2028 = iM14414;
        this.f2013 = new Paint();
        setLayerType(1, null);
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m2207() {
        int i = this.f2008;
        this.f2009 = (int) (i / 3.0f);
        int i2 = this.f2007;
        this.f2010 = (int) (i2 / 3.0f);
        int i3 = this.f2006;
        int i4 = (int) ((i3 - i) / 2.0f);
        int i5 = this.f2005;
        int i6 = (int) ((i5 - i2) / 2.0f);
        this.f2014 = i4;
        this.f2015 = i6;
        int i7 = i3 - i4;
        this.f2016 = i7;
        int i8 = i5 - i6;
        this.f2017 = i8;
        this.f2011 = new float[]{i4, i6 + r3, i7, i6 + r3, i4, (r3 * 2) + i6, i7, (r3 * 2) + i6, i4 + r2, i6, i4 + r2, i8, (r2 * 2) + i4, i6, (r2 * 2) + i4, i8};
        float f = f2000;
        this.f2018 = (int) ((i * (1.0f - f)) / 2.0f);
        this.f2019 = (int) ((i2 * (1.0f - f)) / 2.0f);
        this.f2012 = new float[]{i4 + r1, i6 + r2, i7 - r1, i6 + r2, i4 + r1, i8 - r2, i7 - r1, i8 - r2, i4 + r1, i6 + r2, i4 + r1, i8 - r2, i7 - r1, i6 + r2, i7 - r1, i8 - r2};
        float f2 = (i3 > i5 ? i3 : i5) / 15.0f;
        this.f2022 = new float[]{(i3 - f2) / 2.0f, i5 / 2.0f, (i3 + f2) / 2.0f, i5 / 2.0f, i3 / 2.0f, (i5 - f2) / 2.0f, i3 / 2.0f, (i5 + f2) / 2.0f};
    }

    public CameraCoverRatioView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CameraCoverRatioView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2002 = 255;
        this.f2004 = 255;
        this.f2028 = 255;
        this.f2037 = false;
        this.f2038 = true;
        m2206();
    }
}
