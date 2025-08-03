package com.blink.academy.film.widgets;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.blink.academy.film.FilmApp;

/* loaded from: classes.dex */
public class RobotoCondensedTextView extends AppCompatTextView {
    public RobotoCondensedTextView(Context context) {
        this(context, null);
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2531(Context context, AttributeSet attributeSet, int i) {
        setTypeface(FilmApp.m404());
        getPaint().setFakeBoldText(true);
    }

    public RobotoCondensedTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RobotoCondensedTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2531(context, attributeSet, i);
    }
}
