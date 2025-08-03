package com.blink.academy.film.widgets.dialog;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.blink.academy.film.FilmApp;
import com.blink.academy.film.widgets.FilmTextView;
import com.blink.academy.film.widgets.RoundButton;
import com.blink.academy.film.widgets.score.BaseRatingBar;
import com.blink.academy.protake.R;
import defpackage.AbstractC3771;
import defpackage.AbstractC4012;
import defpackage.C2579;
import defpackage.C4008;
import defpackage.C4792;
import defpackage.ViewOnTouchListenerC3426;

/* loaded from: classes.dex */
public class ScoreDialog extends FrameLayout implements View.OnClickListener {

    /* renamed from: ԫ, reason: contains not printable characters */
    public AbstractC3771 f2904;

    /* renamed from: Ԭ, reason: contains not printable characters */
    public float f2905;

    /* renamed from: ԭ, reason: contains not printable characters */
    public int f2906;

    /* renamed from: Ԯ, reason: contains not printable characters */
    public float f2907;

    /* renamed from: ԯ, reason: contains not printable characters */
    public boolean f2908;

    /* renamed from: ՠ, reason: contains not printable characters */
    public InterfaceC1020 f2909;

    /* renamed from: com.blink.academy.film.widgets.dialog.ScoreDialog$Ϳ, reason: contains not printable characters */
    public class C1015 implements BaseRatingBar.InterfaceC1362 {
        public C1015() {
        }

