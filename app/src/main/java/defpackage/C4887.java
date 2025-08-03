package defpackage;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

/* compiled from: LinkSpan.java */
/* renamed from: ด, reason: contains not printable characters */
/* loaded from: classes.dex */
public class C4887 extends ClickableSpan {

    /* renamed from: ԫ, reason: contains not printable characters */
    public View.OnClickListener f16513;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public int f16514 = ViewCompat.MEASURED_STATE_MASK;

    public C4887(View.OnClickListener onClickListener) {
        this.f16513 = onClickListener;
    }

    @Override // android.text.style.ClickableSpan
    public void onClick(View view) {
        if (r1.m8142(this.f16513)) {
            this.f16513.onClick(view);
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(@NonNull TextPaint textPaint) {
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f16514);
        textPaint.setFlags(1);
        textPaint.setFlags(1 | textPaint.getFlags() | 128);
        textPaint.setUnderlineText(false);
    }
}
