package com.blink.academy.film.widgets;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ProgressBar;

@SuppressLint({"ViewConstructor"})
/* loaded from: classes.dex */
public class OneTakeProgressBar extends ProgressBar {
    public OneTakeProgressBar(Context context) {
        super(context);
        m2464();
    }

    /* renamed from: Ϳ, reason: contains not printable characters */
    public final void m2464() {
        setLayerType(1, null);
    }

    public OneTakeProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m2464();
    }

    public OneTakeProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2464();
    }
}
