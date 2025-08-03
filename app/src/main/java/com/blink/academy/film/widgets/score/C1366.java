package com.blink.academy.film.widgets.score;

import android.view.MotionEvent;
import io.jsonwebtoken.JwtParser;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* compiled from: RatingBarUtils.java */
/* renamed from: com.blink.academy.film.widgets.score.Ϳ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C1366 {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static DecimalFormat f3908;

    /* renamed from: Ϳ, reason: contains not printable characters */
    public static float m3906(PartialView partialView, float f, float f2) {
        return Float.parseFloat(m3907().format(((Integer) partialView.getTag()).intValue() - (1.0f - (Math.round(Float.parseFloat(r0.format((f2 - partialView.getLeft()) / partialView.getWidth())) / f) * f))));
    }

    /* renamed from: Ԩ, reason: contains not printable characters */
    public static DecimalFormat m3907() {
        if (f3908 == null) {
            DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.ENGLISH);
            decimalFormatSymbols.setDecimalSeparator(JwtParser.SEPARATOR_CHAR);
            f3908 = new DecimalFormat("#.##", decimalFormatSymbols);
        }
        return f3908;
    }

    /* renamed from: ԩ, reason: contains not printable characters */
    public static float m3908(float f, int i, float f2) {
        if (f < 0.0f) {
            f = 0.0f;
        }
        float f3 = i;
        if (f > f3) {
            f = f3;
        }
        return f % f2 != 0.0f ? f2 : f;
    }

    /* renamed from: Ԫ, reason: contains not printable characters */
    public static boolean m3909(float f, float f2, MotionEvent motionEvent) {
        if (motionEvent.getEventTime() - motionEvent.getDownTime() > 200.0f) {
            return false;
        }
        return Math.abs(f - motionEvent.getX()) <= 5.0f && Math.abs(f2 - motionEvent.getY()) <= 5.0f;
    }
}
