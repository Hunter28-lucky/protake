package com.blink.academy.film.widgets.iso;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.blink.academy.film.FilmApp;
import defpackage.C4792;
import defpackage.r1;

/* loaded from: classes.dex */
public class ZoomButtonView extends View {

    /* renamed from: ބ, reason: contains not printable characters */
    public static final int f3580 = C4792.m14375().m14378();

    /* renamed from: ޅ, reason: contains not printable characters */
    public static final int f3581 = C4792.m14375().m14377();

    /* renamed from: ކ, reason: contains not printable characters */
    public static final int f3582 = C4792.m14375().m14377();

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f3583;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f3584;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f3585;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public Paint f3586;

    /* renamed from: ԯ, reason: contains not printable characters */
    public Paint f3587;

    /* renamed from: ՠ, reason: contains not printable characters */
    public Paint f3588;

    /* renamed from: ֈ, reason: contains not printable characters */
    public Paint f3589;

    /* renamed from: ֏, reason: contains not printable characters */
    public Paint f3590;

    /* renamed from: ׯ, reason: contains not printable characters */
    public Paint f3591;

    /* renamed from: ؠ, reason: contains not printable characters */
    public Paint f3592;

    /* renamed from: ހ, reason: contains not printable characters */
    public float f3593;

    /* renamed from: ށ, reason: contains not printable characters */
    public float f3594;

    /* renamed from: ނ, reason: contains not printable characters */
    public String f3595;

    /* renamed from: ރ, reason: contains not printable characters */
    public Rect f3596;

    public ZoomButtonView(Context context) {
        this(context, null);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f3583) {
            int i = this.f3584;
            canvas.drawCircle(i / 2.0f, this.f3585 / 2.0f, (i - this.f3593) / 2.0f, this.f3587);
            int i2 = this.f3584;
            canvas.drawCircle(i2 / 2.0f, this.f3585 / 2.0f, ((i2 / 2.0f) - this.f3593) - (this.f3594 / 2.0f), this.f3588);
            int i3 = this.f3584;
            float f = this.f3593;
            canvas.drawCircle(i3 / 2.0f, this.f3585 / 2.0f, (((i3 / 2.0f) - f) - this.f3594) - (f / 2.0f), this.f3587);
            float f2 = (((int) (this.f3585 - this.f3591.getFontMetrics().ascent)) >> 1) - 3;
            float fM3526 = (this.f3584 - m3526(this.f3591, this.f3595)) >> 1;
            canvas.drawText(this.f3595, fM3526, f2, this.f3592);
            canvas.drawText(this.f3595, fM3526, f2, this.f3591);
            return;
        }
        int i4 = this.f3584;
        canvas.drawCircle(i4 / 2.0f, this.f3585 / 2.0f, (i4 / 2.0f) - this.f3593, this.f3586);
        int i5 = this.f3584;
        canvas.drawCircle(i5 / 2.0f, this.f3585 / 2.0f, (i5 / 2.0f) - this.f3593, this.f3587);
        Paint.FontMetrics fontMetrics = this.f3589.getFontMetrics();
        if (r1.m8143(this.f3595)) {
            float f3 = ((int) (this.f3585 - fontMetrics.ascent)) >> 1;
            if (!this.f3595.contains("×")) {
                canvas.drawText(this.f3595, (this.f3584 - m3526(this.f3589, this.f3595)) >> 1, f3, this.f3589);
                return;
            }
            String[] strArrSplit = this.f3595.split("×");
            float fM35262 = m3526(this.f3589, strArrSplit[0]);
            float fM35263 = ((this.f3584 - (m3526(this.f3590, "×") + fM35262)) * 1.0f) / 2.0f;
            canvas.drawText("×", fM35262 + fM35263, ((int) (this.f3585 - this.f3590.getFontMetrics().ascent)) >> 1, this.f3590);
            canvas.drawText(strArrSplit[0], fM35263, f3, this.f3589);
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f3584 == 0 && this.f3585 == 0) {
            this.f3584 = i;
            this.f3585 = i2;
        }
    }

    public void setSelect(boolean z) {
        this.f3583 = z;
    }

    public void setText(String str) {
        this.f3595 = str;
        invalidate();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int m3526(Paint paint, String str) {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        int length = str.length();
        paint.getTextWidths(str, new float[length]);
        int iCeil = 0;
        for (int i = 0; i < length; i++) {
            iCeil += (int) Math.ceil(r2[i]);
        }
        return iCeil;
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public final void m3527() {
        float fM14434 = C4792.m14375().m14434();
        this.f3593 = C4792.m14375().m14476(3) * fM14434;
        this.f3594 = C4792.m14375().m14476(4) * fM14434;
        Paint paint = new Paint(1);
        this.f3586 = paint;
        paint.setColor(-1);
        Paint paint2 = new Paint(1);
        this.f3587 = paint2;
        paint2.setStrokeWidth(this.f3593);
        this.f3587.setStyle(Paint.Style.STROKE);
        this.f3587.setColor(ViewCompat.MEASURED_STATE_MASK);
        Paint paint3 = new Paint(1);
        this.f3588 = paint3;
        paint3.setStrokeWidth(this.f3594);
        this.f3588.setStyle(Paint.Style.STROKE);
        this.f3588.setColor(-1);
        Paint paint4 = new Paint(1);
        this.f3589 = paint4;
        paint4.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f3589.setTypeface(FilmApp.m404());
        this.f3589.setTextSize(f3580 * fM14434);
        Paint paint5 = new Paint(1);
        this.f3590 = paint5;
        paint5.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f3590.setTypeface(FilmApp.m404());
        this.f3590.setTextSize(f3581);
        Paint paint6 = new Paint(1);
        this.f3591 = paint6;
        paint6.setColor(-1);
        this.f3591.setTypeface(FilmApp.m404());
        Paint paint7 = this.f3591;
        int i = f3582;
        paint7.setTextSize(i * fM14434);
        Paint paint8 = new Paint(1);
        this.f3592 = paint8;
        paint8.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f3592.setStyle(Paint.Style.STROKE);
        this.f3592.setStrokeJoin(Paint.Join.ROUND);
        this.f3592.setStrokeCap(Paint.Cap.ROUND);
        this.f3592.setStrokeWidth(C4792.f16138);
        this.f3592.setTypeface(FilmApp.m404());
        this.f3592.setTextSize(i * fM14434);
    }

    public ZoomButtonView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ZoomButtonView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3596 = new Rect();
        m3527();
    }
}