        @Override // com.blink.academy.film.widgets.score.BaseRatingBar.InterfaceC1362
        /* renamed from: Ϳ, reason: contains not printable characters */
        public void mo2879(BaseRatingBar baseRatingBar, float f, boolean z) {
            if (f != 0.0f || ScoreDialog.this.f2907 == f) {
                return;
            }
            ScoreDialog.this.f2907 = f;
            ScoreDialog.this.f2904.f13012.setVisibility(8);
            C4008.m12877(ScoreDialog.this.f2904.f13012, 0.0f, 100, null);
            ScoreDialog.this.f2904.f13013.setVisibility(0);
            C4008.m12877(ScoreDialog.this.f2904.f13013, 1.0f, 100, null);
            ScoreDialog.this.f2904.f13015.setVisibility(8);
            C4008.m12877(ScoreDialog.this.f2904.f13015, 0.0f, 100, null);
            ScoreDialog.this.f2904.f13016.setVisibility(8);
            C4008.m12877(ScoreDialog.this.f2904.f13016, 0.0f, 100, null);
            ScoreDialog.this.f2904.f13014.setVisibility(8);
            C4008.m12877(ScoreDialog.this.f2904.f13014, 0.0f, 100, null);
            ScoreDialog.this.f2904.f13018.setTextColor(ScoreDialog.this.getResources().getColor(R.color.colorBlack, null));
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.ScoreDialog$Ԩ, reason: contains not printable characters */
    public class C1016 implements BaseRatingBar.InterfaceC1363 {

        /* renamed from: com.blink.academy.film.widgets.dialog.ScoreDialog$Ԩ$Ϳ, reason: contains not printable characters */
        public class RunnableC1017 implements Runnable {
            public RunnableC1017() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (ScoreDialog.this.f2904.f13017.getRating() <= 3.0f) {
                    ScoreDialog.this.m2868();
                    if (ScoreDialog.this.f2909 != null) {
                        ScoreDialog.this.f2909.cancel();
                    }
                }
            }
        }

        public C1016() {
        }

        @Override // com.blink.academy.film.widgets.score.BaseRatingBar.InterfaceC1363
        public void onUp() {
            float rating = ScoreDialog.this.f2904.f13017.getRating();
            if (ScoreDialog.this.f2907 != rating || rating == 0.0f) {
                ScoreDialog.this.f2907 = rating;
                if (rating <= 3.0f) {
                    ScoreDialog.this.f2904.f13017.postDelayed(new RunnableC1017(), 150L);
                    return;
                }
                ScoreDialog.this.f2904.f13012.setVisibility(0);
                ScoreDialog.this.f2904.f13012.setAlpha(0.0f);
                C4008.m12877(ScoreDialog.this.f2904.f13012, 1.0f, 100, null);
                ScoreDialog.this.f2904.f13013.setVisibility(8);
                C4008.m12877(ScoreDialog.this.f2904.f13013, 0.0f, 100, null);
                ScoreDialog.this.f2904.f13015.setVisibility(0);
                ScoreDialog.this.f2904.f13015.setAlpha(0.0f);
                C4008.m12877(ScoreDialog.this.f2904.f13015, 1.0f, 100, null);
                ScoreDialog.this.f2904.f13016.setVisibility(0);
                ScoreDialog.this.f2904.f13016.setAlpha(0.0f);
                ScoreDialog.this.f2904.f13014.setVisibility(0);
                C4008.m12877(ScoreDialog.this.f2904.f13014, 1.0f, 100, null);
                C4008.m12877(ScoreDialog.this.f2904.f13016, 1.0f, 100, null);
                ScoreDialog scoreDialog = ScoreDialog.this;
                scoreDialog.m2875(scoreDialog.getResources().getString(R.string.POPUP_MARKET_CONFRIM_GOOGLE));
                ScoreDialog scoreDialog2 = ScoreDialog.this;
                scoreDialog2.m2876(scoreDialog2.getResources().getString(R.string.POPUP_DESC_MARKET_SOCRE_GOOGLE));
                if (ScoreDialog.this.f2909 != null) {
                    ScoreDialog.this.f2909.mo1349(rating);
                }
                ScoreDialog.this.f2904.f13017.setIsIndicator(true);
            }
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.ScoreDialog$Ԫ, reason: contains not printable characters */
    public class C1018 extends AbstractC4012 {
        public C1018() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            ScoreDialog.this.m2874();
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.ScoreDialog$Ԭ, reason: contains not printable characters */
    public class C1019 extends AbstractC4012 {
        public C1019() {
        }

        @Override // defpackage.AbstractC4012, androidx.core.view.ViewPropertyAnimatorListener
        public void onAnimationEnd(View view) {
            super.onAnimationEnd(view);
            ScoreDialog.this.setVisibility(8);
            ScoreDialog.this.f2904.f13017.setRating(0.0f);
            ScoreDialog.this.f2908 = false;
        }
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.ScoreDialog$Ԯ, reason: contains not printable characters */
    public interface InterfaceC1020 {
        void cancel();

        /* renamed from: Ϳ */
        void mo1348(float f);

        /* renamed from: Ԩ */
        void mo1349(float f);

        /* renamed from: ԩ */
        void mo1350();

        /* renamed from: Ԫ */
        void mo1351();
    }

    /* renamed from: com.blink.academy.film.widgets.dialog.ScoreDialog$ՠ, reason: contains not printable characters */
    public static class ViewOnTouchListenerC1021 implements View.OnTouchListener {

        /* renamed from: ԫ, reason: contains not printable characters */
        public RoundButton f2915;

        /* renamed from: com.blink.academy.film.widgets.dialog.ScoreDialog$ՠ$Ϳ, reason: contains not printable characters */
        public class RunnableC1022 implements Runnable {

            /* renamed from: ԫ, reason: contains not printable characters */
            public final /* synthetic */ View f2916;

            public RunnableC1022(View view) {
                this.f2916 = view;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (this.f2916.isEnabled()) {
                    ViewOnTouchListenerC1021.this.f2915.setContentAlpha(1.0f);
                }
            }
        }

        public ViewOnTouchListenerC1021(RoundButton roundButton) {
            this.f2915 = roundButton;
        }

        @Override // android.view.View.OnTouchListener
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f2915.setContentAlpha(0.3f);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            new Handler().postDelayed(new RunnableC1022(view), 100L);
            return false;
        }
    }

    public ScoreDialog(@NonNull Context context) {
        super(context);
        m2871();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.root) {
            switch (id) {
                case R.id.dialog_confirm /* 2131296580 */:
                    if (this.f2909 != null) {
                        m2868();
                        float rating = this.f2904.f13017.getRating();
                        if (rating < 4.0f) {
                            this.f2909.mo1348(rating);
                            break;
                        } else {
                            this.f2909.mo1351();
                            break;
                        }
                    }
                    break;
                case R.id.dialog_dont_show /* 2131296581 */:
                    m2868();
                    InterfaceC1020 interfaceC1020 = this.f2909;
                    if (interfaceC1020 != null) {
                        interfaceC1020.mo1350();
                        break;
                    }
                    break;
            }
            return;
        }
        m2868();
        InterfaceC1020 interfaceC10202 = this.f2909;
        if (interfaceC10202 == null) {
            return;
        }
        interfaceC10202.cancel();
    }

    public void setOnChangeListener(InterfaceC1020 interfaceC1020) {
        this.f2909 = interfaceC1020;
    }

    /* renamed from: ԯ, reason: contains not printable characters */
    public void m2868() {
        C4008.m12876(this, 0.0f, 200, new C1019());
    }

    /* renamed from: ՠ, reason: contains not printable characters */
    public final String m2869(String str, String str2, boolean z) {
        String str3 = String.format(str, str2);
        return z ? str3.toUpperCase() : str3;
    }

    /* renamed from: ֈ, reason: contains not printable characters */
    public final int m2870(float f) {
        return C4792.m14375().m14477(f, this.f2905);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ֏, reason: contains not printable characters */
    public final void m2871() {
        AbstractC3771 abstractC3771M12074 = AbstractC3771.m12074(LayoutInflater.from(getContext()), this, true);
        this.f2904 = abstractC3771M12074;
        abstractC3771M12074.f13018.setTextSize(0, C4792.m14375().m14381());
        this.f2904.f13018.setTypeface(FilmApp.m403());
        this.f2904.f13018.setText(m2869(getResources().getString(R.string.POPUP_TITLE_MARKET_SCORE), getResources().getString(R.string.app_name), false));
        this.f2904.f13015.setTextSize(0, C4792.m14375().m14381());
        this.f2904.f13015.setTypeface(FilmApp.m403());
        this.f2904.f13015.setText(getResources().getString(R.string.POPUP_MARKET_CONFRIM_GOOGLE));
        this.f2904.f13013.setTextSize(0, C4792.m14375().m14381());
        this.f2904.f13013.setTypeface(FilmApp.m403());
        this.f2904.f13013.setText(getResources().getString(R.string.POPUP_MARKET_DONT_SHOW));
        this.f2904.f13014.setTextSize(0, C4792.m14375().m14381());
        this.f2904.f13014.setTypeface(FilmApp.m403());
        this.f2904.f13014.setText(getResources().getString(R.string.POPUP_MARKET_CANCEL));
        this.f2904.f13013.setOnClickListener(this);
        this.f2904.f13014.setOnClickListener(this);
        this.f2904.f13012.setOnClickListener(this);
        this.f2904.f13020.setOnClickListener(this);
        this.f2904.f13017.setOnRatingChangeListener(new C1015());
        this.f2904.f13017.setNumStars(5);
        this.f2904.f13017.setStepSize(1.0f);
        this.f2904.f13017.setClearRatingEnabled(false);
        this.f2904.f13017.setOnTouchListener(new C1016());
        this.f2904.f13019.setOnClickListener(this);
        m2875(getResources().getString(R.string.POPUP_MARKET_CONFRIM_GOOGLE));
        m2872(C4792.m14375().m14498());
    }

    @SuppressLint({"ClickableViewAccessibility"})
    /* renamed from: ׯ, reason: contains not printable characters */
    public final void m2872(boolean z) {
        this.f2905 = 1.0f;
        ViewGroup.LayoutParams layoutParams = this.f2904.f13020.getLayoutParams();
        this.f2906 = C4792.m14375().m14438();
        if (z) {
            this.f2906 = C2579.f9598 - C2579.m9438(50.0f);
        }
        layoutParams.width = this.f2906;
        this.f2904.f13020.setLayoutParams(layoutParams);
        this.f2904.f13020.setBackgroundResource(R.drawable.shape_bg_white_round);
        int iM2870 = m2870(58.0f);
        int iM28702 = m2870(70.0f);
        int iM28703 = m2870(140.0f);
        int iM28704 = m2870(20.0f);
        this.f2904.f13017.setPadding(iM28704, iM28704, iM28704, iM28704);
        int i = iM2870 - iM28704;
        this.f2904.f13018.setPadding(iM2870, iM2870, iM2870, i);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f2904.f13016.getLayoutParams();
        layoutParams2.height = m2870(2.0f);
        layoutParams2.topMargin = i;
        this.f2904.f13016.setLayoutParams(layoutParams2);
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.f2904.f13015.getLayoutParams();
        layoutParams3.leftMargin = iM28703;
        layoutParams3.rightMargin = iM28703;
        layoutParams3.topMargin = iM2870;
        this.f2904.f13015.setLayoutParams(layoutParams3);
        m2875(getResources().getString(R.string.POPUP_MARKET_CONFRIM_GOOGLE));
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f2904.f13014.getLayoutParams();
        layoutParams4.height = C2579.m9438(44.0f);
        this.f2904.f13014.setLayoutParams(layoutParams4);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f2904.f13013.getLayoutParams();
        layoutParams5.height = C2579.m9438(44.0f);
        Paint.FontMetrics fontMetrics = this.f2904.f13013.getPaint().getFontMetrics();
        layoutParams5.topMargin = (int) (((layoutParams5.height - (fontMetrics.bottom - fontMetrics.top)) / 2.0f) - iM28704);
        this.f2904.f13013.setLayoutParams(layoutParams5);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) this.f2904.f13012.getLayoutParams();
        TextPaint textPaint = new TextPaint();
        textPaint.setTextSize(C4792.m14375().m14381() * this.f2905);
        textPaint.setTypeface(FilmApp.m403());
        layoutParams6.width = this.f2906 - (iM28702 * 2);
        Paint.FontMetrics fontMetrics2 = textPaint.getFontMetrics();
        layoutParams6.height = (int) ((fontMetrics2.bottom - fontMetrics2.top) + C4792.m14375().m14476(90));
        layoutParams6.topMargin = iM2870;
        this.f2904.f13012.setLayoutParams(layoutParams6);
        RoundButton roundButton = this.f2904.f13012;
        roundButton.setOnTouchListener(new ViewOnTouchListenerC1021(roundButton));
        FilmTextView filmTextView = this.f2904.f13014;
        filmTextView.setOnTouchListener(new ViewOnTouchListenerC3426(filmTextView));
        FilmTextView filmTextView2 = this.f2904.f13013;
        filmTextView2.setOnTouchListener(new ViewOnTouchListenerC3426(filmTextView2));
    }

    /* renamed from: ؠ, reason: contains not printable characters */
    public boolean m2873() {
        return this.f2908;
    }

    /* renamed from: ހ, reason: contains not printable characters */
    public final void m2874() {
        this.f2904.f13017.setIsIndicator(false);
        this.f2904.f13017.setRating(0.0f);
    }

    /* renamed from: ށ, reason: contains not printable characters */
    public final void m2875(String str) {
        this.f2904.f13012.m2540(C4792.m14375().m14490()).m2542(m2870(10.0f)).m2543(C4792.m14375().m14490()).m2539(0, C4792.m14375().m14381() * this.f2905).m2538(getResources().getColor(R.color.colorBlack, null)).m2537(str).m2544(FilmApp.m403()).m2535().m2534();
    }

    /* renamed from: ނ, reason: contains not printable characters */
    public final void m2876(String str) {
        this.f2904.f13015.setText(str);
    }

    /* renamed from: ރ, reason: contains not printable characters */
    public void m2877(boolean z) {
        m2872(z);
    }

    /* renamed from: ބ, reason: contains not printable characters */
    public void m2878() {
        this.f2908 = true;
        C4008.m12876(this, 1.0f, 200, new C1018());
    }

    public ScoreDialog(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m2871();
    }

    public ScoreDialog(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m2871();
    }
}
