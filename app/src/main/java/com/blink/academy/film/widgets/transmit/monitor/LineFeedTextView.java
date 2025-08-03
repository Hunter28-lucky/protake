package com.blink.academy.film.widgets.transmit.monitor;

import android.content.Context;
import android.util.AttributeSet;
import androidx.annotation.Nullable;
import com.blink.academy.film.widgets.FilmTextView;

/* loaded from: classes.dex */
public class LineFeedTextView extends FilmTextView {

    /* renamed from: ԫ, reason: contains not printable characters */
    public int f4359;

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.LineFeedTextView$Ϳ, reason: contains not printable characters */
    public class RunnableC1643 implements Runnable {
        public RunnableC1643() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LineFeedTextView lineFeedTextView = LineFeedTextView.this;
            lineFeedTextView.f4359 = lineFeedTextView.getLineCount();
            if (LineFeedTextView.this.getLineCount() == 1) {
                LineFeedTextView.this.setGravity(17);
            } else {
                LineFeedTextView.this.setGravity(19);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.transmit.monitor.LineFeedTextView$Ԩ, reason: contains not printable characters */
    public class RunnableC1644 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f4361;

        public RunnableC1644(int i) {
            this.f4361 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            LineFeedTextView lineFeedTextView = LineFeedTextView.this;
            lineFeedTextView.f4359 = lineFeedTextView.getLineCount();
            if (LineFeedTextView.this.f4359 == 0) {
                if (LineFeedTextView.this.getPaint().measureText(LineFeedTextView.this.getText().toString()) > this.f4361) {
                    LineFeedTextView.this.f4359 = 2;
                } else {
                    LineFeedTextView.this.f4359 = 1;
                }
            }
            if (LineFeedTextView.this.f4359 > 1) {
                LineFeedTextView.this.setGravity(19);
            } else {
                LineFeedTextView.this.setGravity(17);
            }
        }
    }

    public LineFeedTextView(Context context) {
        super(context);
    }

    public int getCurrentLineCount() {
        return this.f4359;
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        post(new RunnableC1644(i));
    }

    public void setText(String str) {
        super.setCustomText(str);
        post(new RunnableC1643());
    }

    public LineFeedTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LineFeedTextView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
