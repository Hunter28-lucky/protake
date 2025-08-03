package com.blink.academy.film.widgets;

import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.blink.academy.protake.R;
import defpackage.AbstractC2574;
import defpackage.C4638;
import defpackage.r1;
import java.util.List;

/* loaded from: classes.dex */
public class FilmStopView extends RelativeLayout {

    /* renamed from: ԫ, reason: contains not printable characters */
    public boolean f2198;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public AbstractC2574 f2199;

    /* renamed from: ԭ, reason: contains not printable characters */
    public float f2200;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f2201;

    /* renamed from: ԯ, reason: contains not printable characters */
    public float f2202;

    /* renamed from: ՠ, reason: contains not printable characters */
    public List<String> f2203;

    /* renamed from: ֈ, reason: contains not printable characters */
    public InterfaceC0908 f2204;

    /* renamed from: com.blink.academy.film.widgets.FilmStopView$Ϳ, reason: contains not printable characters */
    public class ViewOnClickListenerC0898 implements View.OnClickListener {
        public ViewOnClickListenerC0898() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C4638.m14099("slim", "next:" + FilmStopView.this.f2199.f9580.isEnabled() + " pre:" + FilmStopView.this.f2199.f9581.isEnabled());
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FilmStopView$Ԩ, reason: contains not printable characters */
    public class ViewOnClickListenerC0899 implements View.OnClickListener {
        public ViewOnClickListenerC0899() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((FilmStopView.this.f2204 == null || FilmStopView.this.f2204.mo2147()) && r1.m8144(FilmStopView.this.f2203)) {
                if (((int) FilmStopView.this.f2200) == FilmStopView.this.f2200) {
                    FilmStopView.m2312(FilmStopView.this);
                } else {
                    FilmStopView.this.f2200 = ((int) r3.f2200) + 1;
                }
                if (FilmStopView.this.f2200 >= FilmStopView.this.f2203.size() - 1) {
                    FilmStopView filmStopView = FilmStopView.this;
                    filmStopView.m2325(filmStopView.f2199.f9578);
                    FilmStopView filmStopView2 = FilmStopView.this;
                    filmStopView2.m2325(filmStopView2.f2199.f9580);
                } else {
                    FilmStopView filmStopView3 = FilmStopView.this;
                    filmStopView3.m2319(filmStopView3.f2199.f9578);
                    FilmStopView filmStopView4 = FilmStopView.this;
                    filmStopView4.m2319(filmStopView4.f2199.f9580);
                }
                FilmStopView filmStopView5 = FilmStopView.this;
                filmStopView5.m2319(filmStopView5.f2199.f9579);
                FilmStopView filmStopView6 = FilmStopView.this;
                filmStopView6.m2319(filmStopView6.f2199.f9581);
                FilmStopView filmStopView7 = FilmStopView.this;
                filmStopView7.f2199.f9582.m2561((CharSequence) filmStopView7.f2203.get((int) FilmStopView.this.f2200));
                if (FilmStopView.this.f2204 != null) {
                    FilmStopView.this.f2204.mo2148((int) FilmStopView.this.f2200);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FilmStopView$Ԫ, reason: contains not printable characters */
    public class ViewOnClickListenerC0900 implements View.OnClickListener {
        public ViewOnClickListenerC0900() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if ((FilmStopView.this.f2204 == null || FilmStopView.this.f2204.mo2147()) && r1.m8144(FilmStopView.this.f2203)) {
                if (((int) FilmStopView.this.f2200) == FilmStopView.this.f2200) {
                    FilmStopView.m2313(FilmStopView.this);
                } else {
                    FilmStopView.this.f2200 = (int) r3.f2200;
                }
                if (FilmStopView.this.f2200 == 0.0f) {
                    FilmStopView filmStopView = FilmStopView.this;
                    filmStopView.m2325(filmStopView.f2199.f9579);
                    FilmStopView filmStopView2 = FilmStopView.this;
                    filmStopView2.m2325(filmStopView2.f2199.f9581);
                } else {
                    FilmStopView filmStopView3 = FilmStopView.this;
                    filmStopView3.m2319(filmStopView3.f2199.f9579);
                    FilmStopView filmStopView4 = FilmStopView.this;
                    filmStopView4.m2319(filmStopView4.f2199.f9581);
                }
                FilmStopView filmStopView5 = FilmStopView.this;
                filmStopView5.f2199.f9582.m2561((CharSequence) filmStopView5.f2203.get((int) FilmStopView.this.f2200));
                if (FilmStopView.this.f2200 < FilmStopView.this.f2203.size() - 1) {
                    FilmStopView filmStopView6 = FilmStopView.this;
                    filmStopView6.m2319(filmStopView6.f2199.f9578);
                    FilmStopView filmStopView7 = FilmStopView.this;
                    filmStopView7.m2319(filmStopView7.f2199.f9580);
                }
                if (FilmStopView.this.f2204 != null) {
                    FilmStopView.this.f2204.mo2148((int) FilmStopView.this.f2200);
                }
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FilmStopView$Ԭ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0901 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.widgets.FilmStopView$Ԭ$Ϳ, reason: contains not printable characters */
        public class RunnableC0902 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f2209;

            public RunnableC0902(View view) {
                this.f2209 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f2209.isEnabled()) {
                    FilmStopView.this.f2199.f9579.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0901() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                FilmStopView.this.f2199.f9579.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0902(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FilmStopView$Ԯ, reason: contains not printable characters */
    public class ViewOnTouchListenerC0903 implements View.OnTouchListener {

        /* renamed from: com.blink.academy.film.widgets.FilmStopView$Ԯ$Ϳ, reason: contains not printable characters */
        public class RunnableC0904 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f2212;

            public RunnableC0904(View view) {
                this.f2212 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f2212.isEnabled()) {
                    FilmStopView.this.f2199.f9578.setAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC0903() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                FilmStopView.this.f2199.f9578.setAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC0904(view), 100L);
            return false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FilmStopView$ՠ, reason: contains not printable characters */
    public class RunnableC0905 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f2214;

        public RunnableC0905(int i) {
            this.f2214 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) FilmStopView.this.f2199.f9578.getLayoutParams();
            int i = this.f2214;
            layoutParams.height = i;
            layoutParams.width = i;
            FilmStopView.this.f2199.f9578.setLayoutParams(layoutParams);
            FilmStopView.this.f2199.f9578.setImageResource(R.drawable.icon_34_arrow_right);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FilmStopView$ֈ, reason: contains not printable characters */
    public class RunnableC0906 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f2216;

        public RunnableC0906(int i) {
            this.f2216 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) FilmStopView.this.f2199.f9579.getLayoutParams();
            int i = this.f2216;
            layoutParams.height = i;
            layoutParams.width = i;
            FilmStopView.this.f2199.f9579.setLayoutParams(layoutParams);
            FilmStopView.this.f2199.f9579.setImageResource(R.drawable.icon_34_arrow_left);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FilmStopView$֏, reason: contains not printable characters */
    public class RunnableC0907 implements Runnable {

        /* renamed from: ԫ, reason: contains not printable characters */
        public final /* synthetic */ int f2218;

        public RunnableC0907(int i) {
            this.f2218 = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewGroup.LayoutParams layoutParams = FilmStopView.this.f2199.f9582.getLayoutParams();
            layoutParams.height = this.f2218;
            FilmStopView.this.f2199.f9582.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: com.blink.academy.film.widgets.FilmStopView$ׯ, reason: contains not printable characters */
    public interface InterfaceC0908 {
        /* renamed from: Ϳ */
        boolean mo2147();

        /* renamed from: Ԩ */
        void mo2148(int i);
    }

    public FilmStopView(Context context) {
        this(context, null);
    }

    /* renamed from: ԫ, reason: contains not printable characters */
    public static /* synthetic */ float m2312(FilmStopView filmStopView) {
        float f = filmStopView.f2200;
        filmStopView.f2200 = 1.0f + f;
        return f;
    }

    /* renamed from: Ԭ, reason: contains not printable characters */
    public static /* synthetic */ float m2313(FilmStopView filmStopView) {
        float f = filmStopView.f2200;
        filmStopView.f2200 = f - 1.0f;
        return f;
    }

    public int getTextHeight() {
        Paint.FontMetrics fontMetrics = this.f2199.f9582.getPaint().getFontMetrics();
        return (int) (fontMetrics.bottom - fontMetrics.top);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f2198) {
            C4638.m14099("FPSSettingView", String.format("w : %s , h : %s , oldW : %s , oldH : %s ", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)));
        }
        this.f2199.f9578.post(new RunnableC0905(i2));
        this.f2199.f9579.post(new RunnableC0906(i2));
        this.f2199.f9582.post(new RunnableC0907(i2));
    }

    public void setCenterTextViewWidth(int i) {
        ViewGroup.LayoutParams layoutParams = this.f2199.f9582.getLayoutParams();
        layoutParams.width = i;
        this.f2199.f9582.setLayoutParams(layoutParams);
    }

    public void setCurrentI(int i) {
        this.f2200 = i;
        m2320();
        m2321();
        this.f2199.f9582.m2561(this.f2203.get(i));
    }

    public void setOnStopClick(InterfaceC0908 interfaceC0908) {
        this.f2204 = interfaceC0908;
    }

    public void setStringDataList(List<String> list) {
        this.f2203 = list;
    }

    public void setTextColor(int i) {
        this.f2199.f9582.setContentTextColor(i);
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m2316() {
        this.f2199.f9582.setDrawBorder(false);
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final void m2317(View view) {
        view.setEnabled(false);
        view.setAlpha(this.f2201);
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public void m2318() {
        m2317(this.f2199.f9582);
        m2317(this.f2199.f9578);
        m2317(this.f2199.f9579);
        m2317(this.f2199.f9581);
        m2317(this.f2199.f9580);
    }

    /* renamed from: ֏, reason: contains not printable characters */
    public final void m2319(View view) {
        view.setEnabled(true);
        view.setAlpha(1.0f);
    }

    /* renamed from: ׯ, reason: contains not printable characters */
    public void m2320() {
        m2319(this.f2199.f9582);
        m2319(this.f2199.f9578);
        m2319(this.f2199.f9579);
        m2319(this.f2199.f9581);
        m2319(this.f2199.f9580);
        float f = this.f2200;
        if (f == 0.0f) {
            m2325(this.f2199.f9579);
            m2325(this.f2199.f9581);
        } else if (f >= this.f2203.size() - 1) {
            m2325(this.f2199.f9578);
            m2325(this.f2199.f9580);
        }
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public final void m2321() {
        List<String> list = this.f2203;
        if (list == null || list.size() <= 0) {
            return;
        }
        TextPaint paint = this.f2199.f9582.getPaint();
        int iMax = 0;
        for (String str : this.f2203) {
            float fMeasureText = paint.measureText(str);
            if (this.f2198) {
                C4638.m14099("FPSSettingView", String.format("measureText : %s , maxWidth : %s ", str, Float.valueOf(fMeasureText)));
            }
            iMax = Math.max(iMax, (int) (fMeasureText + 10.0f));
        }
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m2322() {
        this.f2199 = AbstractC2574.m9429(LayoutInflater.from(getContext()), this, true);
        m2323();
        m2324();
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m2323() {
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m2324() {
        this.f2199.f9582.setOnClickListener(new ViewOnClickListenerC0898());
        this.f2199.f9580.setOnClickListener(new ViewOnClickListenerC0899());
        this.f2199.f9581.setOnClickListener(new ViewOnClickListenerC0900());
        this.f2199.f9581.setOnTouchListener(new ViewOnTouchListenerC0901());
        this.f2199.f9580.setOnTouchListener(new ViewOnTouchListenerC0903());
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public final void m2325(View view) {
        view.setEnabled(false);
        view.setAlpha(this.f2202);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m2326(float f, boolean z, String str) {
        this.f2200 = f;
        m2320();
        m2321();
        if (!z && r1.m8143(str)) {
            this.f2199.f9582.m2561(str);
        }
    }

    /* renamed from: ޅ, reason: contains not printable characters */
    public void m2327(int i, float f) {
        this.f2199.f9582.m2562(i, f);
    }

    public FilmStopView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FilmStopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2198 = false;
        this.f2201 = 0.2f;
        this.f2202 = 0.2f;
        m2322();
    }
}
