package defpackage;

import android.graphics.Paint;
import android.text.style.LineHeightSpan;

/* compiled from: ExcludeInnerLineSpaceSpan.java */
/* renamed from: ۿ, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C3652 implements LineHeightSpan {

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final int f12669;

    public C3652(int i) {
        this.f12669 = i;
    }

    @Override // android.text.style.LineHeightSpan
    public void chooseHeight(CharSequence charSequence, int i, int i2, int i3, int i4, Paint.FontMetricsInt fontMetricsInt) {
        int i5 = fontMetricsInt.descent;
        if (i5 - fontMetricsInt.ascent <= 0) {
            return;
        }
        int iRound = Math.round(i5 * 1.0f);
        fontMetricsInt.descent = iRound;
        fontMetricsInt.ascent = iRound - this.f12669;
    }
}
