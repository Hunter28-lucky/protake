package com.blink.academy.film.widgets;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import defpackage.C3652;
import defpackage.C4792;

/* loaded from: classes.dex */
public class FilmTextView extends AppCompatTextView {
    public FilmTextView(Context context) {
        this(context, null);
    }

    public void setCustomText(CharSequence charSequence) {
        SpannableStringBuilder spannableStringBuilder;
        if (charSequence == null) {
            return;
        }
        int textSize = (int) getTextSize();
        if (charSequence instanceof SpannableStringBuilder) {
            spannableStringBuilder = (SpannableStringBuilder) charSequence;
            spannableStringBuilder.setSpan(new C3652(textSize), 0, charSequence.length(), 33);
        } else {
            spannableStringBuilder = new SpannableStringBuilder(charSequence);
            spannableStringBuilder.setSpan(new C3652(textSize), 0, charSequence.length(), 33);
        }
        setText(spannableStringBuilder);
        setLineSpacing(((textSize * 1.0f) / C4792.m14375().m14378()) * C4792.m14375().m14441(), 1.0f);
    }

    public FilmTextView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FilmTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
