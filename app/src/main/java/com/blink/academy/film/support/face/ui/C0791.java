package com.blink.academy.film.support.face.ui;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.text.TextPaint;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.support.face.ui.GraphicOverlay;
import defpackage.C2579;
import defpackage.C3483;
import defpackage.C4638;
import defpackage.C4792;

/* compiled from: FaceGraphic.java */
/* renamed from: com.blink.academy.film.support.face.ui.Ԩ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C0791 extends GraphicOverlay.AbstractC0788 {

    /* renamed from: ވ, reason: contains not printable characters */
    public static final String f1576 = "Ԩ";

    /* renamed from: Ԩ, reason: contains not printable characters */
    public boolean f1577;

    /* renamed from: ԩ, reason: contains not printable characters */
    public float f1578;

    /* renamed from: Ԫ, reason: contains not printable characters */
    public float f1579;

    /* renamed from: ԫ, reason: contains not printable characters */
    public float f1580;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f1581;

    /* renamed from: ԭ, reason: contains not printable characters */
    public float f1582;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public int f1583;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f1584;

    /* renamed from: ՠ, reason: contains not printable characters */
    public float f1585;

    /* renamed from: ֈ, reason: contains not printable characters */
    public float f1586;

    /* renamed from: ֏, reason: contains not printable characters */
    public float f1587;

    /* renamed from: ׯ, reason: contains not printable characters */
    public int f1588;

    /* renamed from: ؠ, reason: contains not printable characters */
    public int f1589;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f1590;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f1591;

    /* renamed from: ނ, reason: contains not printable characters */
    public final Paint f1592;

    /* renamed from: ރ, reason: contains not printable characters */
    public volatile C3483 f1593;

    /* renamed from: ބ, reason: contains not printable characters */
    public Path f1594;

    /* renamed from: ޅ, reason: contains not printable characters */
    public Path f1595;

    /* renamed from: ކ, reason: contains not printable characters */
    public Paint f1596;

    /* renamed from: އ, reason: contains not printable characters */
    public final TextPaint f1597;

    public C0791(GraphicOverlay graphicOverlay, C3483 c3483) {
        super(graphicOverlay);
        this.f1577 = false;
        this.f1578 = C4792.m14375().m14471() * 300.0f;
        this.f1579 = C4792.f16138 * C4792.m14375().m14471();
        this.f1580 = C4792.m14375().m14471() * 80.0f;
        this.f1581 = C4792.m14375().m14471() * 32.0f;
        this.f1582 = C2579.m9438(4.0f) * C4792.m14375().m14471();
        this.f1583 = Color.parseColor("#9A000000");
        this.f1584 = C4792.m14375().m14471() * 140.0f;
        this.f1585 = C4792.m14375().m14471() * 24.0f;
        this.f1586 = (C4792.m14375().m14471() * 24.0f) + this.f1579;
        this.f1587 = this.f1585 / 2.0f;
        this.f1588 = Color.parseColor("#BBBBBB");
        this.f1589 = ViewCompat.MEASURED_STATE_MASK;
        this.f1590 = C4792.m14375().m14382();
        this.f1591 = (C4792.m14375().m14471() * 28.0f) + this.f1579;
        this.f1593 = c3483;
        Paint paint = new Paint();
        this.f1596 = paint;
        paint.setColor(-1);
        this.f1596.setStyle(Paint.Style.FILL);
        this.f1596.setShadowLayer(this.f1582, 0.0f, 0.0f, this.f1583);
        this.f1596.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f1592 = paint2;
        paint2.setAntiAlias(true);
        TextPaint textPaint = new TextPaint();
        this.f1597 = textPaint;
        textPaint.setTextAlign(Paint.Align.RIGHT);
        textPaint.setTypeface(FilmApp.m403());
        textPaint.setAntiAlias(true);
        textPaint.setTextSize(this.f1590);
        textPaint.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f1594 = new Path();
        this.f1595 = new Path();
    }

    @Override // com.blink.academy.film.support.face.ui.GraphicOverlay.AbstractC0788
    /* renamed from: Ϳ */
    public void mo1897(Canvas canvas) {
        float f;
        float f2;
        boolean z;
        float f3;
        float f4;
        float f5;
        float f6;
        int i;
        int i2;
        int i3;
        int i4;
        float f7;
        C3483 c3483 = this.f1593;
        if (c3483 == null) {
            return;
        }
        float fM1899 = m1899(c3483.m11337());
        float fM1900 = m1900(c3483.m11338());
        float fMax = Math.max(m1898(c3483.m11343().getWidth()), this.f1578) / 2.0f;
        float f8 = fM1899 - fMax;
        float fMax2 = Math.max(m1898(c3483.m11343().getHeight()), this.f1578) / 2.0f;
        float f9 = this.f1580;
        float f10 = (fM1900 - fMax2) - f9;
        float f11 = fM1899 + fMax;
        float f12 = fMax2 + fM1900;
        if (f10 <= 0.0f) {
            f = f12 + f9;
            f2 = f10 + f9;
            z = true;
        } else {
            f = f12;
            f2 = f10;
            z = false;
        }
        this.f1594.reset();
        float f13 = this.f1581;
        this.f1594.addRoundRect(f8, f2, f11, f, new float[]{f13, f13, f13, f13, f13, f13, f13, f13}, Path.Direction.CW);
        if (z) {
            float f14 = this.f1579;
            f3 = f8 + f14;
            f4 = f2 + f14;
            f6 = f11 - f14;
            f5 = f - this.f1580;
        } else {
            float f15 = this.f1579;
            f3 = f8 + f15;
            f4 = f2 + this.f1580;
            f5 = f - f15;
            f6 = f11 - f15;
        }
        this.f1595.reset();
        float f16 = this.f1581 - this.f1579;
        this.f1595.addRoundRect(f3, f4, f6, f5, z ? new float[]{f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f} : new float[]{0.0f, 0.0f, 0.0f, 0.0f, f16, f16, f16, f16}, Path.Direction.CW);
        this.f1594.op(this.f1595, Path.Op.DIFFERENCE);
        canvas.drawPath(this.f1594, this.f1596);
        if (this.f1577) {
            String str = f1576;
            C4638.m14099(str, String.format("centerX : %s , centerY : %s , size : %s ", Integer.valueOf(c3483.m11337()), Integer.valueOf(c3483.m11338()), c3483.m11343()));
            C4638.m14099(str, String.format("x : %s , y : %s , left : %s , top : %s , right : %s , bottom : %s ", Float.valueOf(fM1899), Float.valueOf(fM1900), Float.valueOf(f8), Float.valueOf(f2), Float.valueOf(f11), Float.valueOf(f)));
            C4638.m14099(str, String.format("x : %s , y : %s , centerLeft : %s , centerTop : %s , centerRight : %s , centerBottom : %s ", Float.valueOf(fM1899), Float.valueOf(fM1900), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f6), Float.valueOf(f5)));
        }
        float f17 = (int) (f8 + this.f1586);
        int i5 = (int) (this.f1584 + f17);
        if (z) {
            float f18 = this.f1580;
            float f19 = this.f1585;
            i2 = (int) (f - ((f18 - f19) / 2.0f));
            i = (int) (i2 - f19);
        } else {
            float f20 = this.f1580;
            float f21 = this.f1585;
            int i6 = (int) (f2 + ((f20 - f21) / 2.0f));
            int i7 = (int) (i6 + f21);
            i = i6;
            i2 = i7;
        }
        this.f1592.setColor(this.f1588);
        float f22 = i;
        float f23 = i2;
        float f24 = this.f1587;
        canvas.drawRoundRect(f17, f22, i5, f23, f24, f24, this.f1592);
        float fM11340 = c3483.m11340();
        if (fM11340 > 0.0f) {
            float f25 = this.f1584;
            int i8 = (int) (f17 + (f25 / 2.0f));
            i4 = (int) ((((fM11340 / 2.0f) * f25) / 2.0f) + i8);
            i3 = i8;
        } else if (fM11340 < 0.0f) {
            float f26 = this.f1584;
            int i9 = (int) (f17 + (f26 / 2.0f));
            i3 = (int) (i9 - (((fM11340 / (-2.0f)) * f26) / 2.0f));
            i4 = i9;
        } else {
            i3 = 0;
            i4 = 0;
        }
        this.f1592.setColor(this.f1589);
        float f27 = this.f1587;
        canvas.drawRoundRect(i3, f22, i4, f23, f27, f27, this.f1592);
        String str2 = fM11340 > 1.0f ? "HI" : fM11340 < -1.0f ? "LO" : "OK";
        Paint.FontMetrics fontMetrics = this.f1597.getFontMetrics();
        float f28 = fontMetrics.bottom;
        float f29 = f28 - fontMetrics.top;
        float f30 = (f11 + this.f1579) - this.f1591;
        if (z) {
            float f31 = this.f1580;
            f7 = (((f - f31) + ((f31 / 2.0f) - (f29 / 2.0f))) + f29) - f28;
        } else {
            f7 = ((f2 + ((this.f1580 / 2.0f) - (f29 / 2.0f))) + f29) - f28;
        }
        canvas.drawText(str2, f30, f7, this.f1597);
    }
}
